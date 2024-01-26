package com.nukateam.nukacraft.client.models.armors;

import com.nukateam.nukacraft.common.foundation.items.armor.WoodenArmorItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class WoodenArmorModel extends GeoModel<WoodenArmorItem> {

    @Override
    public ResourceLocation getModelResource(WoodenArmorItem object) {
        return nukaResource("geo/cloths/woodenarmor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WoodenArmorItem object) {
        return nukaResource("textures/armor/"+ object.getSkin() +"_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WoodenArmorItem animatable) {
        return nukaResource( "animations/armor_default_animation.json");
    }
}
