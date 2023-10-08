package com.dayton.nukacraft.client.render.renderers;

import com.dayton.nukacraft.client.models.endity.DeathclawModel;
import com.dayton.nukacraft.common.foundation.entities.Deathclaw;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DeathclawRenderer extends GeoEntityRenderer<Deathclaw> {
    public DeathclawRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeathclawModel<>());
    }
}