package com.nukateam.guns.client.render.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.guns.client.animators.GunItemAnimator;
import com.nukateam.guns.client.model.GeoGunModel;
import com.nukateam.guns.client.render.layers.PlayerSkinLayer;
import mod.azure.azurelib.renderer.GeoObjectRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class GunRendererTest extends GeoObjectRenderer<GunItemAnimator> {
    public static GunRendererTest INSTANCE = new GunRendererTest();

    public GunRendererTest() {
        super(new GeoGunModel<>());
        addRenderLayer(new PlayerSkinLayer<>(this));
    }

    public void render(PoseStack poseStack, ItemStack stack, GunItemAnimator animatable, @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
//        renderStack = stack;
        super.render(poseStack, animatable, bufferSource, renderType, buffer, packedLight);
    }

    //    @Override
//    public void render(LivingEntity entity, ItemStack stack, TransformType transformType, PoseStack poseStack,
//                       GunItemAnimator animatable, @Nullable MultiBufferSource bufferSource,
//                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
//        renderStack = stack;
//        super.render(entity, stack, transformType, poseStack, animatable, bufferSource, renderType, buffer, packedLight);
//    }
}
