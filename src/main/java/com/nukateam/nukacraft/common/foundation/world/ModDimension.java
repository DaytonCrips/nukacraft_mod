package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimension {
    public static final ResourceKey<Level> FALLOUT_WASTELAND = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(NukaCraftMod.MOD_ID, "fallout_wasteland"));
    public static final ResourceKey<DimensionType> FALLOUT_WASTELAND_TYPE =
            ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, FALLOUT_WASTELAND.getRegistryName());

    public static void register() {
        System.out.println("Registering ModDimensions for " + NukaCraftMod.MOD_ID);
    }
}
