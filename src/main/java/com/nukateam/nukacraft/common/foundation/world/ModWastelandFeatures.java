package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.ModFluids;
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

public class ModWastelandFeatures {
    public static final Holder<ConfiguredFeature<BlockStateConfiguration, ?>>
            DISK_ASHSTONE = FeatureUtils.register("disk_ashstone",
            Feature.FOREST_ROCK,
            new BlockStateConfiguration(ModBlocks.ASHSTONE.get().defaultBlockState()));


    public static final Holder<ConfiguredFeature<LakeFeature.Configuration, ?>>
            LAKE_ACID = FeatureUtils.register("lake_acid",
            Feature.LAKE,
            new LakeFeature.Configuration(BlockStateProvider.simple(ModFluids.ACID_FLUID.get().defaultFluidState().createLegacyBlock()),
                    BlockStateProvider.simple(ModBlocks.ACID_DIRT.get().defaultBlockState())));

}
