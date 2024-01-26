package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.items.armor.*;
import com.nukateam.nukacraft.common.registery.ModItemTabs;
import com.nukateam.nukacraft.common.foundation.materials.ModArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModArmorItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    //Armor
    public static final RegistryObject<Item> WOOD_HELMET = ITEMS.register("wood_helmet",
            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.HEAD, "oak",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> WOOD_BODY = ITEMS.register("wood_body",
            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.CHEST, "oak",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> WOOD_LEGGINS = ITEMS.register("wood_leggins",
            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.LEGS, "oak",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> WOOD_BOOTS = ITEMS.register("wood_boots",
            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.FEET, "oak",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//
//    public static final RegistryObject<Item> WOOD2_HELMET = ITEMS.register("wood2_helmet",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.HEAD, "dark_oak",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD2_BODY = ITEMS.register("wood2_body",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.CHEST, "dark_oak",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD2_LEGGINS = ITEMS.register("wood2_leggins",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.LEGS, "dark_oak",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD2_BOOTS = ITEMS.register("wood2_boots",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.FEET, "dark_oak",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//
//    public static final RegistryObject<Item> WOOD3_HELMET = ITEMS.register("wood3_helmet",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.HEAD, "spruce",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD3_BODY = ITEMS.register("wood3_body",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.CHEST, "spruce",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD3_LEGGINS = ITEMS.register("wood3_leggins",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.LEGS, "spruce",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD3_BOOTS = ITEMS.register("wood3_boots",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.FEET, "spruce",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//
//    public static final RegistryObject<Item> WOOD4_HELMET = ITEMS.register("wood4_helmet",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.HEAD, "birch",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD4_BODY = ITEMS.register("wood4_body",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.CHEST, "birch",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD4_LEGGINS = ITEMS.register("wood4_leggins",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.LEGS, "birch",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD4_BOOTS = ITEMS.register("wood4_boots",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.FEET, "birch",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//
//    public static final RegistryObject<Item> WOOD5_HELMET = ITEMS.register("wood5_helmet",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.HEAD, "jungle",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD5_BODY = ITEMS.register("wood5_body",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.CHEST, "jungle",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD5_LEGGINS = ITEMS.register("wood5_leggins",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.LEGS, "jungle",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD5_BOOTS = ITEMS.register("wood5_boots",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.FEET, "jungle",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//
//    public static final RegistryObject<Item> WOOD6_HELMET = ITEMS.register("wood6_helmet",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.HEAD, "acacia",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD6_BODY = ITEMS.register("wood6_body",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.CHEST, "acacia",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD6_LEGGINS = ITEMS.register("wood6_leggins",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.LEGS, "acacia",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD6_BOOTS = ITEMS.register("wood6_boots",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.FEET, "acacia",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//
//    public static final RegistryObject<Item> WOOD7_HELMET = ITEMS.register("wood7_helmet",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.HEAD, "crimson",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD7_BODY = ITEMS.register("wood7_body",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.CHEST, "crimson",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD7_LEGGINS = ITEMS.register("wood7_leggins",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.LEGS, "crimson",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD7_BOOTS = ITEMS.register("wood7_boots",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.FEET, "crimson",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//
//    public static final RegistryObject<Item> WOOD8_HELMET = ITEMS.register("wood8_helmet",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.HEAD, "warped",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD8_BODY = ITEMS.register("wood8_body",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.CHEST, "warped",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD8_LEGGINS = ITEMS.register("wood8_leggins",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.LEGS, "warped",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
//    public static final RegistryObject<Item> WOOD8_BOOTS = ITEMS.register("wood8_boots",
//            () -> new WoodenArmorItem(ModArmorMaterials.WOOD, EquipmentSlot.FEET, "warped",
//                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));

    public static final RegistryObject<Item> LEATHER_HELMET = ITEMS.register("lether_helmet",
            () -> new LeatherArmorItem(ModArmorMaterials.HARDLEATHER, EquipmentSlot.HEAD, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> LEATHER_BODY = ITEMS.register("lether_body",
            () -> new LeatherArmorItem(ModArmorMaterials.HARDLEATHER, EquipmentSlot.CHEST, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> LEATHER_LEGGINS = ITEMS.register("lether_leggins",
            () -> new LeatherArmorItem(ModArmorMaterials.HARDLEATHER, EquipmentSlot.LEGS, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> LEATHER_BOOTS = ITEMS.register("lether_boots",
            () -> new LeatherArmorItem(ModArmorMaterials.HARDLEATHER, EquipmentSlot.FEET, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));

    public static final RegistryObject<Item> RAIDER_HELMET = ITEMS.register("raiders_helmet",
            () -> new RaiderArmorItem(ModArmorMaterials.HARDLEATHER, EquipmentSlot.HEAD, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> RAIDER_BODY = ITEMS.register("raiders_body",
            () -> new RaiderArmorItem(ModArmorMaterials.HARDLEATHER, EquipmentSlot.CHEST, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> RAIDER_LEGGINS = ITEMS.register("raiders_leggins",
            () -> new RaiderArmorItem(ModArmorMaterials.HARDLEATHER, EquipmentSlot.LEGS, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> RAIDER_BOOTS = ITEMS.register("raiders_boots",
            () -> new RaiderArmorItem(ModArmorMaterials.HARDLEATHER, EquipmentSlot.FEET, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));


    public static final RegistryObject<Item> METAL_HELMET = ITEMS.register("metalhelmet",
            () -> new MetalArmorItem(ModArmorMaterials.METAL, EquipmentSlot.HEAD, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> METAL_BODY = ITEMS.register("metalchest",
            () -> new MetalArmorItem(ModArmorMaterials.METAL, EquipmentSlot.CHEST, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> METAL_LEGGINS = ITEMS.register("metalleggins",
            () -> new MetalArmorItem(ModArmorMaterials.METAL, EquipmentSlot.LEGS, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> METAL_BOOTS = ITEMS.register("metalboots",
            () -> new MetalArmorItem(ModArmorMaterials.METAL, EquipmentSlot.FEET, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));

    public static final RegistryObject<Item> TRAP_HELMET = ITEMS.register("traphelmet",
            () -> new TrapperArmorItem(ModArmorMaterials.METAL, EquipmentSlot.HEAD, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> TRAP_BODY = ITEMS.register("trapchest",
            () -> new TrapperArmorItem(ModArmorMaterials.METAL, EquipmentSlot.CHEST, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> TRAP_LEGGINS = ITEMS.register("trapleggins",
            () -> new TrapperArmorItem(ModArmorMaterials.METAL, EquipmentSlot.LEGS, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static final RegistryObject<Item> TRAP_BOOTS = ITEMS.register("trapboots",
            () -> new TrapperArmorItem(ModArmorMaterials.TRAPPER, EquipmentSlot.FEET, "default",
                    new Item.Properties().tab(ModItemTabs.NUKA_ARMOR)));
    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
