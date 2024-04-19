package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.features.ModDefaultFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.ModFeatures;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;


public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, NukaCraftMod.MOD_ID);

    public static final ResourceKey<Biome> POISON_VALLEY = createKey("poison_valley");

    public static final ResourceKey<Biome> GLOW_SEA = createKey("glow_sea");

    public static final ResourceKey<Biome> ASH_HEAP = createKey("ash_heap");

    public static final ResourceKey<Biome> CRANBERRY_BOG = createKey("cranberry_bog");

    public static void bootstrap(BootstapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> worldCarvers = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(POISON_VALLEY, createPoisonValley(placedFeatures, worldCarvers));
        context.register(GLOW_SEA, createGlowSea(placedFeatures, worldCarvers));
        context.register(ASH_HEAP, createAshHeap(placedFeatures, worldCarvers));
        context.register(CRANBERRY_BOG, createCranberryBog(placedFeatures, worldCarvers));
    }

    private static Biome createPoisonValley(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(-5399162)
                .waterColor(-9547964)
                .waterFogColor(11648455)
                .skyColor(-7964315)
                .foliageColorOverride(1783388)
                .grassColorOverride(-861768)
                .build();

        var biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModWastelandPlacements.ASH_GRASSS);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModWastelandPlacements.POISON_GRASS);

        ModDefaultFeatures.addAshTrees(biomeGenerationSettings);
        ModDefaultFeatures.addAshStone(biomeGenerationSettings);
        ModDefaultFeatures.addAcidLake(biomeGenerationSettings);
        ModDefaultFeatures.addPoisonValleyPlants(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
//                .biomeCategory(Biome.BiomeCategory.NONE)
                .temperature(0.5f)
                .downfall(0.5f)
                .specialEffects(effects)
                .mobSpawnSettings(builder.build())
                .generationSettings(biomeGenerationSettings.build())
                .build();
    }

    private static Biome createCranberryBog(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));
        mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BRAHMIN.get(), 1, 1, 1));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);

        ModDefaultFeatures.addDewdropTrees(biomeGenerationSettings);

        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_NORMAL);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModWastelandPlacements.CRANBERRY_GRASS);

        ModDefaultFeatures.addCranBerryBogPlants(biomeGenerationSettings);

        BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
        BiomeDefaultFeatures.addSwampClayDisk(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
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
                        .build())
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeGenerationSettings.build()).build();
    }

    private static Biome createGlowSea(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(16766566).waterColor(3882546).waterFogColor(2308637)
                .skyColor(16246715).foliageColorOverride(9076070).grassColorOverride(9076070).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);

        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModWastelandPlacements.GRASS_ASH);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModWastelandPlacements.GLOW_GRASS);

        ModDefaultFeatures.addGlowTrees(biomeGenerationSettings);

        mobSpawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityTypes.DEATHCLAW.get(), 2, 1, 1));
        mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));

        ModDefaultFeatures.addGlowSeaPlants(biomeGenerationSettings);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
//                .biomeCategory(Biome.BiomeCategory.DESERT)
                .temperature(1.5f)
                .downfall(0.9f).specialEffects(effects)
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeGenerationSettings.build())
                .build();
    }


    private static Biome createAshHeap(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnBuilder = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-10990522).waterColor(-9551310).waterFogColor(11648455)
                .skyColor(-10990522).foliageColorOverride(-10465466).grassColorOverride(-11187642).ambientParticle(new AmbientParticleSettings(ParticleTypes.SMOKE, 0.0219f)).build();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);

        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModWastelandPlacements.GRASS_ASH);

        ModDefaultFeatures.addAshHeapTrees(biomeGenerationSettings);

        mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        mobSpawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));

        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModWastelandPlacements.HEAP_GRASS);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModWastelandPlacements.RUSTY_BUSH);


        ModDefaultFeatures.addAshHeapDisks(biomeGenerationSettings);
        ModDefaultFeatures.addAshHeapPlants(biomeGenerationSettings);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
//                .biomeCategory(Biome.BiomeCategory.DESERT)
                .temperature(1.2f)
                .downfall(0.5f).specialEffects(effects)
                .mobSpawnSettings(mobSpawnBuilder.build())
                .generationSettings(biomeGenerationSettings.build())
                .build();
    }


    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }

    private static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, nukaResource(name));
    }
}
