package com.nukateam.nukacraft.common.foundation.entities.blocks;

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
        controllerRegistrar.add(new AnimationController<>(this, "doorControl", 0, event -> {
            return event.setAndContinue(RawAnimation.begin().thenPlayAndHold("close"));
        }));
    }

    @Override
    public double getTick(Object blockEntity) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
