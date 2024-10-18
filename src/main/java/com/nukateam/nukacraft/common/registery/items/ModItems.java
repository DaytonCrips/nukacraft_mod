package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.annotation.DataGen;
import com.nukateam.nukacraft.common.data.enums.ItemParent;
import com.nukateam.nukacraft.common.foundation.items.consumables.RadNamedItem;
import com.nukateam.nukacraft.common.foundation.items.misc.*;
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
//    @DataGen
//    public static final RegistryObject<Item> UNWEAPONPARTS = ITEMS.register("unc_weapon_parts",
//            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> DEATHCLAW = ITEMS.register("deathclaw",
            () -> new Item(new Item.Properties()));
//    @DataGen
//    public static final RegistryObject<Item> LEGWEAPONPARTS = ITEMS.register("leg_weapon_parts",
//            () -> new Item(new Item.Properties()));
//    @DataGen
//    public static final RegistryObject<Item> MTHWEAPONPARTS = ITEMS.register("myth_weapon_parts",
//            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> WEAPONPARTS = ITEMS.register("weapon_parts",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> REPAIR_KIT = ITEMS.register("repair_kit",
            () -> new RepairKitItem(200, new Item.Properties().durability(2500)));
    @DataGen
    public static final RegistryObject<Item> ELITE_REPAIR_KIT = ITEMS.register("elite_repair_kit",
            () -> new RepairKitItem(500, new Item.Properties().durability(5000)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_BLACK = ITEMS.register("bucket_black",
            () -> new PaintjobItem("black", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_BROWN = ITEMS.register("bucket_brown",
            () -> new PaintjobItem("brown", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_CYAN = ITEMS.register("bucket_cyan",
            () -> new PaintjobItem("cyan", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_GREEN = ITEMS.register("bucket_green",
            () -> new PaintjobItem("green", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_BLUE = ITEMS.register("bucket_blue",
            () -> new PaintjobItem("blue", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_GRAY = ITEMS.register("bucket_gray",
            () -> new PaintjobItem("gray", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_LIGHT_GRAY = ITEMS.register("bucket_light_gray",
            () -> new PaintjobItem("light_gray", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_LIGHT_BLUE = ITEMS.register("bucket_light_blue",
            () -> new PaintjobItem("light_blue", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_LIME = ITEMS.register("bucket_lime",
            () -> new PaintjobItem("lime", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_MAGENTA = ITEMS.register("bucket_magenta",
            () -> new PaintjobItem("magenta", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_ORANGE = ITEMS.register("bucket_orange",
            () -> new PaintjobItem("orange", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_PINK = ITEMS.register("bucket_pink",
            () -> new PaintjobItem("pink", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_PURPLE = ITEMS.register("bucket_purple",
            () -> new PaintjobItem("purple", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_RED = ITEMS.register("bucket_red",
            () -> new PaintjobItem("red", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_WHITE = ITEMS.register("bucket_white",
            () -> new PaintjobItem("white", new Item.Properties().durability(12)));
    @DataGen
    public static final RegistryObject<Item> BUCKET_YELLOW = ITEMS.register("bucket_yellow",
            () -> new PaintjobItem("yellow", new Item.Properties().durability(12)));

    @DataGen
    public static final RegistryObject<Item> SCRAP = ITEMS.register("scrap",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> ACID = ITEMS.register("acid",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> MOLERAT_LEATHER = ITEMS.register("molerat_leather",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> MOLERAT_TEETH = ITEMS.register("molerat_teeth",
            () -> new Item(new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> CLAW_MIRELURK = ITEMS.register("claw_milelurk",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> RAZOR_MIRELURK = ITEMS.register("razor_milelurk",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> MIRELURK_EGG = ITEMS.register("mirelurk_egg",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> MIRELURK_EGGSHELL = ITEMS.register("mirelurk_eggshell",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> PURPLE_REAGENT = ITEMS.register("purple_reagent",
            () -> new VioletReagent(new Item.Properties().rarity(Rarity.RARE)));
    @DataGen
    public static final RegistryObject<Item> ADHESIVE = ITEMS.register("adhesive",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> ANTISEPTIC = ITEMS.register("antisept",
            () -> new Item(new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> FERTILIZER = ITEMS.register("fertilizer",
            () -> new BoneMealItem(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> OIL = ITEMS.register("oil",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> FIBER = ITEMS.register("fiber",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> GLOWING_RESIN = ITEMS.register("resin_glow",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> GLOAMSAP = ITEMS.register("gloam_sap",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> OPTOFIBER = ITEMS.register("optofiber",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> THREADS = ITEMS.register("threads",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> SCREWS = ITEMS.register("screws",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> SPRINGS = ITEMS.register("spring",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> GEARS = ITEMS.register("gears",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> COMPOSITE = ITEMS.register("composite",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> PLASTIC = ITEMS.register("plastic",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> TEXTILE = ITEMS.register("textile",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("alumi_ingot",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> BLACK_TITAN = ITEMS.register("black_titan",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> LEADING = ITEMS.register("lead",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> SILVERING = ITEMS.register("silver",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> STEELING = ITEMS.register("steel",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> ULTRACITE = ITEMS.register("ultracite",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> ALUMINUGG = ITEMS.register("aluminugget",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> BTITANNUGG = ITEMS.register("black_titan_nugget",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> RAW_URANIUM = ITEMS.register("raw_uran",
            () -> new Item(new Item.Properties()));
//    @DataGen
//    public static final RegistryObject<Item> SATURNITERAW = ITEMS.register("raw_saturnite",
//            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> SATURNITE_INGOT = ITEMS.register("saturnite_ingot",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("leadnugget",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silvernugget",
            () -> new Item(new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steelnugget",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> CERAMIC = ITEMS.register("ceramic",
            () -> new Item(new Item.Properties()));
//    @DataGen
//    public static final RegistryObject<Item> ELECTRONUM = ITEMS.register("electronum",
//            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> GLOW_MASS = ITEMS.register("glowmass",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> LEATHERHARD = ITEMS.register("leatherhard",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> DCLEATHER = ITEMS.register("dcleather",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> BBLOODLEAF = ITEMS.register("bbloodleaf",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> QUANTLEAF = ITEMS.register("quantumleaf",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    @DataGen
    public static final RegistryObject<Item> GAMMA_LEAF = ITEMS.register("gamma_leaf",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    @DataGen
    public static final RegistryObject<Item> BLOODLEAF = ITEMS.register("nbloodleafi",
            () -> new Item(new Item.Properties()));
//    @DataGen
//    public static final RegistryObject<Item> PRMT = ITEMS.register("pmt1",
//            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> THISTLE = ITEMS.register("thistle_bud",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> ASHDUST = ITEMS.register("ashdust",
            () -> new Item(new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> CAP = ITEMS.register("cap",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> DOGWOOD = ITEMS.register("dogwood",
            () -> new Item(new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> NUCMAT = ITEMS.register("nuclear_mat",
            () -> new NuclearMaterialItem(new Item.Properties().rarity(Rarity.EPIC)));
    @DataGen
    public static final RegistryObject<Item> PREWARMON = ITEMS.register("prewarmoney",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> RAWURAN = ITEMS.register("rawuran",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    @DataGen
    public static final RegistryObject<Item> LEADPLATE = ITEMS.register("leadplate",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> FILTER = ITEMS.register("filter",
            () -> new Item(new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> RAWALUMI = ITEMS.register("raw_alumi",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> RAWBTITAN = ITEMS.register("raw_black_titan",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> RAWLEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> RAWSILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));

    ///ADVANCED MATERIALS
    @DataGen
    public static final RegistryObject<Item> ADVMAG = ITEMS.register("advmag",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    @DataGen
    public static final RegistryObject<Item> MAG = ITEMS.register("magnet",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> AIPROCC = ITEMS.register("aimproccesor",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> ADCAN = ITEMS.register("adncan",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    @DataGen
    public static final RegistryObject<Item> URANROD = ITEMS.register("uranrod",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    @DataGen
    public static final RegistryObject<Item> CERPLATE = ITEMS.register("cerplate",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    @DataGen
    public static final RegistryObject<Item> ALUMING = ITEMS.register("alumicond",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    @DataGen
    public static final RegistryObject<Item> COPPERWIRE = ITEMS.register("copperwires",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
//    @DataGen
//    public static final RegistryObject<Item> LAMP = ITEMS.register("lamp",
//            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
//    @DataGen
//    public static final RegistryObject<Item> ULTRBAR = ITEMS.register("ultrbar",
//            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
//    @DataGen
//    public static final RegistryObject<Item> COPPERCOND = ITEMS.register("coppercond",
//            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    @DataGen
    public static final RegistryObject<Item> REDUCER = ITEMS.register("reducer",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    ///FLUX
    @DataGen
    public static final RegistryObject<Item> RAWCOBFLUX = ITEMS.register("undcobaltflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    @DataGen
    public static final RegistryObject<Item> COBFLUX = ITEMS.register("cobaltflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    @DataGen
    public static final RegistryObject<Item> CLEANCOBFLUX = ITEMS.register("cleancobaltflux",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    @DataGen
    public static final RegistryObject<Item> RAWFLUOFLUX = ITEMS.register("undfluorflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    @DataGen
    public static final RegistryObject<Item> FLUOFLUX = ITEMS.register("fluorflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    @DataGen
    public static final RegistryObject<Item> CLEANFLUOFLUX = ITEMS.register("cleanfluorflux",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    @DataGen
    public static final RegistryObject<Item> RAWSCARFLUX = ITEMS.register("undscarletflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    @DataGen
    public static final RegistryObject<Item> SCARFLUX = ITEMS.register("scarletflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    @DataGen
    public static final RegistryObject<Item> CLEANSCARFLUX = ITEMS.register("cleanscarletflux",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    @DataGen
    public static final RegistryObject<Item> URANFLUX = ITEMS.register("uraniumflux",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    @DataGen
    public static final RegistryObject<Item> PUREURANFLUX = ITEMS.register("cleanuraniumflux",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    @DataGen
    public static final RegistryObject<Item> RAWVIOLFLUX = ITEMS.register("undvioletflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    @DataGen
    public static final RegistryObject<Item> VIOLFLUX = ITEMS.register("violetflux",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    @DataGen
    public static final RegistryObject<Item> CLEANVIOLFLUX = ITEMS.register("cleanvioletflux",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    @DataGen
    public static final RegistryObject<Item> BLACKFLUX = ITEMS.register("blackflux",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    //
    @DataGen
    public static final RegistryObject<Item> GIGAWHEATL = ITEMS.register("gigawheat",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));


    @DataGen
    public static final RegistryObject<Item> ABRAXOCLEANER = ITEMS.register("abraxo_cleaner",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    @DataGen
    public static final RegistryObject<Item> INDAABRAXOCLEANER = ITEMS.register("inda_abraxo_cleaner",
            () -> new IndustrialAbraxoItem(new Item.Properties().rarity(Rarity.RARE)));

    @DataGen
    public static final RegistryObject<Item> STEELBOWL = ITEMS.register("steelbowl",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    @DataGen
    public static final RegistryObject<Item> SPICES = ITEMS.register("spices",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
//    @DataGen
//    public static final RegistryObject<Item> PIEZODIVIDE = ITEMS.register("piezonucleic_divider",
//            () -> new Item(new Item.Properties()));
//    @DataGen
//    public static final RegistryObject<Item> QUARZDIVIDER = ITEMS.register("quartz_divider",
//            () -> new Item(new Item.Properties()));
//    @DataGen
//    public static final RegistryObject<Item> ULTRDIVIDER = ITEMS.register("ultracite_divider",
//            () -> new Item(new Item.Properties()));
//    @DataGen
//    public static final RegistryObject<Item> ULTRSHEAT = ITEMS.register("ultracite_shell",
//            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> WHITEBRICK = ITEMS.register("whitebrick",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> SILICATE = ITEMS.register("silicate",
            () -> new Item(new Item.Properties()));
//    @DataGen
//    public static final RegistryObject<Item> QUARZS_SHELL = ITEMS.register("quartz_shell",
//            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    @DataGen
    public static final RegistryObject<Item> QUARZPIECE = ITEMS.register("quartz_piece",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    @DataGen
    public static final RegistryObject<Item> QUARZPLATE = ITEMS.register("quartz_plate",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
//    @DataGen
//    public static final RegistryObject<Item> ARMYCIRCUIT = ITEMS.register("army_circuit",
//            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
//    @DataGen
//    public static final RegistryObject<Item> ELEDIVIDE = ITEMS.register("electrite_divider",
//            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
//    @DataGen
//    public static final RegistryObject<Item> ELESHEAT = ITEMS.register("electrite_shell",
//            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
//    @DataGen
//    public static final RegistryObject<Item> GILLEAD = ITEMS.register("gilded_lead",
//            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

//    @DataGen
//    public static final RegistryObject<Item> PIMPBOY = ITEMS.register("pimpboy",
//            () -> new PipBoyItem("pimpboy", new Item.Properties().tab(ModItemTabs.NUKA_ARMOR).stacksTo(1)));
//@DataGen
//    public static final RegistryObject<Item> WEAPONDISPLAY = ITEMS.register("weapon_display_item",
//        () -> new WeaponDisplayItem(EntityTypes.WEAPON_DISPLAY.get(), new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> HOLO_1CC = ITEMS.register("holotape_white",
            () -> new ColoredHolotapeItem(WHITE, new Item.Properties().rarity(Rarity.COMMON)));
    @DataGen
    public static final RegistryObject<Item> HOLO_1D2 = ITEMS.register("holotape_green",
            () -> new ColoredHolotapeItem(GREEN, new Item.Properties().rarity(Rarity.COMMON)));
    @DataGen
    public static final RegistryObject<Item> HOLO_2D2 = ITEMS.register("holotape_cyan",
            () -> new ColoredHolotapeItem(CYAN, new Item.Properties().rarity(Rarity.COMMON)));
    @DataGen
    public static final RegistryObject<Item> HOLO_2D3 = ITEMS.register("holotape_red",
            () -> new ColoredHolotapeItem(RED, new Item.Properties().rarity(Rarity.COMMON)));
    @DataGen
    public static final RegistryObject<Item> HOLO_3D3 = ITEMS.register("holotape_gold",
            () -> new ColoredHolotapeItem(GOLD, new Item.Properties().rarity(Rarity.EPIC)));
    @DataGen
    public static final RegistryObject<Item> HOLO_3D4 = ITEMS.register("holotape_orange",
            () -> new ColoredHolotapeItem(ORANGE, new Item.Properties().rarity(Rarity.COMMON)));
    @DataGen
    public static final RegistryObject<Item> HOLO_3D = ITEMS.register("holotape_violet",
            () -> new ColoredHolotapeItem(VIOLET, new Item.Properties().rarity(Rarity.COMMON)));

    @DataGen
    public static final RegistryObject<Item> ACID_BUCKET = ITEMS.register("acid_bucket",
            () -> new BucketItem(ModFluids.ACID_FLUID, new Item.Properties().stacksTo(1)));

    @DataGen
    public static final RegistryObject<Item> DIRTY_WATER_BUCKET = ITEMS.register("dirty_water_bucket",
            () -> new BucketItem(ModFluids.DIRTY_WATER_FLUID, new Item.Properties().stacksTo(1)));

    @DataGen
    public static final RegistryObject<Item> POISONOUS_WATER_BUCKET = ITEMS.register("poisonous_water_bucket",
            () -> new BucketItem(ModFluids.POISONOUS_WATER_FLUID, new Item.Properties().stacksTo(1)));

    @DataGen
    public static final RegistryObject<Item> BRAINFUNGUS = ITEMS.register("brainfungus",
            () -> new RadNamedItem(0.2f, ModBlocks.BRAINFUNGUS.get(), new Item.Properties()));

//    @DataGen
    public static final RegistryObject<Item> MINDFUNGUS = ITEMS.register("mindfungus",
            () -> new RadNamedItem(0.5f, ModBlocks.MINDFUNGUS.get(), new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> CORAL_LEAF = ITEMS.register("coral_leaf",
            () -> new RadNamedItem(0f, ModBlocks.CORALLEAF.get(), new Item.Properties()));

//    @DataGen
    public static final RegistryObject<Item> BOG_PAD = ITEMS.register("bog_pad",
            () -> new ItemNameBlockItem(ModBlocks.BOGPAD.get(), new Item.Properties().rarity(Rarity.EPIC)));

    @DataGen
    public static final RegistryObject<Item> BLACK_BLOOD_LEAF_BUSH = ITEMS.register("bbloodleafl_",
            () -> new ItemNameBlockItem(ModBlocks.BBLOODLEAF_BUSH.get(), new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> QUANTLEAF_BUSH = ITEMS.register("quantumleaf_",
            () -> new ItemNameBlockItem(ModBlocks.QUANTUMLEAF_BUSH.get(), new Item.Properties().rarity(Rarity.RARE)));

    @DataGen
    public static final RegistryObject<Item> GAMMALEAF_BUSH = ITEMS.register("gamma_leaf_bush",
            () -> new ItemNameBlockItem(ModBlocks.GAMMALEAF_BUSH.get(), new Item.Properties().rarity(Rarity.EPIC)));

    @DataGen
    public static final RegistryObject<Item> BLOODLEAF_BUSH = ITEMS.register("blood_leaf_bush",
            () -> new ItemNameBlockItem(ModBlocks.BLOODLEAF_BUSH.get(), new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> PRISM_LEAF = ITEMS.register("prism_leaf",
            () -> new RadNamedItem(0f, ModBlocks.PRISMLEAF.get(), new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> GIGAWHEAT_SEEDS = ITEMS.register("giga_wheat_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GIGAWHEAT.get(), (new Item.Properties().rarity(Rarity.RARE))));

    @DataGen
    public static final RegistryObject<Item> IRRADIATED_BEETROOT_SEED = ITEMS.register("irradiated_beetroot_seed",
            () -> new ItemNameBlockItem(ModBlocks.IRRADROOT.get(), new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> ULTRAVIOLET_CARROT_SEED = ITEMS.register("uf_carrot_seed",
            () -> new ItemNameBlockItem(ModBlocks.UFCARROT.get(), new Item.Properties()));
    //Spawn Eggs
    @DataGen(parent = ItemParent.SPAWN_EGG)
    public static final RegistryObject<ForgeSpawnEggItem> RAIDER_SPAWN_EGG = ITEMS.register("raider_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.RAIDER, 0xcdb59b, 0x85725c,
                    new Item.Properties()));

    @DataGen(parent = ItemParent.SPAWN_EGG)
    public static final RegistryObject<ForgeSpawnEggItem> RADROACH_SPAWN_EGG = ITEMS.register("radroach_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.RADROACH, 0xcdb50b, 0x85005c,
                    new Item.Properties()));

    @DataGen(parent = ItemParent.SPAWN_EGG)
    public static final RegistryObject<ForgeSpawnEggItem> BLOATFLY_SPAWN_EGG = ITEMS.register("bloatfly_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.BLOATFLY, 0xcdbcdb, 0x58008c,
                    new Item.Properties()));

    @DataGen(parent = ItemParent.SPAWN_EGG)
    public static final RegistryObject<ForgeSpawnEggItem> BRAHMIN_SPAWN_EGG = ITEMS.register("brahmin_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.BRAHMIN, 0xcdb0db, 0x85058c,
                    new Item.Properties()));

    @DataGen(parent = ItemParent.SPAWN_EGG)
    public static final RegistryObject<ForgeSpawnEggItem> DEATHCLAW_SPAWN_EGG = ITEMS.register("deathclaw_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.DEATHCLAW, 0x4b3b35, 0x322926,
                    new Item.Properties()));

    @DataGen(parent = ItemParent.SPAWN_EGG)
    public static final RegistryObject<ForgeSpawnEggItem> MOLERAT_SPAWN_EGG = ITEMS.register("molerat_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.MOLERAT, 0x413135, 0x322226,
                    new Item.Properties()));

    @DataGen(parent = ItemParent.SPAWN_EGG)
    public static final RegistryObject<ForgeSpawnEggItem> ASSAULTRON_SPAWN_EGG = ITEMS.register("assaultron_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.ASSAULTRON, 0x4bbb35, 0x332266,
                    new Item.Properties()));


    @DataGen(parent = ItemParent.SPAWN_EGG)
    public static final RegistryObject<ForgeSpawnEggItem> SECURITRON_SPAWN_EGG = ITEMS.register("securitron_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.SECURITRON, 0x4bbbbb, 0x337766,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
