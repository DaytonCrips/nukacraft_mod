package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.ntgl.common.foundation.entity.StunGrenadeEntity;
import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.ntgl.common.foundation.init.ModSounds;
import com.nukateam.ntgl.common.foundation.item.AmmoItem;
import com.nukateam.ntgl.common.foundation.item.GrenadeItem;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.annotation.DataGen;
import com.nukateam.nukacraft.common.foundation.ModTiers;
import com.nukateam.nukacraft.common.foundation.entities.grenades.*;
import com.nukateam.nukacraft.common.foundation.items.frame.FusionCoreItem;
import com.nukateam.nukacraft.common.foundation.items.guns.*;
import com.nukateam.nukacraft.common.foundation.items.misc.SimpleMeleeWeapon;
import com.nukateam.nukacraft.common.foundation.items.misc.SpearItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModWeapons {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    ///MELEE
    public static final RegistryObject<Item> CLEAVER = ITEMS.register("cleaver",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 1, -2,
                    new Item.Properties()));

    public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench",
            () -> new SimpleMeleeWeapon(ModTiers.SCRAP, 1, -1,
                    new Item.Properties()));

    public static final RegistryObject<Item> SHIV = ITEMS.register("shiv",
            () -> new SimpleMeleeWeapon(ModTiers.TRASH, 1, -3,
                    new Item.Properties()));

    public static final RegistryObject<Item> BOXER = ITEMS.register("boxer",
            () -> new SimpleMeleeWeapon(ModTiers.TRASH, 2, -3,
                    new Item.Properties()));

    public static final RegistryObject<Item> ROLLPIN = ITEMS.register("rollpin",
            () -> new SimpleMeleeWeapon(ModTiers.TRASH, 0, -1,
                    new Item.Properties()));

    public static final RegistryObject<Item> CANE = ITEMS.register("cane",
            () -> new SimpleMeleeWeapon(ModTiers.TRASH, 0, -2,
                    new Item.Properties()));

    public static final RegistryObject<Item> BASEBALL_BAT = ITEMS.register("baseball_bat",
            () -> new SimpleMeleeWeapon(ModTiers.TRASH, 3, -1,
                    new Item.Properties()));

    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 3, 0,
                    new Item.Properties()));
    public static final RegistryObject<Item> JETHAMMER = ITEMS.register("jethammer",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 6, -3,
                    new Item.Properties()));
    public static final RegistryObject<Item> ATOM = ITEMS.register("atom",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 9, -3,
                    new Item.Properties()));
    public static final RegistryObject<Item> SITO_BAT = ITEMS.register("cito_bat",
            () -> new SimpleMeleeWeapon(ModTiers.TRASH, 3, -1,
                    new Item.Properties()));
    public static final RegistryObject<Item> SEC_BATON = ITEMS.register("security_baton",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 1, 0,
                    new Item.Properties()));
