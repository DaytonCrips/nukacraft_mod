package com.nukateam.nukacraft;


import com.nukateam.guns.GunMod;
import com.nukateam.guns.common.base.utils.ProjectileManager;
import com.nukateam.map.impl.atlas.network.AntiqueAtlasNetworking;
import com.nukateam.nukacraft.common.foundation.items.*;
import com.nukateam.nukacraft.common.foundation.world.structures.ModStructures;
import com.nukateam.nukacraft.common.registery.ACSoundRegistry;
import com.nukateam.nukacraft.common.registery.ModParticles;
import com.nukateam.nukacraft.common.foundation.blocks.ModBlocks;
import com.nukateam.nukacraft.common.foundation.container.ContainerRegistry;
import com.nukateam.nukacraft.common.foundation.effects.ModAttributesClass;
import com.nukateam.nukacraft.common.foundation.effects.ModEffect;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import com.nukateam.nukacraft.common.foundation.entities.MiniNukeEntity;
import com.nukateam.nukacraft.common.registery.ModSounds;
import com.nukateam.nukacraft.common.foundation.world.ModBiomeGeneration;
import com.nukateam.nukacraft.common.foundation.world.ModBiomes;
import com.mojang.logging.LogUtils;
import mod.azure.azurelib.AzureLib;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.nukateam.map.impl.atlas.MapCore.*;

//Приходит улитка в бар, а там java классы в нарды играют...

@Mod(NukaCraftMod.MOD_ID)
public class NukaCraftMod {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "nukacraft";
    public static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

    public NukaCraftMod() {
        AzureLib.initialize();

        //IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
//        MOD_EVENT_BUS.addListener(this::setup);

        new GunMod().initGunMod(MOD_EVENT_BUS);

        ModItems.register(MOD_EVENT_BUS);
        PowerArmorItems.register(MOD_EVENT_BUS);
        ModArmorItems.register(MOD_EVENT_BUS);
        ModGuns.register(MOD_EVENT_BUS);
        ModEffect.register(MOD_EVENT_BUS);
        ModAttributesClass.register(MOD_EVENT_BUS);
        ModBlocks.register(MOD_EVENT_BUS);
        ModBiomes.register(MOD_EVENT_BUS);
        ModMelee.register(MOD_EVENT_BUS);
        ModParticles.register(MOD_EVENT_BUS);
        EntityTypes.register(MOD_EVENT_BUS);
        ModSounds.SOUNDS.register(MOD_EVENT_BUS);
        ContainerRegistry.register(MOD_EVENT_BUS);
        ACSoundRegistry.REGISTER.register(MOD_EVENT_BUS);
        ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(MOD_EVENT_BUS);

//        MOD_EVENT_BUS.addListener(this::clientSetup);
        MOD_EVENT_BUS.addListener(this::onCommonSetup);

        // Register the setup method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModBiomeGeneration.generateBiomes();
            ModSetup.flowerPotSetup();
            AntiqueAtlasNetworking.register();
            ProjectileManager.getInstance().registerFactory(ModGuns.MININUKE.get(), (worldIn, entity, weapon, item, modifiedGun) -> new MiniNukeEntity(EntityTypes.MININUKE.get(), worldIn, entity, weapon, item, modifiedGun));
        });
    }
}
