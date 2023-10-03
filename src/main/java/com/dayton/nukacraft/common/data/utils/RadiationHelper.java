package com.dayton.nukacraft.common.data.utils;

import com.dayton.nukacraft.common.foundation.effects.ModAttributesClass;
import com.dayton.nukacraft.common.foundation.effects.ModEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.*;

public class RadiationHelper {
    public static void updateRadiation(LivingEntity entity, float value) {
        var effects = entity.getActiveEffects();
        if (entity instanceof Player/* && !entity.level.isClientSide*/ && value > 0) {
            for (var effect : effects) {
                if (effect.getEffect() == ModEffect.RAD_RES.get())
                    value /= 1.5;
                else if (effect.getEffect() == ModEffect.QUANT_SHIELD.get())
                    value /= 2.0;
            }
        }

        var radiation = entity.getAttributeValue(ModAttributesClass.RADIATION.get());
        var attribute = entity.getAttribute(ModAttributesClass.RADIATION.get());

        if(attribute == null) return;

        radiation += value;
        if ((radiation) > 19) radiation = 19;
        else if ((radiation) < 0) radiation = 0;
        attribute.setBaseValue(radiation);

        attributeMod(entity, value);
    }

    public static double getPlayerRadiation(){
        return Minecraft.getInstance().player.getAttributeValue(ModAttributesClass.RADIATION.get());
    }

    /**
     * Change Max Health and takes radiation damage
     * Max Value what can be obtained is 4, biggest triggered trouble
     */
    private static void attributeMod(LivingEntity entity, double radiation) {
        var oldMaxHealth = entity.getAttributeValue(Attributes.MAX_HEALTH);
        var totalRadiation = entity.getAttributeValue(ModAttributesClass.RADIATION.get());
        var totalHealth = oldMaxHealth + totalRadiation;
        var maxHealth = oldMaxHealth - radiation;

        if(maxHealth <= 0) maxHealth = 1;
        else if(maxHealth > totalHealth) maxHealth = totalHealth;

        AttributeInstance attribute = entity.getAttribute(Attributes.MAX_HEALTH);
//
//        if(radiation > 0)
//            entity.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(
//                    new AttributeModifier("MaxHealth1", -1, ADDITION));
//        else {
//            entity.getAttribute(Attributes.MAX_HEALTH).addTransientModifier(
//                    new AttributeModifier("MaxHealth2", 1, ADDITION));
//        }
        //entity.setHealth(10);

        entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxHealth);
        entity.hurt(DamageSource.GENERIC, 0.1f);
    }
}
