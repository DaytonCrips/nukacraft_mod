package com.nukateam.map.impl.atlas.common.events;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static com.nukateam.map.impl.atlas.MapCore.initMapClient;
import static com.nukateam.map.impl.atlas.MapCore.initMapCommon;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
//        initMapCommon();
//        initMapClient();
    }
}
