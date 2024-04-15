package com.nukateam.nukacraft.common.foundation.world.treedecorator;

import com.mojang.serialization.Codec;
import com.nukateam.nukacraft.common.foundation.blocks.plants.BBlightMushroom;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.ModTreeDecorator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CocoaBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class BBlightDecorator  extends TreeDecorator {
    public static final Codec<BBlightDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(BBlightDecorator::new, (thing) -> {
        return thing.probability;
    }).codec();
    private final float probability;

    public BBlightDecorator(float p_i225868_1_) {
        this.probability = p_i225868_1_;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModTreeDecorator.BBLIGHT_DECORATOR.get();
    }




    public void place(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom, List<BlockPos> pLogPositions, List<BlockPos> pLeafPositions) {
        if (!(pRandom.nextFloat() >= this.probability)) {
            int i = pLogPositions.get(0).getY();
            pLogPositions.stream().filter((p_69980_) -> {
                return p_69980_.getY() - i <= 2;
            }).forEach((p_161728_) -> {
                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    if (pRandom.nextFloat() <= 0.25F) {
                        Direction direction1 = direction.getOpposite();
                        BlockPos blockpos = p_161728_.offset(direction1.getStepX(), 0, direction1.getStepZ());
                        if (Feature.isAir(pLevel, blockpos)) {
                            pBlockSetter.accept(blockpos, ModBlocks.BBLIGHTMUSH.get().defaultBlockState().setValue(BBlightMushroom.AGE, Integer.valueOf(pRandom.nextInt(3))).setValue(BBlightMushroom.FACING, direction));
                        }
                    }
                }

            });
        }
    }

}
