package com.nukateam.nukacraft.common.foundation.world.features;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.foundation.world.trees.ModTrees;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Music;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public final class ModConfiguredFeatures {
	//Trees
	public static final ResourceKey<ConfiguredFeature<?, ?>> ASH_HEAP_TREE = registerKey("tree_ash_heap");
	public static final ResourceKey<ConfiguredFeature<?, ?>> GLOW_TREE = registerKey("tree_glow");
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_DEWDROP = registerKey("tree_dewdrop");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ASH_TREE = registerKey("tree_ash");


	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, nukaResource(name));
	}

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		context.register(ASH_HEAP_TREE	, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_ASH_HEAP));
		context.register(GLOW_TREE		, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_GLOW));
		context.register(TREE_DEWDROP	, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_DEWDROP));
		context.register(ASH_TREE		, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_ASH));
	}

	private static void registerTemplateFeatures(BootstapContext<ConfiguredFeature<?, ?>> context) {
//		HolderGetter<WoodPalette> paletteHolders = context.lookup(TFRegistries.Keys.WOOD_PALETTES);
//		var paletteChoices = SwizzleConfig.buildRarityPalette(paletteHolders);
//
//		ProcessorRule processorCobbleBlock = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.defaultBlockState());
//		ProcessorRule processorCobbleStair = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE_STAIRS, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE_STAIRS.defaultBlockState());
//		ProcessorRule processorCobbleSlab = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE_SLAB, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE_SLAB.defaultBlockState());
//		ProcessorRule processorCobbleWall = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE_WALL, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE_WALL.defaultBlockState());
//
//		ProcessorRule processorStoneBrickBlock = new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.defaultBlockState());
//		ProcessorRule processorStoneBrickStair = new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_STAIRS, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState());
//		ProcessorRule processorStoneBrickSlab = new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_SLAB, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICK_SLAB.defaultBlockState());
//		ProcessorRule processorStoneBrickWall = new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_WALL, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICK_WALL.defaultBlockState());
//
//		SwizzleConfig simpleWellConfig = SwizzleConfig.generate(paletteHolders, CustomTagGenerator.WoodPaletteTagGenerator.WELL_SWIZZLE_MASK, paletteChoices, processorCobbleBlock, processorCobbleStair, processorCobbleSlab, processorCobbleWall);
//		context.register(SIMPLE_WELL, new ConfiguredFeature<>(TFFeatures.SIMPLE_WELL.get(), simpleWellConfig));
//
//		SwizzleConfig fancyWellConfig = SwizzleConfig.generate(paletteHolders, CustomTagGenerator.WoodPaletteTagGenerator.WELL_SWIZZLE_MASK, paletteChoices, processorCobbleBlock, processorCobbleStair, processorCobbleSlab, processorCobbleWall, processorStoneBrickBlock, processorStoneBrickStair, processorStoneBrickSlab, processorStoneBrickWall);
//		context.register(FANCY_WELL, new ConfiguredFeature<>(TFFeatures.FANCY_WELL.get(), fancyWellConfig));
//
//		SwizzleConfig hutConfig = SwizzleConfig.generate(paletteHolders, CustomTagGenerator.WoodPaletteTagGenerator.DRUID_HUT_SWIZZLE_MASK, paletteChoices, processorCobbleBlock, processorCobbleStair, processorCobbleSlab, processorCobbleWall, processorStoneBrickBlock, processorStoneBrickStair, processorStoneBrickSlab, processorStoneBrickWall);
//		context.register(DRUID_HUT, new ConfiguredFeature<>(TFFeatures.DRUID_HUT.get(), hutConfig));
//
//		context.register(GRAVEYARD, new ConfiguredFeature<>(TFFeatures.GRAVEYARD.get(), FeatureConfiguration.NONE));
	}
}