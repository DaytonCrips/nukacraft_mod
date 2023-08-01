package com.dayton.nukacraft.common.world.gen;

import com.dayton.nukacraft.init.blocks.ModBlocksClass;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModFeatures {
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CRACK_BUSH = FeatureUtils.register("patch_crackbush",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.CRACKBERRY_BUSH.get()), 2));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GLOWGRASS = FeatureUtils.register("patch_glowgrass",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.GLOW_GRASS.get()), 26));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BLOODLEAF = FeatureUtils.register("patch_bloodleaf",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.BLOODLEAF_BUSH.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CRANGRASS = FeatureUtils.register("patch_crangrass",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.CRANBERRY_GRASS.get()), 19));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_ASTER = FeatureUtils.register("patch_aster",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.ASTER.get()), 2));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_SITTBEANS = FeatureUtils.register("patch_sittbeans",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.SITTBEAN_BUSH.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_FEVERBLOSM = FeatureUtils.register("patch_feverblossom",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.FEVERBLOSSOM.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_FIREMUSH = FeatureUtils.register("patch_firemush",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.FIREMUSHROOM.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_ASHROSE = FeatureUtils.register("patch_ashrose",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.ASHROSE.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_THISTLE = FeatureUtils.register("patch_thistle",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.THISTLE.get()), 2));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_WILDTATO = FeatureUtils.register("patch_wildtato",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.WILDTATO.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_ASHGRASS = FeatureUtils.register("patch_ashgrass",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.ASHGRASS.get()), 22));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_SOOTFLOWER = FeatureUtils.register("patch_sootflower",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.SOOTFLOWER.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_MUTTFRUIT = FeatureUtils.register("patch_muttfruit",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.MUTTFRUIT_BUSH.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CRANBERRY = FeatureUtils.register("patch_cranberry",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.CRANBERRY.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_STARBERRY = FeatureUtils.register("patch_starberry",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.STARBERRY.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BRAINFUNGUS = FeatureUtils.register("patch_brainfungus",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.BRAINFUNGUS.get()), 1));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GLOWFUNGUS = FeatureUtils.register("patch_glowfungus",
            Feature.RANDOM_PATCH, vegetationPatch(BlockStateProvider.simple(ModBlocksClass.GLOWFUNGUS.get()), 1));
    private static RandomPatchConfiguration vegetationPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(p_195203_)));
    }
}
