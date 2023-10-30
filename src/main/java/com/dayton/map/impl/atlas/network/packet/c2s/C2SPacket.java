package com.dayton.map.impl.atlas.network.packet.c2s;

import com.dayton.map.impl.atlas.AntiqueAtlasMod;
import com.dayton.map.impl.atlas.network.packet.AntiqueAtlasPacket;

public abstract class C2SPacket extends AntiqueAtlasPacket {
	public void send() {
		AntiqueAtlasMod.MOD_CHANNEL.sendToServer(this);
	}
}
