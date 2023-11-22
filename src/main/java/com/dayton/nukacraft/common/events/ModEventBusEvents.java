package com.dayton.nukacraft.common.events;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.render.particles.GammaParticles;
import com.dayton.nukacraft.client.render.particles.MushroomCloudParticle;
import com.dayton.nukacraft.client.render.particles.SmallExplosionParticle;
import com.dayton.nukacraft.common.registery.ModParticles;
import com.dayton.nukacraft.common.foundation.entities.*;
import com.dayton.nukacraft.common.network.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static com.dayton.nukacraft.common.registery.ModParticles.*;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        var engine = Minecraft.getInstance().particleEngine;
        engine.register(ModParticles.GAMMA_PARTICLE.get(), GammaParticles.Provider::new);
        engine.register(MUSHROOM_CLOUD.get(), new MushroomCloudParticle.Factory());
        engine.register(MUSHROOM_CLOUD_SMOKE.get(), SmallExplosionParticle.NukeFactory::new);
        engine.register(MUSHROOM_CLOUD_EXPLOSION.get(), SmallExplosionParticle.NukeFactory::new);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.DEATHCLAW.get(), Deathclaw.createAttributes().build());
        event.put(EntityTypes.POWER_ARMOR_FRAME.get(), PowerArmorFrame.createAttributes().build());
        event.put(EntityTypes.RAIDER.get(), Raider.createAttributes().build());
    }

    @SubscribeEvent
    public static void setup(final FMLCommonSetupEvent event) {
        PacketHandler.register();
    }
}
