package com.dayton.nukacraft.guns.client;

import com.dayton.nukacraft.guns.Reference;
import com.dayton.nukacraft.guns.client.particle.BloodParticle;
import com.dayton.nukacraft.guns.client.particle.BulletHoleParticle;
import com.dayton.nukacraft.guns.client.particle.TrailParticle;
import com.dayton.nukacraft.guns.init.ModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Author: MrCrayfish
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleFactoryRegistry
{
    @SubscribeEvent
    public static void onRegisterParticleFactory(ParticleFactoryRegisterEvent event)
    {
        ParticleEngine particleManager = Minecraft.getInstance().particleEngine;
        particleManager.register(ModParticleTypes.BULLET_HOLE.get(),
                (typeIn, worldIn, x, y, z, xSpeed, ySpeed, zSpeed) ->
                        new BulletHoleParticle(worldIn, x, y, z, typeIn.getDirection(), typeIn.getPos()));
        particleManager.register(ModParticleTypes.BLOOD.get(), BloodParticle.Factory::new);
        particleManager.register(ModParticleTypes.TRAIL.get(), TrailParticle.Factory::new);
    }
}
