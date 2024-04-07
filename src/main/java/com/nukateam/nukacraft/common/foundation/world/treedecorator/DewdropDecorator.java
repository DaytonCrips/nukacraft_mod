package com.nukateam.nukacraft.common.foundation.world.treedecorator;

import com.mojang.serialization.Codec;
import com.nukateam.nukacraft.common.registery.ModTreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class DewdropDecorator extends BaseTreeDecorator {
    public static final Codec<DewdropDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(DewdropDecorator::new, (thing) -> {
        return thing.probability;
    }).codec();
    private final float probability;

    public DewdropDecorator(float p_i225868_1_) {
        super(p_i225868_1_);
        this.probability = p_i225868_1_;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModTreeDecorator.DEWDROPDECORATOR.get();
    }
}
