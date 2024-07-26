
package com.nukateam.nukacraft.client.render.layers;

import com.jetug.chassis_core.client.render.layers.LayerBase;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

@SuppressWarnings("ConstantConditions")
public class SecuritronFaceLayer extends LayerBase<Securitron> {
    public SecuritronFaceLayer(GeoRenderer<Securitron> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack poseStack, Securitron entity, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource,
                       VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {

        var texture = nukaResource("textures/entity/securitron/" + entity.getVariant().getTexture() + ".png");
        renderLayer(poseStack, entity, bakedModel, bufferSource, partialTick, packedLight, texture);
    }
}