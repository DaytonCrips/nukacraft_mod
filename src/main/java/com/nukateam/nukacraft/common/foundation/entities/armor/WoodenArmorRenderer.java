package com.nukateam.nukacraft.common.foundation.entities.armor;

import com.nukateam.nukacraft.client.models.armors.WoodenArmorModel;
import com.nukateam.nukacraft.common.foundation.items.custom.armor.WoodenArmorItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class WoodenArmorRenderer extends GeoArmorRenderer<WoodenArmorItem> {
    public WoodenArmorRenderer() {
        super(new WoodenArmorModel());
    }
}
