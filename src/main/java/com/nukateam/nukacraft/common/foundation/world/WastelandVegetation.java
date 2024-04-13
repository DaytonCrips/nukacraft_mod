package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.foundation.world.features.ModFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class WastelandVegetation {

    public static final Holder<PlacedFeature> PATCH_DEWDROP_SAPLING_PLACE =
            PlacementUtils.register("patch_dewdrop_sapling_place",
                    ModFeatures.DEWDROP_SAPLING_PLANT,
                    RarityFilter.onAverageOnceEvery(4),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_BOGPAD =
            PlacementUtils.register("patch_bogpad",
                    ModFeatures.PATCH_BOGPAD, worldSurfaceSquaredWithCount(5));

    public static final Holder<PlacedFeature> PATCH_TOXIC_FERN_PLACE =
            PlacementUtils.register("patch_toxic_fern_place",
                    ModFeatures.TOXIC_FERN_PLANT,
                    RarityFilter.onAverageOnceEvery(2),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_FUSION_FRUIT_PLACE =
            PlacementUtils.register("patch_fusion_fruit_place",
                    ModFeatures.FUSFRUIT_BUSH_PLANT,
                    RarityFilter.onAverageOnceEvery(2),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_MEGAHATTER_PLACE =
            PlacementUtils.register("patch_megahatter_place",
                    ModFeatures.MEGAMORH_MUSH_PLANT,
                    RarityFilter.onAverageOnceEvery(3),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_ASTER_PLANT_PLACE =
            PlacementUtils.register("patch_aster_plant_place",
                    ModFeatures.ASTER_PLANT,
                    RarityFilter.onAverageOnceEvery(3),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_BROC_PLANT_PLACE =
            PlacementUtils.register("patch_broc_plant_place",
                    ModFeatures.BROC_PLANT,
                    RarityFilter.onAverageOnceEvery(4),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_THISTLE_PLANT_PLACE =
            PlacementUtils.register("patch_thistle_plant_place",
                    ModFeatures.THISTLE_PLANT,
                    RarityFilter.onAverageOnceEvery(35),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_DEAD_PLANT_PLACE =
            PlacementUtils.register("patch_dead_plant_place",
                    ModFeatures.DEAD_PLANT,
                    RarityFilter.onAverageOnceEvery(22),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_SOOTFLOWER_PLANT_PLACE =
            PlacementUtils.register("patch_sootflower_plant_place",
                    ModFeatures.SOOTFLOWER_PLANT,
                    RarityFilter.onAverageOnceEvery(25),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_HOLLYHOCK_PLANT_PLACE =
            PlacementUtils.register("patch_hollyhock_plant_place",
                    ModFeatures.HOLLYHOCK_PLANT,
                    RarityFilter.onAverageOnceEvery(17),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_FEVERBLOSSOM_PLANT_PLACE =
            PlacementUtils.register("patch_feverblossom_plant_place",
                    ModFeatures.FEVERBLOSSOM_PLANT,
                    RarityFilter.onAverageOnceEvery(26),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_CRACKBERRY_BUSH_PLACE =
            PlacementUtils.register("patch_crackberry_plant_place",
                    ModFeatures.CRACKBERRY_BUSH_PLANT,
                    RarityFilter.onAverageOnceEvery(31),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_MUTTFRUIT_BUSH_PLACE =
            PlacementUtils.register("patch_muttfruit_plant_place",
                    ModFeatures.MUTTFRUIT_BUSH_PLANT,
                    RarityFilter.onAverageOnceEvery(25),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_BRAINFUNGUS_PLACE =
            PlacementUtils.register("patch_brainfungus_plant_place",
                    ModFeatures.BRAINFUNGUS_PLANT,
                    RarityFilter.onAverageOnceEvery(22),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_GLOWFUNGUS_PLACE =
            PlacementUtils.register("patch_glowfungus_plant_place",
                    ModFeatures.GLOWFUNGUS_PLANT,
                    RarityFilter.onAverageOnceEvery(25),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_GUTFUNGI_PLACE =
            PlacementUtils.register("patch_gutfungus_plant_place",
                    ModFeatures.GUTFUNGI_PLANT,
                    RarityFilter.onAverageOnceEvery(18),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_BOMBBERRY_BUSH_PLACE =
            PlacementUtils.register("patch_bomberry_plant_place",
                    ModFeatures.BOMBBERRY_BUSH_PLANT,
                    RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_QUANTUMLEAF_BUSH_PLACE =
            PlacementUtils.register("patch_quantleaf_plant_place",
                    ModFeatures.QUANTUMLEAF_BUSH_PLANT,
                    RarityFilter.onAverageOnceEvery(21),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_NEUTRON_BUSH_PLACE =
            PlacementUtils.register("patch_neutron_plant_place",
                    ModFeatures.NEUTRON_BUSH_PLANT,
                    RarityFilter.onAverageOnceEvery(23),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_MINDFUNGUS_PLACE =
            PlacementUtils.register("patch_mindfungus_plant_place",
                    ModFeatures.MINDFUNGUS_PLANT,
                    RarityFilter.onAverageOnceEvery(17),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_RADASTER_PLANT_PLACE =
            PlacementUtils.register("patch_radaster_plant_place",
                    ModFeatures.RADASTER_PLANT,
                    RarityFilter.onAverageOnceEvery(28),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_RADROSE_PLANT_PLACE =
            PlacementUtils.register("patch_radrose_plant_place",
                    ModFeatures.RADROSE_PLANT,
                    RarityFilter.onAverageOnceEvery(32),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_BLASTCAP_PLACE =
            PlacementUtils.register("patch_blastcap_plant_place",
                    ModFeatures.BLASTCAP_PLANT,
                    RarityFilter.onAverageOnceEvery(23),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_FIREFUNGI_PLACE =
            PlacementUtils.register("patch_firefungi_plant_place",
                    ModFeatures.FIREFUNGI_PLANT,
                    RarityFilter.onAverageOnceEvery(21),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_INVERT_PLANT_PLACE =
            PlacementUtils.register("patch_invert_plant_place",
                    ModFeatures.INVERT_PLANT,
                    RarityFilter.onAverageOnceEvery(25),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_BOOMBLOSSOM_PLANT_PLACE =
            PlacementUtils.register("patch_boomblossom_plant_place",
                    ModFeatures.BOOMBLOSSOM_PLANT,
                    RarityFilter.onAverageOnceEvery(21),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());


    public static final Holder<PlacedFeature> PATCH_CRANBERRY =
            PlacementUtils.register("patch_cranberry",
                    ModFeatures.CRANBERRY_PLANT,
                    RarityFilter.onAverageOnceEvery(22),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());


    public static final Holder<PlacedFeature> PATCH_STARBERRY =
            PlacementUtils.register("patch_starberry",
                    ModFeatures.STARBERRY_PLANT,
                    RarityFilter.onAverageOnceEvery(21),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    //
    public static final Holder<PlacedFeature> PATCH_GINS =
            PlacementUtils.register("patch_gins_common",
                    ModFeatures.PATCH_GINS_BUSH,
                    RarityFilter.onAverageOnceEvery(19),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_DATURANS =
            PlacementUtils.register("patch_daturan_common",
                    ModFeatures.PATCH_DEAD_DATURAN,
                    RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_PUNGA =
            PlacementUtils.register("patch_punga_common",
                    ModFeatures.PATCH_DEAD_PUNGA,
                    RarityFilter.onAverageOnceEvery(10),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_CORALL =
            PlacementUtils.register("patch_coral_common",
                    ModFeatures.PATCH_DEAD_CORAL,
                    RarityFilter.onAverageOnceEvery(6),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    //
    public static final Holder<PlacedFeature> PATCH_AGAVE_RARE =
            PlacementUtils.register("patch_agave_common",
                    ModFeatures.PATCH_AGAVE_BUSH,
                    RarityFilter.onAverageOnceEvery(10),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());


    public static final Holder<PlacedFeature> PATCH_SITTBEAN_BUSH =
            PlacementUtils.register("patch_sittbean_bush",
                    ModFeatures.PATCH_SITTBEANS,
                    RarityFilter.onAverageOnceEvery(17),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_BLOODLEAF =
            PlacementUtils.register("patch_bloodleaf_common",
                    ModFeatures.PATCH_BLOODLEAF,
                    RarityFilter.onAverageOnceEvery(9),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    //
//
    public static final Holder<PlacedFeature> PATCH_ZANDER =
            PlacementUtils.register("patch_zander",
                    ModFeatures.PATCH_XANDER,
                    RarityFilter.onAverageOnceEvery(21),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_RUSTY_BUSH =
            PlacementUtils.register("patch_rusty_bush",
                    ModFeatures.PATCH_RUSTY_BUSH,
                    RarityFilter.onAverageOnceEvery(25),
                    InSquarePlacement.spread(),
                    PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                    BiomeFilter.biome());


    public static List<PlacementModifier> worldSurfaceSquaredWithCount(int pCount) {
        return List.of(CountPlacement.of(pCount), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }
}
