package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.foundation.world.features.ModFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class WastelandVegetation {
    public static final ResourceKey<PlacedFeature> PATCH_DEWDROP_SAPLING_PLACE = registerKey("patch_dewdrop_sapling_place");
    public static final ResourceKey<PlacedFeature> PATCH_BOGPAD = registerKey("patch_bogpad");
    public static final ResourceKey<PlacedFeature> PATCH_TOXIC_FERN_PLACE = registerKey("patch_toxic_fern_place");
    public static final ResourceKey<PlacedFeature> PATCH_FUSION_FRUIT_PLACE = registerKey("patch_fusion_fruit_place");
    public static final ResourceKey<PlacedFeature> PATCH_MEGAHATTER_PLACE = registerKey("patch_megahatter_place");
    public static final ResourceKey<PlacedFeature> PATCH_ASTER_PLANT_PLACE = registerKey("patch_aster_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BROC_PLANT_PLACE = registerKey("patch_broc_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_THISTLE_PLANT_PLACE = registerKey("patch_thistle_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_DEAD_PLANT_PLACE = registerKey("patch_dead_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_SOOTFLOWER_PLANT_PLACE = registerKey("patch_sootflower_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_HOLLYHOCK_PLANT_PLACE = registerKey("patch_hollyhock_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_FEVERBLOSSOM_PLANT_PLACE = registerKey("patch_feverblossom_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_CRACKBERRY_BUSH_PLACE = registerKey("patch_crackberry_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_MUTTFRUIT_BUSH_PLACE = registerKey("patch_muttfruit_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BRAINFUNGUS_PLACE = registerKey("patch_brainfungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_GLOWFUNGUS_PLACE = registerKey("patch_glowfungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_GUTFUNGI_PLACE = registerKey("patch_gutfungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BOMBBERRY_BUSH_PLACE = registerKey("patch_bomberry_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_QUANTUMLEAF_BUSH_PLACE = registerKey("patch_quantleaf_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_NEUTRON_BUSH_PLACE = registerKey("patch_neutron_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_MINDFUNGUS_PLACE = registerKey("patch_mindfungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_RADASTER_PLANT_PLACE = registerKey("patch_radaster_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_RADROSE_PLANT_PLACE = registerKey("patch_radrose_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BLASTCAP_PLACE = registerKey("patch_blastcap_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_FIREFUNGI_PLACE = registerKey("patch_firefungi_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_INVERT_PLANT_PLACE = registerKey("patch_invert_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BOOMBLOSSOM_PLANT_PLACE = registerKey("patch_boomblossom_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_CRANBERRY = registerKey("patch_cranberry");
    public static final ResourceKey<PlacedFeature> PATCH_STARBERRY = registerKey("patch_starberry");
    //
    public static final ResourceKey<PlacedFeature> PATCH_GINS = registerKey("patch_gins_common");
    public static final ResourceKey<PlacedFeature> PATCH_DATURANS = registerKey("patch_daturan_common");
    public static final ResourceKey<PlacedFeature> PATCH_PUNGA = registerKey("patch_punga_common");
    public static final ResourceKey<PlacedFeature> PATCH_CORALL = registerKey("patch_coral_common");
    //
    public static final ResourceKey<PlacedFeature> PATCH_AGAVE_RARE = registerKey("patch_agave_common");
    public static final ResourceKey<PlacedFeature> PATCH_SITTBEAN_BUSH = registerKey("patch_sittbean_bush");
    public static final ResourceKey<PlacedFeature> PATCH_BLOODLEAF = registerKey("patch_bloodleaf_common");
    //
//
    public static final ResourceKey<PlacedFeature> PATCH_ZANDER = registerKey("patch_zander");
    public static final ResourceKey<PlacedFeature> PATCH_RUSTY_BUSH = registerKey("patch_rusty_bush");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var features = context.lookup(Registries.CONFIGURED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(PATCH_DEWDROP_SAPLING_PLACE, new PlacedFeature(features.getOrThrow(ModFeatures.DEWDROP_SAPLING_PLANT),
                List.of(RarityFilter.onAverageOnceEvery(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())
        ));

        context.register(PATCH_BOGPAD, new PlacedFeature(features.getOrThrow(
                        ModFeatures.PATCH_BOGPAD), worldSurfaceSquaredWithCount(5)));

        context.register(PATCH_TOXIC_FERN_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.TOXIC_FERN_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_FUSION_FRUIT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.FUSFRUIT_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_MEGAHATTER_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.MEGAMORH_MUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_ASTER_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.ASTER_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_BROC_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.BROC_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_THISTLE_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.THISTLE_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(35),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_DEAD_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.DEAD_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(22),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_SOOTFLOWER_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.SOOTFLOWER_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(25),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_HOLLYHOCK_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.HOLLYHOCK_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(17),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_FEVERBLOSSOM_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.FEVERBLOSSOM_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(26),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_CRACKBERRY_BUSH_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.CRACKBERRY_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(31),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_MUTTFRUIT_BUSH_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.MUTTFRUIT_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(25),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_BRAINFUNGUS_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.BRAINFUNGUS_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(22),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_GLOWFUNGUS_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.GLOWFUNGUS_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(25),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_GUTFUNGI_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.GUTFUNGI_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(18),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_BOMBBERRY_BUSH_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.BOMBBERRY_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_QUANTUMLEAF_BUSH_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.QUANTUMLEAF_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(21),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_NEUTRON_BUSH_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.NEUTRON_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(23),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_MINDFUNGUS_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.MINDFUNGUS_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(17),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_RADASTER_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.RADASTER_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(28),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_RADROSE_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.RADROSE_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_BLASTCAP_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.BLASTCAP_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(23),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_FIREFUNGI_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.FIREFUNGI_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(21),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_INVERT_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.INVERT_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(25),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_BOOMBLOSSOM_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.BOOMBLOSSOM_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(21),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));


        context.register(PATCH_CRANBERRY,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.CRANBERRY_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(22),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));


        context.register(PATCH_STARBERRY,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.STARBERRY_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(21),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        //
        context.register(PATCH_GINS,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.PATCH_GINS_BUSH), List.of(
                        RarityFilter.onAverageOnceEvery(19),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_DATURANS,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.PATCH_DEAD_DATURAN), List.of(
                        RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_PUNGA,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.PATCH_DEAD_PUNGA), List.of(
                        RarityFilter.onAverageOnceEvery(10),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_CORALL,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.PATCH_DEAD_CORAL), List.of(
                        RarityFilter.onAverageOnceEvery(6),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        //
        context.register(PATCH_AGAVE_RARE,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.PATCH_AGAVE_BUSH), List.of(
                        RarityFilter.onAverageOnceEvery(10),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));


        context.register(PATCH_SITTBEAN_BUSH,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.PATCH_SITTBEANS), List.of(
                        RarityFilter.onAverageOnceEvery(17),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_BLOODLEAF,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.PATCH_BLOODLEAF), List.of(
                        RarityFilter.onAverageOnceEvery(9),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        //
//
        context.register(PATCH_ZANDER,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.PATCH_XANDER), List.of(
                        RarityFilter.onAverageOnceEvery(21),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_RUSTY_BUSH,
                new PlacedFeature(features.getOrThrow(
                        ModFeatures.PATCH_RUSTY_BUSH), List.of(
                        RarityFilter.onAverageOnceEvery(25),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
    }

    public static List<PlacementModifier> worldSurfaceSquaredWithCount(int pCount) {
        return List.of(CountPlacement.of(pCount), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, nukaResource(name));
    }
}
