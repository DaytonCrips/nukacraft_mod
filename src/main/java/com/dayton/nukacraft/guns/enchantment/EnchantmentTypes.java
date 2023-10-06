package com.dayton.nukacraft.guns.enchantment;

import com.dayton.nukacraft.guns.Reference;
import com.dayton.nukacraft.guns.item.GunItem;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/**
 * Author: MrCrayfish
 */
public class EnchantmentTypes
{
    public static final EnchantmentCategory GUN = EnchantmentCategory.create(Reference.MOD_ID + ":gun", item -> item instanceof GunItem);
    public static final EnchantmentCategory SEMI_AUTO_GUN = EnchantmentCategory.create(Reference.MOD_ID + ":semi_auto_gun", item -> item instanceof GunItem && !((GunItem) item).getGun().getGeneral().isAuto());
}
