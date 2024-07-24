package com.nukateam.nukacraft.client.events;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.client.models.entity.BrahminModel;
import com.nukateam.nukacraft.client.render.gui.hud.PowerArmorHud;
import com.nukateam.nukacraft.client.render.particles.GammaParticles;
import com.nukateam.nukacraft.client.render.particles.MushroomCloudParticle;
import com.nukateam.nukacraft.client.render.particles.SmallExplosionParticle;
import com.nukateam.nukacraft.client.render.renderers.block.GearDoorRenderer;
import com.nukateam.nukacraft.client.render.renderers.block.OpenGearRenderer;
import com.nukateam.nukacraft.client.render.renderers.entity.*;
import com.nukateam.ntgl.client.render.renderers.projectiles.*;
import com.nukateam.nukacraft.common.data.constants.PipboyPages;
import com.nukateam.nukacraft.common.registery.ModParticles;
import com.nukateam.nukacraft.common.registery.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static com.nukateam.nukacraft.common.registery.EntityTypes.*;
import static com.nukateam.nukacraft.common.registery.ModParticles.*;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SetupEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        PipboyPages.init(PipboyPages.content);
    }

    @SubscribeEvent
    public static void registerHud(RegisterGuiOverlaysEvent event){
        event.registerAbove(new ResourceLocation("hotbar"), "power_armor_hud", PowerArmorHud.POWER_ARMOR_HUD);
    }

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        var particleEngine = Minecraft.getInstance().particleEngine;
        particleEngine.register(ModParticles.GAMMA_PARTICLE.get(), GammaParticles.Provider::new);
        particleEngine.register(MUSHROOM_CLOUD.get(), new MushroomCloudParticle.Factory());
        particleEngine.register(MUSHROOM_CLOUD_SMOKE.get(), SmallExplosionParticle.NukeFactory::new);
        particleEngine.register(MUSHROOM_CLOUD_EXPLOSION.get(), SmallExplosionParticle.NukeFactory::new);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent()
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(MININUKE.get(), MiniNukeRenderer::new);
        event.registerEntityRenderer(BASEBALL_GRENADE_ENTITY.get(), ThrowableGrenadeRenderer::new);
        event.registerEntityRenderer(POWER_ARMOR_FRAME.get(), PowerArmorRenderer::new);
        event.registerEntityRenderer(NUCLEAR_EXPLOSION.get(), EmptyRenderer::new);
        event.registerEntityRenderer(NUCLEAR_EXPLOSION_EFFECT.get(), NuclearExplosionRenderer::new);
        event.registerEntityRenderer(CHAIRENTITY.get(), (context) -> new ChairEntityRenderer(context));

        event.registerEntityRenderer(DEATHCLAW.get(), DeathclawRenderer::new);
        event.registerEntityRenderer(RAIDER.get(), RaiderRenderer::new);
        event.registerEntityRenderer(RADROACH.get(), (context) -> new SimpleEntityRenderer<>(context).setScale(3));
        event.registerEntityRenderer(BRAHMIN.get(), (context) -> new SimpleEntityRenderer<>(context, new BrahminModel()));
        event.registerEntityRenderer(BLOATFLY.get(), SimpleEntityRenderer::new);
        event.registerEntityRenderer(MOLERAT.get(), SimpleEntityRenderer::new);

        event.registerBlockEntityRenderer(ModTileEntities.GEARDOOR_ENTITY.get(), (context) -> new GearDoorRenderer());
        event.registerBlockEntityRenderer(ModTileEntities.OPENGEAR_ENTITY.get(), (context) -> new OpenGearRenderer());
    }

}
