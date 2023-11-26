package com.nukateam.map.impl.atlas.mixinhooks;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;

import java.util.function.Consumer;

@FunctionalInterface
public interface NewPlayerConnectionCallback {
	public class TheEvent extends Event {
	    private final ServerPlayer player;
		
		public TheEvent(ServerPlayer player) {
			this.player = player;
		}
		
		public ServerPlayer getPlayer() {
			return player;
		}
	}
	
	void onNewConnection(ServerPlayer player);
	
	public static void register(NewPlayerConnectionCallback consumer) {
		MinecraftForge.EVENT_BUS.addListener((Consumer<TheEvent>)event->consumer.onNewConnection(event.getPlayer()));
	}
}
