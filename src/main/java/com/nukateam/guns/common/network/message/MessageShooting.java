package com.nukateam.guns.common.network.message;

import com.nukateam.guns.common.foundation.init.ModSyncedDataKeys;
import com.mrcrayfish.framework.api.network.PlayMessage;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class MessageShooting extends PlayMessage<MessageShooting> {
    private boolean shooting;

    public MessageShooting() {}

    public MessageShooting(boolean shooting) {
        this.shooting = shooting;
    }

    @Override
    public void encode(MessageShooting message, FriendlyByteBuf buffer) {
        buffer.writeBoolean(message.shooting);
    }

    @Override
    public MessageShooting decode(FriendlyByteBuf buffer) {
        return new MessageShooting(buffer.readBoolean());
    }

    @Override
    public void handle(MessageShooting message, Supplier<NetworkEvent.Context> supplier) {
        supplier.get().enqueueWork(() -> {
            var player = supplier.get().getSender();
            if (player != null) {
                ModSyncedDataKeys.SHOOTING_RIGHT.setValue(player, message.shooting);
            }
        });
        supplier.get().setPacketHandled(true);
    }
}
