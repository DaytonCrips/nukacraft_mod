package com.nukateam.nukacraft.client.models.entity;

import com.nukateam.nukacraft.common.foundation.entities.mobs.Deathclaw;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static com.jetug.chassis_core.client.render.utils.GeoUtils.setHeadAnimation;
import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class SecuritronModel<Type extends Securitron> extends EntityModel<Type> {
    @Override
    public ResourceLocation getTextureResource(Type object) {
        return nukaResource("textures/entity/securitron/securitron.png");
    }

    @Override
    public RenderType getRenderType(Type animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(texture);
    }
}