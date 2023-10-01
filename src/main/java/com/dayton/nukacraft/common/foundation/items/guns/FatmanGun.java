package com.dayton.nukacraft.common.foundation.items.guns;

import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public class FatmanGun extends GunItem {
    public FatmanGun(Properties properties) {
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
