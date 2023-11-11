package com.dayton.guns.common;

import com.dayton.nukacraft.NukaCraftMod;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

import static com.dayton.guns.client.handler.ShootingHandler.gunCooldown;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.DEDICATED_SERVER)
public class CommonHandler {

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        var remove = new ArrayList<ItemStack>();

        for (var item : gunCooldown) {
            var tag =  item.getOrCreateTag();
            var cool = tag.getInt("Cooldown");
            if(cool > 0)
                tag.putInt("Cooldown", --cool);
            else remove.add(item);
        }
        gunCooldown.removeAll(remove);
    }
}