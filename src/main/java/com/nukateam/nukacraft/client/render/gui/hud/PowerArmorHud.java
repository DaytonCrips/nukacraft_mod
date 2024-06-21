package com.nukateam.nukacraft.client.render.gui.hud;

import com.jetug.chassis_core.common.util.helpers.PlayerUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.utils.PowerArmorUtils;
import mod.azure.azurelib.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.util.List;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class PowerArmorHud {
    private static final int BAR_OFFSET_X = 95;
    private static final ResourceLocation DURABILITY_SENSOR = nukaResource("textures/gui/hud/durability/durability_sensor.png");
    private static final ResourceLocation DURABILITY_ARROW  = nukaResource("textures/gui/hud/durability/durability_flag.png");
    private static final ResourceLocation DURABILITY_HELMET = nukaResource("textures/gui/hud/durability/helmet_indicator.png");
    private static final ResourceLocation DURABILITY_CHEST  = nukaResource("textures/gui/hud/durability/chest_indicator.png");
    private static final ResourceLocation DURABILITY_L_HAND = nukaResource("textures/gui/hud/durability/left_hand_indicator.png");
    private static final ResourceLocation DURABILITY_R_HAND = nukaResource("textures/gui/hud/durability/right_hand_indicator.png");
    private static final ResourceLocation DURABILITY_L_LEG  = nukaResource("textures/gui/hud/durability/left_leg_indicator.png");
    private static final ResourceLocation DURABILITY_R_LEG  = nukaResource("textures/gui/hud/durability/right_leg_indicator.png");

    private static final ResourceLocation POWER_SENSOR = nukaResource("textures/gui/hud/energy/power_sensor.png");
    private static final ResourceLocation POWER_ARROW = nukaResource("textures/gui/hud/energy/power_flag.png");
    private static final ResourceLocation NO_POWER = nukaResource("textures/gui/hud/energy/empty.png");
    private static final ResourceLocation LOW_POWER = nukaResource("textures/gui/hud/energy/low_power.png");
    private static final ResourceLocation WORK = nukaResource("textures/gui/hud/energy/work.png");

    private static final ResourceLocation[] INDICATORS = new ResourceLocation[]{
            DURABILITY_HELMET,
            DURABILITY_CHEST ,
            DURABILITY_L_HAND,
            DURABILITY_R_HAND,
            DURABILITY_L_LEG ,
            DURABILITY_R_LEG };

    public static final IGuiOverlay POWER_ARMOR_HUD = ((gui, graphics, partialTick, width, height) -> {
        if(!PowerArmorUtils.isLocalWearingPowerArmor()) return;
        var frame = PowerArmorUtils.getPowerArmor();
        var minecraft = Minecraft.getInstance();
        if(minecraft.player == null) return;
        var core = frame.inventory.getItem(6);


        var coreDamage = (float)core.getDamageValue();
        var coreMaxDamage = (float)core.getMaxDamage();
        var maxXPos = 95;
        var chargePercent = coreDamage / coreMaxDamage;
        var xPos = (int)(maxXPos * chargePercent);

        graphics.blit(DURABILITY_SENSOR, -4, height - 127, 0, 0, 128, 127, 128, 127);
        graphics.blit(DURABILITY_ARROW, 60, height - 24, 0, 0, 5, 6, 5, 6);

        graphics.blit(POWER_SENSOR, width - 128, height - 127, 0, 0, 128, 127, 128, 127);
        graphics.blit(POWER_ARROW, width - 104 + xPos, height - 23, 0, 0, 5, 9, 5, 9);

       for (var i = 0; i < 6 ; i++){
           var item = frame.inventory.getItem(i);
           if(!item.isEmpty() && item.getDamageValue() < item.getMaxDamage()) {
               setIndicatorColor(item);
               graphics.blit(INDICATORS[i], -4, height - 127, 0, 0,
                       128, 127, 128, 127);
               RenderSystem.setShaderColor(1, 1, 1, 1);
           }
       }

        if (!core.isEmpty()){
            graphics.blit(WORK, width - 56, height - 50, 0, 0, 11, 21, 11, 21);
            if (core.getDamageValue() >= (core.getMaxDamage() / 3) * 2) {
                graphics.blit(LOW_POWER, width - 36, height - 50, 0, 0, 11, 21, 11, 21);
            }
        } else {
            graphics.blit(NO_POWER, width - 16, height - 50, 0, 0, 11, 21, 11, 21);
        }
//        if (!(frame.inventory.getItem(6).isEmpty()) && frame.inventory.getItem(6).getDamageValue() >= 410) {
//            NukaCraftMod.LOGGER.debug(String.valueOf(frame.inventory.getItem(6).getDamageValue()));
//            graphics.blit(LOW_POWER, width - 36, height - 50, 0, 0, 11, 21, 11, 21);
//        }
    });

    private static void blit(GuiGraphics gui, ResourceLocation resourceLocation,
                             int pX1, int pX2, int pY1, int pY2,
                             int pUWidth, int pVHeight){
        gui.blit(resourceLocation, pX1, pX2, pY1, pY2, pUWidth, pVHeight, pUWidth, pVHeight);
    }

    private static void setIndicatorColor(ItemStack stack){
        var damage = stack.getDamageValue();
        var part = stack.getMaxDamage() / 3;
        if(damage < part)
            RenderSystem.setShaderColor(0.2f,0.5f,0.2f,1);
        else if(damage < part * 2)
            RenderSystem.setShaderColor(0.9f,0.8f,0.0f,1);
        else
            RenderSystem.setShaderColor(0.8f,0.1f,0.1f,1);
    }
}