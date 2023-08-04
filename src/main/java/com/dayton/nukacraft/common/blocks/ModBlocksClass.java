package com.dayton.nukacraft.common.blocks;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.blocks.custom.plants.BloodLeafBlockClass;
import com.dayton.nukacraft.common.blocks.custom.blocks.DogWoodClass;
import com.dayton.nukacraft.common.blocks.custom.blocks.ModFlowerBlock;
import com.dayton.nukacraft.common.blocks.custom.plants.*;
import com.dayton.nukacraft.common.items.ModItemTabs;
import com.dayton.nukacraft.common.items.ModItemsClass;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
//И здесь тоже
import java.util.function.Supplier;

public class ModBlocksClass {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<Block> ALUMI_ORE = registerBlock("aluminium_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.6F, 1.9F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPALUMI = registerBlock("deepalumi_block",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPLEAD = registerBlock("deeplead_block",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.4F, 2.2F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));






    public static final RegistryObject<Block> ASHWOOD = registerBlock("dwoodlog",
            () -> new DogWoodClass(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_ASHWOOD = registerBlock("strippeddwood",
            () -> new DogWoodClass(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.1F, 3.0F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DEEPSILVER = registerBlock("deepsilver_block",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.9F, 4.6F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ULTRACITE_ORE = registerBlock("ultracite_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.9F, 3.8F).requiresCorrectToolForDrops().lightLevel((p_50892_) -> {return 5;})));

    public static final RegistryObject<Block> DEEPULTRACITE = registerBlock("deepultracite_block",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.8F, 3.2F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().lightLevel((p_50892_) -> {return 5;})));

    public static final RegistryObject<Block> BTITAN_ORE = registerBlock("btitan_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.2F, 4.1F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPBTITAN = registerBlock("deepbtitan_block",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.7F, 4.5F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SLITILE = registerBlock("slitile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLUETILE = registerBlock("bluetile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BTILE = registerBlock("btile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CYANTILE = registerBlock("cyantile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GREENTILE = registerBlock("greentile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGTILE = registerBlock("magtile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PRPLTILE = registerBlock("prpltile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> REDTILE = registerBlock("redtile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> REDROCKETPANEL = registerBlock("redrocketpanel",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRKBRICK_I = registerBlock("crkbrick_i",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRKBRICK_R = registerBlock("crkbrick_r",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2, 6).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRKBRICK_T = registerBlock("crkbrick_t",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2, 6).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> DANGERFLOOR = registerBlock("dangerfloor",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CRKBRICK_PIPE = registerBlock("crkbrick_pipe",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2, 6).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRKBRICK_VENT = registerBlock("crkbrick_vent",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2, 6).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> VTTILE = registerBlock("vttile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLACKSTEEL = registerBlock("blacksteel",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLACKSTEEL2 = registerBlock("blacksteel2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLACKSTEELSLAB = registerBlock("blacksteelslab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> REDSTEEL = registerBlock("redsteel",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> REDSTEELSLAB = registerBlock("redsteelslab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GREENSTEEL = registerBlock("greensteel",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GREENSTEELSLAB = registerBlock("greensteelslab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WHITESTEEL = registerBlock("whitesteel",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WHITESTEELSLAB = registerBlock("whitesteelslab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NUKAMELON = registerBlock("nukamelon",
            () -> new MelonBlock(BlockBehaviour.Properties.of(Material.VEGETABLE,
                    MaterialColor.COLOR_LIGHT_GREEN).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> THISTLE = registerBlock("thistle",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> CRANBERRY_GRASS = registerBlock("cranberrygrass",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> ASHGRASS = registerBlock("ashgrass",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> GLOW_GRASS = registerBlock("glow_grass",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> DEATH_PLANT = registerBlock("death_plant",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> DEATH_FLOWER = registerBlock("death_flower",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_DEATH_FLOWER = registerBlockWithoutItem("potted_death_flower",
            () -> new FlowerPotBlock(null, ModBlocksClass.DEATH_FLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> ASTER = registerBlock("aster",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_ASTER = registerBlockWithoutItem("potted_aster",
            () -> new FlowerPotBlock(null, ModBlocksClass.ASTER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> RADASTER = registerBlock("radaster",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_RADASTER = registerBlockWithoutItem("potted_radaster",
            () -> new FlowerPotBlock(null, ModBlocksClass.RADASTER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> FIREMUSHROOM = registerBlock("firemushroom",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_FIREMUSHROOM = registerBlockWithoutItem("potted_firemushroom",
            () -> new FlowerPotBlock(null, ModBlocksClass.FIREMUSHROOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> BLASTCAP = registerBlock("blastcap",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_BLASTCAP = registerBlockWithoutItem("potted_blastcap",
            () -> new FlowerPotBlock(null, ModBlocksClass.BLASTCAP,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> ASHROSE = registerBlock("ashrose",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_ASHROSE = registerBlockWithoutItem("potted_ashrose",
            () -> new FlowerPotBlock(null, ModBlocksClass.ASHROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> RADROSE = registerBlock("rad_rose",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_RADROSE = registerBlockWithoutItem("potted_rad_rose",
            () -> new FlowerPotBlock(null, ModBlocksClass.RADROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> FEVERBLOSSOM = registerBlock("feverblossom",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_FEVERBLOSSOM = registerBlockWithoutItem("potted_feverblossom",
            () -> new FlowerPotBlock(null, ModBlocksClass.FEVERBLOSSOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> BOOMBLOSSOM = registerBlock("boomblossom",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_BOOMBLOSSOM = registerBlockWithoutItem("potted_boomblossom",
            () -> new FlowerPotBlock(null, ModBlocksClass.BOOMBLOSSOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> SOOTFLOWER = registerBlock("sootflower",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_SOOTFLOWER = registerBlockWithoutItem("potted_sootflower",
            () -> new FlowerPotBlock(null, ModBlocksClass.SOOTFLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> GEIGERBLOSSOM = registerBlock("geigerblossom",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_GEIGERBLOSSOM = registerBlockWithoutItem("potted_geigerblossom",
            () -> new FlowerPotBlock(null, ModBlocksClass.GEIGERBLOSSOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> BLOODLEAF_BUSH = registerBlockWithoutItem("bloodleaf",
            () -> new BloodLeafBlockClass(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> BBLOODLEAF_BUSH = registerBlockWithoutItem("bbloodleaf",
            () -> new BBloodLeafBlockClass(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> QUANTUMLEAF_BUSH = registerBlockWithoutItem("qbloodleaf",
            () -> new QuantLeafBlockClass(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> GAMMALEAF_BUSH = registerBlockWithoutItem("gbloodleaf",
            () -> new GammaLeafBlockClass(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> CRACKBERRY_BUSH = registerBlockWithoutItem("crackberry",
            () -> new CrackBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> BOMBBERRY_BUSH = registerBlockWithoutItem("bombberry",
            () -> new BombBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> MUTTFRUIT_BUSH = registerBlockWithoutItem("muttfruit",
            () -> new MuttFruitBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> FUSFRUIT_BUSH = registerBlockWithoutItem("fusionfruit",
            () -> new FusFruitBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> SITTBEAN_BUSH = registerBlockWithoutItem("sittbean",
            () -> new SittBeansBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> NEUTRON_BUSH = registerBlockWithoutItem("neutronpod",
            () -> new NeutronRodBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> WILDTATO = registerBlockWithoutItem("wildtato",
            () -> new WildTatoBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> CRANBERRY = registerBlockWithoutItem("cranberry",
            () -> new CranBerryBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> GOLD_CRANBERRY = registerBlockWithoutItem("gold_cranberry",
            () -> new GoldCranberryBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> STARBERRY = registerBlockWithoutItem("starberry",
            () -> new StarBerryBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> GUTSHROOM = registerBlock("gutshroom",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_GUTSHROOM = registerBlockWithoutItem("potted_gutshroom",
            () -> new FlowerPotBlock(null, ModBlocksClass.GUTSHROOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> BBLIGHT = registerBlock("bblight",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_BBLIGHT = registerBlockWithoutItem("potted_bblight",
            () -> new FlowerPotBlock(null, ModBlocksClass.BBLIGHT,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> GIGAWHEAT = registerBlockWithoutItem("gigawheat",
            () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks().sound(SoundType.CROP).noCollission().instabreak()));
    public static final RegistryObject<Block> BRAINFUNGUS = registerBlockWithoutItem("brainfungus",
            () -> new BrainFungusBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> MINDFUNGUS = registerBlockWithoutItem("mindfungus",
            () -> new MindFungusBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak().lightLevel((p_50892_) -> {return 5;})));
    public static final RegistryObject<Block> GLOWFUNGUS = registerBlock("glowfungus",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak().lightLevel((p_50892_) -> {return 4;})));
    public static final RegistryObject<Block> MUTTSHOOTFUNGUS = registerBlock("mutshootfungus",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak().lightLevel((p_50892_) -> {return 9;})));
    public static final RegistryObject<Block> ZANDER = registerBlockWithoutItem("zander",
            () -> new ZanderBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> HOLLYHOCK = registerBlock("hollyhock",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> MARYGOLD = registerBlock("marygold",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_MARYGOLD = registerBlockWithoutItem("potted_marygold",
            () -> new FlowerPotBlock(null, ModBlocksClass.MARYGOLD,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> DATURAN = registerBlockWithoutItem("root_daturan",
            () -> new DaturanBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> AGAVE = registerBlockWithoutItem("agave",
            () -> new AgaveBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> PUNGA = registerBlockWithoutItem("punga",
            () -> new PungaBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> NEOAGAVE = registerBlockWithoutItem("neoagave",
            () -> new NeoagaveBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> GINSENG = registerBlockWithoutItem("ginseng",
            () -> new GinsengBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> NUKAROOT = registerBlockWithoutItem("nukaroot",
            () -> new NukaRootBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));



    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItemsClass.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemTabs.NUKA_BLOCKS)));
    }

    private static <T extends Block>RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
