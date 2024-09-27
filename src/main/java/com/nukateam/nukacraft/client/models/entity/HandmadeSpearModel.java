package com.nukateam.nukacraft.client.models.entity;

import com.nukateam.ntgl.client.model.IGlowingModel;
import com.nukateam.nukacraft.common.foundation.items.misc.HandmadeSpearItem;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import com.nukateam.nukacraft.common.foundation.items.misc.SimpleMeleeWeapon;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class HandmadeSpearModel extends GeoModel<HandmadeSpearItem>{

    @Override
    public ResourceLocation getModelResource(HandmadeSpearItem handmadeSpearItem) {
        return nukaResource("geo/items/spear.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HandmadeSpearItem handmadeSpearItem) {
        return nukaResource("textures/item/melee/spear.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HandmadeSpearItem handmadeSpearItem) {
        return null;
    }
}
