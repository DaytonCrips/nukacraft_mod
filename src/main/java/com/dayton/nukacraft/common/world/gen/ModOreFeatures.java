package com.dayton.nukacraft.common.world.gen;

import com.dayton.nukacraft.init.blocks.ModBlocksClass;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModOreFeatures {



    public static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ALUMI_PLACE = FeatureUtils.register("ore_alumi_place", Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocksClass.ALUMI_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocksClass.DEEPALUMI.get().defaultBlockState())), 4));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_LEAD_PLACE = FeatureUtils.register("ore_lead_place", Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocksClass.LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocksClass.DEEPLEAD.get().defaultBlockState())), 7));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SILVER_PLACE = FeatureUtils.register("ore_silver_place", Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocksClass.SILVER_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocksClass.DEEPSILVER.get().defaultBlockState())), 5));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_BTITAN_PLACE = FeatureUtils.register("ore_btitan_place", Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_ORE_REPLACEABLES, ModBlocksClass.BTITAN_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, ModBlocksClass.DEEPBTITAN.get().defaultBlockState())), 5));





    public static final Holder<PlacedFeature> ORE_ALUMI = PlacementUtils.register("ore_alumi", ORE_ALUMI_PLACE, commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
    public static final Holder<PlacedFeature> ORE_LEAD = PlacementUtils.register("ore_lead", ORE_LEAD_PLACE, commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(45))));
    public static final Holder<PlacedFeature> ORE_SILVER = PlacementUtils.register("ore_silver", ORE_SILVER_PLACE, commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(20))));
    public static final Holder<PlacedFeature> ORE_BTITAN = PlacementUtils.register("ore_btitan", ORE_BTITAN_PLACE, commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(11))));



    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }
    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }
}
