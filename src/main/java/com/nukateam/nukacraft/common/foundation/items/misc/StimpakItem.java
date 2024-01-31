package com.nukateam.nukacraft.common.foundation.items.misc;

import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StimpakItem extends Item {
    private final int heal;

    public StimpakItem(int heal, Properties item) {
        super(item);
        this.heal = heal;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
//        entity.addEffect(new MobEffectInstance(MobEffects.HEAL, healDuration, 0, false, true));

        entity.heal(heal);

        if (!(entity instanceof Player player) || !player.isCreative()) {
            stack.shrink(1);
        }

        return stack;
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        if (item.getItem() == ModItems.STIMPAK.get()) {
            var text = new TranslatableComponent("effect.nukacraft.health").append("§9+" + heal);
            list.add(text);
        }
        if (item.getItem() == ModItems.SUPER_STIMPAK.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.health").append("§9+" + heal));
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {return 22;}

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }


}
