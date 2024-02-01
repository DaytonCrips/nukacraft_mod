package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.items.misc.HolotapeItem;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
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

public class ColoredHolotapeItem extends HolotapeItem {
    public static final String SCREEN = "screen";
    private String color;

    public ColoredHolotapeItem(String color, Item.Properties pProperties) {
        super(pProperties);
        this.color = color;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        var stack = pPlayer.getOffhandItem();
        if (stack.getItem() instanceof PipBoyItem) {
            if (!(stack.getOrCreateTag().getString(SCREEN).equals(color))) {
                stack.getOrCreateTag().putString(SCREEN, color);
            }
        }
        NukaCraftMod.LOGGER.debug("Tagged is " + stack.getOrCreateTag().getString(SCREEN));
        return super.use(pLevel, pPlayer, pUsedHand);
    }


    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        list.add(new TranslatableComponent("tooltip.nukacraft.holotape#" + color));
    }
}
