package com.dayton.nukacraft.common.events;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.particles.GammaParticles;
import com.dayton.nukacraft.client.particles.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.GAMMA_PARTICLE.get(), GammaParticles.Provider::new);
    }

}