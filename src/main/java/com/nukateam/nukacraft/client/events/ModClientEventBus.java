package com.nukateam.nukacraft.client.events;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEventBus {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
//        GeoArmorRenderer.registerArmorRenderer(WoodenArmorItem.class, WoodenArmorRenderer::new);
    }
}
