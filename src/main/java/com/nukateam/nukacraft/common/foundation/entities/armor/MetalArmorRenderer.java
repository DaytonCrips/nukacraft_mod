package com.nukateam.nukacraft.common.foundation.entities.armor;

import com.nukateam.nukacraft.client.models.armors.MetalArmorModel;
import com.nukateam.nukacraft.common.foundation.items.armor.MetalArmorItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class MetalArmorRenderer extends GeoArmorRenderer<MetalArmorItem> {
    public MetalArmorRenderer() {
        super(new MetalArmorModel());
    }
}
