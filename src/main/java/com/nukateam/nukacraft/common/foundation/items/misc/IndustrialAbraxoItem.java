package com.nukateam.nukacraft.common.foundation.items.misc;

import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.nukateam.nukacraft.common.foundation.items.frame.ArmorPart;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public class IndustrialAbraxoItem extends Item {
    public IndustrialAbraxoItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack pStack, Slot pSlot, ClickAction pAction, Player pPlayer) {
        if (pAction == ClickAction.SECONDARY) {
            ItemStack slotItem = pSlot.getItem();
            if (slotItem.getItem() instanceof ArmorPart && !(Objects.equals(StackUtils.getVariant(slotItem), "clear"))) {
                StackUtils.setVariant(slotItem, "clear");
                pStack.shrink(1);
                return true;
            }
        }
        return false;
    }

}
