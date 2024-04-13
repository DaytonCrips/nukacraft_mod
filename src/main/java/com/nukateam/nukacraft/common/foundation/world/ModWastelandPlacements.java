package com.nukateam.nukacraft.common.foundation.world;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.foundation.world.features.ModFeatures;
import com.nukateam.nukacraft.common.foundation.world.trees.ModTreeFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModWastelandPlacements {

    public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);





    public static final Holder<PlacedFeature> TREES_ASH =
            PlacementUtils.register("trees_ash",
                    ModTreeFeatures.TREE_ASH,
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1),
                            Blocks.BIRCH_SAPLING));

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
}
