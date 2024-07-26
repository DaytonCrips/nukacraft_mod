package com.nukateam.nukacraft.common.foundation.entities.mobs;

import com.nukateam.nukacraft.client.helpers.AnimationHelper;
import com.nukateam.nukacraft.client.models.entity.EntityModel;
import com.nukateam.nukacraft.common.foundation.entities.misc.PowerArmorFrame;
import com.nukateam.nukacraft.common.foundation.variants.DeathclawVariant;
import com.nukateam.nukacraft.common.foundation.variants.SecuritronVariant;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.nukateam.nukacraft.common.data.constants.ArmorChassisAnimation.CLOSE;
import static com.nukateam.nukacraft.common.data.constants.ArmorChassisAnimation.OPEN;
import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static net.minecraft.network.syncher.SynchedEntityData.defineId;

public class Securitron extends Monster implements GeoEntity {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final boolean isServerSide = !level().isClientSide;
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Deathclaw.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> HAS_TARGET =
            defineId(Deathclaw.class, EntityDataSerializers.BOOLEAN);
    private final AnimationHelper<Securitron> animationHelper = new AnimationHelper<>(this, new EntityModel<Securitron>());

    public Securitron(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        getEntityData().set(HAS_TARGET, true);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason,
                                        @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        setVariant(Util.getRandom(SecuritronVariant.values(), random));
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
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
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.5D, false));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
//        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Raider.class, true));
//        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Animal.class, false));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(HAS_TARGET, false);
        entityData.define(VARIANT, 0);
    }

    @Override
    public void setTarget(@Nullable LivingEntity pTarget) {
        super.setTarget(pTarget);

        if (isServerSide) {
            hasTarget(pTarget != null);
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

    private AnimationController.AnimationStateHandler<Securitron> animateArms() {
        return event -> {
            var controller = event.getController();
            var animation = begin();
            controller.setAnimationSpeed(1);
            if (hasTarget()) {
                var animationName = getVariant().isUpgraded() ? "laser_mode" : "gun_mode";
                animation.thenPlayAndHold(animationName);
            }
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
            }
            else {
                animation.thenLoop("idle");
            }

            return event.setAndContinue(animation);
        };
    }


    @NotNull
    private AnimationController.AnimationStateHandler<Securitron> animateAntena() {
        return event -> event.setAndContinue( begin().thenLoop("antena"));
    }

    public void hasTarget(boolean hasTarget) {
        getEntityData().set(HAS_TARGET, hasTarget);
    }

    public boolean hasTarget(){
        return getEntityData().get(HAS_TARGET);
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
}