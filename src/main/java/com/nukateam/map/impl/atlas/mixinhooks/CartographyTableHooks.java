package com.nukateam.map.impl.atlas.mixinhooks;

import com.nukateam.map.api.AtlasAPI;
import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.item.AtlasItem;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

public class CartographyTableHooks {
    public static void onTakeItem(Player player, ItemStack map, ItemStack atlas) {
        if (player.getCommandSenderWorld().isClientSide()) {
            return;
        }

        if (map.getItem() == Items.FILLED_MAP) {
            MapItemSavedData mapState = MapItem.getSavedData(MapItem.getMapId(map), player.getCommandSenderWorld());
            if (mapState != null) {
                mapState.getDecorations().forEach(icon -> {
                    int i = 1 << mapState.scale;

                    int x = (int) ((int) (icon.getX() - 0.5f) / 2f) * i + mapState.x;
                    int z = (int) ((int) (icon.getY() - 0.5f) / 2f) * i + mapState.z;

                    ResourceLocation type = null;
                    Component label = null;

                    if (icon.getType() == MapDecoration.Type.RED_X) {
                        type = MapCore.id("red_x_small");
                        label = new TranslatableComponent("gui.nukacraft.marker.treasure");
                    } else if (icon.getType() == MapDecoration.Type.MONUMENT) {
                        type = MapCore.id("monument");
                        label = new TranslatableComponent("gui.nukacraft.marker.monument");
                    } else if (icon.getType() == MapDecoration.Type.MANSION) {
                        type = MapCore.id("mansion");
                        label = new TranslatableComponent("gui.nukacraft.marker.mansion");
                    }

                    if (type != null) {
                        AtlasAPI.getMarkerAPI().putMarker(player.getCommandSenderWorld(), true, AtlasItem.getAtlasID(atlas), type, label, x, z);
                    }
                });
            }
        }
    }
}
