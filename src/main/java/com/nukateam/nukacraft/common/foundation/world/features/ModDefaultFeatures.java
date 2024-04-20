package com.nukateam.nukacraft.common.foundation.world.features;

import com.nukateam.nukacraft.common.foundation.world.features.placed.BiomePlacements;
import com.nukateam.nukacraft.common.foundation.world.features.placed.ModOrePlacements;
import com.nukateam.nukacraft.common.foundation.world.features.placed.ModTreePlacements;
import com.nukateam.nukacraft.common.foundation.world.features.placed.ModVegetationPlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModDefaultFeatures {

    public static void addAshTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModTreePlacements.TREES_ASH);
    }

    public static void addDewdropTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModTreePlacements.TREES_DEWDROP);
    }

    public static void addAshHeapTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModTreePlacements.TREES_ASH_HEAP);
    }

    public static void addGlowTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModTreePlacements.TREES_GLOW);
    }

    public static void copperOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COPPER);
    }

    public static void coalOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_UPPER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COAL_LOWER);
    }

    public static void alumiOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_COPPER);
    }
    public static void ultraciteOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_ULTRACITE);
    }

    public static void uranOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_URAN);
    }

    public static void ironOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_IRON_SMALL);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_IRON_UPPER);
    }

    public static void leadOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_LEAD);
    }

    public static void silverOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_SILVER);
    }

    public static void blackTitanOre(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_BLACK_TITAN);
    }

    public static void addPoisonValleyOres(BiomeGenerationSettings.Builder builder) {
        //  alumiOre(builder);
        //copperOre(builder);
        coalOre(builder);
    }

    public static void addCranberryBogOres(BiomeGenerationSettings.Builder builder) {
        //alumiOre(builder);
        coalOre(builder);
        //ultraciteOre(builder);
    }

    public static void addGlowSeaOres(BiomeGenerationSettings.Builder builder) {
        //uranOre(builder);
        coalOre(builder);
        //ultraciteOre(builder);
    }

    public static void addAshHeapOres(BiomeGenerationSettings.Builder builder) {
        //alumiOre(builder);
        //copperOre(builder);
        coalOre(builder);
        //ironOre(builder);
        //leadOre(builder);
        //silverOre(builder);
        //btitanOre(builder);
    }
//
//    public static void addWastelandAluminium(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ALUMINIUM);
//    }
//
//
//    public static void addWastelandCopper(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_COPPER);
//    }
//    public static void addWastelandCoal(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_COAL_UPPER);
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_COAL_LOWER);
//    }
//
//    public static void addWastelandIron(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_IRON_SMALL);
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacements.ORE_IRON_UPPER);
//    }
//    public static void addWastelandLead(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_LEAD);
//    }
//    public static void addWastelandSilver(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_SILVER);
//    }
//    public static void addWastelandBTitan(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_BLACK_TITAN);
//    }
//    public static void addWastelandUltracite(BiomeGenerationSettings.Builder builder) {
//        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ULTRACITE);
//    }

    public static void addAcidLake(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.LAKES, BiomePlacements.LAKE_ACID_SURFACE);
    }

    public static void addAshStone(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, BiomePlacements.DISK_ASHSTONE);
    }

    public static void addPoisonValleyPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_BROC_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_ASTER_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_THISTLE_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_DEAD_PLANT_PLACE);
    }

    public static void addCranBerryBogPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_TOXIC_FERN_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_DEWDROP_SAPLING_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_DEAD_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_GUT_FUNGI_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_CRANBERRY_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, net.minecraft.data.worldgen.placement.VegetationPlacements.PATCH_SUGAR_CANE_SWAMP);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, net.minecraft.data.worldgen.placement.VegetationPlacements.PATCH_GRASS_NORMAL);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, net.minecraft.data.worldgen.placement.VegetationPlacements.PATCH_DEAD_BUSH);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, net.minecraft.data.worldgen.placement.VegetationPlacements.PATCH_WATERLILY);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_BOGPAD_PLACE);
    }

    public static void addGlowSeaPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_BOMB_BERRY_BUSH_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_RADROSE_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_FUSION_FRUIT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_MEGA_HATTER_PLACE);
    }

    public static void addAshHeapDisks(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, BiomePlacements.DISK_ASHDIRT);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);
    }

    public static void addAshHeapPlants(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_ZANDER);
        //builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_RUSTY_BUSH);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_CRACKBERRY_BUSH_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_SOOT_FLOWER_PLANT_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_FIRE_FUNGI_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_GLOW_FUNGUS_PLACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacements.PATCH_STARLIGHT_BERRY);
    }
}
