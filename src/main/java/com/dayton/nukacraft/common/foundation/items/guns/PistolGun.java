package com.dayton.nukacraft.common.foundation.items.guns;

import com.dayton.nukacraft.common.foundation.items.ModGunsClass;
import com.dayton.nukacraft.guns.common.Gun;
import com.dayton.nukacraft.guns.init.ModEnchantments;
import com.dayton.nukacraft.guns.item.GunItem;
import com.dayton.nukacraft.guns.item.attachment.IAttachment;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

import java.util.Map;

public class PistolGun extends GunItem {
    public PistolGun(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return false;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(stack);
        if (Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGunsClass.MAGAZINE1.get()) {
            if (_enchantments.containsKey(ModEnchantments.OVER_CAPACITY.get())) {
                _enchantments.remove(ModEnchantments.OVER_CAPACITY.get());
            }
            EnchantmentHelper.setEnchantments(_enchantments, stack);
            stack.enchant(ModEnchantments.OVER_CAPACITY.get(), 1);
        }
        if (Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGunsClass.MAGAZINE2.get()) {
            if (_enchantments.containsKey(ModEnchantments.OVER_CAPACITY.get())) {
                _enchantments.remove(ModEnchantments.OVER_CAPACITY.get());
            }
            EnchantmentHelper.setEnchantments(_enchantments, stack);
            stack.enchant(ModEnchantments.OVER_CAPACITY.get(), 2);
        }
        if (Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGunsClass.MAGAZINE3.get()) {
            if (_enchantments.containsKey(ModEnchantments.OVER_CAPACITY.get())) {
                _enchantments.remove(ModEnchantments.OVER_CAPACITY.get());
            }
            EnchantmentHelper.setEnchantments(_enchantments, stack);
            stack.enchant(ModEnchantments.OVER_CAPACITY.get(), 3);
        }

        if (Gun.getAttachment(IAttachment.Type.STOCK, stack).getItem() == Items.AIR
                && (_enchantments.containsKey(ModEnchantments.OVER_CAPACITY.get()))){
            _enchantments.remove(ModEnchantments.OVER_CAPACITY.get());
            EnchantmentHelper.setEnchantments(_enchantments, stack);
        }

        super.inventoryTick(stack, p_41405_, p_41406_, p_41407_, p_41408_);
    }
}
