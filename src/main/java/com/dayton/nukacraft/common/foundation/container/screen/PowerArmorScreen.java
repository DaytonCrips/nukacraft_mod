package com.dayton.nukacraft.common.foundation.container.screen;

import com.dayton.nukacraft.common.foundation.container.menu.PowerArmorMenu;
import com.dayton.nukacraft.common.network.PacketHandler;
import com.dayton.nukacraft.common.network.packets.FramePickupPacket;
import com.jetug.chassis_core.client.gui.screen.ChassisScreen;
import com.jetug.chassis_core.client.gui.ui.IconButton;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;
import static com.jetug.chassis_core.Global.referenceMob;
import static net.minecraft.network.chat.CommonComponents.GUI_DONE;

@OnlyIn(Dist.CLIENT)
public class PowerArmorScreen extends ChassisScreen<PowerArmorMenu> {
    public static final ResourceLocation POWER_ARMOR_GUI = nukaResource("textures/gui/power_armor_inventory.png");
    public PowerArmorScreen(PowerArmorMenu container, Inventory inventory, Component name) {
        super(container, inventory, name, POWER_ARMOR_GUI);
    }

    @Override
    protected void init() {
        super.init();
        this.addButton(new IconButton(leftPos + 133, topPos + 49, 88, 166, GUI_DONE, POWER_ARMOR_GUI) {
            @Override
            public void onPress() {
                PacketHandler.sendToServer(new FramePickupPacket(referenceMob.getId()));
            }
        });
    }

    @Override
    protected void renderEntity(WearableChassis powerArmor) {
        float scale = 1.0F / Math.max(1.0E-4F, powerArmor.getScale());
        InventoryScreen.renderEntityInInventory(this.leftPos + 32, this.topPos + 73, (int)(scale * 23.0F),
                (float)(this.leftPos + 51) - this.mousePosX, (float)(this.topPos + 75 - 50) - this.mousePosY, powerArmor);
    }
}