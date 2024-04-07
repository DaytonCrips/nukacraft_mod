package com.nukateam.nukacraft.common.foundation.entities.misc;

import com.nukateam.ntgl.Config;
import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.ntgl.common.foundation.entity.ThrowableItemEntity;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import static com.nukateam.ntgl.common.foundation.entity.ProjectileEntity.createExplosion;
import static com.nukateam.nukacraft.common.registery.items.ModWeapons.BASEBALL_GRENADE;


public class BaseballGrenadeEntity extends ThrowableGrenadeEntity {
    public BaseballGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public BaseballGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level world, LivingEntity entity) {
        super(entityType, world, entity);
        this.setShouldBounce(true);
        this.setGravityVelocity(0.05F);
        this.setItem(new ItemStack(BASEBALL_GRENADE.get()));
        this.setMaxLife(20 * 3);
    }

    public BaseballGrenadeEntity(Level world, LivingEntity entity, int timeLeft) {
        super(EntityTypes.BASEBALL_GRENADE_ENTITY.get(), world, entity);
        this.setShouldBounce(true);
        this.setGravityVelocity(0.05F);
        this.setItem(new ItemStack(BASEBALL_GRENADE.get()));
        this.setMaxLife(timeLeft);
    }

    @Override
    protected void onHit(HitResult result) {
        createExplosion(this, Config.COMMON.grenades.explosionRadius.get().floatValue(), true);
        this.remove(RemovalReason.KILLED);
    }
}
