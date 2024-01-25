package com.nukateam.nukacraft.client.render.renderers.entity;

import com.nukateam.nukacraft.client.models.entity.DeathclawModel;
import com.nukateam.nukacraft.common.foundation.entities.Deathclaw;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import mod.azure.azurelib.renderer.layer.AutoGlowingGeoLayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DeathclawRenderer extends GeoEntityRenderer<Deathclaw> {
    public DeathclawRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeathclawModel<>());
    }
}