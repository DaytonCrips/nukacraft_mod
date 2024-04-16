package com.nukateam.nukacraft.common.foundation.world;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.features.ModFeatures;
import com.nukateam.nukacraft.common.foundation.world.trees.ModTreeFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModWastelandPlacements {
    public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

//    public static final Holder<PlacedFeature> TREES_ASH =
//            PlacementUtils.register("trees_ash",
//                    ModTreeFeatures.TREE_ASH,
//                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1),
//                            Blocks.BIRCH_SAPLING));

    public static final ResourceKey<PlacedFeature> TREES_ASH = registerKey("trees_ash");


    public static final Holder<PlacedFeature> TREES_GLOW =
            PlacementUtils.register("trees_glow",
                    ModTreeFeatures.TREE_GLOW,
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1),
                            Blocks.BIRCH_SAPLING));

    public static final Holder<PlacedFeature> TREES_DEWDROP =
            PlacementUtils.register("trees_dewdrop",
                    ModTreeFeatures.TREE_DEWDROP,
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1),
                            Blocks.BIRCH_SAPLING));

    public static final Holder<PlacedFeature> TREES_ASH_HEAP =
            PlacementUtils.register("trees_ash_heap",
                    ModTreeFeatures.TREE_ASH_HEAP,
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
                features.getOrThrow(ModTreeFeatures.TREE_ASH_HEAP),
                List.of(PlacementUtils.countExtra(1, 0.1F, 1),
                InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(6),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, AvoidLandmarkModifier.checkSurface(),
                PlacementUtils.filteredByBlockSurvival(TFBlocks.MANGROVE_SAPLING.get()), BiomeFilter.biome())
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

    public static final Holder<PlacedFeature> TREES_ASH1 =
            PlacementUtils.register("trees_ash",
                    ModTreeFeatures.TREE_ASH,
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1),
                            Blocks.BIRCH_SAPLING));

}
