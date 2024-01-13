package com.nukateam.map.impl.atlas.structure;

import com.nukateam.map.impl.atlas.MapCore;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.levelgen.feature.StructureFeature;

public class EndCity {

    public static void registerMarkers() {
        StructureHandler.registerMarker(StructureFeature.END_CITY, MapCore.id("end_city"), new TextComponent(""));
    }

}
