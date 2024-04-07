package com.nukateam.nukacraft.common.network.packets;

import com.nukateam.nukacraft.common.foundation.entities.mobs.Deathclaw;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@SuppressWarnings("ALL")
public class MobPacket {
    int entityId = -1;
    boolean isRunning = false;

    public MobPacket(int entityId, boolean isRunning) {
        this.entityId = entityId;
        this.isRunning = isRunning;
    }

    public MobPacket() {
    }

    public static void write(MobPacket message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.entityId);
        buffer.writeBoolean(message.isRunning);
    }

    public static MobPacket read(FriendlyByteBuf buffer) {
        var entityId = buffer.readInt();
        var isRunning = buffer.readBoolean();
        return new MobPacket(entityId, isRunning);
    }

    public static void handle(MobPacket message, Supplier<NetworkEvent.Context> context) {
        boolean isClientSide = context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT;
        if (isClientSide) {
            ((Deathclaw) Minecraft.getInstance().level.getEntity(message.entityId)).setIsRunning(message.isRunning);
        } else {
        }
    }
}