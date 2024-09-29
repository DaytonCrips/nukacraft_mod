package com.nukateam.nukacraft.client.render.renderers.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.nukateam.nukacraft.client.models.entity.HandmadeSpearModel;
import com.nukateam.nukacraft.common.foundation.entities.misc.SpearEntity;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.ThrownTridentRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.ThrownTrident;

public class SpearEntityRenderer extends GeoEntityRenderer<SpearEntity> {
    public SpearEntityRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HandmadeSpearModel<>());
    }

    @Override
    public void render(SpearEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        {
            poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, entity.yRotO, entity.getYRot()) + 180.0F));
            poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTick, entity.xRotO, entity.getXRot()) + 180.0F));
            //poseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(partialTick, entity.yRotO, entity.getXRot()) + 180.0F));

            super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        }
        poseStack.popPose();

    }
}
