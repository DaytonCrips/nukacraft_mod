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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SpecialSoupItem extends RadItem {
    public SpecialSoupItem(float radiation, Item.Properties properties) {
        super(radiation, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (stack.getItem() == ModItems.FMSOUP.get() || stack.getItem() == ModItems.FMPUREE.get())
            entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
        if (!((Player) entity).isCreative())
            entity.getMainHandItem().shrink(1);

        var itemStack = super.finishUsingItem(stack, level, entity);
        return ((Player)entity).getAbilities().instabuild ? itemStack : new ItemStack(Items.BOWL);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);

        if (item.getItem() == ModItems.FMSOUP.get() || item.getItem() == ModItems.FMPUREE.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.fire_res").append("§9(0:10)"));
        }
    }
}
