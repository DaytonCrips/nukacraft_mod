package com.nukateam.nukacraft.common.foundation.entities.grenades;

import com.nukateam.ntgl.Config;
import com.nukateam.ntgl.common.foundation.entity.GrenadeEntity;
import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.ntgl.common.foundation.entity.ThrowableItemEntity;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import static com.nukateam.nukacraft.common.registery.items.ModWeapons.MOLOTOV_COLA;

public class MolotovColaEntity  extends ThrowableGrenadeEntity {
    public MolotovColaEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public MolotovColaEntity(Level world, LivingEntity entity, int timeLeft) {
        super(EntityTypes.MOLOTOV_COLA_ENTITY.get(), world, entity);
        this.setShouldBounce(true);
        this.setGravityVelocity(0.05F);
        this.setItem(new ItemStack(MOLOTOV_COLA.get()));
        this.setMaxLife(timeLeft);
    }

    @Override
    protected void onHit(HitResult result) {
        GrenadeUtils.createFireExplosion(this, 2.0F, true);
        GrenadeEntity.createExplosion(this, ((Double) Config.COMMON.grenades.explosionRadius.get()).floatValue(), false);
        this.remove(Entity.RemovalReason.KILLED);
    }
}
