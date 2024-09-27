package com.nukateam.nukacraft.client.render.renderers.items;

import com.nukateam.nukacraft.client.models.entity.HandmadeSpearModel;
import com.nukateam.nukacraft.common.foundation.items.misc.SpearItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class SpearRenderer extends GeoItemRenderer<SpearItem> {
    public SpearRenderer() {
        super(new HandmadeSpearModel<>());
    }
}
