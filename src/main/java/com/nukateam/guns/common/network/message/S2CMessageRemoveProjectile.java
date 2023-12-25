package com.nukateam.guns.common.network.message;

import com.nukateam.guns.client.ClientPlayHandler;
import com.mrcrayfish.framework.api.network.PlayMessage;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class S2CMessageRemoveProjectile extends PlayMessage<S2CMessageRemoveProjectile> {
    private int entityId;

    public S2CMessageRemoveProjectile() {
    }

    public S2CMessageRemoveProjectile(int entityId) {
        this.entityId = entityId;
    }

    @Override
    public void encode(S2CMessageRemoveProjectile message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.entityId);
    }

    @Override
    public S2CMessageRemoveProjectile decode(FriendlyByteBuf buffer) {
        return new S2CMessageRemoveProjectile(buffer.readInt());
    }

    @Override
    public void handle(S2CMessageRemoveProjectile message, Supplier<NetworkEvent.Context> supplier) {
        supplier.get().enqueueWork(() -> ClientPlayHandler.handleRemoveProjectile(message));
        supplier.get().setPacketHandled(true);
    }

    public int getEntityId() {
        return this.entityId;
    }
}
