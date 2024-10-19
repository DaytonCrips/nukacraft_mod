package com.nukateam.nukacraft.client.models.entity;

import com.nukateam.nukacraft.client.render.renderers.entity.PowerArmorRenderer;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Brahmin;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.jetug.chassis_core.client.render.utils.GeoUtils.setHeadAnimation;

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

    @Override
    public void setCustomAnimations(Brahmin animatable, long instanceId, AnimationState<Brahmin> animationState) {
        var head = this.getAnimationProcessor().getBone("head_left");
        setHeadAnimation(head, animationState);
    }
}
