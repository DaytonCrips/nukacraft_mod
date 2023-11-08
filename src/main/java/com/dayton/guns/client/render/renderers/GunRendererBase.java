package com.dayton.guns.client.render.renderers;

import com.dayton.guns.client.handler.ReloadHandler;
import com.dayton.guns.common.base.Gun;
import com.dayton.nukacraft.client.models.GunModel;
import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.object.GeoBone;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.model.data.EntityModelData;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import mod.azure.azurelib.renderer.GeoObjectRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static com.dayton.guns.common.foundation.item.GunItem.*;
import static com.dayton.nukacraft.common.data.constants.Animations.RELOAD;
import static com.dayton.nukacraft.common.data.constants.Animations.SHOT;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;

public class GunRendererBase<T extends IResourceProvider & GeoAnimatable> extends GeoObjectRenderer<T> {
    private ItemStack currentItemStack;
    private TransformType currentTransform;

    public GunRendererBase() {
        super(new GunModel<>());
    }

    public void render(ItemStack stack, TransformType transformType,
                       PoseStack poseStack, T animatable,
                       @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable
                       VertexConsumer buffer, int packedLight) {
        this.currentItemStack = stack;
        this.currentTransform = transformType;
        super.render(poseStack, animatable, bufferSource, renderType, buffer, packedLight);
    }

    @Override
    public void actuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model,
                               RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer,
                               boolean isReRender, float partialTick, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {

        poseStack.pushPose();

        LivingEntity livingEntity = null;
        boolean shouldSit = false;
        float lerpBodyRot = 0;
        float lerpHeadRot = 0;
        float netHeadYaw = lerpHeadRot - lerpBodyRot;
        float limbSwingAmount;
//        if (shouldSit) {
//            Entity var21 = animatable.getVehicle();
//            if (var21 instanceof LivingEntity) {
//                LivingEntity livingentity = (LivingEntity)var21;
//                lerpBodyRot = Mth.rotLerp(partialTick, livingentity.yBodyRotO, livingentity.yBodyRot);
//                netHeadYaw = lerpHeadRot - lerpBodyRot;
//                limbSwingAmount = Mth.clamp(Mth.wrapDegrees(netHeadYaw), -85.0F, 85.0F);
//                lerpBodyRot = lerpHeadRot - limbSwingAmount;
//                if (limbSwingAmount * limbSwingAmount > 2500.0F) {
//                    lerpBodyRot += limbSwingAmount * 0.2F;
//                }
//
//                netHeadYaw = lerpHeadRot - lerpBodyRot;
//            }
//        }

//        float ageInTicks = (float)animatable.tickCount + partialTick;
        limbSwingAmount = 0.0F;
        float limbSwing = 0.0F;
//        this.applyRotations(animatable, poseStack, ageInTicks, lerpBodyRot, partialTick);
//        if (!shouldSit && animatable.isAlive() && livingEntity != null) {
//            limbSwingAmount = Mth.lerp(partialTick, livingEntity.animationSpeedOld, livingEntity.animationSpeed);
//            limbSwing = livingEntity.animationPosition - livingEntity.animationSpeed * (1.0F - partialTick);
//            if (livingEntity.isBaby()) {
//                limbSwing *= 3.0F;
//            }
//
//            if (limbSwingAmount > 1.0F) {
//                limbSwingAmount = 1.0F;
//            }
//        }

        if (!isReRender) {
            var headPitch = 0;
            var motionThreshold = 0;
            var velocity = Vec3.ZERO;//jetug
            var avgVelocity = (float)(Math.abs(velocity.x) + Math.abs(velocity.z)) / 2.0F;
            var animationState = new AnimationState(animatable, limbSwing, limbSwingAmount, partialTick,
                    avgVelocity >= motionThreshold && limbSwingAmount != 0.0F);
            var instanceId = this.getInstanceId(animatable);
            animationState.setData(DataTickets.TICK, animatable.getTick(animatable));
            animationState.setData(DataTickets.ENTITY, null);//jet
            animationState.setData(DataTickets.ENTITY_MODEL_DATA, new EntityModelData(shouldSit, false, -netHeadYaw, -headPitch));
            var var31 = this.model;
            Objects.requireNonNull(animationState);
            var31.addAdditionalStateData(animatable, instanceId, animationState::setData);
            this.model.handleAnimations(animatable, instanceId, animationState);
        }

        poseStack.translate(0.0, 0.009999999776482582, 0.0);
        this.modelRenderTranslations = new Matrix4f(poseStack.last().pose());

        super.actuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        poseStack.popPose();
    }

    private void originalActuallyRender(PoseStack poseStack, T animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.updateAnimatedTextureFrame(animatable);

        for (GeoBone group : model.topLevelBones()) {
            this.renderRecursively(poseStack, animatable, group, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }
}