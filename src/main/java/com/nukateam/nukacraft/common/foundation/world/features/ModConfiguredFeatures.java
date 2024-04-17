package com.nukateam.nukacraft.common.foundation.world.features;

import com.google.common.collect.ImmutableList;
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

	//ground decoration
	public static final RandomPatchConfiguration SMALL_FLOWER_CONFIG = (new RandomPatchConfiguration(32, 7, 7,
			PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
					new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
							Blocks.POPPY.defaultBlockState(),
							Blocks.DANDELION.defaultBlockState(),
							Blocks.RED_TULIP.defaultBlockState(),
							Blocks.ORANGE_TULIP.defaultBlockState(),
							Blocks.PINK_TULIP.defaultBlockState(),
							Blocks.WHITE_TULIP.defaultBlockState(),
							Blocks.CORNFLOWER.defaultBlockState(),
							Blocks.LILY_OF_THE_VALLEY.defaultBlockState(),
							Blocks.BLUE_ORCHID.defaultBlockState(),
							Blocks.ALLIUM.defaultBlockState(),
							Blocks.AZURE_BLUET.defaultBlockState(),
							Blocks.OXEYE_DAISY.defaultBlockState())
					)), BlockPredicate.ONLY_IN_AIR_PREDICATE)));

	public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PLACER = registerKey("flower_placer");

	public static final RandomPatchConfiguration SMALL_FLOWER_CONFIG_ALT = (new RandomPatchConfiguration(32, 7, 7,
			PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
					new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
							Blocks.WHITE_TULIP.defaultBlockState(),
							Blocks.PINK_TULIP.defaultBlockState(),
							Blocks.ORANGE_TULIP.defaultBlockState(),
							Blocks.RED_TULIP.defaultBlockState(),
							Blocks.DANDELION.defaultBlockState(),
							Blocks.POPPY.defaultBlockState(),
							Blocks.OXEYE_DAISY.defaultBlockState(),
							Blocks.AZURE_BLUET.defaultBlockState(),
							Blocks.ALLIUM.defaultBlockState(),
							Blocks.BLUE_ORCHID.defaultBlockState(),
							Blocks.LILY_OF_THE_VALLEY.defaultBlockState(),
							Blocks.CORNFLOWER.defaultBlockState())
					)), BlockPredicate.ONLY_IN_AIR_PREDICATE)));

	public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PLACER_ALT = registerKey("flower_placer_alt");


	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, nukaResource(name));
	}

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {


		context.register(BIG_MUSHGLOOM, new ConfiguredFeature<>(TFFeatures.BIG_MUSHGLOOM.get(), new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(TFBlocks.HUGE_MUSHGLOOM.get().defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.TRUE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), BlockStateProvider.simple(TFBlocks.HUGE_MUSHGLOOM_STEM.get().defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.FALSE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), 1)));
		context.register(FALLEN_LEAVES, new ConfiguredFeature<>(TFFeatures.FALLEN_LEAVES.get(), FeatureConfiguration.NONE));
		context.register(MAYAPPLE, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TFBlocks.MAYAPPLE.get())))));
		context.register(FIDDLEHEAD, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TFBlocks.FIDDLEHEAD.get())))));
		context.register(FIRE_JET, new ConfiguredFeature<>(TFFeatures.FIRE_JET.get(), new BlockStateConfiguration(TFBlocks.FIRE_JET.get().defaultBlockState())));
		context.register(FOUNDATION, new ConfiguredFeature<>(TFFeatures.FOUNDATION.get(), RuinedFoundationConfig.withDefaultBlocks(false)));
		context.register(GROVE_RUINS, new ConfiguredFeature<>(TFFeatures.GROVE_RUINS.get(), NoneFeatureConfiguration.NONE));
		context.register(HOLLOW_LOG, new ConfiguredFeature<>(TFFeatures.FALLEN_HOLLOW_LOG.get(), NoneFeatureConfiguration.NONE));
		context.register(HOLLOW_STUMP, new ConfiguredFeature<>(TFFeatures.HOLLOW_STUMP.get(), TreeConfigurations.HOLLOW_TREE));
		context.register(HUGE_LILY_PAD, new ConfiguredFeature<>(TFFeatures.HUGE_LILY_PAD.get(), NoneFeatureConfiguration.NONE));
		context.register(HUGE_WATER_LILY, new ConfiguredFeature<>(TFFeatures.HUGE_WATER_LILY.get(), NoneFeatureConfiguration.NONE));
		context.register(CICADA_LAMPPOST, new ConfiguredFeature<>(TFFeatures.LAMPPOSTS.get(), new BlockStateConfiguration(TFBlocks.CICADA_JAR.get().defaultBlockState())));
		context.register(FIREFLY_LAMPPOST, new ConfiguredFeature<>(TFFeatures.LAMPPOSTS.get(), new BlockStateConfiguration(TFBlocks.FIREFLY_JAR.get().defaultBlockState())));
		context.register(MONOLITH, new ConfiguredFeature<>(TFFeatures.MONOLITH.get(), NoneFeatureConfiguration.NONE));
		context.register(MUSHGLOOM_CLUSTER, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TFBlocks.MUSHGLOOM.get())))));
		context.register(MYCELIUM_BLOB, new ConfiguredFeature<>(TFFeatures.MYCELIUM_BLOB.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.MYCELIUM), BlockPredicate.matchesBlocks(Blocks.GRASS_BLOCK), UniformInt.of(4, 6), 3)));
		context.register(OUTSIDE_STALAGMITE, new ConfiguredFeature<>(TFFeatures.CAVE_STALACTITE.get(), NoneFeatureConfiguration.NONE));
		context.register(PLANT_ROOTS, new ConfiguredFeature<>(TFFeatures.UNDERGROUND_PLANTS.get(), new BlockStateConfiguration(TFBlocks.ROOT_STRAND.get().defaultBlockState())));
		context.register(PUMPKIN_LAMPPOST, new ConfiguredFeature<>(TFFeatures.LAMPPOSTS.get(), new BlockStateConfiguration(Blocks.JACK_O_LANTERN.defaultBlockState())));
		context.register(SMOKER, new ConfiguredFeature<>(TFFeatures.FIRE_JET.get(), new BlockStateConfiguration(TFBlocks.SMOKER.get().defaultBlockState())));
		context.register(STONE_CIRCLE, new ConfiguredFeature<>(TFFeatures.STONE_CIRCLE.get(), NoneFeatureConfiguration.NONE));
		context.register(THORNS, new ConfiguredFeature<>(TFFeatures.THORNS.get(), new ThornsConfig(7, 3, 3, 50)));
		context.register(TORCH_BERRIES, new ConfiguredFeature<>(TFFeatures.UNDERGROUND_PLANTS.get(), new BlockStateConfiguration(TFBlocks.TORCHBERRY_PLANT.get().defaultBlockState().setValue(TorchberryPlantBlock.HAS_BERRIES, true))));
		context.register(TROLL_ROOTS, new ConfiguredFeature<>(TFFeatures.TROLL_VINES.get(), new BlockStateConfiguration(TFBlocks.TROLLVIDR.get().defaultBlockState())));
		context.register(VANILLA_ROOTS, new ConfiguredFeature<>(TFFeatures.UNDERGROUND_PLANTS.get(), new BlockStateConfiguration(Blocks.HANGING_ROOTS.defaultBlockState())));
		context.register(WEBS, new ConfiguredFeature<>(TFFeatures.WEBS.get(), NoneFeatureConfiguration.NONE));
		context.register(WOOD_ROOTS_SPREAD, new ConfiguredFeature<>(TFFeatures.WOOD_ROOTS.get(), new RootConfig(TreeDecorators.ROOT_BLEND_PROVIDER, BlockStateProvider.simple(TFBlocks.LIVEROOT_BLOCK.get()))));
		context.register(SNOW_UNDER_TREES, new ConfiguredFeature<>(TFFeatures.SNOW_UNDER_TREES.get(), NoneFeatureConfiguration.NONE));

		context.register(TF_OAK_FALLEN_LOG, new ConfiguredFeature<>(TFFeatures.FALLEN_SMALL_LOG.get(), new HollowLogConfig(TFBlocks.TWILIGHT_OAK_LOG.get().defaultBlockState(), TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_HORIZONTAL.get().defaultBlockState())));
		context.register(CANOPY_FALLEN_LOG, new ConfiguredFeature<>(TFFeatures.FALLEN_SMALL_LOG.get(), new HollowLogConfig(TFBlocks.CANOPY_LOG.get().defaultBlockState(), TFBlocks.HOLLOW_CANOPY_LOG_HORIZONTAL.get().defaultBlockState())));
		context.register(MANGROVE_FALLEN_LOG, new ConfiguredFeature<>(TFFeatures.FALLEN_SMALL_LOG.get(), new HollowLogConfig(TFBlocks.MANGROVE_LOG.get().defaultBlockState(), TFBlocks.HOLLOW_MANGROVE_LOG_HORIZONTAL.get().defaultBlockState())));
		context.register(OAK_FALLEN_LOG, new ConfiguredFeature<>(TFFeatures.FALLEN_SMALL_LOG.get(), new HollowLogConfig(Blocks.OAK_LOG.defaultBlockState(), TFBlocks.HOLLOW_OAK_LOG_HORIZONTAL.get().defaultBlockState())));
		context.register(SPRUCE_FALLEN_LOG, new ConfiguredFeature<>(TFFeatures.FALLEN_SMALL_LOG.get(), new HollowLogConfig(Blocks.SPRUCE_LOG.defaultBlockState(), TFBlocks.HOLLOW_SPRUCE_LOG_HORIZONTAL.get().defaultBlockState())));
		context.register(BIRCH_FALLEN_LOG, new ConfiguredFeature<>(TFFeatures.FALLEN_SMALL_LOG.get(), new HollowLogConfig(Blocks.BIRCH_LOG.defaultBlockState(), TFBlocks.HOLLOW_BIRCH_LOG_HORIZONTAL.get().defaultBlockState())));

		context.register(SMALL_GRANITE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.GRANITE.defaultBlockState(), 16)));
		context.register(SMALL_DIORITE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.DIORITE.defaultBlockState(), 16)));
		context.register(SMALL_ANDESITE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.ANDESITE.defaultBlockState(), 16)));

		context.register(LEGACY_COAL_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.COAL_ORE.defaultBlockState(), 16)));
		context.register(LEGACY_IRON_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.IRON_ORE.defaultBlockState(), 9)));
		context.register(LEGACY_GOLD_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.GOLD_ORE.defaultBlockState(), 9)));
		context.register(LEGACY_REDSTONE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.REDSTONE_ORE.defaultBlockState(), 8)));
		context.register(LEGACY_DIAMOND_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.DIAMOND_ORE.defaultBlockState(), 8)));
		context.register(LEGACY_LAPIS_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.LAPIS_ORE.defaultBlockState(), 7)));
		context.register(LEGACY_COPPER_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), Blocks.COPPER_ORE.defaultBlockState(), 10)));

		context.register(DARK_MUSHGLOOMS, new ConfiguredFeature<>(TFFeatures.DARK_FOREST_PLACER.get(), FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(TFBlocks.MUSHGLOOM.get())), List.of(Blocks.GRASS_BLOCK), 50)));
		context.register(DARK_PUMPKINS, new ConfiguredFeature<>(TFFeatures.DARK_FOREST_PLACER.get(), FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.PUMPKIN)), List.of(Blocks.GRASS_BLOCK), 50)));
		context.register(DARK_GRASS, new ConfiguredFeature<>(TFFeatures.DARK_FOREST_PLACER.get(), FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SHORT_GRASS)), List.of(Blocks.GRASS_BLOCK), 128)));
		context.register(DARK_FERNS, new ConfiguredFeature<>(TFFeatures.DARK_FOREST_PLACER.get(), FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.FERN)), List.of(Blocks.GRASS_BLOCK), 128)));
		context.register(DARK_MUSHROOMS, new ConfiguredFeature<>(TFFeatures.DARK_FOREST_PLACER.get(), FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.BROWN_MUSHROOM)), List.of(Blocks.GRASS_BLOCK), 50)));
		context.register(DARK_DEAD_BUSHES, new ConfiguredFeature<>(TFFeatures.DARK_FOREST_PLACER.get(), FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.DEAD_BUSH)), List.of(Blocks.GRASS_BLOCK), 50)));

		context.register(UBEROUS_SOIL_PATCH_BIG, new ConfiguredFeature<>(TFFeatures.MYCELIUM_BLOB.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(TFBlocks.UBEROUS_SOIL.get()), BlockPredicate.matchesBlocks(Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT), UniformInt.of(4, 8), 1)));
		context.register(TROLL_CAVE_MYCELIUM, new ConfiguredFeature<>(TFFeatures.MYCELIUM_BLOB.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.MYCELIUM), BlockPredicate.matchesBlocks(Blocks.STONE, TFBlocks.DEADROCK.get()), UniformInt.of(3, 5), 0)));
		context.register(TROLL_CAVE_DIRT, new ConfiguredFeature<>(TFFeatures.MYCELIUM_BLOB.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.DIRT), BlockPredicate.matchesBlocks(Blocks.STONE, TFBlocks.DEADROCK.get()), UniformInt.of(2, 5), 0)));
		context.register(UBEROUS_SOIL_PATCH_SMALL, new ConfiguredFeature<>(TFFeatures.MYCELIUM_BLOB.get(), new DiskConfiguration(RuleBasedBlockStateProvider.simple(TFBlocks.UBEROUS_SOIL.get()), BlockPredicate.matchesBlocks(Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT), UniformInt.of(2, 3), 0)));

		context.register(TWILIGHT_OAK_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.TWILIGHT_OAK));
		context.register(LARGE_TWILIGHT_OAK_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.LARGE_TWILIGHT_OAK));
		context.register(SWAMPY_OAK_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.SWAMPY_OAK));
		context.register(CANOPY_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.CANOPY_TREE));
		context.register(FIREFLY_CANOPY_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.CANOPY_TREE_FIREFLY));
		context.register(DEAD_CANOPY_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.CANOPY_TREE_DEAD));
		context.register(MANGROVE_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.MANGROVE_TREE));
		context.register(DARKWOOD_TREE, new ConfiguredFeature<>(TFFeatures.DARK_CANOPY_TREE.get(), TreeConfigurations.DARKWOOD_TREE));
		context.register(HOMEGROWN_DARKWOOD_TREE, new ConfiguredFeature<>(TFFeatures.DARK_CANOPY_TREE.get(), TreeConfigurations.HOMEGROWN_DARKWOOD_TREE));
		context.register(DARKWOOD_LANTERN_TREE, new ConfiguredFeature<>(TFFeatures.DARK_CANOPY_TREE.get(), TreeConfigurations.DARKWOOD_LANTERN_TREE));
		context.register(TIME_TREE, new ConfiguredFeature<>(TFFeatures.TREE_OF_TIME.get(), TreeConfigurations.TIME_TREE));
		context.register(TRANSFORMATION_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.TRANSFORM_TREE));
		context.register(MINING_TREE, new ConfiguredFeature<>(TFFeatures.MINERS_TREE.get(), TreeConfigurations.MINING_TREE));
		context.register(SORTING_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.SORT_TREE));
		context.register(FOREST_CANOPY_OAK_TREE, new ConfiguredFeature<>(TFFeatures.CANOPY_OAK.get(), TreeConfigurations.FOREST_CANOPY_OAK));
		context.register(SAVANNAH_CANOPY_OAK_TREE, new ConfiguredFeature<>(TFFeatures.CANOPY_OAK.get(), TreeConfigurations.SAVANNAH_CANOPY_OAK));
		context.register(RAINBOW_OAK_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.RAINBOAK_TREE));
		context.register(LARGE_RAINBOW_OAK_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.LARGE_RAINBOAK_TREE));
		context.register(BROWN_CANOPY_MUSHROOM_TREE, new ConfiguredFeature<>(TFFeatures.CANOPY_BROWN_MUSHROOM.get(), new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(Blocks.BROWN_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.TRUE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.FALSE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), 3)));
		context.register(RED_CANOPY_MUSHROOM_TREE, new ConfiguredFeature<>(TFFeatures.CANOPY_RED_MUSHROOM.get(), new HugeMushroomFeatureConfiguration(BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.TRUE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.FALSE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), 3)));
		context.register(MEGA_SPRUCE_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.BIG_SPRUCE));
		context.register(LARGE_WINTER_TREE, new ConfiguredFeature<>(TFFeatures.LARGE_WINTER_TREE.get(), TreeConfigurations.LARGE_WINTER));
		context.register(SNOWY_SPRUCE_TREE, new ConfiguredFeature<>(TFFeatures.SNOW_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build()));
		context.register(DARK_FOREST_OAK_TREE, new ConfiguredFeature<>(TFFeatures.DARK_CANOPY_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
		context.register(DARK_FOREST_BIRCH_TREE, new ConfiguredFeature<>(TFFeatures.DARK_CANOPY_TREE.get(), new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.BIRCH_LOG), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(Blocks.BIRCH_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
		context.register(VANILLA_OAK_TREE, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
		context.register(VANILLA_BIRCH_TREE, new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.BIRCH_LOG), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(Blocks.BIRCH_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build()));
		context.register(SMALLER_JUNGLE_TREE, new ConfiguredFeature<>(Feature.TREE, TreeConfigurations.SMALL_JUNGLE));
		context.register(DUMMY_TREE, new ConfiguredFeature<>(Feature.NO_OP, NoneFeatureConfiguration.INSTANCE));

		context.register(WELL_PLACER, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(FANCY_WELL)), 0.05F)), PlacementUtils.inlinePlaced(features.getOrThrow(SIMPLE_WELL)))));
		context.register(LAMPPOST_PLACER, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(CICADA_LAMPPOST)), 0.1F)), PlacementUtils.inlinePlaced(features.getOrThrow(FIREFLY_LAMPPOST)))));
		context.register(DEFAULT_FALLEN_LOGS, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(BIRCH_FALLEN_LOG)), 0.1F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(OAK_FALLEN_LOG)), 0.2F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(CANOPY_FALLEN_LOG)), 0.4F)), PlacementUtils.inlinePlaced(features.getOrThrow(TF_OAK_FALLEN_LOG)))));

		context.register(CANOPY_TREES, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(CANOPY_TREE)), 0.6F)), PlacementUtils.inlinePlaced(features.getOrThrow(TWILIGHT_OAK_TREE)))));
		context.register(DENSE_CANOPY_TREES, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(CANOPY_TREE)), 0.7F)), PlacementUtils.inlinePlaced(features.getOrThrow(TWILIGHT_OAK_TREE)))));
		context.register(FIREFLY_FOREST_TREES, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(CANOPY_TREE)), 0.33F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(FIREFLY_CANOPY_TREE)), 0.45F)), PlacementUtils.inlinePlaced(features.getOrThrow(TWILIGHT_OAK_TREE)))));
		context.register(DARK_FOREST_TREES, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(DARK_FOREST_BIRCH_TREE)), 0.2F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(DARK_FOREST_OAK_TREE)), 0.2F)), PlacementUtils.inlinePlaced(features.getOrThrow(DARKWOOD_TREE)))));
		context.register(HIGHLANDS_TREES, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(VANILLA_BIRCH_TREE)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(TreeFeatures.SPRUCE)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(TreeFeatures.PINE)), 0.1F)), PlacementUtils.inlinePlaced(features.getOrThrow(MEGA_SPRUCE_TREE)))));
		context.register(ENCHANTED_FOREST_TREES, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(VANILLA_OAK_TREE)), 0.15F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(VANILLA_BIRCH_TREE)), 0.15F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(LARGE_RAINBOW_OAK_TREE)), 0.1F)), PlacementUtils.inlinePlaced(features.getOrThrow(RAINBOW_OAK_TREE)))));
		context.register(SNOWY_FOREST_TREES, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(MEGA_SPRUCE_TREE)), 0.1F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(LARGE_WINTER_TREE)), 0.01F)), PlacementUtils.inlinePlaced(features.getOrThrow(SNOWY_SPRUCE_TREE)))));
		context.register(VANILLA_TF_TREES, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(VANILLA_BIRCH_TREE)), 0.25F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(VANILLA_OAK_TREE)), 0.25F)), PlacementUtils.inlinePlaced(features.getOrThrow(TWILIGHT_OAK_TREE)))));
		context.register(VANILLA_TF_BIG_MUSH, new ConfiguredFeature<>(Feature.RANDOM_BOOLEAN_SELECTOR, new RandomBooleanFeatureConfiguration(PlacementUtils.inlinePlaced(features.getOrThrow(TreeFeatures.HUGE_RED_MUSHROOM)), PlacementUtils.inlinePlaced(features.getOrThrow(TreeFeatures.HUGE_BROWN_MUSHROOM)))));

		context.register(CANOPY_MUSHROOMS_SPARSE, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(BROWN_CANOPY_MUSHROOM_TREE)), 0.15f), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(RED_CANOPY_MUSHROOM_TREE)), 0.05f)), PlacementUtils.inlinePlaced(features.getOrThrow(DUMMY_TREE)))));
		context.register(CANOPY_MUSHROOMS_DENSE, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(BROWN_CANOPY_MUSHROOM_TREE)), 0.675f), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(features.getOrThrow(RED_CANOPY_MUSHROOM_TREE)), 0.225f)), PlacementUtils.inlinePlaced(features.getOrThrow(DUMMY_TREE)))));
		context.register(FLOWER_PLACER, new ConfiguredFeature<>(Feature.FLOWER, SMALL_FLOWER_CONFIG));
		context.register(FLOWER_PLACER_ALT, new ConfiguredFeature<>(Feature.FLOWER, SMALL_FLOWER_CONFIG_ALT));
	}

	private static void registerTemplateFeatures(BootstapContext<ConfiguredFeature<?, ?>> context) {
		HolderGetter<WoodPalette> paletteHolders = context.lookup(TFRegistries.Keys.WOOD_PALETTES);
		var paletteChoices = SwizzleConfig.buildRarityPalette(paletteHolders);

		ProcessorRule processorCobbleBlock = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.defaultBlockState());
		ProcessorRule processorCobbleStair = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE_STAIRS, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE_STAIRS.defaultBlockState());
		ProcessorRule processorCobbleSlab = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE_SLAB, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE_SLAB.defaultBlockState());
		ProcessorRule processorCobbleWall = new ProcessorRule(new RandomBlockMatchTest(Blocks.COBBLESTONE_WALL, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_COBBLESTONE_WALL.defaultBlockState());

		ProcessorRule processorStoneBrickBlock = new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICKS, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICKS.defaultBlockState());
		ProcessorRule processorStoneBrickStair = new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_STAIRS, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICK_STAIRS.defaultBlockState());
		ProcessorRule processorStoneBrickSlab = new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_SLAB, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICK_SLAB.defaultBlockState());
		ProcessorRule processorStoneBrickWall = new ProcessorRule(new RandomBlockMatchTest(Blocks.STONE_BRICK_WALL, 0.5f), AlwaysTrueTest.INSTANCE, Blocks.MOSSY_STONE_BRICK_WALL.defaultBlockState());

		SwizzleConfig simpleWellConfig = SwizzleConfig.generate(paletteHolders, CustomTagGenerator.WoodPaletteTagGenerator.WELL_SWIZZLE_MASK, paletteChoices, processorCobbleBlock, processorCobbleStair, processorCobbleSlab, processorCobbleWall);
		context.register(SIMPLE_WELL, new ConfiguredFeature<>(TFFeatures.SIMPLE_WELL.get(), simpleWellConfig));

		SwizzleConfig fancyWellConfig = SwizzleConfig.generate(paletteHolders, CustomTagGenerator.WoodPaletteTagGenerator.WELL_SWIZZLE_MASK, paletteChoices, processorCobbleBlock, processorCobbleStair, processorCobbleSlab, processorCobbleWall, processorStoneBrickBlock, processorStoneBrickStair, processorStoneBrickSlab, processorStoneBrickWall);
		context.register(FANCY_WELL, new ConfiguredFeature<>(TFFeatures.FANCY_WELL.get(), fancyWellConfig));

		SwizzleConfig hutConfig = SwizzleConfig.generate(paletteHolders, CustomTagGenerator.WoodPaletteTagGenerator.DRUID_HUT_SWIZZLE_MASK, paletteChoices, processorCobbleBlock, processorCobbleStair, processorCobbleSlab, processorCobbleWall, processorStoneBrickBlock, processorStoneBrickStair, processorStoneBrickSlab, processorStoneBrickWall);
		context.register(DRUID_HUT, new ConfiguredFeature<>(TFFeatures.DRUID_HUT.get(), hutConfig));

		context.register(GRAVEYARD, new ConfiguredFeature<>(TFFeatures.GRAVEYARD.get(), FeatureConfiguration.NONE));
	}
}