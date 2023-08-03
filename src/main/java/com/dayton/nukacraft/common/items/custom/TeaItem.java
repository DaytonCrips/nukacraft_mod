package com.dayton.nukacraft.common.items.custom;

import com.dayton.nukacraft.server.helpers.RadiationMath;
import com.dayton.nukacraft.common.items.ModItemsClass;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TeaItem extends Item {
    public TeaItem(Item.Properties item) {super(item);}

    @Override
    public ItemStack finishUsingItem(ItemStack p_41409_, Level p_41410_, LivingEntity p_41411_) {
        if (p_41411_ instanceof Player) {
            if (p_41409_.getItem() == ModItemsClass.ASTER_TEA.get()) {
                RadiationMath.attributeUpdate(p_41411_, true, 0.04f, Stream.of(new AbstractMap.SimpleEntry<>("entity", p_41411_)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                p_41411_.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
            }
            if (p_41409_.getItem() == ModItemsClass.SWEET_ASTER_TEA.get()) {
                p_41411_.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
            }
            if (p_41409_.getItem() == ModItemsClass.ASH_TEA.get()) {
                RadiationMath.attributeUpdate(p_41411_, true, 0.04f, Stream.of(new AbstractMap.SimpleEntry<>("entity", p_41411_)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                p_41411_.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0, false, false));
            }
            if (p_41409_.getItem() == ModItemsClass.SWEET_ASH_TEA.get()) {
                p_41411_.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0, false, false));
            }
            if (p_41409_.getItem() == ModItemsClass.THISTLE_TEA.get()) {
                RadiationMath.attributeUpdate(p_41411_, true, 0.04f, Stream.of(new AbstractMap.SimpleEntry<>("entity", p_41411_)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }
        }
        return super.finishUsingItem(p_41409_, p_41410_, p_41411_);
    }

    //    @Override
//    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
//        if (entity instanceof Player) {
//            if (stack.getItem() == ModItemsClass.ASTER_TEA.get()) {
//                RadiationMath.attributeUpdate(entity, true, 0.04f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
//                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
//                entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
//            }
//            if (stack.getItem() == ModItemsClass.SWEET_ASTER_TEA.get()) {
//                entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
//            }
//            if (stack.getItem() == ModItemsClass.ASH_TEA.get()) {
//                RadiationMath.attributeUpdate(entity, true, 0.04f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
//                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
//                entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0, false, false));
//            }
//            if (stack.getItem() == ModItemsClass.SWEET_ASH_TEA.get()) {
//                entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0, false, false));
//            }
//            if (stack.getItem() == ModItemsClass.THISTLE_TEA.get()) {
//                RadiationMath.attributeUpdate(entity, true, 0.04f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
//                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
//            }
//        }
//        stack.shrink(1);
//        return this.isEdible() ? entity.eat(level, stack) : stack;
//    }


    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        if (item.getItem() == ModItemsClass.ASTER_TEA.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.tea_rad"));
            list.add(new TranslatableComponent("tooltip.nukacraft.tea_regen"));
        }
        if (item.getItem() == ModItemsClass.SWEET_ASTER_TEA.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.tea_regen"));
        }
        if (item.getItem() == ModItemsClass.ASH_TEA.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.tea_rad"));
            list.add(new TranslatableComponent("tooltip.nukacraft.tea_haste"));
        }
        if (item.getItem() == ModItemsClass.SWEET_ASH_TEA.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.tea_haste"));
        }
        if (item.getItem() == ModItemsClass.THISTLE_TEA.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.tea_rad"));
            list.add(new TranslatableComponent("tooltip.nukacraft.tea_thistle"));
        }
    }


    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }
}
