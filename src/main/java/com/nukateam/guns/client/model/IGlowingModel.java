package com.nukateam.guns.client.model;

import com.nukateam.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import net.minecraft.resources.ResourceLocation;

public interface IGlowingModel<T extends GeoAnimatable> {
    ResourceLocation getGlowingTextureResource(T gunItem);
}
