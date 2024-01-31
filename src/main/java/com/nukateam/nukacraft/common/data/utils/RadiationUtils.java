package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.common.registery.ModAttributesClass;
import com.nukateam.nukacraft.common.registery.ModEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.nukateam.nukacraft.common.data.utils.MathUtils.limit;

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
//        var oldMaxHealth = entity.getAttributeValue(Attributes.MAX_HEALTH);
//        var totalRadiation = entity.getAttributeValue(ModAttributesClass.RADIATION.get());
//        var currentHealth = entity.getAttributeValue(Attributes.MAX_HEALTH);
//        var totalHealth = oldMaxHealth + totalRadiation;
//        var maxHealth = oldMaxHealth - value;
//        var radiation = totalRadiation + value;

//        radiation = limit(radiation, 0, totalHealth -2);
//        maxHealth = limit(maxHealth, 2, totalHealth);

//        entity.getAttribute(ModAttributesClass.RADIATION.get()).setBaseValue(radiation);
//        entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxHealth);

//        var s = modifiers.get(entity);

        var radiationAtt = entity.getAttribute(ModAttributesClass.RADIATION.get());
        var healthAtt =  entity.getAttribute(Attributes.MAX_HEALTH);

        var maxHealth = healthAtt.getBaseValue();
        var currentHealth = healthAtt.getValue();

        var currentRad = radiationAtt.getValue();

        var radMod = value;
        var healthMod = -value;
        var isRemovingRad = value < 0;

        if(isRemovingRad){
            if (currentHealth + healthMod > maxHealth) {
                healthMod = maxHealth - currentHealth;
            }
            if(currentRad + radMod < 0){
                radMod = currentRad;
            }
        }
//        else if(currentHealth + value < 0){
//
//        }

        modifyAttribute(radMod, radiationAtt);
        modifyAttribute(healthMod, healthAtt);

        var mod = new AttributeModifier("radiation", -value, AttributeModifier.Operation.ADDITION);

//        radiationAtt.setBaseValue(radiation);
//        entity.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier();

//        if(entity.getAttribute(Attributes.MAX_HEALTH).getValue() > 20){
////            entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
//            entity.getAttribute(Attributes.MAX_HEALTH).getModifiers();
//        }

        if (value > 0 & !(currentHealth <= 2)) {
            entity.hurt(DamageSource.GENERIC, 0.1f);
        }

    }

    private static void modifyAttribute(double value, AttributeInstance radiationAtt) {
        if (radiationAtt == null) return;

        var radValue = 0.0;

        for (var mod: radiationAtt.getModifiers()) {
            if (mod.getName().equals("radiation")){
                radValue = mod.getAmount();
                radiationAtt.removeModifier(mod);
            }
        }

        radiationAtt.addPermanentModifier(new AttributeModifier("radiation", radValue + value, AttributeModifier.Operation.ADDITION));
    }
}

///execute as @p run attribute @s minecraft:generic.max_health base set 100