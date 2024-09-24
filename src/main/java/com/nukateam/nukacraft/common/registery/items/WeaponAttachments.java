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
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_COLLIMATOR_SIGHT = ITEMS.register("pistol_collimator_sight",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_HOLOGRAPHIC_SIGHT = ITEMS.register("pistol_holographic_sight",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_HUNTING_OPTICS = ITEMS.register("pistol_hunting_optics",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_IRON_SIGHT = ITEMS.register("pistol_iron_sight",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_SCOUT_SIGHT = ITEMS.register("pistol_scout_sight",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    /* Barrel Attachments */
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_SILENCER = ITEMS.register("pistol_silencer",
            () -> new BarrelItem(Barrel.create(8.0F, GunModifiers.FLASH_HIDER, GunModifiers.SILENCED, GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_DAMAGE_lvl1, GunModifiers.REDUCED_DISTANCE_LVL3), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_COMPENSATOR = ITEMS.register("pistol_compensator",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.REDUCED_RECOIL_LVL2, GunModifiers.REDUCED_DAMAGE_lvl2), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_FLAME_HIDER = ITEMS.register("pistol_flame_hider",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.FLASH_HIDER, GunModifiers.REDUCED_DAMAGE_lvl1), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_HEAVY_BARREL = ITEMS.register("pistol_heavy_barrel",
            () -> new BarrelItem(Barrel.create(4.0F, GunModifiers.EXTEND_RECOIL_LVL1, GunModifiers.EXTEND_DAMAGE_lvl1, GunModifiers.EXTEND_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_LONG_BARREL = ITEMS.register("pistol_long_barrel",
            () -> new BarrelItem(Barrel.create(4.0F, GunModifiers.EXTEND_RECOIL_LVL1, GunModifiers.EXTEND_DAMAGE_lvl2, GunModifiers.EXTEND_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));



    /* Under Barrel Attachments */
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_SPECIALISED_GRIP = ITEMS.register("pistol_specialised_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL2, GunModifiers.REDUCED_KICKING_LVL1), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_TACTICAL_GRIP = ITEMS.register("pistol_tactical_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_KICKING_LVL3), new Item.Properties().stacksTo(1), false));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_WEIGHTED_GRIP = ITEMS.register("pistol_weighted_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL3, GunModifiers.REDUCED_KICKING_LVL2), new Item.Properties().stacksTo(1)));


    /* Magazine Attachments*/
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_EXTENDED_MAGAZINE = ITEMS.register("pistol_extended_magazine",
            () -> new MagazineItem(Magazine.create(30, GunModifiers.EXTENDED_MAG), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_HUGE_MAGAZINE = ITEMS.register("pistol_huge_magazine",
            () -> new MagazineItem(Magazine.create(60, GunModifiers.HUGE_MAG), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_DRUM_MAGAZINE = ITEMS.register("pistol_drum_magazine",
            () -> new MagazineItem(Magazine.create(60, GunModifiers.DRUM_MAG), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PISTOL_QUICK_MAGAZINE = ITEMS.register("pistol_quick_magazine",
            () -> new MagazineItem(Magazine.create(60, GunModifiers.QUICK_MAG, GunModifiers.EXTEND_KICKING_LVL3), new Item.Properties().stacksTo(1)));







    /* Handmade Grip Attachmentы */

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PIPE_TACTICAL_GRIP = ITEMS.register("pipe_tactical_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL1,GunModifiers.TRANSFORM_CARBINE, GunModifiers.REDUCED_KICKING_LVL3), new Item.Properties().stacksTo(1), false));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PIPE_PISTOL_GRIP = ITEMS.register("pipe_pistol_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_KICKING_LVL1), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PIPE_LONG_GRIP = ITEMS.register("pipe_long_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL3,GunModifiers.TRANSFORM_CARBINE, GunModifiers.REDUCED_KICKING_LVL1, GunModifiers.REDUCED_KICKING_LVL2), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PIPE_CARBINE_GRIP = ITEMS.register("pipe_carbine_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL3,GunModifiers.TRANSFORM_CARBINE, GunModifiers.REDUCED_KICKING_LVL1, GunModifiers.REDUCED_KICKING_LVL3), new Item.Properties().stacksTo(1)));






    /* Handmade Barrel Attachments */
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PIPE_SILENCER = ITEMS.register("pipe_silencer",
            () -> new BarrelItem(Barrel.create(8.0F, GunModifiers.FLASH_HIDER, GunModifiers.SILENCED, GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_DAMAGE_lvl1, GunModifiers.REDUCED_DISTANCE_LVL3), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PIPE_COMPENSATOR = ITEMS.register("pipe_compensator",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.REDUCED_RECOIL_LVL2, GunModifiers.REDUCED_DAMAGE_lvl2), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PIPE_FLAME_HIDER = ITEMS.register("pipe_flame_hider",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.FLASH_HIDER, GunModifiers.REDUCED_DAMAGE_lvl1), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PIPE_HEAVY_BARREL = ITEMS.register("pipe_heavy_barrel",
            () -> new BarrelItem(Barrel.create(4.0F, GunModifiers.EXTEND_RECOIL_LVL2, GunModifiers.EXTEND_DAMAGE_lvl1, GunModifiers.EXTEND_DISTANCE_LVL2, GunModifiers.EXTEND_KICKING_LVL3), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PIPE_LONG_BARREL = ITEMS.register("pipe_long_barrel",
            () -> new BarrelItem(Barrel.create(4.0F, GunModifiers.EXTEND_RECOIL_LVL2, GunModifiers.EXTEND_DAMAGE_lvl2, GunModifiers.EXTEND_DISTANCE_LVL2, GunModifiers.EXTEND_KICKING_LVL2), new Item.Properties().stacksTo(1)));





    /* Minigun Barrel Attachments */
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> MINIGUN_LONG_BARREL = ITEMS.register("minigun_long_barrel",
            () -> new BarrelItem(Barrel.create(8.0F, GunModifiers.EXTEND_KICKING_LVL3, GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_DAMAGE_lvl1, GunModifiers.EXTEND_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> MINIGUN_SHREDDER = ITEMS.register("minigun_shredder",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.REDUCED_RECOIL_LVL3, GunModifiers.REDUCED_DAMAGE_lvl1), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> MINIGUN_SIX_BARREL = ITEMS.register("minigun_six_barrel",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.EXTEND_RECOIL_LVL2, GunModifiers.EXTEND_DAMAGE_lvl2), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> MINIGUN_SHREDDER_SATURNITE = ITEMS.register("minigun_shredder_saturnite",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.EXTEND_RECOIL_LVL2, GunModifiers.EXTEND_DAMAGE_lvl1, GunModifiers.REDUCED_DISTANCE_LVL3, GunModifiers.EXTEND_KICKING_LVL3), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> MINIGUN_SHREDDER_HEAT = ITEMS.register("minigun_shredder_heat",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.EXTEND_RECOIL_LVL1, GunModifiers.EXTEND_DAMAGE_lvl2, GunModifiers.REDUCED_DISTANCE_LVL3, GunModifiers.EXTEND_KICKING_LVL3), new Item.Properties().stacksTo(1)));

    /* Minigun Magazines Attachments */

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> MINIGUN_EXTEND_MAG = ITEMS.register("minigun_extend_mag",
            () -> new MagazineItem(Magazine.create(500, GunModifiers.EXTENDED_MAG), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> MINIGUN_DRUM_MAG = ITEMS.register("minigun_drum_mag",
            () -> new MagazineItem(Magazine.create(500, GunModifiers.DRUM_MAG), new Item.Properties().stacksTo(1)));









    /* Gatling Laser Barrel Attachments */
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> GATLING_LASER_TRIPLE_BARREL = ITEMS.register("gatling_laser_triple_barrel",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.REDUCED_LASER_RATE_lvl1, GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_DAMAGE_lvl1, GunModifiers.EXTEND_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> GATLING_LASER_EIGHT_BARREL = ITEMS.register("gatling_laser_eight_barrel",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.EXTEND_LASER_RATE_lvl1, GunModifiers.REDUCED_DAMAGE_lvl2), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> GATLING_LASER_INDUSTRIAL_BARREL = ITEMS.register("gatling_laser_industrial_barrel",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.SLOWEST_LASER_RATE_lvl1, GunModifiers.EXTEND_RECOIL_LVL2, GunModifiers.EXTEND_DAMAGE_lvl3, GunModifiers.EXTEND_KICKING_LVL3), new Item.Properties().stacksTo(1)));


    //Under Barrel

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> GATLING_LASER_BEAM_SPLITTER = ITEMS.register("gatling_laser_beam_splitter",
            () -> new UnderBarrelItem(UnderBarrel.create(GunModifiers.REDUCED_KICKING_LVL1), new Item.Properties().stacksTo(1)));


    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> GATLING_LASER_BEAM_FOCUSER = ITEMS.register("gatling_laser_beam_focuser",
            () -> new UnderBarrelItem(UnderBarrel.create(GunModifiers.REDUCED_KICKING_LVL1), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> GATLING_LASER_CORRECTION_LENS = ITEMS.register("gatling_laser_correction_lens",
            () -> new UnderBarrelItem(UnderBarrel.create(GunModifiers.REDUCED_KICKING_LVL1), new Item.Properties().stacksTo(1)));


    /* Pump Shotgun  Barrel Attachments */
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PUMP_SHIELD_BARREL = ITEMS.register("pump_shield_barrel",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.REDUCED_RECOIL_LVL3, GunModifiers.EXTEND_KICKING_LVL1), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PUMP_SILENCER_BARREL = ITEMS.register("pump_silencer_barrel",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.SILENCED, GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PUMP_LONG_BARREL = ITEMS.register("pump_long_barrel",
            () -> new BarrelItem(Barrel.create(10.0F,GunModifiers.EXTENDED_MAG, GunModifiers.REDUCED_RECOIL_LVL1,GunModifiers.REDUCED_DAMAGE_lvl3, GunModifiers.EXTEND_DISTANCE_LVL3), new Item.Properties().stacksTo(1)));

    /* Pump Shotgun  Grip Attachments */


//    @DataGen(path = "attachments")
//    public static final RegistryObject<Item> PUMP_HOLOGRAPHIC_SIGHT = ITEMS.register("pump_holographic_sight",
//            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));
//
//    @DataGen(path = "attachments")
//    public static final RegistryObject<Item> PUMP_HUNTING_OPTICS = ITEMS.register("pump_hunting_optics",
//            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));
//
//    @DataGen(path = "attachments")
//    public static final RegistryObject<Item> PUMP_IRON_SIGHT = ITEMS.register("pump_iron_sight",
//            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PUMP_TACTICAL_GRIP = ITEMS.register("pump_tactical_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_KICKING_LVL3), new Item.Properties().stacksTo(1), false));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PUMP_PISTOL_GRIP = ITEMS.register("pump_pistol_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_KICKING_LVL1), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PUMP_LONG_GRIP = ITEMS.register("pump_long_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL3, GunModifiers.REDUCED_KICKING_LVL1, GunModifiers.REDUCED_KICKING_LVL2), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> PUMP_WEIGHTED_GRIP = ITEMS.register("pump_weighted_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL3, GunModifiers.REDUCED_KICKING_LVL1, GunModifiers.REDUCED_KICKING_LVL3), new Item.Properties().stacksTo(1)));


    /* Tesla Grip Attachments */
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> TESLA_TACTICAL_GRIP = ITEMS.register("tesla_tactical_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL2, GunModifiers.REDUCED_KICKING_LVL2), new Item.Properties().stacksTo(1), false));


    /* Tesla Barrel Attachments */
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> TESLA_AUTO_BARREL = ITEMS.register("tesla_auto_barrel",
            () -> new BarrelItem(Barrel.create(1.0F,GunModifiers.SET_AUTO_FIRE, GunModifiers.REDUCED_RECOIL_LVL3, GunModifiers.EXTEND_KICKING_LVL1), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> TESLA_CHARGING_BARREL = ITEMS.register("tesla_charging_barrel",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> TESLA_RAIL_BARREL = ITEMS.register("tesla_rail_barrel",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.REDUCED_RECOIL_LVL1,GunModifiers.REDUCED_DAMAGE_lvl3, GunModifiers.EXTEND_DISTANCE_LVL3), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> TESLA_OVERHEAT_BARREL = ITEMS.register("tesla_overheat_barrel",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> TESLA_IRON_SIGHT = ITEMS.register("tesla_iron_sight",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));
    /* Laser Barrel Attachments */

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> LASER_SNIPER_BARREL = ITEMS.register("laser_sniper_barrel",
            () -> new BarrelItem(Barrel.create(1.0F, GunModifiers.REDUCED_RECOIL_LVL2,GunModifiers.REDUCED_DAMAGE_lvl2, GunModifiers.EXTEND_DISTANCE_LVL3), new Item.Properties().stacksTo(1)));


    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> LASER_AUTO_BARREL = ITEMS.register("laser_auto_barrel",
            () -> new BarrelItem(Barrel.create(1.0F,GunModifiers.EXTEND_LASER_RATE_lvl2, GunModifiers.SET_AUTO_FIRE, GunModifiers.EXTEND_RECOIL_LVL2,GunModifiers.REDUCED_DAMAGE_lvl2, GunModifiers.REDUCED_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> LASER_PROTECTRON_BARREL = ITEMS.register("laser_protectron_barrel",
            () -> new BarrelItem(Barrel.create(2.0F, GunModifiers.EXTEND_RECOIL_LVL2,GunModifiers.EXTEND_DAMAGE_lvl3, GunModifiers.REDUCED_DISTANCE_LVL3), new Item.Properties().stacksTo(1)));


    /* Laser Grip Attachments */

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> LASER_TACTICAL_GRIP = ITEMS.register("laser_tactical_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL1, GunModifiers.REDUCED_KICKING_LVL1), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> LASER_LONG_GRIP = ITEMS.register("laser_long_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL3, GunModifiers.REDUCED_KICKING_LVL1, GunModifiers.REDUCED_KICKING_LVL2), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> LASER_WEIGHTED_GRIP = ITEMS.register("laser_weighted_grip",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL3, GunModifiers.REDUCED_KICKING_LVL1, GunModifiers.REDUCED_KICKING_LVL3), new Item.Properties().stacksTo(1)));


    /* Laser Scope Attachments */

//    @DataGen(path = "attachments")
//    public static final RegistryObject<Item> LASER_LONG_SCOUT_SIGHT = ITEMS.register("laser_long_scout_optics",
//            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

//    @DataGen(path = "attachments")
//    public static final RegistryObject<Item> LASER_SCOUT_SIGHT = ITEMS.register("laser_scout_optics",
//            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

//    @DataGen(path = "attachments")
//    public static final RegistryObject<Item> LASER_IRON_SIGHT = ITEMS.register("laser_iron_sight",
//            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> LASER_ALL_VISION = ITEMS.register("laser_all_vision",
            () -> new ScopeItem(Attachments.SHORT_SCOPE, new Item.Properties().stacksTo(1)));





    // FLamer Barrel
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> FLAMER_LONG_BARREL = ITEMS.register("flamer_long_barrel",
            () -> new BarrelItem(Barrel.create(7.0F, GunModifiers.EXTEND_RECOIL_LVL1, GunModifiers.EXTEND_KICKING_LVL1,GunModifiers.EXTEND_DISTANCE_LVL2), new Item.Properties().stacksTo(1)));
    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> FLAMER_COMPRESS_BARREL = ITEMS.register("flamer_compress_barrel",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.EXTEND_KICKING_LVL3,GunModifiers.EXTEND_DAMAGE_lvl3), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> FLAMER_EVAPORATIVE_BARREL = ITEMS.register("flamer_evaporative_barrel",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.EXTEND_RECOIL_LVL2,GunModifiers.EXTEND_DAMAGE_lvl2), new Item.Properties().stacksTo(1)));

    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> FLAMER_HEAVY_BARREL = ITEMS.register("flamer_heavy_barrel",
            () -> new BarrelItem(Barrel.create(3.0F, GunModifiers.EXTEND_KICKING_LVL3, GunModifiers.EXTEND_RECOIL_LVL2,GunModifiers.EXTEND_DAMAGE_lvl3), new Item.Properties().stacksTo(1)));


    //@DataGen(path = "attachments")
    public static final RegistryObject<Item> STOCK_SHIELD = ITEMS.register("stock_shield",
            () -> new StockItem(Stock.create(GunModifiers.REDUCED_RECOIL_LVL2, GunModifiers.REDUCED_KICKING_LVL1), new Item.Properties().stacksTo(1)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
