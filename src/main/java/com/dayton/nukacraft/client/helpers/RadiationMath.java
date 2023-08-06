package com.dayton.nukacraft.client.helpers;

import com.dayton.nukacraft.common.effects.ModAttributesClass;
import com.dayton.nukacraft.common.effects.ModEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import java.util.Collection;
import java.util.Map;

public class RadiationMath {

    //if argument method is true - radiation added value, else - delete value
    public static void attributeUpdate(LivingEntity entity_, Boolean method, float value, Map<String, Object> depend) {
        double attribute_val = entity_.getAttributeValue(ModAttributesClass.RADIATION.get());
        Entity entity = (Entity) depend.get("entity");
        if (new Object() {
            boolean check(Entity _entity) {
                if (_entity instanceof LivingEntity) {
                    Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
                    for (MobEffectInstance effect : effects) {
                        if (effect.getEffect() == ModEffect.RAD_RES.get())
                            return true;
                    }
                }
                return false;
            }
        }.check(entity)) {
            if (entity instanceof Player && !entity.level.isClientSide) {
                if (method == true) {
                    value /= 1.5;
                }

            }
        }
        if (new Object() {
            boolean check(Entity _entity) {
                if (_entity instanceof LivingEntity) {
                    Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
                    for (MobEffectInstance effect : effects) {
                        if (effect.getEffect() == ModEffect.QUANT_SHIELD.get())
                            return true;
                    }
                }
                return false;
            }
        }.check(entity)) {
            if (entity instanceof Player && !entity.level.isClientSide) {
                if (method == true) {
                    value /= 2.0;
                }

            }
        }

        if (method == true) {
            if ((attribute_val + value) >= 32) {
                entity_.getAttribute(ModAttributesClass.RADIATION.get()).setBaseValue(32);
            } else {
                entity_.getAttribute(ModAttributesClass.RADIATION.get()).setBaseValue(attribute_val + value);
            }
        }

        if (method == false) {
            if ((attribute_val - value) <= 0) {
                entity_.getAttribute(ModAttributesClass.RADIATION.get()).setBaseValue(0);
            } else {
                entity_.getAttribute(ModAttributesClass.RADIATION.get()).setBaseValue(attribute_val - value);
            }
        }
        attributeMod(entity_, method);
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
            if (method == true && entity.getAttributeBaseValue(Attributes.MAX_HEALTH) == 20) {
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