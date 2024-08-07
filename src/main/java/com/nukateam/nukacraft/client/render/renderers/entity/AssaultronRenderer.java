package com.nukateam.nukacraft.client.render.renderers.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.nukacraft.client.models.entity.*;
import com.nukateam.nukacraft.client.render.layers.*;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Assaultron;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.object.GeoBone;
import mod.azure.azurelib.renderer.DynamicGeoEntityRenderer;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class AssaultronRenderer extends DynamicGeoEntityRenderer<Assaultron> {
    public AssaultronRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager,  new AssaultronModel<>());
        addRenderLayer(new AssaultronLayer(this));
    }

    @Override
    public void render(Assaultron entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    protected ResourceLocation getTextureOverrideForBone(GeoBone bone, Assaultron entity, float partialTick) {
        return switch (bone.getName()){
            case "laser" -> nukaResource("textures/entity/assaultron/laser.png");
            default -> null;
        };
    }


    @Override
    public void renderRecursively(PoseStack poseStack, Assaultron animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer,
                                  boolean isReRender, float partialTick, int packedLight,
                                  int packedOverlay, float red, float green, float blue, float alpha) {

        if(bone.getName().equals("laser")) {
            bone.setHidden(!animatable.isShootingLaser());
//            var renderType1 = RenderType.eyes(nukaResource("textures/entity/assaultron/laser.png"));
//            var buffer1 = bufferSource
//                    .getBuffer(RenderType.beaconBeam(nukaResource("textures/entity/assaultron/laser.png"), false));
//            super.renderRecursively(poseStack, animatable, bone, renderType1, bufferSource, buffer1, isReRender,
//                    partialTick, packedLight, packedOverlay, red, green, blue, alpha);
//            return;
        }
//        var bakedModel = getGeoModel().getBakedModel(getGeoModel().getModelResource(animatable));
//        this.reRender(bakedModel, poseStack, bufferSource, animatable, renderTypeNew,
//                bufferSource.getBuffer(renderTypeNew), partialTick, packedLight, OverlayTexture.NO_OVERLAY,
//                1.0F, 1.0F, 1.0F, 1.0F);

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender,
                partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }


//    @Override
//    public RenderType getRenderType(Assaultron animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
//        return RenderType.entityTranslucent(texture);
//    }
}