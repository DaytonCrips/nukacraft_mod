package com.nukateam.nukacraft.client.render.gui.pipboy;

import com.nukateam.nukacraft.common.foundation.effects.ModAttributesClass;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PipBoy {
    public static List<Archive> content;
    public static int rad = 0;
    public static float red   = 0.443f;
    public static float green = 0.749f;
    public static float blue  = 0.459f;
    public static int fontColor = -6684775;
    public static ResourceLocation pipboySkin;

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
    public static ResourceLocation warning_image = new ResourceLocation("nukacraft:textures/screens/pipboy_screens/warning_pipboy.png");
    public static Integer[] warn_cords = new Integer[]{-8, -22};

    public PipBoy() {
        content = new ArrayList<>();
    }

    public void init() {
        content.add(new Archive("archive.nukacraft.vaultboy.name")
            .addPage(new ArchivePage( new String[]{
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

        content.add(new Archive("▪ Ам ням").addPage(new ArchivePage(warning_screen)));
        content.add(new Archive("▪ Kakavozik").addPage(new ArchivePage(warning_screen)));
        content.add(new Archive("▪ SUKA").addPage(new ArchivePage(warning_screen)));
        content.add(new Archive("▪ Метро Люблино").addPage(new ArchivePage(warning_screen)));
        content.add(new Archive("▪ Вкусно и почка").addPage(new ArchivePage(warning_screen)));
        content.add(new Archive("▪ Ну а шо еще писать").addPage(new ArchivePage(warning_screen)));
        content.add(new Archive("▪ WARN1").addPage(new ArchivePage(warning_screen)));
    }

    public static void start(ItemStack stack, String skin, Player player) {
        double rad_val = player.getAttributeValue(ModAttributesClass.RADIATION.get());
        rad = (int)Math.ceil(rad_val);
        pipboySkin = new ResourceLocation("nukacraft:textures/screens/" + skin + "_pipboy.png");
        switch (stack.getOrCreateTag().getString("screen")) {
            case "white" -> {
                red = 1;
                green = 1;
                blue = 1;
                fontColor = -1;
            }
            case "green" -> {
                red = 0.443f;
                green = 0.749f;
                blue = 0.459f;
                fontColor = -6684775;
            }
        }
    }

}
