package com.nukateam.nukacraft.client.render.gui.pipboy;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.map.impl.atlas.AntiqueAtlasModClient;
import com.nukateam.nukacraft.common.data.utils.PlayerUtils;
import com.nukateam.nukacraft.common.data.utils.SlotUtils;
import com.nukateam.nukacraft.common.foundation.container.PipBoyMenu;
import com.nukateam.nukacraft.common.network.PacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PipBoyScreen extends AbstractContainerScreen<PipBoyMenu>{
    private static boolean menu = true;

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

    public enum PipboyPage{
        ARCHIVE,
        MAP,
        RADIO
    }

    private static PipboyPage page = PipboyPage.ARCHIVE;

    public static Integer[] cords = new Integer[]{0, 0};
    private static ResourceLocation image = new ResourceLocation("nukacraft:textures/screens/empty.png");
    private static int page_count, current_page, current_archive, archive_pages, current_archive_page;

    public PipBoyScreen(PipBoyMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.imageWidth = 0;
        this.imageHeight = 0;
    }

    private static final ResourceLocation PIPBOY_FRAME = new ResourceLocation("nukacraft:textures/screens/pipboy_template.png");
    private static ResourceLocation pipboy = new ResourceLocation("nukacraft:textures/screens/pimpboy.png");
    private static final ResourceLocation PIPBOY_SCREEN = new ResourceLocation("nukacraft:textures/screens/pipboy_screen.png");

    @Override
    public void init() {
        pipboy = PipBoy.pipboySkin;
        super.init();
        menu = true;


        switch (page){
            case ARCHIVE -> renderHomePage();
            case MAP -> openMap();
            case RADIO -> renderRadio();
        }

        minecraft.keyboardHandler.setSendRepeatsToGui(true);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(PipBoy.red, PipBoy.green, PipBoy.blue, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, PIPBOY_FRAME);
        blit(poseStack, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        RenderSystem.setShaderTexture(0, PIPBOY_SCREEN); //Pip Boy Skin
        blit(poseStack, leftPos + -163, topPos + -113, 0, 0, 327, 207, 327, 207);

        if (!(image == null)) {
            RenderSystem.setShaderTexture(0, image); //Pip Boy Skin
            blit(poseStack, leftPos + cords[0], topPos + cords[1], 0, 0, 106, 65, 106, 65);
        }

        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, pipboy); //Pip Boy Skin
        blit(poseStack, leftPos + -163, topPos + -113, 0, 0, 327, 207, 327, 207);
        RenderSystem.setShaderTexture(0, new ResourceLocation("nukacraft:textures/screens/rad_marker.png")); //Radiation Marker
        blit(poseStack, leftPos + 91+PipBoy.rad*3, topPos + 72, 0, 0, 3, 4, 3, 4);
    }


    public void warningPipboy() {
        page_buffer = PipBoy.warning_screen;
        image = PipBoy.warning_image;
        cords[0] = PipBoy.warn_cords[0];
        cords[1] = PipBoy.warn_cords[1];
        renderNavigation();
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
            font.draw(poseStack, new TranslatableComponent(page_buffer[xt]), -150, -87 + (xt * 13), PipBoy.fontColor);
        }

        //font.draw(poseStack, new TranslatableComponent("pipboy.nukacraft.data"), 79, -91, -1);
        //font.draw(poseStack, new TranslatableComponent("pipboy.nukacraft.map"), 79, -68, -1);
        //font.draw(poseStack, new TranslatableComponent("pipboy.nukacraft.radio"), 79, -45, -1);
        //font.draw(poseStack, new TranslatableComponent("pipboy.nukacraft.rad"), 83, 52, -1);

        if (menu)
            font.draw(poseStack, new TranslatableComponent("   [" + current_archive_page + "/" + archive_pages + "]"), -25, 64, -1);
        else font.draw(poseStack, new TranslatableComponent("   [" + current_page + "/" + (page_count-1) + "]"), -25, 64, -1);

    }

    @Override
    public void onClose() {
        super.onClose();
        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
        menu = true;
    }

    public static void openMap() {
        var minecraft = Minecraft.getInstance();
        var pipboy = SlotUtils.getPipboyStack(minecraft.player);
        minecraft.player.closeContainer();
        AntiqueAtlasModClient.openAtlasGUI(pipboy);
    }

    public static void openArchive() {
        if(!PlayerUtils.hasPipboy()) return;

        page = PipboyPage.ARCHIVE;
        Minecraft.getInstance().player.closeContainer();
        PacketSender.openPipboyScreen();
    }

    public static void openRadio(){
        if(!PlayerUtils.hasPipboy()) return;

        page = PipboyPage.RADIO;
        Minecraft.getInstance().player.closeContainer();
        PacketSender.openPipboyScreen();
    }

    private void renderHomePage(){
        if (PipBoy.content.size() == 0) {
            warningPipboy();
        } else {
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            buttonMenu();
            renderArchive();
        }
    }

    private void renderNavigation() {
        renderButtons();
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

    private void renderButtons() {
        addRenderableWidget(getArchiveButton());
        addRenderableWidget(getMapButton());
        addRenderableWidget(getOffButton());
        addRenderableWidget(getRadioButton());
    }

    private void renderArchive(){
        warningPipboy();

//        renderButtons();
//        addRenderableWidget(getBackButton(() -> {
//            if (current_archive_page > 0) {
//                current_archive_page--;
//                clearWidgets();
//                renderArchive();
//                buttonMenu();
//            }
//        }));
//        addRenderableWidget(getForwardButton(() -> {
//            if (!(current_archive_page == archive_pages)) {
//                current_archive_page++;
//                clearWidgets();
//                renderArchive();
//                buttonMenu();
//            }
//        }));
    }

    private void renderRadio(){
        warningPipboy();
    }


    private void renderPage() {
        page_buffer = PipBoy.content.get(current_archive).getPage(current_page).getLines();
        image = PipBoy.content.get(current_archive).getPage(current_page).getImage();
        cords[0] = PipBoy.content.get(current_archive).getPage(current_page).getXcord();
        cords[1] = PipBoy.content.get(current_archive).getPage(current_page).getYcord();
    }

    private MainPipBoyButton getArchiveButton(){
        return new MainPipBoyButton(leftPos + 125, topPos + -71, 14, 14,
                new TextComponent(""), e -> {
            clearWidgets();
            renderNavigation();
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            openMap();
        });
    }

    private MainPipBoyButton getMapButton(){
        return new MainPipBoyButton(leftPos + 125, topPos + -94, 14, 14,
                new TextComponent(""), e -> {
            clearWidgets();
            menu = true;
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            buttonMenu();
            renderArchive();
        });
    }

    private MainPipBoyButton getRadioButton(){
        return new MainPipBoyButton(leftPos + 125, topPos + -48, 14, 14,
                new TextComponent(""), e -> {
            clearWidgets();
            renderNavigation();
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            renderRadio();
        });
    }

    private MainPipBoyButton getBackButton(Runnable runnable){
        return new MainPipBoyButton(leftPos + -71, topPos + 61, 14, 14,
                new TextComponent(""), e -> runnable.run());
    }

    private MainPipBoyButton getForwardButton(Runnable runnable){
        return new MainPipBoyButton(leftPos + 52, topPos + 61, 14, 14,
                new TextComponent(""), e -> runnable.run());
    }

    private MainPipBoyButton getOffButton(){
        return new MainPipBoyButton(leftPos + -156, topPos + 61, 14, 14,
                new TextComponent(""), e -> {
            minecraft.player.closeContainer();
        });
    }

    private void buttonMenu() {
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

        page_buffer = PAGE_BUFFER;

        image = new ResourceLocation("nukacraft:textures/screens/empty.png");
        for (int t = 0; t < xj; t++) {
            page_buffer[t+3] = current_archive_page > 0 ? PipBoy.content.get(t+(current_archive_page*7)).getName() : PipBoy.content.get(t+(current_archive_page)).getName();
            int finalT = current_archive_page > 0 ? t+(current_archive_page*7) : t;
            addRenderableWidget(new TextPipBoyButton(leftPos + -150, topPos + (-50 + (t * 13)),  205, 11,
                    new TextComponent(""), e -> {
                menu = false;
                clearWidgets();
                renderNavigation();
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

    private static int round(int first, int second) {
        return first % second == 0 ? (first / second) : (first / second) + 1;
    }
}
