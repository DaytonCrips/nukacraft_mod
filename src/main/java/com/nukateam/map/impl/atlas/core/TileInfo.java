package com.nukateam.map.impl.atlas.core;

import net.minecraft.resources.ResourceLocation;

public class TileInfo {
    public final int x, z;
    public final ResourceLocation id;

    public TileInfo(int x, int z, ResourceLocation id) {
        this.x = x;
        this.z = z;
        this.id = id;
    }
}
