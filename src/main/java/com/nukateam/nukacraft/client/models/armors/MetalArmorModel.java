package com.nukateam.nukacraft.client.models.armors;

import com.nukateam.nukacraft.common.foundation.items.custom.armor.LeatherArmorItem;
import com.nukateam.nukacraft.common.foundation.items.custom.armor.MetalArmorItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class MetalArmorModel extends GeoModel<MetalArmorItem> {
    @Override
    public ResourceLocation getModelResource(MetalArmorItem metalArmorItem) {
        return nukaResource("geo/cloths/metalarmor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MetalArmorItem metalArmorItem) {
        return nukaResource("textures/armor/"+ metalArmorItem.getSkin() +"_metalarmor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MetalArmorItem metalArmorItem) {
        return nukaResource( "animations/armor_default_animation.json");
    }
}
