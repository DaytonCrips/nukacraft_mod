package com.dayton.nukacraft.client.render.gui.pipboy;

import net.minecraft.resources.ResourceLocation;

public class ArchivePage {
    private String[] lines;
    private ResourceLocation image;
    private int x, y;

    public ArchivePage(String[] lines) {
        this.lines = lines;
    }

    public ArchivePage(ResourceLocation image, int x, int y, String[] lines) {
        this.lines = lines;
        this.image = image;
        this.y = y;
        this.x = x;
    }

    public ResourceLocation getImage() {
        return image;
    }
    public int getXcord () {
        return x;
    }
    public int getYcord () {
        return y;
    }
    public String[] getLines() {
        return lines;
    }
}
