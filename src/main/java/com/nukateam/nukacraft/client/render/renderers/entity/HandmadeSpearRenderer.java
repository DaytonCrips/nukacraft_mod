package com.nukateam.nukacraft.client.render.renderers.entity;

import com.nukateam.nukacraft.client.models.entity.HandmadeSpearModel;
import com.nukateam.nukacraft.client.models.items.PipBoyItemModel;
import com.nukateam.nukacraft.client.render.layers.GlowingLayer;
import com.nukateam.nukacraft.common.foundation.items.misc.HandmadeSpearItem;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class HandmadeSpearRenderer extends GeoItemRenderer<HandmadeSpearItem> {
    public HandmadeSpearRenderer() {
        super(new HandmadeSpearModel());
    }
}
