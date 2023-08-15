package com.dayton.nukacraft.client.gui.pipboy;

import net.minecraft.resources.ResourceLocation;

public class ArchivePage {
    private String[] lines;
    private ResourceLocation image;
    private int x, y;

    public ArchivePage(String[] lines) {
        this.lines = lines;
    }

    public ArchivePage(String[] lines, ResourceLocation image, int x, int y) {
        this.lines = lines;
        this.image = image;
        this.y = y;
        this.x = x;
    }

    public String[] getLines() {
        return lines;
    }
}
