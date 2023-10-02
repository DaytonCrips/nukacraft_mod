package com.dayton.nukacraft.common.foundation.container;

import com.dayton.nukacraft.common.foundation.container.screen.PowerArmorScreen;
import com.dayton.nukacraft.common.foundation.container.screen.PowerArmorStationScreen;
import net.minecraft.client.gui.screens.MenuScreens;

public class GuiRegistry {
    public static void register() {
        MenuScreens.register(ContainerRegistry.POWER_CHASSIS_MENU.get(), PowerArmorScreen::new);
        MenuScreens.register(ContainerRegistry.ARMOR_STATION_MENU.get(), PowerArmorStationScreen::new);
    }
}
