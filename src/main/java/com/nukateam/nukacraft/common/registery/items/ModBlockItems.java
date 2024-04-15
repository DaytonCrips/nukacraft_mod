package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.GearDoorBlock;
import com.nukateam.nukacraft.common.foundation.items.сonsumables.*;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.nukateam.nukacraft.common.registery.ModItemTabs.NUKA_BLOCKS;

public class ModBlockItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<Item> FIREFUNGI = ITEMS.register("firemushroom",
            () -> new ItemNameBlockItem(ModBlocks.FIREMUSHROOM.get(), new Item.Properties()));

    public static final RegistryObject<Item> GLOWMUSHROOM = ITEMS.register("glowfungus",
            () -> new ItemNameBlockItem(ModBlocks.GLOWFUNGUS.get(), new Item.Properties()));

    public static final RegistryObject<Item> GUTMUSHROOM = ITEMS.register("gutshroom",
            () -> new ItemNameBlockItem(ModBlocks.GUTFUNGI.get(), new Item.Properties()));

    public static final RegistryObject<Item> MEGAHATTER = ITEMS.register("megamorph_hatter",
            () -> new ItemNameBlockItem(ModBlocks.MEGAHATTERFUNGI.get(), new Item.Properties()));

    public static final RegistryObject<Item> HATTER = ITEMS.register("hatter",
            () -> new ItemNameBlockItem(ModBlocks.HATTERFUNGI.get(), new Item.Properties()));

    public static final RegistryObject<Item> MUTSHMUSHROOM = ITEMS.register("mutshootfungus",
            () -> new ItemNameBlockItem(ModBlocks.MUTTSHOOTFUNGUS.get(), new Item.Properties()));

    public static final RegistryObject<Item> BLASTCAPFUNGI = ITEMS.register("blastcap",
            () -> new ItemNameBlockItem(ModBlocks.BLASTCAP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
