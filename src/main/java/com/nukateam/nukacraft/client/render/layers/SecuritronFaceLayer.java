
package com.nukateam.nukacraft.client.render.layers;

import com.jetug.chassis_core.client.render.layers.LayerBase;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoRenderer;
import mod.azure.azurelib.renderer.layer.GeoRenderLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

@SuppressWarnings("ConstantConditions")
public class SecuritronFaceLayer extends GeoRenderLayer<Securitron> {
    public SecuritronFaceLayer(GeoRenderer<Securitron> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack poseStack, Securitron entity, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource,
                       VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {

        var texture = nukaResource("textures/entity/securitron/screen.png");
        renderLayer(poseStack, entity, bakedModel, bufferSource, partialTick, packedLight, texture);
    }

    protected void renderLayer(PoseStack poseStack, Securitron entity, BakedGeoModel bakedModel,
                               MultiBufferSource bufferSource, float partialTick, int packedLight, ResourceLocation texture) {
        int overlay = OverlayTexture.NO_OVERLAY;
        RenderType renderTypeNew = RenderType.entityTranslucent(texture);
        this.getRenderer().reRender(bakedModel, poseStack, bufferSource, entity,
                renderTypeNew, bufferSource.getBuffer(renderTypeNew),
                partialTick, packedLight, overlay,
                1.0F, 1.0F, 1.0F, 1.0F);
    }
}