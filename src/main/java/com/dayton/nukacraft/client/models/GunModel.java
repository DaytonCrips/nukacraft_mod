package com.dayton.nukacraft.client.models;


import com.dayton.guns.common.foundation.item.GunItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class GunModel extends GeoModel<GunItem> {
    @Override
    public ResourceLocation getModelResource(GunItem gunItem) {
        return getGunResource(gunItem, "geo/guns/", ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GunItem gunItem) {
        return getGunResource(gunItem, "textures/guns/" + gunItem.getName()+ "/", ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(GunItem gunItem) {
        return getGunResource(gunItem, "animations/guns/", ".animation.json");
    }

    public static ResourceLocation getGunResource(GunItem gunItem, String path, String extension){
        var name = gunItem.getName();
        var modId = gunItem.getRegistryName().getNamespace();

        return new ResourceLocation(modId, path + name + extension);
    }
}
