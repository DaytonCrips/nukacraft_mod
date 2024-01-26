package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoyScreen;
import com.nukateam.nukacraft.client.render.gui.screen.PowerArmorScreen;
import com.nukateam.nukacraft.client.render.gui.screen.PowerArmorStationScreen;
import net.minecraft.client.gui.screens.*;

public class GuiRegistry {
    public static void register() {
        MenuScreens.register(ContainerRegistry.POWER_CHASSIS_MENU.get(), PowerArmorScreen::new);
        MenuScreens.register(ContainerRegistry.ARMOR_STATION_MENU.get(), PowerArmorStationScreen::new);
        MenuScreens.register(ContainerRegistry.PIPBOY.get(), PipBoyScreen::new);
    }
}
