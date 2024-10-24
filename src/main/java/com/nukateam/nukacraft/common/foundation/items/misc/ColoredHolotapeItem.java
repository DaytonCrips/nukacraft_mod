package com.nukateam.nukacraft.common.foundation.items.misc;

import com.nukateam.nukacraft.client.helpers.NbtColor;
import com.nukateam.nukacraft.common.data.utils.PipBoyUtils;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.nukateam.nukacraft.common.data.constants.Nbt.COLOR;

public class ColoredHolotapeItem extends HolotapeItem {
    private final NbtColor color;

    public ColoredHolotapeItem(NbtColor color, Item.Properties pProperties) {
        super(pProperties);
        this.color = color;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pUsedHand) {
        PipBoyUtils.setScreenColor(color, player);
        return super.use(level, player, pUsedHand);
    }
}
