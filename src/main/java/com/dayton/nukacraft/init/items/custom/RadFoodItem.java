package com.dayton.nukacraft.init.items.custom;

import com.dayton.nukacraft.common.helpers.RadiationMath;
import com.dayton.nukacraft.init.items.ModItemsClass;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.Nullable;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RadFoodItem extends Item {
    public RadFoodItem(Item.Properties item) {
        super(item);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack p_41409_, Level p_41410_, LivingEntity p_41411_) {
        if (p_41411_ instanceof Player) {
            RadiationMath.attributeUpdate(p_41411_, true, 0.08f, Stream.of(new AbstractMap.SimpleEntry<>("entity", p_41411_)).collect(HashMap::new,
                    (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            if (p_41409_.getItem() == ModItemsClass.BUBBLEAPPLE.get()) {
                p_41411_.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 0, false, false));
            }
        }

        return super.finishUsingItem(p_41409_, p_41410_, p_41411_);
    }
    //    @Override
//    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
//        if (entity instanceof Player) {
//            RadiationMath.attributeUpdate(entity, true, 0.08f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
//                    (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
//            if (stack.getItem() == ModItemsClass.BUBBLEAPPLE.get()) {
//                entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 0, false, false));
//
//            }
//        }
//        stack.shrink(1);
//        ItemStack itemstack = super.finishUsingItem(stack, level, entity);
//        return this.isEdible() ? entity.eat(level, stack) : stack;
//    }



    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        if (item.getItem() == ModItemsClass.BUBBLEAPPLE.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.bubblegum1"));
            list.add(new TranslatableComponent("tooltip.nukacraft.radfood"));
        } else {
            list.add(new TranslatableComponent("tooltip.nukacraft.radfood"));
        }
    }
}
