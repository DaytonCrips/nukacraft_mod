package com.nukateam.nukacraft.common.foundation.entities.mobs;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.client.helpers.AnimationHelper;
import com.nukateam.nukacraft.client.models.entity.EntityModel;
import com.nukateam.nukacraft.common.data.interfaces.IGunUser;
import com.nukateam.nukacraft.common.foundation.goals.GunAttackGoal;
import com.nukateam.nukacraft.common.foundation.goals.SecuritronRangedAttackGoal;
import com.nukateam.nukacraft.common.foundation.variants.SecuritronVariant;
import com.nukateam.nukacraft.common.registery.items.MobGuns;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.common.util.Lazy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static net.minecraft.network.syncher.SynchedEntityData.defineId;

public class Securitron extends PathfinderMob implements GeoEntity, IGunUser {
    private static final EntityDataAccessor<Boolean> HAS_TARGET = defineId(Securitron.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Securitron.class, EntityDataSerializers.INT);
    private static final int SHOOTING_START_TIME = 15;

    private final boolean isServerSide = !level().isClientSide;
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final Lazy<AnimationHelper<Securitron>> animationHelper = Lazy.of(() -> new AnimationHelper<>(this, new EntityModel<Securitron>()));

    public Securitron(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        getEntityData().set(HAS_TARGET, false);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 48);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new SecuritronRangedAttackGoal<>(this, 1.0D, 20.0F));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, this.getClass()));
        if (getVariant() == SecuritronVariant.BERSERK || getVariant() == SecuritronVariant.DAMAGED)
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Raider.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Monster.class, true));
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason,
                                        @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        setVariant(Util.getRandom(SecuritronVariant.values(), random));
        setupGuns();
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setTypeVariant(pCompound.getInt("Variant"));
    }

    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        return getType().getDimensions().scale(this.getScale());
    }

    @Override
    public float getScale() {
        var variant = getVariant();
        return variant.getScale();
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        var item = getGun();
        if (!item.isEmpty()) {
            try {
                GunAttackGoal.shoot(this, true);
//                ShootingHandler.get().fire(this, item);
            } catch (Exception e) {
                NukaCraftMod.LOGGER.error(e.getMessage(), e);
            }
        } else setupGuns();
    }

    @Override
    public ItemStack getGun() {
        return getMainHandItem();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(HAS_TARGET, false);
        entityData.define(VARIANT, 0);
    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        if (getVariant() == SecuritronVariant.MUGGY)
            target = null;

        super.setTarget(target);

        if (isServerSide) {
            hasTarget(target != null);
        }
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        if (VARIANT.equals(pKey)) {
            this.refreshDimensions();
        }

        super.onSyncedDataUpdated(pKey);
    }


    @Override
    public void tick() {
        super.tick();
        if (isServerSide) {
            getEntityData().set(HAS_TARGET, getTarget() != null);
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, animate()));
        controllers.add(new AnimationController<>(this, "armController", 0, animateArms()));
        controllers.add(new AnimationController<>(this, "antenaController", 0, animateAntena()));
    }

    private void setupGuns() {
        var gun = isUpgraded() ? MobGuns.SECURITRON_LASER : MobGuns.SECURITRON_GUN;
        setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(gun.get()));
    }

    private AnimationController.AnimationStateHandler<Securitron> animateArms() {
        return event -> {
            var controller = event.getController();
            var animation = begin();
            controller.setAnimationSpeed(1);

            if (hasTarget()) {
                var animationName = isUpgraded() ? "laser_mode" : "gun_mode";
                animation.thenPlayAndHold(animationName);
                animationHelper.get().syncAnimation(event, animationName, SHOOTING_START_TIME);
            } else if (controller.getCurrentAnimation() != null) {
                var animationName = isUpgraded() ? "laser_mode_end" : "gun_mode_end";
                animation.thenPlay(animationName);
                animationHelper.get().syncAnimation(event, animationName, SHOOTING_START_TIME);
            } else return PlayState.STOP;

            return event.setAndContinue(animation);
        };
    }

    @NotNull
    private AnimationController.AnimationStateHandler<Securitron> animate() {
        return event -> {
            var controller = event.getController();
            var animation = begin();
            controller.setAnimationSpeed(1);
            if (event.isMoving()) {
                animation.thenLoop("walk");
                controller.setAnimationSpeed(2);
            } else {
                animation.thenLoop("idle");
            }

            return event.setAndContinue(animation);
        };
    }

    @NotNull
    private AnimationController.AnimationStateHandler<Securitron> animateAntena() {
        return event -> event.setAndContinue(begin().thenLoop("antena"));
    }

    public void hasTarget(boolean hasTarget) {
        getEntityData().set(HAS_TARGET, hasTarget);
    }

    public boolean hasTarget() {
        return getEntityData().get(HAS_TARGET);
    }

    public int getAttackDelay() {
        return SHOOTING_START_TIME;
    }

    public SecuritronVariant getVariant() {
        return SecuritronVariant.byId(this.getTypeVariant() & 255);
    }

    private void setVariant(SecuritronVariant variant) {
        this.setTypeVariant(variant.ordinal() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(VARIANT);
    }

    private void setTypeVariant(int pTypeVariant) {
        this.entityData.set(VARIANT, pTypeVariant);
    }

    private boolean isUpgraded() {
        return getVariant().isUpgraded();
    }
}