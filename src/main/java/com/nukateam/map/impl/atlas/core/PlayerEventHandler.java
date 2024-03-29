package com.nukateam.map.impl.atlas.core;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.marker.MarkersData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class PlayerEventHandler {
    public static void onPlayerLogin(ServerPlayer player) {
        Level world = player.level;
        int atlasID = player.getUUID().hashCode();

        AtlasData data = MapCore.tileData.getData(atlasID, world);
        // On the player join send the map from the server to the client:
        if (!data.isEmpty()) {
            data.syncOnPlayer(atlasID, player);
        }

        // Same thing with the local markers:
        MarkersData markers = MapCore.markersData.getMarkersData(atlasID, world);
        if (!markers.isEmpty()) {
            markers.syncOnPlayer(atlasID, player);
        }
    }

    public static void onPlayerTick(Player player) {
        if (!MapCore.CONFIG.itemNeeded) {
        	// TODO Can we move world scanning to the server in this case as well?
            AtlasData data = MapCore.tileData.getData(
                    player.getUUID().hashCode(), player.level);

            MapCore.worldScanner.updateAtlasAroundPlayer(data, player);
        }
    }
}
