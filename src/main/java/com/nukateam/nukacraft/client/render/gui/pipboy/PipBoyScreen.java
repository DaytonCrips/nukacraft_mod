package com.nukateam.nukacraft.client.render.gui.pipboy;


import com.jetug.chassis_core.common.util.Pos2I;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.map.impl.atlas.AntiqueAtlasMod;
import com.nukateam.map.impl.atlas.AntiqueAtlasModClient;
import com.nukateam.map.impl.atlas.client.TileRenderIterator;
import com.nukateam.map.impl.atlas.client.TileTextureMap;
import com.nukateam.map.impl.atlas.client.texture.TileTexture;
import com.nukateam.map.impl.atlas.core.WorldData;
import com.nukateam.map.impl.atlas.item.AtlasItem;
import com.nukateam.map.impl.atlas.marker.DimensionMarkersData;
import com.nukateam.map.impl.atlas.marker.MarkersData;
import com.nukateam.map.impl.atlas.util.MathUtil;
import com.nukateam.map.impl.atlas.util.Rect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;

import static com.nukateam.map.impl.atlas.client.gui.GuiAtlasBase.*;

public class PipBoyScreen extends AbstractContainerScreen<PipBoyMenu>{
    private final static HashMap<String, Object> guistate = PipBoyMenu.guiState;
    private static boolean menu = true;
    private final Level world;
    private final int x, y, z;
    private final Player entity;

    private double mapScale = 1;
    int tileHalfSize = 1;
    private int tile2ChunkScale = 1;
    private double screenScale;
    protected int mapOffsetX, mapOffsetY = 0;
    private int guiX = 0, guiY = 0;
    protected WorldData biomeData;
    Player player = Minecraft.getInstance().player;

    private DimensionMarkersData localMarkersData;
    private DimensionMarkersData globalMarkersData;

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

    public int getGuiX() {
        return guiX;
    }

    public int getGuiY() {
        return guiY;
    }


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
        screenScale = Minecraft.getInstance().getWindow().getGuiScale();

