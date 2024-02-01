package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import com.nukateam.nukacraft.common.registery.ModEffect;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.Lazy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RadXItem extends EffectRadItem {
    private final int duration;
    private List<Lazy<MobEffectInstance>> effects = new ArrayList<>();

    public RadXItem(int durationSeconds, Properties item) {
        super(0, () -> new MobEffectInstance(ModEffect.RAD_RES.get(), durationSeconds * 20, 0), item);
        this.duration = durationSeconds;

//        effects.add(Lazy.of());
    }

//    @Override
//    public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
//        for (var lazy: effects) {
//            entity.addEffect(lazy.get());
//        }
//        return super.finishUsingItem(stack, level, entity);
//    }
//
//    @Override
//    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
//        super.appendHoverText(item, level, list, flag);
//
//        for (var lazy: effects) {
//            var effect = lazy.get();
//            var mutablecomponent = new TranslatableComponent(effect.getDescriptionId());
//
//            if (effect.getAmplifier() > 0) {
//                mutablecomponent = new TranslatableComponent("potion.withAmplifier", mutablecomponent, new TranslatableComponent("potion.potency." + effect.getAmplifier()));
//            }
//
//            if (effect.getDuration() > 20) {
//                mutablecomponent = new TranslatableComponent("potion.withDuration", mutablecomponent, MobEffectUtil.formatDuration(effect, 1));
//            }
//
//            list.add(mutablecomponent.withStyle(effect.getEffect().getCategory().getTooltipFormatting()));
//        }
//    }
}
