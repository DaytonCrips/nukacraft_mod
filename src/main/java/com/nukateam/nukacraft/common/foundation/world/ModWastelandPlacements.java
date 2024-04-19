package com.nukateam.nukacraft.common.foundation.world;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.foundation.world.features.ModConfiguredFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.ModFeatures;
import com.nukateam.nukacraft.common.foundation.world.trees.ModTrees;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModWastelandPlacements {
    public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

//    public static final Holder<PlacedFeature> TREES_ASH =
//            PlacementUtils.register("trees_ash",
//                    ModTrees.TREE_ASH,
//                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1),
//                            Blocks.BIRCH_SAPLING));

    public static final ResourceKey<PlacedFeature> TREES_ASH_HEAP = registerKey("trees_ash_heap");
    public static final ResourceKey<PlacedFeature> TREES_GLOW = registerKey("trees_glow");
    public static final ResourceKey<PlacedFeature> TREES_DEWDROP = registerKey("trees_dewdrop");
    public static final ResourceKey<PlacedFeature> TREES_ASH = registerKey("trees_ash");
    public static final ResourceKey<PlacedFeature> DISK_ASHSTONE = registerKey("disk_ashston");

    public static final ResourceKey<PlacedFeature> ASH_GRASSS = registerKey("ashgrasss");
    public static final ResourceKey<PlacedFeature> POISON_GRASS = registerKey("poisongrass");

    public static final ResourceKey<PlacedFeature> CRANBERRY_GRASS = registerKey("crangrass");
    public static final ResourceKey<PlacedFeature> GRASS_ASH = registerKey("grass_ash");
    public static final ResourceKey<PlacedFeature> GLOW_GRASS = registerKey("glowgrass");

    public static final ResourceKey<PlacedFeature> HEAP_GRASS = registerKey("heap_grass");
    public static final ResourceKey<PlacedFeature> RUSTY_BUSH = registerKey("rusty_bush_patch");




//    public static final Holder<PlacedFeature> DISK_ASHSTONE =
//            PlacementUtils.register("disk_ashston",
//                    ModFeatures.DISK_ASHSTONE,
//                    CountPlacement.of(1),
//                    InSquarePlacement.spread(),
//                    PlacementUtils.HEIGHTMAP,
//                    BiomeFilter.biome());

    public static final ResourceKey<PlacedFeature> DISK_ASHDIRT = registerKey("disk_ashdirt");

    public static final ResourceKey<PlacedFeature> LAKE_ACID_SURFACE = registerKey("lake_acid_surface");

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, nukaResource(name));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var features = context.lookup(Registries.CONFIGURED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(HEAP_GRASS, new PlacedFeature(features.getOrThrow( ModFeatures.PATCH_HEAP_GRASS),
                List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(RUSTY_BUSH, new PlacedFeature(features.getOrThrow(ModFeatures.PATCH_RUSTY_BUSH),
                List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(GLOW_GRASS, new PlacedFeature(features.getOrThrow(ModFeatures.PATCH_GLOWGRASS),
                List.of(NoiseThresholdCountPlacement.of(-0.8D, 3, 3),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(GRASS_ASH, new PlacedFeature(features.getOrThrow(VegetationFeatures.PATCH_GRASS),
                List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(CRANBERRY_GRASS, new PlacedFeature(features.getOrThrow(ModFeatures.PATCH_CRANGRASS),
                List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 12),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(ASH_GRASSS, new PlacedFeature(features.getOrThrow(ModFeatures.PATCH_ASHGRASS),
                List.of(NoiseThresholdCountPlacement.of(-0.3D, 2, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(POISON_GRASS, new PlacedFeature(features.getOrThrow(ModFeatures.PATCH_POISONGRASS),
                List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(TREES_ASH_HEAP, new PlacedFeature(
                features.getOrThrow(
                        ModConfiguredFeatures.ASH_HEAP_TREE),
                        VegetationPlacements.treePlacement(
                                PlacementUtils.countExtra(1, 0.1F, 1),
                                Blocks.BIRCH_SAPLING)
                )
        );

        context.register(TREES_ASH, new PlacedFeature(
                features.getOrThrow(
                        ModConfiguredFeatures.ASH_TREE),
                        VegetationPlacements.treePlacement(
                                PlacementUtils.countExtra(1, 0.1F, 1),
                                Blocks.BIRCH_SAPLING)
                )
        );

        context.register(TREES_GLOW, new PlacedFeature(
                features.getOrThrow(ModConfiguredFeatures.GLOW_TREE),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(1, 0.1F, 1),
                        Blocks.BIRCH_SAPLING))
        );

        context.register(TREES_DEWDROP, new PlacedFeature(
                features.getOrThrow(ModConfiguredFeatures.TREE_DEWDROP),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(1, 0.1F, 1),
                        Blocks.BIRCH_SAPLING))
        );

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
