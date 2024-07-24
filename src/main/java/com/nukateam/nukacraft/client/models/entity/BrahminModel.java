package com.nukateam.nukacraft.client.models.entity;

import com.nukateam.nukacraft.common.foundation.entities.mobs.Brahmin;
import net.minecraft.resources.ResourceLocation;

public class BrahminModel extends EntityModel<Brahmin> {
    @Override
    public ResourceLocation getModelResource(Brahmin object) {
        return getResource(object, "geo/entity/", ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Brahmin object) {
        return getResource(object, "textures/entity/", ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(Brahmin object) {
        return getResource(object, "animations/entity/", ".animation.json");
    }
}
