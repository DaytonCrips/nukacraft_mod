package com.dayton.nukacraft.common.foundation.container.screen;

import com.dayton.nukacraft.common.foundation.container.menu.PowerArmorStationMenu;
import com.jetug.chassis_core.client.gui.screen.ArmorStationScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;

public class PowerArmorStationScreen extends ArmorStationScreen<PowerArmorStationMenu> {
    public PowerArmorStationScreen(PowerArmorStationMenu menu, Inventory pPlayerInventory, Component pTitle) {
        super(menu, pPlayerInventory, pTitle, nukaResource( "textures/gui/power_armor_station_gui.png"));
    }
}
