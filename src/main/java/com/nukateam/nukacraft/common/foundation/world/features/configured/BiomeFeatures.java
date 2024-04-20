package com.nukateam.nukacraft.common.foundation.world.features.configured;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.fluid.ModFluids;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.LakeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;
import static com.nukateam.nukacraft.common.registery.ModBlocks.ACID_DIRT;
import static com.nukateam.nukacraft.common.registery.ModBlocks.ASHSTONE;

public final class BiomeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_ASHSTONE = registerKey("disk_ashstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_ASHDIRT = registerKey("disk_ashdirt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAKE_ACID = registerKey("lake_acid");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        FeatureUtils.register(context, DISK_ASHSTONE, Feature.FOREST_ROCK, new BlockStateConfiguration(ASHSTONE.get().defaultBlockState()));

        FeatureUtils.register(context, DISK_ASHDIRT, Feature.DISK, new DiskConfiguration(
                new RuleBasedBlockStateProvider(
                        BlockStateProvider.simple(Blocks.MUD),
                        List.of(new RuleBasedBlockStateProvider
                                .Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR),
                                BlockStateProvider.simple(ModBlocks.ASHDIRT.get())))
                ),
                BlockPredicate.matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK),
                UniformInt.of(2, 5),
                4));


        FeatureUtils.register(context, LAKE_ACID, Feature.LAKE,
                new LakeFeature.Configuration(BlockStateProvider.simple(ModFluids.ACID_FLUID.get().defaultFluidState().createLegacyBlock()),
                        BlockStateProvider.simple(ACID_DIRT.get().defaultBlockState())));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, nukaResource(name));
    }
}