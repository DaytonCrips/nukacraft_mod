package com.nukateam.nukacraft.common.foundation.entities.armors;

import com.nukateam.nukacraft.client.models.armors.TrapArmorModel;
import com.nukateam.nukacraft.common.foundation.items.custom.armor.TrapperArmorItem;
import mod.azure.azurelib.renderer.GeoArmorRenderer;

public class TrapArmortRenderer extends GeoArmorRenderer<TrapperArmorItem> {
    public TrapArmortRenderer() {
        super(new TrapArmorModel());
    }
}
