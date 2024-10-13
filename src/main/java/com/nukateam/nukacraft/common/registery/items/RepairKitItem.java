package com.nukateam.nukacraft.common.registery.items;

import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.items.frame.ArmorPart;
import com.nukateam.nukacraft.common.foundation.items.misc.SimpleMeleeWeapon;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public class RepairKitItem extends Item {
    private int repairPerClick;

    public RepairKitItem(int repairPerClick, Properties pProperties) {
        super(pProperties);
        this.repairPerClick = repairPerClick;
    }
    @Override
    public boolean overrideStackedOnOther(ItemStack pStack, Slot pSlot, ClickAction pAction, Player pPlayer) {
        ItemStack slotItem = pSlot.getItem();
        int targetDamage = slotItem.getDamageValue();
        int kitDurability = pStack.getMaxDamage() - pStack.getDamageValue();
        if (pAction == ClickAction.SECONDARY) {
            if (slotItem.getItem() instanceof ArmorPart || slotItem.getItem() instanceof SimpleMeleeWeapon || slotItem.getItem() instanceof ArmorItem) {
                if (!(Screen.hasControlDown())) {
                    if (kitDurability >= repairPerClick) {
                        if (targetDamage <= repairPerClick) {
                            pStack.setDamageValue(pStack.getDamageValue() + targetDamage);
                            slotItem.setDamageValue(slotItem.getDamageValue() - targetDamage);
                            return false;
                        } else {
                            pStack.setDamageValue(pStack.getDamageValue() + repairPerClick);
                            slotItem.setDamageValue(slotItem.getDamageValue() - repairPerClick);
                            return false;
                        }
                    } else {
                        if (targetDamage <= kitDurability) {
                            pStack.setDamageValue(pStack.getDamageValue() + targetDamage);
                            slotItem.setDamageValue(slotItem.getDamageValue() - targetDamage);
                            return false;
                        } else {
                            pStack.setDamageValue(pStack.getDamageValue() + kitDurability);
                            slotItem.setDamageValue(slotItem.getDamageValue() - kitDurability);
                            pStack.shrink(1);
                            return false;
                        }
                    }
                } else {
                    if (targetDamage <= kitDurability) {
                        pStack.setDamageValue(pStack.getDamageValue() + targetDamage);
                        slotItem.setDamageValue(slotItem.getDamageValue() - targetDamage);
                        return false;
                    } else {
                        pStack.setDamageValue(pStack.getDamageValue() + kitDurability);
                        slotItem.setDamageValue(slotItem.getDamageValue() - kitDurability);
                        pStack.shrink(1);
                        return false;
                    }
                }
            }
        }

        return false;
    }

}
