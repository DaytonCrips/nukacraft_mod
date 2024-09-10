package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class BlastDoorBlock extends DoorBlock {
    protected static final VoxelShape SOUTH_NORTH_AABB = Block.box(6, 0.01, 0.009999999999999787, 10, 15.99, 15.99);
    protected static final VoxelShape EAST_WEST_AABB = Block.box(0.009999999999999787, 0.01, 6, 15.99, 15.99, 10);

    protected static final VoxelShape SOUTH_NORTH_AABB_OPEN = Block.box(6, 13, 0.01, 10, 15.98, 15.99);
    protected static final VoxelShape EAST_WEST_AABB_OPEN = Block.box(0.009999999999999787, 13, 6, 15.99, 15.98, 10);
    protected static final VoxelShape EMPTY_AABB = Block.box(0, 0, 0, 0, 0, 0);

    public BlastDoorBlock(Properties pProperties) {
        super(pProperties, BlockSetType.OAK);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.valueOf(false)).setValue(HINGE, DoorHingeSide.LEFT).setValue(POWERED, Boolean.valueOf(false)).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        Direction direction = pState.getValue(FACING);
        DoubleBlockHalf half = pState.getValue(HALF);
        boolean open = !pState.getValue(OPEN);
        boolean halfs = half.toString().equals("upper");
        return switch (direction) {
            default ->
                    halfs ? (open ? SOUTH_NORTH_AABB : SOUTH_NORTH_AABB_OPEN) : (open ? SOUTH_NORTH_AABB : EMPTY_AABB);
            case SOUTH -> halfs ? (open ? EAST_WEST_AABB : EAST_WEST_AABB_OPEN) : (open ? EAST_WEST_AABB : EMPTY_AABB);
            case WEST ->
                    halfs ? (open ? SOUTH_NORTH_AABB : SOUTH_NORTH_AABB_OPEN) : (open ? SOUTH_NORTH_AABB : EMPTY_AABB);
            case NORTH -> halfs ? (open ? EAST_WEST_AABB : EAST_WEST_AABB_OPEN) : (open ? EAST_WEST_AABB : EMPTY_AABB);
        };
    }


    @Override
    public void setOpen(@Nullable Entity p_153166_, Level pLevel, BlockState pState, BlockPos pPos, boolean pOpen) {
        if (pState.is(this) && pState.getValue(OPEN) != pOpen) {
            pLevel.setBlock(pPos, pState.setValue(OPEN, Boolean.valueOf(pOpen)), 10);
            this.playSound(pLevel, pPos, pOpen);
            pLevel.gameEvent(p_153166_, pOpen ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);
        }
    }

    private int getCloseSound() {
        return 1011;
    }

    private int getOpenSound() {
        return 1005;
    }


    private void playSound(Level pLevel, BlockPos pPos, boolean pIsOpening) {
        pLevel.levelEvent((Player) null, pIsOpening ? this.getOpenSound() : this.getCloseSound(), pPos, 0);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }


}
