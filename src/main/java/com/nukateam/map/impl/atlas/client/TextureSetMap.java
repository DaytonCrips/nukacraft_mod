package com.nukateam.map.impl.atlas.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps texture sets to their names.
 *
 * @author Hunternif
 */
@OnlyIn(Dist.CLIENT)
public class TextureSetMap {
    private static final TextureSetMap INSTANCE = new TextureSetMap();
    public final Map<ResourceLocation, TextureSet> map = new HashMap<>();

    public static TextureSetMap instance() {
        return INSTANCE;
    }

    static public boolean isRegistered(ResourceLocation name) {
        return INSTANCE.map.containsKey(name);
    }

    public void register(TextureSet set) {
        map.put(set.name, set);
    }

    public TextureSet getByName(ResourceLocation name) {
        return map.get(name);
    }
}
