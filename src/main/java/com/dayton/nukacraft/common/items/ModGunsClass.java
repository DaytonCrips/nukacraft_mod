package com.dayton.nukacraft.common.items;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.helpers.Scopes;
import com.dayton.nukacraft.common.ExtraGunModifiers;
import com.dayton.nukacraft.common.items.guns.MagazineItem;
import com.dayton.nukacraft.common.items.guns.PistolGun;
import com.mrcrayfish.guns.item.*;
import com.mrcrayfish.guns.item.attachment.impl.Barrel;
import com.mrcrayfish.guns.item.attachment.impl.Stock;
import com.mrcrayfish.guns.item.attachment.impl.UnderBarrel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModGunsClass {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);



    ///GUNS
    public static final RegistryObject<GunItem> PISTOL10MM = ITEMS.register("pistol10mm", () -> new PistolGun(new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<GunItem> PIPE_PISTOL = ITEMS.register("pipepistol", () -> new PistolGun(new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<GunItem> CLASSIC10MM = ITEMS.register("classic10mm", () -> new PistolGun(new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<GunItem> SCOUT10MM = ITEMS.register("scout10mm", () -> new PistolGun(new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<GunItem> CLASSIC10MM_ZAP = ITEMS.register("classic10mm_zapaway", () -> new PistolGun(new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<GunItem> PIPEREVOLVER = ITEMS.register("piperevolver", () -> new PistolGun(new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));






    ///ATTACHMENT
    public static final RegistryObject<Item> MAGAZINE1  = ITEMS.register("magazine_t1", () -> new MagazineItem(UnderBarrel.create(ExtraGunModifiers.MAGAZINES), new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> MAGAZINE2  = ITEMS.register("magazine_t2", () -> new MagazineItem(UnderBarrel.create(ExtraGunModifiers.MAGAZINES), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> MAGAZINE3  = ITEMS.register("magazine_t3", () -> new MagazineItem(UnderBarrel.create(ExtraGunModifiers.MAGAZINES), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).tab(ModItemTabs.NUKA_EQUIP)));

    public static final RegistryObject<Item> SILENCER  = ITEMS.register("army_silencer", () -> new BarrelItem(Barrel.create(2, ExtraGunModifiers.ARMY_SILENCER), new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> OLD_SCOPE = ITEMS.register("old_scope", () -> new ScopeItem(Scopes.OLD_SCOPE, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> HUNTING_SCOPE = ITEMS.register("hunting_scope", () -> new ScopeItem(Scopes.HUNTING_SCOPE, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> OLD_SILENCER  = ITEMS.register("old_silencer", () -> new BarrelItem(Barrel.create(2, ExtraGunModifiers.OLD_SILENCER), new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> HANDMADE_COLLIMATOR = ITEMS.register("handmade_collimator", () -> new ScopeItem(Scopes.HANDMADE_COLL, new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> HANDMADE_SCOPE = ITEMS.register("handmade_scope", () -> new ScopeItem(Scopes.HUNTING_SCOPE, new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> HANDMADE_STOCK  = ITEMS.register("handmade_stock", () -> new StockItem(Stock.create(ExtraGunModifiers.HANDMADE_STOCK), new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));
    public static final RegistryObject<Item> HANDMADE_FLASHER  = ITEMS.register("handmade_flashhider", () -> new BarrelItem(Barrel.create(2, ExtraGunModifiers.HANDMADE_FLASHER), new Item.Properties().stacksTo(1).tab(ModItemTabs.NUKA_EQUIP)));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
