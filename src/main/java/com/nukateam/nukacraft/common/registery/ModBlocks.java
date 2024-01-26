package com.nukateam.nukacraft.common.registery;

import com.nukateam.guns.common.foundation.block.WorkbenchBlock;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.*;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.PipeBlock;
import com.nukateam.nukacraft.common.foundation.blocks.plants.*;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<Block> WORKBENCH = registerBlock("workbench",
            () -> new WorkbenchBlock(Block.Properties.of(Material.METAL).strength(1.5F)));

    public static final RegistryObject<Block> TERMINAL = registerBlock("wasteland_terminal",
            () -> new TerminalBlock(Block.Properties.of(Material.METAL).strength(1.5F)));

    public static final RegistryObject<Block> ALUMI_ORE = registerBlock("aluminium_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.6F, 1.9F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LANDMINE = registerBlock(ModItemTabs.NUKA_WEAPONS, "fragmine",
            () -> new LandMineBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.6F, 1.9F).noCollission()));
    public static final RegistryObject<Block> GEARDOOR = registerBlockWithoutItem("geardoor",
            () -> new GearDoorBlock(BlockBehaviour.Properties.of(Material.STONE).strength(30f).explosionResistance(30f).noOcclusion()));
    public static final RegistryObject<Block> OPENGEAR = registerBlockWithoutItem("opengear",
            () -> new OpenGearBlock(BlockBehaviour.Properties.of(Material.STONE).strength(30f).explosionResistance(30f).noOcclusion()));

    public static final  RegistryObject<Block> HALFBARRIER = registerBlockWithoutItem("half_barrier",
            () -> new HalfBarrier(BlockBehaviour.Properties.of(Material.BARRIER).strength(-1f).explosionResistance(3600000.8F).noDrops().noOcclusion()));
    public static final  RegistryObject<Block> FILLERBARRIER = registerBlockWithoutItem("filler_barrier",
            () -> new Block(BlockBehaviour.Properties.of(Material.BARRIER).strength(-1f).explosionResistance(3600000.8F).noDrops().noOcclusion()));
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

    public static final RegistryObject<Block> QUARTS_ORE = registerBlock("quarts_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.6F, 4.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPQUARTS_ORE = registerBlock("deepquarts_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.1F, 4.5F).requiresCorrectToolForDrops()));
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
    public static final RegistryObject<Block> DARKFLOOR = registerBlock("darkfloor",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> VAULTPILLAR = registerBlock("vaultpillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRCKDWHITEBRICKS = registerBlock("crackedwhitebricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WHITEBRICKS = registerBlock("whitebricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WHITEBRICKS_SLAB = registerBlock("whitebricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> WHITEBRICKS_STAIRS = registerBlock("whitebricks_stairs",
            () -> new StairBlock(ModBlocks.WHITEBRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SMOOTH_BRICKS = registerBlock("smooth_brick",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.8f, 5.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MOSSWHITEBRICKS = registerBlock("moss_whitebricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GREENTILE = registerBlock("greentile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VAULTDINERTABLE = registerBlock("tablevt",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.4f)));
    public static final RegistryObject<Block> WRITTINGDESK1 = registerBlock("writtingdesk1",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.4f)));
    public static final RegistryObject<Block> WRITTINGDESK2 = registerBlock("writtingdesk2",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.4f)));
    public static final RegistryObject<Block> WRITTINGDESK3 = registerBlock("writtingdesk3",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(0.4f)));
    public static final RegistryObject<Block> VAULTDINERCHAIR = registerBlock("dinnerchair",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.3f)));
    public static final RegistryObject<Block> IND_BUTTON = registerBlock("ind_button",
            () -> new LeverBlock(BlockBehaviour.Properties.of(Material.DECORATION)
                    .strength(0.1f)));
    public static final RegistryObject<Block> MAGTILE = registerBlock("magtile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PRPLTILE = registerBlock("prpltile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> REDTILE = registerBlock("redtile",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SHELTERLAMP = registerBlock("shelter_lamp",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel(litBlockEmission(15))
                    .strength(0.9f)));

    public static final RegistryObject<Block> REDROCKETPANEL = registerBlock("redrocketpanel",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.2f).requiresCorrectToolForDrops()));

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

    public static final RegistryObject<Block> VTARMOR = registerBlock("vtarmor",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5.4f, 9.7f).requiresCorrectToolForDrops()));
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
            () -> new FlowerPotBlock(null, ModBlocks.DEATH_FLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> TATO = registerBlockWithoutItem("tato_plant",
            () -> new TatoCropBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.CROP).noCollission().instabreak()));
    public static final RegistryObject<Block> IRRADROOT = registerBlockWithoutItem("irrad_beetroots",
            () -> new IrradRootBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.CROP).noCollission().instabreak()));
    public static final RegistryObject<Block> UFCARROT = registerBlockWithoutItem("ufcarrots",
            () -> new UltravioletCarrotBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.CROP).noCollission().instabreak()));
    public static final RegistryObject<Block> ASTER = registerBlock("aster",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> BROC = registerBlock("brocflower",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> INVERT = registerBlock("invertflower",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_BROC = registerBlockWithoutItem("potted_broc",
            () -> new FlowerPotBlock(null, ModBlocks.BROC,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> POTTED_INVERT = registerBlockWithoutItem("potted_invert",
            () -> new FlowerPotBlock(null, ModBlocks.INVERT,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> POTTED_ASTER = registerBlockWithoutItem("potted_aster",
            () -> new FlowerPotBlock(null, ModBlocks.ASTER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> RADASTER = registerBlock("radaster",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_RADASTER = registerBlockWithoutItem("potted_radaster",
            () -> new FlowerPotBlock(null, ModBlocks.RADASTER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> FIREMUSHROOM = registerBlock("firemushroom",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_FIREMUSHROOM = registerBlockWithoutItem("potted_firemushroom",
            () -> new FlowerPotBlock(null, ModBlocks.FIREMUSHROOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> BLASTCAP = registerBlock("blastcap",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_BLASTCAP = registerBlockWithoutItem("potted_blastcap",
            () -> new FlowerPotBlock(null, ModBlocks.BLASTCAP,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> ASHROSE = registerBlock("ashrose",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_ASHROSE = registerBlockWithoutItem("potted_ashrose",
            () -> new FlowerPotBlock(null, ModBlocks.ASHROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> RADROSE = registerBlock("rad_rose",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_RADROSE = registerBlockWithoutItem("potted_rad_rose",
            () -> new FlowerPotBlock(null, ModBlocks.RADROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> FEVERBLOSSOM = registerBlock("feverblossom",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_FEVERBLOSSOM = registerBlockWithoutItem("potted_feverblossom",
            () -> new FlowerPotBlock(null, ModBlocks.FEVERBLOSSOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> BOOMBLOSSOM = registerBlock("boomblossom",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_BOOMBLOSSOM = registerBlockWithoutItem("potted_boomblossom",
            () -> new FlowerPotBlock(null, ModBlocks.BOOMBLOSSOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> SOOTFLOWER = registerBlock("sootflower",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_SOOTFLOWER = registerBlockWithoutItem("potted_sootflower",
            () -> new FlowerPotBlock(null, ModBlocks.SOOTFLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> GEIGERBLOSSOM = registerBlock("geigerblossom",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_GEIGERBLOSSOM = registerBlockWithoutItem("potted_geigerblossom",
            () -> new FlowerPotBlock(null, ModBlocks.GEIGERBLOSSOM,
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
            () -> new FlowerPotBlock(null, ModBlocks.GUTSHROOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> BBLIGHT = registerBlock("bblight",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_BBLIGHT = registerBlockWithoutItem("potted_bblight",
            () -> new FlowerPotBlock(null, ModBlocks.BBLIGHT,
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
//    public static final RegistryObject<Block> ZANDER = registerBlockWithoutItem("zander",
//            () -> new ZanderBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> REDLIGHT = registerBlock("redlight",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1.0f).lightLevel((p_50892_) -> {return 4;})));
    public static final RegistryObject<Block> HOLLYHOCK = registerBlock("hollyhock",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> MARYGOLD = registerBlock("marygold",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 0, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> POTTED_MARYGOLD = registerBlockWithoutItem("potted_marygold",
            () -> new FlowerPotBlock(null, ModBlocks.MARYGOLD,
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
    public static final RegistryObject<Block> CORALLEAF = registerBlockWithoutItem("coral_leaf",
            () -> new CoralLeafBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> PRISMLEAF = registerBlockWithoutItem("prism_leaf",
            () -> new PrismLeafBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> MEGAHATTER = registerBlock("megamorph_hatter",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> HATTER = registerBlock("hatter",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> DEAD_PUNGA = registerBlock("dead_punga",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> DEAD_DATURAN = registerBlock("dead_daturan",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> DEAD_CORALLEAF = registerBlock("dead_coralleaf",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> ZANDER = registerBlockWithoutItem("zander",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));


    public static final RegistryObject<Block> STORAGE1 = registerBlock("storage1",
            () -> new BasicStorageBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)));

    public static final RegistryObject<Block> FRIDGE = registerBlock("fridge",
            () -> new BasicStorageBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f)));
    public static final RegistryObject<Block> VENT = registerBlock("vent_tube",
            () -> new VentTubeBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f)));
    public static final RegistryObject<Block> COOLER = registerBlock("cooler",
            () -> new BasicStorageBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f)));

    public static final RegistryObject<Block> VTCRATE = registerBlock("vtcrate1",
            () -> new BasicStorageBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f)));

    public static final RegistryObject<Block> VTCRATE2 = registerBlock("vtcrate2",
            () -> new LockableStorage(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f)));

    public static final RegistryObject<Block> WOODCRATE = registerBlock("woodcrate",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f)));


    public static final RegistryObject<Block> ARMEDGLASS = registerBlock("armedglass",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .strength(1.4F).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> STEELBARS = registerBlock("steel_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RUSTDOOR = registerBlock("rustdoor",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()));

    public static final RegistryObject<Block> DECAYDOOR = registerBlock("decaydoor",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(0.5F).sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<Block> RREDDOOR = registerBlock("rreddoor",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0F).sound(SoundType.METAL).noOcclusion()));
    public static final RegistryObject<Block> SHELTERBARS = registerBlock("shelter_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUPPORTWALL = registerBlock("supportwall",
            () -> new VaultSupportBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUPPORTWALLTOP = registerBlock("supportwalltop",
            () -> new VaultSupportBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SUPPORTTOP = registerBlock("supporttop",
            () -> new VaultSupportBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SERVERBLOCK = registerBlock("comblock",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.2f, 4.4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RADIOTERMINAL = registerBlock("radioterminal",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2.1f, 4.1f).requiresCorrectToolForDrops()));




    public static final RegistryObject<Block> RUSTYPIPE = registerBlock("rusty_pipe",
            () -> new PipeBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1.1f, 4.1f).requiresCorrectToolForDrops()));

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    private static <T extends Block>RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }
    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
        };
    }

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, ModItemTabs.NUKA_BLOCKS);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<T> registerBlock(CreativeModeTab tab, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
