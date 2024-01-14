package com.nukateam.nukacraft.common.network;

import com.mrcrayfish.framework.api.FrameworkAPI;
import com.mrcrayfish.framework.api.network.FrameworkChannelBuilder;
import com.nukateam.guns.client.CustomGunManager;
import com.nukateam.guns.common.base.NetworkGunManager;
import com.nukateam.guns.common.network.message.*;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.network.packets.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.List;

import static com.nukateam.nukacraft.NukaCraftMod.MOD_ID;

public class PacketHandler {
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	private static SimpleChannel HANDLER;
//			= NetworkRegistry.ChannelBuilder
//									.named(new ResourceLocation(MOD_ID, "network"))
//									.clientAcceptedVersions(PROTOCOL_VERSION::equals)
//									.serverAcceptedVersions(PROTOCOL_VERSION::equals)
//									.networkProtocolVersion(() -> PROTOCOL_VERSION)
//									.simpleChannel();
//	private static int disc = 0;

//	public static void register() {
//		HANDLER.registerMessage(disc++, S2CMobPacket.class	        , S2CMobPacket::write	       , S2CMobPacket::read	     , S2CMobPacket::handle		 );
//		HANDLER.registerMessage(disc++, C2SFramePickupPacket.class , C2SFramePickupPacket::write , C2SFramePickupPacket::read , C2SFramePickupPacket::handle );
//		HANDLER.registerMessage(disc++, C2SPipboyScreenPacket.class, C2SPipboyScreenPacket::write, C2SPipboyScreenPacket::read, C2SPipboyScreenPacket::handle);
//	}

	public static SimpleChannel getPlayChannel() {
		return HANDLER;
	}

	public static void register() {
		HANDLER = FrameworkChannelBuilder
				.create(NukaCraftMod.MOD_ID, "play", 1)
				.registerPlayMessage(S2CMobPacket.class					, NetworkDirection.PLAY_TO_CLIENT)
				.registerPlayMessage(C2SFramePickupPacket.class			, NetworkDirection.PLAY_TO_SERVER)
				.registerPlayMessage(C2SPipboyScreenPacket.class		, NetworkDirection.PLAY_TO_SERVER)

				.registerPlayMessage(C2SMessageAim.class				, NetworkDirection.PLAY_TO_SERVER)
				.registerPlayMessage(C2SMessageReload.class				, NetworkDirection.PLAY_TO_SERVER)
				.registerPlayMessage(MessageShoot.class					, NetworkDirection.PLAY_TO_SERVER)
				.registerPlayMessage(C2SMessageUnload.class				, NetworkDirection.PLAY_TO_SERVER)
				.registerPlayMessage(S2CMessageStunGrenade.class		, NetworkDirection.PLAY_TO_CLIENT)
				.registerPlayMessage(C2SMessageCraft.class				, NetworkDirection.PLAY_TO_SERVER)
				.registerPlayMessage(MessageBulletTrail.class			, NetworkDirection.PLAY_TO_CLIENT)
				.registerPlayMessage(C2SMessageAttachments.class		, NetworkDirection.PLAY_TO_SERVER)
				.registerPlayMessage(S2CMessageUpdateGuns.class			, NetworkDirection.PLAY_TO_CLIENT)
				.registerPlayMessage(S2CMessageBlood.class				, NetworkDirection.PLAY_TO_CLIENT)
				.registerPlayMessage(MessageShooting.class				, NetworkDirection.PLAY_TO_SERVER)
				.registerPlayMessage(MessageGunSound.class				, NetworkDirection.PLAY_TO_CLIENT)
				.registerPlayMessage(S2CMessageProjectileHitBlock.class , NetworkDirection.PLAY_TO_CLIENT)
				.registerPlayMessage(S2CMessageProjectileHitEntity.class, NetworkDirection.PLAY_TO_CLIENT)
				.registerPlayMessage(S2CMessageRemoveProjectile.class	, NetworkDirection.PLAY_TO_CLIENT)
				.registerPlayMessage(MessageUpdateMoveInacc.class		, NetworkDirection.PLAY_TO_SERVER)
				.build();

		FrameworkAPI.registerLoginData(new ResourceLocation(NukaCraftMod.MOD_ID, "network_gun_manager"), NetworkGunManager.LoginData::new);
		FrameworkAPI.registerLoginData(new ResourceLocation(NukaCraftMod.MOD_ID, "custom_gun_manager"), CustomGunManager.LoginData::new);
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
