package com.dayton.map.impl.atlas.core.watcher;

import com.dayton.map.api.AtlasAPI;
import com.dayton.map.impl.atlas.AntiqueAtlasMod;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

/**
 * Puts an skull marker to the player's death spot.
 *
 * @author Hunternif, Haven King
 */
public class DeathWatcher {
    public static void onPlayerDeath(Player player) {
        if (AntiqueAtlasMod.CONFIG.autoDeathMarker) {
            for (int atlasID : AtlasAPI.getPlayerAtlases(player)) {
                AtlasAPI.getMarkerAPI().putMarker(player.getCommandSenderWorld(), true, atlasID, new ResourceLocation("nukacraft:tomb"),
                        new TranslatableComponent("gui.nukacraft.marker.tomb", player.getName()),
                        (int) player.getX(), (int) player.getZ());
            }
        }
    }
}
