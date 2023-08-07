package com.dayton.nukacraft;

import com.dayton.nukacraft.common.effects.ModAttributesClass;
import com.dayton.nukacraft.common.effects.ModEffect;
import com.dayton.nukacraft.common.entities.EntityTypes;
import com.dayton.nukacraft.common.network.PacketHandler;
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

import static com.dayton.nukacraft.common.blocks.ModBlocksClass.*;
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
        register(eventBus);
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
        setupRenderLayers();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        //PacketHandler.register();
        event.enqueueWork(ModBiomeGeneration::generateBiomes);
        registerPlants();

        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private static void setupRenderLayers() {
        setRenderLayer(CRACKBERRY_BUSH.get(), RenderType.cutout());
        setRenderLayer(BLOODLEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(BBLOODLEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(GLOW_GRASS.get(), RenderType.cutout());
        setRenderLayer(ASTER.get(), RenderType.cutout());
        setRenderLayer(POTTED_ASTER.get(), RenderType.cutout());
        setRenderLayer(RADASTER.get(), RenderType.cutout());
        setRenderLayer(POTTED_RADASTER.get(), RenderType.cutout());
        setRenderLayer(POTTED_DEATH_FLOWER.get(), RenderType.cutout());
        setRenderLayer(DEATH_PLANT.get(), RenderType.cutout());
        setRenderLayer(DEATH_FLOWER.get(), RenderType.cutout());
        setRenderLayer(FIREMUSHROOM.get(), RenderType.cutout());
        setRenderLayer(POTTED_FIREMUSHROOM.get(), RenderType.cutout());
        setRenderLayer(BLASTCAP.get(), RenderType.cutout());
        setRenderLayer(POTTED_BLASTCAP.get(), RenderType.cutout());
        setRenderLayer(ASHROSE.get(), RenderType.cutout());
        setRenderLayer(POTTED_ASHROSE.get(), RenderType.cutout());
        setRenderLayer(RADROSE.get(), RenderType.cutout());
        setRenderLayer(POTTED_RADROSE.get(), RenderType.cutout());
        setRenderLayer(FEVERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(POTTED_FEVERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(BOOMBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(POTTED_BOOMBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(SOOTFLOWER.get(), RenderType.cutout());
        setRenderLayer(POTTED_SOOTFLOWER.get(), RenderType.cutout());
        setRenderLayer(GEIGERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(POTTED_GEIGERBLOSSOM.get(), RenderType.cutout());
        setRenderLayer(ASHGRASS.get(), RenderType.cutout());
        setRenderLayer(CRANBERRY_GRASS.get(), RenderType.cutout());
        setRenderLayer(THISTLE.get(), RenderType.cutout());
        setRenderLayer(GAMMALEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(QUANTUMLEAF_BUSH.get(), RenderType.cutout());
        setRenderLayer(BOMBBERRY_BUSH.get(), RenderType.cutout());
        setRenderLayer(MUTTFRUIT_BUSH.get(), RenderType.cutout());
        setRenderLayer(FUSFRUIT_BUSH.get(), RenderType.cutout());
        setRenderLayer(SITTBEAN_BUSH.get(), RenderType.cutout());
        setRenderLayer(NEUTRON_BUSH.get(), RenderType.cutout());
        setRenderLayer(WILDTATO.get(), RenderType.cutout());
        setRenderLayer(CRANBERRY.get(), RenderType.cutout());
        setRenderLayer(STARBERRY.get(), RenderType.cutout());
        setRenderLayer(GUTSHROOM.get(), RenderType.cutout());
        setRenderLayer(POTTED_GUTSHROOM.get(), RenderType.cutout());
        setRenderLayer(BBLIGHT.get(), RenderType.cutout());
        setRenderLayer(POTTED_BBLIGHT.get(), RenderType.cutout());
        setRenderLayer(GOLD_CRANBERRY.get(), RenderType.cutout());
        setRenderLayer(GIGAWHEAT.get(), RenderType.cutout());
        setRenderLayer(BRAINFUNGUS.get(), RenderType.cutout());
        setRenderLayer(ZANDER.get(), RenderType.cutout());
        setRenderLayer(MINDFUNGUS.get(), RenderType.cutout());
        setRenderLayer(GLOWFUNGUS.get(), RenderType.cutout());
        setRenderLayer(MUTTSHOOTFUNGUS.get(), RenderType.cutout());
        setRenderLayer(HOLLYHOCK.get(), RenderType.cutout());
        setRenderLayer(MARYGOLD.get(), RenderType.cutout());
        setRenderLayer(POTTED_MARYGOLD.get(), RenderType.cutout());
        setRenderLayer(DATURAN.get(), RenderType.cutout());
        setRenderLayer(AGAVE.get(), RenderType.cutout());
        setRenderLayer(PUNGA.get(), RenderType.cutout());
        setRenderLayer(NEOAGAVE.get(), RenderType.cutout());
        setRenderLayer(GINSENG.get(), RenderType.cutout());
        setRenderLayer(NUKAROOT.get(), RenderType.cutout());
        setRenderLayer(CORALLEAF.get(), RenderType.cutout());
        setRenderLayer(PRISMLEAF.get(), RenderType.cutout());
        setRenderLayer(BROC.get(), RenderType.cutout());
        setRenderLayer(INVERT.get(), RenderType.cutout());
        setRenderLayer(POTTED_BROC.get(), RenderType.cutout());
        setRenderLayer(POTTED_INVERT.get(), RenderType.cutout());
    }

    private void registerPlants() {
        addPlant(ASTER.getId(), POTTED_ASTER);
        addPlant(RADASTER.getId(), POTTED_RADASTER);
        addPlant(DEATH_FLOWER.getId(), POTTED_DEATH_FLOWER);
        addPlant(FIREMUSHROOM.getId(), POTTED_FIREMUSHROOM);
        addPlant(BLASTCAP.getId(), POTTED_BLASTCAP);
        addPlant(ASHROSE.getId(), POTTED_ASHROSE);
        addPlant(RADROSE.getId(), POTTED_RADROSE);
        addPlant(FEVERBLOSSOM.getId(), POTTED_FEVERBLOSSOM);
        addPlant(BOOMBLOSSOM.getId(), POTTED_BOOMBLOSSOM);
        addPlant(SOOTFLOWER.getId(), POTTED_SOOTFLOWER);
        addPlant(GEIGERBLOSSOM.getId(), POTTED_GEIGERBLOSSOM);
        addPlant(GUTSHROOM.getId(), POTTED_GUTSHROOM);
        addPlant(BBLIGHT.getId(), POTTED_BBLIGHT);
        addPlant(MARYGOLD.getId(), POTTED_MARYGOLD);
        addPlant(BROC.getId(), POTTED_BROC);
        addPlant(INVERT.getId(), POTTED_INVERT);
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
