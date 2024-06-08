package com.nukateam.nukacraft.client.render.layers;

import com.ibm.icu.impl.Pair;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.ntgl.client.data.util.TextureUtils;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.texture.GeoAbstractTexture;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoRenderer;
import mod.azure.azurelib.renderer.layer.GeoRenderLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class GlowingLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {
    private Pair<Integer, Integer> size;

    public GlowingLayer(GeoRenderer<T> entityRenderer) {
        super(entityRenderer);
    }

    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType,
                       MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if (this.size == null) {
            this.size = TextureUtils.getTextureSize(this.getRenderer().getTextureLocation(animatable));
        }

        GeoModel<T> model = this.getRenderer().getGeoModel();
        ResourceLocation texture = GeoAbstractTexture.appendToPath(model.getTextureResource(animatable), "_glowmask");
        this.renderLayer(poseStack, animatable, bakedModel, bufferSource, partialTick, packedLight, texture);
    }

    protected void renderLayer(PoseStack poseStack, T entity, BakedGeoModel bakedModel, MultiBufferSource bufferSource, float partialTick, int packedLight, ResourceLocation texture) {
        int overlay = OverlayTexture.NO_OVERLAY;
        RenderType renderTypeNew = RenderType.eyes(texture);
        poseStack.pushPose();
        poseStack.scale(1.0F, 1.0F, 1.0F);
        poseStack.translate(0.5, 0.5, 0.5);
        this.getRenderer().reRender(bakedModel, poseStack, bufferSource, entity, renderTypeNew, bufferSource.getBuffer(renderTypeNew), partialTick, packedLight, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
    }
}
