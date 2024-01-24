package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class PipeBlock extends DirectionalBlock {

    protected static final VoxelShape Z = Block.box(5, 5, 0.01, 11, 11, 15.990000000000002);
    protected static final VoxelShape X = Block.box(0.00999999999999801, 5, 5.000000000000002, 15.99, 11, 11.000000000000002);
    protected static final VoxelShape Y = Block.box(5, 0.00999999999999801, 5.000000000000002, 11, 15.99, 11.000000000000002);
    public PipeBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.UP));
    }

    public VoxelShape getShape(BlockState p_154346_, BlockGetter p_154347_, BlockPos p_154348_, CollisionContext p_154349_) {
        switch (((Direction)p_154346_.getValue(FACING)).getAxis()) {
            case X:
            default:
                return X;
            case Z:
                return Z;
            case Y:
                return Y;
        }
    }

    public BlockState rotate(BlockState p_154354_, Rotation p_154355_) {
        return (BlockState)p_154354_.setValue(FACING, p_154355_.rotate((Direction)p_154354_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_154351_, Mirror p_154352_) {
        return (BlockState)p_154351_.setValue(FACING, p_154352_.mirror((Direction)p_154351_.getValue(FACING)));
    }

    public boolean isPathfindable(BlockState p_154341_, BlockGetter p_154342_, BlockPos p_154343_, PathComputationType p_154344_) {
        return false;
    }
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction $$1 = pContext.getClickedFace();
        BlockState $$2 = pContext.getLevel().getBlockState(pContext.getClickedPos().relative($$1.getOpposite()));
        return $$2.is(this) && $$2.getValue(FACING) == $$1 ? (BlockState)this.defaultBlockState().setValue(FACING, $$1.getOpposite()) : (BlockState)this.defaultBlockState().setValue(FACING, $$1);
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{FACING});
    }

    public PushReaction getPistonPushReaction(BlockState pState) {
        return PushReaction.NORMAL;
    }
}
