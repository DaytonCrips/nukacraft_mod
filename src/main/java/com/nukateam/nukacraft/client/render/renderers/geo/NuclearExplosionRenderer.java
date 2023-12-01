package com.nukateam.nukacraft.client.render.renderers.geo;

import com.nukateam.nukacraft.client.models.*;
import com.nukateam.nukacraft.common.foundation.entities.*;
import com.mojang.blaze3d.vertex.*;
import mod.azure.azurelib.cache.object.*;
import mod.azure.azurelib.core.object.Color;
import mod.azure.azurelib.renderer.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class NuclearExplosionRenderer extends DynamicGeoEntityRenderer<NuclearExplosionEffectEntity> {
    public static final int SCALE = 5;

    public NuclearExplosionRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NuclearExplosionModel());
    }

    @Override
    public void render(NuclearExplosionEffectEntity entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        var size = entity.getExplosionType().size();
        poseStack.scale(SCALE * size, SCALE * size, SCALE * size);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public Color getRenderColor(NuclearExplosionEffectEntity getOpacity, float partialTick, int packedLight) {
        return Color.ofRGBA(1,1,1, getOpacity.getOpacity());
    }

    @Override
    public void renderRecursively(PoseStack poseStack, NuclearExplosionEffectEntity animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick,
                                  int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick,
                packedLight, packedOverlay, red, green, blue, alpha);
    }
}
