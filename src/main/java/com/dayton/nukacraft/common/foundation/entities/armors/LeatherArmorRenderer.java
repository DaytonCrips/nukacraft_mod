package com.dayton.nukacraft.common.foundation.entities.armors;

import com.dayton.nukacraft.client.models.LeatherArmorModel;
import com.dayton.nukacraft.client.models.WoodenArmorModel;
import com.dayton.nukacraft.common.foundation.items.custom.armor.LeatherArmorItem;
import com.dayton.nukacraft.common.foundation.items.custom.armor.WoodenArmorItem;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class LeatherArmorRenderer extends GeoArmorRenderer<LeatherArmorItem> {
    public LeatherArmorRenderer() {
        super(new LeatherArmorModel());
    }
}
