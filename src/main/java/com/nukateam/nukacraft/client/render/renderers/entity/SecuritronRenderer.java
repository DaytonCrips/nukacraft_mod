package com.nukateam.nukacraft.client.render.renderers.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.client.models.entity.*;
import com.nukateam.nukacraft.client.render.layers.SecuritronFaceLayer;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import com.nukateam.nukacraft.common.foundation.variants.SecuritronVariant;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class SecuritronRenderer extends GeoEntityRenderer<Securitron> {
    public SecuritronRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager,  new SecuritronModel<>());
        addRenderLayer(new SecuritronFaceLayer(this));
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


}