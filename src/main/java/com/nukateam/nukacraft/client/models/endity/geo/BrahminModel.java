package com.nukateam.nukacraft.client.models.endity.geo;

import com.nukateam.nukacraft.common.foundation.entities.Brahmin;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;

public class BrahminModel extends EntityModel<Brahmin>{
    @Override
    public ResourceLocation getModelResource(Brahmin object) {
        return getChassisResource(object,"geo/entity/", ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Brahmin object) {
        return getChassisResource(object,"textures/entity/", ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(Brahmin object) {
        return getChassisResource(object,"animations/entity/", ".animation.json");
    }
}
