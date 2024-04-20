package com.nukateam.nukacraft.common.data.utils;

import net.minecraft.core.Vec3i;
import net.minecraft.world.phys.Vec3;

public class VectorUtils {
    public static Vec3i toVec3I(Vec3 vec) {
        return new Vec3i((int) vec.x, (int) vec.y, (int) vec.z);
    }
}
