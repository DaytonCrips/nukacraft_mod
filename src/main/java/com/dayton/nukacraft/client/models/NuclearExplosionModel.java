package com.dayton.nukacraft.client.models;

import com.dayton.nukacraft.common.foundation.entities.NuclearExplosionEntity;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.DefaultedGeoModel;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;

public class NuclearExplosionModel extends GeoModel<NuclearExplosionEntity> {
    @Override
    public ResourceLocation getModelResource(NuclearExplosionEntity geoAnimatable) {
        return nukaResource("geo/nuclear_explosion.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NuclearExplosionEntity geoAnimatable) {
        return nukaResource("textures/entity/nuclear_explosion.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NuclearExplosionEntity geoAnimatable) {
        return nukaResource("animations/nuclear_explosion.animation.json");
    }
}
