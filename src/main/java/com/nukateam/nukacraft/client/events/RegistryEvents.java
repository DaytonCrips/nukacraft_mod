package com.nukateam.nukacraft.client.events;

import com.nukateam.gunscore.client.render.entity.ThrowableGrenadeRenderer;
import com.nukateam.gunscore.common.foundation.init.ModEntities;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.client.render.renderers.entity.MiniNukeRenderer;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypes.MININUKE.get(), MiniNukeRenderer::new);
        event.registerEntityRenderer(EntityTypes.BASEBALL_GRENADE_ENTITY.get(), ThrowableGrenadeRenderer::new);
    }
}

