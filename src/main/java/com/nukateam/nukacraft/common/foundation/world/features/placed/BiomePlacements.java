package com.nukateam.nukacraft.common.foundation.world.features.placed;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.foundation.world.features.configured.ModFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class BiomePlacements {
    public static final ResourceKey<PlacedFeature> DISK_ASHSTONE = registerKey("disk_ashston");

    public static final ResourceKey<PlacedFeature> DISK_ASHDIRT = registerKey("disk_ashdirt");
    public static final ResourceKey<PlacedFeature> LAKE_ACID_SURFACE = registerKey("lake_acid_surface");

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, nukaResource(name));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var features = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(DISK_ASHSTONE, new PlacedFeature(
                features.getOrThrow(ModFeatures.DISK_ASHSTONE),
                ImmutableList.of(
                        CountPlacement.of(1),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome())
                )
        );

        context.register(DISK_ASHDIRT, new PlacedFeature(
                features.getOrThrow(ModFeatures.DISK_ASHDIRT),
                ImmutableList.of(
                        CountPlacement.of(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()
                )
            )
        );

        context.register(LAKE_ACID_SURFACE, new PlacedFeature(
                features.getOrThrow(ModFeatures.LAKE_ACID),
                ImmutableList.of(
                        RarityFilter.onAverageOnceEvery(50),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ))
        );
    }
}
