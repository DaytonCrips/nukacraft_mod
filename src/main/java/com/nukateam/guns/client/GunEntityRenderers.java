package com.nukateam.guns.client;

import com.nukateam.guns.client.render.entity.GrenadeRenderer;
import com.nukateam.guns.client.render.entity.MissileRenderer;
import com.nukateam.guns.client.render.entity.ProjectileRenderer;
import com.nukateam.guns.client.render.entity.ThrowableGrenadeRenderer;
import com.nukateam.guns.common.foundation.init.ModEntities;
import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GunEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.PROJECTILE.get(), ProjectileRenderer::new);
        event.registerEntityRenderer(ModEntities.GRENADE.get(), GrenadeRenderer::new);
        event.registerEntityRenderer(ModEntities.MISSILE.get(), MissileRenderer::new);
        event.registerEntityRenderer(ModEntities.THROWABLE_GRENADE.get(), ThrowableGrenadeRenderer::new);
        event.registerEntityRenderer(ModEntities.THROWABLE_STUN_GRENADE.get(), ThrowableGrenadeRenderer::new);
    }
}
