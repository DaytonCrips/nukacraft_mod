package com.nukateam.nukacraft.client.models.armors;


import com.nukateam.example.common.data.interfaces.IResourceProvider;
import com.nukateam.nukacraft.client.models.IGlowingModel;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class StaticArmorModel<T extends IResourceProvider & GeoAnimatable> extends GeoModel<T> implements IGlowingModel<T> {
    public static ResourceLocation getResource(IResourceProvider gunItem, String path, String extension) {
        var name = gunItem.getName();
        var modId = gunItem.getNamespace();
        var resourceManager = Minecraft.getInstance().getResourceManager();
        var location = new ResourceLocation(modId, path + name + extension);

        if(resourceManager.getResource(location).isPresent()){
            return location;
        }

        return null;
    }

    @Override
    public ResourceLocation getModelResource(T gunItem) {
        return getResource(gunItem, "geo/armor/", ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T gunItem) {
        return getResource(gunItem, "textures/armor/" + gunItem.getName() + "/", ".png");
    }

    @Override
    public ResourceLocation getGlowingTextureResource(T animatable) {
        return getResource(animatable, "textures/armor/" + animatable.getName() + "/", "_glowmask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T gunItem) {
        return null;
    }

    @Override
    public RenderType getRenderType(T animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }
}
