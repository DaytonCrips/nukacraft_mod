package com.nukateam.nukacraft.common.foundation.world.treedecorator;

import com.mojang.serialization.Codec;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.ModTreeDecorator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class MegaSlothDecorator extends TreeDecorator {
    public static final Codec<MegaSlothDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(MegaSlothDecorator::new, (thing) -> {
        return thing.probability;
    }).codec();
    private final float probability;

    public MegaSlothDecorator(float p_i225868_1_) {
        this.probability = p_i225868_1_;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModTreeDecorator.MEGASLOTH_DECORATOR.get();
    }

    public void place(LevelSimulatedReader world, BiConsumer<BlockPos, BlockState> state, Random rando, List<BlockPos> p_161722_, List<BlockPos> p_161723_) {
        if (!(rando.nextFloat() >= this.probability)) {
            int i = p_161722_.get(0).getY();
            p_161722_.stream().filter((p_69980_) -> {
                return p_69980_.getY() - i <= 2;
            }).forEach((p_161728_) -> {
                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    if (rando.nextFloat() <= 0.25F) {
                        Direction direction1 = direction.getOpposite();
                        BlockPos blockpos = p_161728_.offset(direction1.getStepX(), 0, direction1.getStepZ());
                        if (Feature.isAir(world, blockpos)) {
                            state.accept(blockpos, ModBlocks.MEGASLOTHBLOCK.get().defaultBlockState());
                        }
                    }
                }

            });
        }
    }
}
