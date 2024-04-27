package com.nukateam.nukacraft.common.registery.datagen;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.world.ModBiomes;
import com.nukateam.nukacraft.common.foundation.world.WastelandDimensionsSettings;
import com.nukateam.nukacraft.common.foundation.world.features.FeatureRegistry;
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
            .add(Registries.DIMENSION_TYPE, WastelandDimensionsSettings::bootstrapType)
            .add(Registries.CONFIGURED_FEATURE, FeatureRegistry::bootstrapConfigured)
            .add(Registries.PLACED_FEATURE, FeatureRegistry::bootstrapPlaced)
            .add(Registries.NOISE_SETTINGS, WastelandDimensionsSettings::bootstrapNoise);

    public RegistryDataGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider, BUILDER, Set.of("minecraft", NukaCraftMod.MOD_ID));
    }
}
