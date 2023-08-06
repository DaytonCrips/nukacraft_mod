package com.dayton.nukacraft;

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

        eventBus.addListener(this::clientSetup);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLCommonSetupEvent event) {
        setRenderLayer(ModBlocksClass.CRACKBERRY_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.BLOODLEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.BBLOODLEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.GLOW_GRASS.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.ASTER.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_ASTER.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.RADASTER.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_RADASTER.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_DEATH_FLOWER.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.DEATH_PLANT.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.DEATH_FLOWER.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.FIREMUSHROOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_FIREMUSHROOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.BLASTCAP.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_BLASTCAP.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.ASHROSE.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_ASHROSE.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.RADROSE.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_RADROSE.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.FEVERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_FEVERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.BOOMBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_BOOMBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.SOOTFLOWER.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_SOOTFLOWER.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.GEIGERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_GEIGERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.ASHGRASS.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.CRANBERRY_GRASS.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.THISTLE.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.GAMMALEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.QUANTUMLEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.BOMBBERRY_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.MUTTFRUIT_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.FUSFRUIT_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.SITTBEAN_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.NEUTRON_BUSH.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.WILDTATO.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.CRANBERRY.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.STARBERRY.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.GUTSHROOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_GUTSHROOM.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.BBLIGHT.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_BBLIGHT.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.GOLD_CRANBERRY.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.GIGAWHEAT.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.BRAINFUNGUS.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.ZANDER.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.MINDFUNGUS.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.GLOWFUNGUS.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.MUTTSHOOTFUNGUS.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.HOLLYHOCK.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.MARYGOLD.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_MARYGOLD.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.DATURAN.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.AGAVE.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.PUNGA.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.NEOAGAVE.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.GINSENG.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.NUKAROOT.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.CORALLEAF.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.PRISMLEAF.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.BROC.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.INVERT.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_BROC.get(), RenderType.cutout());
        setRenderLayer(ModBlocksClass.POTTED_INVERT.get(), RenderType.cutout());

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(ModBiomeGeneration::generateBiomes);
        addPlant(ModBlocksClass.ASTER.getId(), ModBlocksClass.POTTED_ASTER);
        addPlant(ModBlocksClass.RADASTER.getId(), ModBlocksClass.POTTED_RADASTER);
        addPlant(ModBlocksClass.DEATH_FLOWER.getId(), ModBlocksClass.POTTED_DEATH_FLOWER);
        addPlant(ModBlocksClass.FIREMUSHROOM.getId(), ModBlocksClass.POTTED_FIREMUSHROOM);
        addPlant(ModBlocksClass.BLASTCAP.getId(), ModBlocksClass.POTTED_BLASTCAP);
        addPlant(ModBlocksClass.ASHROSE.getId(), ModBlocksClass.POTTED_ASHROSE);
        addPlant(ModBlocksClass.RADROSE.getId(), ModBlocksClass.POTTED_RADROSE);
        addPlant(ModBlocksClass.FEVERBLOSSOM.getId(), ModBlocksClass.POTTED_FEVERBLOSSOM);
        addPlant(ModBlocksClass.BOOMBLOSSOM.getId(), ModBlocksClass.POTTED_BOOMBLOSSOM);
        addPlant(ModBlocksClass.SOOTFLOWER.getId(), ModBlocksClass.POTTED_SOOTFLOWER);
        addPlant(ModBlocksClass.GEIGERBLOSSOM.getId(), ModBlocksClass.POTTED_GEIGERBLOSSOM);
        addPlant(ModBlocksClass.GUTSHROOM.getId(), ModBlocksClass.POTTED_GUTSHROOM);
        addPlant(ModBlocksClass.BBLIGHT.getId(), ModBlocksClass.POTTED_BBLIGHT);
        addPlant(ModBlocksClass.MARYGOLD.getId(), ModBlocksClass.POTTED_MARYGOLD);
        addPlant(ModBlocksClass.BROC.getId(), ModBlocksClass.POTTED_BROC);
        addPlant(ModBlocksClass.INVERT.getId(), ModBlocksClass.POTTED_INVERT);

        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void addPlant(ResourceLocation resourceLocation, RegistryObject<Block> registryObject){
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(resourceLocation, registryObject);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
    }

    private void processIMC(final InterModProcessEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }


    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
        }
    }
}
