package com.nukateam.guns.client.animators;

import com.jetug.chassis_core.common.data.json.ItemConfig;
import com.jetug.chassis_core.common.foundation.item.IConfigProvider;
import com.nukateam.guns.client.audio.GunShotSound;
import com.nukateam.guns.client.data.handler.AimingHandler;
import com.nukateam.guns.client.data.handler.ClientReloadHandler;
import com.nukateam.guns.client.data.handler.ShootingHandler;
import com.nukateam.guns.client.model.GeoGunModel;
import com.nukateam.guns.common.foundation.item.GunItem;
import com.nukateam.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.cache.AzureLibCache;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;

import javax.annotation.Nullable;

import static com.jetug.chassis_core.client.ClientConfig.modResourceManager;
import static com.nukateam.guns.client.data.util.TransformUtils.isHandTransform;
import static com.nukateam.guns.client.data.util.TransformUtils.isRightHand;
import static com.nukateam.guns.client.render.Render.GUN_RENDERER;
import static com.nukateam.nukacraft.common.data.constants.Animations.*;
import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.Animation.LoopType.HOLD_ON_LAST_FRAME;
import static mod.azure.azurelib.core.animation.Animation.LoopType.LOOP;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND;

@OnlyIn(Dist.CLIENT)
public class GunItemAnimator extends ItemAnimator implements IResourceProvider, IConfigProvider {
    private final Lazy<ItemConfig> config = Lazy.of(() -> modResourceManager.getItemConfig(getName()));
    private final Minecraft minecraft = Minecraft.getInstance();
    private int chamberId = 1;
    private GunItem currentGun = null;

    public GunItemAnimator(TransformType transformType) {
        super(transformType);
    }

    private ItemStack getStack() {
        return GUN_RENDERER.getRenderStack();
    }

    private GunItem getGunItem() {
        return (GunItem) getStack().getItem();
    }


    @Override
    public void registerControllers(ControllerRegistrar controllerRegistrar) {
        var mainController = new AnimationController<>(this, "controller1", 0, animate())
                .setSoundKeyframeHandler((event) -> {
                    var player = minecraft.player;
                    if (player == null) return;
                    var sound = event.getKeyframeData().getSound();
                    var sounds = getGunItem().getGun().getSounds();

                    switch (sound) {
                        case "reload" -> {
                            var reloadSound = sounds.getReload();

                            minecraft.getSoundManager().play(new GunShotSound(reloadSound, SoundSource.PLAYERS,
                                    player.position(), 1, 1, true));
                        }
                        case "cock" -> {
                            var cockSound = sounds.getCock();

                            minecraft.getSoundManager().play(new GunShotSound(cockSound, SoundSource.PLAYERS,
                                    player.position(), 1, 1, true));
                        }
                    }
                });

        controllerRegistrar.add(mainController);
        controllerRegistrar.add(new AnimationController<>(this, "controller2", 0, holdAnimation()));
        controllerRegistrar.add(new AnimationController<>(this, "controller3", 0, animateRevolver()));
    }

    @Override
    public String getName() {
        return ((IResourceProvider) GUN_RENDERER.getRenderStack().getItem()).getName();
    }

    @Override
    public String getNamespace() {
        return ((IResourceProvider) GUN_RENDERER.getRenderStack().getItem()).getNamespace();
    }

    @Override
    @Nullable
    public ItemConfig getConfig() {
        return config.get();
    }

    private boolean isFirstPerson(TransformType transformType) {
        return transformType == FIRST_PERSON_RIGHT_HAND || transformType == FIRST_PERSON_LEFT_HAND;
    }

    private AnimationController.AnimationStateHandler<GunItemAnimator> holdAnimation() {
        return event -> {
            event.getController().setAnimationSpeed(1);
            var stack = GUN_RENDERER.getRenderStack();
            if (stack == null || stack.isEmpty()) return PlayState.STOP;

            RawAnimation animation = null;

            if (isFirstPerson(transformType) && AimingHandler.get().isAiming()) {
                animation = begin().then("aim", HOLD_ON_LAST_FRAME);
            } else {
                return PlayState.STOP;
            }
            try {
                return event.setAndContinue(animation);
            } catch (Exception e) {
                return PlayState.STOP;
            }
        };
    }

