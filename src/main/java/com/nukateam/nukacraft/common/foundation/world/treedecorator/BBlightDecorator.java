package com.nukateam.nukacraft.common.foundation.world.treedecorator;

import com.mojang.serialization.Codec;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.ModTreeDecorator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class BBlightDecorator extends BaseTreeDecorator {
    public static final Codec<BBlightDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(BBlightDecorator::new, (thing) -> {
        return thing.probability;
    }).codec();

    private final float probability;

    public BBlightDecorator(float p_i225868_1_) {
        super(p_i225868_1_);
        this.probability = p_i225868_1_;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModTreeDecorator.BBLIGHT_DECORATOR.get();
    }
}
