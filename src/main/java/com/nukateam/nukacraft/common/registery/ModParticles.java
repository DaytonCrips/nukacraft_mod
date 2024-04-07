package com.nukateam.nukacraft.common.registery;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, NukaCraftMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> GAMMA_PARTICLE =
            PARTICLE_TYPES.register("gamma_particles", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> MUSHROOM_CLOUD
            = PARTICLE_TYPES.register("mushroom_cloud", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> MUSHROOM_CLOUD_SMOKE =
            PARTICLE_TYPES.register("mushroom_cloud_smoke", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MUSHROOM_CLOUD_EXPLOSION =
            PARTICLE_TYPES.register("mushroom_cloud_explosion", () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
