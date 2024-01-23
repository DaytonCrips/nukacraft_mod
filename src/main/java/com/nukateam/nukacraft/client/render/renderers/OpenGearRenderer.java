package com.nukateam.nukacraft.client.render.renderers;

import com.nukateam.nukacraft.client.models.blocks.OpenGearModel;
import com.nukateam.nukacraft.common.foundation.entities.blocks.OpenGearEntity;
import mod.azure.azurelib.renderer.GeoBlockRenderer;

public class OpenGearRenderer extends GeoBlockRenderer<OpenGearEntity> {
    public OpenGearRenderer() {
        super(new OpenGearModel());
    }
}
