package com.dayton.nukacraft.common.events;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.entities.armors.WoodenArmorRenderer;
import com.dayton.nukacraft.common.items.custom.armor.WoodenArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.example.client.renderer.armor.GeckoArmorRenderer;
import software.bernie.example.item.GeckoArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEventBus {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(WoodenArmorItem.class, WoodenArmorRenderer::new);
    }
}
