package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class TeaItem extends EffectRadItem {
    public TeaItem(float radiation, MobEffectInstance effect, Properties properties) {
        super(radiation, () -> effect, properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
}
