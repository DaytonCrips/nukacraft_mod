package com.nukateam.guns.client.render.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.guns.client.model.*;
import com.nukateam.guns.client.render.Render;
import com.nukateam.guns.common.foundation.item.AnimatedGunItem;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.object.GeoBone;
import mod.azure.azurelib.renderer.GeoObjectRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static com.nukateam.guns.client.render.renderers.GunRenderer.getRenderItem;
import static com.nukateam.guns.client.render.renderers.GunRenderer.renderStack;

public class RightHandRenderer extends GeoObjectRenderer<AnimatedGunItem> {
    public RightHandRenderer() {
        super(new GunHandsModel<>());
    }

    @Override
    public void preRender(PoseStack poseStack, AnimatedGunItem animatable, BakedGeoModel model, MultiBufferSource bufferSource,
                          VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight,
                          int packedOverlay, float red, float green, float blue, float alpha) {
//        poseStack.translate(0,1.5, 0);
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void renderRecursively(PoseStack poseStack, AnimatedGunItem animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer,
                                  boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

//        poseStack.pushPose();
//        {
            poseStack.translate(0,-0.3,-0.6);
            if (bone.getName().equals("right_arm")) {
                Render.GUN_RENDERER.renderGun(
                        Minecraft.getInstance().player,
                        ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND,
                        renderStack,
                        poseStack,
                        bufferSource,
                        packedLight);
            }
//        }
//        poseStack.popPose();
    }
//
//    @Override
//    public void renderChildBones(PoseStack poseStack, AnimatedGunItem animatable, GeoBone bone, RenderType renderType,
//                                 MultiBufferSource bufferSource, VertexConsumer buffer,
//                                 boolean isReRender, float partialTick, int packedLight, int packedOverlay,
//                                 float red, float green, float blue, float alpha) {
//        if (!bone.isHidingChildren()) {
//            var bonesToRender = new ArrayList<>(bone.getChildBones());
//
//
//            var bone2 = GeoUtils.getArmorBone(GeoGunModel.INSTANCE.getModelResource(animatable), "model");
//            bonesToRender.add(bone2);
//
//            for (GeoBone childBone : bonesToRender) {
//                this.renderRecursively(poseStack, animatable, childBone, renderType, bufferSource, buffer,
//                        isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
//            }
//        }
//    }


    @Override
    public void render(PoseStack poseStack, AnimatedGunItem animatable, @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
        super.render(poseStack, animatable, bufferSource, renderType, buffer, packedLight);
    }

    public void renderHand(LivingEntity entity, ItemStack stack, PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light) {
        var animatable = getRenderItem(ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND);
        renderStack = stack;
        render(poseStack, animatable, renderTypeBuffer, null, null, light);
    }
}
