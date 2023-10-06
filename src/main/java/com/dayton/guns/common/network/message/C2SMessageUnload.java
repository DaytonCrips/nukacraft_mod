package com.dayton.guns.common.network.message;

import com.dayton.guns.common.base.network.ServerPlayHandler;
import com.mrcrayfish.framework.api.network.PlayMessage;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class C2SMessageUnload extends PlayMessage<C2SMessageUnload>
{
    @Override
    public void encode(C2SMessageUnload message, FriendlyByteBuf buffer) {}

    @Override
    public C2SMessageUnload decode(FriendlyByteBuf buffer)
    {
        return new C2SMessageUnload();
    }

    @Override
    public void handle(C2SMessageUnload message, Supplier<NetworkEvent.Context> supplier)
    {
        supplier.get().enqueueWork(() ->
        {
            ServerPlayer player = supplier.get().getSender();
            if(player != null && !player.isSpectator())
            {
                ServerPlayHandler.handleUnload(player);
            }
        });
        supplier.get().setPacketHandled(true);
    }
}
