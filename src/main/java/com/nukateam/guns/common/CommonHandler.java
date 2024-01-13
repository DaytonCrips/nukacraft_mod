package com.nukateam.guns.common;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

import static com.nukateam.guns.client.handler.ShootingHandler.*;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.DEDICATED_SERVER)
public class CommonHandler {
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
//        if (event.phase != TickEvent.Phase.END) return;
//
//        var remove = new ArrayList<ItemStack>();
//
//        for (var stack : gunCooldown) {
//            var tag =  stack.getOrCreateTag();
//            var cool = tag.getInt("Cooldown");
//            if(cool > 0)
//                tag.putInt("Cooldown", --cool);
//            else remove.add(stack);
//        }
//        gunCooldown.removeAll(remove);
    }
}