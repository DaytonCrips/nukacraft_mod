package com.dayton.nukacraft.client.render.gui.pipboy;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    private List<ArchivePage> pages;
    private String name;
    public Archive(String name) {
        this.name = name;
        this.pages = new ArrayList<>();
    }
    public Archive addPage(ArchivePage page) {
        this.pages.add(page);
        return this;
    }
    public String getName () {
        return name;
    }
    public ArchivePage getPage(int index) {
        return this.pages.get(index);
    }
    public int getPageCount() {return this.pages.size();}
}
