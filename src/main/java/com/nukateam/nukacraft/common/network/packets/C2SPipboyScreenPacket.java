package com.nukateam.nukacraft.common.network.packets;

import com.mrcrayfish.framework.api.network.PlayMessage;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import static com.nukateam.nukacraft.common.foundation.items.custom.PipBoyItem.openPipboyScreen;

@SuppressWarnings("ALL")
public class C2SPipboyScreenPacket extends PlayMessage<C2SPipboyScreenPacket> {
    @Override
    public void encode(C2SPipboyScreenPacket message, FriendlyByteBuf buffer) {}

    @Override
    public C2SPipboyScreenPacket decode(FriendlyByteBuf buffer) {
        return new C2SPipboyScreenPacket();
    }

    @Override
    public void handle(C2SPipboyScreenPacket message, Supplier<NetworkEvent.Context> context) {
        var sender = context.get().getSender();
        if (sender == null) return;
        openPipboyScreen(sender);
    }
}