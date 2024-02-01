package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.nukateam.guns.common.base.NetworkGunManager;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.Lazy;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class EffectRadItem extends RadItem {
//    private final List<Supplier<MobEffectInstance>> effects = new ArrayList<>();
    private List<Lazy<MobEffectInstance>> effects = new ArrayList<>();

    public EffectRadItem(float radiation, Supplier<MobEffectInstance> effect, Properties properties) {
        super(radiation, properties);
        if(effect != null)
            this.effects.add(Lazy.of(effect));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        for (var effect: effects) {
            entity.addEffect(effect.get());
        }
        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        addPotionTooltip(list, effects);
    }

    public static void addPotionTooltip(List<Component> pTooltips, List<Lazy<MobEffectInstance>> effects) {
        List<Pair<Attribute, AttributeModifier>> list = Lists.newArrayList();

        for(var supplier : effects) {
            var effect = supplier.get();
            if(effect == null) continue;

            var  map = effect.getEffect().getAttributeModifiers();
            if (!map.isEmpty()) {
                for(Map.Entry<Attribute, AttributeModifier> entry : map.entrySet()) {
                    AttributeModifier attributemodifier = entry.getValue();
                    AttributeModifier attributemodifier1 = new AttributeModifier(attributemodifier.getName(),
                            effect.getEffect().getAttributeModifierValue(effect.getAmplifier(), attributemodifier),
                            attributemodifier.getOperation());
                    list.add(new Pair<>(entry.getKey(), attributemodifier1));
                }
            }
            var mutablecomponent = new TranslatableComponent(effect.getDescriptionId());

            if (effect.getAmplifier() > 0) {
                mutablecomponent = new TranslatableComponent("potion.withAmplifier", mutablecomponent, new TranslatableComponent("potion.potency." + effect.getAmplifier()));
            }

            if (effect.getDuration() > 20) {
                mutablecomponent = new TranslatableComponent("potion.withDuration", mutablecomponent, MobEffectUtil.formatDuration(effect, 1));
            }

            pTooltips.add(mutablecomponent.withStyle(effect.getEffect().getCategory().getTooltipFormatting()));
        }

        if (!list.isEmpty()) {
            pTooltips.add(TextComponent.EMPTY);
            pTooltips.add((new TranslatableComponent("potion.whenDrank")).withStyle(ChatFormatting.DARK_PURPLE));

            for(var pair : list) {
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
                    pTooltips.add((new TranslatableComponent("attribute.modifier.plus." + attributeModifier.getOperation().toValue(), ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(d1), new TranslatableComponent(pair.getFirst().getDescriptionId()))).withStyle(ChatFormatting.BLUE));
                } else if (d0 < 0.0D) {
                    d1 *= -1.0D;
                    pTooltips.add((new TranslatableComponent("attribute.modifier.take." + attributeModifier.getOperation().toValue(), ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(d1), new TranslatableComponent(pair.getFirst().getDescriptionId()))).withStyle(ChatFormatting.RED));
                }
            }
        }

    }
}