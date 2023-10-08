package com.dayton.nukacraft.client.render.renderers;

import com.dayton.nukacraft.common.foundation.entities.PowerArmorFrame;
import com.jetug.chassis_core.client.render.renderers.ChassisRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PowerArmorRenderer extends ChassisRenderer<PowerArmorFrame> {
    public PowerArmorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager);
    }
}
