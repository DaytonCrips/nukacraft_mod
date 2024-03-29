package com.nukateam.map.impl.atlas.client.gui;

import com.nukateam.map.api.client.AtlasClientAPI;
import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.client.*;
import com.nukateam.map.impl.atlas.client.gui.core.*;
import com.nukateam.map.impl.atlas.client.gui.core.GuiStates.IState;
import com.nukateam.map.impl.atlas.client.gui.core.GuiStates.SimpleState;
import com.nukateam.map.impl.atlas.client.texture.TileTexture;
import com.nukateam.map.impl.atlas.core.WorldData;
import com.nukateam.map.impl.atlas.event.MarkerClickedCallback;
import com.nukateam.map.impl.atlas.event.MarkerHoveredCallback;
import com.nukateam.map.impl.atlas.item.AtlasItem;
import com.nukateam.map.impl.atlas.marker.DimensionMarkersData;
import com.nukateam.map.impl.atlas.marker.Marker;
import com.nukateam.map.impl.atlas.marker.MarkersData;
import com.nukateam.map.impl.atlas.network.packet.c2s.play.BrowsingPositionC2SPacket;
import com.nukateam.map.impl.atlas.registry.MarkerRenderInfo;
import com.nukateam.map.impl.atlas.registry.MarkerType;
import com.nukateam.map.impl.atlas.util.ExportImageUtil;
import com.nukateam.map.impl.atlas.util.Log;
import com.nukateam.map.impl.atlas.util.MathUtil;
import com.nukateam.map.impl.atlas.util.Rect;
import com.jetug.chassis_core.common.util.Pos2I;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoyScreen;
import com.nukateam.nukacraft.common.registery.ModSounds;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

import java.io.File;
import java.text.*;
import java.util.*;

import static com.nukateam.map.impl.atlas.util.MathUtil.*;
import static com.nukateam.nukacraft.common.data.utils.PipBoyUtils.setPipboyShader;

public class GuiAtlasBase extends GuiComponent {
//    public static final int WIDTH = 327; //255
//    public static final int HEIGHT = 207;
//
//    public static final int MAP_BORDER_WIDTH = 17;
//    public static final int MAP_BORDER_HEIGHT = 15;
//    public static final int MAP_WIDTH = 226; //WIDTH - MAP_BORDER_WIDTH * 2; //226
//    public static final int MAP_HEIGHT = 147;

    public static final int WIDTH = 255; //255
    public static final int HEIGHT = 145;
    public static final int MAP_BORDER_WIDTH = 6;
    public static final int MAP_BORDER_HEIGHT = 17;
    public static final int MAP_WIDTH = 223; //WIDTH - MAP_BORDER_WIDTH * 2; //226
    public static final int MAP_HEIGHT = 143;
    public static final int MARKER_SIZE = 32;
    public static final int PLAYER_ICON_WIDTH = 7;
    public static final int PLAYER_ICON_HEIGHT = 8;
    public static final float PLAYER_ROTATION_STEPS = 16;

    private static final Pos2I BOOKMARKS_POS = new Pos2I(-3, 16);
    private static final Pos2I BOOKMARKS_CONTAINER_SIZE = new Pos2I(21, MAP_HEIGHT);
    private static final Rect MARKER_BOUNDS = new Rect(11, 22, MAP_WIDTH, MAP_HEIGHT + 10);
    private static final Rect PLAYER_MARKER_BOX = new Rect(-3, 22, -12, 12);
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");

    private static final String[] ZOOM_NAMES = new String[]{"256", "128", "64", "32", "16", "8", "4", "2", "1", "1/2", "1/4", "1/8", "1/16", "1/32", "1/64", "1/128", "1/256"};

    /** If the map scale goes below this value, the tiles will not scale down visually, but will instead span greater area.*/
    private static final double MIN_SCALE_THRESHOLD = 0.5;
    private final long[] renderTimes = new long[30];
    private int renderTimesIndex = 0;

    // States ==================================================================

    private final GuiStates state = new GuiStates();

    /** If on, navigate the map normally.*/
    private final IState NORMAL = new SimpleState();

    /** If on, all markers as well as the player icon are hidden.*/
    private final IState HIDING_MARKERS = new IState() {
        @Override
        public void onEnterState() {
            // Set the button as not selected so that it can be clicked again:
            btnShowMarkers.setSelected(false);
            btnShowMarkers.setTitle(new TranslatableComponent("gui.nukacraft.showMarkers"));
            btnShowMarkers.setIconTexture(Textures.ICON_SHOW_MARKERS);
            btnShowMarkers.setIconTexture(Textures.ICON_SHOW_MARKERS);
        }

        @Override
        public void onExitState() {
            btnShowMarkers.setSelected(false);
            btnShowMarkers.setTitle(new TranslatableComponent("gui.nukacraft.hideMarkers"));
            btnShowMarkers.setIconTexture(Textures.ICON_HIDE_MARKERS);
        }
    };

    /**
     * If on, a semi-transparent marker is attached to the cursor, and the
     * player's icon becomes semi-transparent as well.
     */
    private final IState PLACING_MARKER = new IState() {
        @Override
        public void onEnterState() {
            btnMarker.setSelected(true);
        }

        @Override
        public void onExitState() {
            btnMarker.setSelected(false);
        }
    };

    /** If on, the closest marker will be deleted upon mouseclick.*/
    private final IState DELETING_MARKER = new IState() {
        @Override
        public void onEnterState() {
            // GuiComponent.v.a();
            addChild(eraser);
            btnDelMarker.setSelected(true);
        }

        @Override
        public void onExitState() {
            // mc.v.b();
            removeChild(eraser);
            btnDelMarker.setSelected(false);
        }
    };


    private final IState EXPORTING_IMAGE = new IState() {
        @Override
        public void onEnterState() {
            btnExportPng.setSelected(true);
        }

        @Override
        public void onExitState() {
            btnExportPng.setSelected(false);
        }
    };

    // UI =================================================================
    /**
     * Progress bar for exporting images.
     */
    protected final ProgressBarOverlay progressBar = new ProgressBarOverlay(100, 2);

    protected final GuiCursor eraser = new GuiCursor();
    protected final GuiArrowButton btnUp, btnDown, btnLeft, btnRight;

    protected final GuiBookmarkButton btnExportPng;
    protected final GuiBookmarkButton btnMarker;
    protected final GuiBookmarkButton btnDelMarker;
    protected final GuiBookmarkButton btnShowMarkers;

