package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.container.PipBoyMenu;
import com.nukateam.nukacraft.common.foundation.container.PowerArmorMenu;
import com.nukateam.nukacraft.common.foundation.container.PowerArmorStationMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ContainerRegistry {
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister
            .create(ForgeRegistries.CONTAINERS, NukaCraftMod.MOD_ID);

    public static final RegistryObject<MenuType<PowerArmorMenu>> POWER_CHASSIS_MENU
            = CONTAINERS.register("power_armor_menu", () -> new MenuType<>(PowerArmorMenu::new));

    public static final RegistryObject<MenuType<PowerArmorStationMenu>> ARMOR_STATION_MENU
            = CONTAINERS.register("power_armor_station_menu", () -> new MenuType<>(PowerArmorStationMenu::new));

    public static final RegistryObject<MenuType<PipBoyMenu>> PIPBOY
            = CONTAINERS.register("pipboy", () -> new MenuType<>(PipBoyMenu::new));

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return CONTAINERS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
