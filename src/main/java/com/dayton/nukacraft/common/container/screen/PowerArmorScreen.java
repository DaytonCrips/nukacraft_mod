package com.dayton.nukacraft.common.container.screen;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.container.menu.PowerChassisMenu;
import com.jetug.chassis_core.common.foundation.container.screen.ChassisScreen;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PowerArmorScreen extends ChassisScreen<PowerChassisMenu> {
    public PowerArmorScreen(PowerChassisMenu container, Inventory inventory, Component name) {
        super(container, inventory, name, new ResourceLocation(NukaCraftMod.MOD_ID, "textures/gui/power_armor_inventory.png"));
    }

    @Override
    protected void renderEntity(WearableChassis powerArmor) {
        float scale = 1.0F / Math.max(1.0E-4F, powerArmor.getScale());
        InventoryScreen.renderEntityInInventory(this.leftPos + 32, this.topPos + 73, (int)(scale * 23.0F),
                (float)(this.leftPos + 51) - this.mousePosX, (float)(this.topPos + 75 - 50) - this.mousePosY, powerArmor);
    }
}