    protected final GuiPipboyButton btnExit;
    protected final GuiPipboyButton btnArchive;
    protected final GuiPipboyButton btnMap;
    protected final GuiPipboyButton btnRadio;

    protected final GuiScaleBar scaleBar = new GuiScaleBar();
    protected final GuiPositionButton btnPosition;
    protected final GuiScrollingContainer markers = new GuiScrollingContainer();


    // Navigation ==============================================================

    /** Pause between after the arrow button is pressed and continuousnavigation starts, in ticks.*/
    private static final int BUTTON_PAUSE = 8;

    /** How much the map view is offset, in blocks, per click (or per tick).*/
    private static final int navigateStep = 24;

    /** The button which is currently being pressed. Used for continuousnavigation using the arrow buttons. Also used to prevent immediatecanceling of placing marker.*/
    protected GuiComponentButton selectedButton = null;

    /**
     * Time in world ticks when the button was pressed. Used to create a pause
     * before continuous navigation using the arrow buttons.
     */
    protected long timeButtonPressed = 0;

    /**
     * Set to true when dragging the map view.
     */
    protected boolean isDragging = false;

    /**
     * Offset to the top left corner of the tile at (0, 0) from the center of
     * the map drawing area, in pixels.
     */
    protected int mapOffsetX, mapOffsetY;
    protected Integer targetOffsetX, targetOffsetY;
    /**
     * If true, the player's icon will be in the center of the GUI, and the
     * offset of the tiles will be calculated accordingly. Otherwise it's the
     * position of the player that will be calculated with respect to the
     * offset.
     */
    protected boolean followPlayer;


    /** Pixel-to-block ratio.*/
    private double mapScale;
    /** The visual size of a tile in pixels.*/
    private int tileHalfSize;
    /*** The number of chunks a tile spans.*/
    private int tile2ChunkScale;


    // Markers =================================================================

    /**
     * Local markers in the current dimension
     */
    private DimensionMarkersData localMarkersData;
    /**
     * Global markers in the current dimension
     */
    private DimensionMarkersData globalMarkersData;
    /**
     * The marker highlighted by the eraser. Even though multiple markers may
     * be highlighted at the same time, only one of them will be deleted.
     */
    private Marker hoveredMarker;

    private final GuiMarkerFinalizer markerFinalizer = new GuiMarkerFinalizer();
    /**
     * Displayed where the marker is about to be placed when the Finalizer GUI is on.
     */
    private final GuiBlinkingMarker blinkingIcon = new GuiBlinkingMarker();

    /**
     * Coordinate scale factor relative to the actual screen size.
     */
    private double screenScale;

    protected Player player;
    protected ItemStack stack;
    protected WorldData biomeData;

    private long lastUpdateMillis = System.currentTimeMillis();
    private int scaleAlpha = 255;
    private int scaleClipIndex = 0;
    private final int zoomLevelOne = 8;
    private int zoomLevel = zoomLevelOne;

    private Thread exportThread;

    @SuppressWarnings("rawtypes")
    public GuiAtlasBase() {
        setSize(WIDTH, HEIGHT);
        setMapScale(0.5);
        followPlayer = true;
        setInterceptKeyboard(true);

        btnUp = GuiArrowButton.up();
        btnDown = GuiArrowButton.down();
        btnLeft = GuiArrowButton.left();
        btnRight = GuiArrowButton.right();
        btnPosition = new GuiPositionButton();
        btnPosition.setEnabled(!followPlayer);
        btnMarker = new GuiBookmarkButton(0, Textures.ICON_ADD_MARKER, new TranslatableComponent("gui.nukacraft.addMarker"));
        btnDelMarker = new GuiBookmarkButton(0, Textures.ICON_DELETE_MARKER, new TranslatableComponent("gui.nukacraft.delMarker"));
        btnShowMarkers = new GuiBookmarkButton(0, Textures.ICON_HIDE_MARKERS, new TranslatableComponent("gui.nukacraft.hideMarkers"));
        btnExit = new GuiPipboyButton(Textures.EXIT);
        btnArchive = new GuiPipboyButton(Textures.EXIT);
        btnMap = new GuiPipboyButton(Textures.EXIT);
        btnRadio = new GuiPipboyButton(Textures.EXIT);

        btnExportPng = new GuiBookmarkButton(1, Textures.ICON_EXPORT, new TranslatableComponent("gui.nukacraft.exportImage")) {
            @Override
            public boolean isEnabled() {
                return !ExportImageUtil.isExporting;
            }
        };

        setupButtons();

        addChild(markers).setRelativeCoords(BOOKMARKS_POS.x, BOOKMARKS_POS.y);
        markers.setViewportSize(BOOKMARKS_CONTAINER_SIZE.x, BOOKMARKS_CONTAINER_SIZE.y)
                .setWheelScrollsVertically()
                .renderBar(false);
        markerFinalizer.addMarkerListener(blinkingIcon);
        eraser.setTexture(Textures.ERASER, 12, 14, 2, 11);
        state.switchTo(NORMAL);
    }

    private void setupButtons() {
        btnUp.addListener       (this::onPositionChanged);
        btnDown.addListener     (this::onPositionChanged);
        btnLeft.addListener     (this::onPositionChanged);
        btnRight.addListener    (this::onPositionChanged);
        btnPosition.addListener (this::onPositionChanged);

//        addChild(btnUp).offsetGuiCoords(148, 10);
//        addChild(btnDown).offsetGuiCoords(148, 194);
//        addChild(btnLeft).offsetGuiCoords(15, 100);
//        addChild(btnRight).offsetGuiCoords(283, 100);

        var x = -11;
        var y = -2;

        addChild(btnPosition    ).offsetGuiCoords(x + 225, y + 148);
        addChild(scaleBar       ).offsetGuiCoords(x + 121, y + 171);
        addChild(btnExit        ).offsetGuiCoords(x + 18 , y + 176);
        addChild(btnArchive     ).offsetGuiCoords(x + 299, y + 21);
        addChild(btnMap         ).offsetGuiCoords(x + 299, y + 44);
        addChild(btnRadio       ).offsetGuiCoords(x + 299, y + 67);

//        addChild(btnMarker      ).offsetGuiCoords( x + 219, y + 14);
//        addChild(btnDelMarker   ).offsetGuiCoords( x + 219, y + 33);
//        addChild(btnShowMarkers ).offsetGuiCoords( x + 219, y + 52);

        var navX = 0;
        var navY = 5;
        addChild(btnMarker      ).offsetGuiCoords(navX + x + 219, navY + y + 14);
        addChild(btnDelMarker   ).offsetGuiCoords(navX + x + 219, navY + y + 33);
        addChild(btnShowMarkers ).offsetGuiCoords(navX + x + 219, navY + y + 52);



        //addChild(btnExportPng   ).offsetGuiCoords(200, 75);
        //addChild(testButton     ).offsetGuiCoords(280, 100);

        //testButton.addListener(button -> {});

//        btnExportPng.addListener(button -> {
//            if (stack != null || !MapCore.CONFIG.itemNeeded) {
//                exportThread = new Thread(() -> exportImage(getAtlasID()), "Atlas file export thread");
//                exportThread.start();
//            }
//        });
        btnMarker.addListener(this::addMarker);
        btnDelMarker.addListener(this::deleteMarker);
        btnShowMarkers.addListener(this::showMarkers);
        btnExit.addListener(this::close);
        btnArchive.addListener(this::openArchives);
        btnRadio.addListener(this::openRadio);
        scaleBar.setMapScale(1);
    }

