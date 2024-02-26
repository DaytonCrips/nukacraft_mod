package com.nukateam.map.impl.atlas.client.gui.core;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.map.impl.atlas.client.Textures;
import com.nukateam.map.impl.atlas.client.texture.ITexture;
import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoyScreenBase;
import com.nukateam.nukacraft.common.registery.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;

public class GuiPipboyButton extends GuiToggleButton{
    private static final int WIDTH = 14;
    private static final int HEIGHT = 14;

    private ITexture iconTexture;

    public GuiPipboyButton(ITexture iconTexture) {
        setIconTexture(iconTexture);
        setSize(WIDTH, HEIGHT);
        setClickSound(ModSounds.PIPBOY_TAB.get());
    }

    @Override
    public void playDownSound() {
        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(ModSounds.PIPBOY_TAB.get(), 1.0F, 1.0f));
    }

    @Override
    public void render(PoseStack matrices, int mouseX, int mouseY, float partialTick) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        int v = isMouseOver || isSelected() ? 0 : WIDTH;
        Textures.EXIT.draw(matrices, getGuiX(), getGuiY(), v, 0, WIDTH, HEIGHT);
    }

    public void setIconTexture(ITexture iconTexture) {
        this.iconTexture = iconTexture;
    }
}