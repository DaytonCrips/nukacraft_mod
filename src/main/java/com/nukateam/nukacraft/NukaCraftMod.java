package com.nukateam.nukacraft;

import com.mojang.logging.LogUtils;
import com.nukateam.ntgl.common.base.utils.ProjectileManager;
import com.nukateam.ntgl.common.foundation.entity.FlameProjectile;
import com.nukateam.ntgl.common.foundation.entity.LaserProjectile;
import com.nukateam.ntgl.common.foundation.entity.TeslaProjectile;
import com.nukateam.ntgl.common.foundation.init.Projectiles;
import com.nukateam.nukacraft.client.KeyBindings;
import com.nukateam.nukacraft.common.events.RadiationTracker;
import com.nukateam.nukacraft.common.foundation.entities.misc.MiniNukeEntity;
import com.nukateam.nukacraft.common.foundation.items.guns.TeslaGun;
import com.nukateam.nukacraft.common.foundation.world.ModBiomeGeneration;
import com.nukateam.nukacraft.common.foundation.world.ModBiomes;
import com.nukateam.nukacraft.common.network.PacketHandler;
import com.nukateam.nukacraft.common.registery.*;
import com.nukateam.nukacraft.common.registery.fluid.ModFluidTypes;
import com.nukateam.nukacraft.common.registery.fluid.ModFluids;
import com.nukateam.nukacraft.common.registery.items.*;
import mod.azure.azurelib.AzureLib;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import static com.nukateam.ntgl.common.foundation.init.Projectiles.LASER_PROJECTILE;
import static com.nukateam.ntgl.common.foundation.init.Projectiles.TESLA_PROJECTILE;

//Приходит улитка в бар, а там java классы в нарды играют...

@Mod(NukaCraftMod.MOD_ID)
public class NukaCraftMod {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "nukacraft";
    public static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

    private static boolean curiosLoaded = false;

    public NukaCraftMod() {
        AzureLib.initialize();

        //IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
//        MOD_EVENT_BUS.addListener(this::setup);

//        MapCore.onInitialize();
//        MapCore.initMapClient();

//        new GunMod().initGunMod(MOD_EVENT_BUS);

        ModEffect.register(MOD_EVENT_BUS);
        EntityTypes.register(MOD_EVENT_BUS);
        PowerArmorItems.register(MOD_EVENT_BUS);
        ModArmorItems.register(MOD_EVENT_BUS);
        ModWeapons.register(MOD_EVENT_BUS);
        ModAttributes.register(MOD_EVENT_BUS);
        ModBlocks.register(MOD_EVENT_BUS);
        ModBiomes.register(MOD_EVENT_BUS);
        ModMelee.register(MOD_EVENT_BUS);
        ModParticles.register(MOD_EVENT_BUS);
        ModSounds.SOUNDS.register(MOD_EVENT_BUS);
        ContainerRegistry.register(MOD_EVENT_BUS);
        SoundRegistry.REGISTER.register(MOD_EVENT_BUS);
        ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(MOD_EVENT_BUS);
        ModPaintings.register(MOD_EVENT_BUS);
        ModTileEntities.REGISTER.register(MOD_EVENT_BUS);
        ModFluids.register(MOD_EVENT_BUS);
        ModFluidTypes.register(MOD_EVENT_BUS);
        ModTreeDecorator.register(MOD_EVENT_BUS);
        ModItems.register(MOD_EVENT_BUS);

//        MOD_EVENT_BUS.addListener(this::clientSetup);
        MOD_EVENT_BUS.addListener(this::onCommonSetup);
        MOD_EVENT_BUS.addListener(this::onEnqueueIMC);

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            MOD_EVENT_BUS.addListener(KeyBindings::register);
        });

        MinecraftForge.EVENT_BUS.register(RadiationTracker.class);
        MinecraftForge.EVENT_BUS.register(this);

        curiosLoaded = ModList.get().isLoaded("curios");
    }

    public static boolean isCuriosLoaded() {
        return curiosLoaded;
    }

    private static void registerProjectileFactories() {
        ProjectileManager.getInstance().registerFactory(ModWeapons.MININUKE.get(),
                (level, entity, weapon, item, modifiedGun) ->
                        new MiniNukeEntity(EntityTypes.MININUKE.get(), level, entity, weapon, item, modifiedGun));

        ProjectileManager.getInstance().registerFactory(ModWeapons.FUSION_CELL.get(),
                (level, entity, weapon, item, modifiedGun) -> {
                    if (item instanceof TeslaGun)
                        return new TeslaProjectile(TESLA_PROJECTILE.get(), level, entity, weapon, item, modifiedGun);
                    else
                        return new LaserProjectile(LASER_PROJECTILE.get(), level, entity, weapon, item, modifiedGun);
                });

        ProjectileManager.getInstance().registerFactory(ModWeapons.FUSION_CORE.get(),
                (level, entity, weapon, item, modifiedGun) -> {
                    if (item instanceof TeslaGun)
                        return new TeslaProjectile(TESLA_PROJECTILE.get(), level, entity, weapon, item, modifiedGun);
                    else
                        return new LaserProjectile(LASER_PROJECTILE.get(), level, entity, weapon, item, modifiedGun);
                });

        ProjectileManager.getInstance().registerFactory(ModWeapons.FUEL.get(),
                (worldIn, entity, weapon, item, modifiedGun) ->
                        new FlameProjectile(Projectiles.FLAME_PROJECTILE.get(), worldIn, entity, weapon, item, modifiedGun));
    }

    private void onEnqueueIMC(InterModEnqueueEvent event) {
        if (!curiosLoaded) return;
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.BRACELET.getMessageBuilder().build());
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModBiomeGeneration.generateBiomes();
            ModSetup.flowerPotSetup();
            PacketHandler.register();
//            AntiqueAtlasNetworking.register();
            registerProjectileFactories();
        });
    }
}
