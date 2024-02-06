package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import com.nukateam.guns.common.base.NetworkGunManager;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

import java.util.function.Supplier;

public class SpecialSoupItem extends EffectRadItem {
    public SpecialSoupItem(float radiation, Supplier<MobEffectInstance> effect, Properties properties) {
        super(radiation, effect, properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }
}
