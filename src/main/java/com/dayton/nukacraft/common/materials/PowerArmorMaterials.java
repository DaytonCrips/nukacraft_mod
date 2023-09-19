package com.dayton.nukacraft.common.materials;

import com.jetug.chassis_core.common.foundation.ChassisArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class PowerArmorMaterials {
    public static ChassisArmorMaterial T45 = new ChassisArmorMaterial(
            "iron", 15, new int[]{3, 6, 4, 4}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));
}
