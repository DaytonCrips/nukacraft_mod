package com.dayton.nukacraft.common.foundation.entities.armors;

import com.dayton.nukacraft.client.models.LeatherArmorModel;
import com.dayton.nukacraft.client.models.RaiderArmorModel;
import com.dayton.nukacraft.common.foundation.items.custom.armor.LeatherArmorItem;
import com.dayton.nukacraft.common.foundation.items.custom.armor.RaiderArmorItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class RaiderArmorRenderer extends GeoArmorRenderer<RaiderArmorItem> {
    public RaiderArmorRenderer() {
        super(new RaiderArmorModel());
    }
}
