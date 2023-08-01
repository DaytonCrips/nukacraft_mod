package com.dayton.nukacraft.common.world.gen;

import com.dayton.nukacraft.init.biomes.ModBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModBiomeGeneration {
    public static final void generateBiomes() {
        addBiome(ModBiomes.POISON_VALLEY.get(), 4, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.CONIFEROUS);
        addBiome(ModBiomes.GLOW_SEA.get(), 1, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.MESA, BiomeDictionary.Type.CONIFEROUS);
        addBiome(ModBiomes.ASH_HEAP.get(), 3, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SANDY);
        addBiome(ModBiomes.CRANBERRY_BOG.get(), 2, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.HOT);


    }



    private static void addBiome(Biome biome, int weight, BiomeDictionary.Type... types) {
        ResourceKey<Biome> key = ResourceKey.create(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));
    }
}
