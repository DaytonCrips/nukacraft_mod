package com.nukateam.nukacraft.client.render.gui.screen;

import com.jetug.chassis_core.client.gui.screen.ChassisScreen;
import com.jetug.chassis_core.client.gui.ui.IconButton;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import com.nukateam.nukacraft.common.foundation.container.PowerArmorMenu;
import com.nukateam.nukacraft.common.network.PacketHandler;
import com.nukateam.nukacraft.common.network.packets.FramePickupPacket;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.jetug.chassis_core.Global.referenceMob;
import static com.nukateam.nukacraft.common.data.constants.Textures.POWER_ARMOR_GUI;
import static net.minecraft.network.chat.CommonComponents.GUI_DONE;

@OnlyIn(Dist.CLIENT)
public class PowerArmorScreen extends ChassisScreen<PowerArmorMenu> {
    public PowerArmorScreen(PowerArmorMenu container, Inventory inventory, Component name) {
        super(container, inventory, name, POWER_ARMOR_GUI);
    }

    @Override
    protected void init() {
        super.init();
        this.addButton(new IconButton(leftPos + 133, topPos + 49, 88, 166, GUI_DONE, POWER_ARMOR_GUI) {
            @Override
            public void onPress() {
                if (referenceMob != null)
                    PacketHandler.sendToServer(new FramePickupPacket(referenceMob.getId()));
            }
        });
    }

    @Override
    protected void renderEntity(WearableChassis powerArmor) {
        float scale = 1.0F / Math.max(1.0E-4F, powerArmor.getScale());
        InventoryScreen.renderEntityInInventory(this.leftPos + 32, this.topPos + 73, (int) (scale * 23.0F),
                (float) (this.leftPos + 51) - this.mousePosX, (float) (this.topPos + 75 - 50) - this.mousePosY, powerArmor);
    }
}