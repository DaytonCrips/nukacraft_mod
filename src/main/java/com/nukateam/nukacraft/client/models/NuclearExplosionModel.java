package com.nukateam.nukacraft.client.models;

import com.nukateam.nukacraft.common.foundation.entities.misc.NuclearExplosionEffectEntity;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class NuclearExplosionModel extends GeoModel<NuclearExplosionEffectEntity> {
    @Override
    public ResourceLocation getModelResource(NuclearExplosionEffectEntity geoAnimatable) {
        return nukaResource("geo/nuclear_explosion.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NuclearExplosionEffectEntity geoAnimatable) {
        return nukaResource("textures/entity/nuclear_explosion.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NuclearExplosionEffectEntity geoAnimatable) {
        return nukaResource("animations/nuclear_explosion.animation.json");
    }

    @Override
    public RenderType getRenderType(NuclearExplosionEffectEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(texture);
    }
}
