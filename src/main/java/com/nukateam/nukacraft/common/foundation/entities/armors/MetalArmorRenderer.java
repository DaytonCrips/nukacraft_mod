package com.nukateam.nukacraft.common.foundation.entities.armors;

import com.nukateam.nukacraft.client.models.armors.MetalArmorModel;
import com.nukateam.nukacraft.common.foundation.items.custom.armor.MetalArmorItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class MetalArmorRenderer extends GeoArmorRenderer<MetalArmorItem> {
    public MetalArmorRenderer() {
        super(new MetalArmorModel());
    }
}
