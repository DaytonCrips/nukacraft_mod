package com.nukateam.nukacraft.client.events;

import com.nukateam.nukacraft.*;
import com.nukateam.nukacraft.client.render.renderers.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

import static com.nukateam.nukacraft.common.foundation.entities.EntityTypes.*;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SetupEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent()
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(MININUKE.get(), MiniNukeRenderer::new);
        event.registerEntityRenderer(DEATHCLAW.get(), DeathclawRenderer::new);
        event.registerEntityRenderer(POWER_ARMOR_FRAME.get(), PowerArmorRenderer::new);
        event.registerEntityRenderer(NUCLEAR_EXPLOSION.get(), EmptyRenderer::new);
        event.registerEntityRenderer(NUCLEAR_EXPLOSION_EFFECT.get(), NuclearExplosionRenderer::new);
        event.registerEntityRenderer(RAIDER.get(), RaiderRenderer::new);
    }
}
