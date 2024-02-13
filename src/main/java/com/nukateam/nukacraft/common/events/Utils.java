package com.nukateam.nukacraft.common.events;

import com.nukateam.nukacraft.common.registery.ModAttributes;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Utils {
    @SubscribeEvent
    public static void persistAttributes(PlayerEvent.Clone event) {
        Player oldPlayer = event.getOriginal();
        Player newPlayer = (Player) event.getEntity();
        newPlayer.getAttribute(ModAttributes.RADIATION.get())
                .setBaseValue(oldPlayer.getAttribute(ModAttributes.RADIATION.get()).getBaseValue());
        newPlayer.getAttribute(Attributes.MAX_HEALTH)
                .setBaseValue(oldPlayer.getAttribute(Attributes.MAX_HEALTH).getBaseValue());
    }
}
