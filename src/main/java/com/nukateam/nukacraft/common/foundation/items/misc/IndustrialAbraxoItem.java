package com.nukateam.nukacraft.common.foundation.items.misc;

import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.nukacraft.NukaCraftMod;
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
        ItemStack slotItem = pSlot.getItem();
        boolean isPaintable = (slotItem.getItem() instanceof ArmorPart || slotItem.getItem() instanceof GunItem);
        if (pAction == ClickAction.SECONDARY) {
            if (isPaintable && !(Objects.equals(StackUtils.getVariant(slotItem), "clean"))) {
                StackUtils.setVariant(slotItem, "clean");
                pStack.shrink(1);
                return true;
            }
        }
        return false;
    }

}
