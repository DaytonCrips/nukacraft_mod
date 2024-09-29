package com.nukateam.nukacraft.common.foundation.entities.grenades;

import com.nukateam.ntgl.Config;
import com.nukateam.ntgl.common.foundation.entity.GrenadeEntity;
import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.ntgl.common.foundation.entity.ThrowableItemEntity;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.nukateam.nukacraft.common.registery.items.ModWeapons.HOLY_GRENADE;


public class HolyGrenadeEntity extends ThrowableGrenadeEntity {
    public float rotation;
    public float prevRotation;

    public HolyGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public HolyGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level world, LivingEntity entity) {
        super(entityType, world, entity);
        this.setShouldBounce(true);
        this.setGravityVelocity(0.05F);
        this.setItem(new ItemStack(HOLY_GRENADE.get()));
        this.setMaxLife(60);
    }

    public HolyGrenadeEntity(Level world, LivingEntity entity, int timeLeft) {
        super(EntityTypes.HOLY_GRENADE_ENTITY.get(), world, entity);
        this.setShouldBounce(true);
        this.setGravityVelocity(0.05F);
        this.setItem(new ItemStack(HOLY_GRENADE.get()));
        this.setMaxLife(timeLeft);
    }
    public void tick() {
        super.tick();
        this.prevRotation = this.rotation;
        double speed = this.getDeltaMovement().length();
        if (speed > 0.1) {
            this.rotation = (float)((double)this.rotation + speed * 50.0);
        }

        if (this.level().isClientSide) {
            this.level().addParticle(ParticleTypes.SMOKE, true, this.getX(), this.getY() + 0.15, this.getZ(), 0.0, 0.0, 0.0);
        }

    }

    public void onDeath() {
        GrenadeEntity.createExplosion(this, Config.COMMON.grenades.explosionRadius.get().floatValue() + 6, true);
    }

    public boolean alwaysAccepts() {
        return super.alwaysAccepts();
    }
}