        updateAtlasData();
//        addRenderableWidget(new MainPipBoyButton(leftPos + -114, topPos + 58, 30, 20, new TextComponent("X"), e -> {
//        }));
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }

    private void renderTiles(PoseStack poseStack, Rect mapPos) {
        RenderSystem.enableScissor(
                (int) ((getGuiX() + MAP_BORDER_WIDTH) * screenScale),
                (int) ((Minecraft.getInstance().getWindow().getHeight() - (getGuiY() + MAP_BORDER_HEIGHT + MAP_HEIGHT) * screenScale)),
                (int) (MAP_WIDTH * screenScale), (int) (MAP_HEIGHT * screenScale));
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        var startScreenPos = getStartScreenPos(mapPos);
        var tiles = new TileRenderIterator(biomeData);

        tiles.setScope(mapPos);
        tiles.setStep(tile2ChunkScale);
        renderSubTiles(poseStack, tiles, startScreenPos);

        RenderSystem.disableScissor();
    }

    protected Pos2I getStartScreenPos(Rect mapPos){
        var mapStartScreenX = getGuiX() + WIDTH / 2 + (int) ((mapPos.minX << 4) * mapScale) + mapOffsetX;
        var mapStartScreenY = getGuiY() + HEIGHT / 2 + (int) ((mapPos.minY << 4) * mapScale) + mapOffsetY;
        return new Pos2I(mapStartScreenX, mapStartScreenY);
    }

    protected Rect getMapPos(){
        int mapStartX = MathUtil.roundToBase((int) Math.floor(-((double) MAP_WIDTH / 2d + mapOffsetX + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);
        int mapStartZ = MathUtil.roundToBase((int) Math.floor(-((double) MAP_HEIGHT / 2d + mapOffsetY + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);
        int mapEndX   = MathUtil.roundToBase((int) Math.ceil(((double) MAP_WIDTH / 2d - mapOffsetX + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);
        int mapEndZ   = MathUtil.roundToBase((int) Math.ceil(((double) MAP_HEIGHT / 2d - mapOffsetY + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);

        return new Rect(mapStartX, mapStartZ, mapEndX, mapEndZ);
    }

    private void renderSubTiles(PoseStack poseStack, TileRenderIterator tiles, Pos2I startScreenPos) {
        poseStack.pushPose();
        poseStack.translate(startScreenPos.x, startScreenPos.y, 0);
        for(var subtiles : tiles) {
            for (var subtile : subtiles) {
                if (subtile == null || subtile.tile == null) continue;
                var texture = TileTextureMap.instance().getTexture(subtile);
                if (texture instanceof TileTexture) {
                    var tileTexture = (TileTexture) texture;
                    tileTexture.bind();
                    tileTexture.drawSubTile(poseStack, subtile, tileHalfSize);
                }
            }
        }
        poseStack.popPose();
    }

    private int getAtlasID() {
        return AntiqueAtlasMod.CONFIG.itemNeeded ?
                AtlasItem.getAtlasID(Minecraft.getInstance().player.getOffhandItem()) :
                Minecraft.getInstance().player.getUUID().hashCode();
    }

    protected void updateAtlasData() {
        int atlasID = getAtlasID();

        biomeData = AntiqueAtlasMod.tileData
                .getData(atlasID, player.getCommandSenderWorld())
                .getWorldData(player.getCommandSenderWorld().dimension());
        globalMarkersData = AntiqueAtlasMod.globalMarkersData.getData()
                .getMarkersDataInWorld(player.getCommandSenderWorld().dimension());
        MarkersData markersData = AntiqueAtlasMod.markersData
                .getMarkersData(atlasID, player.getCommandSenderWorld());
        if (markersData != null) {
            localMarkersData = markersData
                    .getMarkersDataInWorld(player.getCommandSenderWorld().dimension());
        } else {
            localMarkersData = null;
        }
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(PipBoy.bred, PipBoy.bgreen, PipBoy.bblue, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, texture);
        blit(poseStack, leftPos, topPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        RenderSystem.setShaderTexture(0, pipboy_screen); //Pip Boy Skin
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
        
        var mapPos = getMapPos();
        renderTiles(poseStack, mapPos);
    }

    public void warningPipboy() {
        page_buffer = PipBoy.warning_screen;
        image = PipBoy.warning_image;
        cords[0] = PipBoy.warn_cords[0];
        cords[1] = PipBoy.warn_cords[1];
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
        font.draw(poseStack, new TranslatableComponent("pipboy.nukacraft.data"), 79, -91, -1);

        font.draw(poseStack, new TranslatableComponent("pipboy.nukacraft.map"), 79, -68, -1);

        font.draw(poseStack, new TranslatableComponent("pipboy.nukacraft.radio"), 79, -45, -1);

        font.draw(poseStack, new TranslatableComponent("pipboy.nukacraft.rad"), 83, 52, -1);

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

    public void renderNavigationPage() {
        addRenderableWidget(getHomeButton());
        addRenderableWidget(getMapButton());
        addRenderableWidget(getOffButton());
        addRenderableWidget(getRadioButton());
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
        addRenderableWidget(getRadioButton());
        addRenderableWidget(getOffButton());
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
        return new MainPipBoyButton(leftPos + 125, topPos + -94, 14, 14,
                new TextComponent("♦"), e -> {
            clearWidgets();
            menu = true;
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            buttonMenu();
            renderArchiveNavigation();
        });
    }

    private MainPipBoyButton getMapButton(){
        return new MainPipBoyButton(leftPos + 125, topPos + -71, 14, 14,
                new TextComponent("♦"), e -> {
            clearWidgets();
            renderNavigationPage();
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            drawMap();
        });
    }

    private MainPipBoyButton getRadioButton(){
        return new MainPipBoyButton(leftPos + 125, topPos + -48, 14, 14,
                new TextComponent("♦"), e -> {
            clearWidgets();
            renderNavigationPage();
            archive_pages = round(PipBoy.content.size(), 7) - 1;
            current_archive_page = 0;
            warningPipboy();
        });
    }
    private MainPipBoyButton getBackButton(Runnable runnable){
        return new MainPipBoyButton(leftPos + -71, topPos + 61, 14, 14,
                new TextComponent(""), e -> runnable.run());
    }

    private MainPipBoyButton getOffButton(){
        return new MainPipBoyButton(leftPos + -156, topPos + 61, 14, 14,
                new TextComponent("✖"), e -> {
            minecraft.player.closeContainer();
        });
    }

    private MainPipBoyButton getForwardButton(Runnable runnable){
        return new MainPipBoyButton(leftPos + 52, topPos + 61, 14, 14,
                new TextComponent(""), e -> runnable.run());
    }


    private void renderPage() {
        page_buffer = PipBoy.content.get(current_archive).getPage(current_page).getLines();
        image = PipBoy.content.get(current_archive).getPage(current_page).getImage();
        cords[0] = PipBoy.content.get(current_archive).getPage(current_page).getXcord();
        cords[1] = PipBoy.content.get(current_archive).getPage(current_page).getYcord();
    }

    public void drawMap() {
//        addRenderableWidget(new MainPipBoyButton(leftPos + -71, topPos + 61, 14, 14,
//                new TextComponent(""), e -> {
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
            addRenderableWidget(new TextPipBoyButton(leftPos + -150, topPos + (-50 + (t * 13)),  205, 11,
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
