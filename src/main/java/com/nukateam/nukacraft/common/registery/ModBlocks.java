package com.nukateam.nukacraft.common.registery;

import com.nukateam.ntgl.common.foundation.block.WorkbenchBlock;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.annotation.DataGen;
import com.nukateam.nukacraft.common.data.enums.ResourceType;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.PipeBlock;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.*;
import com.nukateam.nukacraft.common.foundation.blocks.plants.*;
import com.nukateam.nukacraft.common.registery.items.ModBlockItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NukaCraftMod.MOD_ID);

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WORKBENCH = registerBlock("workbench",
            () -> new WorkbenchBlock(Block.Properties.of().sound(SoundType.METAL).strength(1.5F)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> TERMINAL = registerBlock("wasteland_terminal",
            () -> new TerminalBlock(Block.Properties.of().sound(SoundType.METAL).strength(1.5F)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ALUMI_ORE = registerBlock("aluminium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.6F, 1.9F).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> LANDMINE = registerBlock("fragmine",
            () -> new LandMineBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.6F, 1.9F)));
//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> GEAR_DOOR = registerBlockWithoutItem("geardoor",
            () -> new GearDoorBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE).strength(30f).explosionResistance(30f).noOcclusion()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> OPENGEAR = registerBlockWithoutItem("opengear",
            () -> new OpenGearBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE).strength(30f).explosionResistance(30f).noOcclusion()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> HALFBARRIER = registerBlockWithoutItem("half_barrier",
            () -> new HalfBarrier(BlockBehaviour.Properties.copy(Blocks.BARRIER).strength(-1f).explosionResistance(3600000.8F)/*.noDrops()*/.noOcclusion()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> FILLERBARRIER = registerBlockWithoutItem("filler_barrier",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BARRIER).strength(-1f).explosionResistance(3600000.8F)/*.noDrops()*/.noOcclusion()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEEPALUMI = registerBlock("deepalumi_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
    
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ULTRACITE_TUFF = registerBlock("ultracite_tuff",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.8f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POINTED_ULTRACITE_CRYSTALL = registerBlock("pointed_ultracite_crystall",
            () -> new PointedUltraciteCrystall(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE).noOcclusion().sound(SoundType.POINTED_DRIPSTONE).randomTicks().strength(1.5F, 3.0F).dynamicShape().lightLevel((p_50892_) -> {
                return 7;
            })));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ULTRACITE_MAGMA = registerBlock("ultracite_magma",
            () -> new UltraciteMagmaBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.5f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().lightLevel((p_50892_) -> {
                        return 7;
                    })));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> CRANBERRYLEAVES = registerBlock("cranberryleaves",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noOcclusion().sound(SoundType.GRASS)
                    .instabreak()));
//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEWDROPHEAD = registerBlock("dewdrop",
            () -> new DewdropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS)
                    .instabreak().noCollission()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEWDROP_SAPLING = registerBlock("dewdrop_sapling",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 2, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS)
                    .instabreak().noCollission().lightLevel((p_50892_) -> {
                        return 1;
                    })));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> TOXICFERN = registerBlock("toxicfern",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 2, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS)
                    .instabreak().noCollission()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BOGPAD = registerBlockWithoutItem("bog_pad",
            () -> new WaterlilyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS)
                    .instabreak().noCollission().noCollission()));
    //    @DataGen(type = ResourceType.BLOCK)
