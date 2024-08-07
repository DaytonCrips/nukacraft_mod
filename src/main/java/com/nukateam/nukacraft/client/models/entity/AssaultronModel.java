package com.nukateam.nukacraft.client.models.entity;

import com.nukateam.nukacraft.common.foundation.entities.mobs.Assaultron;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class AssaultronModel<Type extends Assaultron> extends EntityModel<Type> {
    @Override
    public ResourceLocation getTextureResource(Type object) {
        return nukaResource("textures/entity/assaultron/assaultron.png");
    }

    @Override
    public RenderType getRenderType(Type animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(this.getTextureResource(animatable));
    }
}