    private void openRadio(GuiComponentButton guiComponentButton) {
        PipBoyScreen.openRadio();
    }

    private void openArchives(GuiComponentButton guiComponentButton) {
        PipBoyScreen.openArchive();
    }

    private void close(GuiComponentButton guiComponentButton) {
        close();
    }

    @Override
    public void init() {
        super.init();
        if (state.is(EXPORTING_IMAGE)) {
            state.switchTo(NORMAL); //TODO: his causes the Export PNG progress bar to disappear when resizing game window
        }

        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(true);
        screenScale = Minecraft.getInstance().getWindow().getGuiScale();
        setCentered();

        offsetGuiCoords(-12,-25);

//        offsetGuiCoords(-6, 16);
        updateBookmarkerList();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void onClose() {
        super.onClose();
        markerFinalizer.close();
        removeChild(blinkingIcon);
        // Keyboard.enableRepeatEvents(false);
        biomeData.setBrowsingPosition(mapOffsetX, mapOffsetY, mapScale);

        new BrowsingPositionC2SPacket(getAtlasID(), player.getCommandSenderWorld().dimension(), mapOffsetX, mapOffsetY, mapScale).send();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseState) {
        boolean result = super.mouseClicked(mouseX, mouseY, mouseState);
        if (state.is(EXPORTING_IMAGE)) {
            return result;
        }

        if (result) {
            return true;
        }

        // close atlas with right-click
//        if (mouseState == 1 && state.is(NORMAL)) {
//            onClose();
//            return true;
//        }

        // If clicked on the map, start dragging
        int mapX = (width - MAP_WIDTH) / 2;
        int mapY = (height - MAP_HEIGHT) / 2;
        boolean isMouseOverMap = mouseX >= mapX && mouseX <= mapX + MAP_WIDTH &&
                mouseY >= mapY && mouseY <= mapY + MAP_HEIGHT;
        if (!state.is(NORMAL) && !state.is(HIDING_MARKERS)) {
            int atlasID = getAtlasID();

            if (state.is(PLACING_MARKER) // If clicked on the map, place marker:
                    && isMouseOverMap && mouseState == 0 /* left click */) {
                markerFinalizer.setMarkerData(player.getCommandSenderWorld(), atlasID,
                        screenXToWorldX((int) mouseX), screenYToWorldZ((int) mouseY));
                addChild(markerFinalizer);

                blinkingIcon.setTexture(markerFinalizer.selectedType.getTexture(),
                        MARKER_SIZE, MARKER_SIZE);
                addChildBehind(markerFinalizer, blinkingIcon)
                        .setRelativeCoords((int) mouseX - getGuiX() - MARKER_SIZE / 2,
                                (int) mouseY - getGuiY() - MARKER_SIZE / 2);

                // Need to intercept keyboard events to type in the label:
                setInterceptKeyboard(true);

                // Un-press all keys to prevent player from walking infinitely:
                KeyMapping.releaseAll();

                state.switchTo(NORMAL);
                return true;
            } else if (state.is(DELETING_MARKER) // If clicked on a marker, delete it:
                    && hoveredMarker != null && !hoveredMarker.isGlobal() && isMouseOverMap && mouseState == 0) {
                AtlasClientAPI.getMarkerAPI().deleteMarker(player.getCommandSenderWorld(),
                        atlasID, hoveredMarker.getId());
                hoveredMarker = null;
                player.getCommandSenderWorld().playSound(player, player.blockPosition(),
                        SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.AMBIENT,
                        1F, 0.5F);
            }
            state.switchTo(NORMAL);
        } else if (isMouseOverMap && selectedButton == null) {
            if (hoveredMarker == null || !MinecraftForge.EVENT_BUS.post(new MarkerClickedCallback.TheEvent(player, hoveredMarker, mouseState))) {
                isDragging = true;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_UP) {
            navigateMap(0, navigateStep);
        } else if (keyCode == GLFW.GLFW_KEY_DOWN) {
            navigateMap(0, -navigateStep);
        } else if (keyCode == GLFW.GLFW_KEY_LEFT) {
            navigateMap(navigateStep, 0);
        } else if (keyCode == GLFW.GLFW_KEY_RIGHT) {
            navigateMap(-navigateStep, 0);
        } else if (keyCode == GLFW.GLFW_KEY_EQUAL || keyCode == GLFW.GLFW_KEY_KP_ADD) {
            setMapScale(mapScale * 2);
        } else if (keyCode == GLFW.GLFW_KEY_MINUS || keyCode == GLFW.GLFW_KEY_KP_SUBTRACT) {
            setMapScale(mapScale / 2);
        } else if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            onClose();
        } else {
            var hotbarKeys = Minecraft.getInstance().options.keyHotbarSlots;
            for (KeyMapping bind : hotbarKeys) {
                // only handle hotbarkeys when marker gui isn't shown1
                if (bind.matches(keyCode, scanCode) && this.markerFinalizer.getParent() == null) {
                    onClose();
                    // if we close the gui, then don't handle the event
                    return false;
                }
            }

            return super.keyPressed(keyCode, scanCode, modifiers);
        }

        return true;
    }

    @Override
    public boolean mouseScrolled(double mx, double my, double wheelMove) {
        double origWheelMove = wheelMove;

        boolean handled = super.mouseScrolled(mx, my, origWheelMove);

        if (!handled && wheelMove != 0) {
            wheelMove = wheelMove > 0 ? 1 : -1;
            if (MapCore.CONFIG.doReverseWheelZoom) {
                wheelMove *= -1;
            }

            double mouseOffsetX = Minecraft.getInstance().getWindow().getWidth() / screenScale / 2 - getMouseX();
            double mouseOffsetY = Minecraft.getInstance().getWindow().getHeight() / screenScale / 2 - getMouseY();
            double newScale = mapScale * Math.pow(2, wheelMove);
            double addOffsetX = 0;
            double addOffsetY = 0;
            if (Math.abs(mouseOffsetX) < MAP_WIDTH / 2f && Math.abs(mouseOffsetY) < MAP_HEIGHT / 2f) {
                addOffsetX = mouseOffsetX * wheelMove;
                addOffsetY = mouseOffsetY * wheelMove;

                if (wheelMove > 0) {
                    addOffsetX *= mapScale / newScale;
                    addOffsetY *= mapScale / newScale;
                }
            }

            setMapScale(newScale, (int) addOffsetX, (int) addOffsetY);

            minecraft = Minecraft.getInstance();

            if(wheelMove > 0)
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(ModSounds.PIPBOY_UP.get(), 1.0F));
            else
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI(ModSounds.PIPBOY_DOWN.get(), 1.0F));

            return true;
        }

