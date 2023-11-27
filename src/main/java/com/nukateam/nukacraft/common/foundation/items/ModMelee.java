package com.nukateam.nukacraft.common.foundation.items;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.client.helpers.ModTiers;
import com.nukateam.nukacraft.common.foundation.items.melees.SimpleMeleeWeapon;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMelee {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<Item> CLEAVER = ITEMS.register("cleaver",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 1, -2,
                    new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> COMBATKNIFE = ITEMS.register("combatknife",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 1, -1,
                    new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> COSMICKNIFE = ITEMS.register("cosmicknife",
            () -> new SimpleMeleeWeapon(ModTiers.LOWSTEEL, 0, 0,
                    new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));
    public static final RegistryObject<Item> COMBATPIPE = ITEMS.register("combatpipe",
            () -> new SimpleMeleeWeapon(ModTiers.SCRAP, 0, 0,
                    new Item.Properties().tab(ModItemTabs.NUKA_WEAPONS)));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
