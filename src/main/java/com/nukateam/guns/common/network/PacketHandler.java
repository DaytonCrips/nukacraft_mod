package com.nukateam.guns.common.network;

import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
//    private static SimpleChannel PLAY_CHANNEL;

    public static SimpleChannel getPlayChannel() {
        return com.nukateam.nukacraft.common.network.PacketHandler.getPlayChannel();
    }

    public static void init() {
//        PLAY_CHANNEL = FrameworkChannelBuilder
//            .create(NukaCraftMod.MOD_ID, "play", 1)
//                .registerPlayMessage(C2SMessageAim.class, NetworkDirection.PLAY_TO_SERVER)
//                .registerPlayMessage(C2SMessageReload.class, NetworkDirection.PLAY_TO_SERVER)
//                .registerPlayMessage(MessageShoot.class, NetworkDirection.PLAY_TO_SERVER)
//                .registerPlayMessage(C2SMessageUnload.class, NetworkDirection.PLAY_TO_SERVER)
//                .registerPlayMessage(S2CMessageStunGrenade.class, NetworkDirection.PLAY_TO_CLIENT)
//                .registerPlayMessage(C2SMessageCraft.class, NetworkDirection.PLAY_TO_SERVER)
//                .registerPlayMessage(MessageBulletTrail.class, NetworkDirection.PLAY_TO_CLIENT)
//                .registerPlayMessage(C2SMessageAttachments.class, NetworkDirection.PLAY_TO_SERVER)
//                .registerPlayMessage(S2CMessageUpdateGuns.class, NetworkDirection.PLAY_TO_CLIENT)
//                .registerPlayMessage(S2CMessageBlood.class, NetworkDirection.PLAY_TO_CLIENT)
//                .registerPlayMessage(MessageShooting.class, NetworkDirection.PLAY_TO_SERVER)
//                .registerPlayMessage(MessageGunSound.class, NetworkDirection.PLAY_TO_CLIENT)
//                .registerPlayMessage(S2CMessageProjectileHitBlock.class, NetworkDirection.PLAY_TO_CLIENT)
//                .registerPlayMessage(S2CMessageProjectileHitEntity.class, NetworkDirection.PLAY_TO_CLIENT)
//                .registerPlayMessage(S2CMessageRemoveProjectile.class, NetworkDirection.PLAY_TO_CLIENT)
//                .registerPlayMessage(MessageUpdateMoveInacc.class, NetworkDirection.PLAY_TO_SERVER)
//                .build();
//
//        FrameworkAPI.registerLoginData(new ResourceLocation(NukaCraftMod.MOD_ID, "network_gun_manager"), NetworkGunManager.LoginData::new);
//        FrameworkAPI.registerLoginData(new ResourceLocation(NukaCraftMod.MOD_ID, "custom_gun_manager"), CustomGunManager.LoginData::new);
    }
}
