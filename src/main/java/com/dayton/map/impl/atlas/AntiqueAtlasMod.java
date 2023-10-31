package com.dayton.map.impl.atlas;

import com.dayton.map.impl.atlas.client.gui.*;
import com.dayton.map.impl.atlas.core.GlobalAtlasData;
import com.dayton.map.impl.atlas.core.GlobalTileDataHandler;
import com.dayton.map.impl.atlas.core.PlayerEventHandler;
import com.dayton.map.impl.atlas.core.TileDataHandler;
import com.dayton.map.impl.atlas.core.scaning.TileDetectorBase;
import com.dayton.map.impl.atlas.core.scaning.WorldScanner;
import com.dayton.map.impl.atlas.event.RecipeCraftedCallback;
import com.dayton.map.impl.atlas.event.RecipeCraftedHandler;
import com.dayton.map.impl.atlas.forge.event.ServerWorldEvents;
import com.dayton.map.impl.atlas.marker.GlobalMarkersDataHandler;
import com.dayton.map.impl.atlas.marker.MarkersDataHandler;
import com.dayton.map.impl.atlas.mixinhooks.NewPlayerConnectionCallback;
import com.dayton.map.impl.atlas.mixinhooks.NewServerConnectionCallback;
import com.dayton.map.impl.atlas.network.AntiqueAtlasNetworking;
import com.dayton.map.impl.atlas.structure.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Consumer;

public class AntiqueAtlasMod {
	public static final String ID = "nukacraft";

	public static Logger LOG = LogManager.getLogger(ID);

	public static final WorldScanner worldScanner = new WorldScanner();
	public static final TileDataHandler tileData = new TileDataHandler();
	public static final MarkersDataHandler markersData = new MarkersDataHandler();

	public static final GlobalTileDataHandler globalTileData = new GlobalTileDataHandler();
	public static final GlobalMarkersDataHandler globalMarkersData = new GlobalMarkersDataHandler();

	public static AntiqueAtlasConfig CONFIG = new AntiqueAtlasConfig();
	public static final IEventBus MOD_EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

	public static ResourceLocation id(String... path) {
		return path[0].contains(":") ? new ResourceLocation(String.join(".", path)) : new ResourceLocation(ID, String.join(".", path));
	}

	public static GlobalAtlasData getGlobalAtlasData(Level world) {
		if (world.isClientSide()) {
			LOG.warn("Tried to access server only data from client.");
			return null;
		}

		return ((ServerLevel) world).getDataStorage().computeIfAbsent(GlobalAtlasData::readNbt, GlobalAtlasData::new, "nukacraft:global_atlas_data");
	}

	public static void onInitialize() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener((Consumer<FMLCommonSetupEvent>)common-> {
		TileDetectorBase.scanBiomeTypes();
		});

		CONFIG = new AntiqueAtlasConfig();

		AntiqueAtlasItems.register(MOD_EVENT_BUS);

		AntiqueAtlasNetworking.registerC2SListeners();

		NewServerConnectionCallback.register(tileData::onClientConnectedToServer);
		NewServerConnectionCallback.register(markersData::onClientConnectedToServer);
		NewServerConnectionCallback.register(globalMarkersData::onClientConnectedToServer);

		NewPlayerConnectionCallback.register(globalMarkersData::onPlayerLogin);
		NewPlayerConnectionCallback.register(globalTileData::onPlayerLogin);
		NewPlayerConnectionCallback.register(PlayerEventHandler::onPlayerLogin);

		ServerWorldEvents.register(globalMarkersData::onWorldLoad);
		ServerWorldEvents.register(globalTileData::onWorldLoad);

		RecipeCraftedCallback.register(new RecipeCraftedHandler());

		StructurePieceAddedCallback.register(StructureHandler::resolve);
		StructureAddedCallback.register(StructureHandler::resolve);

		FMLJavaModLoadingContext.get().getModEventBus().addListener((Consumer<FMLCommonSetupEvent>)common-> {
		NetherFortress.registerPieces();
		EndCity.registerMarkers();
		Village.registerMarkers();
		Village.registerPieces();
		Overworld.registerPieces();
		});
	}
	
	////FORGE ONLY
	public static final SimpleChannel MOD_CHANNEL = NetworkRegistry.newSimpleChannel(id("main"), () -> "1", "1"::equals, "1"::equals);
	public static void initMap()
	{
		onInitialize();
		new AntiqueAtlasModClient().onInitializeClient();
	}
}
