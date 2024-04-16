package com.nukateam.nukacraft.common.foundation.world;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class WastelandDimensions {
    public static final ResourceKey<Level> WASTELAND = ResourceKey.create(Registries.DIMENSION, nukaResource("fallout_wasteland"));
}
