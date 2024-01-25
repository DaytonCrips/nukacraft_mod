package com.nukateam.nukacraft.client.render.renderers.block;

import com.nukateam.nukacraft.client.models.blocks.GearDoorModel;
import com.nukateam.nukacraft.common.foundation.entities.blocks.GearDoorEntity;
import mod.azure.azurelib.renderer.GeoBlockRenderer;

public class GearDoorRenderer extends GeoBlockRenderer<GearDoorEntity> {
    public GearDoorRenderer() {
        super(new GearDoorModel());
    }
}
