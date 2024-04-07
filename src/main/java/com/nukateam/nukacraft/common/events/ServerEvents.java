package com.nukateam.nukacraft.common.events;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.nukateam.nukacraft.common.events.RadiationTracker.radiationTrackers;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID)
public class ServerEvents {
    @SubscribeEvent
    public static void onPlayerTick(PlayerEvent.PlayerLoggedInEvent event) {
        var server = event.getEntity().getServer();
        var player = event.getEntity();
        if (server != null) {
            server.execute(() -> radiationTrackers.put(player, new RadiationTracker(player)));
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerEvent.PlayerLoggedOutEvent event) {
        var server = event.getEntity().getServer();
        if (server != null) {
            server.execute(() -> radiationTrackers.remove(event.getEntity()));
        }
    }

}
