package com.nukateam.nukacraft.client.render.renderers.geo.block;

import com.nukateam.nukacraft.client.models.blocks.GearDoorModel;
import com.nukateam.nukacraft.common.foundation.blocks.entity.GearDoorEntity;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoBlockRenderer;

public class GearDoorRenderer extends GeoBlockRenderer<GearDoorEntity> {
    public GearDoorRenderer() {
        super(new GearDoorModel());
    }
}
