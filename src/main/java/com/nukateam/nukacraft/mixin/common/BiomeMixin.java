package com.nukateam.nukacraft.mixin.common;

import com.nukateam.nukacraft.common.data.interfaces.IBiomeSettings;
import com.nukateam.nukacraft.common.foundation.world.BiomeSettings;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Biome.class)
public class BiomeMixin implements IBiomeSettings {
    private BiomeSettings settings = new BiomeSettings();

    @Override
    public void setSettings(BiomeSettings fogDensity) {
        this.settings = fogDensity;
    }

    @Override
    public BiomeSettings getSettings() {
        return settings;
    }
}
