package com.dayton.nukacraft.common.foundation.entities.armors;

import com.dayton.nukacraft.client.models.WoodenArmorModel;
import com.dayton.nukacraft.common.foundation.items.custom.armor.WoodenArmorItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class WoodenArmorRenderer extends GeoArmorRenderer<WoodenArmorItem> {
    public WoodenArmorRenderer() {
        super(new WoodenArmorModel());
    }
}
