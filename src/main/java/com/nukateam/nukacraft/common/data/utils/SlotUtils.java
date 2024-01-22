package com.nukateam.nukacraft.common.data.utils;

import com.mrcrayfish.backpacked.integration.Curios;
import com.nukateam.nukacraft.NukaCraftMod;
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

    public static ItemStack getPipboyStack(Player player) {
        var pipboy = new AtomicReference<>(ItemStack.EMPTY);
        pipboy.set(player.getOffhandItem());
        if (NukaCraftMod.isCuriosLoaded()) {
            pipboy.set(getBraceletStack(player));
        }

        return pipboy.get();
    }

}
