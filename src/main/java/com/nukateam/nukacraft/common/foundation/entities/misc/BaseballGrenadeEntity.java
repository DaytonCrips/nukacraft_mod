package com.nukateam.nukacraft.common.foundation.entities.misc;

import com.nukateam.gunscore.Config;
import com.nukateam.gunscore.common.foundation.entity.GrenadeEntity;
import com.nukateam.gunscore.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.gunscore.common.foundation.entity.ThrowableItemEntity;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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
    protected void defineSynchedData() {
    }

    @Override
    public void tick() {
        super.tick();
        this.prevRotation = this.rotation;
        double speed = this.getDeltaMovement().length();
        if (speed > 0.1) {
            this.rotation += speed * 50;
        }
        if (this.level.isClientSide) {
            this.level.addParticle(ParticleTypes.SMOKE, true, this.getX(), this.getY() + 0.25, this.getZ(), 0, 0, 0);
        }
    }

    @Override
    public void onDeath() {
        GrenadeEntity.createExplosion(this, Config.COMMON.grenades.explosionRadius.get().floatValue(), true);
    }
}
