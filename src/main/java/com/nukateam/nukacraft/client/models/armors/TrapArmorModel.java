package com.nukateam.nukacraft.client.models.armors;

import com.nukateam.nukacraft.common.foundation.items.armor.TrapperArmorItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class TrapArmorModel extends GeoModel<TrapperArmorItem> {
    @Override
    public ResourceLocation getModelResource(TrapperArmorItem trapArmorItem) {
        return nukaResource("geo/cloths/trapperarmor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TrapperArmorItem trapArmorItem) {
        return nukaResource("textures/armor/"+ trapArmorItem.getSkin() +"_trap_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TrapperArmorItem trapArmorItem) {
        return nukaResource( "animations/armor_default_animation.json");
    }
}
