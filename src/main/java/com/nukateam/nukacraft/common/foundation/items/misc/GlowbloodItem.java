package com.nukateam.nukacraft.common.foundation.items.misc;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GlowbloodItem extends RadItem {
    public GlowbloodItem(float radiation, Properties item) {
        super(radiation, item);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        list.add(new TranslatableComponent("effect.nukacraft.glowing"));
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 10;
    }
}
