package com.nukateam.nukacraft.common.network.packets;

import com.mrcrayfish.framework.api.network.PlayMessage;
import com.nukateam.nukacraft.common.foundation.entities.PowerArmorFrame;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import static com.nukateam.nukacraft.common.foundation.items.PowerArmorItems.FRAME_ITEM;
import static com.jetug.chassis_core.common.util.helpers.EntityHelper.entityToItem;
import static net.minecraftforge.items.ItemHandlerHelper.giveItemToPlayer;

@SuppressWarnings("ALL")
public class C2SFramePickupPacket extends PlayMessage<C2SFramePickupPacket> {
    int entityId = -1;

    public C2SFramePickupPacket(int entityId) {
        this.entityId = entityId;
    }

    public C2SFramePickupPacket() {}

    @Override
    public void encode(C2SFramePickupPacket message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.entityId);
    }

    @Override
    public C2SFramePickupPacket decode(FriendlyByteBuf buffer) {
        var entityId = buffer.readInt();
        return new C2SFramePickupPacket(entityId);
    }

    @Override
    public void handle(C2SFramePickupPacket message, Supplier<NetworkEvent.Context> context) {
        boolean isClientSide = context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT;
        if(!isClientSide){
            var player = context.get().getSender();
            var entity = player.level.getEntity(message.entityId);

            if(entity instanceof PowerArmorFrame frame){
                player.stopRiding();
                var stack = new ItemStack(FRAME_ITEM.get());
                entityToItem(stack, frame);
                giveItemToPlayer(player, stack);
            }
        }
    }
}