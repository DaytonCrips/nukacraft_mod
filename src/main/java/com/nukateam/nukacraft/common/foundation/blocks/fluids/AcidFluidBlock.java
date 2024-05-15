package com.nukateam.nukacraft.common.foundation.blocks.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded"})
public class AcidFluidBlock extends LiquidBlock {
    public AcidFluidBlock(RegistryObject<FlowingFluid> flowingFluid, BlockBehaviour.Properties properties) {
        super(flowingFluid, properties);
    }

    @Override
    public void entityInside(BlockState pState, Level level, BlockPos pPos, Entity entity) {
        if (!level.isClientSide && entity instanceof LivingEntity living) {
            living.hurt(level.damageSources().generic(), 1);
        }
    }

    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (shouldSpreadLiquid(pLevel, pPos, pState)) {
            pLevel.scheduleTick(pPos, pState.getFluidState().getType(), getFluid().getTickDelay(pLevel));
        }

    }

    private boolean shouldSpreadLiquid(Level pLevel, BlockPos acidPos, BlockState pState) {
        boolean flag = pLevel.getBlockState(acidPos.below()).is(Blocks.SOUL_SOIL);

//        for(Direction direction : POSSIBLE_FLOW_DIRECTIONS) {
//            var lavaPos = acidPos.relative(direction.getOpposite());
//            if (pLevel.getFluidState(lavaPos).is(FluidTags.LAVA)) {
//                var block = pLevel.getFluidState(lavaPos).isSource() ? Blocks.CRYING_OBSIDIAN : Blocks.TUFF;
//                pLevel.setBlockAndUpdate(lavaPos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(pLevel,
//                        lavaPos, lavaPos, block.defaultBlockState()));
////                this.fizz(pLevel, pPos);
//                return false;
//            }
//
//            if (flag && pLevel.getBlockState(lavaPos).is(Blocks.BLUE_ICE)) {
//                pLevel.setBlockAndUpdate(acidPos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(pLevel, acidPos, acidPos, Blocks.BASALT.defaultBlockState()));
////                this.fizz(pLevel, pPos);
//                return false;
//            }
//        }

        return true;
    }
}
