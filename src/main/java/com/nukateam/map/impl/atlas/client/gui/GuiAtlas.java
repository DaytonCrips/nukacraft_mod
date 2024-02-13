package com.nukateam.map.impl.atlas.client.gui;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.client.Textures;
import com.nukateam.nukacraft.client.render.gui.pipboy.MainPipBoyButton;
import com.nukateam.nukacraft.common.data.constants.PipboyPages;
import com.nukateam.nukacraft.client.render.gui.pipboy.TextPipBoyButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;

import static com.nukateam.nukacraft.client.render.gui.pipboy.PipBoyScreenBase.*;
import static com.nukateam.nukacraft.common.data.utils.MathUtils.round;

public class GuiAtlas extends GuiAtlasBase {
    protected int leftPos;
    protected int topPos;

    public GuiAtlas() {
//        renderNavigation();
    }

    @Override
    public void init() {
        super.init();
        this.leftPos = (this.width - WIDTH) / 2 + WIDTH;
        this.topPos = (this.height - HEIGHT) / 2 + HEIGHT;
    }

    public GuiAtlas prepareToOpen(ItemStack stack) {
        this.stack = stack;
        return prepareToOpen();
    }

    public GuiAtlas prepareToOpen() {
        Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.BOOK_PAGE_TURN, 1.0F));

        this.player = Minecraft.getInstance().player;
        updateAtlasData();
        if (!followPlayer && MapCore.CONFIG.doSaveBrowsingPos) {
            loadSavedBrowsingPosition();
        }

        return this;
    }

    public void renderNavigation() {
        getHomeButton();
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
        getHomeButton();
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

    private void getHomeButton(){
//        new MainPipBoyButton(leftPos + -80, topPos + 58, 20, 20,
//                new TextComponent("☵"), e -> {
//        });
//
        var homeButton = new GuiBookmarkButton(0,Textures.ICON_ADD_MARKER, new TranslatableComponent("gui.nukacraft.addMarker"));
        addChild(homeButton).offsetGuiCoords( 80, height - 40);

        homeButton.addListener(button -> {
            clearWidgets();
            archive_pages = round(PipboyPages.content.size(), 7) - 1;
            current_archive_page = 0;
//            buttonMenu();
            renderArchiveNavigation();
        });

    }

    private MainPipBoyButton getMapButton(){
        return new MainPipBoyButton(leftPos + -46, topPos + 58, 20, 20,
                new TextComponent("✴"), e -> {
            clearWidgets();
            archive_pages = round(PipboyPages.content.size(), 7) - 1;
            current_archive_page = 0;
            //openMap();
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
        page_buffer = PipboyPages.content.get(current_archive).getPage(current_page).getLines();
        image = PipboyPages.content.get(current_archive).getPage(current_page).getImage();
        cords[0] = PipboyPages.content.get(current_archive).getPage(current_page).getXcord();
        cords[1] = PipboyPages.content.get(current_archive).getPage(current_page).getYcord();
    }

    public void buttonMenu() {
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
            page_buffer[t+3] = current_archive_page > 0 ? PipboyPages.content.get(t+(current_archive_page*7)).getName() : PipboyPages.content.get(t+(current_archive_page)).getName();
            int finalT = current_archive_page > 0 ? t+(current_archive_page*7) : t;
            addRenderableWidget(new TextPipBoyButton(leftPos + -102, topPos + (-50 + (t * 13)),  205, 11,
                    new TextComponent(""), e -> {
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
}
