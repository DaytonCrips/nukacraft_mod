package com.dayton.nukacraft.common.foundation.items.custom;

import com.dayton.nukacraft.NukaCraftMod;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ColoredHolotapeItem extends HolotapeItem{
    private String color;
    public ColoredHolotapeItem(String color, Item.Properties pProperties) {
        super(pProperties);
        this.color = color;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getOffhandItem();
        if (stack.getItem() instanceof PipBoyItem) {
            if (!(stack.getOrCreateTag().getString("screen").equals(color))) {
                stack.getOrCreateTag().putString("screen", color);
            }
        }
        NukaCraftMod.LOGGER.debug("Tagged is " + stack.getOrCreateTag().getString("screen"));
        return super.use(pLevel, pPlayer, pUsedHand);
    }


    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        list.add(new TranslatableComponent("tooltip.nukacraft.holotape#" + color));
    }
}
