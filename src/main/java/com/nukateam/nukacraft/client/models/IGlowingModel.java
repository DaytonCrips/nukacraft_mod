package com.nukateam.nukacraft.client.models;

import mod.azure.azurelib.core.animatable.GeoAnimatable;
import net.minecraft.resources.ResourceLocation;

public interface IGlowingModel<T extends GeoAnimatable> {
    ResourceLocation getGlowingTextureResource(T animatable);
}
