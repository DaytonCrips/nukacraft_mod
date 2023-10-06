package com.dayton.nukacraft.client.render.renderers;

import com.dayton.nukacraft.client.models.GunModel;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoObjectRenderer;

public class GunRenderer extends GeoObjectRenderer {
    public GunRenderer() {
        super(new GunModel());
    }
}
