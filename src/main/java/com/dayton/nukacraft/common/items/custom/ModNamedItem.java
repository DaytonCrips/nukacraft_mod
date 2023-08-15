package com.dayton.nukacraft.common.items.custom;

import com.dayton.nukacraft.client.helpers.RadiationMath;
import com.dayton.nukacraft.common.items.ModItemsClass;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ModNamedItem extends ItemNameBlockItem {
    public ModNamedItem(Block block, Item.Properties prop) {
        super(block, prop);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {

            if (stack.getItem() == ModItemsClass.CRACKBERRY.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
                RadiationMath.attributeUpdate(entity, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }

            if (stack.getItem() == ModItemsClass.BOMBBERRY.get()) {
                RadiationMath.attributeUpdate(entity, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }

            if (stack.getItem() == ModItemsClass.FUSFRUIT.get()) {
                RadiationMath.attributeUpdate(entity, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }

            if (stack.getItem() == ModItemsClass.NEUTRONROD.get()) {
                RadiationMath.attributeUpdate(entity, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }

            if (stack.getItem() == ModItemsClass.XANDER_ROOT.get()) {
                RadiationMath.attributeUpdate(entity, true, 0.3f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));
            }
            //if (!((Player) entity).isCreative()) {entity.getMainHandItem().shrink(1);}
        }
        return super.finishUsingItem(stack, level, entity);
    }

    //    @Override
//    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
//        if (entity instanceof Player) {
//            if (stack.getItem() == ModItemsClass.CRACKBERRY.get()) {
//                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
//                RadiationMath.attributeUpdate(entity, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
//                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
//            }
//            if (stack.getItem() == ModItemsClass.BOMBBERRY.get()) {
//                RadiationMath.attributeUpdate(entity, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
//                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
//            }
//            if (stack.getItem() == ModItemsClass.FUSFRUIT.get()) {
//                RadiationMath.attributeUpdate(entity, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
//                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
//            }
//            if (stack.getItem() == ModItemsClass.NEUTRONROD.get()) {
//                RadiationMath.attributeUpdate(entity, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
//                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
//            }
//        }
//        stack.shrink(1);
//        ItemStack itemstack = super.finishUsingItem(stack, level, entity);
//        return this.isEdible() ? entity.eat(level, stack) : stack;
//    }
//
//
    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        if (item.getItem() == ModItemsClass.CRACKBERRY.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.fm_fireres"));
            list.add(new TranslatableComponent("tooltip.nukacraft.rad_effect1"));
        }
        if (item.getItem() == ModItemsClass.BOMBBERRY.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.rad_effect1"));
        }
        if (item.getItem() == ModItemsClass.FUSFRUIT.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.rad_effect1"));
        }
        if (item.getItem() == ModItemsClass.NEUTRONROD.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.rad_effect1"));
        }
        if (item.getItem() == ModItemsClass.XANDER_ROOT.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.rad_xander"));
        }
    }
}
