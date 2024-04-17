package com.nukateam.nukacraft.common.foundation.world;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.foundation.world.features.ModConfiguredFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.ModFeatures;
import com.nukateam.nukacraft.common.foundation.world.trees.ModTrees;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
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

    public static final ResourceKey<PlacedFeature> TREES_ASH = registerKey("trees_ash");


    public static final Holder<PlacedFeature> TREES_GLOW =
            PlacementUtils.register("trees_glow",
                    ModTrees.TREE_GLOW,
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1),
                            Blocks.BIRCH_SAPLING));

    public static final Holder<PlacedFeature> TREES_DEWDROP =
            PlacementUtils.register("trees_dewdrop",
                    ModTrees.TREE_DEWDROP,
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1),
                            Blocks.BIRCH_SAPLING));

    public static final Holder<PlacedFeature> TREES_ASH_HEAP =
            PlacementUtils.register("trees_ash_heap",
                    ModTrees.TREE_ASH_HEAP,
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1),
                            Blocks.BIRCH_SAPLING));

    public static final Holder<PlacedFeature> DISK_ASHSTONE =
            PlacementUtils.register("disk_ashston",
                    ModFeatures.DISK_ASHSTONE,
                    CountPlacement.of(1),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> DISK_ASHDIRT =
            PlacementUtils.register("disk_ashdirt",
                    ModFeatures.DISK_ASHDIRT,
                    CountPlacement.of(3),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP,
                    BiomeFilter.biome());


    public static final Holder<PlacedFeature> LAKE_ACID_SURFACE =
            PlacementUtils.register("lake_acid_surface",
                    ModFeatures.LAKE_ACID,
                    RarityFilter.onAverageOnceEvery(50),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());


    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, nukaResource(name));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var features = context.lookup(Registries.CONFIGURED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);


        context.register(TREES_ASH, new PlacedFeature(
                features.getOrThrow(ModConfiguredFeatures.ASH_HEAP_TREE),
                List.of(PlacementUtils.countExtra(1, 0.1F, 1),
                InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(6),
                PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING), BiomeFilter.biome())
            )
        );

        context.register(TREES_ASH, new PlacedFeature(
                features.getOrThrow(
                        ModConfiguredFeatures.ASH_HEAP_TREE),
                        treeCheckArea(
                                PlacementUtils.countExtra(1, 0.1F, 1),
                                Blocks.BIRCH_SAPLING.defaultBlockState())
                )
        );


        context.register(PLACED_MANGROVE_TREE,
                new PlacedFeature(
                        features.getOrThrow(TFConfiguredFeatures.MANGROVE_TREE),
                        List.of(PlacementUtils.countExtra(3, 0.1F, 1),
                        InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(6),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, AvoidLandmarkModifier.checkSurface(),
                        PlacementUtils.filteredByBlockSurvival(TFBlocks.MANGROVE_SAPLING.get()), BiomeFilter.biome())
                )
        );


    }

    private static List<PlacementModifier> treeCheckArea(PlacementModifier count, BlockState sapling) {
        return ImmutableList.of(count,
                InSquarePlacement.spread(),
                SurfaceWaterDepthFilter.forMaxDepth(0),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, AvoidLandmarkModifier.checkSurface(),
                PlacementUtils.filteredByBlockSurvival(sapling.getBlock()),
                BiomeFilter.biome());
    }
}
