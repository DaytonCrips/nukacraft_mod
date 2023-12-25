package com.nukateam.guns.client.render.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.guns.client.model.GeoGunModel;
import com.nukateam.guns.client.render.layers.PlayerSkinLayer;
import com.nukateam.guns.common.foundation.item.AnimatedGunItem;
import mod.azure.azurelib.renderer.GeoObjectRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static com.nukateam.guns.client.render.renderers.GunRendererDynamic.renderStack;

public class GunRendererTest extends GeoObjectRenderer<AnimatedGunItem> {
    public static GunRendererTest INSTANCE = new GunRendererTest();

    public GunRendererTest() {
        super(new GeoGunModel<>());
        addRenderLayer(new PlayerSkinLayer<>(this));
    }

    public void render(PoseStack poseStack, ItemStack stack, AnimatedGunItem animatable, @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
        renderStack = stack;
        super.render(poseStack, animatable, bufferSource, renderType, buffer, packedLight);
    }

    //    @Override
//    public void render(LivingEntity entity, ItemStack stack, TransformType transformType, PoseStack poseStack,
//                       AnimatedGunItem animatable, @Nullable MultiBufferSource bufferSource,
//                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
//        renderStack = stack;
//        super.render(entity, stack, transformType, poseStack, animatable, bufferSource, renderType, buffer, packedLight);
//    }
}
