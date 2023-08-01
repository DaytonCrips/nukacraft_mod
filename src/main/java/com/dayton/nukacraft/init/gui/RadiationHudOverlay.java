package com.dayton.nukacraft.init.gui;


import ca.weblite.objc.Client;
import com.dayton.nukacraft.NukaCraftMod;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.client.gui.OverlayRegistry;

import java.util.logging.Level;

@OnlyIn(Dist.CLIENT)
public class RadiationHudOverlay {

//    public static final IIngameOverlay RAD_OVERLAY;

    public RadiationHudOverlay(){}
    public static void register(){}
//    public static void render(ForgeIngameGui gui, int screenWidth, int screenHeight, PoseStack poseStack) {
//        Minecraft mc = Minecraft.getInstance();
//        Player player = mc.player;
//        if (!player.isCreative() && !player.isSpectator()) {
//            int left = screenWidth / 2 - 10;
//            int top = screenHeight - gui.right_height;
//            gui.right_height += 10;
//            double attrMaxHealth = player.getAttribute(Attributes.MAX_HEALTH).getValue();
//            double val = 10-Math.round(attrMaxHealth/2);
//            RenderSystem.disableDepthTest();
//            RenderSystem.depthMask(false);
//            RenderSystem.enableBlend();
//            RenderSystem.setShader(GameRenderer::getPositionTexShader);
//            RenderSystem.depthMask(true);
//            RenderSystem.defaultBlendFunc();
//            RenderSystem.enableDepthTest();
//            RenderSystem.setShaderColor(1, 1, 1, 1);
//            RenderSystem.setShaderTexture(0, new ResourceLocation("nukacraft:textures/screens/radhearth.png"));
//            for(int i = 0; i < val; ++i) {
//                int x = left - i * 8 - 9;
//                gui.blit(poseStack, x, top, 0, 0, 9, 9, 9, 9);
//            }
//        }
//    }
//    static {
//        RAD_OVERLAY = OverlayRegistry.registerOverlayAbove(ForgeIngameGui.HELMET_ELEMENT, "RadLevel", ((gui, poseStack, partialTick, width, height) -> {render(gui, width, height, poseStack);}));
//    }


}