//    public static final RegistryObject<Item> SPEAR = ITEMS.register("spear",
//            () -> new SpearItem((new Item.Properties()).durability(250)));

    public static final RegistryObject<Item> POOLCUE = ITEMS.register("poolcue",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 0, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> KOMI = ITEMS.register("komi",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, -1, -2,
                    new Item.Properties()));

    public static final RegistryObject<Item> COMBAT_KNIFE = ITEMS.register("combatknife",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 1, -2,
                    new Item.Properties()));

    public static final RegistryObject<Item> COSMIC_KNIFE = ITEMS.register("cosmicknife",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 0, -2,
                    new Item.Properties()));

    public static final RegistryObject<Item> COMBAT_PIPE = ITEMS.register("combatpipe",
            () -> new SimpleMeleeWeapon(ModTiers.SCRAP, 0, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> CROWBAR = ITEMS.register("crowbar",
            () -> new SimpleMeleeWeapon(ModTiers.SCRAP, 1, -1,
                    new Item.Properties()));

    public static final RegistryObject<Item> CRUSHER = ITEMS.register("crusher",
            () -> new SimpleMeleeWeapon(ModTiers.SCRAP, 3, -2,
                    new Item.Properties()));

    public static final RegistryObject<Item> GOLFDRIVER = ITEMS.register("golfdriver",
            () -> new SimpleMeleeWeapon(ModTiers.SCRAP, 0, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> RAZOR_BLADE = ITEMS.register("razorblade",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 1, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> HATCHET = ITEMS.register("hatchet",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 1, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> HANDMADE_SPEAR = ITEMS.register("handmade_spear",
            () -> new SpearItem(Tiers.IRON, 6, -3.2F,(new Item.Properties())));


    public static final RegistryObject<Item> FIRE_AXE = ITEMS.register("fireaxe",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 2, -3,
                    new Item.Properties()));

    public static final RegistryObject<Item> MACHETE = ITEMS.register("machete",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 4, -1,
                    new Item.Properties()));
    public static final RegistryObject<Item> LIBERATOR = ITEMS.register("liberator",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 5, 0,
                    new Item.Properties()));

    public static final RegistryObject<Item> KATANA = ITEMS.register("katana",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 8, -1,
                    new Item.Properties()));

    public static final RegistryObject<Item> NUKA_BREAK = ITEMS.register("nukabreak",
            () -> new SimpleMeleeWeapon(ModTiers.SCRAP, 3, -3,
                    new Item.Properties()));

    public static final RegistryObject<Item> PIPE_WRENCH = ITEMS.register("pipe_wrench",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 1, -1,
                    new Item.Properties()));

    ///GUNS
    public static final RegistryObject<GunItem> PISTOL10MM = registerGun("pistol10mm");
    public static final RegistryObject<GunItem> PIPE_PISTOL = registerGun("pipepistol");
    public static final RegistryObject<GunItem> CLASSIC10MM = registerGun("classic10mm");
    public static final RegistryObject<GunItem> SCOUT10MM = registerGun("scout10mm");
    //public static final RegistryObject<GunItem> CLASSIC10MM_ZAP = registerGun("classic10mm_zapaway", () -> new PistolGun(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<GunItem> PIPE_REVOLVER = registerGun("piperevolver");
    public static final RegistryObject<GunItem> FATMAN = registerGun("fatman");
    public static final RegistryObject<GunItem> MINIGUN = registerGun("minigun");
    public static final RegistryObject<GunItem> GATLING_LASER = registerGun("gatling_laser");
    public static final RegistryObject<GunItem> POWDERGUN = registerGun("powdergun");
    public static final RegistryObject<GunItem> SHOTGUN = registerGun("shotgun");

    public static final RegistryObject<GunItem> TESLA_RIFLE = ITEMS.register("tesla_rifle", () -> new TeslaGun(new Item.Properties()));
    public static final RegistryObject<GunItem> LASER_RIFLE = registerGun("laser_rifle");
    public static final RegistryObject<GunItem> LASER_PISTOL = registerGun("laser_pistol");
    public static final RegistryObject<GunItem> CLASSIC_LASER_PISTOL = registerGun("classic_laser_pistol");
    public static final RegistryObject<GunItem> FLAMER = registerGun("flamer");
    public static final RegistryObject<GunItem> HANDMADE_FLAMER = registerGun("handmade_flamer");

    ///MAGAZINES
    // public static final RegistryObject<Item> MAGAZINE1  = ITEMS.register("magazine_t1", () -> new MagazineItem(UnderBarrel.create(ExtraGunModifiers.MAGAZINES), new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    // public static final RegistryObject<Item> MAGAZINE2  = ITEMS.register("magazine_t2", () -> new MagazineItem(UnderBarrel.create(ExtraGunModifiers.MAGAZINES), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));
    // public static final RegistryObject<Item> MAGAZINE3  = ITEMS.register("magazine_t3", () -> new MagazineItem(UnderBarrel.create(ExtraGunModifiers.MAGAZINES), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC)));

    //SCOPES
//    public static final RegistryObject<Item> LONG_SCOPE = ITEMS.register("long_scope", () -> new ScopeItem(Attachments.LONG_SCOPE, new Item.Properties().stacksTo(1)));

//    public static final RegistryObject<Item> SILENCER  = ITEMS.register("army_silencer", () -> new BarrelItem(Barrel.create(2, ExtraGunModifiers.ARMY_SILENCER), new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
//    public static final RegistryObject<Item> OLD_SCOPE = ITEMS.register("old_scope", () -> new ScopeItem(Scopes.OLD_SCOPE, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
    // public static final RegistryObject<Item> HUNTING_SCOPE = ITEMS.register("hunting_scope", () -> new ScopeItem(Scopes.HUNTING_SCOPE, new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
//    public static final RegistryObject<Item> HANDMADE_COLLIMATOR = ITEMS.register("handmade_collimator", () -> new ScopeItem(Scopes.HANDMADE_COLL, new Item.Properties().stacksTo(1)));
//    public static final RegistryObject<Item> HANDMADE_SCOPE = ITEMS.register("handmade_scope", () -> new ScopeItem(Scopes.HUNTING_SCOPE, new Item.Properties().stacksTo(1)));
//
//    public static final RegistryObject<Item> HANDMADE_STOCK  = ITEMS.register("handmade_stock", () -> new StockItem(Stock.create(ExtraGunModifiers.HANDMADE_STOCK), new Item.Properties().stacksTo(1)));
//
//    public static final RegistryObject<Item> OLD_SILENCER  = ITEMS.register("old_silencer", () -> new BarrelItem(Barrel.create(2, ExtraGunModifiers.OLD_SILENCER), new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)));
//    public static final RegistryObject<Item> HANDMADE_FLASHER  = ITEMS.register("handmade_flashhider", () -> new BarrelItem(Barrel.create(2, ExtraGunModifiers.HANDMADE_FLASHER), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MISSILE = ITEMS.register("missile", () ->
            new AmmoItem(new Item.Properties()));

    public static final RegistryObject<Item> GRENADE = ITEMS.register("grenade", () ->
            new BaseGrenadeItem<>(new Item.Properties(), 20 * 4, ThrowableGrenadeEntity::new));

    public static final RegistryObject<Item> MIRV_GRENADE = ITEMS.register("grenade_mirv", () ->
            new BaseGrenadeItem<>(new Item.Properties(), 30 * 4, MirvGrenadeEntity::new));

    public static final RegistryObject<Item> HOLY_GRENADE = ITEMS.register("holy_grenade", () ->
            new BaseGrenadeItem<>(new Item.Properties(), 30 * 4, HolyGrenadeEntity::new, ModSounds.ITEM_GRENADE_PIN));

    public static final RegistryObject<Item> GRENADE_FIRE = ITEMS.register("incendiary_grenade", () ->
            new BaseGrenadeItem<>(new Item.Properties(), 25 * 4, FireGrenadeEntity::new));

    public static final RegistryObject<Item> GRENADE_FIRE_FLOATER = ITEMS.register("flame_floater_grenade", () ->
            new BaseGrenadeItem<>(new Item.Properties(), 25 * 4, FlameFloaterGrenadeEntity::new));

    public static final RegistryObject<Item> BASEBALL_GRENADE = ITEMS.register("baseball_grenade", () ->
            new BaseGrenadeItem<>(new Item.Properties(), 20 * 4, BaseballGrenadeEntity::new));

    public static final RegistryObject<Item> STUN_GRENADE = ITEMS.register("stun_grenade", () ->
            new BaseGrenadeItem<>(new Item.Properties(), 72000, StunGrenadeEntity::new));

    public static final RegistryObject<Item> MOLOTOV_COCKTAIL = ITEMS.register("molotov", () ->
            new BaseGrenadeItem<>(new Item.Properties(), 20 * 4, MolotovEntity::new, null));

    public static final RegistryObject<Item> MOLOTOV_COLA = ITEMS.register("molotov_cola", () ->
            new BaseGrenadeItem<>(new Item.Properties(), 20 * 4, MolotovColaEntity::new, null));

    public static final RegistryObject<Item> DYNAMITE_STICK = ITEMS.register("dynamite_stick", () ->
            new BaseGrenadeItem<>(new Item.Properties(), 20 * 4, DynamiteStickEntity::new, null));

    public static final RegistryObject<Item> MININUKE = registerAmmo("mini_nuke");

    //Rounds
    @DataGen
    public static final RegistryObject<Item> ROUND10MM = registerAmmo("round10mm");
    @DataGen
    public static final RegistryObject<Item> ROUND10MM_PIERCING = registerAmmo("round10mm_piercing");
