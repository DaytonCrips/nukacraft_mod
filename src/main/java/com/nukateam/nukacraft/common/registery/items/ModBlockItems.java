package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.annotation.DataGen;
import com.nukateam.nukacraft.common.registery.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

    @DataGen
    public static final RegistryObject<Item> BLASTCAPFUNGI = ITEMS.register("blastcap",
            () -> new ItemNameBlockItem(ModBlocks.BLASTCAP.get(), new Item.Properties()));

    @DataGen
    public static final RegistryObject<Item> VAULT_DOOR = ITEMS.register("vault_door",
            () -> new BlockItem(ModBlocks.GEAR_DOOR.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
