package com.nukateam.map.impl.atlas.client.gui;

import com.nukateam.map.impl.atlas.client.Textures;
import com.nukateam.map.impl.atlas.client.gui.core.GuiComponent;
import com.nukateam.map.impl.atlas.client.texture.ITexture;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TranslatableComponent;

import java.util.Collections;
import java.util.Map;

import static com.nukateam.nukacraft.common.data.utils.PipBoyUtils.setPipboyShader;


/**
 * A scale bar that displays pixel-to-block ratio. To fit into the overall
 * Atlas style it is rendered at half-scale.
 */
public class GuiScaleBar extends GuiComponent {
    private static final int WIDTH = 93;
    private static final int HEIGHT = 17;

    private static final Map<Double, ITexture> textureMap;

    static {
        Builder<Double, ITexture> builder = ImmutableMap.builder();
        builder.put(0.0625, Textures.SCALEBAR_512);
        builder.put(0.125, Textures.SCALEBAR_256);
        builder.put(0.25, Textures.SCALEBAR_128);
        builder.put(0.5, Textures.SCALEBAR_64);
        builder.put(1.0, Textures.SCALEBAR_32);
        builder.put(2.0, Textures.SCALEBAR_16);
        builder.put(4.0, Textures.SCALEBAR_8);
        builder.put(8.0, Textures.SCALEBAR_4);
        textureMap = builder.build();
    }

    /**
     * Pixel-to-block ratio.
     */
    private double mapScale = 1;

    GuiScaleBar() {
        setSize(WIDTH, HEIGHT);
    }

    void setMapScale(double scale) {
        this.mapScale = scale;
    }

    /**
     * Returns the background texture depending on the scale.
     */
    private ITexture getTexture() {
        return textureMap.get(mapScale);
    }

    @Override
    public void render(PoseStack matrices, int mouseX, int mouseY, float partialTick) {
        ITexture texture = getTexture();
        if (texture == null) return;
//        RenderSystem.setShaderColor(1,1,1,1);
        setPipboyShader();
        texture.draw(matrices, getGuiX(), getGuiY());

        if (isMouseOver) {
            drawTooltip(Collections.singletonList(new TranslatableComponent("gui.nukacraft.scalebar")), Minecraft.getInstance().font);
        }
    }
}
