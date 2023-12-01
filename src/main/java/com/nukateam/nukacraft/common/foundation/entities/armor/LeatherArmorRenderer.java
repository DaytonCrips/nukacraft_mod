package com.nukateam.nukacraft.common.foundation.entities.armor;

import com.nukateam.nukacraft.client.models.armors.LeatherArmorModel;
import com.nukateam.nukacraft.common.foundation.items.custom.armor.LeatherArmorItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class LeatherArmorRenderer extends GeoArmorRenderer<LeatherArmorItem> {
    public LeatherArmorRenderer() {
        super(new LeatherArmorModel());
    }
}
