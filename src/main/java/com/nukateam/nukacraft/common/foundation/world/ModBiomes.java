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
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
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
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BRAHMIN.get(), 1, 1, 1));

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();

        ModDefaultFeatures.addGrassPoison(biomeGenerationSettings);
        ModDefaultFeatures.addGrassToxic(biomeGenerationSettings);
        ModDefaultFeatures.addGrassAsh(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);

        ModDefaultFeatures.addAshStone(biomeGenerationSettings);
        ModDefaultFeatures.addAcidLake(biomeGenerationSettings);


        ModDefaultFeatures.addPoisonValleyPlants(biomeGenerationSettings);
        ModDefaultFeatures.addTreePoison(biomeGenerationSettings);



        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);


        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.NONE)
                .temperature(0.5F)
                .downfall(0.5F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(-9547964)
                        .waterFogColor(11648455)
                        .fogColor(-5399162)
                        .skyColor(-7964315)
                        .foliageColorOverride(1783388)
                        .grassColorOverride(-861768)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build()).mobSpawnSettings(mobspawnsettings$builder.build())
                .generationSettings(biomeGenerationSettings.build()).build();

    }





    private static Biome createCranberryBog()
        {
            MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
            mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
            mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));
            mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BRAHMIN.get(), 1, 1, 1));
            BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();

            ModDefaultFeatures.addGrassAsh(biomeGenerationSettings);
            ModDefaultFeatures.addGrassCranberry(biomeGenerationSettings);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
            BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);

            BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
            BiomeDefaultFeatures.addSwampClayDisk(biomeGenerationSettings);

            ModDefaultFeatures.addTreeCranberry(biomeGenerationSettings);

            ModDefaultFeatures.addCranBerryBogPlants(biomeGenerationSettings);




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
        mobspawnsettings$builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityTypes.DEATHCLAW.get(), 2, 1, 1));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();

        ModDefaultFeatures.addGrassAsh(biomeGenerationSettings);
        ModDefaultFeatures.addGlowGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);

        ModDefaultFeatures.addStumpGlow(biomeGenerationSettings);


        ModDefaultFeatures.addGlowSeaPlants(biomeGenerationSettings);


        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.NONE)
                .temperature(1.5F)
                .downfall(0.9F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(3882546)
                        .waterFogColor(2308637)
                        .fogColor(16766566)
                        .skyColor(16246715)
                        .foliageColorOverride(9076070)
                        .grassColorOverride(9076070)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build()).mobSpawnSettings(mobspawnsettings$builder.build())
                .generationSettings(biomeGenerationSettings.build()).build();

    }


    private static Biome createAshHeap() {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();

        ModDefaultFeatures.addGrassAsh(biomeGenerationSettings);
        ModDefaultFeatures.addHeapGrass(biomeGenerationSettings);
        ModDefaultFeatures.addRustyBush(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);

        ModDefaultFeatures.addAshHeapDisks(biomeGenerationSettings);

        ModDefaultFeatures.addStumpHeap(biomeGenerationSettings);




        ModDefaultFeatures.addAshHeapPlants(biomeGenerationSettings);

        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.NONE)
                .temperature(1.2F)
                .downfall(0.5F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(-9551310)
                        .waterFogColor(11648455)
                        .fogColor(-10990522)
                        .skyColor(-10990522)
                        .foliageColorOverride(-10465466)
                        .grassColorOverride(-11187642)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build()).mobSpawnSettings(mobspawnsettings$builder.build())
                .generationSettings(biomeGenerationSettings.build()).build();




    }






    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
