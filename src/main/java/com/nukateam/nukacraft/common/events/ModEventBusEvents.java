package com.nukateam.nukacraft.common.events;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.client.render.particles.GammaParticles;
import com.nukateam.nukacraft.client.render.particles.MushroomCloudParticle;
import com.nukateam.nukacraft.client.render.particles.SmallExplosionParticle;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import com.nukateam.nukacraft.common.registery.ModParticles;
import com.nukateam.nukacraft.common.foundation.entities.*;
import com.nukateam.nukacraft.common.network.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static com.nukateam.nukacraft.common.registery.ModParticles.*;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.DEATHCLAW.get(), Deathclaw.createAttributes().build());
        event.put(EntityTypes.POWER_ARMOR_FRAME.get(), PowerArmorFrame.createAttributes().build());
        event.put(EntityTypes.RAIDER.get(), Raider.createAttributes().build());
        event.put(EntityTypes.RADROACH.get(), Radroach.createAttributes().build());
        event.put(EntityTypes.BRAHMIN.get(), Brahmin.createAttributes().build());
        event.put(EntityTypes.BLOATFLY.get(), Bloatfly.createAttributes().build());
    }
}
