package com.dayton.nukacraft.common.data.utils;

import com.dayton.nukacraft.*;
import net.minecraft.resources.ResourceLocation;

public class Resources {
    public static ResourceLocation nukaResource(String path){
        return new ResourceLocation(NukaCraftMod.MOD_ID, path);
    }
}
