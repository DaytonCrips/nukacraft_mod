package com.dayton.nukacraft.init.items.custom;

import com.dayton.nukacraft.common.effects.ModEffect;
import com.dayton.nukacraft.common.helpers.RadiationMath;
import com.dayton.nukacraft.init.items.ModItemsClass;
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

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StimpakItem extends Item {
    public StimpakItem(Properties item) {
        super(item);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            if (stack.getItem() == ModItemsClass.STIMPAK.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0, false, false));
            }
            if (stack.getItem() == ModItemsClass.SUPER_STIMPAK.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 0, false, false));
            }
        }
        stack.shrink(1);
        return stack;
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        if (item.getItem() == ModItemsClass.STIMPAK.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.stimpak"));
        }
        if (item.getItem() == ModItemsClass.SUPER_STIMPAK.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.super_stimpak"));
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {return 22;}

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.BOW;
    }


}
