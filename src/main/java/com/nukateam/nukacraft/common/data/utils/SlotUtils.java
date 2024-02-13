package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.concurrent.atomic.AtomicReference;

public class SlotUtils {
    public static ItemStack getCuriosStack(Player player, String slotId) {
        var slot = new AtomicReference<>(ItemStack.EMPTY);
        var optional = CuriosApi.getCuriosHelper().getCuriosHandler(player);
        optional.ifPresent((itemHandler) -> {
            var stacksOptional = itemHandler.getStacksHandler(slotId);
            stacksOptional.ifPresent((stacksHandler) -> {
                var stack = stacksHandler.getStacks().getStackInSlot(0);
                if (!stack.isEmpty()) {
                    slot.set(stack);
                }
            });
        });
        return slot.get();
    }

    public static ItemStack getBraceletStack(Player player) {
        return getCuriosStack(player, SlotTypePreset.BRACELET.getIdentifier());
    }

    public static boolean hasCuriosPipboy(Player player) {
        if (NukaCraftMod.isCuriosLoaded()) {
            var bracelet = getBraceletStack(player);
            return bracelet.getItem() instanceof PipBoyItem;
        }

        return false;
    }

    public static ItemStack getCuriosPipboy(Player player){
        var stack = ItemStack.EMPTY;
        if (NukaCraftMod.isCuriosLoaded()) {
            var bracelet = getBraceletStack(player);
            if(!bracelet.isEmpty())
                stack = bracelet;
        }

        return stack;
    }
}
