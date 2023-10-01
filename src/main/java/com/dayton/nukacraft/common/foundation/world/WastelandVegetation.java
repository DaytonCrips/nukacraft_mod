package com.dayton.nukacraft.common.foundation.world;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class WastelandVegetation {



    public static final Holder<PlacedFeature> PATCH_WASTELAND_FLOWER_RARE = PlacementUtils.register("patch_wasteland_flower_rare", ModFeatures.WASTELAND_FLOWER_RARE, RarityFilter.onAverageOnceEvery(12), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_WASTELAND_FLOWER_COMMON = PlacementUtils.register("patch_wasteland_flower_common", ModFeatures.WASTELAND_FLOWER_COMMON, RarityFilter.onAverageOnceEvery(31), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());


    public static final Holder<PlacedFeature> PATCH_WASTELAND_BERRYS = PlacementUtils.register("patch_wasteland_berrys", ModFeatures.WASTELAND_BERRYS, RarityFilter.onAverageOnceEvery(31), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    //
    public static final Holder<PlacedFeature> PATCH_GINS = PlacementUtils.register("patch_gins_common", ModFeatures.PATCH_GINS_BUSH, RarityFilter.onAverageOnceEvery(19), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_DATURANS = PlacementUtils.register("patch_daturan_common", ModFeatures.PATCH_DEAD_DATURAN, RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_PUNGA = PlacementUtils.register("patch_punga_common", ModFeatures.PATCH_DEAD_PUNGA, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_CRANBERRY = PlacementUtils.register("patch_cranberry_common", ModFeatures.PATCH_CRANBERRY, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_CORALL = PlacementUtils.register("patch_coral_common", ModFeatures.PATCH_DEAD_CORAL, RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
//
    public static final Holder<PlacedFeature> PATCH_AGAVE_RARE = PlacementUtils.register("patch_agave_common", ModFeatures.PATCH_AGAVE_BUSH, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_BBLIGHT= PlacementUtils.register("patch_bblight_common", ModFeatures.PATCH_BBLIGHT, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());


    public static final Holder<PlacedFeature> PATCH_WASTELAND_MUSHROOMS = PlacementUtils.register("patch_wasteland_mushrooms", ModFeatures.WASTELAND_MUSHROOMS_COMMON, RarityFilter.onAverageOnceEvery(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_THISTLE_BUSH = PlacementUtils.register("patch_thistle_bush", ModFeatures.PATCH_THISTLE, RarityFilter.onAverageOnceEvery(45), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_SITTBEAN_BUSH = PlacementUtils.register("patch_sittbean_bush", ModFeatures.PATCH_SITTBEANS, RarityFilter.onAverageOnceEvery(17), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> GLOW_FLOWER_DEFAULT = PlacementUtils.register("glow_flower", ModFeatures.GLOWSEA_FLOWER, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
public static final Holder<PlacedFeature> GLOW_EXOTICS= PlacementUtils.register("glow_exotics", ModFeatures.WASTELAND_EXOTICS, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_BLOODLEAF = PlacementUtils.register("patch_bloodleaf_common", ModFeatures.PATCH_BLOODLEAF, RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
//
//
    public static final Holder<PlacedFeature> PATCH_ZANDER = PlacementUtils.register("patch_zander", ModFeatures.PATCH_XANDER, RarityFilter.onAverageOnceEvery(21), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

}
