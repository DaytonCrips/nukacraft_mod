package com.nukateam.nukacraft.common.foundation.entities.misc;


import com.nukateam.guns.common.base.gun.Gun;
import com.nukateam.guns.common.foundation.entity.ProjectileEntity;
import com.nukateam.guns.common.foundation.item.GunItem;
import com.nukateam.nukacraft.common.settings.ExplosionTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import static com.nukateam.nukacraft.client.helpers.ExplosionUtils.createNuclearExplosion;

public class MiniNukeEntity extends ProjectileEntity {
    public MiniNukeEntity(EntityType<? extends ProjectileEntity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public MiniNukeEntity(EntityType<? extends ProjectileEntity> entityType, Level worldIn, LivingEntity shooter, ItemStack weapon, GunItem item, Gun modifiedGun) {
        super(entityType, worldIn, shooter, weapon, item, modifiedGun);
    }

    @Override
    protected void onProjectileTick() {
        if (this.level.isClientSide) {
            for (int i = 5; i > 0; i--) {
                this.level.addParticle(ParticleTypes.CLOUD, true, this.getX() - (this.getDeltaMovement().x() / i), this.getY() - (this.getDeltaMovement().y() / i), this.getZ() - (this.getDeltaMovement().z() / i), 0, 0, 0);
            }
            if (this.level.random.nextInt(2) == 0) {
                this.level.addParticle(ParticleTypes.SMOKE, true, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
                //this.level.addParticle(ParticleTypes.FLAME, true, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
            }
        }
    }

    private void explode() {
        createNuclearExplosion(this, ExplosionTypes.MINI_NUKE);
    }

    @Override
    protected void onHitEntity(Entity entity, Vec3 hitVec, Vec3 startVec, Vec3 endVec, boolean headshot) {
        //createExplosion(this, 20f, false);
        explode();
    }

    @Override
    protected void onHitBlock(BlockState state, BlockPos pos, Direction face, double x, double y, double z) {
        //createExplosion(this, 20f, false);
        explode();
    }

    @Override
    public void onExpired() {
        //createExplosion(this, 20f, false);
        explode();
    }
}
