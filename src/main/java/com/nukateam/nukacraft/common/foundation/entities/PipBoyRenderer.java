package com.nukateam.nukacraft.common.foundation.entities;

import com.nukateam.nukacraft.client.models.items.PipBoyItemModel;
import com.nukateam.nukacraft.common.foundation.items.custom.PipBoyItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class PipBoyRenderer extends GeoItemRenderer<PipBoyItem> {
    public PipBoyRenderer() {
        super(new PipBoyItemModel());
    }
}
