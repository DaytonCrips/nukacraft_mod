package com.nukateam.nukacraft.common.foundation.items.сonsumables;

import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.network.chat.*;
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

public class NukaColaItem extends EffectRadItem {
    public NukaColaItem(float radiation, int duration, Properties properties) {
        super(radiation, MobEffects.MOVEMENT_SPEED, duration, properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }
}
