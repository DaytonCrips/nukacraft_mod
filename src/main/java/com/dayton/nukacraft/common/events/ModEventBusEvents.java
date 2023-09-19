package com.dayton.nukacraft.common.events;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.client.particles.GammaParticles;
import com.dayton.nukacraft.client.particles.ModParticles;
import com.dayton.nukacraft.common.entities.Deathclaw;
import com.dayton.nukacraft.common.entities.EntityTypes;
import com.dayton.nukacraft.common.entities.PowerArmorFrame;
import com.dayton.nukacraft.common.network.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.GAMMA_PARTICLE.get(), GammaParticles.Provider::new);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.DEATHCLAW.get(), Deathclaw.createAttributes().build());
        event.put(EntityTypes.POWER_ARMOR_FRAME.get(), PowerArmorFrame.createAttributes().build());
    }

    @SubscribeEvent
    public static void setup(final FMLCommonSetupEvent event) {
        PacketHandler.register();
    }
}
