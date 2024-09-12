package com.nukateam.nukacraft.client.render.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Assaultron;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.texture.GeoAbstractTexture;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.renderer.GeoRenderer;
import mod.azure.azurelib.renderer.layer.GeoRenderLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class AssaultronLaserLayer<T extends Assaultron> extends GeoRenderLayer<T> {
    public AssaultronLaserLayer(GeoRenderer<T> entityRenderer) {
        super(entityRenderer);
    }

    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        var texture = nukaResource("textures/entity/assaultron/laser.png");
        var renderTypeNew = RenderType.eyes(texture);
//        if(animatable.isShootingLaser())
            this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderTypeNew,
                bufferSource.getBuffer(renderTypeNew), partialTick, packedLight, OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F);
    }
}