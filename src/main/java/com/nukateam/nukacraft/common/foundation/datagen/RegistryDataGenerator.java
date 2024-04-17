package com.nukateam.nukacraft.common.foundation.datagen;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.ModWastelandPlacements;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RegistryDataGenerator extends DatapackBuiltinEntriesProvider {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.PLACED_FEATURE, ModWastelandPlacements::bootstrap);


//			.add(Registries.CONFIGURED_FEATURE, TFConfiguredFeatures::bootstrap)
//			.add(Registries.PLACED_FEATURE, TFPlacedFeatures::bootstrap)
//			.add(TFRegistries.Keys.STRUCTURE_SPELEOTHEM_SETTINGS, StructureSpeleothemConfigs::bootstrap)
//			.add(Registries.STRUCTURE, TFStructures::bootstrap)
//			.add(Registries.STRUCTURE_SET, TFStructureSets::bootstrap)
//			.add(Registries.CONFIGURED_CARVER, TFCaveCarvers::bootstrap)
//			.add(Registries.DENSITY_FUNCTION, TFDensityFunctions::bootstrap)
//			.add(Registries.NOISE_SETTINGS, TFDimensionData::bootstrapNoise)
//			.add(TFRegistries.Keys.BIOME_STACK, BiomeLayerStack::bootstrap)
//			.add(TFRegistries.Keys.BIOME_TERRAIN_DATA, BiomeLayerStack::bootstrapData)
//			.add(Registries.DIMENSION_TYPE, TFDimensionData::bootstrapType)
//			.add(Registries.LEVEL_STEM, TFDimensionData::bootstrapStem)
//			.add(Registries.BIOME, TFBiomes::bootstrap)
//			.add(TFRegistries.Keys.WOOD_PALETTES, WoodPalettes::bootstrap)
//			.add(Registries.DAMAGE_TYPE, TFDamageTypes::bootstrap)
//			.add(Registries.TRIM_MATERIAL, TFTrimMaterials::bootstrap)
//			.add(TFRegistries.Keys.RESTRICTIONS, Restrictions::bootstrap)
//			.add(TFRegistries.Keys.MAGIC_PAINTINGS, MagicPaintingVariants::bootstrap)
//			.add(TFRegistries.Keys.CHUNK_BLANKET_PROCESSORS, ChunkBlanketProcessors::bootstrap);

	public RegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
		super(output, provider, BUILDER, Set.of("minecraft", NukaCraftMod.MOD_ID));
	}
}
