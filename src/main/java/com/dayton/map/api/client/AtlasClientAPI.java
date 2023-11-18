package com.dayton.map.api.client;

import com.dayton.map.api.MarkerAPI;
import com.dayton.map.impl.atlas.api.client.impl.MarkerApiImplClient;
import com.dayton.map.impl.atlas.api.client.impl.TileApiImplClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Use this class to obtain a reference to the client-side APIs.
 *
 * @author Hunternif
 */
@OnlyIn(Dist.CLIENT)
public class AtlasClientAPI {
    private static final int VERSION = 5;
    private static final ClientTileAPI tiles = new TileApiImplClient();
    private static final MarkerAPI markers = new MarkerApiImplClient();

    /**
     * Version of the API, meaning only this particular class. You might
     * want to check static field VERSION in the specific API interfaces.
     */
    public static int getVersion() {
        return VERSION;
    }

    /**
     * API for biomes and custom tiles (i.e. dungeons, towns etc).
     */
    public static ClientTileAPI getTileAPI() {
        return tiles;
    }

    /**
     * API for custom markers.
     */
    public static MarkerAPI getMarkerAPI() {
        return markers;
    }
}
