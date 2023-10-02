package com.dayton.nukacraft.common.data.utils;

import com.dayton.nukacraft.common.foundation.effects.ModAttributesClass;
import com.dayton.nukacraft.common.foundation.effects.ModEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class RadiationHelper {
    public static void updateRadiation(LivingEntity entity, float value) {
        var effects = entity.getActiveEffects();
        if (entity instanceof Player && !entity.level.isClientSide && value > 0) {
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

        if ((radiation) >= 32) radiation = 32;
        else if ((radiation) <= 0) radiation = 0;

        attribute.setBaseValue(radiation);
        //attributeMod(entity, method);
    }

    public static double getPlayerRadiation(){
        return Minecraft.getInstance().player.getAttributeValue(ModAttributesClass.RADIATION.get());
    }

    /**
     * Change Max Health and takes radiation damage
     * Max Value what can be obtained is 4, biggest triggered trouble
     */
    private static void attributeMod(LivingEntity entity, Boolean method) {
        if (entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) <= 3.99f) {
            //entity.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withMinPermissionLevel(4), "/attribute @s minecraft:generic.max_health base set 20");
            //if (method == "+") {
            entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
            //NukaCraftMod.LOGGER.debug("My Health is " + entity.getHealth());
            //  entity.attackEn
            //  tityFrom(DamageSource.GENERIC, (float) 2);
            //}

        }
        if (entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) >= 4 && entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) < 8) {
            if (method && entity.getAttributeBaseValue(Attributes.MAX_HEALTH) == 20) {
                if (entity.getHealth() == 20) {
                    entity.hurt(DamageSource.GENERIC, (float) 2);
                }
            }
            entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(18);
            //entity.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withMinPermissionLevel(4), "/attribute @s minecraft:generic.max_health base set 18");
        }
        if (entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) >= 8 && entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) < 12) {
            if (method == true && entity.getAttributeBaseValue(Attributes.MAX_HEALTH) == 18) {
                if (entity.getHealth() == 18) {
                    entity.hurt(DamageSource.GENERIC, (float) 2);
                }
            }
            entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(16);
            //entity.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withMinPermissionLevel(4), "/attribute @s minecraft:generic.max_health base set 16");
        }
        if (entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) >= 12 && entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) < 16) {
            if (method == true && entity.getAttributeBaseValue(Attributes.MAX_HEALTH) == 16) {
                if (entity.getHealth() == 16) {
                    entity.hurt(DamageSource.GENERIC, (float) 2);
                }
            }
            entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(14);
            //entity.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withMinPermissionLevel(4), "/attribute @s minecraft:generic.max_health base set 14");
        }
        if (entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) >= 16 && entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) < 20) {
            if (method == true && entity.getAttributeBaseValue(Attributes.MAX_HEALTH) == 14) {
                if (entity.getHealth() == 14) {
                    entity.hurt(DamageSource.GENERIC, (float) 2);
                }
            }
            entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(12);
            //entity.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withMinPermissionLevel(4), "/attribute @s minecraft:generic.max_health base set 12");
        }
        if (entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) >= 20 && entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) < 24) {
            if (method == true && entity.getAttributeBaseValue(Attributes.MAX_HEALTH) == 12) {
                if (entity.getHealth() == 12) {
                    entity.hurt(DamageSource.GENERIC, (float) 2);
                }
            }
            entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10);
            //entity.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withMinPermissionLevel(4), "/attribute @s minecraft:generic.max_health base set 10");
        }
        if (entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) >= 24 && entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) < 28) {
            if (method == true && entity.getAttributeBaseValue(Attributes.MAX_HEALTH) == 10) {
                if (entity.getHealth() == 10) {
                    entity.hurt(DamageSource.GENERIC, (float) 2);
                }
            }
            entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8);
            //entity.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withMinPermissionLevel(4), "/attribute @s minecraft:generic.max_health base set 8");
        }
        if (entity.getAttributeBaseValue(ModAttributesClass.RADIATION.get()) >= 28) {
            if (method == true && entity.getAttributeBaseValue(Attributes.MAX_HEALTH) == 8) {
                if (entity.getHealth() == 8) {
                    entity.hurt(DamageSource.GENERIC, (float) 2);
                }
            }
            entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(6);
            //entity.getServer().getCommandManager().handleCommand(entity.getCommandSource().withFeedbackDisabled().withMinPermissionLevel(4), "/attribute @s minecraft:generic.max_health base set 6");
        }
    }



}
