package com.nukateam.nukacraft.client.render.renderers.entity;

import com.jetug.chassis_core.client.render.renderers.ChassisRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.ntgl.client.data.handler.AimingHandler;
import com.nukateam.nukacraft.client.models.PowerArmorModel;
import com.nukateam.nukacraft.common.foundation.entities.misc.PowerArmorFrame;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.object.GeoBone;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.InteractionHand;

import java.util.Objects;

import static com.jetug.chassis_core.common.data.constants.ChassisPart.HELMET;

public class PowerArmorRenderer extends ChassisRenderer<PowerArmorFrame> {
    public PowerArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PowerArmorModel());
    }

    @Override
    public void render(PowerArmorFrame entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    private static void setRotation(GeoBone bone, int rot) {
        bone.setRotX(rot);
        bone.setRotY(rot);
        bone.setRotZ(rot);
    }

    @Override
    public void preRender(PoseStack poseStack, PowerArmorFrame animatable, BakedGeoModel model,
                          MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender,
                          float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        if (animatable == null) return;

//        if (!animatable.hasPassenger() || !(animatable.getControllingPassenger().getMainHandItem().getItem() instanceof GunItem gunItem)) {
//                var rightArm = model.getBone("right_arm").get();
//                var leftArm = model.getBone("left_arm").get();
//                setRotation(rightArm, 0);
//                setRotation(leftArm, 0);
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
    protected void renderHead(PoseStack poseStack, PowerArmorFrame animatable, GeoBone bone, int packedLight, int packedOverlay) {
        if(Objects.equals(bone.getName(), "head_frame") && animatable.hasArmor(HELMET)) {
            bone.setHidden(true);
            bone.setChildrenHidden(false);
        }
        else super.renderHead(poseStack, animatable, bone, packedLight, packedOverlay);
    }
}
