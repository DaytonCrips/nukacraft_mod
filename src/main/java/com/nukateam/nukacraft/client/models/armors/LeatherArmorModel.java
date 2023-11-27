package com.nukateam.nukacraft.client.models.armors;


import com.nukateam.nukacraft.common.foundation.items.custom.armor.LeatherArmorItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class LeatherArmorModel extends GeoModel<LeatherArmorItem> {

    @Override
    public ResourceLocation getModelResource(LeatherArmorItem leatherArmorItem) {
        return nukaResource("geo/cloths/leatherarmor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LeatherArmorItem leatherArmorItem) {
        return nukaResource("textures/armor/"+ leatherArmorItem.getSkin() +"_leather_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LeatherArmorItem leatherArmorItem) {
        return nukaResource( "animations/armor_default_animation.json");
    }
}
