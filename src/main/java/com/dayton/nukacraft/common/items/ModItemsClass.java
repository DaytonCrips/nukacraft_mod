package com.dayton.nukacraft.common.items;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.blocks.ModBlocksClass;
import com.dayton.nukacraft.common.items.custom.*;
import com.dayton.nukacraft.common.items.custom.armor.ArmorPart;
import com.jetug.chassis_core.common.data.enums.ChassisPart;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.dayton.nukacraft.common.materials.PowerArmorMaterials.T45;
//Здесь армяне в нарды играют

public class ModItemsClass {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    ///RAW MATERIALS
    public static final RegistryObject<Item> ACID = ITEMS.register("acid",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> VIOPLEX = ITEMS.register("purple_reagent",
            () -> new VioletReagent(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ADHESIVE = ITEMS.register("adhesive",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> ANTISEPT = ITEMS.register("antisept",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> FERTILIZER = ITEMS.register("fertilizer",
            () -> new BoneMealItem(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> OIL = ITEMS.register("oil",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));

    public static final RegistryObject<Item> FIBER = ITEMS.register("fiber",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> OPTOFIBER = ITEMS.register("optofiber",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> THREADS = ITEMS.register("threads",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> SCREWS = ITEMS.register("screws",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> SPRINGS = ITEMS.register("spring",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> GEARS = ITEMS.register("gears",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> COMPOSITE = ITEMS.register("composite",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> PLASTIC = ITEMS.register("plastic",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> TEXTILE = ITEMS.register("textile",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> ALUMINGOT = ITEMS.register("alumi_ingot",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> BTITANING = ITEMS.register("btitan",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> LEADING = ITEMS.register("lead",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> SILVERING = ITEMS.register("silver",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> STEELING = ITEMS.register("steel",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> ULTRACITE = ITEMS.register("ultracite",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> ALUMINUGG = ITEMS.register("aluminugget",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> BTITANNUGG = ITEMS.register("btitannugget",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> LEADNUGG = ITEMS.register("leadnugget",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> SILVERNUGG = ITEMS.register("silvernugget",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));

    public static final RegistryObject<Item> STEELNUGG = ITEMS.register("steelnugget",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> CERAMIC = ITEMS.register("ceramic",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> ELECTRONUM = ITEMS.register("electronum",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> GLOWMASS = ITEMS.register("glowmass",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> LEATHERHARD = ITEMS.register("leatherhard",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> BBLOODLEAF = ITEMS.register("bbloodleafl",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> QUANTLEAF = ITEMS.register("quantumleaf",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> GAMMALEAF = ITEMS.register("gammaleaf",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC).tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> BLOODLEAF = ITEMS.register("nbloodleafi",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> BBLOODLEAF_ = ITEMS.register("bbloodleafl_",
            () -> new ItemNameBlockItem(ModBlocksClass.BBLOODLEAF_BUSH.get(), new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> QUANTLEAF_ = ITEMS.register("quantumleaf_",
            () -> new ItemNameBlockItem(ModBlocksClass.QUANTUMLEAF_BUSH.get(), new Item.Properties().rarity(Rarity.RARE).tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> GAMMALEAF_ = ITEMS.register("gammaleaf_",
            () -> new ItemNameBlockItem(ModBlocksClass.GAMMALEAF_BUSH.get(), new Item.Properties().rarity(Rarity.EPIC).tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> BLOODLEAF_ = ITEMS.register("nbloodleafi_",
            () -> new ItemNameBlockItem(ModBlocksClass.BLOODLEAF_BUSH.get(), new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> PRMT = ITEMS.register("pmt1",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> THISTLE = ITEMS.register("thistle_bud",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> BRAINFUNGUS = ITEMS.register("brainfungus",
            () -> new ModNamedItem(true, 0.2f, ModBlocksClass.BRAINFUNGUS.get(), new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> MINDFUNGUS = ITEMS.register("mindfungus",
            () -> new ModNamedItem(true, 0.5f, ModBlocksClass.MINDFUNGUS.get(), new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> ASHDUST = ITEMS.register("ashdust",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> DATURAN_ROOT = ITEMS.register("daturan_root",
            () -> new ModNamedItem(true, 0.2f, ModBlocksClass.DATURAN.get(), new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NASTY)));
    public static final RegistryObject<Item> AGAVE = ITEMS.register("agave_fruit",
            () -> new ModNamedItem(false, 0f, ModBlocksClass.AGAVE.get(), new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NASTY)));
    public static final RegistryObject<Item> NEOAGAVE = ITEMS.register("neoagave_fruit",
            () -> new ModNamedItem(false, 0.2f, ModBlocksClass.NEOAGAVE.get(), new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NASTY)));
    public static final RegistryObject<Item> PUNGA = ITEMS.register("punga_fruit",
            () -> new ModNamedItem(false, 0.0f, ModBlocksClass.PUNGA.get(), new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NASTY)));
    public static final RegistryObject<Item> XANDER_ROOT = ITEMS.register("xander_root",
            () -> new ModNamedItem(false, 0f, ModBlocksClass.ZANDER.get(), new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NASTY)));
    public static final RegistryObject<Item> NUKAROOT = ITEMS.register("nukaroot",
            () -> new ModNamedItem(true, 0.2f, ModBlocksClass.NUKAROOT.get(), new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NASTY)));
    public static final RegistryObject<Item> GINSENG_ROOT = ITEMS.register("ginsengroot",
            () -> new ModNamedItem(false, 0f, ModBlocksClass.GINSENG.get(), new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NASTY)));
    public static final RegistryObject<Item> CORAL_LEAF = ITEMS.register("coral_leaf",
            () -> new ModNamedItem(false, 0f, ModBlocksClass.CORALLEAF.get(), new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> PRISM_LEAF = ITEMS.register("prism_leafs",
            () -> new ModNamedItem(false, 0f, ModBlocksClass.PRISMLEAF.get(), new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> CAP = ITEMS.register("cap",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> DOGWOOD = ITEMS.register("dogwood",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));

    public static final RegistryObject<Item> NUCMAT = ITEMS.register("nuclear_mat",
            () -> new NuclearMaterialItem(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> PREWARMON = ITEMS.register("prewarmoney",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> RAWURAN = ITEMS.register("rawuran",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> LEADPLATE = ITEMS.register("leadplate",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> FILTER = ITEMS.register("filter",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));

    public static final RegistryObject<Item> RAWALUMI = ITEMS.register("raw_alumi",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> RAWBTITAN = ITEMS.register("raw_btitan",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> RAWLEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> RAWSILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));

    ///ADVANCED MATERIALS
    public static final RegistryObject<Item> ADVMAG = ITEMS.register("advmag",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> MAG = ITEMS.register("magnet",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> AIPROCC = ITEMS.register("aimproccesor",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> ADCAN = ITEMS.register("adncan",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> URANROD = ITEMS.register("uranrod",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CERPLATE = ITEMS.register("cerplate",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> ALUMING = ITEMS.register("alumicond",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COPPERWIRE = ITEMS.register("copperwires",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> LAMP = ITEMS.register("lamp",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> NUCHOLDER = ITEMS.register("nuc_holder",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ULTRBAR = ITEMS.register("ultrbar",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COPPERCOND = ITEMS.register("coppercond",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> REDUCER = ITEMS.register("reducer",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.COMMON)));



    ///FLUX
    public static final RegistryObject<Item> RAWCOBFLUX = ITEMS.register("undcobaltflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> COBFLUX = ITEMS.register("cobaltflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CLEANCOBFLUX = ITEMS.register("cleancobaltflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> RAWFLUOFLUX = ITEMS.register("undfluorflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> FLUOFLUX = ITEMS.register("fluorflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CLEANFLUOFLUX = ITEMS.register("cleanfluorflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> RAWSCARFLUX = ITEMS.register("undscarletflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> SCARFLUX = ITEMS.register("scarletflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CLEANSCARFLUX = ITEMS.register("cleanscarletflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> URANFLUX = ITEMS.register("uraniumflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> PUREURANFLUX = ITEMS.register("cleanuraniumflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RAWVIOLFLUX = ITEMS.register("undvioletflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> VIOLFLUX = ITEMS.register("violetflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CLEANVIOLFLUX = ITEMS.register("cleanvioletflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> BLACKFLUX = ITEMS.register("blackflux",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GIGAWHEATL = ITEMS.register("gigawheat",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> GIGAWHEAT_SEEDS = ITEMS.register("gigawheat_seeds",
            () -> new ItemNameBlockItem(ModBlocksClass.GIGAWHEAT.get(), (new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL).rarity(Rarity.RARE))));


    //    ///FOODS
    public static final RegistryObject<Item> NUKACOLA = ITEMS.register("nukacola",
        () -> new NukaColaItem(true, 0.08f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NUKACOLA)));
    public static final RegistryObject<Item> NUKAFRUTTI = ITEMS.register("nukafrutti",
            () -> new NukaColaItem(false, 0.09f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NUKAFRUTTI)));
    public static final RegistryObject<Item> CRACKBERRY = ITEMS.register("crackberry",
              () -> new ModNamedItem(true, 0.1f, ModBlocksClass.CRACKBERRY_BUSH.get(), new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.CRACKBERRY)));
    public static final RegistryObject<Item> BOMBBERRY = ITEMS.register("bombberry",
              () -> new ModNamedItem(true, 0.1f, ModBlocksClass.BOMBBERRY_BUSH.get(),new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.BOMBBERRY)));
    public static final RegistryObject<Item> MUTTFRUIT = ITEMS.register("muttfruit",
              () -> new ModNamedItem(false, 0.0f, ModBlocksClass.MUTTFRUIT_BUSH.get(),new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.MUTTFRUIT)));
    public static final RegistryObject<Item> FUSFRUIT = ITEMS.register("fusionfruit",
              () -> new ModNamedItem(true, 0.2f, ModBlocksClass.FUSFRUIT_BUSH.get(),new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.FUSFRUIT)));
    public static final RegistryObject<Item> SITTBEAN = ITEMS.register("sittbean",
              () -> new ModNamedItem(false, 0.0f, ModBlocksClass.SITTBEAN_BUSH.get(),new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.SITTBEAN)));
    public static final RegistryObject<Item> NEUTRONROD = ITEMS.register("neutronpod",
              () -> new ModNamedItem(true, 0.3f, ModBlocksClass.NEUTRON_BUSH.get(),new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NEUTRONROD)));
    public static final RegistryObject<Item> WILDTATO = ITEMS.register("wildtato",
              () -> new ModNamedItem(false, 0.0f, ModBlocksClass.TATO.get(), new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.WILDTATO)));
    public static final RegistryObject<Item> IRRADBEETROOT = ITEMS.register("irrad_beetroot",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(Foods.BEETROOT)));
    public static final RegistryObject<Item> UFCARROT = ITEMS.register("ufcarrot",
            () -> new ModNamedItem(true, 0.2f, ModBlocksClass.UFCARROT.get(), new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.WILDTATO)));
    public static final RegistryObject<Item> IRRADSEED = ITEMS.register("irradb_seed",
            () -> new BlockItem(ModBlocksClass.IRRADROOT.get(), new Item.Properties().tab(ModItemTabs.NUKA_MATERIAL)));
    public static final RegistryObject<Item> SPOILD_TATO = ITEMS.register("spoiled_tato",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.SPOILED)));
    public static final RegistryObject<Item> STARBERRY = ITEMS.register("starberry",
              () -> new ModNamedItem(false, 0.0f, ModBlocksClass.STARBERRY.get(),new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.STARBERRY)));
    public static final RegistryObject<Item> CRANBERRY = ITEMS.register("cranberry",
              () -> new ModNamedItem(false, 0.1f, ModBlocksClass.CRANBERRY.get(),new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.CRANBERRY)));
    public static final RegistryObject<Item> GOLD_CRANBERRY = ITEMS.register("gold_cranberry",
            () -> new ModNamedItem(false, 0.3f, ModBlocksClass.GOLD_CRANBERRY.get(),new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.CRANBERRY)));
    public static final RegistryObject<Item> APPLESP = ITEMS.register("applesp",
        () -> new RadFoodItem(true, 0.5f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.APPLESP)));
    public static final RegistryObject<Item> CRAM = ITEMS.register("cram",
              () -> new RadFoodItem(true, 0.45f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.CRAM)));
    public static final RegistryObject<Item> NUKAMEL = ITEMS.register("nukamelon_piece",
            () -> new RadFoodItem(true, 0.55f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.NUKAMELON)));
    public static final RegistryObject<Item> CHIPS = ITEMS.register("chips",
            () -> new RadFoodItem(true, 0.35f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.CHIPS)));
    public static final RegistryObject<Item> FCAKES = ITEMS.register("fcakes",
            () -> new RadFoodItem(true, 0.4f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.FCAKES)));
    public static final RegistryObject<Item> MCCHESSE = ITEMS.register("maccheese",
            () -> new RadFoodItem(true, 0.3f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.MCCHESSE)));
    public static final RegistryObject<Item> PURES = ITEMS.register("pures",
            () -> new RadFoodItem(true, 0.2f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.PURES)));
    public static final RegistryObject<Item> COTTONCANDY = ITEMS.register("cottoncandy",
            () -> new RadFoodItem(false, 0.0f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.COTTONCANDY)));
    public static final RegistryObject<Item> BUBBLEAPPLE = ITEMS.register("bubbleapple",
            () -> new RadFoodItem(false, 0.0f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.BUBBLEAPPLE)));  //    public static final RegistryObject<Item> ASTER_TEA = ITEMS.register("aster_tea", () -> new TeaItem(new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.TEA)));
    public static final RegistryObject<Item> ASTER_TEA = ITEMS.register("aster_tea",
            () -> new TeaItem(true, 0.14f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.TEA)));
    public static final RegistryObject<Item> SWEET_ASTER_TEA = ITEMS.register("sweet_aster_tea",
            () -> new TeaItem(false, 0.0f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.TEA)));
    public static final RegistryObject<Item> ASH_TEA = ITEMS.register("ash_tea",
            () -> new TeaItem(true, 0.1f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.TEA)));
    public static final RegistryObject<Item> SWEET_ASH_TEA = ITEMS.register("sweet_ash_tea",
            () -> new TeaItem(false, 0.0f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.TEA)));
    public static final RegistryObject<Item> THISTLE_TEA = ITEMS.register("thistle_tea",
            () -> new TeaItem(true, 0.2f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.THISTLE)));
    public static final RegistryObject<Item> SOOT_TEA = ITEMS.register("soot_tea",
            () -> new TeaItem(false, 0.1f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.TEA)));
    public static final RegistryObject<Item> VEGSOUP = ITEMS.register("vegsoup",
            () -> new BowlFoodItem(new Item.Properties().tab(ModItemTabs.NUKA_FOOD).stacksTo(1).food(ModFoodClass.VEGSOUP)));
    public static final RegistryObject<Item> TATOSALAD = ITEMS.register("tato_salad",
            () -> new BowlFoodItem(new Item.Properties().tab(ModItemTabs.NUKA_FOOD).stacksTo(1).food(ModFoodClass.TATOSALAD)));
    public static final RegistryObject<Item> SITTSOUP = ITEMS.register("sittsoup",
            () -> new BowlFoodItem(new Item.Properties().tab(ModItemTabs.NUKA_FOOD).stacksTo(1).food(ModFoodClass.SITTSOUP)));
    public static final RegistryObject<Item> SITTPUREE = ITEMS.register("sittpuree",
            () -> new BowlFoodItem(new Item.Properties().tab(ModItemTabs.NUKA_FOOD).stacksTo(1).food(ModFoodClass.SITTPUREE)));
    public static final RegistryObject<Item> FMSOUP = ITEMS.register("firemushsoup",
            () -> new SpecialSoupItem(false, 0.0f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).stacksTo(1).food(ModFoodClass.FMSOUP)));
    public static final RegistryObject<Item> FMPUREE = ITEMS.register("firemushpuree",
            () -> new SpecialSoupItem(false, 0.0f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).stacksTo(1).food(ModFoodClass.FMPUREE)));

//
//
//    //MEDICINE ITEMS
      public static final RegistryObject<Item> STIMPAK = ITEMS.register("stimpak",
        () -> new StimpakItem(new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.MED)));
      public static final RegistryObject<Item> SUPER_STIMPAK = ITEMS.register("super_stimpak",
              () -> new StimpakItem(new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.MED)));
      public static final RegistryObject<Item> RADAWAY = ITEMS.register("radaway",
              () -> new MedicineItem(false, 4.0f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.MED)));
      public static final RegistryObject<Item> GLOWBLOOD = ITEMS.register("glowblood",
              () -> new MedicineItem(true, 4.0f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.MED)));
      public static final RegistryObject<Item> RADX = ITEMS.register("radx",
              () -> new MedicineItem(false, 0.0f, new Item.Properties().tab(ModItemTabs.NUKA_FOOD).food(ModFoodClass.MED)));



    public static final RegistryObject<Item> ROUND10MM = ITEMS.register("round10mm",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> ROUND38 = ITEMS.register("round38",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> ROUND45 = ITEMS.register("round45",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> ROUND5MM = ITEMS.register("round5mm",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> ROUND44 = ITEMS.register("round44",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> ROUND50 = ITEMS.register("round50",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> ROUND380 = ITEMS.register("round380",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> ROUND556 = ITEMS.register("round556",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> SHOTSHELL = ITEMS.register("shotshell",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> ROUND127 = ITEMS.register("round127",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> ROUND22 = ITEMS.register("round22",
            () -> new Item(new Item.Properties().tab(ModItemTabs.NUKA_EQUIP)));

//Others
    public static final RegistryObject<Item> PIP_BOY_D = ITEMS.register("pipboy_d",
        () -> new PipBoyItem("pipboy_d", new Item.Properties().tab(ModItemTabs.NUKA_EQUIP).stacksTo(1)));
    public static final RegistryObject<Item> PIMPBOY = ITEMS.register("pimpboy",
            () -> new PipBoyItem("pimpboy", new Item.Properties().tab(ModItemTabs.NUKA_EQUIP).stacksTo(1)));


    public static final RegistryObject<Item> HOLO_1CC = ITEMS.register("holotape_white",
            () -> new ColoredHolotapeItem("white", new Item.Properties().tab(ModItemTabs.NUKA_EQUIP).rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> HOLO_1D2 = ITEMS.register("holotape_green",
            () -> new ColoredHolotapeItem("green", new Item.Properties().tab(ModItemTabs.NUKA_EQUIP).rarity(Rarity.COMMON)));

    //Power armor
    public static final RegistryObject<Item> FUSION_CONE = ITEMS.register("fusion_core", () ->
            new FusionCoreItem(new Item.Properties()
                    .stacksTo(64)
                    .durability(100000)
                    .tab(ModItemTabs.NUKA_MATERIAL)));

    public static final RegistryObject<Item> T45_HELMET = ITEMS.register("t45_helmet", () ->
            new ArmorPart(T45, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> T45_BODY = ITEMS.register("t45_body", () ->
            new ArmorPart(T45, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> T45_RIGHT_ARM = ITEMS.register("t45_right_arm", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T45_LEFT_ARM = ITEMS.register("t45_left_arm", () ->
            new ArmorPart(T45, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T45_RIGHT_LEG = ITEMS.register("t45_right_leg", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> T45_LEFT_LEG = ITEMS.register("t45_left_leg", () ->
            new ArmorPart(T45, ChassisPart.LEFT_LEG_ARMOR));


    public static final RegistryObject<Item> T51_HELMET = ITEMS.register("t51_helmet", () ->
            new ArmorPart(T45, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> T51_BODY = ITEMS.register("t51_body", () ->
            new ArmorPart(T45, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> T51_RIGHT_ARM = ITEMS.register("t51_right_arm", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T51_LEFT_ARM = ITEMS.register("t51_left_arm", () ->
            new ArmorPart(T45, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T51_RIGHT_LEG = ITEMS.register("t51_right_leg", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> T51_LEFT_LEG = ITEMS.register("t51_left_leg", () ->
            new ArmorPart(T45, ChassisPart.LEFT_LEG_ARMOR));

    public static final RegistryObject<Item> T60_HELMET = ITEMS.register("t60_helmet", () ->
            new ArmorPart(T45, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> T60_BODY = ITEMS.register("t60_body", () ->
            new ArmorPart(T45, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> T60_RIGHT_ARM = ITEMS.register("t60_right_arm", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T60_LEFT_ARM = ITEMS.register("t60_left_arm", () ->
            new ArmorPart(T45, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> T60_RIGHT_LEG = ITEMS.register("t60_right_leg", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> T60_LEFT_LEG = ITEMS.register("t60_left_leg", () ->
            new ArmorPart(T45, ChassisPart.LEFT_LEG_ARMOR));

    public static final RegistryObject<Item> RAIDER_HELMET = ITEMS.register("raider_helmet", () ->
            new ArmorPart(T45, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> RAIDER_BODY = ITEMS.register("raider_body", () ->
            new ArmorPart(T45, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> RAIDER_RIGHT_ARM = ITEMS.register("raider_right_arm", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> RAIDER_LEFT_ARM = ITEMS.register("raider_left_arm", () ->
            new ArmorPart(T45, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> RAIDER_RIGHT_LEG = ITEMS.register("raider_right_leg", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> RAIDER_LEFT_LEG = ITEMS.register("raider_left_leg", () ->
            new ArmorPart(T45, ChassisPart.LEFT_LEG_ARMOR));

    public static final RegistryObject<Item> EXC_HELMET = ITEMS.register("exc_helmet", () ->
            new ArmorPart(T45, ChassisPart.HELMET));

    public static final RegistryObject<ArmorPart> EXC_BODY = ITEMS.register("exc_body", () ->
            new ArmorPart(T45, ChassisPart.BODY_ARMOR));

    public static final RegistryObject<ArmorPart> EXC_RIGHT_ARM = ITEMS.register("exc_right_arm", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> EXC_LEFT_ARM = ITEMS.register("exc_left_arm", () ->
            new ArmorPart(T45, ChassisPart.LEFT_ARM_ARMOR));

    public static final RegistryObject<ArmorPart> EXC_RIGHT_LEG = ITEMS.register("exc_right_leg", () ->
            new ArmorPart(T45, ChassisPart.RIGHT_LEG_ARMOR));

    public static final RegistryObject<ArmorPart> EXC_LEFT_LEG = ITEMS.register("exc_left_leg", () ->
            new ArmorPart(T45, ChassisPart.LEFT_LEG_ARMOR));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
