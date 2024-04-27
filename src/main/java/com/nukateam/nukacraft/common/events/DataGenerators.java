package com.nukateam.nukacraft.common.events;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.registery.datagen.ItemModelProvider;
import com.nukateam.nukacraft.common.registery.datagen.RegistryDataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NukaCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var packOutput = generator.getPackOutput();
        var fileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new RegistryDataGenerator(packOutput, event.getLookupProvider()));
        generator.addProvider(event.includeClient(), new ItemModelProvider(packOutput, fileHelper));
    }
}
