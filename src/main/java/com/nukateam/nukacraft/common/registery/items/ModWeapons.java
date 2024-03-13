package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.gunscore.common.foundation.item.*;
import com.nukateam.nukacraft.*;
import com.nukateam.nukacraft.common.foundation.items.guns.BaseGrenadeItem;
import com.nukateam.nukacraft.common.registery.ModItemTabs;
import com.nukateam.nukacraft.common.foundation.items.guns.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.registries.*;

public class ModWeapons {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    ///GUNS
    public static final RegistryObject<GunItem> PISTOL10MM = ITEMS.register("pistol10mm", () -> new PistolGun(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<GunItem> PIPE_PISTOL = ITEMS.register("pipepistol", () -> new PistolGun(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<GunItem> CLASSIC10MM = ITEMS.register("classic10mm", () -> new PistolGun(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<GunItem> SCOUT10MM = ITEMS.register("scout10mm", () -> new PistolGun(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    //public static final RegistryObject<GunItem> CLASSIC10MM_ZAP = ITEMS.register("classic10mm_zapaway", () -> new PistolGun(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<GunItem> PIPEREVOLVER = ITEMS.register("piperevolver", () -> new PistolGun(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<GunItem> FATMAN = ITEMS.register("fatman", () -> new FatmanGun(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<GunItem> MINIGUN = ITEMS.register("minigun", () -> new MinigunGun(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<GunItem> POWDERGUN = ITEMS.register("powdergun", () -> new ShotGun(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));

    public static final RegistryObject<GunItem> TESLA_RIFLE = ITEMS.register("tesla_rifle", () -> new TeslaGun(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));

    ///MAGAZINES
   // public static final RegistryObject<Item> MAGAZINE1  = ITEMS.register("magazine_t1", () -> new MagazineItem(UnderBarrel.create(ExtraGunModifiers.MAGAZINES), new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(ModItemTabs.NUKA_WEAPONS)));
   // public static final RegistryObject<Item> MAGAZINE2  = ITEMS.register("magazine_t2", () -> new MagazineItem(UnderBarrel.create(ExtraGunModifiers.MAGAZINES), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).tab(ModItemTabs.NUKA_WEAPONS)));
   // public static final RegistryObject<Item> MAGAZINE3  = ITEMS.register("magazine_t3", () -> new MagazineItem(UnderBarrel.create(ExtraGunModifiers.MAGAZINES), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).tab(ModItemTabs.NUKA_WEAPONS)));

    //SCOPES
//    public static final RegistryObject<Item> LONG_SCOPE = ITEMS.register("long_scope", () -> new ScopeItem(Attachments.LONG_SCOPE, new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_WEAPONS)));

//    public static final RegistryObject<Item> SILENCER  = ITEMS.register("army_silencer", () -> new BarrelItem(Barrel.create(2, ExtraGunModifiers.ARMY_SILENCER), new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(ModItemTabs.NUKA_WEAPONS)));
//    public static final RegistryObject<Item> OLD_SCOPE = ITEMS.register("old_scope", () -> new ScopeItem(Scopes.OLD_SCOPE, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).tab(ModItemTabs.NUKA_WEAPONS)));
   // public static final RegistryObject<Item> HUNTING_SCOPE = ITEMS.register("hunting_scope", () -> new ScopeItem(Scopes.HUNTING_SCOPE, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(ModItemTabs.NUKA_WEAPONS)));
//    public static final RegistryObject<Item> HANDMADE_COLLIMATOR = ITEMS.register("handmade_collimator", () -> new ScopeItem(Scopes.HANDMADE_COLL, new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_WEAPONS)));
//    public static final RegistryObject<Item> HANDMADE_SCOPE = ITEMS.register("handmade_scope", () -> new ScopeItem(Scopes.HUNTING_SCOPE, new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_WEAPONS)));
//
//    public static final RegistryObject<Item> HANDMADE_STOCK  = ITEMS.register("handmade_stock", () -> new StockItem(Stock.create(ExtraGunModifiers.HANDMADE_STOCK), new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_WEAPONS)));
//
//    public static final RegistryObject<Item> OLD_SILENCER  = ITEMS.register("old_silencer", () -> new BarrelItem(Barrel.create(2, ExtraGunModifiers.OLD_SILENCER), new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(ModItemTabs.NUKA_WEAPONS)));
//    public static final RegistryObject<Item> HANDMADE_FLASHER  = ITEMS.register("handmade_flashhider", () -> new BarrelItem(Barrel.create(2, ExtraGunModifiers.HANDMADE_FLASHER), new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_WEAPONS)));


    public static final RegistryObject<Item> MISSILE = ITEMS.register("missile", () -> new AmmoItem(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> GRENADE = ITEMS.register("grenade", () -> new GrenadeItem(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS), 20 * 4));
    public static final RegistryObject<Item> BASEBALL_GRENADE = ITEMS.register("baseball_grenade", () -> new BaseGrenadeItem(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS), 20 * 4));
    public static final RegistryObject<Item> STUN_GRENADE = ITEMS.register("stun_grenade", () -> new StunGrenadeItem(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS), 72000));

    //Rounds
    public static final RegistryObject<Item> ROUND10MM = ModItems.ITEMS.register("round10mm",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> ROUND38 = ModItems.ITEMS.register("round38",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> STEELBALLS = ModItems.ITEMS.register("steel_ball",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> ROUND45 = ModItems.ITEMS.register("round45",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> ROUND5MM = ModItems.ITEMS.register("round5mm",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> ROUND44 = ModItems.ITEMS.register("round44",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> ROUND50 = ModItems.ITEMS.register("round50",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> ROUND380 = ModItems.ITEMS.register("round380",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> ROUND556 = ModItems.ITEMS.register("round556",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> SHOTSHELL = ModItems.ITEMS.register("shotshell",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> ROUND127 = ModItems.ITEMS.register("round127",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> ROUND22 = ModItems.ITEMS.register("round22",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> MININUKE = ModItems.ITEMS.register("mini_nuke",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));

    public static final RegistryObject<Item> FUSION_CELL = ModItems.ITEMS.register("fusion_cell",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
