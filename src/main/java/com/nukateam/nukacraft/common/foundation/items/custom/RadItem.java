package com.nukateam.nukacraft.common.foundation.items.custom;

import com.nukateam.nukacraft.common.data.utils.RadiationHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
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

    public boolean isIrradiated(){
        return radiation > 0;
    }

    @Override @NotNull
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player)
            RadiationHelper.updateRadiation(entity, radiation);

        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        showRadiation(list, radiation);
    }

    public static void showRadiation(List<Component> list, float radiation) {
        if(radiation == 0) return;

        if (radiation < 0) {
            list.add(new TranslatableComponent("tooltip.nukacraft.irradiation").append("§a-" + abs(radiation)));
        } else {
            list.add(new TranslatableComponent("tooltip.nukacraft.radiation").append("§c+" + abs(radiation)));
        }
    }
}
