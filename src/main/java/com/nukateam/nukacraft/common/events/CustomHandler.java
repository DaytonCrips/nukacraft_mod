package com.nukateam.nukacraft.common.events;

import com.nukateam.nukacraft.common.data.utils.RadiationUtils;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.RadioactiveBlock;
import com.nukateam.nukacraft.common.registery.ModAttributesClass;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

import static com.nukateam.nukacraft.common.events.RadiationTracker.radiationTrackers;

@Mod.EventBusSubscriber
public class CustomHandler {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event){
        var entity = event.getEntity();
        if (entity instanceof Player player) {
            var rad = player.getAttribute(ModAttributesClass.RADIATION.get());
            rad.setBaseValue(0);

            for (var mod: rad.getModifiers()) {
                if (mod.getName().equals("radiation")){
                    rad.removeModifier(mod);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event) {
        radiationTrackers.values().forEach((val) -> {
            if(val.player == event.player)
                val.onPlayerTick(event);
        });
    }
}