package com.dayton.nukacraft.common.world;

import com.dayton.nukacraft.common.blocks.ModBlocksClass;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModFeatures {



    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WASTELAND_FLOWER_COMMON = FeatureUtils.register("wasteland_flower_common_features",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.ASTER.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.BROC.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.MARYGOLD.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.ASHROSE.get().defaultBlockState(), 1)), 50));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WASTELAND_FLOWER_RARE = FeatureUtils.register("wasteland_flower_rare_features",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.SOOTFLOWER.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.HOLLYHOCK.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.FEVERBLOSSOM.get().defaultBlockState(), 1)), 20));



    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WASTELAND_BERRYS = FeatureUtils.register("wasteland_berrys_features",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.CRACKBERRY_BUSH.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.MUTTFRUIT_BUSH.get().defaultBlockState(), 1)), 20));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_THISTLE = FeatureUtils.register("patch_thistle",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.THISTLE.get().defaultBlockState(), 3)
                    .add(ModBlocksClass.ASHGRASS.get().defaultBlockState(), 7)), 20));



    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WASTELAND_MUSHROOMS_COMMON = FeatureUtils.register("wasteland_mushrooms_features",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.BRAINFUNGUS.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.GLOWFUNGUS.get().defaultBlockState(), 3)
                    .add(ModBlocksClass.GUTSHROOM.get().defaultBlockState(), 1)), 20));



    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> WASTELAND_EXOTICS = FeatureUtils.register("wasteland_exotics_features",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.BOMBBERRY_BUSH.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.QUANTUMLEAF_BUSH.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.NEUTRON_BUSH.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.MINDFUNGUS.get().defaultBlockState(), 1)), 20));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DEAD_DATURAN = FeatureUtils.register("patch_deaddaturan_features",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.DEAD_DATURAN.get()), 2));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DEAD_PUNGA = FeatureUtils.register("patch_deadpunga_features",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.DEAD_PUNGA.get()), 2));


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DEAD_CORAL = FeatureUtils.register("patch_deadcoral_features",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.DEAD_CORALLEAF.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_AGAVE_BUSH = FeatureUtils.register("patch_agave_features",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.AGAVE.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GINS_BUSH = FeatureUtils.register("patch_gins_features",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.GINSENG.get()), 1));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BLOODLEAF = FeatureUtils.register("patch_bloodleaf_features",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.BLOODLEAF_BUSH.get()), 1));






    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> GLOWSEA_FLOWER = FeatureUtils.register("glowsea_flower_features",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.RADASTER.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.RADROSE.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.BLASTCAP.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.INVERT.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.BOOMBLOSSOM.get().defaultBlockState(), 1)), 50));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_XANDER = FeatureUtils.register("patch_xander",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.ZANDER.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BBLIGHT = FeatureUtils.register("patch_bblight",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.BBLIGHT.get()), 1));



    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GLOWGRASS = FeatureUtils.register("patch_glowgrass",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.GLOW_GRASS.get()), 26));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CRANGRASS = FeatureUtils.register("patch_crangrass",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.CRANBERRY_GRASS.get()), 19));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_SITTBEANS = FeatureUtils.register("patch_sittbeans",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.SITTBEAN_BUSH.get()), 1));





    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_ASHGRASS = FeatureUtils.register("patch_ashgrass",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.ASHGRASS.get()), 22));



    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CRANBERRY = FeatureUtils.register("patch_cranberry",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.CRANBERRY.get().defaultBlockState(), 3)
                    .add(ModBlocksClass.STARBERRY.get().defaultBlockState(), 1)), 50));




    private static RandomPatchConfiguration vegetationPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(p_195203_)));
    }

}
