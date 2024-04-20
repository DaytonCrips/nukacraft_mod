package com.nukateam.nukacraft.common.foundation.world.features.configured;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModVegetationFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BOGPAD =
            registerKey("patch_bogpad");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASTER_PLANT =
            registerKey("aster_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEWDROP_SAPLING_PLANT =
            registerKey("dewdrop_sapling_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TOXIC_FERN_PLANT =
            registerKey("toxic_fern_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BROC_PLANT =
            registerKey("broc_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> THISTLE_PLANT =
            registerKey("thistle_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PLANT =
            registerKey("dead_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SOOT_FLOWER_PLANT =
            registerKey("soot_flower_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLYHOCK_PLANT =
            registerKey("hollyhock_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FEVER_BLOSSOM_PLANT =
            registerKey("fever_blossom_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRACKBERRY_BUSH_PLANT =
            registerKey("crackberry_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MUTTFRUIT_BUSH_PLANT =
            registerKey("muttfruit_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> BRAIN_FUNGUS_PLANT =
            registerKey("brain_fungus_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOW_FUNGUS_PLANT =
            registerKey("glow_fungus_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GUT_FUNGI_PLANT =
            registerKey("gut_fungus_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOMBBERRY_BUSH_PLANT =
            registerKey("bomberry_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> FUSFRUIT_BUSH_PLANT =
            registerKey("fusfruit_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGAMORH_MUSH_PLANT =
            registerKey("megamorph_mush_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> QUANTUMLEAF_BUSH_PLANT =
            registerKey("quantleaf_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NEUTRON_BUSH_PLANT =
            registerKey("neutron_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MINDFUNGUS_PLANT =
            registerKey("mindfungus_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DEAD_DATURAN =
            registerKey("deaddaturan_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DEAD_PUNGA =
            registerKey("deadpunga_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DEAD_CORAL =
            registerKey("deadcoral_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_AGAVE_BUSH =
            registerKey("agave_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GINS_BUSH =
            registerKey("gins_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLOODLEAF =
            registerKey("bloodleaf_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> RADASTER_PLANT =
            registerKey("radaster_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RADROSE_PLANT =
            registerKey("radrose_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLASTCAP_PLANT =
            registerKey("blastcap_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FIREFUNGI_PLANT =
            registerKey("firefungi_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> INVERT_PLANT =
            registerKey("invert_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOOMBLOSSOM_PLANT =
            registerKey("boomblossom_plant_features");


    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_XANDER =
            registerKey("patch_xander");

//    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_RUSTY_BUSH =
//            registerKey("patch_rusty_bush",
//                    Feature.RANDOM_PATCH,
//                    vegetationPatch(BlockStateProvider.simple(ModBlocks.RUSTY_BUSH.get()), 2));

//    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BBLIGHT = registerKey("patch_bblight",
//            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocks.BBLIGHT.get()), 1));


    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLOW_GRASS =
            registerKey("patch_glow_grass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CRANBERRY_GRASS =
            registerKey("patch_cranberry_grass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SLIT_BEANS =
            registerKey("patch_slit_beans");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ASH_GRASS =
            registerKey("patch_ash_grass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_POISON_GRASS =
            registerKey("patch_poison_grass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_HEAP_GRASS =
            registerKey("patch_heap_grass");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_RUSTY_BUSH =
            registerKey("patch_rustybush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> STARLIGHT_BERRY_PLANT =
            registerKey("starberry_plant_features");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CRANBERRY_PLANT =
            registerKey("cranberry_plant_features");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
        FeatureUtils.register(pContext, PATCH_BOGPAD,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(12, 8, 5,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BOGPAD.get())))));

        FeatureUtils.register(pContext, ASTER_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.ASTER.get().defaultBlockState(), 1)), 30));

        FeatureUtils.register(pContext, DEWDROP_SAPLING_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.DEWDROP_SAPLING.get().defaultBlockState(), 2)), 25));

        FeatureUtils.register(pContext, TOXIC_FERN_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.TOXICFERN.get().defaultBlockState(), 1)), 15));

        FeatureUtils.register(pContext, BROC_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BROC.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, THISTLE_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.THISTLE.get().defaultBlockState(), 3)
                        .add(ModBlocks.ASHGRASS.get().defaultBlockState(), 7)), 20));

        FeatureUtils.register(pContext, DEAD_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.DEAD_PLANT.get().defaultBlockState(), 1)), 50));

        FeatureUtils.register(pContext, SOOT_FLOWER_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.SOOTFLOWER.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, HOLLYHOCK_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.HOLLYHOCK.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, FEVER_BLOSSOM_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.FEVERBLOSSOM.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, CRACKBERRY_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.CRACKBERRY_BUSH.get().defaultBlockState(), 1)), 15));

        FeatureUtils.register(pContext, MUTTFRUIT_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.MUTTFRUIT_BUSH.get().defaultBlockState(), 1)), 10));


        FeatureUtils.register(pContext, BRAIN_FUNGUS_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BRAINFUNGUS.get().defaultBlockState(), 1)), 20));


        FeatureUtils.register(pContext, GLOW_FUNGUS_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.GLOWFUNGUS.get().defaultBlockState(), 3)), 10));

        FeatureUtils.register(pContext, GUT_FUNGI_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.GUTFUNGI.get().defaultBlockState(), 1)), 10));

        FeatureUtils.register(pContext, BOMBBERRY_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BOMBBERRY_BUSH.get().defaultBlockState(), 1)), 10));


        FeatureUtils.register(pContext, FUSFRUIT_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.FUSFRUIT_BUSH.get().defaultBlockState(), 1)), 8));


        FeatureUtils.register(pContext, MEGAMORH_MUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.MEGAHATTERFUNGI.get().defaultBlockState(), 1)), 12));

        FeatureUtils.register(pContext, QUANTUMLEAF_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.QUANTUMLEAF_BUSH.get().defaultBlockState(), 1)), 10));

        FeatureUtils.register(pContext, NEUTRON_BUSH_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.NEUTRON_BUSH.get().defaultBlockState(), 1)), 10));

        FeatureUtils.register(pContext, MINDFUNGUS_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.MINDFUNGUS.get().defaultBlockState(), 1)), 10));


        FeatureUtils.register(pContext, PATCH_DEAD_DATURAN,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.DEAD_DATURAN.get()), 2));

        FeatureUtils.register(pContext, PATCH_DEAD_PUNGA,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.DEAD_PUNGA.get()), 2));


        FeatureUtils.register(pContext, PATCH_DEAD_CORAL,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.DEAD_CORALLEAF.get()), 1));

        FeatureUtils.register(pContext, PATCH_AGAVE_BUSH,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.AGAVE.get()), 1));

        FeatureUtils.register(pContext, PATCH_GINS_BUSH,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.GINSENG.get()), 1));


        FeatureUtils.register(pContext, PATCH_BLOODLEAF,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.BLOODLEAF_BUSH.get()), 1));


        FeatureUtils.register(pContext, RADASTER_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.RADASTER.get().defaultBlockState(), 1)), 30));

        FeatureUtils.register(pContext, RADROSE_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.RADROSE.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, BLASTCAP_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BLASTCAP.get().defaultBlockState(), 1)), 20));

        FeatureUtils.register(pContext, FIREFUNGI_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.FIREMUSHROOM.get().defaultBlockState(), 1)), 18));

        FeatureUtils.register(pContext, INVERT_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.INVERT.get().defaultBlockState(), 1)), 10));

        FeatureUtils.register(pContext, BOOMBLOSSOM_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.BOOMBLOSSOM.get().defaultBlockState(), 1)), 30));


        FeatureUtils.register(pContext, PATCH_XANDER,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.ZANDER.get()), 1));

