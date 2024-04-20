package com.nukateam.nukacraft.common.foundation.world.features.placed;

import com.nukateam.nukacraft.common.foundation.world.features.configured.ModTreeFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModTreePlacements {
    public static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

//    public static final Holder<PlacedFeature> TREES_ASH =
//            PlacementUtils.register("trees_ash",
//                    ModTrees.TREE_ASH,
//                    ModVegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1),
//                            Blocks.BIRCH_SAPLING));

    public static final ResourceKey<PlacedFeature> TREES_ASH_HEAP = registerKey("trees_ash_heap");
    public static final ResourceKey<PlacedFeature> TREES_GLOW = registerKey("trees_glow");
    public static final ResourceKey<PlacedFeature> TREES_DEWDROP = registerKey("trees_dewdrop");
    public static final ResourceKey<PlacedFeature> TREES_ASH = registerKey("trees_ash");

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, nukaResource(name));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var features = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(TREES_ASH_HEAP, new PlacedFeature(
                        features.getOrThrow(
                                ModTreeFeatures.ASH_HEAP_TREE),
                        VegetationPlacements.treePlacement(
                                PlacementUtils.countExtra(1, 0.1F, 1),
                                Blocks.BIRCH_SAPLING)
                )
        );

        context.register(TREES_ASH, new PlacedFeature(
                        features.getOrThrow(
                                ModTreeFeatures.ASH_TREE),
                        VegetationPlacements.treePlacement(
                                PlacementUtils.countExtra(1, 0.1F, 1),
                                Blocks.BIRCH_SAPLING)
                )
        );

        context.register(TREES_GLOW, new PlacedFeature(
                features.getOrThrow(ModTreeFeatures.GLOW_TREE),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(1, 0.1F, 1),
                        Blocks.BIRCH_SAPLING))
        );

        context.register(TREES_DEWDROP, new PlacedFeature(
                features.getOrThrow(ModTreeFeatures.TREE_DEWDROP),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(1, 0.1F, 1),
                        Blocks.BIRCH_SAPLING))
        );
    }
}
