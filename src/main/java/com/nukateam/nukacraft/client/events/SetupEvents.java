package com.nukateam.nukacraft.client.events;

import com.nukateam.nukacraft.*;
import com.nukateam.nukacraft.client.KeyBindings;
import com.nukateam.nukacraft.client.render.renderers.*;
import com.nukateam.nukacraft.client.render.renderers.geo.DeathclawRenderer;
import com.nukateam.nukacraft.client.render.renderers.geo.NuclearExplosionRenderer;
import com.nukateam.nukacraft.client.render.renderers.geo.PowerArmorRenderer;
import com.nukateam.nukacraft.client.render.renderers.geo.SimpleEntityRenderer;
import com.nukateam.nukacraft.common.foundation.entities.Radroach;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static com.nukateam.nukacraft.common.foundation.entities.EntityTypes.*;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SetupEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        KeyBindings.register();
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent()
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(MININUKE.get(), MiniNukeRenderer::new);
        event.registerEntityRenderer(DEATHCLAW.get(), DeathclawRenderer::new);
        event.registerEntityRenderer(POWER_ARMOR_FRAME.get(), PowerArmorRenderer::new);
        event.registerEntityRenderer(NUCLEAR_EXPLOSION.get(), EmptyRenderer::new);
        event.registerEntityRenderer(NUCLEAR_EXPLOSION_EFFECT.get(), NuclearExplosionRenderer::new);
        event.registerEntityRenderer(RAIDER.get(), RaiderRenderer::new);
        event.registerEntityRenderer(RADROACH.get(), (context) -> new SimpleEntityRenderer<>(context, 3));
    }
}
