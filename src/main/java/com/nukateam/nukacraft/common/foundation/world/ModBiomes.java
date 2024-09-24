package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.foundation.world.features.ModDefaultFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.placed.ModVegetationPlacements;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.core.Holder;
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

import javax.annotation.Nullable;
import java.util.HashMap;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModBiomes {
    public static final ResourceKey<Biome> POISON_VALLEY = createKey("poison_valley");
    public static final ResourceKey<Biome> GLOW_SEA = createKey("glow_sea");
    public static final ResourceKey<Biome> ASH_HEAP = createKey("ash_heap");
    public static final ResourceKey<Biome> CRANBERRY_BOG = createKey("cranberry_bog");
    public static final ResourceKey<Biome> SAVAGE_DIVIDE = createKey("savage_divide");

    private static final HashMap<ResourceKey<Biome>, BiomeSettings> biomeSettings = new HashMap<>();

    public static void bootstrap(BootstapContext<Biome> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var worldCarvers = context.lookup(Registries.CONFIGURED_CARVER);

        context.register(POISON_VALLEY  , createPoisonValley(placedFeatures, worldCarvers));
        context.register(CRANBERRY_BOG  , createCranberryBog(placedFeatures, worldCarvers));
        context.register(ASH_HEAP       , createAshHeap(placedFeatures, worldCarvers));
        context.register(GLOW_SEA       , createGlowSea(placedFeatures, worldCarvers));
        context.register(SAVAGE_DIVIDE       , createSavageDivide(placedFeatures, worldCarvers));
//        BiomeSettings
    }

    public static void setupBiomeSettings() {
        biomeSettings.put(POISON_VALLEY , new BiomeSettings().setFogDensity(1.0f));
        biomeSettings.put(CRANBERRY_BOG , new BiomeSettings().setFogDensity(1.0f));
        biomeSettings.put(ASH_HEAP      , new BiomeSettings().setFogDensity(0.5f));
        biomeSettings.put(GLOW_SEA      , new BiomeSettings().setFogDensity(0.05f));
        biomeSettings.put(SAVAGE_DIVIDE      , new BiomeSettings().setFogDensity(1.0f));
    }

    @Nullable
    public static BiomeSettings getBiomeSettings(Holder<Biome> biome){
        for (var key: biomeSettings.keySet()) {
            if(biome.is(key)){
                return biomeSettings.get(key);
            }
        }
        return null;
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


        //ModDefaultFeatures.addPoisonValleyOres(biomeBuilder);

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

    private static Biome createSavageDivide(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        var mobBuilder = new MobSpawnSettings.Builder();
        //var settingsd = (IBiomeSettings)placedFeatures;

        var biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        var effects = new BiomeSpecialEffects.Builder()
                .fogColor(-10990522)
                .waterColor(-11386816)
                .waterFogColor(-11386816)
                .skyColor(16246715)
                .foliageColorOverride(-861668)
                .grassColorOverride(-861668)
                .build();

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.STRANGE_GRASS);

        //ModDefaultFeatures.addSavageDivideOres(biomeBuilder);

        ModDefaultFeatures.addImmortalGreenTrees(biomeBuilder);
        ModDefaultFeatures.addCommonBerryBush(biomeBuilder);
        ModDefaultFeatures.addRustyTrees(biomeBuilder);
        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addTaigaGrass(biomeBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);

//        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.ASH_GRASS);
//        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.POISON_GRASS);
//


//        ModDefaultFeatures.addAshStone(biomeBuilder);
//        ModDefaultFeatures.addAcidLake(biomeBuilder);
//        ModDefaultFeatures.addPoisonValleyPlants(biomeBuilder);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.7f)
                .downfall(0.4f)
                .specialEffects(effects)
                .mobSpawnSettings(mobBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    private static void createBiomeSettings(Biome biome, BiomeSettings settings){
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
        mobBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BRAHMIN.get(), 1, 1, 1));

        //ModDefaultFeatures.addCranberryBogOres(biomeBuilder);

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

        //ModDefaultFeatures.addGlowSeaOres(biomeBuilder);

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

        //ModDefaultFeatures.addAshHeapOres(biomeBuilder);

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
