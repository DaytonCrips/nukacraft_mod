package com.dayton.nukacraft;


import com.dayton.nukacraft.client.gui.pipboy.PipBoy;
import com.dayton.nukacraft.common.container.ContainerRegistry;
import com.dayton.nukacraft.common.effects.ModAttributesClass;
import com.dayton.nukacraft.common.effects.ModEffect;
import com.dayton.nukacraft.common.entities.EntityTypes;
import com.dayton.nukacraft.common.world.ModBiomeGeneration;
import com.dayton.nukacraft.common.world.ModBiomes;
import com.dayton.nukacraft.common.blocks.ModBlocksClass;
import com.dayton.nukacraft.client.gui.RadiationHudOverlay;
import com.dayton.nukacraft.common.items.ModItemsClass;
import com.dayton.nukacraft.client.particles.ModParticles;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.client.renderer.ItemBlockRenderTypes.*;
//Приходит улитка в бар, а там java классы в нарды играют...

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NukaCraftMod.MOD_ID)
public class NukaCraftMod
{
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "nukacraft";

    public NukaCraftMod()
    {
        GeckoLib.initialize();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        ModItemsClass.register(eventBus);
        ModEffect.register(eventBus);
        ModAttributesClass.register(eventBus);
        ModBlocksClass.register(eventBus);
        ModBiomes.register(eventBus);
        ModParticles.register(eventBus);
        RadiationHudOverlay.register();
        EntityTypes.register(eventBus);
        ContainerRegistry.register(eventBus);

        eventBus.addListener(this::clientSetup);

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
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        PipBoy pipBoy = new PipBoy();
        pipBoy.init();
        event.enqueueWork(ModBiomeGeneration::generateBiomes);
        ModSetup.flowerPotSetup();
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
