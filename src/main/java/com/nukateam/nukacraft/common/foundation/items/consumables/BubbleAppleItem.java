package com.nukateam.nukacraft.common.foundation.items.consumables;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BubbleAppleItem extends RadItem {
    public BubbleAppleItem(float radiation, Item.Properties properties) {
        super(radiation, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide)
            entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 0, false, false));

        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        list.add(Component.translatable("tooltip.nukacraft.jumpboost").append("§9(0:05)"));
    }
}