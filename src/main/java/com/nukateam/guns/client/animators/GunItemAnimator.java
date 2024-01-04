package com.nukateam.guns.client.animators;

import com.jetug.chassis_core.common.data.json.ItemConfig;
import com.jetug.chassis_core.common.foundation.item.IConfigProvider;
import com.nukateam.guns.client.handler.AimingHandler;
import com.nukateam.guns.client.handler.ReloadHandler;
import com.nukateam.guns.client.model.GeoGunModel;
import com.nukateam.guns.common.base.gun.Gun;
import com.nukateam.guns.common.foundation.item.GunItem;
import com.nukateam.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.cache.AzureLibCache;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.util.Lazy;

import javax.annotation.Nullable;
import java.util.ArrayList;

import static com.jetug.chassis_core.client.ClientConfig.modResourceManager;
import static com.jetug.chassis_core.common.util.extensions.Collection.arrayListOf;
import static com.nukateam.guns.client.handler.ShootingHandler.getCooldown;
import static com.nukateam.guns.client.render.Render.GUN_RENDERER;
import static com.nukateam.guns.common.foundation.item.GunItem.bannedTransforms;
import static com.nukateam.nukacraft.common.data.constants.Animations.SHOT;
import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.Animation.LoopType.*;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.*;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND;

public class GunItemAnimator extends ItemAnimator implements IResourceProvider, IConfigProvider {
    public static final String RELOAD = "reload";
    private final Lazy<ItemConfig> config = Lazy.of(() -> modResourceManager.getItemConfig(getName()));
    private final Minecraft minecraft = Minecraft.getInstance();

    public GunItemAnimator(TransformType transformType) {
        super(transformType);
    }

    @Override
    public void registerControllers(ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller1", 0, animate()));
        controllerRegistrar.add(new AnimationController<>(this, "controller2", 0, holdAnimation()));
    }

    @Override
    public String getName() {
        return ((IResourceProvider)GUN_RENDERER.getRenderStack().getItem()).getName();
    }

    @Override
    public String getNamespace() {
        return ((IResourceProvider)GUN_RENDERER.getRenderStack().getItem()).getNamespace();
    }

    @Override
    @Nullable
    public ItemConfig getConfig() {
        return config.get();
    }

    private final ArrayList<TransformType> reloadTransforms = arrayListOf(
            FIRST_PERSON_RIGHT_HAND,
            FIRST_PERSON_LEFT_HAND,
            THIRD_PERSON_RIGHT_HAND,
            THIRD_PERSON_LEFT_HAND);

    private boolean isFirstPerson(TransformType transformType){
        return transformType == FIRST_PERSON_RIGHT_HAND || transformType == FIRST_PERSON_LEFT_HAND;
    }

    private AnimationController.AnimationStateHandler<GunItemAnimator> holdAnimation() {
        return event -> {
            event.getController().setAnimationSpeed(1);
            var stack = GUN_RENDERER.getRenderStack();
            if(stack == null || stack.isEmpty()) return PlayState.STOP;

            var gun = (GunItem)stack.getItem();
            var general = gun.getModifiedGun(stack).getGeneral();
            var entity = GUN_RENDERER.getRenderEntity();

//            if(currentGun != gun){
//                currentGun = gun;
//                event.getController().stop();
//                return event.setAndContinue(begin().then(RELOAD, HOLD_ON_LAST_FRAME));
//            }

            RawAnimation animation = null;

            if(entity != null && ReloadHandler.get().isReloading(entity)){
                if(reloadTransforms.contains(transformType)) {
                    animation = begin().then(RELOAD, HOLD_ON_LAST_FRAME);
                    syncAnimation(event, RELOAD , general.getReloadTime());
                }
            }
            else if(isFirstPerson(transformType) && AimingHandler.get().isAiming()){
                animation = begin().then("aim", HOLD_ON_LAST_FRAME);
            }
            else {
                animation = begin().then("hold", LOOP);
            }
            try {
                return event.setAndContinue(animation);
            }
            catch (Exception e){
                return PlayState.STOP;
            }
        };
    }

    private GunItem currentGun = null;

    private AnimationController.AnimationStateHandler<GunItemAnimator> animate() {
        return event -> {
            try{

                var controller = event.getController();
                controller.setAnimationSpeed(1);
                var stack = GUN_RENDERER.getRenderStack();
                var gun = (GunItem)stack.getItem();
                var general = gun.getModifiedGun(stack).getGeneral();

//                if(currentGun != gun){
//                    currentGun = gun;
//                    event.getController().stop();
//                    return event.setAndContinue(begin().then(RELOAD, HOLD_ON_LAST_FRAME));
//                }

                if (bannedTransforms.contains(transformType) /*|| (entity != player && !(entity instanceof PowerArmorFrame))*/) {
                    return PlayState.STOP;
                }

                float cooldown = getCooldown(stack);
                RawAnimation animation;

                if(cooldown > 0) {
                    animation = begin().then(SHOT, LOOP);
                    syncAnimation(event, SHOT, general.getRate());
                }
                else if(!Gun.hasAmmo(stack)){
                    animation = begin().then("slide_off", LOOP);
                }
                else return PlayState.STOP;

                if (controller.hasAnimationFinished())
                    controller.forceAnimationReset();

                return event.setAndContinue(animation);
            }
            catch (Exception e){
                return PlayState.STOP;
            }
        };
    }

    private void syncAnimation(AnimationState<GunItemAnimator> event, String animationName, int reloadDuration) {
        var multiplier = (float) getSpeedMultiplier(animationName, reloadDuration);
        event.setControllerSpeed(multiplier);
    }

    private double getSpeedMultiplier(String animationName, double targetDuration){
        var duration = getAnimationDuration(animationName);
        return duration / targetDuration;
    }

    private double getAnimationDuration(String animationName){
        var map = AzureLibCache.getBakedAnimations();
        var animationResource = GeoGunModel.INSTANCE.getAnimationResource(this);
        var bakedAnimations = map.get(animationResource);
        var animation = bakedAnimations.animations().get(animationName);

        return animation != null ? animation.length() : 1;
    }
}
