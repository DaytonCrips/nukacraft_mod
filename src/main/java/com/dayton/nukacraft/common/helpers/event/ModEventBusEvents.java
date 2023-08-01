package com.dayton.nukacraft.common.helpers.event;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.init.blocks.ModBlocksClass;
import com.dayton.nukacraft.init.blocks.custom.blocks.MutationFloraClass;
import com.dayton.nukacraft.init.items.ModItemsClass;
import com.dayton.nukacraft.init.particles.GammaParticles;
import com.dayton.nukacraft.init.particles.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.GAMMA_PARTICLE.get(), GammaParticles.Provider::new);
    }

}
