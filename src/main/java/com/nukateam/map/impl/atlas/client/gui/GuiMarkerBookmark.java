package com.nukateam.map.impl.atlas.client.gui;

import com.nukateam.map.impl.atlas.client.Textures;
import com.nukateam.map.impl.atlas.client.gui.core.GuiComponentButton;
import com.nukateam.map.impl.atlas.client.texture.ITexture;
import com.nukateam.map.impl.atlas.marker.Marker;
import com.nukateam.map.impl.atlas.registry.MarkerType;
import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.common.data.utils.PipBoyUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import java.util.Collections;


/**
 * Bookmark-button in the journal. When a bookmark is selected, it will not
 * bulge on mouseover.
 */
public class GuiMarkerBookmark extends GuiComponentButton {
    private static final int WIDTH = 21;
    private static final int HEIGHT = 18;

    private final int colorIndex;
    private ITexture iconTexture;
    private Marker marker;

    GuiMarkerBookmark(Marker marker) {
        this.colorIndex = 3;
        this.marker = marker;

        var type = MarkerType.REGISTRY.get(marker.getType());
        setIconTexture(type.getTexture());

        setSize(WIDTH, HEIGHT);
    }

    void setIconTexture(ITexture iconTexture) {
        this.iconTexture = iconTexture;
    }

    public Component getTitle() {
        return marker.getLabel();
    }


    @Override
    public void render(PoseStack matrices, int mouseX, int mouseY, float partialTick) {
        PipBoyUtils.setPipboyShader();

        // Render background:
        int u = colorIndex * WIDTH;
        int v = isMouseOver ? 0 : HEIGHT;
        Textures.BOOKMARKS_LEFT.draw(matrices, getGuiX(), getGuiY(), u, v, WIDTH, HEIGHT);

        // Render the icon:
        iconTexture.draw(matrices, getGuiX() - (isMouseOver ? 3 : 2), getGuiY()-3, 24,24);

        if (isMouseOver && !getTitle().getString().isEmpty()) {
            drawTooltip(Collections.singletonList(getTitle()), Minecraft.getInstance().font);
        }
    }
}
