package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

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
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ALUMI);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_LOWER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ULTRACITE);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_IRON_SMALL);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_IRON_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_LEAD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_SILVER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_BTITAN);
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
}
