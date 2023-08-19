package com.dayton.nukacraft.common.items.custom;

import com.dayton.nukacraft.common.effects.ModEffect;
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

public class MedicineItem extends Item {
    private float radfloat;
    private boolean irradiated;
    public MedicineItem(boolean irradiated, float radfloat, Properties item) {
        super(item);
        this.irradiated = irradiated;
        this.radfloat = radfloat;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            RadiationMath.attributeUpdate(entity, irradiated, radfloat, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                    (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));



            if (stack.getItem() == ModItemsClass.RADAWAY.get()) {
                RadiationMath.attributeUpdate(entity, false, 4.0f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            }

            if (stack.getItem() == ModItemsClass.GLOWBLOOD.get()) {
                RadiationMath.attributeUpdate(entity, true, 3.0f, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 140, 0, false, false));
            }

            if (stack.getItem() == ModItemsClass.RADX.get()) {
                entity.addEffect(new MobEffectInstance(ModEffect.RAD_RES.get(), 600, 0, false, false));
            }
            if (!((Player) entity).isCreative()) {entity.getMainHandItem().shrink(1);}
        }

        return stack;
    }



    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);

        if (!this.irradiated) {
            if (!(this.radfloat == 0.0f)) {
                list.add(new TranslatableComponent("tooltip.nukacraft.irradiation").append(("§a-" + this.radfloat)));
            }
        } else {
            list.add(new TranslatableComponent("tooltip.nukacraft.radiation").append(("§c+" + this.radfloat)));
        }


        if (item.getItem() == ModItemsClass.GLOWBLOOD.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.glowing"));
        }

        if (item.getItem() == ModItemsClass.RADX.get()) {
            list.add(new TranslatableComponent("effect.nukacraft.rad_shield").append("§9(0:30)"));
        }

    }




    @Override
    public int getUseDuration(ItemStack stack) {
        if (stack.getItem() == ModItemsClass.RADX.get()) {
            return 9;
        } else {
            return 25;
        }

    }
}
