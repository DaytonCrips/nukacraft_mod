package com.nukateam.nukacraft.client.models.blocks;


import com.nukateam.nukacraft.common.foundation.entities.blocks.PowerArmorStationEntity;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class PowerAmorStationModel extends GeoModel<PowerArmorStationEntity> {
    private static final ResourceLocation model = new ResourceLocation("nukacraft", "geo/blocks/power_armor_station.geo.json");
    private static final ResourceLocation texture = new ResourceLocation("nukacraft", "textures/block/pa_station.png");
    @Override
    public ResourceLocation getModelResource(PowerArmorStationEntity gearDoorEntity) {
        return model;
    }

    @Override
    public ResourceLocation getTextureResource(PowerArmorStationEntity gearDoorEntity) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationResource(PowerArmorStationEntity gearDoorEntity) {
        return null;
    }
}