    private AnimationController.AnimationStateHandler<GunItemAnimator> animate() {
        return event -> {
            try {
                var controller = event.getController();
                controller.setAnimationSpeed(1);
                var stack = GUN_RENDERER.getRenderStack();
                var general = ((GunItem) stack.getItem()).getModifiedGun(stack).getGeneral();
                var entity = GUN_RENDERER.getRenderEntity();
                var reloadHandler = ClientReloadHandler.get();

                if (!isHandTransform(transformType))
                    return event.setAndContinue(begin().then(HOLD, LOOP));

                var arm = isRightHand(transformType) ? HumanoidArm.RIGHT : HumanoidArm.LEFT;
                var isShooting = ShootingHandler.get().isShooting(entity, arm);

                RawAnimation animation = null;

                if (reloadHandler.isReloading(entity, arm)) {
                    animation = begin().then(RELOAD, HOLD_ON_LAST_FRAME);
                    syncAnimation(event, RELOAD, general.getReloadTime());
                } else if (isShooting) {
                    animation = begin().then(SHOT, LOOP);
                    syncAnimation(event, SHOT, general.getRate());
                } else if (reloadHandler.isReloading(entity, arm.getOpposite())) {
                    animation = begin().then("hide", HOLD_ON_LAST_FRAME);
                } else {
                    if (currentGun == (GunItem) stack.getItem())
                        animation = begin().then(HOLD, LOOP);
                    else {
                        currentGun = (GunItem) stack.getItem();
                        animation = begin().then(SHOT, LOOP);
                    }
                }
//                else if(!Gun.hasAmmo(stack)){
//                    animation = begin().then("slide_off", LOOP);
//                }

                if (controller.hasAnimationFinished())
                    controller.forceAnimationReset();

                return event.setAndContinue(animation);
            } catch (Exception e) {
                return PlayState.STOP;
            }
        };
    }

    private AnimationController.AnimationStateHandler<GunItemAnimator> animateRevolver() {
        return event -> {
            var controller = event.getController();
            controller.setAnimationSpeed(1);
            var stack = GUN_RENDERER.getRenderStack();
            var general = ((GunItem) stack.getItem()).getModifiedGun(stack).getGeneral();
            var entity = GUN_RENDERER.getRenderEntity();

            if (!isHandTransform(transformType)) return PlayState.STOP;

            var arm = isRightHand(transformType) ? HumanoidArm.RIGHT : HumanoidArm.LEFT;
            var cooldown = ShootingHandler.get().getCooldownRight(entity, arm);
            var isShooting = ShootingHandler.get().isShooting(entity, arm);

            RawAnimation animation = null;

            if (cooldown == general.getRate()) {
                if (chamberId < 6)
                    chamberId++;
                else chamberId = 1;
            }

            if (isShooting) {
                var chamber = "chamber" + chamberId;
                animation = begin().then(chamber, HOLD_ON_LAST_FRAME);
                syncAnimation(event, chamber, general.getRate());
            }
            return event.setAndContinue(animation);

        };
    }

    private void syncAnimation(AnimationState<GunItemAnimator> event, String animationName, int reloadDuration) {
        var multiplier = (float) getSpeedMultiplier(animationName, reloadDuration);
        event.setControllerSpeed(multiplier);
    }

    private double getSpeedMultiplier(String animationName, double targetDuration) {
        var duration = getAnimationDuration(animationName);
        return duration / targetDuration;
    }

    private double getAnimationDuration(String animationName) {
        var map = AzureLibCache.getBakedAnimations();
        var animationResource = GeoGunModel.INSTANCE.getAnimationResource(this);
        var bakedAnimations = map.get(animationResource);
        var animation = bakedAnimations.animations().get(animationName);

        return animation != null ? animation.length() : 1;
    }
}
