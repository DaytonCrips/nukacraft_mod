package com.nukateam.map.impl.atlas.client.events;

import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import com.nukateam.nukacraft.*;

import static com.nukateam.map.impl.atlas.MapCore.initMapClient;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SetupEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        initMapClient();
    }
}
