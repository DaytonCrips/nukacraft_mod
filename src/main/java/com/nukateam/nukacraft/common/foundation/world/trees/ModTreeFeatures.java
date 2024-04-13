package com.nukateam.nukacraft.common.foundation.world.trees;


import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.foundation.world.treedecorator.*;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;

public class ModTreeFeatures {

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> TREE_ASH_HEAP = FeatureUtils.register("nukacraft:tree_ash_heap", Feature.TREE,
            new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                                new StraightTrunkPlacer(1, 1, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                                .decorators(ImmutableList.of(new BBlightDecorator(0.2f))).ignoreVines()
                                .build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> TREE_GLOW = FeatureUtils.register("nukacraft:tree_glow", Feature.TREE,
            new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                                new StraightTrunkPlacer(1, 1, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                                .decorators(ImmutableList.of(new BBlightDecorator(0.2f), new SapDecorator(0.1f))).ignoreVines()
                                .build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> TREE_DEWDROP = FeatureUtils.register("nukacraft:tree_dewdrop", Feature.TREE,
            new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CRANBERRYWOOD.get().defaultBlockState()),
                                new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(ModBlocks.CRANBERRYLEAVES.get().defaultBlockState()),
                                new AcaciaFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),
                                new TwoLayersFeatureSize(1, 0, 1, OptionalInt.empty())).decorators(ImmutableList.of(new DewdropDecorator(0.4f), new DewdropDecorator(0.1f))).ignoreVines()
                                .build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> TREE_ASH = FeatureUtils.register("nukacraft:tree_ash", Feature.TREE,
            new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                    new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                    .decorators(ImmutableList.of(new ResinDecorator(0.05F), new MegaSlothDecorator(0.03F))).ignoreVines()
                    .build());
}
