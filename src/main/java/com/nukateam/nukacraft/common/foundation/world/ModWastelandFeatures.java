package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.fluid.ModFluids;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

import static com.nukateam.nukacraft.common.registery.ModBlocks.*;

public class ModWastelandFeatures {
    public static final Holder<ConfiguredFeature<BlockStateConfiguration, ?>>
            DISK_ASHSTONE = FeatureUtils.register("disk_ashstone",
            Feature.FOREST_ROCK,
            new BlockStateConfiguration(ASHSTONE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_ASHDIRT =
            FeatureUtils.register("disk_ashdirt",
                    Feature.DISK,
                    new DiskConfiguration(
                            ASHDIRT.get().defaultBlockState(),
                            UniformInt.of(2, 5),
                            4,
                            List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState())
                    )
            );

    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_ASHDIRT =
            FeatureUtils.register("disk_ashdirt",
                    Feature.DISK,
                    new DiskConfiguration(
                            ModBlocks.ASHDIRT.get().defaultBlockState(),
                            BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK),
                            UniformInt.of(2, 5),
                            4
                            List.of(Blocks.DIRT.defaultBlockState(),
                                    Blocks.GRASS_BLOCK.defaultBlockState())));

    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_MUD = createConfiguredFeature("disk_mud",
            () -> Feature.DISK,
            () -> new DiskConfiguration(
                    new RuleBasedBlockStateProvider(
                            BlockStateProvider.simple(Blocks.MUD),
                            List.of(new RuleBasedBlockStateProvider
                                    .Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR),
                                    BlockStateProvider.simple(Blocks.MUD)))
                    ),
                    BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.CLAY),
                    UniformInt.of(2, 6),
                    2)
    );

    private void ss(){
        var s UniformInt.of(2, 5),
    }

    public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>>
            LAKE_ACID = FeatureUtils.register("lake_acid",
            Feature.LAKE,
            new LakeFeature.Configuration(BlockStateProvider.simple(ModFluids.ACID_FLUID.get().defaultFluidState().createLegacyBlock()),
                    BlockStateProvider.simple(ACID_DIRT.get().defaultBlockState())));

}
