package com.nukateam.nukacraft.client.models.blocks;

import com.nukateam.nukacraft.common.foundation.entities.blocks.GearDoorEntity;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class GearDoorModel extends GeoModel<GearDoorEntity> {

    private static final ResourceLocation model = new ResourceLocation("nukacraft", "geo/blocks/vtdoor.geo.json");
    private static final ResourceLocation texture = new ResourceLocation("nukacraft", "textures/blocks/vtdoor.png");
    private static final ResourceLocation animation = new ResourceLocation("nukacraft", "animations/blocks/vtdoor.animation.json");

    @Override
    public ResourceLocation getModelResource(GearDoorEntity gearDoorEntity) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(GearDoorEntity gearDoorEntity) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(GearDoorEntity gearDoorEntity) {
        return animation;
    }
}
