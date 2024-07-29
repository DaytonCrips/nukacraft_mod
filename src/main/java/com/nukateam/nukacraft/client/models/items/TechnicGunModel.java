package com.nukateam.nukacraft.client.models.items;

import com.nukateam.example.common.data.interfaces.IResourceProvider;
import com.nukateam.ntgl.client.animators.GunAnimator;
import com.nukateam.ntgl.client.model.IGlowingModel;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class TechnicGunModel<T extends IResourceProvider & GeoAnimatable> extends GeoModel<T> {
    public TechnicGunModel() {}

    public ResourceLocation getModelResource(T gunItem) {
        return nukaResource("geo/guns/flamer.geo.json");
    }

    public ResourceLocation getTextureResource(T gunItem) {
        return nukaResource("textures/guns/flamer.png");
    }
    public ResourceLocation getAnimationResource(T gunItem) {
        return nukaResource("animations/guns/flamer.animation.json");
    }

    public RenderType getRenderType(T animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(this.getTextureResource(animatable));
    }
}

