package com.nukateam.nukacraft.client.render.gui.hud;

import com.jetug.chassis_core.common.util.helpers.PlayerUtils;
import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class PowerArmorHud {


    private static final int BAR_OFFSET_X = 95;
    private static final ResourceLocation DURABILITY_SENSOR = nukaResource("textures/gui/hud/durability/durability_sensor.png");
    private static final ResourceLocation DURABILITY_ARROW = nukaResource("textures/gui/hud/durability/durability_flag.png");
    private static final ResourceLocation DURABILITY_HELMET = nukaResource("textures/gui/hud/durability/helmet_indicator.png");
    private static final ResourceLocation DURABILITY_CHEST = nukaResource("textures/gui/hud/durability/chest_indicator.png");
    private static final ResourceLocation DURABILITY_L_HAND = nukaResource("textures/gui/hud/durability/left_hand_indicator.png");
    private static final ResourceLocation DURABILITY_R_HAND = nukaResource("textures/gui/hud/durability/right_hand_indicator.png");
    private static final ResourceLocation DURABILITY_L_LEG = nukaResource("textures/gui/hud/durability/left_leg_indicator.png");
    private static final ResourceLocation DURABILITY_R_LEG = nukaResource("textures/gui/hud/durability/right_leg_indicator.png");

    private static final ResourceLocation POWER_SENSOR = nukaResource("textures/gui/hud/energy/power_sensor.png");
    private static final ResourceLocation POWER_ARROW = nukaResource("textures/gui/hud/energy/power_flag.png");
    private static final ResourceLocation NO_POWER = nukaResource("textures/gui/hud/energy/empty.png");
    private static final ResourceLocation LOW_POWER = nukaResource("textures/gui/hud/energy/low_power.png");
    private static final ResourceLocation WORK = nukaResource("textures/gui/hud/energy/work.png");



    public static final IGuiOverlay POWER_ARMOR_HUD = ((gui, graphics, partialTick, width, height) -> {
        if(!PlayerUtils.isLocalWearingChassis()) return;
        var chasis = PlayerUtils.getLocalPlayerChassis();
        var minecraft = Minecraft.getInstance();
        if(minecraft.player == null) return;
        var y = height - 39;
        var x = width / 2;
        var poseStack = graphics.pose();
        ItemStack core = chasis.inventory.getItem(6);
        poseStack.pushPose();
        {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }
        poseStack.popPose();
        graphics.blit(DURABILITY_SENSOR, -4, height - 127, 0, 0, 128, 127, 128, 127);
        graphics.blit(DURABILITY_ARROW, 60, height - 24, 0, 0, 5, 6, 5, 6);

        graphics.blit(POWER_SENSOR, width - 128, height - 127, 0, 0, 128, 127, 128, 127);
        graphics.blit(POWER_ARROW, width - 104, height - 23, 0, 0, 5, 9, 5, 9);








        //graphics.setColor(1f, 0, 0, 1); red
        //graphics.setColor(1f, 0.808f, 0.322f, 1); yellow
        //graphics.setColor(1f, 0.447f, 0, 1); orange
        if (!(chasis.inventory.getItem(1).isEmpty())) {
            graphics.blit(DURABILITY_CHEST, -4, height - 127, 0, 0, 128, 127, 128, 127);
        }
        if (!(chasis.inventory.getItem(2).isEmpty())) {
            graphics.blit(DURABILITY_L_HAND, -4, height - 127, 0, 0, 128, 127, 128, 127);
        }
        if (!(chasis.inventory.getItem(3).isEmpty())) {
            graphics.blit(DURABILITY_R_HAND, -4, height - 127, 0, 0, 128, 127, 128, 127);
        }
        if (!(chasis.inventory.getItem(4).isEmpty())) {
            graphics.blit(DURABILITY_L_LEG, -4, height - 127, 0, 0, 128, 127, 128, 127);
        }
        if (!(chasis.inventory.getItem(5).isEmpty())) {
            graphics.blit(DURABILITY_R_LEG, -4, height - 127, 0, 0, 128, 127, 128, 127);
        }
        if (!(chasis.inventory.getItem(0).isEmpty())) {
            graphics.blit(DURABILITY_HELMET, -4, height - 127, 0, 0, 128, 127, 128, 127);
        }
        if (!(core.getItem() instanceof AirItem)) {
            graphics.blit(WORK, width - 56, height - 50, 0, 0, 11, 21, 11, 21);
            if (core.getDamageValue() >= 410) {
            NukaCraftMod.LOGGER.debug(String.valueOf(chasis.inventory.getItem(6).getDamageValue()));
            graphics.blit(LOW_POWER, width - 36, height - 50, 0, 0, 11, 21, 11, 21);
        }
        } else {
            graphics.blit(NO_POWER, width - 16, height - 50, 0, 0, 11, 21, 11, 21);
        }
//        if (!(chasis.inventory.getItem(6).isEmpty()) && chasis.inventory.getItem(6).getDamageValue() >= 410) {
//            NukaCraftMod.LOGGER.debug(String.valueOf(chasis.inventory.getItem(6).getDamageValue()));
//            graphics.blit(LOW_POWER, width - 36, height - 50, 0, 0, 11, 21, 11, 21);
//        }




        x += BAR_OFFSET_X;
        x -= BAR_OFFSET_X - 26;
    });
}