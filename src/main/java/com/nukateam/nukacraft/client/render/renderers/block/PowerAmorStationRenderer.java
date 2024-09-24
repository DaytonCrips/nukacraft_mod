package com.nukateam.nukacraft.client.render.renderers.block;


import com.nukateam.nukacraft.client.models.blocks.PowerAmorStationModel;
import com.nukateam.nukacraft.common.foundation.entities.blocks.PowerArmorStationEntity;
import mod.azure.azurelib.renderer.GeoBlockRenderer;

public class PowerAmorStationRenderer extends GeoBlockRenderer<PowerArmorStationEntity> {
    public PowerAmorStationRenderer() {
        super(new PowerAmorStationModel());
    }
}
