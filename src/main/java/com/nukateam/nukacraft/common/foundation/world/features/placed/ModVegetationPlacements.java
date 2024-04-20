package com.nukateam.nukacraft.common.foundation.world.features.placed;

import com.nukateam.nukacraft.common.foundation.world.features.configured.ModVegetationFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModVegetationPlacements {
    public static final ResourceKey<PlacedFeature> PATCH_DEWDROP_SAPLING_PLACE = registerKey("patch_dewdrop_sapling_place");
    public static final ResourceKey<PlacedFeature> PATCH_BOGPAD_PLACE = registerKey("patch_bogpad_place");
    public static final ResourceKey<PlacedFeature> PATCH_TOXIC_FERN_PLACE = registerKey("patch_toxic_fern_place");
    public static final ResourceKey<PlacedFeature> PATCH_FUSION_FRUIT_PLACE = registerKey("patch_fusion_fruit_place");
    public static final ResourceKey<PlacedFeature> PATCH_MEGA_HATTER_PLACE = registerKey("patch_mega_hatter_place");
    public static final ResourceKey<PlacedFeature> PATCH_ASTER_PLANT_PLACE = registerKey("patch_aster_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BROC_PLANT_PLACE = registerKey("patch_broc_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_THISTLE_PLANT_PLACE = registerKey("patch_thistle_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_DEAD_PLANT_PLACE = registerKey("patch_dead_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_SOOT_FLOWER_PLANT_PLACE = registerKey("patch_soot_flower_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_HOLLYHOCK_PLANT_PLACE = registerKey("patch_hollyhock_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_FEVER_BLOSSOM_PLANT_PLACE = registerKey("patch_fever_blossom_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_CRACKBERRY_BUSH_PLACE = registerKey("patch_crackberry_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_MUTTFRUIT_BUSH_PLACE = registerKey("patch_muttfruit_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BRAIN_FUNGUS_PLACE = registerKey("patch_brain_fungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_GLOW_FUNGUS_PLACE = registerKey("patch_glow_fungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_GUT_FUNGI_PLACE = registerKey("patch_gut_fungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BOMB_BERRY_BUSH_PLACE = registerKey("patch_bomb_berry_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_QUANTUM_LEAF_BUSH_PLACE = registerKey("patch_quantum_leaf_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_NEUTRON_BUSH_PLACE = registerKey("patch_neutron_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_MIND_FUNGUS_PLACE = registerKey("patch_mind_fungus_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_RADASTER_PLANT_PLACE = registerKey("patch_radaster_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_RADROSE_PLANT_PLACE = registerKey("patch_radrose_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BLAST_CAP_PLACE = registerKey("patch_blast_cap_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_FIRE_FUNGI_PLACE = registerKey("patch_fire_fungi_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_INVERT_PLANT_PLACE = registerKey("patch_invert_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_BOOM_BLOSSOM_PLANT_PLACE = registerKey("patch_boom_blossom_plant_place");
    public static final ResourceKey<PlacedFeature> PATCH_CRANBERRY_PLACE = registerKey("patch_cranberry_place");
    public static final ResourceKey<PlacedFeature> PATCH_STARLIGHT_BERRY = registerKey("patch_starlight_berry");
    //
    public static final ResourceKey<PlacedFeature> PATCH_GINS = registerKey("patch_gins_common");
    public static final ResourceKey<PlacedFeature> PATCH_DATURANA = registerKey("patch_daturana_common");
    public static final ResourceKey<PlacedFeature> PATCH_PUNGA = registerKey("patch_punga_common");
    public static final ResourceKey<PlacedFeature> PATCH_CORAL = registerKey("patch_coral_common");
    //
    public static final ResourceKey<PlacedFeature> PATCH_AGAVE_RARE = registerKey("patch_agave_common");
    public static final ResourceKey<PlacedFeature> PATCH_SLIT_BEAN_BUSH = registerKey("patch_slit_bean_bush");
    public static final ResourceKey<PlacedFeature> PATCH_BLOOD_LEAF = registerKey("patch_blood_leaf_common");
    //
    public static final ResourceKey<PlacedFeature> PATCH_ZANDER = registerKey("patch_zander");
    public static final ResourceKey<PlacedFeature> PATCH_RUSTY_BUSH = registerKey("patch_rusty_bush");
    public static final ResourceKey<PlacedFeature> ASH_GRASS = registerKey("ash_grass");
    public static final ResourceKey<PlacedFeature> POISON_GRASS = registerKey("poison_grass");
    public static final ResourceKey<PlacedFeature> CRANBERRY_GRASS = registerKey("cranberry_grass");
    public static final ResourceKey<PlacedFeature> GRASS_ASH = registerKey("grass_ash");
    public static final ResourceKey<PlacedFeature> GLOW_GRASS = registerKey("glow_grass");
    public static final ResourceKey<PlacedFeature> HEAP_GRASS = registerKey("heap_grass");
    public static final ResourceKey<PlacedFeature> RUSTY_BUSH = registerKey("rusty_bush_patch");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var features = context.lookup(Registries.CONFIGURED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(PATCH_DEWDROP_SAPLING_PLACE, new PlacedFeature(features.getOrThrow(ModVegetationFeatures.DEWDROP_SAPLING_PLANT),
                List.of(RarityFilter.onAverageOnceEvery(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())
        ));

        context.register(PATCH_BOGPAD_PLACE, new PlacedFeature(features.getOrThrow(
                ModVegetationFeatures.PATCH_BOGPAD), worldSurfaceSquaredWithCount(5)));

        context.register(PATCH_TOXIC_FERN_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.TOXIC_FERN_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_FUSION_FRUIT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.FUSFRUIT_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_MEGA_HATTER_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.MEGAMORH_MUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_ASTER_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.ASTER_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(3),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_BROC_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.BROC_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(4),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_THISTLE_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.THISTLE_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(35),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_DEAD_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.DEAD_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(22),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_SOOT_FLOWER_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.SOOT_FLOWER_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(25),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_HOLLYHOCK_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.HOLLYHOCK_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(17),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_FEVER_BLOSSOM_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.FEVER_BLOSSOM_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(26),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_CRACKBERRY_BUSH_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.CRACKBERRY_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(31),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_MUTTFRUIT_BUSH_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.MUTTFRUIT_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(25),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_BRAIN_FUNGUS_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.BRAIN_FUNGUS_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(22),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_GLOW_FUNGUS_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.GLOW_FUNGUS_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(25),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_GUT_FUNGI_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.GUT_FUNGI_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(18),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_BOMB_BERRY_BUSH_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.BOMBBERRY_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_QUANTUM_LEAF_BUSH_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.QUANTUMLEAF_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(21),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_NEUTRON_BUSH_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.NEUTRON_BUSH_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(23),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_MIND_FUNGUS_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.MINDFUNGUS_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(17),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_RADASTER_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.RADASTER_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(28),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_RADROSE_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.RADROSE_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_BLAST_CAP_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.BLASTCAP_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(23),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_FIRE_FUNGI_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.FIREFUNGI_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(21),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_INVERT_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.INVERT_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(25),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_BOOM_BLOSSOM_PLANT_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.BOOMBLOSSOM_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(21),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));


        context.register(PATCH_CRANBERRY_PLACE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.CRANBERRY_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(22),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));


        context.register(PATCH_STARLIGHT_BERRY,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.STARLIGHT_BERRY_PLANT), List.of(
                        RarityFilter.onAverageOnceEvery(21),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        //
        context.register(PATCH_GINS,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.PATCH_GINS_BUSH), List.of(
                        RarityFilter.onAverageOnceEvery(19),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_DATURANA,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.PATCH_DEAD_DATURAN), List.of(
                        RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_PUNGA,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.PATCH_DEAD_PUNGA), List.of(
                        RarityFilter.onAverageOnceEvery(10),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        context.register(PATCH_CORAL,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.PATCH_DEAD_CORAL), List.of(
                        RarityFilter.onAverageOnceEvery(6),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        //
        context.register(PATCH_AGAVE_RARE,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.PATCH_AGAVE_BUSH), List.of(
                        RarityFilter.onAverageOnceEvery(10),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));


        context.register(PATCH_SLIT_BEAN_BUSH,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.PATCH_SLIT_BEANS), List.of(
                        RarityFilter.onAverageOnceEvery(17),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_BLOOD_LEAF,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.PATCH_BLOODLEAF), List.of(
                        RarityFilter.onAverageOnceEvery(9),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));
        //
//
        context.register(PATCH_ZANDER,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.PATCH_XANDER), List.of(
                        RarityFilter.onAverageOnceEvery(21),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(PATCH_RUSTY_BUSH,
                new PlacedFeature(features.getOrThrow(
                        ModVegetationFeatures.PATCH_RUSTY_BUSH), List.of(
                        RarityFilter.onAverageOnceEvery(25),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())));

        context.register(HEAP_GRASS, new PlacedFeature(features.getOrThrow(ModVegetationFeatures.PATCH_HEAP_GRASS),
                        List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(RUSTY_BUSH, new PlacedFeature(features.getOrThrow(ModVegetationFeatures.PATCH_RUSTY_BUSH),
                        List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(GLOW_GRASS, new PlacedFeature(features.getOrThrow(ModVegetationFeatures.PATCH_GLOW_GRASS),
                        List.of(NoiseThresholdCountPlacement.of(-0.8D, 3, 3),
                                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(GRASS_ASH, new PlacedFeature(features.getOrThrow(VegetationFeatures.PATCH_GRASS),
                        List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4),
                                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(CRANBERRY_GRASS, new PlacedFeature(features.getOrThrow(ModVegetationFeatures.PATCH_CRANBERRY_GRASS),
                        List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 12),
                                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(ASH_GRASS, new PlacedFeature(features.getOrThrow(ModVegetationFeatures.PATCH_ASH_GRASS),
                        List.of(NoiseThresholdCountPlacement.of(-0.3D, 2, 1),
                                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );

        context.register(POISON_GRASS, new PlacedFeature(features.getOrThrow(ModVegetationFeatures.PATCH_POISON_GRASS),
                        List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                                InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
                )
        );
    }

    public static List<PlacementModifier> worldSurfaceSquaredWithCount(int pCount) {
        return List.of(CountPlacement.of(pCount), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, nukaResource(name));
    }
}
