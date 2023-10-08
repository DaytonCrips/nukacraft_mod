package com.dayton.nukacraft.common.foundation.items.custom;

import com.dayton.nukacraft.common.foundation.items.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraftforge.items.ItemHandlerHelper.giveItemToPlayer;

public class NukaColaItem extends RadItem {
    public NukaColaItem(float radiation, Properties properties) {
        super(radiation, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            var items = new ItemStack(ModItems.CAP.get());
            items.setCount(1);
            giveItemToPlayer((Player) entity, items);

            if (!((Player) entity).isCreative()) {entity.getMainHandItem().shrink(1);}
        }
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0, false, false));
        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        list.add(new TranslatableComponent("effect.nukacraft.speed").append("§9(0:10)"));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }
}
