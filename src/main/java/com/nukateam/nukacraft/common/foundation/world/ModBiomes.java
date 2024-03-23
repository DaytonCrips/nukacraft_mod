package com.nukateam.nukacraft.common.foundation.world;

import com.google.common.collect.ImmutableList;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.treedecorator.*;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.OptionalInt;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, NukaCraftMod.MOD_ID);

    public static final RegistryObject<Biome> POISON_VALLEY = BIOMES.register("poison_valley",
            ModBiomes::createPoisonValley);

    public static final RegistryObject<Biome> GLOW_SEA = BIOMES.register("glow_sea",
            ModBiomes::createGlowSea);

    public static final RegistryObject<Biome> ASH_HEAP = BIOMES.register("ash_heap",
            ModBiomes::createAshHeap);

    public static final RegistryObject<Biome> CRANBERRY_BOG = BIOMES.register("cranberry_bog",
            ModBiomes::createCranberryBog);

    private static Biome createPoisonValley() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-5399162).waterColor(-9547964).waterFogColor(11648455)
                .skyColor(-7964315).foliageColorOverride(1783388).grassColorOverride(-861768).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("nukacraft:tree_ashwood",
                FeatureUtils.register("nukacraft:tree_ash", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                                new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                                .decorators(ImmutableList.of(new ResinDecorator(0.2f), new MegaSlothDecorator(0.1f))).ignoreVines()
                                .build()),
                List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));


        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:ashgrasss", ModFeatures.PATCH_ASHGRASS, List.of(NoiseThresholdCountPlacement.of(-0.3D, 2, 1),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:poisongrass", ModFeatures.PATCH_POISONGRASS, List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));

        ModDefaultFeatures.addAshStone(biomeGenerationSettings);
        ModDefaultFeatures.addPoisonValleyOres(biomeGenerationSettings);
        ModDefaultFeatures.addAcidLake(biomeGenerationSettings);


        ModDefaultFeatures.addPoisonValleyPlants(biomeGenerationSettings);

        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BRAHMIN.get(), 1, 1, 1));

        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);



        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.NONE).temperature(0.5f)
                .downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobspawnsettings$builder.build()).generationSettings(biomeGenerationSettings.build())
                .build();
    }

    private static Biome createCranberryBog()
        {
            MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
            mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
            mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));
            mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BRAHMIN.get(), 1, 1, 1));
            BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();

            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("nukacraft:tree_cranberry",
                    FeatureUtils.register("nukacraft:cranberry_tree", Feature.TREE,
                            new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.CRANBERRYWOOD.get().defaultBlockState()),
                                    new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(ModBlocks.CRANBERRYLEAVES.get().defaultBlockState()),
                                    new AcaciaFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0)),
                                    new TwoLayersFeatureSize(1, 0, 1, OptionalInt.empty())).decorators(ImmutableList.of(new DewdropDecorator(0.4f), new DewdropDecorator(0.1f))).ignoreVines()
                                    .build()),
                    List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                            PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));


            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                    PlacementUtils.register("nukacraft:grass_ash", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));

            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                    PlacementUtils.register("nukacraft:crangrass", ModFeatures.PATCH_CRANGRASS, List.of(NoiseThresholdCountPlacement.of(-0.3D, 1, 12),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));

            ModDefaultFeatures.addCranBerryBogPlants(biomeGenerationSettings);
            ModDefaultFeatures.addCranberryBogOres(biomeGenerationSettings);

            BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
            BiomeDefaultFeatures.addSwampClayDisk(biomeGenerationSettings);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
            return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN)
                    .biomeCategory(Biome.BiomeCategory.SWAMP)
                    .temperature(0.8F)
                    .downfall(0.9F)
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(-11386816)
                            .waterFogColor(-11590620)
                            .fogColor(-10990522)
                            .skyColor(-3024201)
                            .foliageColorOverride(-6797754)
                            .grassColorOverride(-7714230)
                            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                            .build()).mobSpawnSettings(mobspawnsettings$builder.build())
                    .generationSettings(biomeGenerationSettings.build()).build();
        }

    private static Biome createGlowSea() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(16766566).waterColor(3882546).waterFogColor(2308637)
                .skyColor(16246715).foliageColorOverride(9076070).grassColorOverride(9076070).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:grass_ash", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:glowgrass", ModFeatures.PATCH_GLOWGRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 3, 3),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("nukacraft:stump_ashwood",
                FeatureUtils.register("nukacraft:stump_ash", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                                new StraightTrunkPlacer(1, 1, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                                .decorators(ImmutableList.of(new BBlightDecorator(0.2f), new SapDecorator(0.1f))).ignoreVines()
                                .build()),
                List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));

        mobspawnsettings$builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityTypes.DEATHCLAW.get(), 2, 1, 1));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));

        ModDefaultFeatures.addGlowSeaPlants(biomeGenerationSettings);
        ModDefaultFeatures.addGlowSeaOres(biomeGenerationSettings);

        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.DESERT).temperature(1.5f)
                .downfall(0.9f).specialEffects(effects).mobSpawnSettings(mobspawnsettings$builder.build()).generationSettings(biomeGenerationSettings.build())
                .build();
    }


    private static Biome createAshHeap() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-10990522).waterColor(-9551310).waterFogColor(11648455)
                .skyColor(-10990522).foliageColorOverride(-10465466).grassColorOverride(-11187642).ambientParticle(new AmbientParticleSettings(ParticleTypes.SMOKE, 0.0219f)).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:grass_ash", VegetationFeatures.PATCH_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("nukacraft:stump_ash_heap",
                FeatureUtils.register("nukacraft:stump_ash_heap", Feature.TREE,
                        new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.ASHWOOD.get().defaultBlockState()),
                                new StraightTrunkPlacer(1, 1, 0), BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
                                .decorators(ImmutableList.of(new BBlightDecorator(0.2f))).ignoreVines()
                                .build()),
                List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));

        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));


        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:heap_grass", ModFeatures.PATCH_HEAP_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                PlacementUtils.register("nukacraft:rusty_bush_patch", ModFeatures.PATCH_RUSTY_BUSH, List.of(NoiseThresholdCountPlacement.of(-0.4D, 2, 2),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));

        ModDefaultFeatures.addAshHeapDisks(biomeGenerationSettings);
        ModDefaultFeatures.addAshHeapPlants(biomeGenerationSettings);
        ModDefaultFeatures.addAshHeapOres(biomeGenerationSettings);


        return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.DESERT).temperature(1.2f)
                .downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobspawnsettings$builder.build()).generationSettings(biomeGenerationSettings.build())
                .build();
    }


    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
