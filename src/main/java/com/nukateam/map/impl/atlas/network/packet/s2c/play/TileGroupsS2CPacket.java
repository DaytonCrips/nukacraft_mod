package com.nukateam.map.impl.atlas.network.packet.s2c.play;

import com.nukateam.map.impl.atlas.AntiqueAtlasMod;
import com.nukateam.map.impl.atlas.core.AtlasData;
import com.nukateam.map.impl.atlas.core.TileGroup;
import com.nukateam.map.impl.atlas.core.WorldData;
import com.nukateam.map.impl.atlas.network.packet.s2c.S2CPacket;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;


/**
 * Syncs tile groups to the client.
 * @author Hunternif
 * @author Haven King
 */
public class TileGroupsS2CPacket extends S2CPacket {
	public static final int TILE_GROUPS_PER_PACKET = 100;
	public static final ResourceLocation ID = AntiqueAtlasMod.id("packet", "s2c", "tile", "groups");

	int atlasID;
	ResourceKey<Level> world;
	List<TileGroup> tileGroups;

	public TileGroupsS2CPacket(int atlasID, ResourceKey<Level> world, List<TileGroup> tileGroups) {
		this.atlasID = atlasID;
		this.world = world;
		this.tileGroups = tileGroups;
	}

	public static void encode(final TileGroupsS2CPacket msg, final FriendlyByteBuf packetBuffer) {
		packetBuffer.writeVarInt(msg.atlasID);
		packetBuffer.writeResourceLocation(msg.world.location());
		packetBuffer.writeVarInt(msg.tileGroups.size());

		for (TileGroup tileGroup : msg.tileGroups) {
			packetBuffer.writeNbt(tileGroup.writeToNBT(new CompoundTag()));
		}
	}

	public static TileGroupsS2CPacket decode(final FriendlyByteBuf packetBuffer) {
		int atlasID = packetBuffer.readVarInt();
		ResourceKey<Level> world = ResourceKey.create(Registry.DIMENSION_REGISTRY, packetBuffer.readResourceLocation());
		int length = packetBuffer.readVarInt();
		List<TileGroup> tileGroups = new ArrayList<>(length);

		for (int i = 0; i < length; ++i) {
			CompoundTag tag = packetBuffer.readNbt();

			if (tag != null) {
				tileGroups.add(new TileGroup().readFromNBT(tag));
			}
		}

		return new TileGroupsS2CPacket(atlasID, world, tileGroups);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean handle(LocalPlayer player) {
		AtlasData atlasData = AntiqueAtlasMod.tileData.getData(atlasID, player.level);
		WorldData dimData = atlasData.getWorldData(world);
		for (TileGroup t : tileGroups) {
			dimData.putTileGroup(t);
		}
		return true;
	}

	@Override
	public ResourceLocation getId() {
		return ID;
	}
}
