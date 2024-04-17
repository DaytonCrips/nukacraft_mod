package com.nukateam.nukacraft.common.foundation.world.features;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.fluid.ModFluids;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

import static com.nukateam.nukacraft.common.registery.ModBlocks.ACID_DIRT;

public class OreFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, NukaCraftMod.MOD_ID);

    public static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ALUMI_PLACE        = FeatureUtils.createKey("ore_alumi_place");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_LEAD_PLACE         = FeatureUtils.createKey("ore_lead_place");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SILVER_PLACE       = FeatureUtils.createKey("ore_silver_place");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_BTITAN_PLACE       = FeatureUtils.createKey("ore_btitan_place");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ULTRACITE_PLACE    = FeatureUtils.createKey("ore_ultracite_place");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_URAN_PLACE         = FeatureUtils.createKey("ore_uranium_place");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
        FeatureUtils.register(pContext, ORE_ALUMI_PLACE, Feature.ORE, new OreConfiguration(
                List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES,
                                ModBlocks.ALUMI_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES,
                                ModBlocks.DEEPALUMI.get().defaultBlockState())), 4));

        FeatureUtils.register(pContext, ORE_LEAD_PLACE      , Feature.ORE,
                new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.LEAD_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEP_LEAD_ORE.get().defaultBlockState())), 7));

        FeatureUtils.register(pContext, ORE_SILVER_PLACE    , Feature.ORE,
                new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSILVER.get().defaultBlockState())), 5));

        FeatureUtils.register(pContext, ORE_BTITAN_PLACE    ,
                Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.BTITAN_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPBTITAN.get().defaultBlockState())), 11));

        FeatureUtils.register(pContext, ORE_ULTRACITE_PLACE , Feature.ORE,
                new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.ULTRACITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPULTRACITE.get().defaultBlockState())), 9));

        FeatureUtils.register(pContext, ORE_URAN_PLACE      , Feature.ORE,
                new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocks.URAN_ORE.get().defaultBlockState()),
                        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEP_URAN_ORE.get().defaultBlockState())), 8));
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier modifier) {
        return List.of(p_195347_, InSquarePlacement.spread(), modifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

}
