package com.nukateam.map.impl.atlas;

import com.nukateam.map.impl.atlas.client.gui.GuiAtlas;

public class AntiqueAtlasConfig {
    public boolean doSaveBrowsingPos = true;

    public boolean autoDeathMarker = true;

    public boolean autoVillageMarkers = true;

    public boolean autoNetherPortalMarkers = true;

    public boolean itemNeeded = true;

    public boolean doScaleMarkers = false;

    public double defaultScale = 0.5f;

    public double minScale = 1.0 / 32.0;

    public double maxScale = 4;

    public boolean doReverseWheelZoom = false;

    public int scanRadius = 11;

    public boolean forceChunkLoading = false;

    public float newScanInterval = 1f;

    public boolean doRescan = true;

    public int rescanRate = 4;

    public int markerLimit = 1024;

    public boolean doScanPonds = true;

    public boolean doScanRavines = true;

    public boolean debugRender = false;

    public int tileSize = 8;

    public int markerSize = GuiAtlas.MARKER_SIZE / 2;

    public int playerIconWidth = 14;

    public int playerIconHeight = 16;
}
