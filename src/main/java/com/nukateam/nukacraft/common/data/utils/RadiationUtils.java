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
import net.minecraft.world.entity.projectile.Snowball;
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
                radMod = -currentRad;
            }
        }
        else{
            if (currentRad + radMod > maxHealth - 1){
                radMod = Math.max(0, Math.min(radMod, currentHealth - 1));
            }
        }

        modifyAttribute(radMod, radiationAtt);
        modifyAttribute(healthMod, healthAtt);

        entity.setHealth(Math.min(entity.getMaxHealth(), entity.getHealth()));

//        if (value > 0 & !(currentHealth <= 2)) {
////            entity.hurt(DamageSource.GENERIC, 0.0f);
//        }
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

    public static void setAddMaxHealth(Player player, double value) {
        player.getAttribute(Attributes.MAX_HEALTH)
                .addPermanentModifier(new AttributeModifier("health", value, AttributeModifier.Operation.ADDITION));
    }

    public static void setAddMaxHealth2(Player player, double value) {
        var attribute = player.getAttribute(Attributes.MAX_HEALTH);
                //.addPermanentModifier(new AttributeModifier("health", value, AttributeModifier.Operation.ADDITION));
        if (attribute == null) return;

        var currentValue = 0.0;

        for (var mod: attribute.getModifiers()) {
            if (mod.getName().equals("health")){
                currentValue = mod.getAmount();
                attribute.removeModifier(mod);
            }
        }

        attribute.addPermanentModifier(new AttributeModifier("health", currentValue + value, AttributeModifier.Operation.ADDITION));
    }

}

///execute as @p run attribute @s minecraft:generic.max_health base set 100