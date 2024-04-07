package com.nukateam.map.impl.atlas.common.events;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
//        initMapCommon();
//        initMapClient();
    }
}
