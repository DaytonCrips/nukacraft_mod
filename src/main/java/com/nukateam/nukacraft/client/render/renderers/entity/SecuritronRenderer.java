package com.nukateam.nukacraft.client.render.renderers.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.client.models.entity.EntityModel;
import com.nukateam.nukacraft.client.models.entity.SecuritronModel;
import com.nukateam.nukacraft.client.render.layers.GlowingLayer;
import com.nukateam.nukacraft.client.render.layers.SecuritronFaceLayer;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.LivingEntity;

public class SecuritronRenderer extends SimpleEntityRenderer<Securitron> {
    public SecuritronRenderer(EntityRendererProvider.Context renderManager) {
        this(renderManager, new SecuritronModel<>());
        addRenderLayer(new SecuritronFaceLayer(this));
    }

    public SecuritronRenderer(EntityRendererProvider.Context renderManager, GeoModel<Securitron> model) {
        super(renderManager, model);
    }

    @Override
    public void render(Securitron entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}