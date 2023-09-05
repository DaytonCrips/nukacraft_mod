package com.dayton.nukacraft.common.world;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;

public class WastelandVegetation {
    public static final Holder<PlacedFeature> PATCH_CRACKBERRY_RARE = PlacementUtils.register("patch_berry_rare", ModFeatures.PATCH_CRACK_BUSH, RarityFilter.onAverageOnceEvery(31), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_GINS = PlacementUtils.register("patch_gins_common", ModFeatures.PATCH_GINS_BUSH, RarityFilter.onAverageOnceEvery(19), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_DATURANS = PlacementUtils.register("patch_daturan_common", ModFeatures.PATCH_DEAD_DATURAN, RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_PUNGA = PlacementUtils.register("patch_punga_common", ModFeatures.PATCH_DEAD_PUNGA, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_STARBERRY = PlacementUtils.register("patch_starberry_common", ModFeatures.PATCH_STARBERRY, RarityFilter.onAverageOnceEvery(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_CRANBERRY = PlacementUtils.register("patch_cranberry_common", ModFeatures.PATCH_CRANBERRY, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_CORALL = PlacementUtils.register("patch_coral_common", ModFeatures.PATCH_DEAD_CORAL, RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_AGAVE_RARE = PlacementUtils.register("patch_berry_common", ModFeatures.PATCH_AGAVE_BUSH, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_BBLIGHT= PlacementUtils.register("patch_berry_common", ModFeatures.PATCH_BBLIGHT, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_THISTLE_BUSH = PlacementUtils.register("patch_thistle_bush", ModFeatures.PATCH_THISTLE, RarityFilter.onAverageOnceEvery(45), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_GLOWFUNGUS_BUSH = PlacementUtils.register("patch_glowfungus_bush", ModFeatures.PATCH_GLOWFUNGUS, RarityFilter.onAverageOnceEvery(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_SITTBEAN_BUSH = PlacementUtils.register("patch_sittbean_bush", ModFeatures.PATCH_SITTBEANS, RarityFilter.onAverageOnceEvery(17), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_BRAINFUNG_BUSH = PlacementUtils.register("patch_brainfung_bush", ModFeatures.PATCH_BRAINFUNGUS, RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> GLOW_FLOWER_DEFAULT = PlacementUtils.register("glow_flower", ModFeatures.GLOWSEA_FLOWER, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_QUANTLEAF = PlacementUtils.register("patch_quantleaf_common", ModFeatures.PATCH_QUANTLEAF, RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_MINDFUNGUS_BUSH = PlacementUtils.register("patch_mindfungus_bush", ModFeatures.PATCH_MINDFUNGUS, RarityFilter.onAverageOnceEvery(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_NEUTRON_BUSH = PlacementUtils.register("patch_neutron_bush", ModFeatures.PATCH_NEUTRONROD, RarityFilter.onAverageOnceEvery(17), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> POISON_FLOWER_DEFAULT = PlacementUtils.register("poison_flower", ModFeatures.POISONVALLEY_FLOWER, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_BLOODLEAF = PlacementUtils.register("patch_bloodleaf_common", ModFeatures.PATCH_BLOODLEAF, RarityFilter.onAverageOnceEvery(9), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_HOLLYHOCK = PlacementUtils.register("patch_hollyss", ModFeatures.PATCH_HOLLYHCOCK, RarityFilter.onAverageOnceEvery(20), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_MUTTFRUIT = PlacementUtils.register("patch_muttfruit", ModFeatures.PATCH_MUTTFRUIT, RarityFilter.onAverageOnceEvery(31), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

    public static final Holder<PlacedFeature> ASHHEAP_FLOWER_DEFAULT = PlacementUtils.register("ash_flower", ModFeatures.ASHHEAP_FLOWER, RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_ZANDER = PlacementUtils.register("patch_zander", ModFeatures.PATCH_XANDER, RarityFilter.onAverageOnceEvery(21), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_BOMBBERRY_RARE = PlacementUtils.register("patch_bombberry_rare", ModFeatures.PATCH_BOMB_BUSH, RarityFilter.onAverageOnceEvery(31), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

}