//    public static final RegistryObject<Block> DEWDROPHEAD_PLANT = registerBlock("dewdrop_plant",
//            () -> new DewdropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS)
//                    .instabreak().noCollission()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ASHWOOD = registerBlock("dwoodlog",
            () -> new DogWoodClass(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.9F).sound(SoundType.WOOD)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> STRIPPED_ASHWOOD = registerBlock("strippeddwood",
            () -> new DogWoodClass(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.9F).sound(SoundType.WOOD)));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> CRANBERRYWOOD = registerBlock("cranberrywood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.9F).sound(SoundType.WOOD)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEEP_LEAD_ORE = registerBlock("deeplead_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(3.4F, 2.2F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(0.8f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> URAN_ORE = registerBlock("uranium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2.8f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SATURNITE_ORE = registerBlock("saturnite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2.8f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEEP_URAN_ORE = registerBlock("deeruranium",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(3.0f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEEP_SATURNITE_ORE = registerBlock("deepslate_saturnite",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(3.0f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ULTRACITE_TUFF_ORE = registerBlock("ultracite_tuff_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(3.8F, 3.2F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().lightLevel((p_50892_) -> {
                        return 7;
                    })));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2.1F, 3.0F).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> QUARTS_ORE = registerBlock("quarts_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2.6F, 4.0F).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEEPQUARTS_ORE = registerBlock("deepquarts_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(3.1F, 4.5F).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEEPSILVER = registerBlock("deepsilver_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(3.9F, 4.6F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ULTRACITE_ORE = registerBlock("ultracite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2.9F, 3.8F).requiresCorrectToolForDrops().lightLevel((p_50892_) -> {
                        return 7;
                    })));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BTITAN_ORE = registerBlock("black_titan_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(4.2F, 4.1F).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEEPBTITAN = registerBlock("deep_black_titan_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(4.7F, 4.5F).requiresCorrectToolForDrops()));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEEP_ULTRACITE = registerBlock("deep_ultracite_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(3.8F, 3.2F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().lightLevel((p_50892_) -> {
                        return 7;
                    })));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SLITILE = registerBlock("slitile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BLUETILE = registerBlock("bluetile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BTILE = registerBlock("btile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ACID_DIRT = registerBlock("acid_dirt",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS)
                    .strength(0.2f)));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ASHDIRT = registerBlock("ashdirt",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS)
                    .strength(0.2f)));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SCORCHED = registerBlock("scorched_earth",
            () -> new ScorchedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS)
                    .strength(0.5f)));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ASHSTONE = registerBlock("ash_stone",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.2f)));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ASHSMOKER = registerBlock("ash_smoker",
            () -> new AshSmoker(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.2f)));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> CYANTILE = registerBlock("cyantile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DARKFLOOR = registerBlock("darkfloor",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> VAULTPILLAR = registerBlock("vaultpillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> CRCKDWHITEBRICKS = registerBlock("crackedwhitebricks",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WHITEBRICKS = registerBlock("whitebricks",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WHITEBRICKS_STAIRS = registerBlock("whitebricks_stairs",
            () -> new StairBlock(ModBlocks.WHITEBRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> CRCKDWHITEBRICKS_STAIRS = registerBlock("crackedwhitebricks_stairs",
            () -> new StairBlock(ModBlocks.WHITEBRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> MOSSWHITEBRICKS_STAIRS = registerBlock("mosswhitebricks_stairs",
            () -> new StairBlock(ModBlocks.WHITEBRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WHITEBRICKS_SLAB = registerBlock("whitebricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));
    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SMOOTH_BRICKS = registerBlock("smooth_brick",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.8f, 5.0f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> MOSSWHITEBRICKS = registerBlock("moss_whitebricks",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2f, 6.0f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> GREEN_TILE = registerBlock("greentile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> VAULT_DINER_TABLE = registerBlock("tablevt",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(0.4f)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> VAULT_BLASTDOOR = registerBlock("vaultblastdoor",
            () -> new BlastDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(0.4f).lightLevel((p_50892_) -> 1)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WRITTING_DESK1 = registerBlock("writtingdesk1",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(0.4f)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WRITTING_DESK2 = registerBlock("writtingdesk2",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(0.4f)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WRITTING_DESK3 = registerBlock("writtingdesk3",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(0.4f)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> VAULT_DINER_CHAIR = registerBlock("dinnerchair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(0.3f)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> GOLD_TOILET = registerBlock("goldtoilet",
            () -> new ChairBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS).mapColor(MapColor.ICE)
                    .strength(0.4f)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> TOILET = registerBlock("toilet",
            () -> new ChairBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS).mapColor(MapColor.ICE)
                    .strength(0.3f)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> IND_BUTTON = registerBlock("ind_button",
            () -> new LeverBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE)
                    .strength(0.1f)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> MAGTILE = registerBlock("magtile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> PRPLTILE = registerBlock("prpltile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> REDTILE = registerBlock("redtile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SHELTER_LAMP = registerBlock("shelter_lamp",
            () -> new RedstoneLampBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL).lightLevel(litBlockEmission(15))
                    .strength(0.9f)));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> REDROCKET_PANEL = registerBlock("redrocketpanel",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.2f).requiresCorrectToolForDrops()));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DANGER_FLOOR = registerBlock("dangerfloor",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> VT_LATTICE = registerBlock("vtlattice",
            () -> new LatticeBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops().noOcclusion()));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> CRKBRICK_PIPE = registerBlock("crkbrick_pipe",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2, 6).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> CRKBRICK_VENT = registerBlock("crkbrick_vent",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2, 6).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> VTTILE = registerBlock("vttile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BROWNTILE = registerBlock("brown_tile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WHITETILE = registerBlock("white_tile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ORANGETILE = registerBlock("orange_tile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> LBLUETILE = registerBlock("ligthblue_tile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> YELLOWTILE = registerBlock("yellow_tile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> LIMETILE = registerBlock("lime_tile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> PINKTILE = registerBlock("pink_tile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DARKGRAYTILE = registerBlock("darkgray_tile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> GRAYTILE = registerBlock("gray_tile",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(1.1f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> VTARMOR = registerBlock("vtarmor",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(5.4f, 9.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BLACKSTEEL = registerBlock("blacksteel",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BLACKSTEEL_STAIRS = registerBlock("blacksteel_stairs",
            () -> new StairBlock(ModBlocks.BLACKSTEEL.get().defaultBlockState(), BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(MapColor.STONE)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POWERBLOCK = registerBlock("powerblock",
            () -> new PowerBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> STEELFLOOR = registerBlock("shelterfloor",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BLACKSTEEL2 = registerBlock("blacksteel2",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BLACKSTEELSLAB = registerBlock("blacksteelslab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> REDSTEEL = registerBlock("redsteel",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SCRAPMETALL = registerBlock("scrapmetall",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(1.8f, 2.7f)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RUSTTIREBLOCK = registerBlock("rusttiresblock",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(1.2f, 1.7f)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> YELLOWSTEEL = registerBlock("yellow_steel",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> YELLOWSTEEL_COLUMN = registerBlock("yellow_steel_column",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RUSTREDSTEEL = registerBlock("rustedredsteel",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RUSTEDGREENSTEEL = registerBlock("rustedgreensteel",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> PLATEDGREENSTEEL = registerBlock("platedgreensteel",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> REDSTEELSLAB = registerBlock("redsteelslab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> GREENSTEEL = registerBlock("greensteel",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> GREENSTEELSLAB = registerBlock("greensteelslab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WHITESTEEL = registerBlock("whitesteel",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WHITESTEELCOLUMN = registerBlock("whitesteel_column",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BLUESTEEL = registerBlock("bluesteel",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WHITESTEELSLAB = registerBlock("whitesteelslab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> NUKAMELON = registerBlock("nukamelon",
            () -> new MelonBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS).mapColor(MapColor.COLOR_LIGHT_GREEN).strength(1.0F).sound(SoundType.WOOD)));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> THISTLE = registerBlock("thistle",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> CRANBERRY_GRASS = registerBlock("cranberrygrass",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ASHGRASS = registerBlock("ashgrass",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> HEAP_GRASS = registerBlock("heap_grass",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RUSTY_BUSH = registerBlock("rusty_bush",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POISONGRASS = registerBlock("poison_grass",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> GLOW_GRASS = registerBlock("glow_grass",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEAD_PLANT = registerBlock("death_plant",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> DEATH_FLOWER = registerBlock("death_flower",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_DEATH_FLOWER = registerBlockWithoutItem("potted_death_flower",
            () -> new FlowerPotBlock(null, ModBlocks.DEATH_FLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> TATO = registerBlockWithoutItem("tato_plant",
            () -> new TatoCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.CROP).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> IRRADROOT = registerBlockWithoutItem("irrad_beetroots",
            () -> new IrradRootBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.CROP).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> UFCARROT = registerBlockWithoutItem("ufcarrots",
            () -> new UltravioletCarrotBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.CROP).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ASTER = registerBlock("aster",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_ASTER = registerBlockWithoutItem("potted_aster",
            () -> new FlowerPotBlock(null, ModBlocks.ASTER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BROC = registerBlock("brocflower",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_BROC = registerBlockWithoutItem("potted_broc",
            () -> new FlowerPotBlock(null, ModBlocks.BROC,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> INVERT = registerBlock("invertflower",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_INVERT = registerBlockWithoutItem("potted_invert",
            () -> new FlowerPotBlock(null, ModBlocks.INVERT,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RADASTER = registerBlock("radaster",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.AZALEA_LEAVES).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_RADASTER = registerBlockWithoutItem("potted_radaster",
            () -> new FlowerPotBlock(null, ModBlocks.RADASTER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> FIREMUSHROOM = registerBlockWithoutItem("firefungi",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_FIREMUSHROOM = registerBlockWithoutItem("potted_firemushroom",
            () -> new FlowerPotBlock(null, ModBlocks.FIREMUSHROOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BLASTCAP = registerBlockWithoutItem("blastcapfungi",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_BLASTCAP = registerBlockWithoutItem("potted_blastcap",
            () -> new FlowerPotBlock(null, ModBlocks.BLASTCAP,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ASHROSE = registerBlock("ashrose",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_ASHROSE = registerBlockWithoutItem("potted_ashrose",
            () -> new FlowerPotBlock(null, ModBlocks.ASHROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RADROSE = registerBlock("rad_rose",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_RADROSE = registerBlockWithoutItem("potted_rad_rose",
            () -> new FlowerPotBlock(null, ModBlocks.RADROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> FEVERBLOSSOM = registerBlock("feverblossom",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
//
//    @DataGen(type = ResourceTyp//e.BLOCK)
    public static final RegistryObject<Block> POTTED_FEVERBLOSSOM = registerBlockWithoutItem("potted_feverblossom",
            () -> new FlowerPotBlock(null, ModBlocks.FEVERBLOSSOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BOOMBLOSSOM = registerBlock("boomblossom",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_BOOMBLOSSOM = registerBlockWithoutItem("potted_boomblossom",
            () -> new FlowerPotBlock(null, ModBlocks.BOOMBLOSSOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SOOTFLOWER = registerBlock("sootflower",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
//
//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_SOOTFLOWER = registerBlockWithoutItem("potted_sootflower",
            () -> new FlowerPotBlock(null, ModBlocks.SOOTFLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> GEIGERBLOSSOM = registerBlock("geigerblossom",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> POTTED_GEIGERBLOSSOM = registerBlockWithoutItem("potted_geigerblossom",
            () -> new FlowerPotBlock(null, ModBlocks.GEIGERBLOSSOM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BLOODLEAF_BUSH = registerBlockWithoutItem("bloodleaf",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BBLOODLEAF_BUSH = registerBlockWithoutItem("bbloodleaf",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> QUANTUMLEAF_BUSH = registerBlockWithoutItem("qbloodleaf",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> GAMMALEAF_BUSH = registerBlockWithoutItem("gbloodleaf",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> CRACKBERRY_BUSH = registerBlockWithoutItem("crackberry",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> BOMBBERRY_BUSH = registerBlockWithoutItem("bombberry",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> MUTTFRUIT_BUSH = registerBlockWithoutItem("muttfruit",
            () -> new MuttFruitBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> FUSFRUIT_BUSH = registerBlockWithoutItem("fusionfruit",
            () -> new FusFruitBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> SILT_BEAN_BUSH = registerBlockWithoutItem("silt_bean",
            () -> new SittBeansBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> NEUTRON_BUSH = registerBlockWithoutItem("neutronpod",
            () -> new NeutronRodBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> WILDTATO = registerBlockWithoutItem("wildtato",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> CRANBERRY = registerBlockWithoutItem("cranberry",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> GOLD_CRANBERRY = registerBlockWithoutItem("gold_cranberry",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> STARBERRY = registerBlockWithoutItem("starberry",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> GUTFUNGI = registerBlockWithoutItem("gutfungi",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> POTTED_GUTSHROOM = registerBlockWithoutItem("potted_gutshroom",
            () -> new FlowerPotBlock(null, ModBlocks.GUTFUNGI,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> GIGAWHEAT = registerBlockWithoutItem("gigawheat",
            () -> new CropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().sound(SoundType.CROP).noCollission().instabreak()));

    public static final RegistryObject<Block> BRAINFUNGUS = registerBlockWithoutItem("brainfungus",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> MINDFUNGUS = registerBlockWithoutItem("mindfungus",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak().lightLevel((p_50892_) -> {
                return 5;

            })));

    public static final RegistryObject<Block> GLOWFUNGUS = registerBlockWithoutItem("glowfungi",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak().lightLevel((p_50892_) -> {
                return 4;

            })));

    public static final RegistryObject<Block> POTTED_GLOWFUNGUS = registerBlockWithoutItem("potted_glowfungi",
            () -> new FlowerPotBlock(null, ModBlocks.GLOWFUNGUS,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> MUTTSHOOTFUNGUS = registerBlockWithoutItem("mutshootfungi",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak().lightLevel((p_50892_) -> {
                return 9;

            })));

    public static final RegistryObject<Block> POTTED_MUTTSHOOTFUNGUS = registerBlockWithoutItem("potted_mutshootfungi",
            () -> new FlowerPotBlock(null, ModBlocks.MUTTSHOOTFUNGUS,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));


    public static final RegistryObject<Block> MEGAHATTERFUNGI = registerBlockWithoutItem("megamorph_hatterfungi",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> POTTED_MEGAHATTERFUNGI = registerBlockWithoutItem("potted_megamorph",
            () -> new FlowerPotBlock(null, ModBlocks.MEGAHATTERFUNGI,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> POTTED_HATTER = registerBlockWithoutItem("potted_hatter",
            () -> new FlowerPotBlock(null, ModBlocks.MEGAHATTERFUNGI,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> HATTERFUNGI = registerBlockWithoutItem("hatterfungi",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> REDLIGHT = registerBlock("redlight",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(1.0f).lightLevel((p_50892_) -> {
                        return 4;

                    })));


    public static final RegistryObject<Block> CRYOCAPSULEACT = registerBlock("cryocapsuleact",
            () -> new CryoCapsuleBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL).sound(SoundType.METAL).strength(2.0f).lightLevel((p_50892_) -> {
                return 1;
            })));


    public static final RegistryObject<Block> OPENCRYOCAPSULE = registerBlock("opencryocapsule",
            () -> new CryoCapsuleBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL).sound(SoundType.METAL).strength(2.0f).lightLevel((p_50892_) -> {
                return 1;
            })));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> CRYOCAPSULE = registerBlock("cryocapsule",
            () -> new CryoCapsuleBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL).sound(SoundType.METAL).strength(2.0f).lightLevel((p_50892_) -> {
                return 1;
            })));


    public static final RegistryObject<Block> HOLLYHOCK = registerBlock("hollyhock",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> MARYGOLD = registerBlock("marygold",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 0, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> POTTED_MARYGOLD = registerBlockWithoutItem("potted_marygold",
            () -> new FlowerPotBlock(null, ModBlocks.MARYGOLD,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));


    public static final RegistryObject<Block> DATURAN = registerBlockWithoutItem("root_daturan",
            () -> new DaturanBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> AGAVE = registerBlockWithoutItem("agave",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> PUNGA = registerBlockWithoutItem("punga",
            () -> new PungaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> NEOAGAVE = registerBlockWithoutItem("neoagave",
            () -> new SmallAgeRadPlant(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> GLOWRESINBLOCK = registerBlockWithoutItem("glowresinblock",
            () -> new ResinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).instabreak().lightLevel((p_50892_) -> {
                return 2;

            })));


    public static final RegistryObject<Block> MEGASLOTHBLOCK = registerBlockWithoutItem("megaslotmush",
            () -> new MegaSlothBlock(BlockBehaviour.Properties.of().sound(SoundType.MOSS).mapColor(MapColor.GRASS).instabreak()));

    public static final RegistryObject<Block> BBLIGHTMUSH = registerBlockWithoutItem("bblightmush",
            () -> new BBlightMushroom(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.MOSS).instabreak()));

    public static final RegistryObject<Block> GLOWSAP = registerBlockWithoutItem("glowsap",
            () -> new GloamSapBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).instabreak().lightLevel((p_50892_) -> {
                return 4;

            })));

    public static final RegistryObject<Block> GINSENG = registerBlockWithoutItem("ginseng",
            () -> new GinsengBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> NUKAROOT = registerBlockWithoutItem("nukaroot",
            () -> new NukaRootBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> CORALLEAF = registerBlockWithoutItem("coral_leaf",
            () -> new CoralLeafBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> PRISMLEAF = registerBlockWithoutItem("prism_leaf",
            () -> new PrismLeafBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> DEAD_PUNGA = registerBlock("dead_punga",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> DEAD_DATURAN = registerBlock("dead_daturan",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> DEAD_CORALLEAF = registerBlock("dead_coralleaf",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<Block> ZANDER = registerBlockWithoutItem("zander",
            () -> new ModFlowerBlock(MobEffects.DIG_SPEED, 0,
                    BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> STORAGE = registerBlock("storage1",
            () -> new BasicStorageBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(1f), "SideHalf"));


//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> FRIDGE = registerBlock("fridge",
            () -> new BasicStorageBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2f), "FullBlock"));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> VENT = registerBlock("vent_tube",
            () -> new VentTubeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2f)));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> COOLER = registerBlock("cooler",
            () -> new BasicStorageBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2f), "FullBlock"));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> VTCRATE = registerBlock("vtcrate1",
            () -> new BasicStorageBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2f), "FullBlock"));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> VTCRATE2 = registerBlock("vtcrate2",
            () -> new LockableStorage(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2f), "FullBlock"));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> WOODCRATE = registerBlock("woodcrate",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(1f)));


//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> ARMEDGLASS = registerBlock("armedglass",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS).mapColor(MapColor.ICE)
                    .strength(1.4F).sound(SoundType.GLASS)));


//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> STEEL_BARS = registerBlock("steel_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));


//    @DataGen
    public static final RegistryObject<Block> RUSTY_STEEL_BARS = registerBlock("rusty_steel_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.4f, 6.7f).requiresCorrectToolForDrops()));


//    @DataGen
    public static final RegistryObject<Block> RUSTY_DOOR = registerBlock("rustdoor",
            () -> new DoorBlock(
                    BlockBehaviour.Properties.of()
                            .sound(SoundType.METAL)
                            .mapColor(MapColor.METAL)
                            .requiresCorrectToolForDrops()
                            .strength(5.0F)
                            .sound(SoundType.METAL)
                            .noOcclusion(), BlockSetType.OAK)
    );

//    @DataGen
    public static final RegistryObject<Block> CAGEDOOR = registerBlock("door_cage",
            () -> new DoorBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion(), BlockSetType.OAK));

//    @DataGen
    public static final RegistryObject<Block> DECAYDOOR = registerBlock("decay_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> STOREDOOR = registerBlock("door_store",
            () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> REDDOOR = registerBlock("door_red",
            () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> GREENDOOR = registerBlock("door_green",
            () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> WHITEDOOR = registerBlock("door_white",
            () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> HARDDOOR = registerBlock("door_hardened",
            () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.5F).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> RREDDOOR = registerBlock("rreddoor",
            () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.0F).sound(SoundType.METAL).noOcclusion(), BlockSetType.OAK));

//    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SHELTERBARS = registerBlock("shelter_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SUPPORTWALL = registerBlock("supportwall",
            () -> new VaultSupportBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops(), "wall"));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SUPPORTWALLTOP = registerBlock("supportwalltop",
            () -> new VaultSupportBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops(), "walltop"));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SUPPORTTOP = registerBlock("supporttop",
            () -> new VaultSupportBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops(), "top"));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RUST_SUPPORT_WALL = registerBlock("rustsupportwall",
            () -> new VaultSupportBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops(), "wall"));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RUST_SUPPORTWALL_TOP = registerBlock("rustsupportwalltop",
            () -> new VaultSupportBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops(), "walltop"));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RUST_SUPPORT_TOP = registerBlock("rustsupporttop",
            () -> new VaultSupportBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.1f, 5.7f).requiresCorrectToolForDrops(), "top"));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> SERVER_BLOCK = registerBlock("comblock",
            () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.2f, 4.4f).requiresCorrectToolForDrops()));

    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RADIO_TERMINAL = registerBlock("radioterminal",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.1f, 4.1f).requiresCorrectToolForDrops()));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> BARREL = registerBlock("barrel",
            () -> new RadBarrelBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.1f, 4.1f).requiresCorrectToolForDrops(), 0.5f));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> EXPLOSIVE_BARREL = registerBlock("expbarrel",
            () -> new ExplosiveBarrel(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(2.1f, 4.1f).requiresCorrectToolForDrops()));


    @DataGen(type = ResourceType.BLOCK)
    public static final RegistryObject<Block> RUSTYPIPE = registerBlock("rusty_pipe",
            () -> new PipeBlock(BlockBehaviour.Properties.of().sound(SoundType.METAL).mapColor(MapColor.METAL)
                    .strength(1.1f, 4.1f).requiresCorrectToolForDrops()));


//    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
//        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
//    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
        };
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        var toReturn = BLOCKS.register(name, block);
        ModBlockItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));

        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
