package com.nukateam.nukacraft.common.foundation.world;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeSettings {
    private float fogDensity = 1.0f;

    public float getFogDensity() {
        return fogDensity;
    }

    public BiomeSettings setFogDensity(float fogDensity) {
        this.fogDensity = fogDensity;
        return this;
    }
}
