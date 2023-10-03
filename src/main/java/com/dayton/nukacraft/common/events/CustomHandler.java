package com.dayton.nukacraft.common.events;

import com.dayton.nukacraft.common.foundation.effects.ModAttributesClass;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CustomHandler {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event){
        var entity = event.getEntity();
        if (entity instanceof Player player) {
            player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
            player.getAttribute(ModAttributesClass.RADIATION.get()).setBaseValue(0);
        }
    }
}