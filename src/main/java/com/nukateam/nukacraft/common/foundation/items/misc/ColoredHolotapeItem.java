package com.nukateam.nukacraft.common.foundation.items.misc;

import com.nukateam.nukacraft.client.helpers.NbtColor;
import com.nukateam.nukacraft.common.data.utils.PipBoyUtils;
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

import static com.nukateam.nukacraft.common.data.constants.Nbt.COLOR;

public class ColoredHolotapeItem extends HolotapeItem {
    public static final String SCREEN = "screen";
//    private final float red;
//    private final float green;
//    private final float blue;
    private final NbtColor color;

    public ColoredHolotapeItem(NbtColor color, Item.Properties pProperties) {
        super(pProperties);
        this.color = color;
//        this.red = red;
//        this.green = green;
//        this.blue = blue;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand pUsedHand) {
        var stack = PipBoyUtils.getPipboyStack(player);
        if (stack.getItem() instanceof PipBoyItem) {
            var pipBoyTag = stack.getOrCreateTag();
            pipBoyTag.put(COLOR, color.serializeNBT());
        }

        return super.use(level, player, pUsedHand);
    }


    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        list.add(new TranslatableComponent("tooltip.nukacraft.holotape#" + color));
    }
}
