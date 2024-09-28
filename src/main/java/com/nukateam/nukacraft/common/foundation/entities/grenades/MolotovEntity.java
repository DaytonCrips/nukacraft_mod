package com.nukateam.nukacraft.common.foundation.entities.grenades;

import com.nukateam.ntgl.common.foundation.entity.ThrowableGrenadeEntity;
import com.nukateam.ntgl.common.foundation.entity.ThrowableItemEntity;
import com.nukateam.nukacraft.common.registery.EntityTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import static com.nukateam.nukacraft.common.registery.items.ModWeapons.MOLOTOV_COCKTAIL;

public class MolotovEntity extends ThrowableGrenadeEntity {
    public MolotovEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    public MolotovEntity(Level world, LivingEntity entity, int timeLeft) {
        super(EntityTypes.COCKTAIL_MOLOTOV_ENTITY.get(), world, entity);
        this.setShouldBounce(true);
        this.setGravityVelocity(0.05F);
        this.setItem(new ItemStack(MOLOTOV_COCKTAIL.get()));
        this.setMaxLife(timeLeft);
    }

    @Override
    protected void onHit(HitResult result) {
        GrenadeUtils.createFireExplosion(this, 2.0F, true);
        this.remove(Entity.RemovalReason.KILLED);
    }
}
