package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import com.nukateam.nukacraft.common.data.utils.RadiationUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static java.lang.Math.abs;

public class RadItem extends Item {
    protected final float radiation;


    public RadItem(float radiation, Item.Properties item) {
        super(item);
        this.radiation = radiation;
    }

    public static void showRadiation(List<Component> list, float radiation) {
        if (radiation == 0) return;

        if (radiation < 0) {
            list.add(Component.translatable("tooltip.nukacraft.irradiation").append("§a-" + abs(radiation)));
        } else {
            list.add(Component.translatable("tooltip.nukacraft.radiation").append("§c+" + abs(radiation)));
        }
    }

    public boolean isIrradiated() {
        return radiation > 0;
    }

    @Override
    @NotNull
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player)
            RadiationUtils.addRadiation(entity, radiation);


//        if (!(entity instanceof Player player) || !player.isCreative()) {
//            stack.shrink(1);
//        }

//        if (entity instanceof Player player)//&& !level.isClientSide
//            RadiationUtils.setAddMaxHealth(player, -10);


        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        showRadiation(list, radiation);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 10;
    }
}
