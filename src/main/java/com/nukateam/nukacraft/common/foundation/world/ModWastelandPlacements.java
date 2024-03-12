package com.nukateam.nukacraft.common.foundation.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.*;

public class ModWastelandPlacements {
    public static final Holder<PlacedFeature> DISK_ASHSTONE =
            PlacementUtils.register("disk_ashston",
                    ModWastelandFeatures.DISK_ASHSTONE,
                    CountPlacement.of(1),
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
