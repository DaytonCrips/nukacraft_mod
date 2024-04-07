package com.nukateam.nukacraft.common.data.constants;

import com.nukateam.nukacraft.client.render.gui.pipboy.Archive;
import com.nukateam.nukacraft.client.render.gui.pipboy.ArchivePage;

import java.util.ArrayList;
import java.util.List;

public class PipboyPages {
    public static final String[] PAGE_BUFFER = {
            "archive.nukacraft.pip_os.string1", //string1
            "archive.nukacraft.pip_os.string2_1", //string2
            "archive.nukacraft.pip_os.string3", //string3
            "", //string4
            "", //string5
            "", //string6
            "", //string7
            "", //string8
            "", //string9
            "" //string10
    };
    public static String[] warning_screen = new String[]{
            "archive.nukacraft.pip_os.string1", //string1
            "archive.nukacraft.pip_os.string2", //string2
            "archive.nukacraft.pip_os.string3", //string3
            "archivepage.nukacraft.warn.string_d1", //string4
            "archivepage.nukacraft.warn.string_d2", //string5
            "archivepage.nukacraft.warn.string_d3", //string6
            "", //string7
            "", //string8
            "", //string9
            "archivepage.nukacraft.warn.string_d5" //string10

    };
    public static List<Archive> content = new ArrayList<>();

    public static void init(List<Archive> content) {
        content.add(new Archive("archive.nukacraft.vaultboy.name")
                .addPage(new ArchivePage(new String[]{
                        "archivepage.nukacraft.vaultboy1.string_d1", //string1
                        "", //string2
                        "archivepage.nukacraft.vaultboy1.string_d2", //string3
                        "archivepage.nukacraft.vaultboy1.string_d3", //string4
                        "", //string5
                        "", //string6
                        "archivepage.nukacraft.vaultboy1.string_d4", //string7
                        "archivepage.nukacraft.vaultboy1.string_d5", //string8
                        "archivepage.nukacraft.vaultboy1.string_d6", //string9
                        "" //string10
                }))
        );

        content.add(new Archive("▪ Ам ням").addPage(new ArchivePage(PipboyPages.warning_screen)));
        content.add(new Archive("▪ Kakavozik").addPage(new ArchivePage(PipboyPages.warning_screen)));
        content.add(new Archive("▪ SUKA").addPage(new ArchivePage(PipboyPages.warning_screen)));
        content.add(new Archive("▪ Метро Люблино").addPage(new ArchivePage(PipboyPages.warning_screen)));
        content.add(new Archive("▪ Вкусно и почка").addPage(new ArchivePage(PipboyPages.warning_screen)));
        content.add(new Archive("▪ Ну а шо еще писать").addPage(new ArchivePage(PipboyPages.warning_screen)));
        content.add(new Archive("▪ WARN1").addPage(new ArchivePage(PipboyPages.warning_screen)));
    }
}
