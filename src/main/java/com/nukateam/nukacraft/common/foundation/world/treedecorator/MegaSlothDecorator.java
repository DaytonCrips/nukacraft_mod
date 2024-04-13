package com.nukateam.nukacraft.common.foundation.world.treedecorator;

import com.mojang.serialization.Codec;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.ResinBlock;
import com.nukateam.nukacraft.common.foundation.blocks.plants.MegaSlothBlock;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.ModTreeDecorator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class MegaSlothDecorator extends TreeDecorator {
    public static final Codec<MegaSlothDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(MegaSlothDecorator::new, (p_69989_) -> {
        return p_69989_.probability;
    }).codec();
    private final float probability;

    public MegaSlothDecorator(float p_69976_) {
        this.probability = p_69976_;
    }

    protected TreeDecoratorType<?> type() {
        return ModTreeDecorator.MEGASLOTH_DECORATOR.get();
    }

    public void place(TreeDecorator.Context pContext) {
        RandomSource $$1 = pContext.random();
        if (!($$1.nextFloat() >= this.probability)) {
            List<BlockPos> $$2 = pContext.logs();
            int $$3 = ((BlockPos)$$2.get(0)).getY();
            $$2.stream().filter((p_69980_) -> {
                return p_69980_.getY() - $$3 <= 2;
            }).forEach((p_226026_) -> {
                Iterator var3 = Direction.Plane.HORIZONTAL.iterator();

                while(var3.hasNext()) {
                    Direction $$32 = (Direction)var3.next();
                    if ($$1.nextFloat() <= 0.25F) {
                        Direction $$4 = $$32.getOpposite();
                        BlockPos $$5 = p_226026_.offset($$4.getStepX(), 0, $$4.getStepZ());
                        if (pContext.isAir($$5)) {
                            pContext.setBlock($$5, (BlockState)((BlockState) ModBlocks.MEGASLOTHBLOCK.get().defaultBlockState().setValue(MegaSlothBlock.AGE, $$1.nextInt(3))).setValue(MegaSlothBlock.FACING, $$32));
                        }
                    }
                }

            });
        }
    }

}
