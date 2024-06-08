package com.nukateam.nukacraft.client.render.gui.hud;

import com.jetug.chassis_core.common.util.helpers.PlayerUtils;
import com.nukateam.ntgl.common.base.gun.Gun;
import com.nukateam.ntgl.common.data.util.GunEnchantmentHelper;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class PowerArmorHud {
    private static final int BAR_OFFSET_X = 95;
    private static final ResourceLocation DURABILITY_SENSOR = nukaResource("textures/gui/hud/durability_sensor.png");
    private static final ResourceLocation POWER_SENSOR = nukaResource("textures/gui/hud/power_sensor.png");

    public static final IGuiOverlay POWER_ARMOR_HUD = ((gui, graphics, partialTick, width, height) -> {
        if(!PlayerUtils.isLocalWearingChassis()) return;
        var minecraft = Minecraft.getInstance();
        if(minecraft.player == null) return;
        var y = height - 39;
        var x = width / 2;

        var poseStack = graphics.pose();
        poseStack.pushPose();
        {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }
        poseStack.popPose();
        graphics.blit(DURABILITY_SENSOR, -4, height - 127, 0, 0, 128, 127, 128, 127);
        graphics.blit(POWER_SENSOR, width - 128, height - 127, 0, 0, 128, 127, 128, 127);

        x += BAR_OFFSET_X;
        x -= BAR_OFFSET_X - 26;


    });
}