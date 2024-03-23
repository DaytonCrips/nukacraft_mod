package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RadFoodItem extends RadItem {
    public RadFoodItem(float radiation, Item.Properties properties) {
        super(radiation, properties);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 20;
    }
}