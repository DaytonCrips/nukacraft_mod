package com.dayton.map.api.client;

import com.dayton.map.api.TileAPI;
import com.dayton.map.impl.atlas.client.TileRenderIterator;
import com.dayton.map.impl.atlas.util.Rect;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface ClientTileAPI extends TileAPI {
    TileRenderIterator getTiles(Level world, int atlasID, Rect scope, int step);
}