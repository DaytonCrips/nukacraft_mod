package com.dayton.guns.common.network;

import com.dayton.guns.client.CustomGunManager;
import com.dayton.guns.common.base.NetworkGunManager;
import com.dayton.guns.common.network.message.*;
import com.dayton.nukacraft.NukaCraftMod;
import com.mrcrayfish.framework.api.FrameworkAPI;
import com.mrcrayfish.framework.api.network.FrameworkChannelBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
    private static SimpleChannel PLAY_CHANNEL;

    /**
     * Gets the play network channel for MrCrayfish's Gun Mod
     */
    public static SimpleChannel getPlayChannel() {
        return PLAY_CHANNEL;
    }

    public static void init() {
        PLAY_CHANNEL = FrameworkChannelBuilder
                .create(NukaCraftMod.MOD_ID, "play", 1)
                .registerPlayMessage(C2SMessageAim.class, NetworkDirection.PLAY_TO_SERVER)
                .registerPlayMessage(C2SMessageReload.class, NetworkDirection.PLAY_TO_SERVER)
                .registerPlayMessage(C2SMessageShoot.class, NetworkDirection.PLAY_TO_SERVER)
                .registerPlayMessage(C2SMessageUnload.class, NetworkDirection.PLAY_TO_SERVER)
                .registerPlayMessage(S2CMessageStunGrenade.class, NetworkDirection.PLAY_TO_CLIENT)
                .registerPlayMessage(C2SMessageCraft.class, NetworkDirection.PLAY_TO_SERVER)
                .registerPlayMessage(S2CMessageBulletTrail.class, NetworkDirection.PLAY_TO_CLIENT)
                .registerPlayMessage(C2SMessageAttachments.class, NetworkDirection.PLAY_TO_SERVER)
                .registerPlayMessage(S2CMessageUpdateGuns.class, NetworkDirection.PLAY_TO_CLIENT)
                .registerPlayMessage(S2CMessageBlood.class, NetworkDirection.PLAY_TO_CLIENT)
                .registerPlayMessage(C2SMessageShooting.class, NetworkDirection.PLAY_TO_SERVER)
                .registerPlayMessage(S2CMessageGunSound.class, NetworkDirection.PLAY_TO_CLIENT)
                .registerPlayMessage(S2CMessageProjectileHitBlock.class, NetworkDirection.PLAY_TO_CLIENT)
                .registerPlayMessage(S2CMessageProjectileHitEntity.class, NetworkDirection.PLAY_TO_CLIENT)
                .registerPlayMessage(S2CMessageRemoveProjectile.class, NetworkDirection.PLAY_TO_CLIENT)
                .build();

        FrameworkAPI.registerLoginData(new ResourceLocation(NukaCraftMod.MOD_ID, "network_gun_manager"), NetworkGunManager.LoginData::new);
        FrameworkAPI.registerLoginData(new ResourceLocation(NukaCraftMod.MOD_ID, "custom_gun_manager"), CustomGunManager.LoginData::new);
    }
}
