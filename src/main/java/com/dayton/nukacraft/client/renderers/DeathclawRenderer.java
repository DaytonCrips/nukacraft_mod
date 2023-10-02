package com.dayton.nukacraft.client.renderers;

import com.dayton.nukacraft.client.models.DeathclawModel;
import com.dayton.nukacraft.common.foundation.entities.Deathclaw;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeathclawRenderer extends GeoEntityRenderer<Deathclaw> {
    public DeathclawRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeathclawModel<>());
    }
}