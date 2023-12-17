package com.nukateam.guns.client.render.renderers;

import com.nukateam.guns.client.model.GunHandModel;
import mod.azure.azurelib.renderer.GeoObjectRenderer;

public class GunHandRenderer extends GeoObjectRenderer {
    public GunHandRenderer() {
        super(new GunHandModel());
    }
}
