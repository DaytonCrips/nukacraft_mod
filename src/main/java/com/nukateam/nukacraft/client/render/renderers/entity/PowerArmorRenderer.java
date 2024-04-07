package com.nukateam.nukacraft.client.render.renderers.entity;

import com.jetug.chassis_core.client.render.renderers.ChassisRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.nukateam.ntgl.client.data.handler.AimingHandler;
import com.nukateam.nukacraft.client.models.PowerArmorModel;
import com.nukateam.nukacraft.client.render.layers.RaiderHeadLayer;
import com.nukateam.nukacraft.common.foundation.entities.misc.PowerArmorFrame;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.object.GeoBone;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.InteractionHand;

public class PowerArmorRenderer extends ChassisRenderer<PowerArmorFrame> {
//    public GunItem gunItem;

    public PowerArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PowerArmorModel());
        addRenderLayer(new RaiderHeadLayer<>(this));
    }

    public static Vector3f getRotations(GeoBone bone) {
        return new Vector3f(
                bone.getRotX(),
                bone.getRotY(),
                bone.getRotZ());
    }

    public static void setRotations(GeoBone bone, Vector3f vec) {
        bone.setRotX(vec.x());
        bone.setRotY(vec.y());
        bone.setRotZ(vec.z());
    }

    public static void copyRotations(GeoBone dist, GeoBone source) {
        dist.setRotX(source.getRotX());
        dist.setRotY(source.getRotY());
        dist.setRotZ(source.getRotZ());
    }

    private static void addRotation(GeoBone bone, int x, int y, int z) {
        bone.setRotX(bone.getRotX() + x);
        bone.setRotY(bone.getRotY() + y);
        bone.setRotZ(bone.getRotZ() + z);
    }

    private static void setRotation(GeoBone bone, int rot) {
        bone.setRotX(rot);
        bone.setRotY(rot);
        bone.setRotZ(rot);
    }

    private static void addRotationX(GeoBone bone, int x) {
        bone.setRotX(bone.getRotX() + x);
    }

    @Override
    public void render(PowerArmorFrame entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public void preRender(PoseStack poseStack, PowerArmorFrame animatable, BakedGeoModel model,
                          MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender,
                          float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
//        if (animatable == null) return;

//        if (animatable.hasPassenger() && animatable.getPassenger().getMainHandItem().getItem() instanceof GunItem gunItem) {
//            this.gunItem = gunItem;
//        } else {
//            doSafe(() -> {
//                this.gunItem = null;
//                var rightArm = model.getBone("right_arm").get();
//                var leftArm = model.getBone("left_arm").get();
//                setRotation(rightArm, 0);
//                setRotation(leftArm, 0);
//            });
//        }

        var heldItem = animatable.getMainHandItem();

        if (animatable.passengerHaveGun()) {
            var gunItem = animatable.getPassengerGun();

            var gun = gunItem.getModifiedGun(heldItem);
            var heldAnimation = gun.getGeneral().getGripType().getHeldAnimation();
            var aimProgress = AimingHandler.get().getAimProgress(animatable, partialTick);

            heldAnimation.applyEntityPreRender(
                    animatable,
                    InteractionHand.MAIN_HAND,
                    aimProgress,
                    poseStack,
                    bufferSource);
        }

    }

    @Override
    public void renderRecursively(PoseStack poseStack, PowerArmorFrame animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick,
                                  int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//        Vector3f buffVec = null;
//        buffVec = getRotations(bone);

//        if (gunItem != null) {
//            gunItem.getGun().getGeneral().getGripType().getHeldAnimation()
//                    .applyGeoModelRotation(animatable, , getGeoModel());
//        }
//        else{
//            if (bone.getName().equals("right_arm") || bone.getName().equals("left_arm")) {
//                setRotation(bone, 0);
////            setRotations(bone, buffVec);
//            }
//        }

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick,
                packedLight, packedOverlay, red, green, blue, alpha);
    }
}
