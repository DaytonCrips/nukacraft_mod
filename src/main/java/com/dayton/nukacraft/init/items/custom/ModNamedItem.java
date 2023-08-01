package com.dayton.nukacraft.init.items.custom;

import com.dayton.nukacraft.common.helpers.RadiationMath;
import com.dayton.nukacraft.init.items.ModItemsClass;
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
    public ModNamedItem(Block p_41579_, Item.Properties p_41580_) {
        super(p_41579_, p_41580_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack p_41409_, Level p_41410_, LivingEntity p_41411_) {
        if (p_41411_ instanceof Player) {
            if (p_41409_.getItem() == ModItemsClass.CRACKBERRY.get()) {
                p_41411_.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
                RadiationMath.attributeUpdate(p_41411_, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", p_41411_)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }
            if (p_41409_.getItem() == ModItemsClass.BOMBBERRY.get()) {
                RadiationMath.attributeUpdate(p_41411_, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", p_41411_)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }
            if (p_41409_.getItem() == ModItemsClass.FUSFRUIT.get()) {
                RadiationMath.attributeUpdate(p_41411_, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", p_41411_)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }
            if (p_41409_.getItem() == ModItemsClass.NEUTRONROD.get()) {
                RadiationMath.attributeUpdate(p_41411_, true, 0.1f, Stream.of(new AbstractMap.SimpleEntry<>("entity", p_41411_)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }
            if (p_41409_.getItem() == ModItemsClass.XANDER_ROOT.get()) {
                RadiationMath.attributeUpdate(p_41411_, true, 0.3f, Stream.of(new AbstractMap.SimpleEntry<>("entity", p_41411_)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                p_41411_.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));

            }
        }
        return super.finishUsingItem(p_41409_, p_41410_, p_41411_);
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
