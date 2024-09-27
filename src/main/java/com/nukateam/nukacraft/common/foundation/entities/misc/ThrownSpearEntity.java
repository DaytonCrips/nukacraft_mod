package com.nukateam.nukacraft.common.foundation.entities.misc;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ThrownSpearEntity extends AbstractArrow {
    private static final EntityDataAccessor<Byte> ID_LOYALTY;
    private static final EntityDataAccessor<Boolean> ID_FOIL;
    public ThrownSpearEntity(EntityType<? extends AbstractArrow> type, Level world) {
        super(type, world);
    }

    public ThrownSpearEntity(EntityType<? extends AbstractArrow> type, LivingEntity entity, Level world) {
        super(type, entity, world);
    }

    public boolean isFoil() {
        return (Boolean)this.entityData.get(ID_FOIL);
    }

    protected ItemStack getPickupItem() {
        return null;
    }

    protected float getWaterInertia() {
        return 0.99F;
    }




    static {
        ID_LOYALTY = SynchedEntityData.defineId(ThrownSpearEntity.class, EntityDataSerializers.BYTE);
        ID_FOIL = SynchedEntityData.defineId(ThrownSpearEntity.class, EntityDataSerializers.BOOLEAN);
    }
}
