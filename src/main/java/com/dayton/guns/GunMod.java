package com.dayton.guns;

import com.dayton.guns.client.ClientHandler;
import com.dayton.guns.client.MetaLoader;
import com.dayton.guns.client.handler.CrosshairHandler;
import com.dayton.guns.common.base.BoundingBoxManager;
import com.dayton.guns.common.base.ProjectileManager;
import com.dayton.guns.common.data.datagen.*;
import com.dayton.guns.common.foundation.crafting.ModRecipeType;
import com.dayton.guns.common.foundation.crafting.WorkbenchIngredient;
import com.dayton.guns.common.foundation.entity.GrenadeEntity;
import com.dayton.guns.common.foundation.entity.MissileEntity;
import com.dayton.guns.common.foundation.init.*;
import com.dayton.guns.common.network.PacketHandler;
import com.dayton.nukacraft.NukaCraftMod;
import com.mrcrayfish.framework.api.client.FrameworkClientAPI;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.dayton.nukacraft.common.foundation.items.ModGuns.GRENADE;
import static com.dayton.nukacraft.common.foundation.items.ModGuns.MISSILE;

//@Mod(NukaCraftMod.MOD_ID)
public class GunMod {
    public static boolean debugging = false;
    public static boolean controllableLoaded = false;
    public static boolean backpackedLoaded = false;
    public static boolean playerReviveLoaded = false;
    public static final Logger LOGGER = LogManager.getLogger(NukaCraftMod.MOD_ID);

    public void initGunMod(IEventBus bus)
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.clientSpec);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.commonSpec);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.serverSpec);
        //ModBlocksClass.REGISTER.register(bus);
        ModContainers.REGISTER.register(bus);
        ModEffects.REGISTER.register(bus);
        ModEnchantments.REGISTER.register(bus);
        ModEntities.REGISTER.register(bus);
        ModItems.REGISTER.register(bus);
        ModParticleTypes.REGISTER.register(bus);
        ModRecipeSerializers.REGISTER.register(bus);
        ModSounds.REGISTER.register(bus);
        ModTileEntities.REGISTER.register(bus);
        bus.addListener(this::onCommonSetup);
        bus.addListener(this::onClientSetup);
        bus.addListener(this::onGatherData);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            bus.addListener(CrosshairHandler::onConfigReload);
            bus.addListener(ClientHandler::onRegisterReloadListener);
            FrameworkClientAPI.registerDataLoader(MetaLoader.getInstance());
        });
        controllableLoaded = ModList.get().isLoaded("controllable");
        backpackedLoaded = ModList.get().isLoaded("backpacked");
        playerReviveLoaded = ModList.get().isLoaded("playerrevive");
    }

    private void onCommonSetup(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            ModRecipeType.init();
            ModSyncedDataKeys.register();
            CraftingHelper.register(new ResourceLocation(NukaCraftMod.MOD_ID, "workbench_ingredient"), WorkbenchIngredient.Serializer.INSTANCE);
            ProjectileManager.getInstance().registerFactory(GRENADE.get(), (worldIn, entity, weapon, item, modifiedGun) -> new GrenadeEntity(ModEntities.GRENADE.get(), worldIn, entity, weapon, item, modifiedGun));
            ProjectileManager.getInstance().registerFactory(MISSILE.get(), (worldIn, entity, weapon, item, modifiedGun) -> new MissileEntity(ModEntities.MISSILE.get(), worldIn, entity, weapon, item, modifiedGun));
            PacketHandler.init();
            if(Config.COMMON.gameplay.improvedHitboxes.get())
            {
                MinecraftForge.EVENT_BUS.register(new BoundingBoxManager());
            }
        });
    }

    private void onClientSetup(FMLClientSetupEvent event)
    {
        event.enqueueWork(ClientHandler::setup);
    }

    private void onGatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        BlockTagGen blockTagGen = new BlockTagGen(generator, existingFileHelper);
        generator.addProvider(new RecipeGen(generator));
        generator.addProvider(new LootTableGen(generator));
        generator.addProvider(blockTagGen);
        generator.addProvider(new ItemTagGen(generator, blockTagGen, existingFileHelper));
        generator.addProvider(new LanguageGen(generator));
        generator.addProvider(new GunGen(generator));
    }

    public static boolean isDebugging()
    {
        return false; //!FMLEnvironment.production;
    }
}
