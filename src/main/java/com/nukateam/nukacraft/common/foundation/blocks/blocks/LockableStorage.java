package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.nukacraft.common.foundation.entities.blocks.BasicStorageEntity;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LockableStorage extends BasicStorageBlock{
    public LockableStorage(Properties pProperties, String model) {
        super(pProperties, model);
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pPlayer.getOffhandItem().getItem() == ModItems.PIP_BOY_D.get()) {
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
        } else {return InteractionResult.FAIL;}
    }

    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof Container) {
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }
}
