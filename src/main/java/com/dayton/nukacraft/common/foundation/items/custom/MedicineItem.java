package com.dayton.nukacraft.common.foundation.items.custom;

import com.dayton.nukacraft.client.helpers.RadiationMath;
import com.dayton.nukacraft.common.foundation.effects.ModEffect;
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
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MedicineItem extends RadItem {
    public MedicineItem(float radiation, Properties item) {
        super(radiation,item);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!((Player) entity).isCreative()) {entity.getMainHandItem().shrink(1);}

        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);

        if (item.getItem() == ModItemsClass.GLOWBLOOD.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.glowing"));
        }

        if (item.getItem() == ModItemsClass.RADX.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.rad_shield").append("§9(0:30)"));
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        if (stack.getItem() == ModItemsClass.RADX.get()) {
            return 9;
        } else {
            return 25;
        }
    }
}
