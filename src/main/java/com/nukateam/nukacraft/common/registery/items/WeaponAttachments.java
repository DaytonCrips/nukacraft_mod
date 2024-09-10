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
            () -> new BarrelItem(Barrel.create(8.0F, GunModifiers.SILENCED, GunModifiers.REDUCED_DAMAGE), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_COMPENSATOR = ITEMS.register("pistol_compensator",
            () -> new BarrelItem(Barrel.create(8.0F, GunModifiers.SILENCED, GunModifiers.REDUCED_DAMAGE), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_FLAME_HIDER = ITEMS.register("pistol_flame_hider",
            () -> new BarrelItem(Barrel.create(8.0F, GunModifiers.SILENCED, GunModifiers.REDUCED_DAMAGE), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_HEAVY_BARREL = ITEMS.register("pistol_heavy_barrel",
            () -> new BarrelItem(Barrel.create(8.0F, GunModifiers.SILENCED, GunModifiers.REDUCED_DAMAGE), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_LONG_BARREL = ITEMS.register("pistol_long_barrel",
            () -> new BarrelItem(Barrel.create(8.0F, GunModifiers.SILENCED, GunModifiers.REDUCED_DAMAGE), new Item.Properties().stacksTo(1)));

    /* Stock Attachments */
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_LIGHT_STOCK = ITEMS.register("pistol_light_stock",
            () -> new StockItem(Stock.create(GunModifiers.BETTER_CONTROL), new Item.Properties().stacksTo(1), false));
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_TACTICAL_STOCK = ITEMS.register("pistol_tactical_stock",
            () -> new StockItem(Stock.create(GunModifiers.STABILISED), new Item.Properties().stacksTo(1), false));
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_WEIGHTED_STOCK = ITEMS.register("pistol_weighted_stock",
            () -> new StockItem(Stock.create(GunModifiers.SUPER_STABILISED), new Item.Properties().stacksTo(1)));

    /* Under Barrel Attachments */
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_SPECIALISED_GRIP = ITEMS.register("pistol_specialised_grip",
            () -> new UnderBarrelItem(UnderBarrel.create(GunModifiers.REDUCED_RECOIL), new Item.Properties().stacksTo(1)));
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_TACTICAL_GRIP = ITEMS.register("pistol_tactical_grip",
            () -> new StockItem(Stock.create(GunModifiers.STABILISED), new Item.Properties().stacksTo(1), false));
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_WEIGHTED_GRIP = ITEMS.register("pistol_weighted_grip",
            () -> new StockItem(Stock.create(GunModifiers.SUPER_STABILISED), new Item.Properties().stacksTo(1)));
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_LIGHT_GRIP = ITEMS.register("pistol_light_grip",
            () -> new UnderBarrelItem(UnderBarrel.create(GunModifiers.LIGHT_RECOIL), new Item.Properties().stacksTo(1)));

    /* Magazine Attachments*/
    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_EXTENDED_MAGAZINE = ITEMS.register("pistol_extended_magazine",
            () -> new MagazineItem(Magazine.create(30, GunModifiers.EXTENDED_MAG), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_HUGE_MAGAZINE = ITEMS.register("pistol_huge_magazine",
            () -> new MagazineItem(Magazine.create(60, GunModifiers.SLOWER_ADS, GunModifiers.HUGE_MAG), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_DRUM_MAGAZINE = ITEMS.register("pistol_drum_magazine",
            () -> new MagazineItem(Magazine.create(60, GunModifiers.SLOWER_ADS, GunModifiers.DRUM_MAG), new Item.Properties().stacksTo(1)));

    @DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_QUICK_MAGAZINE = ITEMS.register("pistol_quick_magazine",
            () -> new MagazineItem(Magazine.create(60, GunModifiers.SLOWER_ADS, GunModifiers.QUICK_MAG), new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
