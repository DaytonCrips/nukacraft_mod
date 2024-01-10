package com.nukateam.nukacraft.common.foundation.blocks.custom.blocks;

import com.nukateam.nukacraft.common.foundation.blocks.entity.GearDoorEntity;
import com.nukateam.nukacraft.common.foundation.entities.ModBlocksEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class GearDoorBlock extends BaseEntityBlock {
    public GearDoorBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new GearDoorEntity(ModBlocksEntity.GEARDOOR.get(), pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
}
