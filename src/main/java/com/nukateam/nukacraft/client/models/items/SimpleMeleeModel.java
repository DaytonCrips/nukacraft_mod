package com.nukateam.nukacraft.client.models.items;

import com.nukateam.nukacraft.common.foundation.items.misc.SimpleMeleeWeapon;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;


public class SimpleMeleeModel extends GeoModel<SimpleMeleeWeapon> {


    @Override
    public ResourceLocation getModelResource(SimpleMeleeWeapon weapon) {
        return nukaResource("geo/items/" + weapon.getName() + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SimpleMeleeWeapon weapon) {
        return nukaResource("textures/item/melee/" + weapon.getName() + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(SimpleMeleeWeapon weapon) {
        return null;
    }
}
