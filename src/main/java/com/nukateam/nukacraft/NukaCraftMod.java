package com.nukateam.nukacraft;


import com.nukateam.guns.GunMod;
import com.nukateam.guns.common.base.ProjectileManager;
import com.nukateam.nukacraft.client.render.gui.RadiationHudOverlay;
import com.nukateam.nukacraft.client.render.gui.pipboy.PipBoy;
import com.nukateam.nukacraft.common.registery.ACSoundRegistry;
import com.nukateam.nukacraft.common.registery.ModParticles;
import com.nukateam.nukacraft.common.foundation.blocks.ModBlocks;
import com.nukateam.nukacraft.common.foundation.container.ContainerRegistry;
import com.nukateam.nukacraft.common.foundation.effects.ModAttributesClass;
import com.nukateam.nukacraft.common.foundation.effects.ModEffect;
import com.nukateam.nukacraft.common.foundation.entities.EntityTypes;
import com.nukateam.nukacraft.common.foundation.entities.MiniNukeEntity;
import com.nukateam.nukacraft.common.foundation.items.ModArmorItems;
import com.nukateam.nukacraft.common.foundation.items.ModGuns;
import com.nukateam.nukacraft.common.foundation.items.ModItems;
import com.nukateam.nukacraft.common.foundation.items.PowerArmorItems;
import com.nukateam.nukacraft.common.registery.ModSounds;
import com.nukateam.nukacraft.common.foundation.world.ModBiomeGeneration;
import com.nukateam.nukacraft.common.foundation.world.ModBiomes;
import com.mojang.logging.LogUtils;
import mod.azure.azurelib.AzureLib;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.nukateam.map.impl.atlas.AntiqueAtlasMod.*;

//Приходит улитка в бар, а там java классы в нарды играют...

@Mod(NukaCraftMod.MOD_ID)
public class NukaCraftMod {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "nukacraft";
    public static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

    public NukaCraftMod() {
        AzureLib.initialize();

        //IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MOD_EVENT_BUS.addListener(this::setup);

        new GunMod().initGunMod(MOD_EVENT_BUS);
        initMap();

        ModItems.register(MOD_EVENT_BUS);
        PowerArmorItems.register(MOD_EVENT_BUS);
        ModArmorItems.register(MOD_EVENT_BUS);
        ModGuns.register(MOD_EVENT_BUS);

        ModEffect.register(MOD_EVENT_BUS);
        ModAttributesClass.register(MOD_EVENT_BUS);
        ModBlocks.register(MOD_EVENT_BUS);
        ModBiomes.register(MOD_EVENT_BUS);
        ModParticles.register(MOD_EVENT_BUS);
        RadiationHudOverlay.register();
        EntityTypes.register(MOD_EVENT_BUS);
        ModSounds.SOUNDS.register(MOD_EVENT_BUS);
        ContainerRegistry.register(MOD_EVENT_BUS);
        ACSoundRegistry.REGISTER.register(MOD_EVENT_BUS);

        MOD_EVENT_BUS.addListener(this::clientSetup);
        MOD_EVENT_BUS.addListener(this::onCommonSetup);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLCommonSetupEvent event) {
        ModSetup.renderTypeSetup();
        //ClientConfig.setup();
    }

    private void setup(final FMLCommonSetupEvent event) {
        PipBoy pipBoy = new PipBoy();
        pipBoy.init();
        event.enqueueWork(ModBiomeGeneration::generateBiomes);
        ModSetup.flowerPotSetup();
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ProjectileManager.getInstance().registerFactory(ModGuns.MININUKE.get(), (worldIn, entity, weapon, item, modifiedGun) -> new MiniNukeEntity(EntityTypes.MININUKE.get(), worldIn, entity, weapon, item, modifiedGun));
        });
    }
//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
//    }
//
//    private void processIMC(final InterModProcessEvent event)
//    {
//    }
//
//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event)
//    {
//    }


    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents
//    {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
//        {
//        }
//    }
}
