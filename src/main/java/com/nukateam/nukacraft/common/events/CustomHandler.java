package com.nukateam.nukacraft.common.events;

import com.nukateam.nukacraft.common.registery.ModAttributes;
import com.nukateam.nukacraft.common.registery.ModFluids;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Function;

import static com.nukateam.nukacraft.common.events.RadiationTracker.radiationTrackers;

@Mod.EventBusSubscriber
public class CustomHandler {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event){
        var entity = event.getEntity();
        if (entity instanceof Player player) {
            var rad = player.getAttribute(ModAttributes.RADIATION.get());
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

    @SubscribeEvent
    public static void whenFluidsMeet(BlockEvent.FluidPlaceBlockEvent event) {
        var fluidState = event.getOriginalState().getFluidState();
//        if (fluidState.isSource() && FluidHelper.isLava(fluidState.getType()))
//            return;

        if(fluidState.isSource()){
            extracted(event, fluidState, (fluid) -> {
                var lavaInteraction = ModFluids.getLavaInteraction(fluid);
                if(lavaInteraction == null) return null;
                return lavaInteraction.getA();
            });
        }
        else {
            extracted(event, fluidState, (fluid) -> {
                var lavaInteraction = ModFluids.getLavaInteraction(fluid);
                if(lavaInteraction == null) return null;
                return lavaInteraction.getB();
            });
        }
    }

    private static void extracted(BlockEvent.FluidPlaceBlockEvent event, FluidState fluidState, Function<FluidState, Block> function) {
        var world = event.getWorld();
        var pos = event.getPos();

        for (var direction : Direction.values()) {
            var metFluidState = fluidState.isSource() ? fluidState : world.getFluidState(pos.relative(direction));
            if (metFluidState.is(FluidTags.WATER)) {
                var block = function.apply(metFluidState);
                if (block != null) {
                    event.setNewState(block.defaultBlockState());
                    break;
                }
            }
        }
    }
}