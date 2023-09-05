package com.dayton.nukacraft.common.world;

import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModDefaultFeatures {



    public static void addWastelandOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ALUMI);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_LEAD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_SILVER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_BTITAN);
    }

    public static void addGlowSeaFeatures(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_BOMBBERRY_RARE);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.GLOW_FLOWER_DEFAULT);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_QUANTLEAF);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_MINDFUNGUS_BUSH);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_NEUTRON_BUSH);
    }
    public static void addCranberryBogFeatures(BiomeGenerationSettings.Builder pBuilder) {


        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_STARBERRY);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_CRANBERRY);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_BBLIGHT);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_CORALL);
    }
    public static void addAshHeapFeatures(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_BRAINFUNG_BUSH);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.ASHHEAP_FLOWER_DEFAULT);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_PUNGA);

    }

    public static void addPoisonValleyFeatures(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_GINS);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_CRACKBERRY_RARE);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.POISON_FLOWER_DEFAULT);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_THISTLE_BUSH);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_HOLLYHOCK);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_DATURANS);

    }

    public static void addWastelandExoticsFeatures(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_SITTBEAN_BUSH);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_GLOWFUNGUS_BUSH);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_ZANDER);
    }
    public static void addWastelandCommonsFeatures(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_AGAVE_RARE);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_MUTTFRUIT);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WastelandVegetation.PATCH_BLOODLEAF);
    }
}
