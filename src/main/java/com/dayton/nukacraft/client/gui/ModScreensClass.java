package com.dayton.nukacraft.client.gui;

import com.dayton.nukacraft.client.gui.pipboy.PipBoyScreen;
import com.dayton.nukacraft.common.container.GuiRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModScreensClass {
    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        GuiRegistry.register();
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenuClass.PIPBOY, PipBoyScreen::new);
        });
    }
}
