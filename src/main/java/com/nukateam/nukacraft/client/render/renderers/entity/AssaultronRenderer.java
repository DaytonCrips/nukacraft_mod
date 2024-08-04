package com.nukateam.nukacraft.client.render.renderers.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.nukacraft.client.models.entity.EntityModel;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Assaultron;
import mod.azure.azurelib.cache.object.GeoBone;
import mod.azure.azurelib.renderer.DynamicGeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public class AssaultronRenderer extends DynamicGeoEntityRenderer<Assaultron> {
    public AssaultronRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager,  new EntityModel<>());
    }

    @Override
    public void render(Assaultron entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public void renderRecursively(PoseStack poseStack, Assaultron animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer,
                                  boolean isReRender, float partialTick, int packedLight,
                                  int packedOverlay, float red, float green, float blue, float alpha) {

        if(bone.getName().equals("laser"))
            bone.setHidden(!animatable.isShootingLaser());

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender,
                partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }


    @Override
    public RenderType getRenderType(Assaultron animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}