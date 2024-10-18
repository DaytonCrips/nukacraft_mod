package com.nukateam.nukacraft.common.foundation.blocks.blocks;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class DoorTerminalBlock extends Block {
    public DoorTerminalBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        int positionX = pPos.getX() - 3;
        int positionZ = pPos.getZ() - 3;

        NukaCraftMod.LOGGER.debug(pPos + "");
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 7; x++) {
                for (int z = 0; z < 7; z++) {
                    BlockPos posXYZ = new BlockPos(positionX+x, pPos.getY()+y, positionZ+z);
                    //boolean isShelterDoor = (pLevel.getBlockState(posXYZ).getBlock() instanceof GearDoorBlock || pLevel.getBlockState(posXYZ).getBlock() instanceof OpenGearBlock);
                    if ((pLevel.getBlockState(posXYZ).getBlock() instanceof GearDoorBlock || pLevel.getBlockState(posXYZ).getBlock() instanceof OpenGearBlock)) {
                        Block shelter = pLevel.getBlockState(posXYZ).getBlock();
                        shelter.doo
                    }
                }
            }
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
