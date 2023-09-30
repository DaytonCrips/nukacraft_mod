package com.dayton.nukacraft.common.network;

import com.dayton.nukacraft.common.network.packets.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraftforge.common.util.*;
import net.minecraftforge.network.*;
import net.minecraftforge.network.simple.*;
import net.minecraftforge.server.*;

import java.util.List;

import static com.dayton.nukacraft.NukaCraftMod.MOD_ID;

public class PacketHandler {
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
									.named(new ResourceLocation(MOD_ID, "network"))
									.clientAcceptedVersions(PROTOCOL_VERSION::equals)
									.serverAcceptedVersions(PROTOCOL_VERSION::equals)
									.networkProtocolVersion(() -> PROTOCOL_VERSION)
									.simpleChannel();
	private static int disc = 0;

	public static void register() {
		HANDLER.registerMessage(disc++, MobPacket.class	   , MobPacket::write	 , MobPacket::read	 , MobPacket::handle);
		HANDLER.registerMessage(disc++, FramePickupPacket.class, FramePickupPacket::write, FramePickupPacket::read, FramePickupPacket::handle);

	}

	public static void sendToServer(Object msg) {
		HANDLER.sendToServer(msg);
	}

	public static void sendTo(Object msg, ServerPlayer player) {
		if(!(player instanceof FakePlayer)) {
			HANDLER.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
		}
	}

	public static void sendToAllPlayers(Object msg) {
		var server = ServerLifecycleHooks.getCurrentServer();
		List<ServerPlayer> list = server.getPlayerList().getPlayers();
		for(ServerPlayer e : list) {
			sendTo(msg, e);
		}
	}
}
