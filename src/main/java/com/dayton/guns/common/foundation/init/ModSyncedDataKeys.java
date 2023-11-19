package com.dayton.guns.common.foundation.init;

import com.dayton.nukacraft.NukaCraftMod;
import com.mrcrayfish.framework.api.FrameworkAPI;
import com.mrcrayfish.framework.api.data.sync.Serializers;
import com.mrcrayfish.framework.api.data.sync.SyncedClassKey;
import com.mrcrayfish.framework.api.data.sync.SyncedDataKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

/**
 * Author: MrCrayfish
 */
public class ModSyncedDataKeys {
    public static final SyncedDataKey<LivingEntity, Boolean> AIMING = SyncedDataKey.builder(SyncedClassKey.LIVING_ENTITY, Serializers.BOOLEAN)
            .id(new ResourceLocation(NukaCraftMod.MOD_ID, "aiming"))
            .defaultValueSupplier(() -> false)
            .resetOnDeath()
            .build();

    public static final SyncedDataKey<LivingEntity, Boolean> SHOOTING = SyncedDataKey.builder(SyncedClassKey.LIVING_ENTITY, Serializers.BOOLEAN)
            .id(new ResourceLocation(NukaCraftMod.MOD_ID, "shooting"))
            .defaultValueSupplier(() -> false)
            .resetOnDeath()
            .build();

    public static final SyncedDataKey<LivingEntity, Boolean> RELOADING = SyncedDataKey.builder(SyncedClassKey.LIVING_ENTITY, Serializers.BOOLEAN)
            .id(new ResourceLocation(NukaCraftMod.MOD_ID, "reloading"))
            .defaultValueSupplier(() -> false)
            .resetOnDeath()
            .build();

    public static void register() {
        FrameworkAPI.registerSyncedDataKey(AIMING);
        FrameworkAPI.registerSyncedDataKey(SHOOTING);
        FrameworkAPI.registerSyncedDataKey(RELOADING);
    }
}
