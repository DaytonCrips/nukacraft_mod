package com.dayton.nukacraft.client.gui;


//@Mod.EventBusSubscriber(Dist.CLIENT)
//public class RadiationGui {
//    @SubscribeEvent(priority = EventPriority.NORMAL)
//    public static void eventHandler(RenderGameOverlayEvent.Pre event) {
//        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
//            Minecraft mc = Minecraft.getInstance();
//            Player player = mc.player;
//            int gui_scale = 39;
//            if (!player.isCreative() && !player.isSpectator()) {
//                int w = event.getWindow().getGuiScaledWidth() / 2;
//                int h = event.getWindow().getGuiScaledHeight() - gui_scale;
//                double attrMaxHealth = player.getAttribute(Attributes.MAX_HEALTH).getValue();
//                double val = 10-Math.round(attrMaxHealth/2);
//                RenderSystem.disableDepthTest();
//                RenderSystem.depthMask(false);
//                RenderSystem.enableBlend();
//                RenderSystem.setShader(GameRenderer::getPositionTexShader);
//                RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
//                        GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
//                RenderSystem.setShaderColor(1, 1, 1, 1);
//                RenderSystem.setShaderTexture(0, new ResourceLocation(RAD_HEART_ICON));
//                for (int i = 0; i < val; ++i) {
//                    int x = w - i * 8 - 9;
//                    Minecraft.getInstance().gui.blit(event.getMatrixStack(), x-10, h, 0, 0, 9, 9, 9, 9);
//                }
//                RenderSystem.depthMask(true);
//                RenderSystem.defaultBlendFunc();
//                RenderSystem.enableDepthTest();
//                RenderSystem.disableBlend();
//                RenderSystem.setShaderColor(1, 1, 1, 1);
//            }
//
//        }
//    }
//
//}
