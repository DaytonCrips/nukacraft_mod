package com.nukateam.nukacraft.common.network.packets;

import com.nukateam.nukacraft.common.foundation.entities.Deathclaw;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import static com.nukateam.nukacraft.common.foundation.items.custom.PipBoyItem.openPipboyScreen;

@SuppressWarnings("ALL")
public class PipboyScreenPacket {
    public static void write(PipboyScreenPacket message, FriendlyByteBuf buffer) {}

    public static PipboyScreenPacket read(FriendlyByteBuf buffer) {
        return new PipboyScreenPacket();
    }

    public static void handle(PipboyScreenPacket message, Supplier<NetworkEvent.Context> context) {
        boolean isClientSide = context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT;
        if(!isClientSide){
            var sender = context.get().getSender();
            if (sender == null) return;
            openPipboyScreen(sender);
        } else{}
    }
}