package com.nukateam.nukacraft.common.network.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import static com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem.openPipboyScreen;

public class PipboyScreenPacket {
    public PipboyScreenPacket() {
    }

    public static void write(PipboyScreenPacket message, FriendlyByteBuf buffer) {
    }

    public static PipboyScreenPacket read(FriendlyByteBuf buffer) {
        return new PipboyScreenPacket();
    }

    public static void handle(PipboyScreenPacket message, Supplier<NetworkEvent.Context> context) {
        var sender = context.get().getSender();
        if (sender == null) return;
        openPipboyScreen(sender);
    }
}