package com.nukateam.nukacraft.client.render.gui;

import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoyScreen;
import com.nukateam.nukacraft.common.foundation.container.GuiRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModScreensClass {
    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        GuiRegistry.register();
        event.enqueueWork(() -> MenuScreens.register(ModMenuClass.PIPBOY, PipBoyScreen::new));
    }
}
