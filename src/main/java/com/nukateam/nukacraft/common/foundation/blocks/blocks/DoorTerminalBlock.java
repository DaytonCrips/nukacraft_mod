package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class DoorTerminalBlock extends Block {
    public DoorTerminalBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState state, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        int positionX = pPos.getX() - 3;
        int positionZ = pPos.getZ() - 3;

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 7; x++) {
                for (int z = 0; z < 7; z++) {
                    var posXYZ = new BlockPos(positionX + x, pPos.getY() + y, positionZ + z);
                    var doorBlockState = pLevel.getBlockState(posXYZ);

                    if ((pLevel.getBlockState(posXYZ).getBlock() instanceof GearDoorBlock gearDoor)) {
                        gearDoor.doorInteraction(doorBlockState, pLevel, posXYZ);
                    }

                    if (pLevel.getBlockState(posXYZ).getBlock() instanceof OpenGearBlock gearDoor) {
                        gearDoor.doorInteraction(doorBlockState, pLevel, posXYZ);
                    }
                }
            }
        }

        return super.use(state, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
