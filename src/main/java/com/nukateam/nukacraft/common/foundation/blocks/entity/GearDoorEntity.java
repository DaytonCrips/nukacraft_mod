package com.nukateam.nukacraft.common.foundation.blocks.entity;

import com.nukateam.guns.common.foundation.init.ModTileEntities;
import com.nukateam.nukacraft.common.foundation.entities.ModBlocksEntity;
import mod.azure.azurelib.animatable.GeoBlockEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class GearDoorEntity extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public GearDoorEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModTileEntities.GEARDOOR_ENTITY.get(), pPos, pBlockState);
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
