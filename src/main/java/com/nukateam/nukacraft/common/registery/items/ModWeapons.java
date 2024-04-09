package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.ntgl.common.foundation.item.*;
import com.nukateam.nukacraft.*;
import com.nukateam.nukacraft.common.foundation.items.frame.FusionCoreItem;
import com.nukateam.nukacraft.common.foundation.items.guns.BaseGrenadeItem;
import com.nukateam.nukacraft.common.registery.ModItemTabs;
import com.nukateam.nukacraft.common.foundation.items.guns.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.registries.*;

import static com.nukateam.nukacraft.common.registery.ModItemTabs.NUKA_WEAPONS;

public class ModWeapons {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    ///GUNS
    public static final RegistryObject<GunItem> PISTOL10MM = registerGun("pistol10mm");
    public static final RegistryObject<GunItem> PIPE_PISTOL = registerGun("pipepistol");
    public static final RegistryObject<GunItem> CLASSIC10MM = registerGun("classic10mm");
    public static final RegistryObject<GunItem> SCOUT10MM = registerGun("scout10mm");
    //public static final RegistryObject<GunItem> CLASSIC10MM_ZAP = registerGun("classic10mm_zapaway", () -> new PistolGun(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<GunItem> PIPEREVOLVER = registerGun("piperevolver");
    public static final RegistryObject<GunItem> FATMAN = registerGun("fatman");
    public static final RegistryObject<GunItem> MINIGUN = registerGun("minigun");
    public static final RegistryObject<GunItem> GATLING_LASER = registerGun("gatling_laser");
    public static final RegistryObject<GunItem> POWDERGUN = registerGun("powdergun");
    public static final RegistryObject<GunItem> SHOTGUN = registerGun("shotgun");

    public static final RegistryObject<GunItem> TESLA_RIFLE = ITEMS.register("tesla_rifle", () -> new TeslaGun(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<GunItem> LASER_RIFLE = registerGun("laser_rifle");
    public static final RegistryObject<GunItem> LASER_PISTOL = registerGun("laser_pistol");
    public static final RegistryObject<GunItem> FLAMER = registerGun("flamer");
    public static final RegistryObject<GunItem> HANDMADE_FLAMER = registerGun("handmade_flamer");

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
    public static final RegistryObject<Item> ROUND10MM = registerAmmo("round10mm");
    public static final RegistryObject<Item> ROUND38 = registerAmmo("round38");
    public static final RegistryObject<Item> STEELBALLS = registerAmmo("steel_ball");
    public static final RegistryObject<Item> ROUND45 = registerAmmo("round45");
    public static final RegistryObject<Item> ROUND5MM = registerAmmo("round5mm");
    public static final RegistryObject<Item> ROUND44 = registerAmmo("round44");
    public static final RegistryObject<Item> ROUND50 = registerAmmo("round50");
    public static final RegistryObject<Item> ROUND380 = registerAmmo("round380");
    public static final RegistryObject<Item> ROUND556 = registerAmmo("round556");
    public static final RegistryObject<Item> SHOTSHELL = registerAmmo("shotshell");
    public static final RegistryObject<Item> ROUND127 = registerAmmo("round127");
    public static final RegistryObject<Item> ROUND22 = registerAmmo("round22");
    public static final RegistryObject<Item> MININUKE = registerAmmo("mini_nuke");
    public static final RegistryObject<Item> FUSION_CELL = registerAmmo("fusion_cell");
    public static final RegistryObject<Item> FUEL = ModItems.ITEMS.register("fuel",
            () -> new AmmoItem(new Item.Properties()
                    .durability(1000)
                    .tab(ModItemTabs.NUKA_WEAPONS)));

    public static final RegistryObject<Item> FUSION_CORE = ITEMS.register("fusion_core",
            () -> new FusionCoreItem(new Item.Properties()
                    .durability(500)
                    .tab(NUKA_WEAPONS)));

    public static RegistryObject<GunItem> registerGun(String name) {
        return ITEMS.register(name, () -> new GunItem(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    }

    public static RegistryObject<Item> registerAmmo(String name) {
        return ITEMS.register(name, () -> new AmmoItem(new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    }

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
