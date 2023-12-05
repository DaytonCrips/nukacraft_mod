package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModDefaultFeatures {



    public static void addWastelandOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ALUMI);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_LEAD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_SILVER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_BTITAN);
    }


    public static void addWastelandFlowerCommon(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_WASTELAND_FLOWER_COMMON);
    }
    public static void addWastelandFlowerRare(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_WASTELAND_FLOWER_RARE);
    }


    public static void addWastelandCranberry(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_CRANBERRY);
    }

    public static void addSittbeans(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_SITTBEAN_BUSH);
    }

    public static void addGlowSeaFlower(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.GLOW_FLOWER_DEFAULT);
    }


    public static void addGlowSeaExotics(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.GLOW_EXOTICS);
    }
    public static void addWastelandBerrys(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_WASTELAND_BERRYS);
    }
    public static void addWastelandThistle(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_THISTLE_BUSH);
    }

    public static void addBloodLeaf(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_BLOODLEAF);
    }

    public static void addDaturan(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_DATURANS);
    }
    public static void addCorallLeaf(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_CORALL);
    }
    public static void addPunga(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_PUNGA);
    }

    public static void addBBlight(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_BBLIGHT);
    }
    public static void addAgave(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_AGAVE_RARE);
    }
    public static void addGins(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_GINS);
    }
    public static void addXander(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_ZANDER);
    }
    public static void addWastelandMushrooms(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_WASTELAND_MUSHROOMS);
    }

    public static void MonsterWastelandSpawns(MobSpawnSettings.Builder builder) {
        //builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityTypes.RADROACH.get(), 1, 1, 1));
        //builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityTypes.BLOATFLY.get(), 1, 1, 1));
        //builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityTypes.DEATHCLAW.get(), 1, 1, 1));
    }

    public static void CreatureWastelandSpawns(MobSpawnSettings.Builder builder) {
        //builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityTypes.BRAHMIN.get(), 1, 1, 2));

    }
}
