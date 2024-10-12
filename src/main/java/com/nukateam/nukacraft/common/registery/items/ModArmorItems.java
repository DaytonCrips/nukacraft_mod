package com.nukateam.nukacraft.common.registery.items;

import com.mojang.datafixers.util.Pair;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.annotation.DataGen;
import com.nukateam.nukacraft.common.data.utils.ArmorStorage;
import com.nukateam.nukacraft.common.foundation.items.armor.GeoArmorItem;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import com.nukateam.nukacraft.common.foundation.materials.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;

public class ModArmorItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    @DataGen(path = "armor")
    public static final ArmorStorage WOODEN_SET = registerArmorSet("wooden", ModArmorMaterials.WOOD);
    @DataGen(path = "armor")
    public static final ArmorStorage LEATHER_SET = registerArmorSet("leather", ModArmorMaterials.HARDLEATHER);
    @DataGen(path = "armor")
    public static final ArmorStorage VAULT_DWELLER_SET = registerClothSet("vault_dweller", ModArmorMaterials.CLOTH);
    @DataGen(path = "armor")
    public static final ArmorStorage VAULT_SCIENTIST_SET = registerClothSetWithoutBoots("vault_science", ModArmorMaterials.CLOTH);
    @DataGen(path = "armor")
    public static final ArmorStorage RAIDER_SET = registerArmorSet("raiders", ModArmorMaterials.RAIDER);
    @DataGen(path = "armor")
    public static final ArmorStorage METAL_SET = registerArmorSet("metal", ModArmorMaterials.METAL);
    @DataGen(path = "armor")
    public static final ArmorStorage TRAPPER_SET = registerArmorSet("trapper", ModArmorMaterials.TRAPPER);
    @DataGen(path = "armor")
    public static final ArmorStorage SCOUT_SET = registerArmorSet("scout", ModArmorMaterials.SCOUT);
    @DataGen(path = "armor")
    public static final ArmorStorage VAULT_SECURITY_SET = registerArmorSet("vault_security", ModArmorMaterials.SCOUT);
    @DataGen(path = "armor")
    public static final ArmorStorage COMBAT_SET = registerArmorSet("combat", ModArmorMaterials.COMBAT);
    @DataGen(path = "armor")
    public static final ArmorStorage ROBOT_SET = registerArmorSet("robot", ModArmorMaterials.ROBOT);

    public static final RegistryObject<Item> PIP_BOY_D = ITEMS.register("pipboy",
            () -> new PipBoyItem("default", new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static ArmorStorage registerArmorSet(String name, ArmorMaterial material) {
        var armorSet = new ArmorStorage();
        var armorSlots = List.of(
                Pair.of(ArmorItem.Type.HELMET, "helmet"),
                Pair.of(ArmorItem.Type.CHESTPLATE, "chest"),
                Pair.of(ArmorItem.Type.LEGGINGS, "leggins"),
                    Pair.of(ArmorItem.Type.BOOTS, "boots"));

        for (var slot : armorSlots) {
            var item = registerArmor(name + "_" + slot.getSecond(), name, material, slot.getFirst());
            armorSet.put(slot.getFirst(), item);
        }

        return armorSet;
    }

    private static ArmorStorage registerClothSet(String name, ArmorMaterial material) {
        var armorSet = new ArmorStorage();
        var armorSlots = List.of(
                Pair.of(ArmorItem.Type.CHESTPLATE, "chest"),
                Pair.of(ArmorItem.Type.LEGGINGS, "leggins"),
                Pair.of(ArmorItem.Type.BOOTS, "boots"));

        for (var slot : armorSlots) {
            var item = registerArmor(name + "_" + slot.getSecond(), name, material, slot.getFirst());
            armorSet.put(slot.getFirst(), item);
        }

        return armorSet;
    }

    private static ArmorStorage registerClothSetWithoutBoots(String name, ArmorMaterial material) {
        var armorSet = new ArmorStorage();
        var armorSlots = List.of(
                Pair.of(ArmorItem.Type.CHESTPLATE, "chest"),
                Pair.of(ArmorItem.Type.LEGGINGS, "leggins"));

        for (var slot : armorSlots) {
            var item = registerArmor(name + "_" + slot.getSecond(), name, material, slot.getFirst());
            armorSet.put(slot.getFirst(), item);
        }

        return armorSet;
    }

    private static RegistryObject<Item> registerArmor(String registryName, String name, ArmorMaterial material, ArmorItem.Type slot) {
        return ITEMS.register(registryName, () -> new GeoArmorItem(material, slot, name,
                new Item.Properties()));
    }
}
