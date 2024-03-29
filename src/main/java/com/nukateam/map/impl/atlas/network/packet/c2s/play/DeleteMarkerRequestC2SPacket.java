package com.nukateam.map.impl.atlas.network.packet.c2s.play;

import com.nukateam.map.api.AtlasAPI;
import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.network.packet.c2s.C2SPacket;
import com.nukateam.map.impl.atlas.util.Log;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;


/**
 * Deletes a marker. A client sends this packet to the server as a request,
 * and the server sends an  to all players as a response, including the
 * original sender.
 * @author Hunternif
 */
public class DeleteMarkerRequestC2SPacket extends C2SPacket {
	public static final ResourceLocation ID = MapCore.id("packet", "c2s", "marker", "delete");

	private static final int GLOBAL = -1;

	int atlasID, markerID;
	
	public DeleteMarkerRequestC2SPacket(int atlasID, int markerID) {
		this.atlasID = atlasID;
		this.markerID = markerID;
	}

	public static void encode(final DeleteMarkerRequestC2SPacket msg, final FriendlyByteBuf packetBuffer) {
		packetBuffer.writeVarInt(msg.atlasID);
		packetBuffer.writeVarInt(msg.markerID);
	}

	public static DeleteMarkerRequestC2SPacket decode(final FriendlyByteBuf packetBuffer) {
		return new DeleteMarkerRequestC2SPacket(
				packetBuffer.readVarInt(),
				packetBuffer.readVarInt());
	}

	public static void handle(final DeleteMarkerRequestC2SPacket msg, final Supplier<NetworkEvent.Context> contextSupplier) {
		final NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			final ServerPlayer sender = context.getSender();
			if (sender == null) {
				return;
			}
			if (MapCore.CONFIG.itemNeeded && !AtlasAPI.getPlayerAtlases(sender).contains(msg.atlasID)) {
				Log.warn("Player %s attempted to delete marker from someone else's Atlas #%d",
						sender.getName(), msg.atlasID);
				return;
			}

			AtlasAPI.getMarkerAPI().deleteMarker(sender.getCommandSenderWorld(), msg.atlasID, msg.markerID);
		});
		context.setPacketHandled(true);
	}

	@Override
	public ResourceLocation getId() {
		return ID;
	}
}
