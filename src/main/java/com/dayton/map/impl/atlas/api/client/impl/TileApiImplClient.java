package com.dayton.map.impl.atlas.api.client.impl;

import com.dayton.map.api.client.ClientTileAPI;
import com.dayton.map.impl.atlas.AntiqueAtlasMod;
import com.dayton.map.impl.atlas.client.TileRenderIterator;
import com.dayton.map.impl.atlas.core.AtlasData;
import com.dayton.map.impl.atlas.core.TileDataStorage;
import com.dayton.map.impl.atlas.network.packet.c2s.play.PutTileC2SPacket;
import com.dayton.map.impl.atlas.util.Log;
import com.dayton.map.impl.atlas.util.Rect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TileApiImplClient implements ClientTileAPI {
    @Override
    public void putTile(Level world, int atlasID, ResourceLocation tile, int chunkX, int chunkZ) {
        new PutTileC2SPacket(atlasID, chunkX, chunkZ, tile).send();
    }

    @Override
    public ResourceLocation getTile(Level world, int atlasID, int chunkX, int chunkZ) {
        AtlasData data = AntiqueAtlasMod.tileData.getData(atlasID, world);
        return data.getWorldData(world.dimension()).getTile(chunkX, chunkZ);
    }

    @Override
    public void putGlobalTile(Level world, ResourceLocation tile, int chunkX, int chunkZ) {
        Log.warn("Client attempted to put global tile");
    }

    @Override
    public ResourceLocation getGlobalTile(Level world, int chunkX, int chunkZ) {
        TileDataStorage data = AntiqueAtlasMod.globalTileData.getData(world);
        return data.getTile(chunkX, chunkZ);
    }

    @Override
    public void deleteGlobalTile(Level world, int chunkX, int chunkZ) {
        Log.warn("Client attempted to delete global tile");
    }

    @Override
    public TileRenderIterator getTiles(Level world, int atlasID, Rect scope, int step) {
        TileRenderIterator iter = new TileRenderIterator(AntiqueAtlasMod.tileData
                .getData(atlasID, world)
                .getWorldData(world.dimension()));
        iter.setScope(scope);
        iter.setStep(step);
        return iter;
    }
}
