package com.nukateam.nukacraft.common.foundation.world.features;

import com.nukateam.nukacraft.common.foundation.world.trees.ModTrees;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public final class ModConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> ASH_HEAP_TREE	= registerKey("tree_ash_heap" );
	public static final ResourceKey<ConfiguredFeature<?, ?>> GLOW_TREE 		= registerKey("tree_glow"		);
	public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_DEWDROP 	= registerKey("tree_dewdrop"	);
	public static final ResourceKey<ConfiguredFeature<?, ?>> ASH_TREE 		= registerKey("tree_ash"		);

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		context.register(ASH_HEAP_TREE	, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_ASH_HEAP	));
		context.register(GLOW_TREE		, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_GLOW		));
		context.register(TREE_DEWDROP	, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_DEWDROP	));
		context.register(ASH_TREE		, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_ASH		));
	}

	private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, nukaResource(name));
	}
}