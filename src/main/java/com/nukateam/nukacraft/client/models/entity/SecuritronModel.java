package com.nukateam.nukacraft.client.models.entity;

import com.nukateam.nukacraft.common.foundation.entities.mobs.Deathclaw;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static com.jetug.chassis_core.client.render.utils.GeoUtils.setHeadAnimation;
import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class SecuritronModel<Type extends Securitron> extends EntityModel<Type> {
    private static final ResourceLocation model = nukaResource("geo/entity/deathclaw.geo.json");
    private static final ResourceLocation animation = nukaResource("animations/entity/deathclaw.animation.json");

    @Override
    public ResourceLocation getTextureResource(Type object) {
        return nukaResource("textures/entity/securitron/"+ object.getVariant().getTexture() +".png");
    }
}