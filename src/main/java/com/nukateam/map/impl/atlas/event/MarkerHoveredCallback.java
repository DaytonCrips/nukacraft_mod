package com.nukateam.map.impl.atlas.event;

import com.nukateam.map.impl.atlas.marker.Marker;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;

import java.util.function.Consumer;

@FunctionalInterface
public interface MarkerHoveredCallback {
    public static void register(MarkerHoveredCallback consumer) {
        MinecraftForge.EVENT_BUS.addListener((Consumer<TheEvent>) event -> consumer.onHovered(event.getPlayer(), event.getMarker()));
    }

    void onHovered(Player player, Marker marker);

    public class TheEvent extends PlayerEvent {
        Marker marker;

        public TheEvent(Player player, Marker marker) {
            super(player);
            this.marker = marker;
        }

        public Marker getMarker() {
            return marker;
        }
    }
}
