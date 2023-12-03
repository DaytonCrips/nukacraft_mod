package com.nukateam.map.impl.atlas.client.gui.core;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.map.impl.atlas.client.Textures;
import com.nukateam.map.impl.atlas.client.texture.ITexture;
import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoyScreenBase;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;

public class GuiPipboyButton extends GuiToggleButton{
    private static final int WIDTH = 21;
    private static final int HEIGHT = 18;
    private static final ResourceLocation button_t = new ResourceLocation("nukacraft:textures/screens/button_t.png");
    private static final ResourceLocation button_f = new ResourceLocation("nukacraft:textures/screens/button_f.png");


    private ITexture iconTexture;
    private Component title;

    GuiPipboyButton(ITexture iconTexture) {
        setIconTexture(iconTexture);
        setSize(WIDTH, HEIGHT);
    }


    void setIconTexture(ITexture iconTexture) {
        this.iconTexture = iconTexture;
    }

    public Component getTitle() {
        return title;
    }

    void setTitle(Component title) {
        this.title = title;
    }

    @Override
    public void render(PoseStack matrices, int mouseX, int mouseY, float partialTick) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, button_t);


        if (isMouseOver) {
            RenderSystem.setShaderTexture(0, button_f);
        }
    }
}
