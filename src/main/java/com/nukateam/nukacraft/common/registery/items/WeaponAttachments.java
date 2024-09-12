package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.example.common.registery.Attachments;
import com.nukateam.ntgl.common.foundation.item.*;
import com.nukateam.ntgl.common.foundation.item.attachment.impl.Barrel;
import com.nukateam.ntgl.common.foundation.item.attachment.impl.Magazine;
import com.nukateam.ntgl.common.foundation.item.attachment.impl.Stock;
import com.nukateam.ntgl.common.foundation.item.attachment.impl.UnderBarrel;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.annotation.DataGen;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WeaponAttachments {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    /* Scope Attachments */
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_COLLIMATOR_SIGHT = ITEMS.register("pistol_collimator_sight",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_HOLOGRAPHIC_SIGHT = ITEMS.register("pistol_holographic_sight",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_HUNTING_OPTICS = ITEMS.register("pistol_hunting_optics",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_IRON_SIGHT = ITEMS.register("pistol_iron_sight",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_SCOUT_SIGHT = ITEMS.register("pistol_scout_sight",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    /* Barrel Attachments */
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_SILENCER = ITEMS.register("pistol_silencer",
            () -> new BarrelItem(Barrel.create(8.0F, GunModifiers.FLASH_HIDER, GunModifiers.SILENCED, GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_DAMAGE_lvl1, GunModifiers.REDUCED_DISTANCE_LVL3), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_COMPENSATOR = ITEMS.register("pistol_compensator",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.REDUCED_RECOIL_LVL2, GunModifiers.REDUCED_DAMAGE_lvl2), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_FLAME_HIDER = ITEMS.register("pistol_flame_hider",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.FLASH_HIDER, GunModifiers.REDUCED_DAMAGE_lvl1), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_HEAVY_BARREL = ITEMS.register("pistol_heavy_barrel",
            () -> new BarrelItem(Barrel.create(4.0F, GunModifiers.EXTEND_RECOIL_LVL1, GunModifiers.EXTEND_DAMAGE_lvl1, GunModifiers.EXTEND_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_LONG_BARREL = ITEMS.register("pistol_long_barrel",
            () -> new BarrelItem(Barrel.create(4.0F, GunModifiers.EXTEND_RECOIL_LVL1, GunModifiers.EXTEND_DAMAGE_lvl2, GunModifiers.EXTEND_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));



    /* Under Barrel Attachments */
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_SPECIALISED_GRIP = ITEMS.register("pistol_specialised_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL2, GunModifiers.REDUCED_KICKING_LVL1), new Item.Properties().stacksTo(1)));
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_TACTICAL_GRIP = ITEMS.register("pistol_tactical_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_KICKING_LVL3), new Item.Properties().stacksTo(1), false));
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_WEIGHTED_GRIP = ITEMS.register("pistol_weighted_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL3, GunModifiers.REDUCED_KICKING_LVL2), new Item.Properties().stacksTo(1)));


    /* Magazine Attachments*/
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_EXTENDED_MAGAZINE = ITEMS.register("pistol_extended_magazine",
            () -> new MagazineItem(Magazine.create(30, GunModifiers.EXTENDED_MAG), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_HUGE_MAGAZINE = ITEMS.register("pistol_huge_magazine",
            () -> new MagazineItem(Magazine.create(60, GunModifiers.HUGE_MAG), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_DRUM_MAGAZINE = ITEMS.register("pistol_drum_magazine",
            () -> new MagazineItem(Magazine.create(60, GunModifiers.DRUM_MAG), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_QUICK_MAGAZINE = ITEMS.register("pistol_quick_magazine",
            () -> new MagazineItem(Magazine.create(60, GunModifiers.QUICK_MAG, GunModifiers.EXTEND_KICKING_LVL3), new Item.Properties().stacksTo(1)));







    /* Handmade Grip Attachmentы */

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> HANDMADE_TACTICAL_GRIP = ITEMS.register("handmade_tactical_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL1,GunModifiers.TRANSFORM_CARBINE, GunModifiers.REDUCED_KICKING_LVL3), new Item.Properties().stacksTo(1), false));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> HANDMADE_PISTOL_GRIP = ITEMS.register("handmade_pistol_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_KICKING_LVL1), new Item.Properties().stacksTo(1)));
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> HANDMADE_LONG_GRIP = ITEMS.register("handmade_long_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL3,GunModifiers.TRANSFORM_CARBINE, GunModifiers.REDUCED_KICKING_LVL1, GunModifiers.REDUCED_KICKING_LVL2), new Item.Properties().stacksTo(1)));
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> HANDMADE_CARBINE_GRIP = ITEMS.register("handmade_carbine_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL3,GunModifiers.TRANSFORM_CARBINE, GunModifiers.REDUCED_KICKING_LVL1, GunModifiers.REDUCED_KICKING_LVL3), new Item.Properties().stacksTo(1)));






    /* Handmade Barrel Attachments */
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> HANDMADE_SILENCER = ITEMS.register("handmade_silencer",
            () -> new BarrelItem(Barrel.create(8.0F, GunModifiers.FLASH_HIDER, GunModifiers.SILENCED, GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_DAMAGE_lvl1, GunModifiers.REDUCED_DISTANCE_LVL3), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> HANDMADE_COMPENSATOR = ITEMS.register("handmade_compensator",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.REDUCED_RECOIL_LVL2, GunModifiers.REDUCED_DAMAGE_lvl2), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> HANDMADE_FLAME_HIDER = ITEMS.register("handmade_flame_hider",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.FLASH_HIDER, GunModifiers.REDUCED_DAMAGE_lvl1), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> HANDMADE_HEAVY_BARREL = ITEMS.register("handmade_heavy_barrel",
            () -> new BarrelItem(Barrel.create(4.0F, GunModifiers.EXTEND_RECOIL_LVL2, GunModifiers.EXTEND_DAMAGE_lvl1, GunModifiers.EXTEND_DISTANCE_LVL2, GunModifiers.EXTEND_KICKING_LVL3), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> HANDMADE_LONG_BARREL = ITEMS.register("handmade_long_barrel",
            () -> new BarrelItem(Barrel.create(4.0F, GunModifiers.EXTEND_RECOIL_LVL2, GunModifiers.EXTEND_DAMAGE_lvl2, GunModifiers.EXTEND_DISTANCE_LVL2, GunModifiers.EXTEND_KICKING_LVL2), new Item.Properties().stacksTo(1)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
