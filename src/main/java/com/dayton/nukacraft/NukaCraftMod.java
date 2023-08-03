package com.dayton.nukacraft;

import com.dayton.nukacraft.server.effects.ModAttributesClass;
import com.dayton.nukacraft.server.effects.ModEffect;
import com.dayton.nukacraft.common.world.ModBiomeGeneration;
import com.dayton.nukacraft.common.world.ModBiomes;
import com.dayton.nukacraft.common.blocks.ModBlocksClass;
import com.dayton.nukacraft.common.gui.RadiationHudOverlay;
import com.dayton.nukacraft.common.items.ModItemsClass;
import com.dayton.nukacraft.common.particles.ModParticles;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
import org.slf4j.Logger;
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
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        ModItemsClass.register(eventBus);
        ModEffect.register(eventBus);
        ModAttributesClass.register(eventBus);
        ModBlocksClass.register(eventBus);
        ModBiomes.register(eventBus);
        ModParticles.register(eventBus);
        RadiationHudOverlay.register();


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
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.CRACKBERRY_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.BLOODLEAF_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.BBLOODLEAF_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.GLOW_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.ASTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_ASTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.RADASTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_RADASTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_DEATH_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.DEATH_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.DEATH_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.FIREMUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_FIREMUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.BLASTCAP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_BLASTCAP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.ASHROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_ASHROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.RADROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_RADROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.FEVERBLOSSOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_FEVERBLOSSOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.BOOMBLOSSOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_BOOMBLOSSOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.SOOTFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_SOOTFLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.GEIGERBLOSSOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_GEIGERBLOSSOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.ASHGRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.CRANBERRY_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.THISTLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.GAMMALEAF_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.QUANTUMLEAF_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.BOMBBERRY_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.MUTTFRUIT_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.FUSFRUIT_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.SITTBEAN_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.NEUTRON_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.WILDTATO.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.CRANBERRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.STARBERRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.GUTSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_GUTSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.BBLIGHT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_BBLIGHT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.GOLD_CRANBERRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.GIGAWHEAT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.BRAINFUNGUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.ZANDER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.MINDFUNGUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.GLOWFUNGUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.MUTTSHOOTFUNGUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.HOLLYHOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.MARYGOLD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.POTTED_MARYGOLD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.DATURAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.AGAVE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.PUNGA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.NEOAGAVE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocksClass.GINSENG.get(), RenderType.cutout());

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(ModBiomeGeneration::generateBiomes);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.ASTER.getId(), ModBlocksClass.POTTED_ASTER);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.RADASTER.getId(), ModBlocksClass.POTTED_RADASTER);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.DEATH_FLOWER.getId(), ModBlocksClass.POTTED_DEATH_FLOWER);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.FIREMUSHROOM.getId(), ModBlocksClass.POTTED_FIREMUSHROOM);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.BLASTCAP.getId(), ModBlocksClass.POTTED_BLASTCAP);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.ASHROSE.getId(), ModBlocksClass.POTTED_ASHROSE);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.RADROSE.getId(), ModBlocksClass.POTTED_RADROSE);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.FEVERBLOSSOM.getId(), ModBlocksClass.POTTED_FEVERBLOSSOM);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.BOOMBLOSSOM.getId(), ModBlocksClass.POTTED_BOOMBLOSSOM);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.SOOTFLOWER.getId(), ModBlocksClass.POTTED_SOOTFLOWER);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.GEIGERBLOSSOM.getId(), ModBlocksClass.POTTED_GEIGERBLOSSOM);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.GUTSHROOM.getId(), ModBlocksClass.POTTED_GUTSHROOM);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.BBLIGHT.getId(), ModBlocksClass.POTTED_BBLIGHT);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocksClass.MARYGOLD.getId(), ModBlocksClass.POTTED_MARYGOLD);


        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
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
