package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import com.nukateam.guns.common.base.NetworkGunManager;
import com.nukateam.nukacraft.common.data.utils.RadiationUtils;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class SpecialSoupItem extends EffectRadItem {

    public SpecialSoupItem(float radiation, Supplier<MobEffectInstance> effect, Properties properties) {
        super(radiation, effect, properties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            RadiationUtils.addRadiation(entity, radiation);
            ((Player) entity).addItem(ModItems.STEELBOWL.get().getDefaultInstance());
        }
        return super.finishUsingItem(stack, level, entity);
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }
}
