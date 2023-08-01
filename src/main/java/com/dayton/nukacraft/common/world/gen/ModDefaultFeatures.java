package com.dayton.nukacraft.common.world.gen;

import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModDefaultFeatures {



    public static void addWastelandOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_ALUMI);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_LEAD);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_SILVER);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOreFeatures.ORE_BTITAN);
    }
}
