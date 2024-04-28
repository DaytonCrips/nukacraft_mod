package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.annotation.DataGen;
import com.nukateam.nukacraft.common.foundation.items.consumables.*;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFood {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    //FOOD
    @DataGen
    public static final RegistryObject<Item> MEGASLOTHFUNGI = ITEMS.register("megasloth",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> BRIGHT_BLIGHT = ITEMS.register("bblight",
            () -> new Item(new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> NUKA_COLA = ITEMS.register("nuka_cola",
            () -> new NukaColaItem(0.08f, 10, new Item.Properties().food(ModFoodTypes.NUKACOLA)));
    @DataGen
    public static final RegistryObject<Item> NUKA_FRUTTI = ITEMS.register("nuka_frutti",
            () -> new NukaColaItem(-0.09f, 10, new Item.Properties().food(ModFoodTypes.NUKAFRUTTI)));
    @DataGen
    public static final RegistryObject<Item> CRACKBERRY = ITEMS.register("crackberry",
            () -> new RadNamedItem(-0.1f, ModBlocks.CRACKBERRY_BUSH.get(), new Item.Properties().food(ModFoodTypes.CRACKBERRY)));
    @DataGen
    public static final RegistryObject<Item> BOMBBERRY = ITEMS.register("bombberry",
            () -> new RadNamedItem(-0.1f, ModBlocks.BOMBBERRY_BUSH.get(), new Item.Properties().food(ModFoodTypes.BOMBBERRY)));
    @DataGen
    public static final RegistryObject<Item> MUTTFRUIT = ITEMS.register("muttfruit",
            () -> new RadNamedItem(0.0f, ModBlocks.MUTTFRUIT_BUSH.get(), new Item.Properties().food(ModFoodTypes.MUTTFRUIT)));
    @DataGen
    public static final RegistryObject<Item> FUSION_FRUIT = ITEMS.register("fusion_fruit",
            () -> new RadNamedItem(-0.2f, ModBlocks.FUSFRUIT_BUSH.get(), new Item.Properties().food(ModFoodTypes.FUSFRUIT)));
    @DataGen
    public static final RegistryObject<Item> SILT_BEAN = ITEMS.register("silt_bean",
            () -> new RadNamedItem(0.0f, ModBlocks.SILT_BEAN_BUSH.get(), new Item.Properties().food(ModFoodTypes.SILT_BEAN)));
    @DataGen
    public static final RegistryObject<Item> NEUTRON_ROD = ITEMS.register("neutron_rod",
            () -> new RadNamedItem(0.3f, ModBlocks.NEUTRON_BUSH.get(), new Item.Properties().food(ModFoodTypes.NEUTRONROD)));
    @DataGen
    public static final RegistryObject<Item> WILD_TATO = ITEMS.register("wild_tato",
            () -> new RadNamedItem(0.0f, ModBlocks.TATO.get(), new Item.Properties().food(ModFoodTypes.WILDTATO)));
    @DataGen
    public static final RegistryObject<Item> IRRADIATED_BEETROOT = ITEMS.register("irradiated_beetroot",
            () -> new Item(new Item.Properties().food(Foods.BEETROOT)));
    @DataGen
    public static final RegistryObject<Item> ULTRAVIOLET_CARROT = ITEMS.register("ultraviolet_carrot",
            () -> new RadNamedItem(0.2f, ModBlocks.UFCARROT.get(), new Item.Properties().food(ModFoodTypes.WILDTATO)));
    @DataGen
    public static final RegistryObject<Item> IRRADIATED_BEETROOT_SEED = ITEMS.register("irradiated_beetroot_seed",
            () -> new BlockItem(ModBlocks.IRRADROOT.get(), new Item.Properties()));
    @DataGen
    public static final RegistryObject<Item> SPOILED_TATO = ITEMS.register("spoiled_tato",
            () -> new Item(new Item.Properties().food(ModFoodTypes.SPOILED)));
    @DataGen
    public static final RegistryObject<Item> STARBERRY = ITEMS.register("starlight_berry",
            () -> new RadNamedItem(0.0f, ModBlocks.STARBERRY.get(), new Item.Properties().food(ModFoodTypes.STARBERRY)));
    @DataGen
    public static final RegistryObject<Item> CRANBERRY = ITEMS.register("cranberry",
            () -> new RadNamedItem(-0.1f, ModBlocks.CRANBERRY.get(), new Item.Properties().food(ModFoodTypes.CRANBERRY)));
    @DataGen
    public static final RegistryObject<Item> GOLD_CRANBERRY = ITEMS.register("gold_cranberry",
            () -> new RadNamedItem(-0.3f, ModBlocks.GOLD_CRANBERRY.get(), new Item.Properties().food(ModFoodTypes.CRANBERRY)));
    @DataGen
    public static final RegistryObject<Item> APPLESP = ITEMS.register("dandy_boy_apples",
            () -> new RadFoodItem(0.5f, new Item.Properties().food(ModFoodTypes.APPLESP)));
    @DataGen
    public static final RegistryObject<Item> CRAM = ITEMS.register("cram",
            () -> new RadFoodItem(0.45f, new Item.Properties().food(ModFoodTypes.CRAM)));
    @DataGen
    public static final RegistryObject<Item> NUKAMEL = ITEMS.register("nukamelon_piece",
            () -> new RadFoodItem(0.55f, new Item.Properties().food(ModFoodTypes.NUKAMELON)));
    @DataGen
    public static final RegistryObject<Item> CHIPS = ITEMS.register("chips",
            () -> new RadFoodItem(0.35f, new Item.Properties().food(ModFoodTypes.CHIPS)));
    @DataGen
    public static final RegistryObject<Item> CAKES = ITEMS.register("cakes",
            () -> new RadFoodItem(0.4f, new Item.Properties().food(ModFoodTypes.FCAKES)));
    @DataGen
    public static final RegistryObject<Item> BLAMCO = ITEMS.register("blamco",
            () -> new RadFoodItem(0.3f, new Item.Properties().food(ModFoodTypes.MCCHESSE)));
    @DataGen
    public static final RegistryObject<Item> RAW_DEADCLAW_MEAT = ITEMS.register("raw_deadclaw_meat",
            () -> new RadFoodItem(0.3f, new Item.Properties().food(ModFoodTypes.DEATHMEAT)));
    @DataGen
    public static final RegistryObject<Item> RAW_RADROACH_MEAT = ITEMS.register("raw_radroach_meat",
            () -> new RadFoodItem(0.6f, new Item.Properties().food(ModFoodTypes.ROACHMEAT)));
    @DataGen
    public static final RegistryObject<Item> COOKED_RADROACH_MEAT = ITEMS.register("cooked_radroach_meat",
            () -> new RadFoodItem(0.1f, new Item.Properties().food(ModFoodTypes.CROACHMEAT)));
    @DataGen
    public static final RegistryObject<Item> COOKED_DEADCLAW_MEAT = ITEMS.register("cooked_deadclaw_meat",
            () -> new RadFoodItem(0.1f, new Item.Properties().food(ModFoodTypes.CDEATHMEAT)));
    @DataGen
    public static final RegistryObject<Item> RAW_BRAHMIN_MEAT = ITEMS.register("raw_brahmin_meat",
            () -> new RadFoodItem(0.2f, new Item.Properties().food(ModFoodTypes.RAWBRMEAT)));
    @DataGen
    public static final RegistryObject<Item> COOKED_BRAHMIN_MEAT = ITEMS.register("cooked_brahmin_meat",
            () -> new RadFoodItem(0f, new Item.Properties().food(ModFoodTypes.CBRMEAT)));
    @DataGen
    public static final RegistryObject<Item> PURES = ITEMS.register("pures",
            () -> new RadFoodItem(0.2f, new Item.Properties().food(ModFoodTypes.PURES)));
    @DataGen
    public static final RegistryObject<Item> COTTON_CANDY = ITEMS.register("cotton_candy",
            () -> new RadFoodItem(0.0f, new Item.Properties().food(ModFoodTypes.COTTONCANDY)));
    @DataGen
    public static final RegistryObject<Item> BUBBLE_APPLE = ITEMS.register("bubble_apple",
            () -> new BubbleAppleItem(0.0f, new Item.Properties().food(ModFoodTypes.BUBBLEAPPLE)));

    @DataGen
    public static final RegistryObject<Item> ASTER_TEA = ITEMS.register("aster_tea",
            () -> new TeaItem(0.14f, () -> new MobEffectInstance(MobEffects.REGENERATION, 10 * 20),
                    new Item.Properties().food(ModFoodTypes.TEA)));
    @DataGen
    public static final RegistryObject<Item> SWEET_ASTER_TEA = ITEMS.register("sweet_aster_tea",
            () -> new TeaItem(0.0f, () -> new MobEffectInstance(MobEffects.REGENERATION, 10 * 20),
                    new Item.Properties().food(ModFoodTypes.TEA)));
    @DataGen
    public static final RegistryObject<Item> ASH_TEA = ITEMS.register("ash_tea",
            () -> new TeaItem(0.1f, () -> new MobEffectInstance(MobEffects.DIG_SPEED, 10 * 20),
                    new Item.Properties().food(ModFoodTypes.TEA)));
    @DataGen
    public static final RegistryObject<Item> SWEET_ASH_TEA = ITEMS.register("sweet_ash_tea",
            () -> new TeaItem(0.0f, () -> new MobEffectInstance(MobEffects.DIG_SPEED, 10 * 20),
                    new Item.Properties().food(ModFoodTypes.TEA)));
    @DataGen
    public static final RegistryObject<Item> THISTLE_TEA = ITEMS.register("thistle_tea",
            () -> new TeaItem(0.2f, null, new Item.Properties().food(ModFoodTypes.THISTLE)));
    @DataGen
    public static final RegistryObject<Item> SOOT_TEA = ITEMS.register("soot_tea",
            () -> new TeaItem(0.1f, () -> new MobEffectInstance(MobEffects.DIG_SPEED, 10 * 20),
                    new Item.Properties().food(ModFoodTypes.TEA)));

    @DataGen
    public static final RegistryObject<Item> VEGETABLE_SOUP = ITEMS.register("vegetable_soup",
            () -> new SteelBowlItem(new Item.Properties().stacksTo(1).food(ModFoodTypes.VEGSOUP)));
    @DataGen
    public static final RegistryObject<Item> TATO_SALAD = ITEMS.register("tato_salad",
            () -> new SteelBowlItem(new Item.Properties().stacksTo(1).food(ModFoodTypes.TATOSALAD)));
    @DataGen
    public static final RegistryObject<Item> SILT_SOUP = ITEMS.register("silt_soup",
            () -> new SteelBowlItem(new Item.Properties().stacksTo(1).food(ModFoodTypes.SITTSOUP)));
    @DataGen
    public static final RegistryObject<Item> SITTPUREE = ITEMS.register("silt_puree",
            () -> new SteelBowlItem(new Item.Properties().stacksTo(1).food(ModFoodTypes.SITTPUREE)));

    @DataGen
    public static final RegistryObject<Item> FMSOUP = ITEMS.register("firemushsoup",
            () -> new SpecialSoupItem(0.0f, () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10 * 20),
                    new Item.Properties().stacksTo(1).food(ModFoodTypes.FMSOUP)));
    @DataGen
    public static final RegistryObject<Item> FMPUREE = ITEMS.register("firemushpuree",
            () -> new SpecialSoupItem(0.0f, () -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10 * 20), new Item.Properties().stacksTo(1).food(ModFoodTypes.FMPUREE)));
//

    @DataGen
    public static final RegistryObject<Item> DATURAN_ROOT = ITEMS.register("daturan_root",
            () -> new RadNamedItem(0.2f, ModBlocks.DATURAN.get(), new Item.Properties().food(ModFoodTypes.NASTY)));
    @DataGen
    public static final RegistryObject<Item> AGAVE = ITEMS.register("agave_fruit",
            () -> new RadNamedItem(0f, ModBlocks.AGAVE.get(), new Item.Properties().food(ModFoodTypes.NASTY)));
    @DataGen
    public static final RegistryObject<Item> NEOAGAVE = ITEMS.register("neoagave_fruit",
            () -> new RadNamedItem(-0.2f, ModBlocks.NEOAGAVE.get(), new Item.Properties().food(ModFoodTypes.NASTY)));
    @DataGen
    public static final RegistryObject<Item> PUNGA = ITEMS.register("punga_fruit",
            () -> new RadNamedItem(0.0f, ModBlocks.PUNGA.get(), new Item.Properties().food(ModFoodTypes.NASTY)));
    @DataGen
    public static final RegistryObject<Item> XANDER_ROOT = ITEMS.register("xander_root",
            () -> new RadNamedItem(0f, ModBlocks.ZANDER.get(), new Item.Properties().food(ModFoodTypes.NASTY)));
    @DataGen
    public static final RegistryObject<Item> NUKAROOT = ITEMS.register("nukaroot",
            () -> new RadNamedItem(-0.2f, ModBlocks.NUKAROOT.get(), new Item.Properties().food(ModFoodTypes.NASTY)));
    @DataGen
    public static final RegistryObject<Item> GINSENG_ROOT = ITEMS.register("ginsengroot",
            () -> new RadNamedItem(0f, ModBlocks.GINSENG.get(), new Item.Properties().food(ModFoodTypes.NASTY)));

    //////////MEDICINE ITEMS
    @DataGen
    public static final RegistryObject<Item> STIMPAK = ITEMS.register("stimpak",
            () -> new StimpakItem(5, new Item.Properties().food(ModFoodTypes.MED)));
    @DataGen
    public static final RegistryObject<Item> SUPER_STIMPAK = ITEMS.register("super_stimpak",
            () -> new StimpakItem(8, new Item.Properties().food(ModFoodTypes.MED)));
    @DataGen
    public static final RegistryObject<Item> RADAWAY = ITEMS.register("radaway",
            () -> new RadItem(-4.0f, new Item.Properties().food(ModFoodTypes.MED)));
    @DataGen
    public static final RegistryObject<Item> GLOWBLOOD = ITEMS.register("glowing_blood",
            () -> new GlowbloodItem(4.0f, new Item.Properties().food(ModFoodTypes.MED)));
    @DataGen
    public static final RegistryObject<Item> RADX = ITEMS.register("radx",
            () -> new RadXItem(100, new Item.Properties().food(ModFoodTypes.MED)));

    //Others

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
