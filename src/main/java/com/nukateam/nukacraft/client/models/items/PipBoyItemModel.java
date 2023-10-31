package com.nukateam.nukacraft.client.models.items;

import com.nukateam.nukacraft.common.foundation.items.custom.PipBoyItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

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
