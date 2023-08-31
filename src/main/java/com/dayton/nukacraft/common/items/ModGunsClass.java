package com.dayton.nukacraft.common.items;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.items.guns.PistolGun;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModGunsClass {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<GunItem> PISTOL10MM = ITEMS.register("pistol10mm", () -> new PistolGun(new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<GunItem> PIPE_PISTOL = ITEMS.register("pipepistol", () -> new PistolGun(new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<GunItem> CLASSIC10MM = ITEMS.register("classic10mm", () -> new PistolGun(new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));


}
