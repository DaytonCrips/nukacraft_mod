package com.nukateam.nukacraft.common.foundation.goals;

import com.nukateam.ntgl.Ntgl;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Ntgl.MOD_ID)
public class EntityReloadTracker {
    private static Map<LivingEntity, EntityReloadTracker> RELOAD_TRACKER_MAP = new HashMap<>();

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        try {
            if (event.phase == TickEvent.Phase.START) {
                for (var entity: RELOAD_TRACKER_MAP.keySet()) {
                    if(entity instanceof Player) continue;
//                    handTick(entity);
                }
            }
        }
        catch (Exception e){
            Ntgl.LOGGER.error(e.getMessage(), e);
        }
    }
}
