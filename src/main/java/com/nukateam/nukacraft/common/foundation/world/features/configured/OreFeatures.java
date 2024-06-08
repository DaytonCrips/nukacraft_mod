package com.nukateam.nukacraft.common.foundation.world.features.configured;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class OreFeatures {
    public static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ALUMINIUM_PLACE = registerKey("ore_aluminium_place");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LEAD_PLACE = registerKey("ore_lead_place");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SILVER_PLACE = registerKey("ore_silver_place");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BLACK_TITAN_PLACE = registerKey("ore_black_titan_place");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ULTRACITE_PLACE = registerKey("ore_ultracite_place");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_URAN_PLACE = registerKey("ore_uranium_place");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
        FeatureUtils.register(pContext, ORE_ALUMINIUM_PLACE, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES,
                                ModBlocks.ALUMI_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES,
                                ModBlocks.DEEPALUMI.get().defaultBlockState())), 4));

        FeatureUtils.register(pContext, ORE_LEAD_PLACE, Feature.ORE,
                new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.LEAD_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEP_LEAD_ORE.get().defaultBlockState())), 7));

        FeatureUtils.register(pContext, ORE_SILVER_PLACE, Feature.ORE,
                new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSILVER.get().defaultBlockState())), 5));

        FeatureUtils.register(pContext, ORE_BLACK_TITAN_PLACE,
                Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.BTITAN_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPBTITAN.get().defaultBlockState())), 11));

        FeatureUtils.register(pContext, ORE_ULTRACITE_PLACE, Feature.ORE,
                new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.ULTRACITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEP_ULTRACITE.get().defaultBlockState())), 9));

        FeatureUtils.register(pContext, ORE_URAN_PLACE, Feature.ORE,
                new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.URAN_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEP_URAN_ORE.get().defaultBlockState())), 8));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, nukaResource(name));
    }
}
