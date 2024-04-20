package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.foundation.world.features.ModDefaultFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.placed.ModVegetationPlacements;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;


public class ModBiomes {
    public static final ResourceKey<Biome> POISON_VALLEY = createKey("poison_valley");
    public static final ResourceKey<Biome> GLOW_SEA = createKey("glow_sea");
    public static final ResourceKey<Biome> ASH_HEAP = createKey("ash_heap");
    public static final ResourceKey<Biome> CRANBERRY_BOG = createKey("cranberry_bog");

    public static void bootstrap(BootstapContext<Biome> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var worldCarvers = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(POISON_VALLEY, createPoisonValley(placedFeatures, worldCarvers));
        context.register(CRANBERRY_BOG, createCranberryBog(placedFeatures, worldCarvers));
        context.register(ASH_HEAP     , createAshHeap     (placedFeatures, worldCarvers));
        context.register(GLOW_SEA     , createGlowSea     (placedFeatures, worldCarvers));
    }

    private static Biome createPoisonValley(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        var mobBuilder = new MobSpawnSettings.Builder();
        var biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        var effects = new BiomeSpecialEffects.Builder()
                .fogColor(-5399162)
                .waterColor(-9547964)
                .waterFogColor(11648455)
                .skyColor(-7964315)
                .foliageColorOverride(1783388)
                .grassColorOverride(-861768)
                .build();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.ASH_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.POISON_GRASS);

        ModDefaultFeatures.addAshTrees(biomeBuilder);
        ModDefaultFeatures.addAshStone(biomeBuilder);
        ModDefaultFeatures.addAcidLake(biomeBuilder);
        ModDefaultFeatures.addPoisonValleyPlants(biomeBuilder);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.5f)
                .downfall(0.5f)
                .specialEffects(effects)
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static Biome createCranberryBog(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        var mobBuilder = new MobSpawnSettings.Builder();
        var biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        var effects = new BiomeSpecialEffects.Builder()
                .fogColor(-10990522)
                .waterColor(-11386816)
                .waterFogColor(-11590620)
                .skyColor(-3024201)
                .foliageColorOverride(-6797754)
                .grassColorOverride(-7714230)
                .build();

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BRAHMIN .get(), 1, 1, 1));

        ModDefaultFeatures.addDewdropTrees(biomeBuilder);
        BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);

        ModDefaultFeatures.addCranBerryBogPlants(biomeBuilder);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.8F)
                .downfall(0.9F)
                .specialEffects(effects)
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static Biome createGlowSea(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        var mobBuilder = new MobSpawnSettings.Builder();
        var biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        var effects = new BiomeSpecialEffects.Builder()
                .fogColor(16766566)
                .waterColor(3882546)
                .waterFogColor(2308637)
                .skyColor(16246715)
                .foliageColorOverride(9076070)
                .grassColorOverride(9076070)
                .build();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.GRASS_ASH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.GLOW_GRASS);

        ModDefaultFeatures.addGlowTrees(biomeBuilder);

        mobBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityTypes.DEATHCLAW.get(), 2, 1, 1));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));

        ModDefaultFeatures.addGlowSeaPlants(biomeBuilder);


        return (new Biome.BiomeBuilder())
                .hasPrecipitation(false)
//                .biomeCategory(Biome.BiomeCategory.DESERT)
                .temperature(1.5f)
                .downfall(0.9f).specialEffects(effects)
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }


    private static Biome createAshHeap(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        var mobBuilder = new MobSpawnSettings.Builder();
        var biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        var effects = new BiomeSpecialEffects.Builder()
                .fogColor(-10990522)
                .waterColor(-9551310)
                .waterFogColor(11648455)
                .skyColor(-10990522)
                .foliageColorOverride(-10465466)
                .grassColorOverride(-11187642)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.SMOKE, 0.0219f))
                .build();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.GRASS_ASH);
        ModDefaultFeatures.addAshHeapTrees(biomeBuilder);

        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.HEAP_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.RUSTY_BUSH);

        ModDefaultFeatures.addAshHeapDisks(biomeBuilder);
        ModDefaultFeatures.addAshHeapPlants(biomeBuilder);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(false)
//                .biomeCategory(Biome.BiomeCategory.DESERT)
                .temperature(1.2f)
                .downfall(0.5f).specialEffects(effects)
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, nukaResource(name));
    }
}
