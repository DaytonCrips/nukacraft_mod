package com.nukateam.map.impl.atlas.network.packet.s2c.play;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.core.AtlasData;
import com.nukateam.map.impl.atlas.network.packet.s2c.S2CPacket;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Puts biome tile into one atlas.
 * @author Hunternif
 * @author Haven King
 */
public class PutTileS2CPacket extends S2CPacket {
	public static final ResourceLocation ID = MapCore.id("packet", "s2c", "tile", "put");

	int atlasID;
	ResourceKey<Level> world;
	int x, z;
	ResourceLocation tile;

	public PutTileS2CPacket(int atlasID, ResourceKey<Level> world, int x, int z, ResourceLocation tile) {

	}

	public static void encode(final PutTileS2CPacket msg, final FriendlyByteBuf packetBuffer) {
		packetBuffer.writeInt(msg.atlasID);
		packetBuffer.writeResourceLocation(msg.world.location());
		packetBuffer.writeVarInt(msg.x);
		packetBuffer.writeVarInt(msg.z);
		packetBuffer.writeResourceLocation(msg.tile);
	}

	public static PutTileS2CPacket decode(final FriendlyByteBuf packetBuffer) {
		int atlasID = packetBuffer.readVarInt();
		ResourceKey<Level> world = ResourceKey.create(Registry.DIMENSION_REGISTRY, packetBuffer.readResourceLocation());
		int x = packetBuffer.readVarInt();
		int z = packetBuffer.readVarInt();
		ResourceLocation tile = packetBuffer.readResourceLocation();

		return new PutTileS2CPacket(atlasID, world, x, z, tile);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean handle(LocalPlayer player) {
		AtlasData data = MapCore.tileData.getData(this.atlasID, player.getCommandSenderWorld());
		data.setTile(this.world, this.x, this.z, this.tile);
		return true;
	}

	@Override
	public ResourceLocation getId() {
		return ID;
	}
}
