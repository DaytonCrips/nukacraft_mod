package com.nukateam.nukacraft.common.foundation.world.features.configured;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.foundation.world.trees.ModTrees;
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
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public final class BiomeFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> LAKE_ACID = registerKey("lake_acid");

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

	}

	private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, nukaResource(name));
	}
}