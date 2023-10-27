package com.dayton.nukacraft.client.models.items;

import com.dayton.nukacraft.common.foundation.items.custom.PipBoyItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;

public class PipBoyItemModel extends GeoModel<PipBoyItem> {
    @Override
    public ResourceLocation getModelResource(PipBoyItem pipBoyItem) {
        return nukaResource("geo/items/pipboy.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PipBoyItem pipBoyItem) {
        return nukaResource("textures/items/"+ pipBoyItem.getSkin() +"_pipboy.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PipBoyItem pipBoyItem) {
        return null;
    }
}
