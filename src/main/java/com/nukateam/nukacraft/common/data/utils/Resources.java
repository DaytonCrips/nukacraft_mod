package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.NukaCraftMod;
import net.minecraft.resources.ResourceLocation;

public class Resources {
    public static ResourceLocation nukaResource(String path){
        return new ResourceLocation(NukaCraftMod.MOD_ID, path);
    }
}
