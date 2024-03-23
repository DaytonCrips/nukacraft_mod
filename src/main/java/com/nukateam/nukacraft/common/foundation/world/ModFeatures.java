package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModFeatures {


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BOGPAD =
            FeatureUtils.register("patch_bogpad",
                    Feature.RANDOM_PATCH,
                    new RandomPatchConfiguration(12, 8, 5,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BOGPAD.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ASTER_PLANT =
            FeatureUtils.register("aster_plant_features",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocks.ASTER.get().defaultBlockState(), 1)), 30));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DEWDROP_SAPLING_PLANT =
            FeatureUtils.register("dewdrop_sapling_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.DEWDROP_SAPLING.get().defaultBlockState(), 2)), 25));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> TOXIC_FERN_PLANT =
            FeatureUtils.register("toxic_fern_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.TOXICFERN.get().defaultBlockState(), 1)), 15));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BROC_PLANT =
            FeatureUtils.register("broc_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.BROC.get().defaultBlockState(), 1)), 20));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> THISTLE_PLANT =
            FeatureUtils.register("thistle_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.THISTLE.get().defaultBlockState(), 3)
                            .add(ModBlocks.ASHGRASS.get().defaultBlockState(), 7)), 20));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> DEAD_PLANT =
            FeatureUtils.register("dead_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.DEAD_PLANT.get().defaultBlockState(), 1)), 50));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SOOTFLOWER_PLANT =
            FeatureUtils.register("sootflower_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.SOOTFLOWER.get().defaultBlockState(), 1)), 20));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> HOLLYHOCK_PLANT =
            FeatureUtils.register("hollyhock_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.HOLLYHOCK.get().defaultBlockState(), 1)), 20));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FEVERBLOSSOM_PLANT =
            FeatureUtils.register("feverblossom_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.FEVERBLOSSOM.get().defaultBlockState(), 1)), 20));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CRACKBERRY_BUSH_PLANT =
            FeatureUtils.register("crackberry_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.CRACKBERRY_BUSH.get().defaultBlockState(), 1)), 15));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MUTTFRUIT_BUSH_PLANT =
            FeatureUtils.register("muttfruit_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.MUTTFRUIT_BUSH.get().defaultBlockState(), 1)), 10));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BRAINFUNGUS_PLANT =
            FeatureUtils.register("brainfungus_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.BRAINFUNGUS.get().defaultBlockState(), 1)), 20));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> GLOWFUNGUS_PLANT =
            FeatureUtils.register("glowfungus_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.GLOWFUNGUS.get().defaultBlockState(), 3)), 10));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> GUTFUNGI_PLANT =
            FeatureUtils.register("gutfungus_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.GUTFUNGI.get().defaultBlockState(), 1)), 10));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BOMBBERRY_BUSH_PLANT =
            FeatureUtils.register("bomberry_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.BOMBBERRY_BUSH.get().defaultBlockState(), 1)), 10));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FUSFRUIT_BUSH_PLANT =
            FeatureUtils.register("fusfruit_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.FUSFRUIT_BUSH.get().defaultBlockState(), 1)), 8));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MEGAMORH_MUSH_PLANT =
            FeatureUtils.register("megamorph_mush_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.MEGAHATTERFUNGI.get().defaultBlockState(), 1)), 12));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> QUANTUMLEAF_BUSH_PLANT =
            FeatureUtils.register("quantleaf_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.QUANTUMLEAF_BUSH.get().defaultBlockState(), 1)), 10));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NEUTRON_BUSH_PLANT =
            FeatureUtils.register("neutron_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.NEUTRON_BUSH.get().defaultBlockState(), 1)), 10));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MINDFUNGUS_PLANT =
            FeatureUtils.register("mindfungus_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.MINDFUNGUS.get().defaultBlockState(), 1)), 10));


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DEAD_DATURAN =
            FeatureUtils.register("deaddaturan_plant_features",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.DEAD_DATURAN.get()), 2));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DEAD_PUNGA =
            FeatureUtils.register("deadpunga_plant_features",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.DEAD_PUNGA.get()), 2));


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DEAD_CORAL =
            FeatureUtils.register("deadcoral_plant_features",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.DEAD_CORALLEAF.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_AGAVE_BUSH =
            FeatureUtils.register("agave_plant_features",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.AGAVE.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GINS_BUSH =
            FeatureUtils.register("gins_plant_features",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.GINSENG.get()), 1));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BLOODLEAF =
            FeatureUtils.register("bloodleaf_plant_features",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.BLOODLEAF_BUSH.get()), 1));



    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> RADASTER_PLANT =
            FeatureUtils.register("radaster_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.RADASTER.get().defaultBlockState(), 1)), 30));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> RADROSE_PLANT =
            FeatureUtils.register("radrose_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.RADROSE.get().defaultBlockState(), 1)), 20));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BLASTCAP_PLANT =
            FeatureUtils.register("blastcap_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.BLASTCAP.get().defaultBlockState(), 1)), 20));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FIREFUNGI_PLANT =
            FeatureUtils.register("firefungi_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.FIREMUSHROOM.get().defaultBlockState(), 1)), 18));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> INVERT_PLANT =
            FeatureUtils.register("invert_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.INVERT.get().defaultBlockState(), 1)), 10));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> BOOMBLOSSOM_PLANT =
            FeatureUtils.register("boomblossom_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.BOOMBLOSSOM.get().defaultBlockState(), 1)), 30));



    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_XANDER =
            FeatureUtils.register("patch_xander",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.ZANDER.get()), 1));
//    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_RUSTY_BUSH =
//            FeatureUtils.register("patch_rusty_bush",
//                    Feature.RANDOM_PATCH,
//                    vegetationPatch(BlockStateProvider.simple(ModBlocks.RUSTY_BUSH.get()), 2));
//    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BBLIGHT = FeatureUtils.register("patch_bblight",
//            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocks.BBLIGHT.get()), 1));



    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GLOWGRASS =
            FeatureUtils.register("patch_glowgrass",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.GLOW_GRASS.get()), 36));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CRANGRASS =
            FeatureUtils.register("patch_crangrass",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.CRANBERRY_GRASS.get()), 19));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_SITTBEANS =
            FeatureUtils.register("patch_sittbeans",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.SITTBEAN_BUSH.get()), 1));





    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_ASHGRASS =
            FeatureUtils.register("patch_ashgrass",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.ASHGRASS.get()), 32));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_POISONGRASS =
            FeatureUtils.register("patch_poisongrass",
            Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.POISONGRASS.get()), 66));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_HEAP_GRASS =
            FeatureUtils.register("patch_heapgrass",
                    Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.HEAP_GRASS.get()), 26));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_RUSTY_BUSH =
            FeatureUtils.register("patch_rustybush",
                    Feature.RANDOM_PATCH,
                    vegetationPatch(BlockStateProvider.simple(ModBlocks.RUSTY_BUSH.get()), 12));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> STARBERRY_PLANT =
            FeatureUtils.register("starberry_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.STARBERRY.get().defaultBlockState(), 2)), 31));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> CRANBERRY_PLANT =
            FeatureUtils.register("cranberry_plant_features",
                    Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(ModBlocks.CRANBERRY.get().defaultBlockState(), 3)), 40));










    private static RandomPatchConfiguration vegetationPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(p_195203_)));
    }

}
