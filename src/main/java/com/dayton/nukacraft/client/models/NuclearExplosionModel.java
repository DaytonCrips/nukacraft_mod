package com.dayton.nukacraft.client.models;

import com.dayton.nukacraft.common.foundation.entities.*;
import mod.azure.azurelib.model.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.*;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;

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
