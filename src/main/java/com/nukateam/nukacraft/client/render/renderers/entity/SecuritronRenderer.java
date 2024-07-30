package com.nukateam.nukacraft.client.render.renderers.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.ntgl.client.render.renderers.DynamicGunRenderer;
import com.nukateam.nukacraft.client.models.entity.*;
import com.nukateam.nukacraft.client.render.layers.SecuritronFaceLayer;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import com.nukateam.nukacraft.common.foundation.variants.SecuritronVariant;
import mod.azure.azurelib.cache.object.GeoBone;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.DynamicGeoEntityRenderer;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class SecuritronRenderer extends DynamicGeoEntityRenderer<Securitron> {
    public SecuritronRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager,  new SecuritronModel<>());
        addRenderLayer(new SecuritronFaceLayer(this));
    }

    @Override
    public void render(Securitron entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        var scale = entity.getVariant().getScale();
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

    @Override
    public void renderRecursively(PoseStack poseStack, Securitron animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer,
                                  boolean isReRender, float partialTick, int packedLight,
                                  int packedOverlay, float red, float green, float blue, float alpha) {

        if(bone.getName().equals("screen"))
            alpha = 0.4f;

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender,
                partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Nullable
    @Override
    protected ResourceLocation getTextureOverrideForBone(GeoBone bone, Securitron entity, float partialTick) {
        return switch (bone.getName()){
            case "face" -> nukaResource("textures/entity/securitron/" + entity.getVariant().getTexture() + ".png");
            case "screen" -> nukaResource("textures/entity/securitron/screen.png");
            default -> null;
        };
    }



    @Override
    public RenderType getRenderType(Securitron animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}