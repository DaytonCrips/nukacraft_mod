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
    private float radfloat;
    private boolean irradiated;
    public ModNamedItem(boolean irradiated, float radfloat, Block block, Item.Properties prop) {
        super(block, prop);
        this.irradiated = irradiated;
        this.radfloat = radfloat;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            RadiationMath.attributeUpdate(entity, this.irradiated, this.radfloat, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                    (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

            if (stack.getItem() == ModItemsClass.CRACKBERRY.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0, false, false));
            }

            if (stack.getItem() == ModItemsClass.XANDER_ROOT.get()) {
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));
            }
        }
        return super.finishUsingItem(stack, level, entity);
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

        if (item.getItem() == ModItemsClass.CRACKBERRY.get()) {
            list.add(new TranslatableComponent("tooltip.nukacraft.fire_res").append("§9(0:10)"));
        }
    }
}
