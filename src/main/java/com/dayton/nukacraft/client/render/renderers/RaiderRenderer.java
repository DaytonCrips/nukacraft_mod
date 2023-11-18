package com.dayton.nukacraft.client.render.renderers;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;

public class RaiderRenderer extends HumanoidMobRenderer {
    public RaiderRenderer(EntityRendererProvider.Context pContext, HumanoidModel pModel, float pShadowRadius) {
        super(pContext, pModel, pShadowRadius);
    }

    public RaiderRenderer(EntityRendererProvider.Context pContext, HumanoidModel pModel, float pShadowRadius, float pScaleX, float pScaleY, float pScaleZ) {
        super(pContext, pModel, pShadowRadius, pScaleX, pScaleY, pScaleZ);
    }
}
