package com.nukateam.guns.client.model;

import com.jetug.chassis_core.ChassisCore;
import com.nukateam.guns.common.foundation.item.TestItem;
import com.nukateam.nukacraft.NukaCraftMod;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

public class TestModel extends GeoModel<TestItem> {
    @Override
    public ResourceLocation getModelResource(TestItem testItem) {
        return new ResourceLocation(NukaCraftMod.MOD_ID, "geo/test.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TestItem testItem) {
        return new ResourceLocation(NukaCraftMod.MOD_ID, "textures/test.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TestItem testItem) {
        return null;
    }
}
