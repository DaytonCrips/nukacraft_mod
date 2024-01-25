package com.nukateam.nukacraft.common.foundation.blocks.entity;

import com.nukateam.nukacraft.common.registery.ModTileEntities;
import mod.azure.azurelib.animatable.GeoBlockEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.util.AzureLibUtil;
import mod.azure.azurelib.util.RenderUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GearDoorEntity extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);


    public GearDoorEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModTileEntities.GEARDOOR_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(new AnimationController<>(this, "doorControl", 0, animateGear()));
        controllerRegistrar.add(new AnimationController<>(this, "doorControl", 0, event ->
        {
            return event.setAndContinue( RawAnimation.begin().thenPlayAndHold("close"));
        }));
    }

    //public RawAnimation currentAnimation = null;
//    public void setState(boolean state) {
//        GearDoorEntity.state = state;
//    }

//    public boolean getState() {
//        return state;
//    }
//    public void changeState() {
//        this.getUpdateTag().putBoolean("state", !this.getUpdateTag().getBoolean("state"));
//    }
//    private AnimationController.AnimationStateHandler<GearDoorEntity> animateGear() {
//        var states = this.getUpdateTag().getBoolean("state");
//        return event -> {
//            var controller = event.getController();
//            controller.setAnimationSpeed(0.4);
//            RawAnimation animation = null;
//            if (states) {
//                animation = begin().thenPlayAndHold("open");
//            } else {
//                animation = begin().thenPlayAndHold("close");
//            }
//
//
////            if (passenger != null && !passengerHaveGun()) {
////                if (passenger.attackAnim > 0) {
////                    controller.setAnimationSpeed(2.0D);
////                    animation = begin().then(HIT, PLAY_ONCE);
////                } else if (hurtTime > 0) {
////                    animation = begin().then(HURT, PLAY_ONCE);
////                } else if (isWalking()) {
////                    controller.setAnimationSpeed(speedometer.getSpeed() * 4.0D);
////                    animation = begin().then(WALK_ARMS, LOOP);
////                } else animation = begin().then(IDLE, LOOP);
////            }
//
//            currentAnimation = animation;
//            return event.setAndContinue(animation);
//        };
//    }
    @Override
    public double getTick(Object blockEntity) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
