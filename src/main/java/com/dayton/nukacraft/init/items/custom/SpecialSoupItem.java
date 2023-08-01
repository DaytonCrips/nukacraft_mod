package com.dayton.nukacraft.init.items.custom;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.init.items.ModItemsClass;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SpecialSoupItem extends Item {
    public SpecialSoupItem(Item.Properties item) {super(item);}
//
    @Override
    public ItemStack finishUsingItem(ItemStack p_40684_, Level p_40685_, LivingEntity p_40686_) {
        //p_40686_.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
        if (p_40684_.getItem() == ModItemsClass.FMSOUP.get()) {
            p_40686_.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
            NukaCraftMod.LOGGER.debug("This is " + p_40684_.getItem());
        }
        if (p_40684_.getItem() == ModItemsClass.FMPUREE.get()) {
            p_40686_.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
            NukaCraftMod.LOGGER.debug("This is " + p_40684_.getItem());
        }
        ItemStack itemstack = super.finishUsingItem(p_40684_, p_40685_, p_40686_);
        return p_40686_ instanceof Player && ((Player)p_40686_).getAbilities().instabuild ? itemstack : new ItemStack(Items.BOWL);
    }

//    @Override
//    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
//        stack.shrink(1);
//        if (entity instanceof Player) {
//            if (stack.getItem() == ModItemsClass.FMSOUP.get()) {
//                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
//            }
//            if (stack.getItem() == ModItemsClass.FMPUREE.get()) {
//                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
//            }
//        }
//        ItemStack itemstack = super.finishUsingItem(stack, level, entity);
//        return entity instanceof Player && ((Player)entity).getAbilities().instabuild ? itemstack : new ItemStack(Items.BOWL);
//    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        if (item.getItem() == ModItemsClass.FMSOUP.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.fm_fireres"));
        }
        if (item.getItem() == ModItemsClass.FMPUREE.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.fm_fireres"));
        }
    }
}
