package com.nukateam.nukacraft.client.render.gui.pipboy;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.common.data.constants.PipboyPages;
import com.nukateam.nukacraft.common.data.utils.PipBoyUtils;
import com.nukateam.nukacraft.common.foundation.container.PipBoyMenu;
import com.nukateam.nukacraft.common.network.PacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static com.nukateam.nukacraft.common.data.constants.PipboyPages.PAGE_BUFFER;
import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class PipBoyScreen extends AbstractContainerScreen<PipBoyMenu> {
    private static final ResourceLocation PIPBOY_FRAME = nukaResource("textures/screens/pipboy_template.png");
    private static final ResourceLocation PIPBOY_SCREEN = nukaResource("textures/screens/pipboy_screen.png");
    public static String[] page_buffer = PAGE_BUFFER;
    public static Integer[] cords = new Integer[]{0, 0};
    private static boolean menu = true;
    private static PipboyPage page = PipboyPage.ARCHIVE;
    private static ResourceLocation image = new ResourceLocation("nukacraft:textures/screens/empty.png");
    private static int page_count, current_page, current_archive, archive_pages, current_archive_page;
    private static ResourceLocation pipboy;
    private final Minecraft minecraft = Minecraft.getInstance();
    public PipBoyScreen(PipBoyMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.imageWidth = 0;
        this.imageHeight = 0;
    }

    public static void openMap() {
        var minecraft = Minecraft.getInstance();
        var pipboy = PipBoyUtils.getPipboyStack(minecraft.player);
        minecraft.player.closeContainer();
//        AntiqueAtlasModClient.openAtlasGUI(pipboy);
    }

    public static void openArchive() {
        if (!PipBoyUtils.hasPipboy()) return;

        page = PipboyPage.ARCHIVE;
        Minecraft.getInstance().player.closeContainer();
        PacketSender.openPipboyScreen();
    }

    public static void openRadio() {
        if (!PipBoyUtils.hasPipboy()) return;

        page = PipboyPage.RADIO;
        Minecraft.getInstance().player.closeContainer();
        PacketSender.openPipboyScreen();
    }

    private static int round(int first, int second) {
        return first % second == 0 ? (first / second) : (first / second) + 1;
    }

    @Override
    public void init() {
        super.init();

        pipboy = PipBoyUtils.getPipboySkin(minecraft.player);
        menu = true;

        switch (page) {
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
        PipBoyUtils.setPipboyShader();

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

        RenderSystem.setShaderTexture(0, nukaResource("textures/screens/rad_marker.png")); //Radiation Marker
        var radX = leftPos + 91 + PipBoyUtils.getPlayerRads(minecraft.player) * 3;
        blit(poseStack, radX, topPos + 72, 0, 0, 3, 4, 3, 4);
    }

    public void warningPipboy() {
        page_buffer = PipboyPages.warning_screen;
        image = PipBoyUtils.warning_image;
        cords[0] = PipBoyUtils.warn_cords[0];
        cords[1] = PipBoyUtils.warn_cords[1];
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
        for (int i = 0; i < 10; i++) {
            var text = Component.translatable(page_buffer[i]);
            var fontColor = PipBoyUtils.getPipboyColor(minecraft.player).getIntColor();
            font.draw(poseStack, text, -150, -87 + (i * 13), fontColor);
        }

        //font.draw(poseStack, Component.translatable("pipboy.nukacraft.data"), 79, -91, -1);
        //font.draw(poseStack, Component.translatable("pipboy.nukacraft.map"), 79, -68, -1);
        //font.draw(poseStack, Component.translatable("pipboy.nukacraft.radio"), 79, -45, -1);
        //font.draw(poseStack, Component.translatable("pipboy.nukacraft.rad"), 83, 52, -1);

        if (menu)
            font.draw(poseStack, Component.translatable("   [" + current_archive_page + "/" + archive_pages + "]"), -25, 64, -1);
        else
            font.draw(poseStack, Component.translatable("   [" + current_page + "/" + (page_count - 1) + "]"), -25, 64, -1);

    }

    @Override
    public void onClose() {
        super.onClose();
        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
        menu = true;
    }

    private void renderHomePage() {
        if (PipboyPages.content.size() == 0) {
            warningPipboy();
        } else {
            archive_pages = round(PipboyPages.content.size(), 7) - 1;
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
            if (current_page < page_count - 1) {
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

    private void renderArchive() {
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

    private void renderRadio() {
        warningPipboy();
    }


    private void renderPage() {
        page_buffer = PipboyPages.content.get(current_archive).getPage(current_page).getLines();
        image = PipboyPages.content.get(current_archive).getPage(current_page).getImage();
        cords[0] = PipboyPages.content.get(current_archive).getPage(current_page).getXcord();
        cords[1] = PipboyPages.content.get(current_archive).getPage(current_page).getYcord();
    }

    private MainPipBoyButton getArchiveButton() {
        return new MainPipBoyButton(leftPos + 125, topPos + -71, 14, 14,
                Component.literal(""), e -> {
            clearWidgets();
            renderNavigation();
            archive_pages = round(PipboyPages.content.size(), 7) - 1;
            current_archive_page = 0;
            openMap();
        });
    }

    private MainPipBoyButton getMapButton() {
        return new MainPipBoyButton(leftPos + 125, topPos + -94, 14, 14,
                Component.literal(""), e -> {
            clearWidgets();
            menu = true;
            archive_pages = round(PipboyPages.content.size(), 7) - 1;
            current_archive_page = 0;
            buttonMenu();
            renderArchive();
        });
    }

    private MainPipBoyButton getRadioButton() {
        return new MainPipBoyButton(leftPos + 125, topPos + -48, 14, 14,
                Component.literal(""), e -> {
            clearWidgets();
            renderNavigation();
            archive_pages = round(PipboyPages.content.size(), 7) - 1;
            current_archive_page = 0;
            renderRadio();
        });
    }

    private MainPipBoyButton getBackButton(Runnable runnable) {
        return new MainPipBoyButton(leftPos + -71, topPos + 61, 14, 14,
                Component.literal(""), e -> runnable.run());
    }

    private MainPipBoyButton getForwardButton(Runnable runnable) {
        return new MainPipBoyButton(leftPos + 52, topPos + 61, 14, 14,
                Component.literal(""), e -> runnable.run());
    }

    private MainPipBoyButton getOffButton() {
        return new MainPipBoyButton(leftPos + -156, topPos + 61, 14, 14,
                Component.literal(""), e -> {
            minecraft.player.closeContainer();
        });
    }

    private void buttonMenu() {
        int xj = 0;

        if (current_archive_page == archive_pages) {
            if (PipboyPages.content.size() % 7 == 0) {
                xj = 7;
            } else {
                xj = PipboyPages.content.size() % 7;
            }
        } else if (PipboyPages.content.size() >= 7) {
            xj = 7;
        }

        page_buffer = PipboyPages.PAGE_BUFFER;

        image = new ResourceLocation("nukacraft:textures/screens/empty.png");
        for (int t = 0; t < xj; t++) {
            page_buffer[t + 3] = current_archive_page > 0 ? PipboyPages.content.get(t + (current_archive_page * 7)).getName() : PipboyPages.content.get(t + (current_archive_page)).getName();
            int finalT = current_archive_page > 0 ? t + (current_archive_page * 7) : t;
            addRenderableWidget(new TextPipBoyButton(leftPos + -150, topPos + (-50 + (t * 13)), 205, 11,
                    Component.literal(""), e -> {
                menu = false;
                clearWidgets();
                renderNavigation();
                page_buffer = PipboyPages.content.get(finalT).getPage(0).getLines();
                image = PipboyPages.content.get(finalT).getPage(0).getImage();
                cords[0] = PipboyPages.content.get(finalT).getPage(0).getXcord();
                cords[1] = PipboyPages.content.get(finalT).getPage(0).getYcord();
                current_archive = finalT;
                page_count = PipboyPages.content.get(finalT).getPageCount();
                current_page = 0;
            }));
        }
    }

    public enum PipboyPage {
        ARCHIVE,
        MAP,
        RADIO
    }
}
