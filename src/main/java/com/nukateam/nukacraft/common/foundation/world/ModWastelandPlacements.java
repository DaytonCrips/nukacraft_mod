package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModWastelandPlacements {
    public static final Holder<PlacedFeature> DISK_ASHSTONE =
            PlacementUtils.register("disk_ashston",
                    ModWastelandFeatures.DISK_ASHSTONE,
                    CountPlacement.of(1),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> DISK_ASHDIRT =
            PlacementUtils.register("disk_ashdirt",
                    ModWastelandFeatures.DISK_ASHDIRT,
                    CountPlacement.of(3),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> LAKE_ACID_SURFACE =
            PlacementUtils.register("lake_acid_surface",
                    ModWastelandFeatures.LAKE_ACID,
                    RarityFilter.onAverageOnceEvery(50),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
}
