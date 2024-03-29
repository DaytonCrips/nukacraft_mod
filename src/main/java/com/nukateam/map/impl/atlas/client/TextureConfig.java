package com.nukateam.map.impl.atlas.client;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.client.texture.ITexture;
import com.nukateam.map.impl.atlas.client.texture.TileTexture;
import com.nukateam.map.impl.atlas.forge.resource.IResourceReloadListener;
import com.nukateam.map.impl.atlas.util.Log;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * Reads all png files available under assets/(?modid)/textures/gui/tiles/(?tex).png as Textures that
 * are referenced by the TextureSets.
 *<p>
 * Note that each texture is represented by TWO Identifiers:
 * - The identifier of the physical location in modid:texture/gui/tiles/tex.png
 * - The logical identifier modid:tex referenced by TextureSets
 */
@OnlyIn(Dist.CLIENT)
public class TextureConfig implements IResourceReloadListener<Map<ResourceLocation, ITexture>> {
	private final Map<ResourceLocation, ITexture> texture_map;

	public TextureConfig(Map<ResourceLocation, ITexture> texture_map) {
		this.texture_map = texture_map;
	}

	@Override
	public CompletableFuture<Map<ResourceLocation, ITexture>> load(ResourceManager manager, ProfilerFiller profiler, Executor executor) {
		return CompletableFuture.supplyAsync(() -> {
			Map<ResourceLocation, ITexture> textures = new HashMap<>();

			for (ResourceLocation id : manager.listResources("textures/gui/tiles", (s) -> s.endsWith(".png"))) {
				try {
					// id now contains the physical file path of the texture

					// texture_id is the logical identifier, as it will be referenced by TextureSets
					ResourceLocation texture_id = new ResourceLocation(
							id.getNamespace(),
							id.getPath().replace("textures/gui/tiles/", "").replace(".png", "")
							);

					MapCore.LOG.info("Found new Texture: " + texture_id);

					textures.put(texture_id, new TileTexture(id));
				} catch (Throwable e) {
					MapCore.LOG.warn("Failed to read textures!", e);
				}
			}


			return textures;
		});
	}

	@Override
	public CompletableFuture<Void> apply(Map<ResourceLocation, ITexture> textures, ResourceManager manager, ProfilerFiller profiler, Executor executor) {
		texture_map.clear();
		for (Map.Entry<ResourceLocation, ITexture> entry : textures.entrySet()) {
			texture_map.put(entry.getKey(), entry.getValue());
			Log.info("Loaded texture %s with path %s", entry.getKey(), entry.getValue().getTexture());
		}
		return CompletableFuture.runAsync(() -> {

		});
	}

	@Override
	public ResourceLocation getForgeId() {
		return new ResourceLocation("nukacraft:textures");
	}
}
