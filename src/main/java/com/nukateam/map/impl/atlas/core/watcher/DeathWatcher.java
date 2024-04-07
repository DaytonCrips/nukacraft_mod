package com.nukateam.map.impl.atlas.core.watcher;

import com.nukateam.map.api.AtlasAPI;
import com.nukateam.map.impl.atlas.MapCore;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

/**
 * Puts an skull marker to the player's death spot.
 *
 * @author Hunternif, Haven King
 */
public class DeathWatcher {
    public static void onPlayerDeath(Player player) {
        if (MapCore.CONFIG.autoDeathMarker) {
            for (int atlasID : AtlasAPI.getPlayerAtlases(player)) {
                AtlasAPI.getMarkerAPI().putMarker(player.getCommandSenderWorld(), true, atlasID, new ResourceLocation("nukacraft:tomb"),
                        Component.translatable("gui.nukacraft.marker.tomb", player.getName()),
                        (int) player.getX(), (int) player.getZ());
            }
        }
    }
}
