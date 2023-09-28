package com.dayton.nukacraft.common.materials;

import com.jetug.chassis_core.common.foundation.ChassisArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class PowerArmorMaterials {

    public static ChassisArmorMaterial RAIDER = new ChassisArmorMaterial(
            "t45", 15, new int[]{1, 4, 2, 2}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial EXCAVATOR = new ChassisArmorMaterial(
            "t45", 15, new int[]{2, 5, 3, 3}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial T45 = new ChassisArmorMaterial(
            "t45", 15, new int[]{3, 8, 6, 6}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial T51 = new ChassisArmorMaterial(
            "t45", 15, new int[]{4, 9, 7, 7}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial T60 = new ChassisArmorMaterial(
            "t45", 15, new int[]{5, 10, 8, 8}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial X01 = new ChassisArmorMaterial(
            "t45", 15, new int[]{7, 14, 10, 10}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));
}
