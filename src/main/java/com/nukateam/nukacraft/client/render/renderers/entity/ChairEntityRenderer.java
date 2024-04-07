package com.nukateam.nukacraft.client.render.renderers.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.common.foundation.entities.blocks.ChairBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;


public class ChairEntityRenderer<T extends Entity> extends EntityRenderer<ChairBlockEntity> {
    public ChairEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(ChairBlockEntity seatEntity) {
        return null;
    }

    @Override
    protected void renderNameTag(ChairBlockEntity entity, Component component, PoseStack stack, MultiBufferSource source, int light) {
    }
}
