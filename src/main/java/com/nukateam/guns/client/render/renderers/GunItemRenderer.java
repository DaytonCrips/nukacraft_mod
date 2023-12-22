package com.nukateam.guns.client.render.renderers;

import com.nukateam.guns.client.model.GeoGunModel;
import com.nukateam.guns.client.model.GunModel;
import com.nukateam.guns.common.foundation.item.GunItem;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class GunItemRenderer extends GeoItemRenderer<GunItem> {
    public GunItemRenderer() {
        super(new GeoGunModel<>());
    }
}
