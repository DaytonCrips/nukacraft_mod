package com.nukateam.map.impl.atlas.client;

import com.google.gson.JsonParser;
import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.forge.resource.IResourceReloadListener;
import com.nukateam.map.impl.atlas.util.Log;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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
                for (var id : manager.listResources("atlas/tiles", (s) -> s.endsWith(".json"))) {
                    var tile_id = new ResourceLocation(
                            id.getNamespace(),
                            id.getPath().replace("atlas/tiles/", "").replace(".json", "")
                    );

                    try {
                        var resource = manager.getResource(id);
                        try (
                                var stream = resource.getInputStream();
                                var reader = new InputStreamReader(stream)
                        ) {
                            var object = PARSER.parse(reader).getAsJsonObject();

                            int version = object.getAsJsonPrimitive("version").getAsInt();
                            if (version != VERSION) {
                                MapCore.LOG.warn("The tile " + tile_id + " is in the wrong version! Skipping.");
                                continue;
                            }

                            var texture_set = new ResourceLocation(object.get("texture_set").getAsString());

                            map.put(tile_id, texture_set);
                        }
                    } catch (Exception e) {
                        MapCore.LOG.warn("Error reading tile mapping " + tile_id + "!", e);
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
        for (var entry : tileMap.entrySet()) {
            var tile_id = entry.getKey();
            var texture_set = entry.getValue();
            var set = textureSetMap.getByName(entry.getValue());

            if (set == null) {
                MapCore.LOG.error("Missing texture set `{}` for tile `{}`. Using default.", texture_set, tile_id);

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
