package com.dayton.nukacraft.client.renderers;

import com.dayton.nukacraft.common.entities.PowerArmorFrame;
import com.jetug.chassis_core.client.render.renderers.ChassisRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.geo.render.built.GeoModel;

public class PowerArmorRenderer extends ChassisRenderer<PowerArmorFrame> {
    public PowerArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager);
    }

    @Override
    public void render(GeoModel model, PowerArmorFrame animatable, float partialTick, RenderType type,
                       PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer,
                       int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.render(model, animatable, partialTick,
                type, poseStack, bufferSource,
                buffer, packedLight, packedOverlay,
                red, green, blue, alpha);
    }
}
