package com.dayton.nukacraft.client.gui.pipboy;

import java.util.ArrayList;
import java.util.List;

public class PipBoy {
    public static List<Archive> content;
    public static String[] page_buffer = new String[]{

            "▪ Шлёпнуть Андрея", //string1
            "▪ Шлёпнуть Андрея", //string2
            "▪ Шлёпнуть Андрея", //string3
            "▪ Шлёпнуть Андрея", //string4
            "▪ Шлёпнуть Андрея", //string5
            "▪ Шлёпнуть Андрея", //string6
            "▪ Шлёпнуть Андрея", //string7
            "▪ Шлёпнуть Андрея", //string8
            "▪ Шлёпнуть Андрея", //string9
            "▪ Шлёпнуть Андрея", //string10
            "Шо? ☢", //catalogue name
            "nukacraft:textures/screens/radhearth." //resourceLocation
    };
    public PipBoy() {
        this.content = new ArrayList<Archive>();
    }
    public void init() {
        content.add(new Archive("▪ Test").addPage(new ArchivePage(page_buffer)));
        content.add(new Archive("▪ Ам ням").addPage(new ArchivePage(page_buffer)));
        content.add(new Archive("▪ Kakavozik").addPage(new ArchivePage(page_buffer)));
        content.add(new Archive("▪ SUKA").addPage(new ArchivePage(page_buffer)));
    }
}
