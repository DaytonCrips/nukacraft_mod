package com.dayton.nukacraft.common.data.utils;

import com.dayton.nukacraft.common.foundation.entities.PowerArmorFrame;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

public class PowerArmorUtils {
    public static boolean isWearingPowerArmor(Entity entity) {
        return entity != null && entity.getVehicle() instanceof PowerArmorFrame;
    }

    @Nullable
    public static WearableChassis getPowerArmor(Entity player) {
        return player.getVehicle() instanceof PowerArmorFrame ? (PowerArmorFrame)player.getVehicle() : null;
    }
}
