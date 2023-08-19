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
    private float radfloat;
    private boolean irradiated;
    public NukaColaItem(boolean irradiated, float radfloat, Properties properties) {
        super(properties);
        this.irradiated = irradiated;
        this.radfloat = radfloat;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            ItemStack items = new ItemStack(ModItemsClass.CAP.get());
            items.setCount(1);
            ItemHandlerHelper.giveItemToPlayer((Player) entity, items);

            RadiationMath.attributeUpdate(entity, irradiated, radfloat, Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                    (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

            if (!((Player) entity).isCreative()) {entity.getMainHandItem().shrink(1);}
        }
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0, false, false));
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
        list.add(new TranslatableComponent("effect.nukacraft.speed").append("§9(0:10)"));

    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }
}
