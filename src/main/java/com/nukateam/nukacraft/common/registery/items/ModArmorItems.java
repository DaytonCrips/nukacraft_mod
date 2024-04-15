package com.nukateam.nukacraft.common.registery.items;

import com.ibm.icu.impl.Pair;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.items.armor.*;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import com.nukateam.nukacraft.common.foundation.materials.ModArmorMaterials;
import com.nukateam.nukacraft.common.registery.ModItemTabs;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ModArmorItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    public static final HashMap<EquipmentSlot, RegistryObject<Item>> WOODEN_SET = registerArmorSet("wooden", ModArmorMaterials.WOOD);
    public static final HashMap<EquipmentSlot, RegistryObject<Item>> LEATHER_SET = registerArmorSet("leather", ModArmorMaterials.HARDLEATHER);
    public static final HashMap<EquipmentSlot, RegistryObject<Item>> RAIDER_SET = registerArmorSet("raiders", ModArmorMaterials.RAIDER);
    public static final HashMap<EquipmentSlot, RegistryObject<Item>> METAL_SET = registerArmorSet("metal", ModArmorMaterials.METAL);
    public static final HashMap<EquipmentSlot, RegistryObject<Item>> TRAPPER_SET = registerArmorSet("trapper", ModArmorMaterials.TRAPPER);

    public static final RegistryObject<Item> PIP_BOY_D = ITEMS.register("pipboy",
            () -> new PipBoyItem("default", new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static HashMap<EquipmentSlot, RegistryObject<Item>> registerArmorSet(String name, ArmorMaterial material){
        var armorSet = new HashMap<EquipmentSlot, RegistryObject<Item>>();
        var armorSlots = List.of(
                Pair.of(EquipmentSlot.HEAD , "helmet"),
                Pair.of(EquipmentSlot.CHEST, "chest"),
                Pair.of(EquipmentSlot.LEGS , "leggins"),
                Pair.of(EquipmentSlot.FEET , "boots"));

        for (var slot: armorSlots) {
            var item = registerArmor(name + "_" + slot.second, name, material, slot.first);
            armorSet.put(slot.first, item);
        }

        return armorSet;
    }

    private static RegistryObject<Item> registerArmor(String registryName, String name, ArmorMaterial material, EquipmentSlot slot){
        return ITEMS.register(registryName, () -> new GeoArmorItem(material, slot, name,
                        new Item.Properties()));
    }
}
