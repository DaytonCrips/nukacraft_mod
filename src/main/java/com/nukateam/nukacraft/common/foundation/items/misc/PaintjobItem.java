package com.nukateam.nukacraft.common.foundation.items.misc;

import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.items.frame.ArmorPart;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public class PaintjobItem extends Item {
    private final String paintjob;
    public PaintjobItem(String paintjob, Properties pProperties) {
        super(pProperties);
        this.paintjob = paintjob;
    }
    @Override
    public boolean overrideStackedOnOther(ItemStack pStack, Slot pSlot, ClickAction pAction, Player pPlayer) {
        if (pAction == ClickAction.SECONDARY) {
            ItemStack slotItem = pSlot.getItem();
            if (slotItem.getItem() instanceof ArmorPart && (Objects.equals(StackUtils.getVariant(slotItem), "clear"))) {
                StackUtils.setVariant(slotItem, paintjob);
                if (pStack.getDamageValue() == 12) {
                    pStack.shrink(1);
                } else
                    pStack.setDamageValue(pStack.getDamageValue() + 1);

//                if (!(pStack.getDamageValue() == 12)) {
//                    pStack.setDamageValue(pStack.getDamageValue() - 1);
//                } else if (pStack.getDamageValue() == 12)
//                    pStack.shrink(1);


                return true;
            }
        }
        return false;
    }
}
