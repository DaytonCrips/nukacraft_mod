package com.dayton.nukacraft.common.foundation.container;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.foundation.container.menu.PowerArmorStationMenu;
import com.dayton.nukacraft.common.foundation.container.menu.PowerArmorMenu;
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


    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return CONTAINERS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}
