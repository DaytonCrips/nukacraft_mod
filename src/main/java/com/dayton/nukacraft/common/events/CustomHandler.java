package com.dayton.nukacraft.common.events;

import com.jetug.chassis_core.ChassisCore;
import com.jetug.chassis_core.common.events.ContainerChangedEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static java.lang.System.out;

@Mod.EventBusSubscriber(modid = ChassisCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CustomHandler {
    @SubscribeEvent
    public static void pickup(PlayerEvent.ItemPickupEvent event) {
        var stack = event.getStack();
        var tag = stack.getOrCreateTag();
        tag .putString("variant", "rust");

        stack.setTag(tag);
    }
}