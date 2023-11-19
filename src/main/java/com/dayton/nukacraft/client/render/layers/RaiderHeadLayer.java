package com.dayton.nukacraft.client.render.layers;

import com.dayton.nukacraft.common.foundation.entities.RaiderEntity;
import com.jetug.chassis_core.client.render.layers.LayerBase;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
import java.util.HashMap;

import static com.jetug.chassis_core.common.util.helpers.BufferedImageHelper.*;
import static com.jetug.chassis_core.common.util.helpers.TextureHelper.*;

public class RaiderHeadLayer<T extends WearableChassis> extends LayerBase<T> {
    private static final HashMap<String, ResourceLocation> raiderHeads = new HashMap<>();
    private int textureWidth;
    private int textureHeight;

    public RaiderHeadLayer(GeoRenderer<T> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType,
                       MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        if(!animatable.isInvisible()
                && animatable.isVehicle()
                && animatable.getControllingPassenger() instanceof RaiderEntity raider ) {

            var texture = getRaiderHead(raider, animatable);
            resourceToBufferedImage(texture);

            if (texture == null) return;
            renderLayer(poseStack, animatable, bakedModel, bufferSource, partialTick, packedLight, texture);
        }
    }

    private void setTextureSize(T entity){
        var size = getTextureSize(getRenderer().getTextureLocation(entity));
        textureWidth = size.getA();
        textureHeight = size.getB();
    }

    @Nullable
    private ResourceLocation getRaiderHead(RaiderEntity raider, T animatable) {
        var tag = raider.getVariant();

        if (!raiderHeads.containsKey(tag)) {
            setTextureSize(animatable);
            var image = resourceToBufferedImage(raider.getTexture());
            image = extendImage(image, textureWidth, textureHeight);
            var resource = createResource(image, "raider_" + raider.getVariant());
            raiderHeads.put(tag, resource);
        }
        return raiderHeads.get(tag);
    }

}