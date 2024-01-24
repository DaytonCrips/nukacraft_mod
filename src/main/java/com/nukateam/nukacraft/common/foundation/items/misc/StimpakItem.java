package com.nukateam.nukacraft.common.foundation.items.misc;

import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StimpakItem extends Item {
    public StimpakItem(Properties item) {
        super(item);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            if (stack.getItem() == ModItems.STIMPAK.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0, false, false));}

            if (stack.getItem() == ModItems.SUPER_STIMPAK.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 0, false, false));}
            if (!((Player) entity).isCreative()) {entity.getMainHandItem().shrink(1);}
        }
        return stack;
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        if (item.getItem() == ModItems.STIMPAK.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.health").append("§9+5"));
        }
        if (item.getItem() == ModItems.SUPER_STIMPAK.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.health").append("§9+8"));
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {return 22;}

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }


}
