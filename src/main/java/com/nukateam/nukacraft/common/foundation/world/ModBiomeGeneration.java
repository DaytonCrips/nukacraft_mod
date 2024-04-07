package com.nukateam.nukacraft.common.foundation.world;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModBiomeGeneration {
    public static void generateBiomes() {
        addBiome(ModBiomes.POISON_VALLEY.get());
        addBiome(ModBiomes.GLOW_SEA.get());
        addBiome(ModBiomes.ASH_HEAP.get());
        addBiome(ModBiomes.CRANBERRY_BOG.get());
    }

    private static void addBiome(Biome biome) {
        ResourceKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));
    }
}
