package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import com.nukateam.nukacraft.common.registery.ModEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.common.util.Lazy;

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
//            var mutablecomponent = Component.translatable(effect.getDescriptionId());
//
//            if (effect.getAmplifier() > 0) {
//                mutablecomponent = Component.translatable("potion.withAmplifier", mutablecomponent, Component.translatable("potion.potency." + effect.getAmplifier()));
//            }
//
//            if (effect.getDuration() > 20) {
//                mutablecomponent = Component.translatable("potion.withDuration", mutablecomponent, MobEffectUtil.formatDuration(effect, 1));
//            }
//
//            list.add(mutablecomponent.withStyle(effect.getEffect().getCategory().getTooltipFormatting()));
//        }
//    }
}
