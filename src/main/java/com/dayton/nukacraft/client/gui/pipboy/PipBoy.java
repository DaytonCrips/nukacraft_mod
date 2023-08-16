package com.dayton.nukacraft.client.gui.pipboy;

import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class PipBoy {
    public static List<Archive> content;


    public static String[] warning_screen = new String[]{

            "    Copyright 2076 ROBCO INDUSTRIES", //string1
            "                -Internal 1-        ", //string2
            "-----------------------------------", //string3
            "archivepage.nukacraft.warn.string_d1", //string4
            "archivepage.nukacraft.warn.string_d2", //string5
            "archivepage.nukacraft.warn.string_d3", //string6
            "", //string7
            "", //string8
            "", //string9
            "archivepage.nukacraft.warn.string_d5" //string10

    };
    public static ResourceLocation warning_image = new ResourceLocation("nukacraft:textures/screens/pipboy_screens/warning_pipboy.png");
    public static Integer[] warn_cords = new Integer[]{30, -22};
//
//
//    public static ResourceLocation image = new ResourceLocation("nukacraft:textures/screens/empty.png");
    public PipBoy() {
        this.content = new ArrayList<Archive>();
    }
    public void init() {
        content.add(new Archive("archive.nukacraft.vaultboy.name")
                .addPage(new ArchivePage(
                        new ResourceLocation("nukacraft:textures/screens/pipboy_screens/vaultlogo.png"),
                        -52,
                        -10,
                        new String[]
                                {
                                        "archivepage.nukacraft.vaultboy1.string_d1", //string1
                                        "", //string2
                                        "archivepage.nukacraft.vaultboy1.string_d2", //string3
                                        "archivepage.nukacraft.vaultboy1.string_d3", //string4
                                        "", //string5
                                        "archivepage.nukacraft.vaultboy1.string_d4", //string6
                                        "", //string7
                                        "", //string8
                                        "", //string9
                                        "" //string10
                                }))
        );



//        content.add(new Archive("▪ Ам ням").addPage(new ArchivePage(warning_screen)));
//        content.add(new Archive("▪ Kakavozik").addPage(new ArchivePage(warning_screen)));
//        content.add(new Archive("▪ SUKA").addPage(new ArchivePage(warning_screen)));
//        content.add(new Archive("▪ Метро Люблино").addPage(new ArchivePage(warning_screen)));
//        content.add(new Archive("▪ Вкусно и почка").addPage(new ArchivePage(warning_screen)));
//        content.add(new Archive("▪ Ну а шо еще писать").addPage(new ArchivePage(warning_screen)));
//        content.add(new Archive("▪ WARN1").addPage(new ArchivePage(warning_screen)));

    }


}
