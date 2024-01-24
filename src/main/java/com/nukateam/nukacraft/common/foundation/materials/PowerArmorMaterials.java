package com.nukateam.nukacraft.common.foundation.materials;

import com.jetug.chassis_core.common.foundation.ChassisArmorMaterial;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class PowerArmorMaterials {

    public static ChassisArmorMaterial RAIDER = new ChassisArmorMaterial(
            "raider", 150, new int[]{1, 4, 2, 2}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(ModItems.SCRAP.get()));

    public static ChassisArmorMaterial EXCAVATOR = new ChassisArmorMaterial(
            "excavator", 230, new int[]{2, 5, 3, 3}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial T45 = new ChassisArmorMaterial(
            "t45", 145, new int[]{3, 8, 6, 6}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial T51 = new ChassisArmorMaterial(
            "t51", 175, new int[]{4, 9, 7, 7}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial T60 = new ChassisArmorMaterial(
            "t60", 200, new int[]{5, 10, 8, 8}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial X01 = new ChassisArmorMaterial(
            "x01", 310, new int[]{7, 14, 10, 10}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial X02 = new ChassisArmorMaterial(
            "x02", 365, new int[]{8, 14, 12, 12}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));

    public static ChassisArmorMaterial X02_CRYO = new ChassisArmorMaterial(
            "x02_cryo", 365, new int[]{8, 15, 11, 11}, 3,9,
            SoundEvents.ARMOR_EQUIP_IRON, 0.0F,
            () -> Ingredient.of(Items.IRON_INGOT));
}
