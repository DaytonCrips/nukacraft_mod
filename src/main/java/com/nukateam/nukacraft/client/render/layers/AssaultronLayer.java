
package com.nukateam.nukacraft.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Assaultron;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoRenderer;
import mod.azure.azurelib.renderer.layer.GeoRenderLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class AssaultronLayer extends GeoRenderLayer<Assaultron> {
    public AssaultronLayer(GeoRenderer<Assaultron> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack poseStack, Assaultron entity, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource,
                       VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        var texture = nukaResource("textures/entity/assaultron/laser.png");
        renderLayer(poseStack, entity, bakedModel, bufferSource, partialTick, packedLight, texture);
    }

    protected void renderLayer(PoseStack poseStack, Assaultron entity, BakedGeoModel bakedModel,
                               MultiBufferSource bufferSource, float partialTick, int packedLight, ResourceLocation texture) {
        int overlay = OverlayTexture.NO_OVERLAY;
        RenderType renderTypeNew = RenderType.entityTranslucent(texture);
        this.getRenderer().reRender(bakedModel, poseStack, bufferSource, entity,
                renderTypeNew, bufferSource.getBuffer(renderTypeNew),
                partialTick, packedLight, overlay,
                1.0F, 1.0F, 1.0F, 1.0F);
    }
}