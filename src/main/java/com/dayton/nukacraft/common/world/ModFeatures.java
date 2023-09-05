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
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CRACK_BUSH = FeatureUtils.register("patch_crackbush_features",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.CRACKBERRY_BUSH.get()), 2));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BOMB_BUSH = FeatureUtils.register("patch_bombbush_features",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.BOMBBERRY_BUSH.get()), 2));
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
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> POISONVALLEY_FLOWER = FeatureUtils.register("poison_valley_flower_features",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.ASTER.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.FEVERBLOSSOM.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.FIREMUSHROOM.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.MARYGOLD.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.ASHROSE.get().defaultBlockState(), 1)), 50));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BLOODLEAF = FeatureUtils.register("patch_bloodleaf_features",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.BLOODLEAF_BUSH.get()), 1));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_QUANTLEAF = FeatureUtils.register("patch_quantleaf_features",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.QUANTUMLEAF_BUSH.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_HOLLYHCOCK = FeatureUtils.register("patch_hollys",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.HOLLYHOCK.get()), 1));


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ASHHEAP_FLOWER = FeatureUtils.register("ash_heap_flower_features",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.GUTSHROOM.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.ASHROSE.get().defaultBlockState(), 1)
                    .add(ModBlocksClass.BROC.get().defaultBlockState(), 1)), 50));


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

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_NEUTRONROD = FeatureUtils.register("patch_neutronrod",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.NEUTRON_BUSH.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_SITTBEANS = FeatureUtils.register("patch_sittbeans",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.SITTBEAN_BUSH.get()), 1));



    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_THISTLE = FeatureUtils.register("patch_thistle",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.THISTLE.get()), 2));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_ASHGRASS = FeatureUtils.register("patch_ashgrass",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.ASHGRASS.get()), 22));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_MUTTFRUIT = FeatureUtils.register("patch_muttfruit",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.MUTTFRUIT_BUSH.get()), 1));


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CRANBERRY = FeatureUtils.register("patch_cranberry",
            Feature.FLOWER, vegetationPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(ModBlocksClass.CRANBERRY.get().defaultBlockState(), 3)
                    .add(ModBlocksClass.STARBERRY.get().defaultBlockState(), 1)), 50));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_STARBERRY = FeatureUtils.register("patch_starberry",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.STARBERRY.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BRAINFUNGUS = FeatureUtils.register("patch_brainfungus",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.BRAINFUNGUS.get()), 1));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_MINDFUNGUS = FeatureUtils.register("patch_mindfungus",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.MINDFUNGUS.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GLOWFUNGUS = FeatureUtils.register("patch_glowfungus",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.GLOWFUNGUS.get()), 1));
    private static RandomPatchConfiguration vegetationPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(p_195203_)));
    }
    public static List<PlacementModifier> seagrassPlacement(int pCount) {
        return List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, CountPlacement.of(pCount), BiomeFilter.biome());
    }
}
