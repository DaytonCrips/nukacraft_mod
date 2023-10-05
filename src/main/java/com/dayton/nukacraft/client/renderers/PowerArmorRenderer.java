package com.dayton.nukacraft.client.renderers;

import com.dayton.nukacraft.common.foundation.entities.PowerArmorFrame;
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
}
