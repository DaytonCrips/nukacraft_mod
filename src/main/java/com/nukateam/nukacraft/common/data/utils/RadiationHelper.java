package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.common.foundation.effects.ModAttributesClass;
import com.nukateam.nukacraft.common.foundation.effects.ModEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import static com.nukateam.nukacraft.common.data.utils.MathUtils.limit;

public class RadiationHelper {
    public static double getPlayerRadiation(){
        return Minecraft.getInstance().player.getAttributeValue(ModAttributesClass.RADIATION.get());
    }

    public static void updateRadiation(LivingEntity entity, float value) {
        var effects = entity.getActiveEffects();
        if (entity instanceof Player && value > 0) {
            for (var effect : effects) {
                if (effect.getEffect() == ModEffect.RAD_RES.get())
                    value /= 1.5;
                else if (effect.getEffect() == ModEffect.QUANT_SHIELD.get())
                    value /= 2.0;
            }
        }
        updateAttributes(entity, value);
    }

    private static void updateAttributes(LivingEntity entity, double value) {
        var oldMaxHealth = entity.getAttributeValue(Attributes.MAX_HEALTH);
        var totalRadiation = entity.getAttributeValue(ModAttributesClass.RADIATION.get());
        var currentHealth = entity.getAttributeValue(Attributes.MAX_HEALTH);
        var totalHealth = oldMaxHealth + totalRadiation;
        var maxHealth = oldMaxHealth - value;
        var radiation = totalRadiation + value;

        radiation = limit(radiation, 0, totalHealth -2);
        maxHealth = limit(maxHealth, 2, totalHealth);

        entity.getAttribute(ModAttributesClass.RADIATION.get()).setBaseValue(radiation);
        entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxHealth);
        if (value > 0 & !(currentHealth <= 2)) {
            entity.hurt(DamageSource.GENERIC, 2f);
        }

    }
}

///execute as @p run attribute @s minecraft:generic.max_health base set 100