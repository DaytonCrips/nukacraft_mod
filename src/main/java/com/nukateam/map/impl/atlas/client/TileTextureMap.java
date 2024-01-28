package com.nukateam.map.impl.atlas.client;

import com.nukateam.map.impl.atlas.MapCore;
import com.nukateam.map.impl.atlas.client.texture.ITexture;
import com.nukateam.map.impl.atlas.util.Log;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.*;
import java.util.Map.Entry;

import static com.nukateam.map.impl.atlas.core.scaning.TileDetectorBase.getCategory;

/**
 * Maps biome IDs (or pseudo IDs) to textures. <i>Not thread-safe!</i>
 * <p>If several textures are set for one ID, one will be chosen at random when
 * putting tile into Atlas.</p>
 *
 * @author Hunternif
 */
@OnlyIn(Dist.CLIENT)
public class TileTextureMap {
    private static final TileTextureMap INSTANCE = new TileTextureMap();

    public static TileTextureMap instance() {
        return INSTANCE;
    }

    /**
     * This map stores the pseudo biome texture mappings, any biome with ID <0 is assumed to be a pseudo biome
     */
    private final Map<ResourceLocation, TextureSet> textureMap = new HashMap<>();

    /**
     * Assign texture set to pseudo biome
     */
    public void setTexture(ResourceLocation tileId, TextureSet textureSet) {
        if (textureSet == null) {
            if (textureMap.remove(tileId) != null) {
                Log.warn("Removing old texture for %d", tileId);
            }
            return;
        }

        textureMap.put(tileId, textureSet);
    }

    public TextureSet getDefaultTexture() {
        return TextureSetMap.instance().getByName(MapCore.id("test"));
    }

    /**
     * Find the most appropriate standard texture set depending on
     * BiomeDictionary types.
     */
    public void autoRegister(ResourceLocation id, Biome biome) {
        if (biome == null) {
            Log.error("Given biome is null. Cannot autodetect a suitable texture set for that.");
            return;
        }
//
//        var biomeTag = Minecraft.getInstance().level.getRegistryManager().get(Registry.BIOME_KEY).entryOf(biome);
//
        var biomeCategory = getCategory(biome);
        if(biomeCategory == null) return;

        var biomeName = biome.getRegistryName();
        if(biomeName == null) return;

        if(biomeName.getPath().equals("swamp_hills")){
            var i = 0;
        }

        var textureSet = switch (biomeCategory) {
            case SWAMP -> MapCore.id("swamp");
            case OCEAN, RIVER -> MapCore.id(biome.getPrecipitation() == Biome.Precipitation.SNOW ? "ice" : "water");
            case BEACH -> MapCore.id("shore");
            case JUNGLE -> MapCore.id("jungle");
            case SAVANNA -> MapCore.id("savanna");
            case MESA -> MapCore.id("plateau_mesa");
            case FOREST -> MapCore.id(biome.getPrecipitation() == Biome.Precipitation.SNOW ? "snow_pines" : "forest");
            case PLAINS -> MapCore.id(biome.getPrecipitation() == Biome.Precipitation.SNOW ? "snow" : "plains");
            case ICY -> MapCore.id("ice_spikes");
            case DESERT -> MapCore.id("desert");
            case TAIGA -> MapCore.id("snow");
            case EXTREME_HILLS -> MapCore.id("hills");
            case MOUNTAIN -> MapCore.id("mountains");
            case THEEND -> {
//                var features = biome.getGenerationSettings().features();
//                boolean has_chorus_plant = features.stream().anyMatch(supplier -> supplier.stream()
//                        .anyMatch(step -> step == CHORUS_PLANT));
//
//                var name = has_chorus_plant ? "end_island_plants" : "end_island";
//                setTexture(id, TextureSetMap.instance().getByName(MapCore.id(name)));
//
//

                var features = biome.getGenerationSettings().features();
                var chorus_plant_feature = BuiltinRegistries.PLACED_FEATURE.get(new ResourceLocation("chorus_plant"));
                assert chorus_plant_feature != null;
                boolean has_chorus_plant = features.stream().anyMatch(entries -> entries.stream().anyMatch(feature -> feature.value() == chorus_plant_feature));
                if (has_chorus_plant) yield MapCore.id("end_island_plants");
                else yield MapCore.id("end_island");
            }
            case MUSHROOM -> MapCore.id("mushroom");
            case NETHER -> MapCore.id("soul_sand_valley");
            case NONE -> MapCore.id("end_void");
            case UNDERGROUND -> {
                Log.warn("Underground biomes aren't supported yet.");
                yield null;
            }
        };

        setTexture(id, TextureSetMap.instance().getByName(textureSet));

        if (textureMap.get(id) != null) {
            Log.info("Auto-registered standard texture set for biome %s: %s", id.toString(), textureMap.get(id).name);
        } else {
            Log.error("Failed to auto-register a standard texture set for the biome '%s'. This is most likely caused by errors in the TextureSet configurations, check your resource packs first before reporting it as an issue!", id.toString());
        }
    }


    /**
     * Auto-registers the biome if it is not registered.
     */
    public void checkRegistration(ResourceLocation id, Biome biome) {
        if (!isRegistered(id)) {
            autoRegister(id, biome);
        }
    }

    /**
     * Checks for pseudo biome ID - if not registered, use default
     */
    private void checkRegistration(ResourceLocation id) {
        if (!isRegistered(id)) {
            setTexture(id, getDefaultTexture());
        }
    }

    public boolean isRegistered(ResourceLocation id) {
        return textureMap.containsKey(id);
    }

    /**
     * If unknown biome, auto-registers a texture set. If null, returns default set.
     */
    public TextureSet getTextureSet(ResourceLocation tile) {
        if (tile == null) return getDefaultTexture();

        var biome = BuiltinRegistries.BIOME.get(tile);
        if (biome != null)
            checkRegistration(tile, biome);
        else checkRegistration(tile);

        return textureMap.getOrDefault(tile, getDefaultTexture());
    }

    public ITexture getTexture(SubTile subTile) {
        return getTextureSet(subTile.tile).getTexture(subTile.variationNumber);
    }

    public List<ResourceLocation> getAllTextures() {
        List<ResourceLocation> list = new ArrayList<>();

        for (Entry<ResourceLocation, TextureSet> entry : textureMap.entrySet()) {
            Arrays.stream(entry.getValue().textures).forEach(iTexture -> list.add(iTexture.getTexture()));
        }

        return list;
    }
}
