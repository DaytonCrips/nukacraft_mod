package com.nukateam.nukacraft.common.network;

import com.nukateam.nukacraft.common.network.packets.C2SPipboyScreenPacket;

import static com.nukateam.nukacraft.common.network.PacketHandler.sendToServer;

public class PacketSender {
    public static void openPipboyScreen(){
        sendToServer(new C2SPipboyScreenPacket());
    }
}
