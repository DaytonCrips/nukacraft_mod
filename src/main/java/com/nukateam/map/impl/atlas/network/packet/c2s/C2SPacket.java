package com.nukateam.map.impl.atlas.network.packet.c2s;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.network.packet.AntiqueAtlasPacket;

public abstract class C2SPacket extends AntiqueAtlasPacket {
    public void send() {
        MapCore.MOD_CHANNEL.sendToServer(this);
    }
}
