package com.nukateam.guns.common.foundation.item;

import com.nukateam.guns.client.handler.ReloadHandler;
import com.nukateam.guns.client.model.GeoGunModel;
import com.nukateam.nukacraft.common.data.interfaces.IResourceProvider;
import com.jetug.chassis_core.common.data.json.ItemConfig;
import com.jetug.chassis_core.common.foundation.item.IConfigProvider;
import mod.azure.azurelib.cache.AzureLibCache;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.util.Lazy;

import javax.annotation.Nullable;

import java.util.ArrayList;

import static com.jetug.chassis_core.common.util.extensions.Collection.arrayListOf;
import static com.nukateam.guns.client.handler.ShootingHandler.*;
import static com.nukateam.guns.client.render.renderers.GunRendererDynamic.*;
import static com.nukateam.guns.common.base.gun.GripType.ONE_HANDED;
import static com.nukateam.guns.common.foundation.item.GunItem.*;
import static com.nukateam.nukacraft.common.data.constants.Animations.*;
import static com.jetug.chassis_core.client.ClientConfig.*;
import static mod.azure.azurelib.core.animation.AnimatableManager.*;
import static mod.azure.azurelib.core.animation.Animation.LoopType.*;
import static mod.azure.azurelib.core.animation.RawAnimation.*;
import static net.minecraft.client.renderer.block.model.ItemTransforms.*;

public class AnimatedGunItem extends GunItemBase implements IResourceProvider, IConfigProvider {
    protected final TransformType transformType;
    private final Lazy<ItemConfig> config = Lazy.of(() -> modResourceManager.getItemConfig(getName()));
    private Minecraft minecraft = Minecraft.getInstance();

    public AnimatedGunItem(TransformType transformType) {
        this.transformType = transformType;
    }

    @Override
    public void registerControllers(ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller1", 0, animate()));
        controllerRegistrar.add(new AnimationController<>(this, "controller2", 0, holdAnimation()));
    }

    @Override
    public String getName() {
        return ((IResourceProvider)renderStack.getItem()).getName();
    }

    @Override
    public String getNamespace() {
        return ((IResourceProvider)renderStack.getItem()).getNamespace();
    }

    @Override
    @Nullable
    public ItemConfig getConfig() {
        return config.get();
    }

    private final ArrayList<TransformType> reloadTransforms = arrayListOf(
            TransformType.FIRST_PERSON_RIGHT_HAND,
            TransformType.FIRST_PERSON_LEFT_HAND,
            TransformType.THIRD_PERSON_RIGHT_HAND,
            TransformType.THIRD_PERSON_LEFT_HAND);

    private AnimationController.AnimationStateHandler<AnimatedGunItem> holdAnimation() {
        return event -> {
            var stack = renderStack;
            if(stack == null || stack.isEmpty()) return PlayState.STOP;

            var gun = (GunItem)stack.getItem();
            var grip = gun.getGun().getGeneral().getGripType();
            var reloadProgress = ReloadHandler.get().getReloadProgress(Minecraft.getInstance().getFrameTime());

            RawAnimation animation = null;

            if(ReloadHandler.get().isReloading(minecraft.player)){
                if(reloadTransforms.contains(transformType)) {
                    animation = begin().then("pistol_reload", HOLD_ON_LAST_FRAME);

                    var reloadDuration = gun.getModifiedGun(stack).getGeneral().getReloadTime();
                    var multiplier = (float) getSpeedMultiplier("pistol_reload", reloadDuration);

                    event.setControllerSpeed(multiplier);
                }
            }
            else if (grip == ONE_HANDED) {
                animation = begin().then("one_hand_hold", LOOP);
            }
//            else if(grip == TWO_HANDED){
//                animation = begin().then("two_hand_hold", LOOP);
//            }
            try {
                return event.setAndContinue(animation);
            }
            catch (Exception e){
                return PlayState.STOP;
            }
        };
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

        return animation.length();
    }

    private AnimationController.AnimationStateHandler<AnimatedGunItem> animate() {
        return event -> {
            try{
                var controller = event.getController();
                controller.setAnimationSpeed(1);
//                var stack = event.getData(DataTickets.ITEMSTACK);
//                var transformType = event.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
                var player = Minecraft.getInstance().player;
//                var playerHasNotStack = !player.getInventory().items.contains(stack);
//                var stack = event.getData(DataTickets.ITEMSTACK);
//                var transformType = event.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);

                var entity = (LivingEntity)event.getData(DataTickets.ENTITY);

                var stack = renderStack;

//                var entity = entityForStack.get(stack);
                if(entity == null) entity = player;

                if (bannedTransforms.contains(transformType) /*|| (entity != player && !(entity instanceof PowerArmorFrame))*/) {
                    return PlayState.STOP;
                }

//                float cooldown = ShootingHandler.get().getShootTickGapLeft(entity);
                float cooldown = getCooldown(stack);//tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
                float reloadProgress = ReloadHandler.get().getReloadProgress(Minecraft.getInstance().getFrameTime());

                RawAnimation animation;

//                if(reloadProgress > 0){
//                    animation = begin().then(RELOAD, LOOP);
//                }
////                Gun.hasAmmo(stack) &&
//                else
                if(cooldown > 0) {
                    animation = begin().then(SHOT, LOOP);
                }
                else{
                    return PlayState.STOP;
                }

                if (controller.hasAnimationFinished())
                    controller.forceAnimationReset();

                return event.setAndContinue(animation);
            }
            catch (Exception e){
                return PlayState.STOP;
            }
        };
    }
}
