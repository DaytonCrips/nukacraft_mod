package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.common.registery.ModAttributes;
import com.nukateam.nukacraft.common.registery.ModEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class RadiationUtils {
    public static void addRadiation(LivingEntity entity, float value) {
        var effects = entity.getActiveEffects();
        if (entity instanceof Player && value > 0) {
            for (var effect : effects) {
                if (effect.getEffect() == ModEffect.RAD_RES.get())
                    value /= 1.5;
                else if (effect.getEffect() == ModEffect.QUANT_SHIELD.get())
                    value /= 2.0;
            }
        }
        handleAddedRadiation(entity, value);
    }

//    private final static Map<LivingEntity, Pair<UUID, UUID>> modifiers = new HashMap<>();

    private static void handleAddedRadiation(LivingEntity entity, double value) {
        var radiationAtt = entity.getAttribute(ModAttributes.RADIATION.get());
        var healthAtt = entity.getAttribute(Attributes.MAX_HEALTH);
        var maxHealth = healthAtt.getBaseValue();
        var currentHealth = healthAtt.getValue();
        var currentRad = radiationAtt.getValue();
        var radMod = value;
        var healthMod = -value;
        var isRemovingRad = value < 0;

        if (isRemovingRad) {
            if (currentHealth + healthMod > maxHealth) {
                healthMod = maxHealth - currentHealth;
            }
            if (currentRad + radMod < 0) {
                radMod = -currentRad;
            }
        } else {
            if (currentHealth + healthMod > maxHealth - 1) {
                healthMod = maxHealth - currentHealth - 1;
            }
            if (currentRad + radMod > maxHealth - 1) {
                radMod = Math.max(0, Math.min(radMod, currentHealth - 1));
            }
        }

        modifyAttribute(radiationAtt, radMod, 0, maxHealth - 1);
        modifyAttribute(healthAtt, healthMod, -maxHealth + 1, 0);

        entity.setHealth(Math.min(entity.getMaxHealth(), entity.getHealth()));

//        if (value > 0 & !(currentHealth <= 2)) {
////            entity.hurt(DamageSource.GENERIC, 0.0f);
//        }
    }

    private static void modifyAttribute(AttributeInstance radiationAtt, double value, double minBound, double maxBound) {
        if (radiationAtt == null) return;

        var currentValue = 0.0;

        for (var mod : radiationAtt.getModifiers()) {
            if (mod.getName().equals("radiation")) {
                currentValue = mod.getAmount();
                radiationAtt.removeModifier(mod);
            }
        }

        var newValue = currentValue + value;

        if (newValue < minBound) newValue = minBound;
        if (newValue > maxBound) newValue = maxBound;

        radiationAtt.addPermanentModifier(new AttributeModifier("radiation", newValue, AttributeModifier.Operation.ADDITION));
    }


    public static void setAddMaxHealth2(Player player, double value) {
        var attribute = player.getAttribute(Attributes.MAX_HEALTH);

        if (attribute == null) return;

        var currentValue = 0.0;

        for (var mod : attribute.getModifiers()) {
            if (mod.getName().equals("health")) {
                currentValue = mod.getAmount();
                attribute.removeModifier(mod);
            }
        }

        attribute.addPermanentModifier(new AttributeModifier("health", currentValue + value, AttributeModifier.Operation.ADDITION));
    }

}

///execute as @p run attribute @s minecraft:generic.max_health base set 100