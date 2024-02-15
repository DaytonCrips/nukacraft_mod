package com.nukateam.map.impl.atlas.registry;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.item.AtlasItem;
import com.nukateam.map.impl.atlas.item.ItemEmptyAtlas;
import com.nukateam.map.impl.atlas.item.RecipeAtlasCloning;
import com.nukateam.map.impl.atlas.item.RecipeAtlasCombining;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AntiqueAtlasItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MapCore.ID);
	public static final DeferredRegister<RecipeSerializer<?>>
			RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MapCore.ID);


//	public static final RegistryObject<Item> EMPTY_ATLAS = ITEMS.register("empty_antique_atlas",
//			() -> new ItemEmptyAtlas(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
//	public static final RegistryObject<Item> ATLAS = ITEMS.register("antique_atlas",
//			() -> new AtlasItem(new Item.Properties().stacksTo(1)));
//
//	public static ItemStack getAtlasFromId(int atlasID) {
//		ItemStack atlas = new ItemStack(ATLAS.get());
//		atlas.getOrCreateTag().putInt("atlasID", atlasID);
//
//		return atlas;
//	}

	public static void register(IEventBus modEventBus) {
		if (MapCore.CONFIG.itemNeeded) {
			ITEMS.register(modEventBus);

			RECIPES.register("atlas_clone", () -> RecipeAtlasCloning.SERIALIZER);
			RECIPES.register("atlas_combine", () -> RecipeAtlasCombining.SERIALIZER);

			RECIPES.register(modEventBus);
		}
	}
}

