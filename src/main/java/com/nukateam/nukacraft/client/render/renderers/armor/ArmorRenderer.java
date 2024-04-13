package com.nukateam.nukacraft.client.render.renderers.armor;

import com.nukateam.nukacraft.client.models.armors.StaticArmorModel;
import com.nukateam.nukacraft.common.foundation.items.armor.GeoArmorItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class ArmorRenderer extends GeoArmorRenderer<GeoArmorItem> {
    public ArmorRenderer() {
        super(new StaticArmorModel());
    }
}
