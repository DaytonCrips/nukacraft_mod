package com.dayton.nukacraft.client.gui;


import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.dayton.nukacraft.common.data.constants.Textures.RAD_HEART_ICON;

@Mod.EventBusSubscriber({Dist.CLIENT})

public class RadiationGui {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            Minecraft mc = Minecraft.getInstance();
            Player player = mc.player;
            int gui_scale = 39;
            if (!player.isCreative() && !player.isSpectator()) {
                int w = event.getWindow().getGuiScaledWidth() / 2;
                int h = event.getWindow().getGuiScaledHeight() - gui_scale;
                double attrMaxHealth = player.getAttribute(Attributes.MAX_HEALTH).getValue();
                double val = 10-Math.round(attrMaxHealth/2);
                RenderSystem.disableDepthTest();
                RenderSystem.depthMask(false);
                RenderSystem.enableBlend();
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                        GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                RenderSystem.setShaderColor(1, 1, 1, 1);
                RenderSystem.setShaderTexture(0, new ResourceLocation(RAD_HEART_ICON));
                for (int i = 0; i < val; ++i) {
                    int x = w - i * 8 - 9;
                    Minecraft.getInstance().gui.blit(event.getMatrixStack(), x-10, h, 0, 0, 9, 9, 9, 9);
                }
                RenderSystem.depthMask(true);
                RenderSystem.defaultBlendFunc();
                RenderSystem.enableDepthTest();
                RenderSystem.disableBlend();
                RenderSystem.setShaderColor(1, 1, 1, 1);
            }

        }
    }

}
