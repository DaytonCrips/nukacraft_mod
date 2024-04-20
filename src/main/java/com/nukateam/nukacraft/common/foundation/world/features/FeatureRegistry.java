package com.nukateam.nukacraft.common.foundation.world.features;

import com.nukateam.nukacraft.common.foundation.world.features.configured.BiomeFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.configured.ModTreeFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.configured.ModVegetationFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.configured.OreFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.placed.BiomePlacements;
import com.nukateam.nukacraft.common.foundation.world.features.placed.ModOrePlacements;
import com.nukateam.nukacraft.common.foundation.world.features.placed.ModTreePlacements;
import com.nukateam.nukacraft.common.foundation.world.features.placed.ModVegetationPlacements;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FeatureRegistry {
    public static void bootstrapConfigured(BootstapContext<ConfiguredFeature<?, ?>> context) {
        OreFeatures.bootstrap(context);
        ModTreeFeatures.bootstrap(context);
        BiomeFeatures.bootstrap(context);
        ModVegetationFeatures.bootstrap(context);
    }

    public static void bootstrapPlaced(BootstapContext<PlacedFeature> context) {
        ModTreePlacements.bootstrap(context);
        ModVegetationPlacements.bootstrap(context);
        ModOrePlacements.bootstrap(context);
        BiomePlacements.bootstrap(context);
    }
}
