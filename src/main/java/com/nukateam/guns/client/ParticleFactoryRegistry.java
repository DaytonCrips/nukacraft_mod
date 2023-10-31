package com.nukateam.guns.client;

import com.nukateam.guns.client.particle.BloodParticle;
import com.nukateam.guns.client.particle.BulletHoleParticle;
import com.nukateam.guns.client.particle.TrailParticle;
import com.nukateam.guns.common.foundation.init.ModParticleTypes;
import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleFactoryRegistry {
    @SubscribeEvent
    public static void onRegisterParticleFactory(ParticleFactoryRegisterEvent event) {
        ParticleEngine particleManager = Minecraft.getInstance().particleEngine;
        particleManager.register(ModParticleTypes.BULLET_HOLE.get(),
                (typeIn, worldIn, x, y, z, xSpeed, ySpeed, zSpeed) ->
                        new BulletHoleParticle(worldIn, x, y, z, typeIn.getDirection(), typeIn.getPos()));
        particleManager.register(ModParticleTypes.BLOOD.get(), BloodParticle.Factory::new);
        particleManager.register(ModParticleTypes.TRAIL.get(), TrailParticle.Factory::new);
    }
}
