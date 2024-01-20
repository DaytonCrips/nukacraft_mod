package com.nukateam.nukacraft.common.network.packets;

import com.mrcrayfish.framework.api.network.PlayMessage;
import com.nukateam.nukacraft.common.foundation.entities.Deathclaw;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@SuppressWarnings("ALL")
public class S2CMobPacket extends PlayMessage<S2CMobPacket> {
    int entityId = -1;
    boolean isRunning = false;

    public S2CMobPacket(int entityId, boolean isRunning) {
        this.entityId = entityId;
        this.isRunning = isRunning;
    }

    public S2CMobPacket() {}

    @Override
    public void encode(S2CMobPacket message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.entityId);
        buffer.writeBoolean(message.isRunning);
    }

    @Override
    public S2CMobPacket decode(FriendlyByteBuf buffer) {
        var entityId = buffer.readInt();
        var isRunning = buffer.readBoolean();
        return new S2CMobPacket(entityId, isRunning);
    }

    public void handle(S2CMobPacket message, Supplier<NetworkEvent.Context> context) {
        boolean isClientSide = context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT;
        if(isClientSide){
            ((Deathclaw)Minecraft.getInstance().level.getEntity(message.entityId)).setIsRunning(message.isRunning);
        }else{}
    }
}