package com.dayton.nukacraft.common.items.custom.armor;

import com.dayton.nukacraft.common.items.ModItemTabs;
import com.jetug.chassis_core.common.foundation.ChassisArmorMaterial;
import com.jetug.chassis_core.common.foundation.item.ChassisArmor;
import net.minecraft.world.item.Item;

public class ArmorPart extends ChassisArmor {
    public ArmorPart(ChassisArmorMaterial material, String part) {
        super(new Item.Properties().tab(ModItemTabs.NUKA_ARMOR), material, part);
    }
}
