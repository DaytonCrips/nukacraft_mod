package com.nukateam.nukacraft.client.render.renderers.entity;

import com.nukateam.nukacraft.client.models.entity.DeathclawModel;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Deathclaw;
import mod.azure.azurelib.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DeathclawRenderer extends GeoEntityRenderer<Deathclaw> {
    public static final DeathclawModel<Deathclaw> DEATHCLAW_MODEL = new DeathclawModel<>();

    public DeathclawRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, DEATHCLAW_MODEL);
    }
}