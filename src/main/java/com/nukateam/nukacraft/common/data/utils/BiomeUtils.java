package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeUtils {
    public static boolean isInGlowSea(Level level, BlockPos pos, BlockState state) {
        var glowSeaResource = new ResourceLocation(NukaCraftMod.MOD_ID, "glow_sea");
        var biomesKey = ForgeRegistries.BIOMES.getKey(level.getBiome(pos).value());

        return glowSeaResource.equals(biomesKey);
    }
}
