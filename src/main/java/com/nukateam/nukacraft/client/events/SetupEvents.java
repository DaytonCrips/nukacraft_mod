package com.nukateam.nukacraft.client.events;


import com.nukateam.nukacraft.*;
import com.nukateam.nukacraft.client.KeyBindings;
import com.nukateam.nukacraft.client.models.entity.BrahminModel;
import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoy;
import com.nukateam.nukacraft.client.render.particles.GammaParticles;
import com.nukateam.nukacraft.client.render.particles.MushroomCloudParticle;
import com.nukateam.nukacraft.client.render.particles.SmallExplosionParticle;
import com.nukateam.nukacraft.client.render.renderers.block.GearDoorRenderer;
import com.nukateam.nukacraft.client.render.renderers.block.OpenGearRenderer;
import com.nukateam.nukacraft.client.render.renderers.entity.*;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import com.nukateam.nukacraft.common.registery.ModFluids;
import com.nukateam.nukacraft.common.registery.ModParticles;
import com.nukateam.nukacraft.common.registery.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static com.nukateam.map.impl.atlas.MapCore.*;
import static com.nukateam.nukacraft.common.registery.EntityTypes.*;
import static com.nukateam.nukacraft.common.registery.ModParticles.*;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SetupEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        KeyBindings.register();
        ModSetup.renderTypeSetup();
        PipBoy pipBoy = new PipBoy();
        pipBoy.init();

        ItemBlockRenderTypes.setRenderLayer(ModFluids.ACID_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.ACID_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.ACID_FLOWING.get(), RenderType.translucent());
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
        event.registerEntityRenderer(EntityTypes.CHAIRENTITY.get(),(context) -> new ChairEntityRenderer(context));
        event.registerEntityRenderer(RADROACH.get(), (context) -> new SimpleEntityRenderer<>(context).setScale(3));
        event.registerEntityRenderer(BRAHMIN.get(), (context) -> new SimpleEntityRenderer<>(context, new BrahminModel()));
        event.registerEntityRenderer(BLOATFLY.get(), SimpleEntityRenderer::new);
        event.registerBlockEntityRenderer(ModTileEntities.GEARDOOR_ENTITY.get(), (context) -> new GearDoorRenderer());
        event.registerBlockEntityRenderer(ModTileEntities.OPENGEAR_ENTITY.get(), (context) -> new OpenGearRenderer());
    }

}
