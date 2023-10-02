package com.dayton.nukacraft.common.foundation.items.custom;

import com.dayton.nukacraft.common.foundation.items.ModItemsClass;
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

//cursed:(
public class TeaItem extends RadItem {
    public TeaItem(float radiation, Item.Properties properties) {
        super(radiation, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            if (stack.getItem() == ModItemsClass.ASTER_TEA.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));}
            if (stack.getItem() == ModItemsClass.SWEET_ASTER_TEA.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));}
            if (stack.getItem() == ModItemsClass.ASH_TEA.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0, false, false));}
            if (stack.getItem() == ModItemsClass.SWEET_ASH_TEA.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0, false, false));}

            if (!((Player) entity).isCreative()) {entity.getMainHandItem().shrink(1);}
        }
        return super.finishUsingItem(stack, level, entity);
    }
    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);

        if (item.getItem() == ModItemsClass.ASTER_TEA.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.regen").append("§9(0:10)"));
        }
        if (item.getItem() == ModItemsClass.SWEET_ASTER_TEA.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.regen").append("§9(0:10)"));
        }
        if (item.getItem() == ModItemsClass.ASH_TEA.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.haste").append("§9(0:10)"));
        }
        if (item.getItem() == ModItemsClass.SWEET_ASH_TEA.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.haste").append("§9(0:10)"));
        }
        if (item.getItem() == ModItemsClass.THISTLE_TEA.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.tea_thistle"));
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
}
