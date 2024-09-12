package com.nukateam.nukacraft.common.foundation.world.features.configured;

import com.nukateam.nukacraft.common.foundation.world.trees.ModTrees;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.AboveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;

import java.util.List;
import java.util.Optional;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public final class ModTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASH_HEAP_TREE = registerKey("tree_ash_heap");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOW_TREE = registerKey("tree_glow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_DEWDROP = registerKey("tree_dewdrop");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASH_TREE = registerKey("tree_ash");
    public static final ResourceKey<ConfiguredFeature<?, ?>> IMMORTAL_TREE = registerKey("trees_immortal_green");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUSTY_TREE = registerKey("trees_rusty");
    /*    public static final ResourceKey<ConfiguredFeature<?, ?>> MIRE_TREE = registerKey("tree_mire");*/

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<Block> $$1 = context.lookup(Registries.BLOCK);

        context.register(ASH_HEAP_TREE, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_ASH_HEAP));
        context.register(GLOW_TREE, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_GLOW));
        context.register(TREE_DEWDROP, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_DEWDROP));
        context.register(ASH_TREE, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_ASH));
        context.register(IMMORTAL_TREE, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_IMMORTAL));
        context.register(RUSTY_TREE, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_RUSTY));
//        context.register(MIRE_TREE, new ConfiguredFeature<>(Feature.TREE, ModTrees.TREE_MIRE));

    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, nukaResource(name));
    }
}