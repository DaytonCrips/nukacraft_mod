package com.nukateam.guns.client.model;

import com.nukateam.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class RightHandModel<T extends IResourceProvider & GeoAnimatable> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T geoAnimatable) {
        return nukaResource("geo/hand/gun_hands.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T geoAnimatable) {
        var player = Minecraft.getInstance().player;
        if(player != null) return player.getSkinTextureLocation();
        return null;
    }

    @Override
    public ResourceLocation getAnimationResource(T geoAnimatable) {
        return nukaResource("animations/hand/hands.animation.json");
    }
}
