package com.nukateam.map.impl.atlas.mixinhooks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;

import java.util.function.Consumer;

@FunctionalInterface
public interface NewServerConnectionCallback {
	public class TheEvent extends Event {
	    private final boolean isRemote;
		
		public TheEvent(boolean isRemote) {
			this.isRemote = isRemote;
		}
		
		public boolean isRemote() {
			return isRemote;
		}
	}
	
	void onNewConnection(boolean isRemote);
	
	public static void register(Consumer<Boolean> isRemote) {
		MinecraftForge.EVENT_BUS.addListener((Consumer<TheEvent>) event->isRemote.accept(event.isRemote()));
	}
}
