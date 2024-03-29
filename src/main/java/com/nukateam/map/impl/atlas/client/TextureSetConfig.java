package com.nukateam.map.impl.atlas.client;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.forge.resource.IResourceReloadListener;
import com.nukateam.map.impl.atlas.util.Log;
import com.google.gson.JsonElement;
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
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * Saves texture set names with the lists of texture variations.
 */
@OnlyIn(Dist.CLIENT)
public class TextureSetConfig implements IResourceReloadListener<Collection<TextureSet>> {
    private static final int VERSION = 1;
    private static final JsonParser PARSER = new JsonParser();
    private final TextureSetMap textureSetMap;

    public TextureSetConfig(TextureSetMap textureSetMap) {
        this.textureSetMap = textureSetMap;
    }

    @Override
    public CompletableFuture<Collection<TextureSet>> load(ResourceManager manager, ProfilerFiller profiler, Executor executor) {
        return CompletableFuture.supplyAsync(() -> {
            Map<ResourceLocation, TextureSet> sets = new HashMap<>();

            try {
                for (ResourceLocation id : manager.listResources("atlas/texture_sets", (s) -> s.endsWith(".json"))) {
                    ResourceLocation texture_id = new ResourceLocation(
                            id.getNamespace(),
                            id.getPath().replace("atlas/texture_sets/", "").replace(".json", "")
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
                                MapCore.LOG.warn("The TextureSet " + texture_id + " is in the wrong version! Skipping.");
                                continue;
                            }

                            JsonObject data = object.getAsJsonObject("data");

                            List<ResourceLocation> textures = new ArrayList<>();

                            for (Entry<String, JsonElement> entry : data.getAsJsonObject("textures").entrySet()) {
                                for (int i = 0; i < entry.getValue().getAsInt(); i++) {
                                    textures.add(new ResourceLocation(entry.getKey()));
                                }
                            }

                            ResourceLocation[] textureArray = new ResourceLocation[textures.size()];
                            TextureSet set;

                            if (!data.has("shore")) {
                                set = new TextureSet(texture_id, textures.toArray(textureArray));
                            } else {
                                JsonObject shore = data.getAsJsonObject("shore");

                                if (!shore.has("water")) {
                                    throw new RuntimeException("The `shore` entry is missing a water entry.");
                                }

                                set = new TextureSet.TextureSetShore(texture_id, new ResourceLocation(shore.get("water").getAsString()), textures.toArray(textureArray));
                            }

                            if (data.has("stitch")) {
                                data.getAsJsonObject("stitch").entrySet().forEach(entry -> {
                                    String to = entry.getValue().getAsString();

                                    switch (to) {
                                        case "both":
                                            set.stitchTo(new ResourceLocation(entry.getKey()));
                                            break;
                                        case "horizontal":
                                            set.stitchToHorizontal(new ResourceLocation(entry.getKey()));
                                            break;
                                        case "vertical":
                                            set.stitchToVertical(new ResourceLocation(entry.getKey()));
                                            break;
                                        default:
                                            throw new RuntimeException("Invalid stitch value (" + to + ") for `" + entry.getKey() + "`");
                                    }
                                });
                            }


                            sets.put(texture_id, set);
                        }
                    } catch (Exception e) {
                        MapCore.LOG.warn("Error reading TextureSet " + texture_id + "!", e);
                    }
                }
            } catch (Throwable e) {
                Log.warn(e, "Failed to read texture sets!");
            }

            return sets.values();
        });
    }

    @Override
    public CompletableFuture<Void> apply(Collection<TextureSet> sets, ResourceManager manager, ProfilerFiller profiler, Executor executor) {
    	for (TextureSet set : sets) {
            try {
                set.loadTextures();
                textureSetMap.register(set);
                Log.info("Loaded texture set %s with %d custom texture(s)", set.name, set.getTexturePaths().length);
            }
            catch (Throwable e) {
                Log.error(e, "Failed to load the texture set `%s`:", set.name);
            }

        }

        for (TextureSet set : sets) {
            set.checkStitching();

            if (set instanceof TextureSet.TextureSetShore) {
                TextureSet.TextureSetShore texture = (TextureSet.TextureSetShore) set;
                texture.loadWater();
                Log.info("Loaded water texture `%s` for shore texture `%s` texture", texture.waterName, texture.name);
            }
        }
    	return CompletableFuture.runAsync(() -> {
        });
    }

    @Override
    public ResourceLocation getForgeId() {
        return new ResourceLocation("nukacraft:texture_sets");
    }

    @Override
    public Collection<ResourceLocation> getForgeDependencies() {
        return Collections.singleton(new ResourceLocation("nukacraft:textures"));
    }
}
