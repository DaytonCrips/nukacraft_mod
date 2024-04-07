package com.nukateam.nukacraft.client.models.armors;

import com.nukateam.nukacraft.common.foundation.items.armor.RaiderArmorItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class RaiderArmorModel extends GeoModel<RaiderArmorItem> {

    @Override
    public ResourceLocation getModelResource(RaiderArmorItem raiderArmorItem) {
        return nukaResource("geo/cloths/raiderarmor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RaiderArmorItem raiderArmorItem) {
        return nukaResource("textures/armor/" + raiderArmorItem.getSkin() + "_raider_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RaiderArmorItem raiderArmorItem) {
        return nukaResource("animations/armor_default_animation.json");
    }
}
