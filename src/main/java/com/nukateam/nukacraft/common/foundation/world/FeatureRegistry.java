package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.foundation.world.features.configured.ModFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.configured.ModTreeFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.configured.OreFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FeatureRegistry {
    public static void bootstrapConfigured(BootstapContext<ConfiguredFeature<?, ?>> context) {
        OreFeatures.bootstrap(context);
        ModTreeFeatures.bootstrap(context);
//        ModFeatures.bootstrap(context);
    }

    public static void bootstrapPlaced(BootstapContext<PlacedFeature> context) {
    }
}
