package com.nukateam.map.impl.atlas.client;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.client.texture.DynamicTexture;
import com.nukateam.map.impl.atlas.client.texture.ITexture;
import com.nukateam.map.impl.atlas.client.texture.IconTexture;
import com.nukateam.map.impl.atlas.client.texture.Texture;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;

import static com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem.getPipboyFrame;

@OnlyIn(Dist.CLIENT)
public class Textures {
    private static final String MOD_PREFIX = MapCore.ID + ":";
    private static final String GUI = MOD_PREFIX + "textures/gui/";
    private static final String GUI_ICONS = GUI + "icons/";
    private static final String GUI_SCALEBAR = GUI + "scalebar/";
    private static final String SCREEN = GUI + "screens/";

    public static final Map<ResourceLocation, ITexture> TILE_TEXTURES_MAP  = new HashMap<>();
    public static final ResourceLocation EXPORTED_BG = new ResourceLocation(GUI + "exported_bg.png");

    public static final ITexture
            PIPBOY_SCREEN = screen("pipboy_screen.png", 327, 207), //327, 207,
            PIPBOY_FRAME = dynamicScreen("default_pipboy.png", 327, 207), //327, 207,
            PIPBOY_FRAME_NARROW = dynamicScreen("default_pipboy.png", 310, 218),
            BTN_ARROWS = gui("navigate_arrows.png", 24, 24),
            BTN_POSITION = gui("position.png", 24, 24),
            BOOKMARKS = gui("bookmarks.png", 84, 36),
            BOOKMARKS_LEFT = gui("bookmarks_l.png", 84, 36),
            PLAYER = gui("player.png", 7, 8),
            SCROLLBAR_HOR = pipboyGui("scrollbar_hor.png", 8, 7),
            SCROLLBAR_VER = pipboyGui("scrollbar_ver.png", 7,8),
            MARKER_FRAME_ON = gui("marker_frame_on.png", 34, 34),
            MARKER_FRAME_OFF = gui("marker_frame_off.png", 34, 34),
            ERASER = gui("eraser.png", 24, 24),
            EXIT = gui("pipboy_btn.png", 28, 14),

            SCALEBAR_4 = scaleBar("scalebar_4.png"),
            SCALEBAR_8 = scaleBar("scalebar_8.png"),
            SCALEBAR_16 = scaleBar("scalebar_16.png"),
            SCALEBAR_32 = scaleBar("scalebar_32.png"),
            SCALEBAR_64 = scaleBar("scalebar_64.png"),
            SCALEBAR_128 = scaleBar("scalebar_128.png"),
            SCALEBAR_256 = scaleBar("scalebar_256.png"),
            SCALEBAR_512 = scaleBar("scalebar_512.png"),

            ICON_ADD_MARKER = icon("add_marker.png"),
            ICON_DELETE_MARKER = icon("del_marker.png"),
            ICON_SHOW_MARKERS = icon("show_markers.png"),
            ICON_HIDE_MARKERS = icon("hide_markers.png"),
            ICON_EXPORT = icon("export.png");

    // Constructor helpers:
    private static ITexture screen(String fileName, int width, int height) {
        return new Texture(new ResourceLocation(SCREEN + fileName), width, height);
    }

    private static ITexture dynamicScreen(String fileName, int width, int height) {
        return new DynamicTexture(new ResourceLocation(SCREEN + fileName), width, height){
            @Override
            public ResourceLocation getTexture() {
                var player = Minecraft.getInstance().player;
                if(player != null && player.getOffhandItem().getItem() instanceof PipBoyItem pipBoyItem) {
                    return getPipboyFrame(pipBoyItem);
                }
                return new ResourceLocation(SCREEN + fileName);
            }
        };
    }

    private static ITexture gui(String fileName, int width, int height) {
        return new Texture(new ResourceLocation(GUI + fileName), width, height);
    }

    private static ITexture pipboyGui(String fileName, int width, int height) {
        return new Texture(new ResourceLocation(GUI + fileName), width, height, true);
    }

    private static ITexture scaleBar(String fileName) {
        return new Texture(new ResourceLocation(GUI_SCALEBAR + fileName), 102, 19);
    }

    private static ITexture icon(String fileName) {
        return new IconTexture(new ResourceLocation(GUI_ICONS + fileName));
    }
}
