package com.nukateam.map.impl.atlas.structure;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;

import java.util.function.Consumer;

public interface StructureAddedCallback {
    public static void register(StructureAddedCallback consumer) {
        MinecraftForge.EVENT_BUS.addListener((Consumer<TheEvent>) event -> consumer.onStructureAdded(event.getStructureStart(), event.getWorld()));
    }

    void onStructureAdded(StructureStart structureStart, ServerLevel world);

    /**
     * @author Stereowalker
     */
    public class TheEvent extends Event {
        private final StructureStart structureStart;
        private final ServerLevel world;

        public TheEvent(StructureStart structureStart, ServerLevel world) {
            this.structureStart = structureStart;
            this.world = world;
        }

        public StructureStart getStructureStart() {
            return structureStart;
        }

        public ServerLevel getWorld() {
            return world;
        }

    }

}
