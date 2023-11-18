package com.dayton.map.impl.atlas.client.gui;

import com.dayton.map.impl.atlas.client.gui.core.GuiBlinkingImage;
import com.dayton.map.impl.atlas.registry.MarkerType;

public class GuiBlinkingMarker extends GuiBlinkingImage implements GuiMarkerFinalizer.IMarkerTypeSelectListener {
    public void onSelectMarkerType(MarkerType markerType) {
        setTexture(markerType.getTexture(), GuiAtlas.MARKER_SIZE, GuiAtlas.MARKER_SIZE);
    }
}
