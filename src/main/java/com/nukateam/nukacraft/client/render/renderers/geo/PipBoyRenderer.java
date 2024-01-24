package com.nukateam.nukacraft.client.render.renderers.geo;

import com.nukateam.nukacraft.client.models.items.PipBoyItemModel;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class PipBoyRenderer extends GeoItemRenderer<PipBoyItem> {
    public PipBoyRenderer() {
        super(new PipBoyItemModel());
    }
}
