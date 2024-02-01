package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraftforge.items.ItemHandlerHelper.giveItemToPlayer;

public class EffectRadItem extends RadItem {
    private final int duration;
    private final MobEffect effect;

    public EffectRadItem(float radiation, MobEffect effect, int duration, Properties properties) {
        super(radiation, properties);
        this.duration = duration;
        this.effect = effect;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        entity.addEffect(new MobEffectInstance(effect, duration * 20, 0, false, true));
        return super.finishUsingItem(stack, level, entity);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(item, level, list, flag);
        var minutes = duration / 60;
        var seconds = duration - minutes * 60;
        list.add(new TextComponent("§9").append(effect.getDisplayName()).append(" §9("+minutes+":" + seconds + ")"));
    }
}