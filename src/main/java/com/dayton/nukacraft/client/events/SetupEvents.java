package com.dayton.nukacraft.client.events;

import com.dayton.nukacraft.*;
import com.dayton.nukacraft.client.render.renderers.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

import static com.dayton.nukacraft.common.foundation.entities.EntityTypes.*;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SetupEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent()
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(DEATHCLAW.get(), DeathclawRenderer::new);
        event.registerEntityRenderer(POWER_ARMOR_FRAME.get(), PowerArmorRenderer::new);
        event.registerEntityRenderer(NUCLEAR_EXPLOSION.get(), NuclearExplosionRenderer::new);
    }
}
