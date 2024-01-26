package com.nukateam.nukacraft.common.foundation.items.misc;

import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

        if (item.getItem() == ModItems.GLOWBLOOD.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.glowing"));
        }

        if (item.getItem() == ModItems.RADX.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.rad_shield").append("§9(0:30)"));
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        if (stack.getItem() == ModItems.RADX.get()) {
            return 9;
        } else {
            return 25;
        }
    }
}
