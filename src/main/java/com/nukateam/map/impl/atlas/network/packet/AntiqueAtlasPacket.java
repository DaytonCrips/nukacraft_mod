package com.nukateam.map.impl.atlas.network.packet;

import com.mrcrayfish.framework.api.network.PlayMessage;
import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public abstract class AntiqueAtlasPacket<T> extends PlayMessage<T> {
//	public AntiqueAtlasPacket() {
//		super(Unpooled.buffer());
//	}

	public abstract ResourceLocation getId();
}
