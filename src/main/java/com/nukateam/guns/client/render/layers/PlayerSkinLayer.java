package com.nukateam.guns.client.render.layers;

import com.jetug.chassis_core.client.render.layers.LayerBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.renderer.GeoRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.UUID;

import static com.jetug.chassis_core.common.util.helpers.BufferedImageHelper.extendImage;
import static com.jetug.chassis_core.common.util.helpers.BufferedImageHelper.resourceToBufferedImage;
import static com.jetug.chassis_core.common.util.helpers.TextureHelper.createResource;
import static com.jetug.chassis_core.common.util.helpers.TextureHelper.getTextureSize;

public class PlayerSkinLayer<T extends GeoAnimatable> extends LayerBase<T> {
    private static ResourceLocation playerSkin = null;
    private int textureWidth;
    private int textureHeight;

    public PlayerSkinLayer(GeoRenderer<T> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType,
                       MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {

        poseStack.translate(-0.5, -0.5, -0.5);

        var player = Minecraft.getInstance().player;
        if(player == null) return;
        var texture = getPlayerSkin(player, animatable);
        if (texture == null) return;
        renderLayer(poseStack, animatable, bakedModel, bufferSource, partialTick, packedLight, texture);
    }

    private void setTextureSize(T animatable){
        var size = getTextureSize(getRenderer().getTextureLocation(animatable));
        textureWidth = size.getA();
        textureHeight = size.getB();
    }

    @Nullable
    private ResourceLocation getPlayerSkin(AbstractClientPlayer player, T animatable) {
        if (playerSkin == null) {
            setTextureSize(animatable);
            var image = resourceToBufferedImage(player.getSkinTextureLocation());
            image = extendImage(image, textureWidth, textureHeight);
            playerSkin = createResource(image, "player");
        }
        return playerSkin;
    }
}