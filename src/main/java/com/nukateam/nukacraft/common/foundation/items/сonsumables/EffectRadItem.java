package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class EffectRadItem extends RadItem {
    private final List<Supplier<MobEffectInstance>> effectSuppliers = new ArrayList<>();
    private List<MobEffectInstance> effects = new ArrayList<>();

    public EffectRadItem(float radiation, Supplier<MobEffectInstance> effect, Properties properties) {
        super(radiation, properties);
        if (effect != null)
            this.effectSuppliers.add(effect);
    }

    public EffectRadItem(float radiation, List<Supplier<MobEffectInstance>> effects, Properties properties) {
        super(radiation, properties);
        if (effects != null)
            this.effectSuppliers.addAll(effects);
    }

    public static void addPotionTooltip(List<Component> pTooltips, List<Supplier<MobEffectInstance>> effects) {
        List<Pair<Attribute, AttributeModifier>> list = Lists.newArrayList();

        for (var supplier : effects) {
            var effect = supplier.get();
            if (effect == null) continue;

            var map = effect.getEffect().getAttributeModifiers();
            if (!map.isEmpty()) {
                for (Map.Entry<Attribute, AttributeModifier> entry : map.entrySet()) {
                    AttributeModifier attributemodifier = entry.getValue();
                    AttributeModifier attributemodifier1 = new AttributeModifier(attributemodifier.getName(),
                            effect.getEffect().getAttributeModifierValue(effect.getAmplifier(), attributemodifier),
                            attributemodifier.getOperation());
                    list.add(new Pair<>(entry.getKey(), attributemodifier1));
                }
            }
            var mutablecomponent = Component.translatable(effect.getDescriptionId());

            if (effect.getAmplifier() > 0) {
                mutablecomponent = Component.translatable("potion.withAmplifier", mutablecomponent, Component.translatable("potion.potency." + effect.getAmplifier()));
            }

            if (effect.getDuration() > 20) {
                mutablecomponent = Component.translatable("potion.withDuration", mutablecomponent, MobEffectUtil.formatDuration(effect, 1));
            }

            pTooltips.add(mutablecomponent.withStyle(effect.getEffect().getCategory().getTooltipFormatting()));
        }

        if (!list.isEmpty()) {
            pTooltips.add(Component.literal(""));
            pTooltips.add((Component.translatable("potion.whenDrank")).withStyle(ChatFormatting.DARK_PURPLE));

            for (var pair : list) {
                var attributeModifier = pair.getSecond();
                double d0 = attributeModifier.getAmount();
                double d1;

                if (attributeModifier.getOperation() != AttributeModifier.Operation.MULTIPLY_BASE &&
                        attributeModifier.getOperation() != AttributeModifier.Operation.MULTIPLY_TOTAL) {
                    d1 = attributeModifier.getAmount();
                } else {
                    d1 = attributeModifier.getAmount() * 100.0D;
                }

                if (d0 > 0.0D) {
                    pTooltips.add((Component.translatable("attribute.modifier.plus." + attributeModifier.getOperation().toValue(), ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(d1), Component.translatable(pair.getFirst().getDescriptionId()))).withStyle(ChatFormatting.BLUE));
                } else if (d0 < 0.0D) {
                    d1 *= -1.0D;
                    pTooltips.add((Component.translatable("attribute.modifier.take." + attributeModifier.getOperation().toValue(), ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(d1), Component.translatable(pair.getFirst().getDescriptionId()))).withStyle(ChatFormatting.RED));
                }
            }
        }

    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        for (var supp : effectSuppliers) {
            var effect = supp.get();
            effects.clear();
            effects.add(effect);
            entity.addEffect(effect);
        }
        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        addPotionTooltip(list, effectSuppliers);
    }
}