package com.dayton.nukacraft.common.foundation.blocks.custom.blocks;

import com.dayton.nukacraft.common.data.utils.VoxelShapeHelper;
import com.dayton.nukacraft.common.foundation.entities.blocks.BasicStorageEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.*;

public class BasicStorageBlock extends BarrelBlock {
    private final Map<BlockState, VoxelShape> SHAPES = new HashMap<>();
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public BasicStorageBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OPEN, Boolean.valueOf(false)));
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof BasicStorageEntity) {
                pPlayer.openMenu((BasicStorageEntity)blockentity);
                pPlayer.awardStat(Stats.OPEN_BARREL);
            }

            return InteractionResult.CONSUME;
        }
    }
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof Container) {
                Containers.dropContents(pLevel, pPos, (Container)blockentity);
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof BasicStorageEntity) {
            ((BasicStorageEntity)blockentity).recheckOpen();
        }

    }
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BasicStorageEntity(pPos, pState);
    }
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        if (pStack.hasCustomHoverName()) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof BasicStorageEntity) {
                ((BasicStorageEntity)blockentity).setCustomName(pStack.getHoverName());
            }
        }

    }
    private VoxelShape getShape(BlockState state)
    {
        if(SHAPES.containsKey(state))
        {
            return SHAPES.get(state);
        }
        List<VoxelShape> shapes = new ArrayList<>();
        shapes.add(box(0.1, 0, 0.1, 15.9, 15.9, 15.9));
        VoxelShape shape = VoxelShapeHelper.combineAll(shapes);
        SHAPES.put(state, shape);
        return shape;
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return this.getShape(state);
    }
    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos)
    {
        return this.getShape(state);
    }
}
