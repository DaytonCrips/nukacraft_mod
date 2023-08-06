package com.dayton.nukacraft.common.items.custom;

import com.dayton.nukacraft.client.helpers.RadiationMath;
import com.dayton.nukacraft.common.items.ModItemsClass;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
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
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            RadiationMath.attributeUpdate(entity, true, 0.08f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                    (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            if (stack.getItem() == ModItemsClass.BUBBLEAPPLE.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 200, 0, false, false));
            }
            if (!((Player) entity).isCreative()) {entity.getMainHandItem().shrink(1);}
        }

        return super.finishUsingItem(stack, level, entity);
    }




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
