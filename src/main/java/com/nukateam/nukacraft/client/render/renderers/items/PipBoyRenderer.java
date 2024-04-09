package com.nukateam.nukacraft.client.render.renderers.items;

import com.nukateam.ntgl.client.render.layers.GlowingLayer;
import com.nukateam.nukacraft.client.models.items.PipBoyItemModel;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class PipBoyRenderer extends GeoItemRenderer<PipBoyItem> {
    public PipBoyRenderer() {
        super(new PipBoyItemModel());
        addRenderLayer(new GlowingLayer<>(this));
    }
}