//    public static final RegistryObject<Item> ROUND10MM_INCENDIARY = registerAmmo("round10mm_incendiary");
    @DataGen
    public static final RegistryObject<Item> ROUND38 = registerAmmo("round38");
    @DataGen
    public static final RegistryObject<Item> ROUND38_PIERCING = registerAmmo("round38_piercing");
    @DataGen
    public static final RegistryObject<Item> STEEL_BALLS = registerAmmo("steel_ball");
    @DataGen
    public static final RegistryObject<Item> ROUND45 = registerAmmo("round45");
    @DataGen
    public static final RegistryObject<Item> ROUND45_PIERCING = registerAmmo("round45_piercing");
    @DataGen
    public static final RegistryObject<Item> ROUND5MM = registerAmmo("round5mm");
    @DataGen
    public static final RegistryObject<Item> ROUND5MM_PIERCING = registerAmmo("round5mm_piercing");
    @DataGen
    public static final RegistryObject<Item> ROUND44 = registerAmmo("round44");
    @DataGen
    public static final RegistryObject<Item> ROUND44_PIERCING = registerAmmo("round44_piercing");
    @DataGen
    public static final RegistryObject<Item> ROUND50 = registerAmmo("round50");
    @DataGen
    public static final RegistryObject<Item> ROUND50_PIERCING = registerAmmo("round50_piercing");
    @DataGen
    public static final RegistryObject<Item> ROUND380 = registerAmmo("round380");
    @DataGen
    public static final RegistryObject<Item> ROUND380_piercing = registerAmmo("round380_piercing");
    @DataGen
    public static final RegistryObject<Item> ROUND556 = registerAmmo("round556");
    @DataGen
    public static final RegistryObject<Item> ROUND556_PIERCING = registerAmmo("round556_piercing");
    @DataGen
    public static final RegistryObject<Item> SHOT_SHELL = registerAmmo("shotshell");
    @DataGen
    public static final RegistryObject<Item> ROUND127 = registerAmmo("round127");
    @DataGen
    public static final RegistryObject<Item> ROUND127_PIERCING = registerAmmo("round127_piercing");
    @DataGen
    public static final RegistryObject<Item> ROUND22 = registerAmmo("round22");
    @DataGen
    public static final RegistryObject<Item> ROUND22_PIERCING = registerAmmo("round22_piercing");
    @DataGen
    public static final RegistryObject<Item> FUSION_CELL = registerAmmo("fusion_cell");
    @DataGen
    public static final RegistryObject<Item> FUEL = ModItems.ITEMS.register("fuel",
            () -> new AmmoItem(new Item.Properties()
                    .durability(500)
            ));

    @DataGen
    public static final RegistryObject<Item> FUSION_CORE = ITEMS.register("fusion_core",
            () -> new FusionCoreItem(new Item.Properties().durability(500)));

    public static RegistryObject<GunItem> registerGun(String name) {
        return ITEMS.register(name, () -> new GunItem(new Item.Properties().stacksTo(1)));
    }

    public static RegistryObject<GunItem> registerTechnicGun(String name) {
        return ITEMS.register(name, () -> new TechnicGun(new Item.Properties().stacksTo(1)));
    }

    public static RegistryObject<GunItem> registerGun(String name, int durability) {
        return ITEMS.register(name, () -> new GunItem(new Item.Properties().durability(durability)));
    }

    public static RegistryObject<Item> registerAmmo(String name) {
        return ITEMS.register(name, () -> new AmmoItem(new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
