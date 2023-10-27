package com.dayton.nukacraft.common.foundation.entities;

import com.dayton.nukacraft.client.models.items.PipBoyItemModel;
import com.dayton.nukacraft.common.foundation.items.custom.PipBoyItem;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class PipBoyRenderer extends GeoItemRenderer<PipBoyItem> {
    public PipBoyRenderer() {
        super(new PipBoyItemModel());
    }
}
