package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.common.foundation.entities.PowerArmorFrame;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

public class PowerArmorUtils {
    public static boolean isWearingPowerArmor(Entity entity) {
        return entity != null && entity.getVehicle() instanceof PowerArmorFrame;
    }

    @Nullable
    public static PowerArmorFrame getPowerArmor(Entity player) {
        return player.getVehicle() instanceof PowerArmorFrame ? (PowerArmorFrame)player.getVehicle() : null;
    }
}
