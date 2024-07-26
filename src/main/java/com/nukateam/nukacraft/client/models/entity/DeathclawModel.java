package com.nukateam.nukacraft.client.models.entity;

import com.nukateam.nukacraft.common.foundation.entities.mobs.Deathclaw;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static com.jetug.chassis_core.client.render.utils.GeoUtils.setHeadAnimation;
import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class DeathclawModel<Type extends Deathclaw> extends EntityModel<Type> {
    private static final ResourceLocation model = nukaResource("geo/entity/deathclaw.geo.json");
    private static final ResourceLocation animation = nukaResource("animations/entity/deathclaw.animation.json");

    @Override
    public ResourceLocation getTextureResource(Type object) {
        return nukaResource("textures/entity/deathclaw/"+ object.getVariant().getTexture() +".png");
    }

    @Override
    public void setCustomAnimations(Type animatable, long instanceId, AnimationState<Type> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        setHeadAnimation(animatable, this.getAnimationProcessor(), animationState);
    }

    @Override
    public RenderType getRenderType(Type animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }

}