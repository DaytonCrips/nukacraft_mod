package com.nukateam.nukacraft.common.foundation.datagen;

import com.nukateam.nukacraft.*;
import com.nukateam.nukacraft.common.foundation.world.features.*;
import com.nukateam.nukacraft.common.foundation.world.*;
import com.nukateam.nukacraft.common.foundation.world.features.configured.*;
import net.minecraft.core.*;
import net.minecraft.core.registries.*;
import net.minecraft.data.*;
import net.minecraftforge.common.data.*;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RegistryDataGenerator extends DatapackBuiltinEntriesProvider {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.BIOME, ModBiomes::bootstrap)
			.add(Registries.DIMENSION_TYPE, WastelandDimensionsSettings::bootstrapType)
			.add(Registries.CONFIGURED_FEATURE, FeatureRegistry::bootstrapConfigured)
			.add(Registries.PLACED_FEATURE, FeatureRegistry::bootstrapPlaced)
			.add(Registries.NOISE_SETTINGS, WastelandDimensionsSettings::bootstrapNoise)
			;

	public RegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
		super(output, provider, BUILDER, Set.of("minecraft", NukaCraftMod.MOD_ID));
	}
}
