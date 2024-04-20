package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.items.misc.ColoredHolotapeItem;
import com.nukateam.nukacraft.common.foundation.items.misc.NuclearMaterialItem;
import com.nukateam.nukacraft.common.foundation.items.misc.VioletReagent;
import com.nukateam.nukacraft.common.foundation.items.сonsumables.RadNamedItem;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.fluid.ModFluids;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.nukateam.nukacraft.common.data.constants.PipboyColors.*;
//Здесь армяне в нарды играют

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    ///RAW MATERIALS


    public static final RegistryObject<Item> UNWEAPONPARTS = ITEMS.register("unc_weapon_parts",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEATHCLAW = ITEMS.register("deathclaw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEGWEAPONPARTS = ITEMS.register("leg_weapon_parts",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MTHWEAPONPARTS = ITEMS.register("myth_weapon_parts",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WEAPONPARTS = ITEMS.register("weapon_parts",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCRAP = ITEMS.register("scrap",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> ACID = ITEMS.register("acid",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VIOPLEX = ITEMS.register("purple_reagent",
            () -> new VioletReagent(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ADHESIVE = ITEMS.register("adhesive",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANTISEPT = ITEMS.register("antisept",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FERTILIZER = ITEMS.register("fertilizer",
            () -> new BoneMealItem(new Item.Properties()));
    public static final RegistryObject<Item> OIL = ITEMS.register("oil",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIBER = ITEMS.register("fiber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLOWINGRES = ITEMS.register("resin_glow",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLOAMSAP = ITEMS.register("gloam_sap",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPTOFIBER = ITEMS.register("optofiber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> THREADS = ITEMS.register("threads",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCREWS = ITEMS.register("screws",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPRINGS = ITEMS.register("spring",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEARS = ITEMS.register("gears",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COMPOSITE = ITEMS.register("composite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLASTIC = ITEMS.register("plastic",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEXTILE = ITEMS.register("textile",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINGOT = ITEMS.register("alumi_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BTITANING = ITEMS.register("btitan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VAULTDOOR = ITEMS.register("vaultdoor",
            () -> new BlockItem(ModBlocks.GEARDOOR.get(), new Item.Properties()));
    //    public static final RegistryObject<Item> HALFBARRIER = ITEMS.register("half_barrier_item",
//            () -> new BlockItem(ModBlocks.HALFBARRIER.get(), new Item.Properties().tab(NUKA_BLOCKS)));
//    public static final RegistryObject<Item> FILLERBARRIER = ITEMS.register("filler_barrier_item",
//            () -> new BlockItem(ModBlocks.FILLERBARRIER.get(), new Item.Properties().tab(NUKA_BLOCKS)));
    public static final RegistryObject<Item> LEADING = ITEMS.register("lead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVERING = ITEMS.register("silver",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEELING = ITEMS.register("steel",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ULTRACITE = ITEMS.register("ultracite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUGG = ITEMS.register("aluminugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BTITANNUGG = ITEMS.register("btitannugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> URANRAW = ITEMS.register("raw_uran",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SATURNITERAW = ITEMS.register("raw_saturnite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEADNUGG = ITEMS.register("leadnugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVERNUGG = ITEMS.register("silvernugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BOGPAD_ITEM = ITEMS.register("bogpad_item",
            () -> new ItemNameBlockItem(ModBlocks.GAMMALEAF_BUSH.get(), new Item.Properties().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> STEELNUGG = ITEMS.register("steelnugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CERAMIC = ITEMS.register("ceramic",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELECTRONUM = ITEMS.register("electronum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GLOWMASS = ITEMS.register("glowmass",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEATHERHARD = ITEMS.register("leatherhard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DCLEATHER = ITEMS.register("dcleather",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BBLOODLEAF = ITEMS.register("bbloodleafl",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUANTLEAF = ITEMS.register("quantumleaf",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GAMMALEAF = ITEMS.register("gammaleaf",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> BLOODLEAF = ITEMS.register("nbloodleafi",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BBLOODLEAF_ = ITEMS.register("bbloodleafl_",
            () -> new ItemNameBlockItem(ModBlocks.BBLOODLEAF_BUSH.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUANTLEAF_ = ITEMS.register("quantumleaf_",
            () -> new ItemNameBlockItem(ModBlocks.QUANTUMLEAF_BUSH.get(), new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GAMMALEAF_ = ITEMS.register("gammaleaf_",
            () -> new ItemNameBlockItem(ModBlocks.GAMMALEAF_BUSH.get(), new Item.Properties().rarity(Rarity.EPIC)));


    public static final RegistryObject<Item> BLOODLEAF_ = ITEMS.register("nbloodleafi_",
            () -> new ItemNameBlockItem(ModBlocks.BLOODLEAF_BUSH.get(), new Item.Properties()));
    public static final RegistryObject<Item> PRMT = ITEMS.register("pmt1",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> THISTLE = ITEMS.register("thistle_bud",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRAINFUNGUS = ITEMS.register("brainfungus",
            () -> new RadNamedItem(0.2f, ModBlocks.BRAINFUNGUS.get(), new Item.Properties()));
    public static final RegistryObject<Item> MINDFUNGUS = ITEMS.register("mindfungus",
            () -> new RadNamedItem(0.5f, ModBlocks.MINDFUNGUS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ASHDUST = ITEMS.register("ashdust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CORAL_LEAF = ITEMS.register("coral_leaf",
            () -> new RadNamedItem(0f, ModBlocks.CORALLEAF.get(), new Item.Properties()));
    public static final RegistryObject<Item> PRISM_LEAF = ITEMS.register("prism_leafs",
            () -> new RadNamedItem(0f, ModBlocks.PRISMLEAF.get(), new Item.Properties()));
    public static final RegistryObject<Item> CAP = ITEMS.register("cap",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DOGWOOD = ITEMS.register("dogwood",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NUCMAT = ITEMS.register("nuclear_mat",
            () -> new NuclearMaterialItem(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> PREWARMON = ITEMS.register("prewarmoney",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWURAN = ITEMS.register("rawuran",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> LEADPLATE = ITEMS.register("leadplate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FILTER = ITEMS.register("filter",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAWALUMI = ITEMS.register("raw_alumi",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWBTITAN = ITEMS.register("raw_btitan",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWLEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAWSILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));

    ///ADVANCED MATERIALS
    public static final RegistryObject<Item> ADVMAG = ITEMS.register("advmag",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> MAG = ITEMS.register("magnet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AIPROCC = ITEMS.register("aimproccesor",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADCAN = ITEMS.register("adncan",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> URANROD = ITEMS.register("uranrod",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CERPLATE = ITEMS.register("cerplate",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> ALUMING = ITEMS.register("alumicond",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COPPERWIRE = ITEMS.register("copperwires",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> LAMP = ITEMS.register("lamp",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> ULTRBAR = ITEMS.register("ultrbar",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COPPERCOND = ITEMS.register("coppercond",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> REDUCER = ITEMS.register("reducer",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    ///FLUX
    public static final RegistryObject<Item> RAWCOBFLUX = ITEMS.register("undcobaltflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COBFLUX = ITEMS.register("cobaltflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CLEANCOBFLUX = ITEMS.register("cleancobaltflux",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> RAWFLUOFLUX = ITEMS.register("undfluorflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FLUOFLUX = ITEMS.register("fluorflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CLEANFLUOFLUX = ITEMS.register("cleanfluorflux",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> RAWSCARFLUX = ITEMS.register("undscarletflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SCARFLUX = ITEMS.register("scarletflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CLEANSCARFLUX = ITEMS.register("cleanscarletflux",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> URANFLUX = ITEMS.register("uraniumflux",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> PUREURANFLUX = ITEMS.register("cleanuraniumflux",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RAWVIOLFLUX = ITEMS.register("undvioletflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> VIOLFLUX = ITEMS.register("violetflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CLEANVIOLFLUX = ITEMS.register("cleanvioletflux",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> BLACKFLUX = ITEMS.register("blackflux",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    //
    public static final RegistryObject<Item> GIGAWHEATL = ITEMS.register("gigawheat",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GIGAWHEAT_SEEDS = ITEMS.register("gigawheat_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GIGAWHEAT.get(), (new Item.Properties().rarity(Rarity.RARE))));
    public static final RegistryObject<Item> ABRAXOCLEANER = ITEMS.register("abraxo_cleaner",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> STEELBOWL = ITEMS.register("steelbowl",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> INDAABRAXOCLEANER = ITEMS.register("inda_abraxo_cleaner",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> PIEZODIVIDE = ITEMS.register("piezonucleic_divider",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARZDIVIDER = ITEMS.register("quartz_divider",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ULTRDIVIDER = ITEMS.register("ultracite_divider",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ULTRSHEAT = ITEMS.register("ultracite_shell",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WHITEBRICK = ITEMS.register("whitebrick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILICATE = ITEMS.register("silicate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARZS_SHELL = ITEMS.register("quartz_shell",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> QUARZPIECE = ITEMS.register("quartz_piece",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> QUARZPLATE = ITEMS.register("quartz_plate",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ARMYCIRCUIT = ITEMS.register("army_circuit",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> ELEDIVIDE = ITEMS.register("electrite_divider",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ELESHEAT = ITEMS.register("electrite_shell",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> GILLEAD = ITEMS.register("gilded_lead",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

//    public static final RegistryObject<Item> PIMPBOY = ITEMS.register("pimpboy",
//            () -> new PipBoyItem("pimpboy", new Item.Properties().tab(ModItemTabs.NUKA_ARMOR).stacksTo(1)));
//public static final RegistryObject<Item> WEAPONDISPLAY = ITEMS.register("weapon_display_item",
//        () -> new WeaponDisplayItem(EntityTypes.WEAPON_DISPLAY.get(), new Item.Properties()));

    public static final RegistryObject<Item> HOLO_1CC = ITEMS.register("holotape_white",
            () -> new ColoredHolotapeItem(WHITE, new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> HOLO_1D2 = ITEMS.register("holotape_green",
            () -> new ColoredHolotapeItem(GREEN, new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> HOLO_2D2 = ITEMS.register("holotape_cyan",
            () -> new ColoredHolotapeItem(CYAN, new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> HOLO_2D3 = ITEMS.register("holotape_red",
            () -> new ColoredHolotapeItem(RED, new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> HOLO_3D3 = ITEMS.register("holotape_gold",
            () -> new ColoredHolotapeItem(GOLD, new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> HOLO_3D4 = ITEMS.register("holotape_orange",
            () -> new ColoredHolotapeItem(ORANGE, new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> HOLO_3D = ITEMS.register("holotape_violet",
            () -> new ColoredHolotapeItem(VIOLET, new Item.Properties().rarity(Rarity.COMMON)));

    public static final RegistryObject<Item> ACID_BUCKET = ITEMS.register("acid_bucket",
            () -> new BucketItem(ModFluids.ACID_FLUID, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DIRTY_WATER_BUCKET = ITEMS.register("dirty_water_bucket",
            () -> new BucketItem(ModFluids.DIRTY_WATER_FLUID, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> POISONOUS_WATER_BUCKET = ITEMS.register("poisonous_water_bucket",
            () -> new BucketItem(ModFluids.POISONOUS_WATER_FLUID, new Item.Properties().stacksTo(1)));

    //Spawn Eggs
    public static final RegistryObject<ForgeSpawnEggItem> RAIDER_SPAWN_EGG = ITEMS.register("raider_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.RAIDER, 0xcdb59b, 0x85725c,
                    new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> RADROACH_SPAWN_EGG = ITEMS.register("radroach_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.RADROACH, 0xcdb50b, 0x85005c,
                    new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> BLOATFLY_SPAWN_EGG = ITEMS.register("bloatfly_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.BLOATFLY, 0xcdbcdb, 0x58008c,
                    new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> BRAHMIN_SPAWN_EGG = ITEMS.register("brahmin_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.BRAHMIN, 0xcdb0db, 0x85058c,
                    new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> DEATHCLAW_SPAWN_EGG = ITEMS.register("deathclaw_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.DEATHCLAW, 0x4b3b35, 0x322926,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
