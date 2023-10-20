package com.dayton.nukacraft.client.render.renderers;

import com.dayton.nukacraft.client.models.NuclearExplosionModel;
import com.dayton.nukacraft.common.foundation.entities.NuclearExplosionEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.cache.object.GeoBone;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.DynamicGeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import java.util.Objects;

public class NuclearExplosionRenderer extends DynamicGeoEntityRenderer<NuclearExplosionEntity> {
    public NuclearExplosionRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NuclearExplosionModel());
    }

    @Override
    public void render(NuclearExplosionEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(50,50,50);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public void renderRecursively(PoseStack poseStack, NuclearExplosionEntity animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick,
                                  int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//        if(Objects.equals(bone.getName(), "bone")){
//            bone.updateScale(10,10,10);
//        }
        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick,
                packedLight, packedOverlay, red, green, blue, alpha);
    }
}
