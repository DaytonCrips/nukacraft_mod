package com.nukateam.guns.client.render.layers;

import com.jetug.chassis_core.client.render.layers.LayerBase;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.guns.common.foundation.item.AnimatedGunItem;
import com.nukateam.nukacraft.common.foundation.entities.Raider;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.checkerframework.checker.units.qual.min;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.UUID;

import static com.jetug.chassis_core.common.util.helpers.BufferedImageHelper.extendImage;
import static com.jetug.chassis_core.common.util.helpers.BufferedImageHelper.resourceToBufferedImage;
import static com.jetug.chassis_core.common.util.helpers.TextureHelper.createResource;
import static com.jetug.chassis_core.common.util.helpers.TextureHelper.getTextureSize;

public class PlayerSkinLayer<T extends AnimatedGunItem> extends LayerBase<T> {
    private static final HashMap<UUID, ResourceLocation> playerSkins = new HashMap<>();
    private int textureWidth;
    private int textureHeight;

    public PlayerSkinLayer(GeoRenderer<T> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType,
                       MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        var player = Minecraft.getInstance().player;
        if(player == null) return;
        var texture = getPlayerSkin(player, animatable);
        if (texture == null) return;
        renderLayer(poseStack, animatable, bakedModel, bufferSource, partialTick, packedLight, texture);
    }

    private void setTextureSize(T entity){
        var size = getTextureSize(getRenderer().getTextureLocation(entity));
        textureWidth = size.getA();
        textureHeight = size.getB();
    }

    @Nullable
    private ResourceLocation getPlayerSkin(AbstractClientPlayer player, T animatable) {
        var tag = player.getUUID();
        if (!playerSkins.containsKey(tag)) {
            setTextureSize(animatable);
            var image = resourceToBufferedImage(player.getSkinTextureLocation());
            image = extendImage(image, textureWidth, textureHeight);
            var resource = createResource(image, "player" + tag);
            playerSkins.put(tag, resource);
        }
        return playerSkins.get(tag);
    }

}