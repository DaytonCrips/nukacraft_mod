package com.dayton.guns.common.foundation.item;

import com.dayton.guns.common.foundation.item.attachment.IScope;
import com.dayton.guns.common.foundation.item.attachment.impl.Scope;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

/**
 * A basic scope attachment item implementation with color support
 * <p>
 * Author: MrCrayfish
 */
public class ScopeItem extends AttachmentItem implements IScope, IColored {
    private final Scope scope;
    private final boolean colored;

    public ScopeItem(Scope scope, Item.Properties properties) {
        super(properties);
        this.scope = scope;
        this.colored = true;
    }

    public ScopeItem(Scope scope, Item.Properties properties, boolean colored) {
        super(properties);
        this.scope = scope;
        this.colored = colored;
    }

    @Override
    public Scope getProperties() {
        return this.scope;
    }

    @Override
    public boolean canColor(ItemStack stack) {
        return this.colored;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.BINDING_CURSE || super.canApplyAtEnchantingTable(stack, enchantment);
    }
}
