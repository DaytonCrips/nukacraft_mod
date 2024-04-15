package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.client.helpers.ModTiers;
import com.nukateam.nukacraft.common.foundation.items.misc.SimpleMeleeWeapon;
import com.nukateam.nukacraft.common.foundation.items.сonsumables.*;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import com.nukateam.nukacraft.common.registery.ModItemTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.nukateam.nukacraft.common.registery.ModItemTabs.NUKA_MATERIAL;

public class ModFood {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    //FOOD
    public static final RegistryObject<Item> MEGASLOTHFUNGI = ITEMS.register("megasloth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BBLIGHT = ITEMS.register("bblight",
            () -> new Item(new Item.Properties()));
    
    public static final RegistryObject<Item> NUKACOLA = ITEMS.register("nukacola",
            () -> new NukaColaItem(0.08f, 10, new Item.Properties().food(ModFoodTypes.NUKACOLA)));
    public static final RegistryObject<Item> NUKAFRUTTI = ITEMS.register("nukafrutti",
            () -> new NukaColaItem(-0.09f, 10, new Item.Properties().food(ModFoodTypes.NUKAFRUTTI)));
    public static final RegistryObject<Item> CRACKBERRY = ITEMS.register("crackberry",
            () -> new RadNamedItem(-0.1f, ModBlocks.CRACKBERRY_BUSH.get(), new Item.Properties().food(ModFoodTypes.CRACKBERRY)));
    public static final RegistryObject<Item> BOMBBERRY = ITEMS.register("bombberry",
            () -> new RadNamedItem(-0.1f, ModBlocks.BOMBBERRY_BUSH.get(), new Item.Properties().food(ModFoodTypes.BOMBBERRY)));
    public static final RegistryObject<Item> MUTTFRUIT = ITEMS.register("muttfruit",
            () -> new RadNamedItem(0.0f, ModBlocks.MUTTFRUIT_BUSH.get(), new Item.Properties().food(ModFoodTypes.MUTTFRUIT)));
    public static final RegistryObject<Item> FUSFRUIT = ITEMS.register("fusionfruit",
            () -> new RadNamedItem(-0.2f, ModBlocks.FUSFRUIT_BUSH.get(), new Item.Properties().food(ModFoodTypes.FUSFRUIT)));
    public static final RegistryObject<Item> SITTBEAN = ITEMS.register("sittbean",
            () -> new RadNamedItem(0.0f, ModBlocks.SITTBEAN_BUSH.get(), new Item.Properties().food(ModFoodTypes.SITTBEAN)));
    public static final RegistryObject<Item> NEUTRONROD = ITEMS.register("neutronpod",
            () -> new RadNamedItem(0.3f, ModBlocks.NEUTRON_BUSH.get(), new Item.Properties().food(ModFoodTypes.NEUTRONROD)));
    public static final RegistryObject<Item> WILDTATO = ITEMS.register("wildtato",
            () -> new RadNamedItem(0.0f, ModBlocks.TATO.get(), new Item.Properties().food(ModFoodTypes.WILDTATO)));
    public static final RegistryObject<Item> IRRADBEETROOT = ITEMS.register("irrad_beetroot",
            () -> new Item(new Item.Properties().food(Foods.BEETROOT)));
    public static final RegistryObject<Item> UFCARROT = ITEMS.register("ufcarrot",
            () -> new RadNamedItem(0.2f, ModBlocks.UFCARROT.get(), new Item.Properties().food(ModFoodTypes.WILDTATO)));
    public static final RegistryObject<Item> IRRADSEED = ITEMS.register("irradb_seed",
            () -> new BlockItem(ModBlocks.IRRADROOT.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPOILD_TATO = ITEMS.register("spoiled_tato",
            () -> new Item(new Item.Properties().food(ModFoodTypes.SPOILED)));
    public static final RegistryObject<Item> STARBERRY = ITEMS.register("starberry",
            () -> new RadNamedItem(0.0f, ModBlocks.STARBERRY.get(), new Item.Properties().food(ModFoodTypes.STARBERRY)));
    public static final RegistryObject<Item> CRANBERRY = ITEMS.register("cranberry",
            () -> new RadNamedItem(-0.1f, ModBlocks.CRANBERRY.get(), new Item.Properties().food(ModFoodTypes.CRANBERRY)));
    public static final RegistryObject<Item> GOLD_CRANBERRY = ITEMS.register("gold_cranberry",
            () -> new RadNamedItem(-0.3f, ModBlocks.GOLD_CRANBERRY.get(), new Item.Properties().food(ModFoodTypes.CRANBERRY)));
    public static final RegistryObject<Item> APPLESP = ITEMS.register("applesp",
            () -> new RadFoodItem(0.5f, new Item.Properties().food(ModFoodTypes.APPLESP)));
    public static final RegistryObject<Item> CRAM = ITEMS.register("cram",
            () -> new RadFoodItem(0.45f, new Item.Properties().food(ModFoodTypes.CRAM)));
    public static final RegistryObject<Item> NUKAMEL = ITEMS.register("nukamelon_piece",
            () -> new RadFoodItem(0.55f, new Item.Properties().food(ModFoodTypes.NUKAMELON)));
    public static final RegistryObject<Item> CHIPS = ITEMS.register("chips",
            () -> new RadFoodItem(0.35f, new Item.Properties().food(ModFoodTypes.CHIPS)));
    public static final RegistryObject<Item> FCAKES = ITEMS.register("fcakes",
            () -> new RadFoodItem(0.4f, new Item.Properties().food(ModFoodTypes.FCAKES)));
    public static final RegistryObject<Item> MCCHESSE = ITEMS.register("maccheese",
            () -> new RadFoodItem(0.3f, new Item.Properties().food(ModFoodTypes.MCCHESSE)));
    public static final RegistryObject<Item> RDCMEAT = ITEMS.register("raw_dcmeat",
            () -> new RadFoodItem(0.3f, new Item.Properties().food(ModFoodTypes.DEATHMEAT)));
    public static final RegistryObject<Item> RAWROACHMEAT = ITEMS.register("raw_radroachmeat",
            () -> new RadFoodItem(0.6f, new Item.Properties().food(ModFoodTypes.ROACHMEAT)));
    public static final RegistryObject<Item> CROACHMEAT = ITEMS.register("c_radroachmeat",
            () -> new RadFoodItem(0.1f, new Item.Properties().food(ModFoodTypes.CROACHMEAT)));
    public static final RegistryObject<Item> CDCMEAT = ITEMS.register("c_dcmeat",
            () -> new RadFoodItem(0.1f, new Item.Properties().food(ModFoodTypes.CDEATHMEAT)));
    public static final RegistryObject<Item> BRAHMINMEAT = ITEMS.register("raw_brahminmeat",
            () -> new RadFoodItem(0.2f, new Item.Properties().food(ModFoodTypes.RAWBRMEAT)));
    public static final RegistryObject<Item> CBRAHMINMEAT = ITEMS.register("c_brahminmeat",
            () -> new RadFoodItem(0f, new Item.Properties().food(ModFoodTypes.CBRMEAT)));
    public static final RegistryObject<Item> PURES = ITEMS.register("pures",
            () -> new RadFoodItem(0.2f, new Item.Properties().food(ModFoodTypes.PURES)));
    public static final RegistryObject<Item> COTTONCANDY = ITEMS.register("cottoncandy",
            () -> new RadFoodItem(0.0f, new Item.Properties().food(ModFoodTypes.COTTONCANDY)));
    public static final RegistryObject<Item> BUBBLEAPPLE = ITEMS.register("bubbleapple",
            () -> new BubbleAppleItem(0.0f, new Item.Properties().food(ModFoodTypes.BUBBLEAPPLE)));

    public static final RegistryObject<Item> ASTER_TEA = ITEMS.register("aster_tea",
            () -> new TeaItem(0.14f, () -> new MobEffectInstance(MobEffects.REGENERATION, 10 * 20),
                    new Item.Properties().food(ModFoodTypes.TEA)));
    public static final RegistryObject<Item> SWEET_ASTER_TEA = ITEMS.register("sweet_aster_tea",
            () -> new TeaItem(0.0f, () -> new MobEffectInstance(MobEffects.REGENERATION, 10 * 20),
                    new Item.Properties().food(ModFoodTypes.TEA)));
    public static final RegistryObject<Item> ASH_TEA = ITEMS.register("ash_tea",
            () -> new TeaItem(0.1f, () -> new MobEffectInstance(MobEffects.DIG_SPEED, 10 * 20),
                    new Item.Properties().food(ModFoodTypes.TEA)));
    public static final RegistryObject<Item> SWEET_ASH_TEA = ITEMS.register("sweet_ash_tea",
            () -> new TeaItem(0.0f, () -> new MobEffectInstance(MobEffects.DIG_SPEED, 10 * 20),
                    new Item.Properties().food(ModFoodTypes.TEA)));
    public static final RegistryObject<Item> THISTLE_TEA = ITEMS.register("thistle_tea",
            () -> new TeaItem(0.2f, null, new Item.Properties().food(ModFoodTypes.THISTLE)));
    public static final RegistryObject<Item> SOOT_TEA = ITEMS.register("soot_tea",
            () -> new TeaItem(0.1f, () -> new MobEffectInstance(MobEffects.DIG_SPEED, 10 * 20),
                    new Item.Properties().food(ModFoodTypes.TEA)));

    public static final RegistryObject<Item> VEGSOUP = ITEMS.register("vegsoup",
            () -> new SteelBowlItem(new Item.Properties().stacksTo(1).food(ModFoodTypes.VEGSOUP)));
    public static final RegistryObject<Item> TATOSALAD = ITEMS.register("tato_salad",
            () -> new SteelBowlItem(new Item.Properties().stacksTo(1).food(ModFoodTypes.TATOSALAD)));
    public static final RegistryObject<Item> SITTSOUP = ITEMS.register("sittsoup",
            () -> new SteelBowlItem(new Item.Properties().stacksTo(1).food(ModFoodTypes.SITTSOUP)));
    public static final RegistryObject<Item> SITTPUREE = ITEMS.register("sittpuree",
            () -> new SteelBowlItem(new Item.Properties().stacksTo(1).food(ModFoodTypes.SITTPUREE)));

    public static final RegistryObject<Item> FMSOUP = ITEMS.register("firemushsoup",
            () -> new SpecialSoupItem(0.0f, () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10 * 20),
                    new Item.Properties().stacksTo(1).food(ModFoodTypes.FMSOUP)));
    public static final RegistryObject<Item> FMPUREE = ITEMS.register("firemushpuree",
            () -> new SpecialSoupItem(0.0f, () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10 * 20), new Item.Properties().stacksTo(1).food(ModFoodTypes.FMPUREE)));
//

    //////////MEDICINE ITEMS
    public static final RegistryObject<Item> STIMPAK = ITEMS.register("stimpak",
            () -> new StimpakItem(5, new Item.Properties().food(ModFoodTypes.MED)));
    public static final RegistryObject<Item> SUPER_STIMPAK = ITEMS.register("super_stimpak",
            () -> new StimpakItem(8, new Item.Properties().food(ModFoodTypes.MED)));
    public static final RegistryObject<Item> RADAWAY = ITEMS.register("radaway",
            () -> new RadItem(-4.0f, new Item.Properties().food(ModFoodTypes.MED)));
    public static final RegistryObject<Item> GLOWBLOOD = ITEMS.register("glowblood",
            () -> new GlowbloodItem(4.0f, new Item.Properties().food(ModFoodTypes.MED)));
    public static final RegistryObject<Item> RADX = ITEMS.register("radx",
            () -> new RadXItem(100, new Item.Properties().food(ModFoodTypes.MED)));

    //Others

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