        return handled;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int mouseState) {
        boolean result = false;
        if (mouseState != -1) {
            result = selectedButton != null || isDragging;
            selectedButton = null;
            isDragging = false;
        }
        return super.mouseReleased(mouseX, mouseY, mouseState) || result;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int lastMouseButton, double deltaX, double deltaY) {
        boolean result = false;
        if (isDragging) {
            followPlayer = false;
            btnPosition.setEnabled(true);
            mapOffsetX += (int) deltaX;
            mapOffsetY += (int) deltaY;
            result = true;
        }
        return super.mouseDragged(mouseX, mouseY, lastMouseButton, deltaX, deltaY) || result;
    }

    @Override
    public void tick() {
        super.tick();
        if (player == null) return;
        if (followPlayer) {
            setMapPosition((int)player.getX(), (int)player.getZ());
        }
        if (player.getCommandSenderWorld().getGameTime() > timeButtonPressed + BUTTON_PAUSE) {
            navigateByButton(selectedButton);
        }

        if (targetOffsetX != null) {
            if (Math.abs(getTargetPositionX() - mapOffsetX) > navigateStep) {
                navigateMap(getTargetPositionX() > mapOffsetX ? navigateStep : -navigateStep, 0);
            } else {
                mapOffsetX = getTargetPositionX();
                targetOffsetX = null;
            }
        }

        if (targetOffsetY != null) {
            if (Math.abs(getTargetPositionY() - mapOffsetY) > navigateStep) {
                navigateMap(0, getTargetPositionY() > mapOffsetY ? navigateStep : -navigateStep);
            } else {
                mapOffsetY = getTargetPositionY();
                targetOffsetY = null;
            }
        }

        updateAtlasData();
    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float par3) {
        long currentMillis = System.currentTimeMillis();
        long deltaMillis = currentMillis - lastUpdateMillis;
        lastUpdateMillis = currentMillis;
        if (MapCore.CONFIG.debugRender) printDebugInfo();

        super.renderBackground(poseStack);

        setPipboyShader();
        Textures.PIPBOY_SCREEN.draw(poseStack, getGuiX(), getGuiY());

        RenderSystem.setShaderColor(1, 1, 1, 1);
        Textures.PIPBOY_FRAME.draw(poseStack, getGuiX(), getGuiY());

        setPipboyShader();

        if ((stack == null && MapCore.CONFIG.itemNeeded) || biomeData == null)
            return;

        if (state.is(DELETING_MARKER))
            setPipboyShader(0.5f);

        var mapPos = getMapPos();
        var markerPos = getMarkerPos(mapPos);
        var iconScale = getIconScale();

        renderTiles(poseStack, mapPos);
        // Overlay the frame so that edges of the map are smooth:


//        renderMarkers(poseStack, markerPos, globalMarkersData);
//        renderMarkers(poseStack, markerPos, localMarkersData);

        int mapStartX = MathUtil.roundToBase((int) Math.floor(-((double) MAP_WIDTH / 2d + mapOffsetX + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);
        int mapStartZ = MathUtil.roundToBase((int) Math.floor(-((double) MAP_HEIGHT / 2d + mapOffsetY + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);
        int mapEndX = MathUtil.roundToBase((int) Math.ceil(((double) MAP_WIDTH / 2d - mapOffsetX + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);
        int mapEndZ = MathUtil.roundToBase((int) Math.ceil(((double) MAP_HEIGHT / 2d - mapOffsetY + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);

        int markersStartX = MathUtil.roundToBase(mapStartX, MarkersData.CHUNK_STEP) / MarkersData.CHUNK_STEP - 1;
        int markersStartZ = MathUtil.roundToBase(mapStartZ, MarkersData.CHUNK_STEP) / MarkersData.CHUNK_STEP - 1;
        int markersEndX = MathUtil.roundToBase(mapEndX, MarkersData.CHUNK_STEP) / MarkersData.CHUNK_STEP + 1;
        int markersEndZ = MathUtil.roundToBase(mapEndZ, MarkersData.CHUNK_STEP) / MarkersData.CHUNK_STEP + 1;

        RenderSystem.disableScissor();

        // Overlay the frame so that edges of the map are smooth:

        // Draw global markers:
        renderMarkers(poseStack, markersStartX, markersStartZ, markersEndX, markersEndZ, globalMarkersData);
        renderMarkers(poseStack, markersStartX, markersStartZ, markersEndX, markersEndZ, localMarkersData);

//        Textures.PIPBOY_FRAME_NARROW.draw(poseStack, getGuiX(), getGuiY());

//        renderScaleOverlay(poseStack, deltaMillis);

        if (!state.is(HIDING_MARKERS)) renderPlayer(poseStack, iconScale);

        // Draw buttons:
        super.render(poseStack, mouseX, mouseY, par3);

        if (state.is(PLACING_MARKER))
            drawPlacingMarker(poseStack, mouseX, mouseY, iconScale);

        renderDebugTooltip();

        // Draw progress overlay:
        if (state.is(EXPORTING_IMAGE)) {
            renderBackground(poseStack);
            progressBar.draw(poseStack, (width - 100) / 2, height / 2 - 34);
        }
        RenderSystem.setShaderColor(1, 1, 1, 1);
    }

    public void openMarkerFinalizer(Component name) {
        markerFinalizer.setMarkerData(player.getCommandSenderWorld(),
                getAtlasID(),
                (int) player.getX(), (int) player.getZ());
        addChild(markerFinalizer);

        if (name != null) {
            markerFinalizer.setMarkerName(name);
        }

        blinkingIcon.setTexture(markerFinalizer.selectedType.getTexture(),
                MARKER_SIZE, MARKER_SIZE);
        addChildBehind(markerFinalizer, blinkingIcon)
                .setRelativeCoords(worldXToScreenX((int) player.getX()) - getGuiX() - MARKER_SIZE / 2,
                        worldZToScreenY((int) player.getZ()) - getGuiY() - MARKER_SIZE / 2);

        // Need to intercept keyboard events to type in the label:
        setInterceptKeyboard(true);

        // Un-press all keys to prevent player from walking infinitely:
        KeyMapping.releaseAll();

        selectedButton = null;
        state.switchTo(NORMAL);
    }

    public void loadSavedBrowsingPosition() {
        // Apply zoom first, because browsing position depends on it:
        setMapScale(biomeData.getBrowsingZoom());
        mapOffsetX = biomeData.getBrowsingX();
        mapOffsetY = biomeData.getBrowsingY();
        isDragging = false;
    }

    public void updateBookmarkerList() {
        markers.removeAllContent();
        markers.scrollTo(0,0);

        if(localMarkersData == null) return;

        int contentY = 0;
        for (var marker : localMarkersData.getAllMarkers()) {
            if (!marker.isVisibleAhead() || marker.isGlobal()) {
                continue;
            }

            var bookmark = new GuiMarkerBookmark(marker);
//            bookmark.setRelativeX(20);

            bookmark.addListener(button -> {
                if(state.is(NORMAL)) {
                    setTargetPosition(marker.getX(), marker.getZ());
                    followPlayer = false;
                    btnPosition.setEnabled(true);
                }
                else if(state.is(DELETING_MARKER)) {
                    AtlasClientAPI.getMarkerAPI().deleteMarker(player.getCommandSenderWorld(),
                            getAtlasID(), marker.getId());
                    player.getCommandSenderWorld().playSound(player, player.blockPosition(),
                            SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.AMBIENT,
                            1F, 0.5F);
                    state.switchTo(NORMAL);
                }
            });

            markers.addContent(bookmark).setRelativeY(contentY);
            contentY += 18 + 2;
        }
    }

    // Find chunk coordinates of the top left corner of the map.
    // The 'roundToBase' is required so that when the map scales below the
    // threshold the tiles don't change when map position changes slightly.
    // The +-2 at the end provide margin so that tiles at the edges of
    // the page have their stitched texture correct.
    protected Rect getMapPos(){
        int mapStartX = roundToBase((int) Math.floor(-((double) MAP_WIDTH / 2d + mapOffsetX + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);
        int mapStartZ = roundToBase((int) Math.floor(-((double) MAP_HEIGHT / 2d + mapOffsetY + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);
        int mapEndX   = roundToBase((int) Math.ceil(((double) MAP_WIDTH / 2d - mapOffsetX + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);
        int mapEndZ   = roundToBase((int) Math.ceil(((double) MAP_HEIGHT / 2d - mapOffsetY + 2 * tileHalfSize) / mapScale / 16d), tile2ChunkScale);

        return new Rect(mapStartX, mapStartZ, mapEndX, mapEndZ);
    }

    protected Rect getMarkerPos(Rect mapPos){
        int markersStartX = roundToBase(mapPos.minX, MarkersData.CHUNK_STEP) / MarkersData.CHUNK_STEP - 1;
        int markersStartZ = roundToBase(mapPos.minY, MarkersData.CHUNK_STEP) / MarkersData.CHUNK_STEP - 1;
        int markersEndX   = roundToBase(mapPos.maxX, MarkersData.CHUNK_STEP) / MarkersData.CHUNK_STEP + 1;
        int markersEndZ   = roundToBase(mapPos.maxY, MarkersData.CHUNK_STEP) / MarkersData.CHUNK_STEP + 1;

        return new Rect(markersStartX, markersStartZ, markersEndX, markersEndZ);
    }

    protected Pos2I getStartScreenPos(Rect mapPos){
        var mapStartScreenX = getGuiX() + WIDTH  / 2 + (int) ((mapPos.minX << 4) * mapScale) + mapOffsetX;
        var mapStartScreenY = getGuiY() + HEIGHT / 2 + (int) ((mapPos.minY << 4) * mapScale) + mapOffsetY;
        return new Pos2I(mapStartScreenX, mapStartScreenY);
    }

    /**
     * Update {@link #biomeData}, {@link #localMarkersData},
     * {@link #globalMarkersData}
     */
    protected void updateAtlasData() {
        int atlasID = getAtlasID();

        biomeData = MapCore.tileData
                .getData(atlasID, player.getCommandSenderWorld())
                .getWorldData(player.getCommandSenderWorld().dimension());
        globalMarkersData = MapCore.globalMarkersData.getData()
                .getMarkersDataInWorld(player.getCommandSenderWorld().dimension());
        MarkersData markersData = MapCore.markersData
                .getMarkersData(atlasID, player.getCommandSenderWorld());
        if (markersData != null) {
            localMarkersData = markersData
                    .getMarkersDataInWorld(player.getCommandSenderWorld().dimension());
        } else {
            localMarkersData = null;
        }
    }



    /**
     * Opens a dialog window to select which file to save to, then performs
     * rendering of the map of current dimension into a PNG image.
     */
    private void exportImage(int atlasID) {
        boolean showMarkers = !state.is(HIDING_MARKERS);
        state.switchTo(EXPORTING_IMAGE);
        // Default file name is "Atlas <N>.png"
        ExportImageUtil.isExporting = true;

        File screenshot_folder = new File(Minecraft.getInstance().gameDirectory, "screenshots");
        if (!screenshot_folder.isDirectory()) {
            screenshot_folder.mkdir();
        }

        String outputname = "atlas-" + DATE_FORMAT.format(new Date());

        File file = new File(screenshot_folder, outputname + ".png");
        for (int i = 1; file.exists(); i++) {
            file = new File(screenshot_folder, outputname + "_" + i + ".png");
        }

        try {
            Log.info("Exporting image from Atlas #%d to file %s", atlasID, file.getAbsolutePath());
            ExportImageUtil.exportPngImage(biomeData, globalMarkersData, localMarkersData, file, showMarkers);
            Log.info("Finished exporting image");
        } catch (OutOfMemoryError e) {
            Log.warn(e, "Image is too large, trying to export in strips");
            try {
                ExportImageUtil.exportPngImageTooLarge(biomeData, globalMarkersData, localMarkersData, file, showMarkers);
            } catch (OutOfMemoryError e2) {
                int minX = (biomeData.getScope().minX - 1) * ExportImageUtil.TILE_SIZE;
                int minY = (biomeData.getScope().minY - 1) * ExportImageUtil.TILE_SIZE;
                int outWidth = (biomeData.getScope().maxX + 2) * ExportImageUtil.TILE_SIZE - minX;
                int outHeight = (biomeData.getScope().maxY + 2) * ExportImageUtil.TILE_SIZE - minY;

                Log.error(e2, "Image is STILL too large, how massive is this map?! Answer: (%dx%d)", outWidth, outHeight);

                ExportUpdateListener.INSTANCE.setStatusString(I18n.get("gui.nukacraft.export.tooLarge"));
                ExportImageUtil.isExporting = false;
                return; //Don't switch to normal state yet so that the error message can be read.
            }
        }

        ExportImageUtil.isExporting = false;
        state.switchTo(showMarkers ? NORMAL : HIDING_MARKERS);
    }

    /**
     * Offset the map view depending on which button was pressed.
     */
    private void navigateByButton(GuiComponentButton btn) {
        if (btn == null) return;
        if (btn.equals(btnUp)) {
            navigateMap(0, navigateStep);
        } else if (btn.equals(btnDown)) {
            navigateMap(0, -navigateStep);
        } else if (btn.equals(btnLeft)) {
            navigateMap(navigateStep, 0);
        } else if (btn.equals(btnRight)) {
            navigateMap(-navigateStep, 0);
        }
    }

    /**
     * Offset the map view by given values, in blocks.
     */
    private void navigateMap(int dx, int dy) {
        mapOffsetX += dx;
        mapOffsetY += dy;
        followPlayer = false;
        btnPosition.setEnabled(true);
    }

    private void setMapPosition(int x, int z) {
        mapOffsetX = (int) (-x * mapScale);
        mapOffsetY = (int) (-z * mapScale);
        followPlayer = false;
    }

    private void setTargetPosition(int x, int z) {
        targetOffsetX = x;
        targetOffsetY = z;
    }

    private int getTargetPositionX() {
        return (int)(-targetOffsetX * mapScale);
    }

    private int getTargetPositionY() {
        return (int)(-targetOffsetY * mapScale);
    }


    /**
     * Set the pixel-to-block ratio, maintaining the current center of the screen.
     */
    public void setMapScale(double scale) {
        setMapScale(scale, 0, 0);
    }

    /**
     * Set the pixel-to-block ratio, maintaining the current center of the screen with additional offset.
     */
    private void setMapScale(double scale, int addOffsetX, int addOffsetY) {
        double oldScale = mapScale;
        mapScale = Math.min(Math.max(scale, MapCore.CONFIG.minScale), MapCore.CONFIG.maxScale);

        // Scaling not needed
        if (oldScale == mapScale) {
            return;
        }

        if (mapScale >= MIN_SCALE_THRESHOLD) {
            tileHalfSize = (int) Math.round(8 * mapScale);
            tile2ChunkScale = 1;
        } else {
            tileHalfSize = (int) Math.round(8 * MIN_SCALE_THRESHOLD);
            tile2ChunkScale = (int) Math.round(MIN_SCALE_THRESHOLD / mapScale);
        }

        // Times 2 because the contents of the Atlas are rendered at resolution 2 times smaller:
        scaleBar.setMapScale(mapScale * 2);
        mapOffsetX = (int) ((mapOffsetX + addOffsetX) * (mapScale / oldScale));
        mapOffsetY = (int) ((mapOffsetY + addOffsetY) * (mapScale / oldScale));
        scaleClipIndex = Mth.log2((int) (mapScale * 8192)) + 1 - 13;
        zoomLevel = -scaleClipIndex + zoomLevelOne;
        scaleAlpha = 255;

        if (followPlayer && (addOffsetX != 0 || addOffsetY != 0)) {
            followPlayer = false;
            btnPosition.setEnabled(true);
        }
    }

    private void onPositionChanged(GuiComponentButton button) {
        selectedButton = button;
        if (button.equals(btnPosition)) {
            followPlayer = true;
            targetOffsetX = null;
            targetOffsetY = null;
            btnPosition.setEnabled(false);
        } else {
            // Navigate once, before enabling pause:
            navigateByButton(selectedButton);
            timeButtonPressed = player.getCommandSenderWorld().getGameTime();
        }
    }

    private void showMarkers(GuiComponentButton button) {
        selectedButton = null;
        if (state.is(HIDING_MARKERS)) {
            state.switchTo(NORMAL);
        } else if (stack != null || !MapCore.CONFIG.itemNeeded) {
            selectedButton = null;
            state.switchTo(HIDING_MARKERS);
        }
    }

    private void deleteMarker(GuiComponentButton button) {
        if (state.is(DELETING_MARKER)) {
            selectedButton = null;
            state.switchTo(NORMAL);
        } else if (stack != null || !MapCore.CONFIG.itemNeeded) {
            selectedButton = button;
            state.switchTo(DELETING_MARKER);
        }
    }

    private void addMarker(GuiComponentButton button) {
        if (state.is(PLACING_MARKER)) {
            selectedButton = null;
            state.switchTo(NORMAL);
        } else if (stack != null || !MapCore.CONFIG.itemNeeded) {
            selectedButton = button;
            state.switchTo(PLACING_MARKER);

            // While holding shift, we create a marker on the player's position
            if (hasShiftDown()) {
                markerFinalizer.setMarkerData(player.getCommandSenderWorld(),
                        getAtlasID(),
                        (int) player.getX(), (int) player.getZ());
                addChild(markerFinalizer);

                blinkingIcon.setTexture(markerFinalizer.selectedType.getTexture(),
                        MARKER_SIZE, MARKER_SIZE);
                addChildBehind(markerFinalizer, blinkingIcon)
                        .setRelativeCoords(worldXToScreenX((int) player.getX()) - getGuiX() - MARKER_SIZE / 2,
                                worldZToScreenY((int) player.getZ()) - getGuiY() - MARKER_SIZE / 2);

                // Need to intercept keyboard events to type in the label:
                setInterceptKeyboard(true);

                // Un-press all keys to prevent player from walking infinitely:
                KeyMapping.releaseAll();

                selectedButton = null;
                state.switchTo(NORMAL);
            }
        }
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

    private void renderDebugTooltip() {
        if (MapCore.CONFIG.debugRender && !isDragging && isMouseOver) {
            int x = screenXToWorldX((int) getMouseX());
            int z = screenYToWorldZ((int) getMouseY());

            var coords = String.format("Coords: %d / %d", x, z);
            var pos = new ChunkPos(new BlockPos(x, 0, z));
            var chunks = String.format("Chunks: %d / %d", pos.x, pos.z);
            ResourceLocation tile = biomeData.getTile(pos.x, pos.z);

            if (tile == null) {
                drawTooltip(Arrays.asList(new TextComponent(coords), new TextComponent(chunks)), font);
            } else {
                String texture_set = TileTextureMap.instance().getTextureSet(tile).name.toString();
                drawTooltip(Arrays.asList(
                                new TextComponent(coords),
                                new TextComponent(chunks),
                                new TextComponent("Tile: " + tile),
                                new TextComponent("TSet: " + texture_set)),
                        font);
            }
        }
    }

    private void printDebugInfo() {
        renderTimes[renderTimesIndex++] = System.currentTimeMillis();
        if (renderTimesIndex == renderTimes.length) {
            renderTimesIndex = 0;
            double elapsed = 0;
            for (int i = 0; i < renderTimes.length - 1; i++) {
                elapsed += renderTimes[i + 1] - renderTimes[i];
            }
            System.out.printf("GuiAtlas avg. render time: %.3f\n", elapsed / renderTimes.length);
        }
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

    private void drawPlacingMarker(PoseStack poseStack, int mouseX, int mouseY, double iconScale) {
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        //            RenderSystem.setShaderColor(1, 1, 1, 0.5f);
        setPipboyShader(0.5f);
        markerFinalizer.selectedType.calculateMip(iconScale, mapScale, screenScale);
        MarkerRenderInfo renderInfo = markerFinalizer.selectedType.getRenderInfo(iconScale, mapScale, screenScale);
        markerFinalizer.selectedType.resetMip();
        renderInfo.tex.draw(poseStack, mouseX + renderInfo.x, mouseY + renderInfo.y);
        setPipboyShader();
//            RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.disableBlend();
    }

    private void renderPlayer(PoseStack poseStack, double iconScale) {
        // How much the player has moved from the top left corner of the map, in pixels:
        int playerOffsetX = (int) (player.getX() * mapScale) + mapOffsetX;
        int playerOffsetZ = (int) (player.getZ() * mapScale) + mapOffsetY;
        playerOffsetX = Mth.clamp(playerOffsetX, -MAP_WIDTH / 2 + PLAYER_MARKER_BOX.minX, MAP_WIDTH / 2 + PLAYER_MARKER_BOX.maxX);
        playerOffsetZ = Mth.clamp(playerOffsetZ, -MAP_HEIGHT / 2 + PLAYER_MARKER_BOX.minY, MAP_HEIGHT / 2 + PLAYER_MARKER_BOX.maxY);

        // Draw the icon:
//        RenderSystem.setShaderColor(1, 1, 1, state.is(PLACING_MARKER) ? 0.5f : 1);
        setPipboyShader(state.is(PLACING_MARKER) ? 0.5f : 1);
        poseStack.pushPose();

        var canterX = getGuiX() + WIDTH / 2 + playerOffsetX;
        var canterY = getGuiY() + HEIGHT / 2 + playerOffsetZ;
        var iconCenterX = (float) (-PLAYER_ICON_WIDTH / 2 * iconScale);
        var iconCenterY = (float) (-PLAYER_ICON_HEIGHT / 2 * iconScale);
        var playerRotation = (float) Math.round(player.getYRot() / 360f * PLAYER_ROTATION_STEPS) / PLAYER_ROTATION_STEPS * 360f;

        poseStack.translate(canterX, canterY, 0);
        poseStack.mulPose(Vector3f.ZP.rotationDegrees(180 + playerRotation));
        poseStack.translate(iconCenterX, iconCenterY, 0f);

        Textures.PLAYER.draw(poseStack, 0, 1, (int) Math.round(PLAYER_ICON_WIDTH * iconScale), (int) Math.round(PLAYER_ICON_HEIGHT * iconScale));

        poseStack.popPose();

        RenderSystem.setShaderColor(1, 1, 1, 1);
    }

    private void renderScaleOverlay(PoseStack poseStack, long deltaMillis) {
        if (scaleAlpha > 3) {
            poseStack.pushPose();
            poseStack.translate(getGuiX() + WIDTH - 13, getGuiY() + 12, 0);

            int color = scaleAlpha << 24;

            String text;
            int textWidth, xWidth;

            text = "x";
            xWidth = textWidth = this.font.width(text);
            xWidth++;
            this.font.draw(poseStack, text, -textWidth, 0, color);

            text = ZOOM_NAMES[zoomLevel];
            if (text.contains("/")) {
                String[] parts = text.split("/");

                int centerXtranslate = Math.max(this.font.width(parts[0]), this.font.width(parts[1])) / 2;
                poseStack.translate(-xWidth - centerXtranslate, (float) -this.font.lineHeight / 2, 0);

                GuiComponent.fill(poseStack, -centerXtranslate - 1, this.font.lineHeight - 1, centerXtranslate, this.font.lineHeight, color);

                textWidth = this.font.width(parts[0]);
                this.font.draw(poseStack, parts[0], (float) -textWidth / 2, 0, color);

                textWidth = this.font.width(parts[1]);
                this.font.draw(poseStack, parts[1], (float) -textWidth / 2, 10, color);
            } else {
                textWidth = this.font.width(text);
                this.font.draw(poseStack, text, -textWidth - xWidth + 1, 2, color);
            }

            poseStack.popPose();

            int deltaScaleAlpha = (int) (deltaMillis * 0.256);
            // because of some crazy high frame rate
            if (deltaScaleAlpha == 0) {
                deltaScaleAlpha = 1;
            }

            scaleAlpha -= deltaScaleAlpha;

            if (scaleAlpha < 0)
                scaleAlpha = 0;

        }
    }

    private void renderMarkers(PoseStack poseStack, Rect pos, DimensionMarkersData markersData) {
        if (markersData == null) return;

        int markersStartX = pos.minX;
        int markersStartZ = pos.minY;
        int markersEndX = pos.maxX;
        int markersEndZ = pos.maxY;

//        int markersStartX = 10;
//        int markersStartZ = 10;
//        int markersEndX   = 50;
//        int markersEndZ   = 50;

        for (int x = markersStartX; x <= markersEndX; x++) {
            for (int z = markersStartZ; z <= markersEndZ; z++) {
                var markers = markersData.getMarkersAtChunk(x, z);
                if (markers == null) continue;
                for (Marker marker : markers) {
                    renderMarker(poseStack, marker, getIconScale());
                }
            }
        }
    }

    private void renderMarkers(PoseStack matrices, int markersStartX, int markersStartZ,
                               int markersEndX, int markersEndZ, DimensionMarkersData markersData) {
        if (markersData == null) return;

        for (int x = markersStartX; x <= markersEndX; x++) {
            for (int z = markersStartZ; z <= markersEndZ; z++) {
                List<Marker> markers = markersData.getMarkersAtChunk(x, z);
                if (markers == null) continue;
                for (var marker : markers) {
                    renderMarker(matrices, marker, getIconScale());
                }
            }
        }
    }

    private void renderMarker(PoseStack poseStack, Marker marker, double scale) {
        var type = MarkerType.REGISTRY.get(marker.getType());

        if (type.shouldHide(state.is(HIDING_MARKERS), scaleClipIndex))
            return;

        int markerX = worldXToScreenX(marker.getX());
        int markerY = worldZToScreenY(marker.getZ());

        if (!marker.isVisibleAhead() && !biomeData.hasTileAt(marker.getChunkX(), marker.getChunkZ()))
            return;

        type.calculateMip(scale, mapScale, screenScale);
        var info = type.getRenderInfo(scale, mapScale, screenScale);
        var mouseIsOverMarker = type.shouldHover((getMouseX() - (markerX + info.x)) / info.tex.width(), (getMouseY() - (markerY + info.y)) / info.tex.height());
        type.resetMip();

        if (mouseIsOverMarker) {
            RenderSystem.setShaderColor(0.5f, 0.5f, 0.5f, 1);
            hoveredMarker = marker;
            MinecraftForge.EVENT_BUS.post(new MarkerHoveredCallback.TheEvent(player, marker));
        } else {
            setPipboyShader();
            if (hoveredMarker == marker)
                hoveredMarker = null;
        }

        if (state.is(PLACING_MARKER) || state.is(DELETING_MARKER) && marker.isGlobal()) {
            setPipboyShader(0.5f);
        } else {
            setPipboyShader();
        }

        if (MapCore.CONFIG.debugRender) {
            System.out.println("Rendering Marker: " + info.tex);
        }

        if (markerX <= getGuiX() + MARKER_BOUNDS.minX|| // MAP_BORDER_WIDTH ||
            markerX >= getGuiX() + MARKER_BOUNDS.maxX|| // MAP_WIDTH + MAP_BORDER_WIDTH ||
            markerY <= getGuiY() + MARKER_BOUNDS.minY|| // MAP_BORDER_HEIGHT ||
            markerY >= getGuiY() + MARKER_BOUNDS.maxY){ // MAP_HEIGHT + MAP_BORDER_HEIGHT) {
            setPipboyShader(0.5f);
//            RenderSystem.setShaderColor(1, 1, 1, 0.5f);
            info.scale(0.8);
        }

//        markerX = Mth.clamp(markerX, getGuiX() + MAP_BORDER_WIDTH,  getGuiX() + MAP_WIDTH + MAP_BORDER_WIDTH);
//        markerY = Mth.clamp(markerY, getGuiY() + MAP_BORDER_HEIGHT,  getGuiY() + MAP_HEIGHT + MAP_BORDER_HEIGHT);

        markerX = Mth.clamp(markerX, getGuiX() + MARKER_BOUNDS.minX,  getGuiX() + MARKER_BOUNDS.maxX);
        markerY = Mth.clamp(markerY, getGuiY() + MARKER_BOUNDS.minY,  getGuiY() + MARKER_BOUNDS.maxY);

        info.tex.draw(poseStack, markerX + info.x, markerY + info.y, info.width, info.height);

        RenderSystem.setShaderColor(1, 1, 1, 1);

        if (isMouseOver && mouseIsOverMarker && marker.getLabel().getString().length() > 0) {
            drawTooltip(Collections.singletonList(marker.getLabel()), font);
        }
    }

    /**
     * Returns the Y coordinate that the cursor is pointing at.
     */
    private int screenXToWorldX(int mouseX) {
        return (int) Math.round((double) (mouseX - this.width / 2 - mapOffsetX) / mapScale);
    }

    /**
     * Returns the Y block coordinate that the cursor is pointing at.
     */
    private int screenYToWorldZ(int mouseY) {
        return (int) Math.round((double) (mouseY - this.height / 2 - mapOffsetY) / mapScale);
    }

    private int worldXToScreenX(int x) {
        return (int) Math.round((double) x * mapScale + this.width / 2f + mapOffsetX);
    }

    private int worldZToScreenY(int z) {
        return (int) Math.round((double) z * mapScale + this.height / 2f + mapOffsetY);
    }

    @Override
    protected void onChildClosed(GuiComponent child) {
        if (child.equals(markerFinalizer)) {
            setInterceptKeyboard(true);
            removeChild(blinkingIcon);
        }
    }

    /**
     * Update all text labels to current localization.
     */
    public void updateL18n() {
        btnExportPng.setTitle(new TranslatableComponent("gui.nukacraft.exportImage"));
        btnMarker.setTitle(new TranslatableComponent("gui.nukacraft.addMarker"));
    }

    /**
     * Returns the scale of markers and player icon at given mapScale.
     */
    private double getIconScale() {
        if (MapCore.CONFIG.doScaleMarkers) {
            if (mapScale < 0.5) return 0.5;
            if (mapScale > 1) return 2;
        }
        return 1;
    }

    /**
     * Returns atlas id based on "itemNeeded" option
     */
    private int getAtlasID() {
        return MapCore.CONFIG.itemNeeded ? AtlasItem.getAtlasID(stack) : player.getUUID().hashCode();
    }
}
