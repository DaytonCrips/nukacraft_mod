package com.dayton.guns.common.foundation.enchantment;

import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.nukacraft.NukaCraftMod;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/**
 * Author: MrCrayfish
 */
public class EnchantmentTypes {
    public static final EnchantmentCategory GUN = EnchantmentCategory.create(NukaCraftMod.MOD_ID + ":gun", item -> item instanceof GunItem);
    public static final EnchantmentCategory SEMI_AUTO_GUN = EnchantmentCategory.create(NukaCraftMod.MOD_ID + ":semi_auto_gun", item -> item instanceof GunItem && !((GunItem) item).getGun().getGeneral().isAuto());
}
