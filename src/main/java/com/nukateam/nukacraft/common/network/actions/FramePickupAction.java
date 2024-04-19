package com.nukateam.nukacraft.common.network.actions;

import com.jetug.chassis_core.common.network.actions.Action;
import com.nukateam.nukacraft.common.foundation.entities.misc.PowerArmorFrame;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import static com.jetug.chassis_core.common.util.helpers.EntityHelper.entityToItem;
import static com.nukateam.nukacraft.common.registery.items.PowerArmorItems.FRAME_ITEM;

@SuppressWarnings("ConstantConditions")
public class FramePickupAction extends Action<FramePickupAction> {
    public FramePickupAction() {
    }

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
        var entity = player.level().getEntity(entityId);

        if (entity instanceof PowerArmorFrame frame) {
            player.stopRiding();
            var stack = new ItemStack(FRAME_ITEM.get());
            entityToItem(stack, frame);
            player.getInventory().add(stack);
        }
    }
}
