package com.dayton.nukacraft.common.items.custom;

import com.dayton.nukacraft.common.items.ModItemsClass;
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
            if (stack.getItem() == ModItemsClass.STIMPAK.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0, false, false));}

            if (stack.getItem() == ModItemsClass.SUPER_STIMPAK.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2, 0, false, false));}
            if (!((Player) entity).isCreative()) {entity.getMainHandItem().shrink(1);}
        }
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
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }


}
