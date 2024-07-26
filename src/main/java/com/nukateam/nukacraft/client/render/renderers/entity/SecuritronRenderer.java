package com.nukateam.nukacraft.client.render.renderers.entity;

import com.mojang.blaze3d.vertex.PoseStack;
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
//        addRenderLayer(new SecuritronFaceLayer(this));
    }

    @Override
    public void render(Securitron entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if(entity.getVariant() == SecuritronVariant.BERSERK || entity.getVariant() == SecuritronVariant.DAMAGED) {
            var scale = 1.5f;
            poseStack.scale(scale, scale, scale);
        }
        poseStack.pushPose();
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        poseStack.popPose();
    }

    @Nullable
    @Override
    protected ResourceLocation getTextureOverrideForBone(GeoBone bone, Securitron entity, float partialTick) {
        var texture = nukaResource("textures/entity/securitron/" + entity.getVariant().getTexture() + ".png");
        return bone.getName().equals("screen") ? texture : null;
    }

    @Override
    public RenderType getRenderType(Securitron animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}