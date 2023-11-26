package com.nukateam.nukacraft.common.foundation.entities.armors;

import com.nukateam.nukacraft.client.models.LeatherArmorModel;
import com.nukateam.nukacraft.common.foundation.items.custom.armor.LeatherArmorItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class LeatherArmorRenderer extends GeoArmorRenderer<LeatherArmorItem> {
    public LeatherArmorRenderer() {
        super(new LeatherArmorModel());
    }
}
