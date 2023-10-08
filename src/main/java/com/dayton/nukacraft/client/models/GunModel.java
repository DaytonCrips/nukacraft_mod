package com.dayton.nukacraft.client.models;


import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.nukacraft.common.data.interfaces.INameable;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class GunModel<T extends INameable & GeoAnimatable> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T gunItem) {
        return getGunResource(gunItem, "geo/guns/", ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T gunItem) {
        return getGunResource(gunItem, "textures/guns/" + gunItem.getName()+ "/", ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(T gunItem) {
        return getGunResource(gunItem, "animations/guns/", ".animation.json");
    }

    public static ResourceLocation getGunResource(INameable gunItem, String path, String extension){
        var name = gunItem.getName();
        var modId = gunItem.getNamespace();

        return new ResourceLocation(modId, path + name + extension);
    }
}
