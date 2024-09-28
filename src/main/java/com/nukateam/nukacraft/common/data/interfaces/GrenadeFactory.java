package com.nukateam.nukacraft.common.data.interfaces;

import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

@FunctionalInterface
public interface GrenadeFactory<T extends ThrowableGrenadeEntity> {
    T get(Level world, LivingEntity entity, int timeLeft);
}