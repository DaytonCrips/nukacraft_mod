package com.dayton.nukacraft.client.models;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.entities.Deathclaw;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class DeathclawModel<Type extends Deathclaw> extends AnimatedGeoModel<Type>{
    @Override
    public ResourceLocation getModelLocation(Type object) {
        return new ResourceLocation(NukaCraftMod.MOD_ID, "geo/deathclaw.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Type object) {
        return new ResourceLocation(NukaCraftMod.MOD_ID, "textures/entity/deathclaw.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Type animatable) {
        return new ResourceLocation(NukaCraftMod.MOD_ID, "animations/deathclaw.animation.json");
    }

    @Override
    public void setCustomAnimations(Type animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        setupHeadAnimation(animationEvent);
    }

    private void setupHeadAnimation(AnimationEvent customPredicate){
        var head = this.getAnimationProcessor().getBone("head");
        var data = customPredicate.getExtraDataOfType(EntityModelData.class);
        var f = data;
        var extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}