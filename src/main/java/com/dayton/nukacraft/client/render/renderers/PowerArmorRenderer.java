package com.dayton.nukacraft.client.render.renderers;

import com.dayton.guns.client.render.pose.OneHandedPose;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.nukacraft.client.render.layers.RaiderHeadLayer;
import com.dayton.nukacraft.common.foundation.entities.PowerArmorFrame;
import com.jetug.chassis_core.client.render.renderers.ChassisRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.object.GeoBone;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static com.dayton.guns.common.base.GripType.ONE_HANDED;
import static com.jetug.chassis_core.client.render.renderers.CustomHandRenderer.doSafe;

public class PowerArmorRenderer extends ChassisRenderer<PowerArmorFrame> {
    public GunItem gunItem;

    public PowerArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager);
        addRenderLayer(new RaiderHeadLayer<>(this));
    }

    @Override
    public void render(PowerArmorFrame entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public void preRender(PoseStack poseStack, PowerArmorFrame animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        if(animatable == null) return;

        if (animatable.hasPassenger() && animatable.getPassenger().getMainHandItem().getItem() instanceof GunItem gunItem) {
            this.gunItem = gunItem;
        } else {
            doSafe(() -> {
                this.gunItem = null;
                GeoBone rightArm = model.getBone("right_arm").get();
                GeoBone leftArm = model.getBone("left_arm").get();
                setRotation(rightArm, 0);
                setRotation(leftArm, 0);
            });
        }
    }

    public static void copyRotations(GeoBone dist, GeoBone source) {
        dist.setRotX(source.getRotX());
        dist.setRotY(source.getRotY());
        dist.setRotX(source.getRotZ());
    }

    private static void addRotation(GeoBone bone, int x, int y, int z) {
        bone.setRotX(bone.getRotX() + x);
        bone.setRotY(bone.getRotY() + y);
        bone.setRotX(bone.getRotZ() + z);
    }

    private static void setRotation(GeoBone bone, int rot) {
        bone.setRotX(rot);
        bone.setRotY(rot);
        bone.setRotX(rot);
    }


    private static void addRotationX(GeoBone bone, int x) {
        bone.setRotX(bone.getRotX() + x);
    }

    @Override
    public void renderRecursively(PoseStack poseStack, PowerArmorFrame animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick,
                                  int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if(gunItem != null){
//            if (gunItem.getGun().getGeneral().getGripType() == ONE_HANDED) {
                    gunItem.getGun().getGeneral().getGripType().getHeldAnimation()
                            .applyGeoModelRotation(animatable, getGeoModel(), bone);
//            }
        }

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick,
                packedLight, packedOverlay, red, green, blue, alpha);
    }
}
