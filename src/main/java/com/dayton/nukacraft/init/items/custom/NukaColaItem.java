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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.Nullable;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class NukaColaItem extends Item {
    public NukaColaItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            if (stack.getItem() == ModItemsClass.NUKACOLA.get()) {
                RadiationMath.attributeUpdate(entity, true, 0.08f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }
            else if (stack.getItem() == ModItemsClass.NUKAFRUTTI.get()) {
                RadiationMath.attributeUpdate(entity, false, 0.09f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }
        }
        stack.shrink(1);
        if (entity instanceof Player) {
            ItemStack items = new ItemStack(ModItemsClass.CAP.get());
            items.setCount(1);
            ItemHandlerHelper.giveItemToPlayer((Player) entity, items);
        }
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0, false, false));
        return stack;
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        if (item.getItem() == ModItemsClass.NUKACOLA.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.speed"));
            list.add(new TranslatableComponent("tooltip.nukacraft.cola_rad+"));
        }
        if (item.getItem() == ModItemsClass.NUKAFRUTTI.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.speed"));
            list.add(new TranslatableComponent("tooltip.nukacraft.cola_rad-"));
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }
}
