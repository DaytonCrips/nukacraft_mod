package com.nukateam.nukacraft.common.foundation.blocks.plants;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;
import java.util.Map;

public class CranberryLeaves extends LeavesBlock {
    //protected static final VoxelShape BASE_AABB = Block.box(-0.1, 0.1, 0.1, 15.700000000000001, 15.9, 15.9);

    public CranberryLeaves(Properties pProperties) {
        super(pProperties);
    }

//    @Override
//    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
//        return BASE_AABB;
//    }
}
