package com.nukateam.map.impl.atlas.network.packet.c2s;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.network.packet.AntiqueAtlasPacket;

public abstract class C2SPacket<T> extends AntiqueAtlasPacket<T> {
	public void send() {
		com.nukateam.nukacraft.common.network.PacketHandler.getPlayChannel().sendToServer(this);
	}

	public C2SPacket() {}
}
