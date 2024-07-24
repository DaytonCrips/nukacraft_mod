package com.nukateam.nukacraft.client.models.entity;

import com.nukateam.nukacraft.common.foundation.entities.mobs.Deathclaw;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static com.jetug.chassis_core.client.render.utils.GeoUtils.setHeadAnimation;
import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class DeathclawModel<Type extends Deathclaw> extends GeoModel<Type> {
    private static final ResourceLocation model = nukaResource("geo/entity/deathclaw.geo.json");
    private static final ResourceLocation animation = nukaResource("animations/entity/deathclaw.animation.json");

    @Override
    public ResourceLocation getModelResource(Type object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(Type object) {
        return nukaResource("textures/entity/deathclaw/"+ object.getVariant().getTexture() +".png");
    }

    @Override
    public ResourceLocation getAnimationResource(Type animatable) {
        return animation;
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

//    @Override
//    public void setCustomAnimations(Type animatable, int instanceId, AnimationEvent animationEvent) {
//        super.setCustomAnimations(animatable, instanceId, animationEvent);
//        var head = this.getAnimationProcessor().getBone("head");
//        var extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
//        head.setRotX(extraData.headPitch * ((float) Math.PI / 180F));
//        head.setRotY(extraData.netHeadYaw * ((float) Math.PI / 180F));
//    }

}