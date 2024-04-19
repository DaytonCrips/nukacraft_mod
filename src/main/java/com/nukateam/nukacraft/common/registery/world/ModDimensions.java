package com.nukateam.nukacraft.common.registery.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class ModDimensions {
    public static final ResourceLocation WASTELAND = nukaResource("fallout_wasteland");

    public static final ResourceKey<Level> WASTELAND_DIMENSION = ResourceKey.create(Registries.DIMENSION, WASTELAND);
}
