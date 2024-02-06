package com.nukateam.guns.common.network.message;

import com.nukateam.guns.common.base.network.ServerPlayHandler;
import com.mrcrayfish.framework.api.network.PlayMessage;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class MessageShoot extends PlayMessage<MessageShoot> {
    private int shooterId;
    private float rotationYaw;
    private float rotationPitch;
    private float randP;
    private float randY;
    private boolean isMainHand;

    public MessageShoot() {}

    public MessageShoot(int shooterId, float yaw, float pitch, float randP, float randY, boolean isMainHand) {
        this.shooterId = shooterId;
        this.rotationPitch = pitch;
        this.rotationYaw = yaw;
        this.randP = randP;
        this.randY = randY;
        this.isMainHand = isMainHand;
    }

    @Override
    public void encode(MessageShoot messageShoot, FriendlyByteBuf buffer) {
        buffer.writeInt(messageShoot.shooterId);
        buffer.writeFloat(messageShoot.rotationYaw);
        buffer.writeFloat(messageShoot.rotationPitch);
        buffer.writeFloat(messageShoot.randP);
        buffer.writeFloat(messageShoot.randY);
        buffer.writeBoolean(messageShoot.isMainHand);
    }

    @Override
    public MessageShoot decode(FriendlyByteBuf buffer) {
        return new MessageShoot(
                buffer.readInt(),
                buffer.readFloat(),
                buffer.readFloat(),
                buffer.readFloat(),
                buffer.readFloat(),
                buffer.readBoolean());
    }

    @Override
    public void handle(MessageShoot messageShoot, Supplier<NetworkEvent.Context> supplier) {
        supplier.get().enqueueWork(() -> {
            var player = supplier.get().getSender();
            if (player != null) {
                var shooter = player.level.getEntity(messageShoot.shooterId);

                if (shooter instanceof LivingEntity livingEntity)
                    ServerPlayHandler.handleShoot(messageShoot, livingEntity);
            }
        });
        supplier.get().setPacketHandled(true);
    }

    public boolean isMainHand() {
        return isMainHand;
    }

    public float getRotationYaw() {
        return this.rotationYaw;
    }

    public float getRotationPitch() {
        return this.rotationPitch;
    }
}