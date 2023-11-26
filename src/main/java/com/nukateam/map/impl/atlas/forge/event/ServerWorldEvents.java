package com.nukateam.map.impl.atlas.forge.event;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent.Load;

import java.util.function.Consumer;

public interface ServerWorldEvents {

	void onWorldLoad(MinecraftServer server, ServerLevel world);
	
	public static void register(ServerWorldEvents consumer) {
		MinecraftForge.EVENT_BUS.addListener((Consumer<Load>)event->{if (event.getWorld() instanceof ServerLevel)consumer.onWorldLoad(((ServerLevel)event.getWorld()).getServer(), (ServerLevel)event.getWorld());});
	}
}
