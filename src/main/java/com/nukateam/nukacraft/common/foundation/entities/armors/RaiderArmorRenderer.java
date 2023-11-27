package com.nukateam.nukacraft.common.foundation.entities.armors;

import com.nukateam.nukacraft.client.models.armors.RaiderArmorModel;
import com.nukateam.nukacraft.common.foundation.items.custom.armor.RaiderArmorItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class RaiderArmorRenderer extends GeoArmorRenderer<RaiderArmorItem> {
    public RaiderArmorRenderer() {
        super(new RaiderArmorModel());
    }
}
