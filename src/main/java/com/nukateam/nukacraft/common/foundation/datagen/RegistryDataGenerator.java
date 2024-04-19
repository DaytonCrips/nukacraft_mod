package com.nukateam.nukacraft.common.foundation.datagen;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.ModBiomes;
import com.nukateam.nukacraft.common.foundation.world.ModWastelandPlacements;
import com.nukateam.nukacraft.common.foundation.world.WastelandDimensionsSettings;
import com.nukateam.nukacraft.common.foundation.world.WastelandVegetation;
import com.nukateam.nukacraft.common.foundation.world.features.ModConfiguredFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.ModFeatures;
import com.nukateam.nukacraft.common.foundation.world.features.ModOrePlacements;
import com.nukateam.nukacraft.common.foundation.world.features.OreFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RegistryDataGenerator extends DatapackBuiltinEntriesProvider {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
//			.add(Registries.BIOME, ModBiomes::bootstrap)
//			.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
//			.add(Registries.CONFIGURED_FEATURE, OreFeatures::bootstrap)
//			.add(Registries.CONFIGURED_FEATURE, ModFeatures::bootstrap)
//			.add(Registries.DIMENSION_TYPE, WastelandDimensionsSettings::bootstrapType)
//			.add(Registries.PLACED_FEATURE, ModWastelandPlacements::bootstrap)
//			.add(Registries.PLACED_FEATURE, WastelandVegetation::bootstrap)
//			.add(Registries.PLACED_FEATURE, ModOrePlacements::bootstrap)
//			.add(Registries.NOISE_SETTINGS, WastelandDimensionsSettings::bootstrapNoise)
			;

	public RegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
		super(output, provider, BUILDER, Set.of("minecraft", NukaCraftMod.MOD_ID));
	}
}
