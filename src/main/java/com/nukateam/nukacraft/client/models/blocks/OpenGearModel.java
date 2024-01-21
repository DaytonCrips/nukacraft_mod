package com.nukateam.nukacraft.client.models.blocks;

import com.nukateam.nukacraft.common.foundation.blocks.entity.GearDoorEntity;
import com.nukateam.nukacraft.common.foundation.blocks.entity.OpenGearEntity;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class OpenGearModel extends GeoModel<OpenGearEntity> {
    private static final ResourceLocation model = new ResourceLocation("nukacraft", "geo/blocks/vtdoor.geo.json");
    private static final ResourceLocation texture = new ResourceLocation("nukacraft", "textures/blocks/vtdoor.png");
    private static final ResourceLocation animation = new ResourceLocation("nukacraft", "animations/blocks/vtdoor.animation.json");

    @Override
    public ResourceLocation getModelResource(OpenGearEntity gearDoorEntity) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(OpenGearEntity gearDoorEntity) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(OpenGearEntity gearDoorEntity) {
        return animation;
    }
}
