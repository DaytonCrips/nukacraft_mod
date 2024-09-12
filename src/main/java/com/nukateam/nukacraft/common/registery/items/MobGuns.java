package com.nukateam.nukacraft.common.registery.items;

import com.nukateam.ntgl.common.foundation.item.AmmoItem;
import com.nukateam.ntgl.common.foundation.item.GrenadeItem;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.ntgl.common.foundation.item.StunGrenadeItem;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.annotation.DataGen;
import com.nukateam.nukacraft.common.foundation.ModTiers;
import com.nukateam.nukacraft.common.foundation.items.frame.FusionCoreItem;
import com.nukateam.nukacraft.common.foundation.items.guns.BaseGrenadeItem;
import com.nukateam.nukacraft.common.foundation.items.guns.TechnicGun;
import com.nukateam.nukacraft.common.foundation.items.guns.TeslaGun;
import com.nukateam.nukacraft.common.foundation.items.misc.SimpleMeleeWeapon;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobGuns {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<GunItem> SECURITRON_GUN = registerTechnicGun("securitron_gun");
    public static final RegistryObject<GunItem> SECURITRON_LASER = registerTechnicGun("securitron_laser");
    public static final RegistryObject<GunItem> ASSAULTRON_LASER = registerTechnicGun("assaultron_laser");

    public static RegistryObject<GunItem> registerTechnicGun(String name) {
        return ITEMS.register(name, () -> new TechnicGun(new Item.Properties().stacksTo(1)));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
