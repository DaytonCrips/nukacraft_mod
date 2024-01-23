package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.items.custom.PipBoyItem;
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

    public static ItemStack getPipboyStack(Player player) {
        var pipboy = new AtomicReference<>(ItemStack.EMPTY);
        pipboy.set(ItemStack.EMPTY);

        var offhand = player.getOffhandItem();
        if(offhand.getItem() instanceof PipBoyItem){
            pipboy.set(offhand);
        }

        if (NukaCraftMod.isCuriosLoaded()) {
            var bracelet = getBraceletStack(player);
            if(!bracelet.isEmpty())
                pipboy.set(bracelet);
        }

        return pipboy.get();
    }

}
