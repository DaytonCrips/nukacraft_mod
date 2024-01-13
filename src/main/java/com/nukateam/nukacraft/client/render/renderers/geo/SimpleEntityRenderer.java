package com.nukateam.nukacraft.client.render.renderers.geo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.client.models.entity.geo.EntityModel;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.LivingEntity;

public class SimpleEntityRenderer<T extends LivingEntity & GeoAnimatable> extends GeoEntityRenderer<T> {
    private float scale = 1;

    public SimpleEntityRenderer(EntityRendererProvider.Context renderManager) {
        this(renderManager, new EntityModel<>());
    }

    public SimpleEntityRenderer(EntityRendererProvider.Context renderManager, GeoModel<T> model) {
        super(renderManager, model);
    }

    @Override
    public void render(T entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(scale, scale, scale);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    public SimpleEntityRenderer setScale(float scale) {
        this.scale = scale;
        return this;
    }
}