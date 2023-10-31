package com.dayton.nukacraft.client.render.gui.pipboy;


import com.dayton.map.impl.atlas.AntiqueAtlasModClient;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class PipBoyScreen extends AbstractContainerScreen<PipBoyMenu>{
    private final static HashMap<String, Object> guistate = PipBoyMenu.guiState;
    private static boolean menu = true;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
//Шо? ☢
    public static String[] page_buffer = new String[]{
            "", //string1
            "", //string2
            "", //string3
            "", //string4
            "", //string5
            "", //string6
            "", //string7
            "", //string8
            "", //string9
            "" //string10
    };
    public static Integer[] cords = new Integer[]{0, 0};
    private static ResourceLocation image = new ResourceLocation("nukacraft:textures/screens/empty.png");

    private static int page_count, current_page, current_archive, archive_pages, current_archive_page;

    public PipBoyScreen(PipBoyMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 0;
        this.imageHeight = 0;
    }

    private static final ResourceLocation texture = new ResourceLocation("nukacraft:textures/screens/pipboy_template.png");
    private static ResourceLocation pipboy = new ResourceLocation("nukacraft:textures/screens/pimpboy.png");
    private static final ResourceLocation pipboy_screen = new ResourceLocation("nukacraft:textures/screens/pipboy_screen.png");

    @Override
    public void init() {
        pipboy = PipBoy.pipboy_name;
        super.init();
        menu = true;
        if (PipBoy.content.size() == 0) {
            warningPipboy();
        } else {
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            buttonMenu();
            renderArchiveNavigation();
        }
        minecraft.keyboardHandler.setSendRepeatsToGui(true);
//        addRenderableWidget(new MainPipBoyButton(leftPos + -114, topPos + 58, 30, 20, new TextComponent("X"), e -> {
//        }));
    }

    @Override
    public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        this.renderTooltip(ms, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(PipBoy.bred, PipBoy.bgreen, PipBoy.bblue, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, texture);
        blit(ms, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        RenderSystem.setShaderTexture(0, pipboy_screen); //Pip Boy Skin
        blit(ms, leftPos + -116, topPos + -113, 0, 0, 235, 207, 235, 207);

        if (!(image == null)) {
            RenderSystem.setShaderTexture(0, image); //Pip Boy Skin
            blit(ms, leftPos + cords[0], topPos + cords[1], 0, 0, 106, 65, 106, 65);
        }

        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, pipboy); //Pip Boy Skin
        blit(ms, leftPos + -116, topPos + -113, 0, 0, 235, 207, 235, 207);
    }

    public void warningPipboy() {
        page_buffer = PipBoy.warning_screen;
        image = PipBoy.warning_image;
        cords = PipBoy.warn_cords;
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    public void containerTick() {
        super.containerTick();
    }

    @Override
    protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
        for (int xt = 0; xt < 10; xt++) {
            font.draw(poseStack, new TranslatableComponent(page_buffer[xt]), -102, -87 + (xt * 13), PipBoy.fontColor);
        }

        if (menu)
            font.draw(poseStack, new TranslatableComponent("   [" + current_archive_page + "/" + archive_pages + "]"), 33, 64, -1);
        else font.draw(poseStack, new TranslatableComponent("   [" + current_page + "/" + (page_count-1) + "]"), 33, 64, -1);

    }

    @Override
    public void onClose() {
        super.onClose();
        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
        menu = true;
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
        return new MainPipBoyButton(leftPos + -80, topPos + 58, 20, 20,
                new TextComponent("☵"), e -> {
            clearWidgets();
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            buttonMenu();
            renderArchiveNavigation();
        });
    }

    private MainPipBoyButton getMapButton(){
        return new MainPipBoyButton(leftPos + -46, topPos + 58, 20, 20,
                new TextComponent("✴"), e -> {
            clearWidgets();
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            drawMap();
        });
    }

    private MainPipBoyButton getBackButton(Runnable runnable){
        return new MainPipBoyButton(leftPos + -112, topPos + 58, 30, 20,
                new TextComponent("◀"), e -> runnable.run());
    }

    private MainPipBoyButton getForwardButton(Runnable runnable){
        return new MainPipBoyButton(leftPos + -24, topPos + 58, 30, 20,
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
        Minecraft.getInstance().player.closeContainer();
        AntiqueAtlasModClient.openAtlasGUI(Minecraft.getInstance().player.getOffhandItem());
    }

    public void buttonMenu() {
        int xj = 0;

        if (current_archive_page == archive_pages) {
            if (PipBoy.content.size() % 7 == 0) {
                xj = 7;
            } else {
                xj = PipBoy.content.size() % 7;
            }
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

    public static int round(int i, int j) {
        if (i % j == 0) {
            return (i / j);
        } else {
            return (i / j) + 1;
        }
    }
}
