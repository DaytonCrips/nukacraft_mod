package com.nukateam.map.impl.atlas.client.gui;

import com.nukateam.map.impl.atlas.client.Textures;
import com.nukateam.map.impl.atlas.client.gui.core.GuiComponentButton;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.common.data.utils.PipBoyUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;
import org.lwjgl.opengl.GL11;

import java.util.Collections;

public class GuiPositionButton extends GuiComponentButton {
    private static final int WIDTH = 11;
    private static final int HEIGHT = 11;

    public GuiPositionButton() {
        setSize(WIDTH, HEIGHT);
    }

    @Override
    public void render(PoseStack matrices, int mouseX, int mouseY, float partialTick) {
        if (isEnabled()) {
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

            int x = getGuiX(), y = getGuiY();
            PipBoyUtils.setPipboyShader();
//            if (isMouseOver) {
//                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//            } else {
//                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.5F);
//            }

            Textures.BTN_POSITION.draw(matrices, x, y, WIDTH, HEIGHT);

            RenderSystem.disableBlend();

            if (isMouseOver) {
                drawTooltip(Collections.singletonList(new TranslatableComponent("gui.nukacraft.followPlayer")), Minecraft.getInstance().font);
            }
        }
    }
}
