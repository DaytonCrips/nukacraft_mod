package com.dayton.nukacraft.common.container.screen;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.container.menu.PowerChassisMenu;
import com.jetug.chassis_core.common.foundation.container.screen.ChassisScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PowerArmorScreen extends ChassisScreen<PowerChassisMenu> {
    public PowerArmorScreen(PowerChassisMenu container, Inventory inventory, Component name) {
        super(container, inventory, name, new ResourceLocation(NukaCraftMod.MOD_ID, "textures/gui/power_armor_inventory.png"));
    }
}