package com.dayton.map.impl.atlas.client;

import com.dayton.map.impl.atlas.AntiqueAtlasMod;
import com.dayton.map.impl.atlas.forge.resource.IResourceReloadListener;
import com.dayton.map.impl.atlas.util.Log;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * Client-only config mapping biome IDs to texture sets.
 * <p>Must be loaded after {@link TextureSetConfig}!</p>
 *
 * @author Hunternif
 */
@OnlyIn(Dist.CLIENT)
public class TileTextureConfig implements IResourceReloadListener<Map<ResourceLocation, ResourceLocation>> {
    private static final int VERSION = 1;
    private static final JsonParser PARSER = new JsonParser();
    private final TileTextureMap tileTextureMap;
    private final TextureSetMap textureSetMap;

    public TileTextureConfig(TileTextureMap biomeTextureMap, TextureSetMap textureSetMap) {
        this.tileTextureMap = biomeTextureMap;
        this.textureSetMap = textureSetMap;
    }

    @Override
    public CompletableFuture<Map<ResourceLocation, ResourceLocation>> load(ResourceManager manager, ProfilerFiller profiler, Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            Map<ResourceLocation, ResourceLocation> map = new HashMap<>();

            try {
                for (ResourceLocation id : manager.listResources("atlas/tiles", (s) -> s.endsWith(".json"))) {
                    ResourceLocation tile_id = new ResourceLocation(
                            id.getNamespace(),
                            id.getPath().replace("atlas/tiles/", "").replace(".json", "")
                    );

                    try {
                        Resource resource = manager.getResource(id);
                        try (
                                InputStream stream = resource.getInputStream();
                                InputStreamReader reader = new InputStreamReader(stream)
                        ) {
                            JsonObject object = PARSER.parse(reader).getAsJsonObject();

                            int version = object.getAsJsonPrimitive("version").getAsInt();
                            if (version != VERSION) {
                                AntiqueAtlasMod.LOG.warn("The tile " + tile_id + " is in the wrong version! Skipping.");
                                continue;
                            }

                            ResourceLocation texture_set = new ResourceLocation(object.get("texture_set").getAsString());

                            map.put(tile_id, texture_set);
                        }
                    } catch (Exception e) {
                        AntiqueAtlasMod.LOG.warn("Error reading tile mapping " + tile_id + "!", e);
                    }
                }
            } catch (Throwable e) {
                Log.warn(e, "Failed to read tile mappings!");
            }

            return map;
        });
    }

    @Override
    public CompletableFuture<Void> apply(Map<ResourceLocation, ResourceLocation> tileMap, ResourceManager manager, ProfilerFiller profiler, Executor executor) {
    	for (Map.Entry<ResourceLocation, ResourceLocation> entry : tileMap.entrySet()) {
	        ResourceLocation tile_id = entry.getKey();
	        ResourceLocation texture_set = entry.getValue();
	        TextureSet set = textureSetMap.getByName(entry.getValue());

	        if(set == null) {
	            AntiqueAtlasMod.LOG.error("Missing texture set `{}` for tile `{}`. Using default.", texture_set, tile_id);

	            set = tileTextureMap.getDefaultTexture();
            }

	        tileTextureMap.setTexture(entry.getKey(), set);
            Log.info("Using texture set %s for tile %s", set.name, tile_id);
        }
    	return CompletableFuture.runAsync(() -> {
        });
    }

    @Override
    public ResourceLocation getForgeId() {
        return new ResourceLocation("nukacraft:tile_textures");
    }

    @Override
    public Collection<ResourceLocation> getForgeDependencies() {
        return Collections.singleton(new ResourceLocation("nukacraft:texture_sets"));
    }
}