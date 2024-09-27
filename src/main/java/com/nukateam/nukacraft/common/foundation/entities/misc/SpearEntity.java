package com.nukateam.nukacraft.common.foundation.entities.misc;

import com.nukateam.nukacraft.common.registery.EntityTypes;
import com.nukateam.nukacraft.common.registery.items.ModWeapons;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.util.AzureLibUtil;
import mod.azure.azurelib.util.RenderUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

import static mod.azure.azurelib.util.AzureLibUtil.*;

public class SpearEntity extends AbstractArrow implements GeoAnimatable {
    public static final float DAMAGE = 8.0F;
    private final AnimatableInstanceCache cache = createInstanceCache(this);
    private ItemStack handmadeSpearItem;
    private boolean dealtDamage;

    public SpearEntity(EntityType<SpearEntity> type, Level level) {
        super(type, level);
        this.handmadeSpearItem = new ItemStack(ModWeapons.HANDMADE_SPEAR.get());
    }

    public SpearEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(EntityTypes.HANDMADE_SPEAR_ENTITY.get(), pShooter, pLevel);
        this.handmadeSpearItem = pStack.copy();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

//    @Override
//    public boolean shouldRender(double pX, double pY, double pZ) {
//        return true;
//    }

    @Override
    public void playerTouch(Player pEntity) {
        if (this.ownedBy(pEntity) || this.getOwner() == null)
            super.playerTouch(pEntity);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("Handmade Spear", 10))
            this.handmadeSpearItem = ItemStack.of(pCompound.getCompound("Handmade Spear"));

        this.dealtDamage = pCompound.getBoolean("DealtDamage");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.put("Handmade Spear", this.handmadeSpearItem.save(new CompoundTag()));
        pCompound.putBoolean("DealtDamage", this.dealtDamage);
    }

    @Override
    public void tickDespawn() {
        if (this.pickup != Pickup.ALLOWED) {
            super.tickDespawn();
        }
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4)
            this.dealtDamage = true;

        super.tick();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        this.dealtDamage = true;
        var target = pResult.getEntity();
        var owner = this.getOwner();
        var damageSource = this.damageSources().trident(this, owner == null ? this : owner);
        var soundEvent = SoundEvents.TRIDENT_HIT;

        if (target.hurt(damageSource, DAMAGE)) {
            if (target.getType() == EntityType.ENDERMAN) return;

            if (target instanceof LivingEntity livingEntity) {
                if (owner instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingEntity, owner);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity) owner, livingEntity);
                }

                this.doPostHurtEffects(livingEntity);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01, -0.1, -0.01));
        this.playSound(soundEvent, 1.0F, 1.0F);
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.handmadeSpearItem.copy();
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
        return this.dealtDamage ? null : super.findHitEntity(pStartVec, pEndVec);
    }

    @Override
    protected boolean tryPickup(Player player) {
        return super.tryPickup(player) || this.isNoPhysics() && this.ownedBy(player) && player.getInventory().add(this.getPickupItem());
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }

    @Override
    public double getTick(Object object) {
        return RenderUtils.getCurrentTick();
    }
}
