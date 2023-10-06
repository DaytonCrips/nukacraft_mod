package com.dayton.nukacraft.client.events;

import com.dayton.nukacraft.*;
import com.dayton.nukacraft.client.renderers.DeathclawRenderer;
import com.dayton.nukacraft.client.renderers.PowerArmorRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.dayton.nukacraft.common.foundation.entities.EntityTypes.DEATHCLAW;
import static com.dayton.nukacraft.common.foundation.entities.EntityTypes.POWER_ARMOR_FRAME;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SetupEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent()
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(DEATHCLAW.get(), DeathclawRenderer::new);
        event.registerEntityRenderer(POWER_ARMOR_FRAME.get(), PowerArmorRenderer::new);
    }
}
