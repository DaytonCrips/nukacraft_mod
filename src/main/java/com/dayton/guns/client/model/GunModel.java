package com.dayton.guns.client.model;

import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class GunModel<T extends IResourceProvider & GeoAnimatable> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T gunItem) {
        return getGunResource(gunItem, "geo/guns/", ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T gunItem) {
        return getGunResource(gunItem, "textures/guns/" + gunItem.getName() + "/", ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(T gunItem) {
        return getGunResource(gunItem, "animations/guns/", ".animation.json");
    }

    public static ResourceLocation getGunResource(IResourceProvider gunItem, String path, String extension){
        var name = gunItem.getName();
        var modId = gunItem.getNamespace();

        return new ResourceLocation(modId, path + name + extension);
    }
}
