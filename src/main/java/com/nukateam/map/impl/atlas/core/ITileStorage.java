package com.nukateam.map.impl.atlas.core;

import com.nukateam.map.impl.atlas.util.Rect;
import net.minecraft.resources.ResourceLocation;

public interface ITileStorage {
    void setTile(int x, int y, ResourceLocation tile);

    /** Removes the tile set at the given coordinate
     * @return the Tile previously set at given coordinates.
     */
    ResourceLocation removeTile(int x, int y);

    /** Retrieves the tile set a given position
     *
     * @param x
     * @param y
     * @return either the tile stored for the coords or null
     */
    ResourceLocation getTile(int x, int y);

    boolean hasTileAt(int x, int y);

    Rect getScope();
}
