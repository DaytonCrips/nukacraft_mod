package com.nukateam.nukacraft.client.render.gui.pipboy;


import com.nukateam.map.impl.atlas.AntiqueAtlasModClient;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

import static com.nukateam.nukacraft.common.data.utils.MathUtils.round;

public class PipBoyScreenBase<T extends AbstractContainerMenu> extends AbstractContainerScreen<T>{
    public static int page_count, current_page, current_archive, archive_pages, current_archive_page;
    public static ResourceLocation image = new ResourceLocation("nukacraft:textures/screens/empty.png");
    public static boolean menu = true;
    public static Integer[] cords = new Integer[]{0, 0};

    public static String[] page_buffer = new String[]{ "", "", "", "", "", "", "", "", "", "" };

    public PipBoyScreenBase(T container, Inventory inventory, Component text) {
        super(container, inventory, text);
    }

    @Override protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {}

    public static void setPipboyShader(){
        RenderSystem.setShaderColor(PipBoy.red, PipBoy.green, PipBoy.blue, 1);
    }

    public static void setPipboyShader(float alpha){
        RenderSystem.setShaderColor(PipBoy.red, PipBoy.green, PipBoy.blue, alpha);
    }

    public void renderNavigationPage() {
        addRenderableWidget(getHomeButton());
        addRenderableWidget(getMapButton());
        addRenderableWidget(getBackButton(() -> {
            if (current_page > 0) {
                current_page--;
                renderPage();
            }
        }));
        addRenderableWidget(getForwardButton(() -> {
            if (current_page < page_count-1){
                current_page++;
                renderPage();
            }
        }));
    }

    public void renderArchiveNavigation(){
        addRenderableWidget(getHomeButton());
        addRenderableWidget(getMapButton());
        addRenderableWidget(getBackButton(() -> {
            if (current_archive_page > 0) {
                current_archive_page--;
                clearWidgets();
                renderArchiveNavigation();
                buttonMenu();
            }
        }));
        addRenderableWidget(getForwardButton(() -> {
            if (!(current_archive_page == archive_pages)) {
                current_archive_page++;
                clearWidgets();
                renderArchiveNavigation();
                buttonMenu();
            }
        }));
    }

    private MainPipBoyButton getHomeButton(){
        return new MainPipBoyButton(leftPos - 80, topPos + 58, 20, 20,
                new TextComponent("☵"), e -> {
            clearWidgets();
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            buttonMenu();
            renderArchiveNavigation();
        });
    }

    private MainPipBoyButton getMapButton(){
        return new MainPipBoyButton(leftPos - 46, topPos + 58, 20, 20,
                new TextComponent("✴"), e -> {
            clearWidgets();
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            drawMap();
        });
    }

    private MainPipBoyButton getBackButton(Runnable runnable){
        return new MainPipBoyButton(leftPos - 112, topPos + 58, 30, 20,
                new TextComponent("◀"), e -> runnable.run());
    }

    private MainPipBoyButton getForwardButton(Runnable runnable){
        return new MainPipBoyButton(leftPos -24, topPos + 58, 30, 20,
                new TextComponent("▶"), e -> runnable.run());
    }


    private void renderPage() {
        page_buffer = PipBoy.content.get(current_archive).getPage(current_page).getLines();
        image = PipBoy.content.get(current_archive).getPage(current_page).getImage();
        cords[0] = PipBoy.content.get(current_archive).getPage(current_page).getXcord();
        cords[1] = PipBoy.content.get(current_archive).getPage(current_page).getYcord();
    }

    public void drawMap() {
//        addRenderableWidget(new MainPipBoyButton(leftPos + -112, topPos + 58, 30, 20,
//                new TextComponent("◀"), e -> {
//            clearWidgets();
//            archive_pages = round(PipBoy.content.size(), 7) - 1;
//            current_archive_page = 0;
//            buttonMenu();
//            renderArchiveNavigation();
//            }));
//        page_buffer = new String[]{
//                "", //string1
//                "", //string2
//                "", //string3
//                "", //string4
//                "", //string5
//                "", //string6
//                "", //string7
//                "", //string8
//                "", //string9
//                "" //string10
//        };
//        image = new ResourceLocation("nukacraft:textures/screens/empty.png");
//
//        Minecraft.getInstance().player.closeContainer();
        AntiqueAtlasModClient.openAtlasGUI(Minecraft.getInstance().player.getOffhandItem());
    }

    public void buttonMenu() {
        int xj = 0;

        if (current_archive_page == archive_pages) {
            if (PipBoy.content.size() % 7 == 0)
                xj = 7;
            else
                xj = PipBoy.content.size() % 7;
        } else if (PipBoy.content.size() >= 7) {
            xj = 7;
        }

        page_buffer = new String[]{
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
        image = new ResourceLocation("nukacraft:textures/screens/empty.png");
        for (int t = 0; t < xj; t++) {
            page_buffer[t+3] = current_archive_page > 0 ? PipBoy.content.get(t+(current_archive_page*7)).getName() : PipBoy.content.get(t+(current_archive_page)).getName();
            int finalT = current_archive_page > 0 ? t+(current_archive_page*7) : t;
            addRenderableWidget(new TextPipBoyButton(leftPos + -102, topPos + (-50 + (t * 13)),  205, 11,
                    new TextComponent(""), e -> {
                menu = false;
                clearWidgets();
                renderNavigationPage();
                page_buffer = PipBoy.content.get(finalT).getPage(0).getLines();
                image = PipBoy.content.get(finalT).getPage(0).getImage();
                cords[0] = PipBoy.content.get(finalT).getPage(0).getXcord();
                cords[1] = PipBoy.content.get(finalT).getPage(0).getYcord();
                current_archive = finalT;
                page_count = PipBoy.content.get(finalT).getPageCount();
                current_page = 0;
            }));
        }
    }
}
