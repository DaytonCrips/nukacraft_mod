package com.nukateam.nukacraft.client.events;


import com.nukateam.guns.common.foundation.init.ModTileEntities;
import com.nukateam.nukacraft.*;
import com.nukateam.nukacraft.client.KeyBindings;
import com.nukateam.nukacraft.client.models.entity.geo.BrahminModel;
import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoy;
import com.nukateam.nukacraft.client.render.particles.GammaParticles;
import com.nukateam.nukacraft.client.render.particles.MushroomCloudParticle;
import com.nukateam.nukacraft.client.render.particles.SmallExplosionParticle;
import com.nukateam.nukacraft.client.render.renderers.geo.block.GearDoorRenderer;
import com.nukateam.nukacraft.client.render.renderers.geo.block.OpenGearRenderer;
import com.nukateam.nukacraft.client.render.renderers.geo.entity.DeathclawRenderer;
import com.nukateam.nukacraft.client.render.renderers.geo.entity.NuclearExplosionRenderer;
import com.nukateam.nukacraft.client.render.renderers.geo.entity.PowerArmorRenderer;
import com.nukateam.nukacraft.client.render.renderers.geo.entity.SimpleEntityRenderer;
import com.nukateam.nukacraft.client.render.renderers.vanilla.EmptyRenderer;
import com.nukateam.nukacraft.client.render.renderers.vanilla.MiniNukeRenderer;
import com.nukateam.nukacraft.client.render.renderers.vanilla.RaiderRenderer;
import com.nukateam.nukacraft.common.registery.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static com.nukateam.map.impl.atlas.MapCore.initMap;
import static com.nukateam.nukacraft.common.registery.EntityTypes.*;
import static com.nukateam.nukacraft.common.registery.ModParticles.*;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SetupEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        initMap();
        KeyBindings.register();
        ModSetup.renderTypeSetup();
        PipBoy pipBoy = new PipBoy();
        pipBoy.init();
    }

//    @SubscribeEvent
//    public static void clientSetup(final FMLClientSetupEvent event) {
//
//        //ClientConfig.setup();
//    }

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        var particleEngine = Minecraft.getInstance().particleEngine;
        particleEngine.register(ModParticles.GAMMA_PARTICLE.get(), GammaParticles.Provider::new);
        particleEngine.register(MUSHROOM_CLOUD.get(), new MushroomCloudParticle.Factory());
        particleEngine.register(MUSHROOM_CLOUD_SMOKE.get(), SmallExplosionParticle.NukeFactory::new);
        particleEngine.register(MUSHROOM_CLOUD_EXPLOSION.get(), SmallExplosionParticle.NukeFactory::new);
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
        event.registerEntityRenderer(RADROACH.get(), (context) -> new SimpleEntityRenderer<>(context).setScale(3));
        event.registerEntityRenderer(BRAHMIN.get(), (context) -> new SimpleEntityRenderer<>(context, new BrahminModel()));
        event.registerEntityRenderer(BLOATFLY.get(), SimpleEntityRenderer::new);
        event.registerBlockEntityRenderer(ModTileEntities.GEARDOOR_ENTITY.get(), (context) -> new GearDoorRenderer());
        event.registerBlockEntityRenderer(ModTileEntities.OPENGEAR_ENTITY.get(), (context) -> new OpenGearRenderer());
    }

}
