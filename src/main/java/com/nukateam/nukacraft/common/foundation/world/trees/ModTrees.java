package com.nukateam.nukacraft.common.foundation.world.trees;


import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.foundation.world.treedecorator.*;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.AboveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class ModTrees {
//    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> TREE_ASH_HEAP = FeatureUtils.register("nukacraft:tree_ash_heap", Feature.TREE,
//            new TreeConfiguration.TreeConfigurationBuilder(
//                    BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
//                    new StraightTrunkPlacer(1, 1, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
//                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
//                    new TwoLayersFeatureSize(1, 0, 1)
//            )
//                    .decorators(ImmutableList.of(new BBlightDecorator(0.2f)))
//                    .ignoreVines()
//                    .build());

    private static HolderGetter<Block> holderGetter;
    public static <S> void setTags(HolderGetter<S> lookup) {
        holderGetter = (HolderGetter<Block>) lookup;
    }
    public static final TreeConfiguration TREE_ASH_HEAP = new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
            new StraightTrunkPlacer(1, 1, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
            new TwoLayersFeatureSize(1, 0, 1)
    )
            .decorators(ImmutableList.of(new BBlightDecorator(0.2f)))
            .ignoreVines()
            .build();

    public static final TreeConfiguration TREE_GLOW =
            new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                    new StraightTrunkPlacer(1, 1, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1))
                    .decorators(ImmutableList.of(new BBlightDecorator(0.2f), new SapDecorator(0.1f))).ignoreVines()
                    .build();

    public static final TreeConfiguration TREE_DEWDROP =
            new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.CRANBERRYWOOD.get().defaultBlockState()),
                    new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(ModBlocks.CRANBERRYLEAVES.get().defaultBlockState()),
                    new AcaciaFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 1, OptionalInt.empty())).decorators(ImmutableList.of(new DewdropDecorator(0.4f), new DewdropDecorator(0.1f))).ignoreVines()
                    .build();

    public static final TreeConfiguration TREE_ASH =
            new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                    new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1))
                    .decorators(ImmutableList.of(new ResinDecorator(0.05F), new MegaSlothDecorator(0.03F))).ignoreVines()
                    .build();
//    public static final TreeConfiguration TREE_MIRE =
//            new TreeConfiguration.TreeConfigurationBuilder(
//                    BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
//                    new UpwardsBranchingTrunkPlacer(2, 1, 4,UniformInt.of(1, 4), 0.5F, UniformInt.of(0, 1), holderGetter.getOrThrow(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)),
//                    BlockStateProvider.simple(Blocks.MANGROVE_LEAVES),
//                    new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 70),
//                    Optional.of(new MangroveRootPlacer(UniformInt.of(1, 3),
//                            BlockStateProvider.simple(Blocks.MANGROVE_ROOTS),
//                            Optional.of(new AboveRootPlacement(BlockStateProvider.simple(Blocks.MOSS_CARPET), 0.5F)),
//                            new MangroveRootPlacement(holderGetter.getOrThrow(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH),
//                                    HolderSet.direct(Block::builtInRegistryHolder, new Block[]{Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS}),
//                                    BlockStateProvider.simple(Blocks.MUDDY_MANGROVE_ROOTS), 8, 15, 0.2F))),
//                    new TwoLayersFeatureSize(2, 0, 2))
//                    .decorators(List.of(new LeaveVineDecorator(0.125F),
//                            new AttachedToLeavesDecorator(0.14F, 1, 0,
//                                    new RandomizedIntStateProvider(BlockStateProvider.simple((BlockState)Blocks.MANGROVE_PROPAGULE.defaultBlockState().setValue(MangrovePropaguleBlock.HANGING, true)),
//                                            MangrovePropaguleBlock.AGE, UniformInt.of(0, 4)), 2, List.of(Direction.DOWN)))).ignoreVines().build();





}
