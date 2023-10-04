package com.dayton.nukacraft.client.models;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.foundation.entities.Deathclaw;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import java.util.function.BiConsumer;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;

public class DeathclawModel<Type extends Deathclaw> extends GeoModel<Type> {

    // Models must be stored in assets/<modid>/geo with subfolders supported inside the geo folder
    private static final ResourceLocation model = nukaResource("geo/deathclaw.geo.json");
    // Textures must be stored in assets/<modid>/geo with subfolders supported inside the textures folder
    private static final ResourceLocation texture = nukaResource( "textures/deathclaw/deathclaw.png");
    // Animations must be stored in assets/<modid>/animations with subfolders supported inside the animations folder
    private static final ResourceLocation animation = nukaResource( "animations/deathclaw.animation.json");



    @Override
    public ResourceLocation getModelResource(Type object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(Type object) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(Type animatable) {
        return animation;
    }

    @Override
    public void setCustomAnimations(Type animatable, long instanceId, AnimationState<Type> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
//        var extraData = (EntityModelData)animationState.getExtraData().get(EntityModelData.class);
//        if (extraData == null) return;

        var head = this.getAnimationProcessor().getBone("head");
        var partialTick = Minecraft.getInstance().getFrameTime();

        float lerpBodyRot = Mth.rotLerp(partialTick, animatable.yBodyRotO, animatable.yBodyRot);
        float lerpHeadRot = Mth.rotLerp(partialTick, animatable.yHeadRotO, animatable.yHeadRot);
        float headPitch = Mth.lerp(partialTick, animatable.xRotO, animatable.getXRot());
        float netHeadYaw = lerpHeadRot - lerpBodyRot;

        head.setRotX(-headPitch * ((float) Math.PI / 180F));
        head.setRotY(-netHeadYaw * ((float) Math.PI / 180F));
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