//     FeatureUtils.register(pContext, PATCH_RUSTY_BUSH =
//            FeatureUtils.register(,
//                    Feature.RANDOM_PATCH,
//                    vegetationPatch(BlockStateProvider.simple(ModBlocks.RUSTY_BUSH.get()), 2));

//     FeatureUtils.register(pContext, PATCH_BBLIGHT = FeatureUtils.register(,
//            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocks.BBLIGHT.get()), 1));


        FeatureUtils.register(pContext, PATCH_GLOW_GRASS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.GLOW_GRASS.get()), 36));

        FeatureUtils.register(pContext, PATCH_CRANBERRY_GRASS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.CRANBERRY_GRASS.get()), 19));


        FeatureUtils.register(pContext, PATCH_SLIT_BEANS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.SITTBEAN_BUSH.get()), 1));


        FeatureUtils.register(pContext, PATCH_ASH_GRASS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.ASHGRASS.get()), 32));

        FeatureUtils.register(pContext, PATCH_POISON_GRASS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.POISONGRASS.get()), 66));

        FeatureUtils.register(pContext, PATCH_HEAP_GRASS,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.HEAP_GRASS.get()), 26));

        FeatureUtils.register(pContext, PATCH_RUSTY_BUSH,
                Feature.RANDOM_PATCH,
                vegetationPatch(BlockStateProvider.simple(ModBlocks.RUSTY_BUSH.get()), 12));


        FeatureUtils.register(pContext, STARLIGHT_BERRY_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.STARBERRY.get().defaultBlockState(), 2)), 31));

        FeatureUtils.register(pContext, CRANBERRY_PLANT,
                Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.CRANBERRY.get().defaultBlockState(), 3)), 40));

    }

    private static RandomPatchConfiguration vegetationPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(p_195203_)));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, nukaResource(name));
    }
}
