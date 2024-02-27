package com.nukateam.nukacraft.common.events;

import com.nukateam.gunscore.client.data.handler.AimingHandler;
import com.nukateam.nukacraft.common.data.utils.RadiationUtils;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.RadioactiveBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;

import java.util.HashMap;
import java.util.Map;

public class RadiationTracker {
    public static final int COUNTER = 10;
    public final Player player;
    private int counter = COUNTER;
    public static final Map<Player, RadiationTracker> radiationTrackers = new HashMap<>();

    public RadiationTracker(Player player){
        this.player = player;
    }

    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START)
            return;

        if(counter <= 0) {
            rareTick(event);
            counter = COUNTER;
        }
        else counter--;
    }

    private void rareTick(TickEvent.PlayerTickEvent event) {
        if (event.player != player) return;

        var level = event.player.level;
        var bounding = player.getBoundingBox().inflate(10);
        var blocks = BlockPos.betweenClosedStream(bounding);

        blocks.forEach((blockPos) -> {
            var block = level.getBlockState(blockPos).getBlock();
            if(block instanceof RadioactiveBlock radioactiveBlock){
                RadiationUtils.addRadiation(player, radioactiveBlock.getRadiation());
            }
        } );
    }
}
