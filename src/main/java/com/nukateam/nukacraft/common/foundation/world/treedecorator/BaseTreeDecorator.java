package com.nukateam.nukacraft.common.foundation.world.treedecorator;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;

public abstract class BaseTreeDecorator extends TreeDecorator {
    private final float probability;

    protected BaseTreeDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    public void place(TreeDecorator.Context context) {
        var pos1 = context.roots();
        var random = RandomSource.create();

        if (!(random.nextFloat() >= this.probability)) {
            int i = pos1.get(0).getY();
            pos1.stream().filter((p_69980_) -> p_69980_.getY() - i <= 4).forEach((p_161728_) -> {
                for (Direction direction : Direction.Plane.HORIZONTAL) {
                    if (random.nextFloat() <= 0.25F) {
                        Direction direction1 = direction.getOpposite();
                        BlockPos blockpos = p_161728_.offset(direction1.getStepX(), 0, direction1.getStepZ());
                        if (context.isAir(blockpos)) {
                            context.setBlock(blockpos, ModBlocks.DEWDROPHEAD.get().defaultBlockState());
                        }
                    }
                }
            });
        }
    }
}
