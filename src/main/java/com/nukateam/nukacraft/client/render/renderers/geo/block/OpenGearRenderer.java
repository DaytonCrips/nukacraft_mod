package com.nukateam.nukacraft.client.render.renderers.geo.block;

import com.nukateam.nukacraft.client.models.blocks.GearDoorModel;
import com.nukateam.nukacraft.client.models.blocks.OpenGearModel;
import com.nukateam.nukacraft.common.foundation.blocks.entity.GearDoorEntity;
import com.nukateam.nukacraft.common.foundation.blocks.entity.OpenGearEntity;
import mod.azure.azurelib.renderer.GeoBlockRenderer;

public class OpenGearRenderer extends GeoBlockRenderer<OpenGearEntity> {
    public OpenGearRenderer() {
        super(new OpenGearModel());
    }
}
