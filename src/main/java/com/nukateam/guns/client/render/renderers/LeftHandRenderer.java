package com.nukateam.guns.client.render.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.guns.client.model.LeftHandModel;
import com.nukateam.guns.client.model.RightHandModel;
import com.nukateam.guns.common.foundation.item.AnimatedGunItem;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.renderer.GeoObjectRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static com.nukateam.guns.client.render.renderers.GunRenderer.getRenderItem;

public class LeftHandRenderer extends GeoObjectRenderer<AnimatedGunItem> {
    public LeftHandRenderer() {
        super(new LeftHandModel<>());
    }

    @Override
    public void preRender(PoseStack poseStack, AnimatedGunItem animatable, BakedGeoModel model, MultiBufferSource bufferSource,
                          VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight,
                          int packedOverlay, float red, float green, float blue, float alpha) {
//        poseStack.translate(0,1.5, 0);
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void render(PoseStack poseStack, AnimatedGunItem animatable, @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
        super.render(poseStack, animatable, bufferSource, renderType, buffer, packedLight);
    }

    public void renderHand(LivingEntity entity, ItemStack stack, PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light) {
        var animatable = getRenderItem(ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND);
        render(poseStack, animatable, renderTypeBuffer, null, null, light);
    }
}
