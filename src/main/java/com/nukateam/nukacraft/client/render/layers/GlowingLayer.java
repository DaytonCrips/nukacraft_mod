package com.nukateam.nukacraft.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.texture.GeoAbstractTexture;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.renderer.GeoRenderer;
import mod.azure.azurelib.renderer.layer.GeoRenderLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class GlowingLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {
    public GlowingLayer(GeoRenderer<T> entityRenderer) {
        super(entityRenderer);
    }

    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        ResourceLocation model = this.getRenderer().getGeoModel().getTextureResource(animatable);
        ResourceLocation texture = GeoAbstractTexture.appendToPath(model, "_glowmask");
        RenderType renderTypeNew = RenderType.eyes(texture);
        this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderTypeNew,
                bufferSource.getBuffer(renderTypeNew), partialTick, packedLight, OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F);
    }
}