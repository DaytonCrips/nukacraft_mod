package com.nukateam.nukacraft.common.foundation.items.consumables;

import com.nukateam.nukacraft.common.data.utils.RadiationUtils;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class NukaColaItem extends EffectRadItem {
    public NukaColaItem(float radiation, int duration, Properties properties) {
        super(radiation, () -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration * 20, 0), properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            RadiationUtils.addRadiation(entity, radiation);
            ((Player) entity).addItem(ModItems.CAP.get().getDefaultInstance());
        }
        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }
}
