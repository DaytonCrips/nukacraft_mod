package com.dayton.nukacraft.client.render.renderers;

import com.dayton.nukacraft.client.models.*;
import com.dayton.nukacraft.common.foundation.entities.*;
import com.mojang.blaze3d.vertex.*;
import mod.azure.azurelib.cache.object.*;
import mod.azure.azurelib.renderer.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;


public class NuclearExplosionRenderer extends DynamicGeoEntityRenderer<NuclearExplosionEffectEntity> {
    public NuclearExplosionRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NuclearExplosionModel());
    }

    @Override
    public void render(NuclearExplosionEffectEntity entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(5,5,5);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public void renderRecursively(PoseStack poseStack, NuclearExplosionEffectEntity animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick,
                                  int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick,
                packedLight, packedOverlay, red, green, blue, alpha);
    }
}
