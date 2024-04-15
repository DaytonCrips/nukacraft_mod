package com.nukateam.nukacraft.common.foundation.world;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.common.foundation.world.treedecorator.*;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;
import java.util.OptionalInt;

public class ModDefaultFeatures {


    public static void addPoisonValleyOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ALUMI);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COPPER);
    }
    public static void addCranberryBogOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ALUMI);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ULTRACITE);
    }

    public static void addGlowSeaOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_URAN);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ULTRACITE);
    }
    public static void addAshHeapOres(BiomeGenerationSettings.Builder builder) {
        //builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_BTITAN);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_GOLD);
    }
//
//    public static void addWastelandAluminium(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ALUMI);
//    }
//
//
//    public static void addWastelandCopper(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COPPER);
//    }
//    public static void addWastelandCoal(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_LOWER);
//    }
//
//    public static void addWastelandIron(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_IRON_SMALL);
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_IRON_UPPER);
//    }
//    public static void addWastelandLead(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_LEAD);
//    }
//    public static void addWastelandSilver(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_SILVER);
//    }
//    public static void addWastelandBTitan(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_BTITAN);
//    }
//    public static void addWastelandUltracite(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ULTRACITE);
//    }

    public static void addAcidLake(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.LAKES, ModWastelandPlacements.LAKE_ACID_SURFACE);
    }

    public static void addAshStone(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModWastelandPlacements.DISK_ASHSTONE);
    }

    public static void addPoisonValleyPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_BROC_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_ASTER_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_THISTLE_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_DEAD_PLANT_PLACE);
    }
    public static void addCranBerryBogPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_TOXIC_FERN_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_DEWDROP_SAPLING_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_DEAD_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_GUTFUNGI_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_CRANBERRY);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_SUGAR_CANE_SWAMP);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_BOGPAD);
    }

    public static void addGlowSeaPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_BOMBBERRY_BUSH_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_RADROSE_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_FUSION_FRUIT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_MEGAHATTER_PLACE);
    }
    public static void addAshHeapDisks(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModWastelandPlacements.DISK_ASHDIRT);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);
    }
    public static void addAshHeapPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_ZANDER);
        //builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_RUSTY_BUSH);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_CRACKBERRY_BUSH_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_SOOTFLOWER_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_FIREFUNGI_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_GLOWFUNGUS_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_STARBERRY);
    }


    public static void addGlowGrass(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:glowgrass", ModFeatures.PATCH_GLOWGRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 3, 3),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
    }
    public static void addGrassAsh(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:grass_ash", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
    }


    public static void addTreePoison(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("nukacraft:tree_ashwood",
                FeatureUtils.register("nukacraft:tree_ash", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                                new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                                .decorators(ImmutableList.of(new ResinDecorator(0.2f), new MegaSlothDecorator(0.1f))).ignoreVines()
                                .build()),
                List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
    }

    public static void addGrassPoison(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:poisongrass", ModFeatures.PATCH_POISONGRASS, List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
    }
    public static void addGrassToxic(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:ashgrasss", ModFeatures.PATCH_ASHGRASS, List.of(NoiseThresholdCountPlacement.of(-0.3D, 2, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
    }

    public static void addGrassCranberry(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:crangrass", ModFeatures.PATCH_CRANGRASS, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 12),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
    }

    public static void addTreeCranberry(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("nukacraft:tree_cranberry",
                FeatureUtils.register("nukacraft:cranberry_tree", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CRANBERRYWOOD.get().defaultBlockState()),
                                new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(ModBlocks.CRANBERRYLEAVES.get().defaultBlockState()),
                                new AcaciaFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),
                                new TwoLayersFeatureSize(1, 0, 1, OptionalInt.empty())).decorators(ImmutableList.of(new DewdropDecorator(0.4f), new DewdropDecorator(0.1f))).ignoreVines()
                                .build()),
                List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
    }

    public static void addStumpGlow(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("nukacraft:stump_ashwood",
                FeatureUtils.register("nukacraft:stump_ash", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                                new StraightTrunkPlacer(1, 1, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                                .decorators(ImmutableList.of(new BBlightDecorator(0.2f), new SapDecorator(0.1f))).ignoreVines()
                                .build()),
                List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
    }
    public static void addStumpHeap(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("nukacraft:stump_ash_heap",
                FeatureUtils.register("nukacraft:stump_ash_heap", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                                new StraightTrunkPlacer(1, 1, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                                .decorators(ImmutableList.of(new BBlightDecorator(0.2f))).ignoreVines()
                                .build()),
                List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
    }
    public static void addHeapGrass(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:heap_grass", ModFeatures.PATCH_HEAP_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
    }
    public static void addRustyBush(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:rusty_bush_patch", ModFeatures.PATCH_RUSTY_BUSH, List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
    }
}
