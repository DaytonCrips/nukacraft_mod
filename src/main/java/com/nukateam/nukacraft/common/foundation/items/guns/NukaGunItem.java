package com.nukateam.nukacraft.common.foundation.items.guns;

import com.nukateam.ntgl.common.foundation.item.GunItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public class NukaGunItem extends GunItem {
    public NukaGunItem(Properties properties) {
        super(properties);
    }

    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return false;
    }
}
