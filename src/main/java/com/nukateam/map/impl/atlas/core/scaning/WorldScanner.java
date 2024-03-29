package com.nukateam.map.impl.atlas.core.scaning;

import com.nukateam.map.api.AtlasAPI;
import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.core.AtlasData;
import com.nukateam.map.impl.atlas.core.TileInfo;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkStatus;

import java.util.*;

public class WorldScanner {

    /**
     * Maps dimension ID to biomeAnalyzer.
     */
    private final Map<ResourceKey<Level>, ITileDetector> biomeAnalyzers = new HashMap<>();
    private final TileDetectorBase tileDetectorOverworld = new TileDetectorBase();

    public WorldScanner() {
        setBiomeDetectorForWorld(Level.OVERWORLD, tileDetectorOverworld);
        setBiomeDetectorForWorld(Level.NETHER, new TileDetectorNether());
        setBiomeDetectorForWorld(Level.END, new TileDetectorEnd());
    }


    /**
     * If not found, returns the analyzer for overworld.
     */
    private ITileDetector getBiomeDetectorForWorld(ResourceKey<Level> world) {
        ITileDetector biomeAnalyzer = biomeAnalyzers.get(world);

        return biomeAnalyzer == null ? tileDetectorOverworld : biomeAnalyzer;
    }

    private void setBiomeDetectorForWorld(ResourceKey<Level> world, ITileDetector biomeAnalyzer) {
        biomeAnalyzers.put(world, biomeAnalyzer);
    }

    /**
     * Updates map data around player
     *
     * @return A set of the new tiles, mostly so the server can sync those with relevant clients.
     */
    public Collection<TileInfo> updateAtlasAroundPlayer(AtlasData data, Player player) {
        // Update the actual map only so often:
        int newScanInterval = Math.round(MapCore.CONFIG.newScanInterval * 20);

        if (player.getCommandSenderWorld().getGameTime() % newScanInterval != 0) {
            return Collections.emptyList(); //no new tiles
        }

        ArrayList<TileInfo> updatedTiles = new ArrayList<>();

        int rescanInterval = newScanInterval * MapCore.CONFIG.rescanRate;
        boolean rescanRequired = MapCore.CONFIG.doRescan && player.getCommandSenderWorld().getGameTime() % rescanInterval == 0;

        ITileDetector biomeDetector = getBiomeDetectorForWorld(player.getCommandSenderWorld().dimension());

        int scanRadius = biomeDetector.getScanRadius();

        // Look at chunks around in a circular area:
        for (int dx = -scanRadius; dx <= scanRadius; dx++) {
            for (int dz = -scanRadius; dz <= scanRadius; dz++) {
                if (dx * dx + dz * dz > scanRadius * scanRadius) {
                    continue; // Outside the circle
                }

                int chunkX = player.chunkPosition().x + dx;
                int chunkZ = player.chunkPosition().z + dz;

                TileInfo update = updateAtlasForChunk(data, player.getCommandSenderWorld(), chunkX, chunkZ, rescanRequired);
                if (update != null) {
                    updatedTiles.add(update);
                }
            }
        }
        return updatedTiles;
    }

    private TileInfo updateAtlasForChunk(AtlasData data, Level world, int x, int z, boolean rescanRequired) {
        var storedData = data.getWorldData(world.dimension());
        var oldTile = storedData.getTile(x, z);

        // Check if there's a custom tile at the location:
        // Custom tiles overwrite even the chunks already seen.
        var tile = AtlasAPI.getTileAPI().getGlobalTile(world, x, z);

        // If there's no custom tile, check the actual chunk:
        if (tile == null) {
            // If the chunk has been scanned previously, only re-scan it so often:
            if (oldTile != null && !rescanRequired)
                return null;
            
            if(!world.getChunkSource().hasChunk(x,z))
                return null;

            // TODO FABRIC: forceChunkLoading crashes here
            var chunk = world.getChunk(x, z, ChunkStatus.FULL, MapCore.CONFIG.forceChunkLoading);

            // Skip chunk if it hasn't loaded yet:
            if (chunk == null) return null;

            var biomeDetector = getBiomeDetectorForWorld(world.dimension());
            tile = biomeDetector.getBiomeID(world, chunk);

            if (oldTile != null) {
                if (tile == null) {
                    // If the new tile is empty, remove the old one:
                    data.removeTile(world.dimension(), x, z);
                } else if (!oldTile.equals(tile)) {
                    // Only update if the old tile's biome ID doesn't match the new one:
                    data.setTile(world.dimension(), x, z, tile);
                    return new TileInfo(x, z, tile);
                }
            } else {
                // Scanning new chunk:
                if (tile != null) {
                    data.setTile(world.dimension(), x, z, tile);
                    return new TileInfo(x, z, tile);
                }
            }
        } else {
            // Only update the custom tile if it doesn't rewrite itself:
            if (oldTile == null || !oldTile.equals(tile)) {
                data.setTile(world.dimension(), x, z, tile);
                data.setDirty();
                return new TileInfo(x, z, tile);
            }
        }

        return null;
    }
}
