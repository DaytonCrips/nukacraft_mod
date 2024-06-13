package com.nukateam.nukacraft.common.data.utils;

import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import com.nukateam.nukacraft.common.foundation.entities.misc.PowerArmorFrame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class PowerArmorUtils {
    public static boolean isWearingPowerArmor(Entity entity) {
        return entity != null && entity.getVehicle() instanceof PowerArmorFrame;
    }

    @OnlyIn(Dist.CLIENT)
    public static LocalPlayer getLocalPlayer() {
        return Minecraft.getInstance().player;
    }

    @OnlyIn(Dist.CLIENT)
    public static boolean isLocalWearingPowerArmor() {
        return isWearingPowerArmor(getLocalPlayer());
    }

    @Nullable
    public static PowerArmorFrame getPowerArmor(Entity player) {
        return player.getVehicle() instanceof PowerArmorFrame ? (PowerArmorFrame) player.getVehicle() : null;
    }

    @OnlyIn(Dist.CLIENT)
    public static WearableChassis getPowerArmor() {
        return getPowerArmor(getLocalPlayer());
    }
}
