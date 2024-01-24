package com.nukateam.nukacraft.common.foundation.entities.items;


import com.nukateam.nukacraft.client.models.items.SimpleMeleeModel;
import com.nukateam.nukacraft.common.foundation.items.misc.SimpleMeleeWeapon;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class SimpleMeleeRenderer extends GeoItemRenderer<SimpleMeleeWeapon> {

    public SimpleMeleeRenderer() {
        super(new SimpleMeleeModel());
    }
}
