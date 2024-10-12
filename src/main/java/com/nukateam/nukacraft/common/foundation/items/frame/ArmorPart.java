package com.nukateam.nukacraft.common.foundation.items.frame;

import com.jetug.chassis_core.common.foundation.ChassisArmorMaterial;
import com.jetug.chassis_core.common.foundation.item.ChassisArmor;
import com.jetug.chassis_core.common.foundation.item.StackUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.jetug.chassis_core.common.foundation.item.StackUtils.getVariant;

public class ArmorPart extends ChassisArmor {
    public ArmorPart(ChassisArmorMaterial material, String part) {
        super(new Item.Properties().fireResistant(), material, part);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        var stack = pPlayer.getItemInHand(pUsedHand);
        //StackUtils.setVariant(stack, "clear");
        StackUtils.setAttachment(stack, "back", "jetpack");

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, list, isAdvanced);
        var variant = getVariant(stack);
        list.add(Component.translatable("skin." + variant));
    }
}
