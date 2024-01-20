package com.nukateam.map.impl.atlas.network.packet.c2s;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.network.packet.AntiqueAtlasPacket;
import net.minecraftforge.network.NetworkDirection;

public abstract class C2SPacket<T> extends AntiqueAtlasPacket<T> {
	public void send() {
		try{
			com.nukateam.nukacraft.common.network.PacketHandler.getPlayChannel().sendToServer(this);
		}
		catch (Exception e){}
	}

	public C2SPacket() {}
}
