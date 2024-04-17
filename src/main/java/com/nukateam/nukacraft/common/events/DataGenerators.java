package com.nukateam.nukacraft.common.events;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.datagen.RegistryDataGenerator;
import net.minecraft.DetectedVersion;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		var generator = event.getGenerator();
		var output = event.getGenerator().getPackOutput();
		var provider = event.getLookupProvider();
		var helper = event.getExistingFileHelper();

		//registry-based tags
		var datapackProvider = new RegistryDataGenerator(output, provider);
		CompletableFuture<HolderLookup.Provider> lookupProvider = datapackProvider.getRegistryProvider();
		generator.addProvider(event.includeServer(), datapackProvider);
		generator.addProvider(event.includeServer(), new BiomeTagGenerator(output, lookupProvider, helper));
		generator.addProvider(event.includeServer(), new CustomTagGenerator.DimensionTypeTagGenerator(output, lookupProvider, helper));
		generator.addProvider(event.includeServer(), new CustomTagGenerator.WoodPaletteTagGenerator(output, lookupProvider, helper));
		generator.addProvider(event.includeServer(), new DamageTypeTagGenerator(output, lookupProvider, helper));
		generator.addProvider(event.includeServer(), new StructureTagGenerator(output, lookupProvider, helper));

		//pack.mcmeta
		generator.addProvider(true, new PackMetadataGenerator(output).add(PackMetadataSection.TYPE, new PackMetadataSection(
				Component.literal("Resources for NukaCraft"),
				DetectedVersion.BUILT_IN.getPackVersion(PackType.SERVER_DATA))));
	}
}
