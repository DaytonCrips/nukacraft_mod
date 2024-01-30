package com.nukateam.nukacraft.common.events;

import com.nukateam.nukacraft.common.data.utils.RadiationUtils;
import com.nukateam.nukacraft.common.foundation.blocks.blocks.RadioactiveBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class RadiationTracker {
    private final Player player;
    private int counter = 10;
    public static final Map<Player, RadiationTracker> radiationTrackers = new HashMap<>();

    public RadiationTracker(Player player){
        this.player = player;
    }

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) {
        if(counter >= 0) {
            rareTick(event);
            counter = 10;
        }
        else counter--;
    }

    private void rareTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END || event.player != player) return;

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
