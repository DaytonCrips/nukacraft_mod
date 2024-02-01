package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class SpecialSoupItem extends EffectRadItem {
    public SpecialSoupItem(float radiation, int duration, Properties properties) {
        super(radiation, MobEffects.FIRE_RESISTANCE, duration, properties);
    }
}
