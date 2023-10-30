package com.dayton.map.impl.atlas.client.gui;

import com.dayton.map.impl.atlas.AntiqueAtlasConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ConfigGuiHandler;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class AntiqueAtlasModMenu {
	
    public static Supplier<ConfigGuiHandler.ConfigGuiFactory> getModConfigScreenFactory() {
			return () -> new ConfigGuiHandler.ConfigGuiFactory((minecraft, parentScreen) -> {
				return AutoConfig.getConfigScreen(AntiqueAtlasConfig.class, parentScreen).get();
			});
    }
}
