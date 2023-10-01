package com.dayton.nukacraft.common.network.actions;

import com.dayton.nukacraft.common.foundation.entities.PowerArmorFrame;
import com.jetug.chassis_core.common.network.actions.Action;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import static com.dayton.nukacraft.common.foundation.items.PowerArmorItems.FRAME_ITEM;
import static com.jetug.chassis_core.common.foundation.EntityHelper.entityToItem;

@SuppressWarnings("ConstantConditions")
public class FramePickupAction extends Action<FramePickupAction> {
    public FramePickupAction() {}

    @Override
    public void write(FriendlyByteBuf buffer) {
    }

    @Override
    public FramePickupAction read(FriendlyByteBuf buffer) {
        return new FramePickupAction();
    }

    @Override
    public void doServerAction(FramePickupAction message, Supplier<NetworkEvent.Context> context, int entityId) {
        var player = context.get().getSender();
        var entity = player.level.getEntity(entityId);

        if(entity instanceof PowerArmorFrame frame){
            player.stopRiding();
            var stack = new ItemStack(FRAME_ITEM.get());
            entityToItem(stack, frame);
            player.getInventory().add(stack);
        }
    }
}
