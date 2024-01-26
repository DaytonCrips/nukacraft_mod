package com.nukateam.guns.common.network.message;

import com.mrcrayfish.framework.api.network.PlayMessage;
import com.nukateam.guns.client.data.handler.ClientReloadHandler;
import com.nukateam.guns.common.foundation.init.ModSyncedDataKeys;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class S2CMessageReload extends PlayMessage<S2CMessageReload> {
    private boolean reload;
    private boolean isRightHand;

    public S2CMessageReload() {
    }

    public S2CMessageReload(boolean reload, HumanoidArm arm) {
        this.reload = reload;
        this.isRightHand = arm == HumanoidArm.RIGHT;
    }

    public S2CMessageReload(boolean reload, boolean isRightHand) {
        this.reload = reload;
        this.isRightHand = isRightHand;
    }

    @Override
    public void encode(S2CMessageReload message, FriendlyByteBuf buffer) {
        buffer.writeBoolean(message.reload);
        buffer.writeBoolean(message.isRightHand);
    }

    @Override
    public S2CMessageReload decode(FriendlyByteBuf buffer) {
        return new S2CMessageReload(buffer.readBoolean(), buffer.readBoolean());
    }

    @Override
    public void handle(S2CMessageReload message, Supplier<NetworkEvent.Context> supplier) {
        supplier.get().enqueueWork(() -> {
            var player = Minecraft.getInstance().player;
            if (player != null && !player.isSpectator()) {
                var arm = message.isRightHand ? HumanoidArm.RIGHT : HumanoidArm.LEFT;
                var dataKey = message.isRightHand ?
                        ModSyncedDataKeys.RELOADING_RIGHT : ModSyncedDataKeys.RELOADING_LEFT;

                ClientReloadHandler.get().setReloading(!dataKey.getValue(player), arm);
            }
        });
        supplier.get().setPacketHandled(true);
    }
}
