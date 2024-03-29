package com.nukateam.map.impl.atlas.network.packet.s2c;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.network.packet.AntiqueAtlasPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public abstract class S2CPacket extends AntiqueAtlasPacket {
	@SuppressWarnings("deprecation")
	public void message(final Supplier<NetworkEvent.Context> contextSupplier) {
		final NetworkEvent.Context context = contextSupplier.get();
		if (shouldRun()) {
			context.enqueueWork(() -> DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
				context.setPacketHandled(handle(Minecraft.getInstance().player));
			}));
		}
	}

	public boolean shouldRun() {
		return true;
	}

	@OnlyIn(Dist.CLIENT)
	public abstract boolean handle(LocalPlayer player);
	
	public void send(ServerPlayer playerEntity) {
		MapCore.MOD_CHANNEL.sendTo(this, playerEntity.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
	}

	public void send(ServerLevel world) {
		for (ServerPlayer playerEntity : world.players()) {
			send(playerEntity);
		}
	}

	public void send(MinecraftServer server) {
		for (ServerPlayer playerEntity : server.getPlayerList().getPlayers()) {
			send(playerEntity);
		}
	}
}
