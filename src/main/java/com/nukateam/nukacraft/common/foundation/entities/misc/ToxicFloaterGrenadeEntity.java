package com.nukateam.nukacraft.common.foundation.entities.misc;

import com.nukateam.ntgl.common.foundation.entity.GrenadeEntity;
import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.ntgl.common.foundation.entity.ThrowableItemEntity;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;

import static com.nukateam.nukacraft.common.registery.items.ModWeapons.GRENADE_TOXIC_FLOATER;

public class ToxicFloaterGrenadeEntity extends ThrowableGrenadeEntity {
    public float rotation;
    public float prevRotation;

    public ToxicFloaterGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public ToxicFloaterGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level world, LivingEntity entity) {
        super(entityType, world, entity);
        this.setShouldBounce(true);
        this.setGravityVelocity(0.05F);
        this.setItem(new ItemStack(GRENADE_TOXIC_FLOATER.get()));
        this.setMaxLife(60);
    }

    public ToxicFloaterGrenadeEntity(Level world, LivingEntity entity, int timeLeft) {
        super(EntityTypes.TOXIC_FLOATER_GRENADE_ENTITY.get(), world, entity);
        this.setShouldBounce(true);
        this.setGravityVelocity(0.05F);
        this.setItem(new ItemStack(GRENADE_TOXIC_FLOATER.get()));
        this.setMaxLife(timeLeft);
    }

    protected void defineSynchedData() {
    }

    public void tick() {
        super.tick();
        this.prevRotation = this.rotation;
        double speed = this.getDeltaMovement().length();
        if (speed > 0.1) {
            this.rotation = (float)((double)this.rotation + speed * 50.0);
        }

        if (this.level().isClientSide) {
            this.level().addParticle(ParticleTypes.SMOKE, true, this.getX(), this.getY() + 0.25, this.getZ(), 0.0, 0.0, 0.0);
        }

    }

    public boolean alwaysAccepts() {
        return super.alwaysAccepts();
    }

    @Override
    public void onDeath(){
        level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 1.0F, -1.0F);
        createToxicCloud(5.0F, true);}



    private void createToxicCloud(float radius, boolean forceNone)
    {


        AreaEffectCloud cloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
        cloud.setRadius(radius + 1.0F);
        cloud.setRadiusOnUse(-0.5F);
        cloud.setWaitTime(10);
        cloud.setRadiusPerTick(-cloud.getRadius() / (float)cloud.getDuration());
        cloud.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 9));
        //cloud.setPotion(Potions.POISON);

        this.level().addFreshEntity(cloud);
//        Level world = entity.level();
//        if(world.isClientSide())
//            return;
//
//        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 1.0F, 1.0F);
//        DamageSource source = entity instanceof ProjectileEntity projectile ? entity.damageSources().explosion(entity, projectile.getShooter()) : null;
//        Explosion.BlockInteraction mode = Explosion.BlockInteraction.KEEP;
//        Explosion explosion = new ProjectileExplosion(world, entity, source, null, entity.getX(), entity.getY(), entity.getZ(), radius, true, mode);
//
//        if(net.minecraftforge.event.ForgeEventFactory.onExplosionStart(world, explosion))
//            return;
//
//        // Do explosion logic
//        explosion.explode();
//        explosion.finalizeExplosion(true);

    }

}
