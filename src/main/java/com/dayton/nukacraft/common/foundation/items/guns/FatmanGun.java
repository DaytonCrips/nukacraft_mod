package com.dayton.nukacraft.common.foundation.items.guns;

import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.nukacraft.client.render.renderers.FatmanRendererAnimated;
import com.dayton.guns.client.render.renderers.AnimatedGunRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public class FatmanGun extends GunItem {
    public FatmanGun(Properties properties) {
        super(properties);
    }

    private static final FatmanRendererAnimated renderer = new FatmanRendererAnimated();

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

//    @Override
    public AnimatedGunRenderer getRenderer() {
        return renderer;
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return false;
    }
}
