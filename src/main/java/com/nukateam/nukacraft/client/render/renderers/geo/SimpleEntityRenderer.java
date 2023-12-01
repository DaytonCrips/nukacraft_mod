package com.nukateam.nukacraft.client.render.renderers.geo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.client.models.endity.geo.DeathclawModel;
import com.nukateam.nukacraft.client.models.endity.geo.EntityModel;
import com.nukateam.nukacraft.common.foundation.entities.Deathclaw;
import com.nukateam.nukacraft.common.foundation.entities.NuclearExplosionEffectEntity;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SimpleEntityRenderer<T extends LivingEntity & GeoAnimatable> extends GeoEntityRenderer<T> {
    private final float scale;

    public SimpleEntityRenderer(EntityRendererProvider.Context renderManager) {
        this(renderManager, 1);
    }

    public SimpleEntityRenderer(EntityRendererProvider.Context renderManager, float scale) {
        super(renderManager, new EntityModel<>());
        this.scale = scale;
    }

    @Override
    public void render(T entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.scale(scale, scale, scale);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}