package com.nukateam.nukacraft.common.foundation.datagen;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.FeatureRegistry;
import com.nukateam.nukacraft.common.foundation.world.ModBiomes;
import com.nukateam.nukacraft.common.foundation.world.features.configured.ModFeatures;
import com.nukateam.nukacraft.common.foundation.world.WastelandDimensionsSettings;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RegistryDataGenerator extends DatapackBuiltinEntriesProvider {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.BIOME, ModBiomes::bootstrap)
//			.add(Registries.CONFIGURED_FEATURE, ModTreeFeatures::bootstrap)
//			.add(Registries.CONFIGURED_FEATURE, OreFeatures::bootstrap)
			.add(Registries.CONFIGURED_FEATURE, ModFeatures::bootstrap)
			.add(Registries.CONFIGURED_FEATURE, FeatureRegistry::bootstrapConfigured)
			.add(Registries.DIMENSION_TYPE, WastelandDimensionsSettings::bootstrapType)
//			.add(Registries.PLACED_FEATURE, ModWastelandPlacements::bootstrap)
//			.add(Registries.PLACED_FEATURE, WastelandVegetation::bootstrap)
//			.add(Registries.PLACED_FEATURE, ModOrePlacements::bootstrap)
			.add(Registries.NOISE_SETTINGS, WastelandDimensionsSettings::bootstrapNoise)
			;

	public RegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
		super(output, provider, BUILDER, Set.of("minecraft", NukaCraftMod.MOD_ID));
	}
}
