package com.nukateam.nukacraft.common.foundation.entities.mobs;

import com.jetug.chassis_core.common.util.helpers.timer.PlayOnceTimerTask;
import com.jetug.chassis_core.common.util.helpers.timer.TickTimer;
import com.nukateam.ntgl.client.data.handler.ShootingHandler;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.nukacraft.client.helpers.AnimationHelper;
import com.nukateam.nukacraft.client.models.entity.EntityModel;
import com.nukateam.nukacraft.common.data.interfaces.IGunUser;
import com.nukateam.nukacraft.common.foundation.goals.AssaultronAttackGoal;
import com.nukateam.nukacraft.common.foundation.goals.GeoMeleeAttackGoal;
import com.nukateam.nukacraft.common.registery.items.ModWeapons;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.Animation.LoopType.*;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static net.minecraft.network.syncher.SynchedEntityData.defineId;

public class Assaultron extends PathfinderMob implements GeoEntity, IGunUser, ITriggerProvider {
    public static final EntityDataAccessor<Boolean> IS_AGGRESSIVE = defineId(Assaultron.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> IS_SHOOTING_LASER = defineId(Assaultron.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> LASER_COOLDOWN = defineId(Assaultron.class, EntityDataSerializers.INT);
    public static final String TRIGGER = "trigger";

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final boolean isServerSide = !level().isClientSide;
    private final AnimationHelper<Assaultron> animationHelper = new AnimationHelper<>(this, new EntityModel<Assaultron>());
    private final TickTimer serverTimer = new TickTimer();
    private boolean startAttacking = false;
    private String attackAnimName;
    private String[] attackAnims = new String[]{
            "attack_right",
            "attack_left" ,
            "attack"
    };

    AnimationController<Assaultron> triggersController = new AnimationController<>(this, TRIGGER, event -> PlayState.CONTINUE)
            .triggerableAnim("attack_right", begin().then("attack_right", PLAY_ONCE))
            .triggerableAnim("attack_left" , begin().then("attack_left" , PLAY_ONCE))
            .triggerableAnim("attack"      , begin().then("attack"      , PLAY_ONCE))
            .setAnimationSpeed(2);

    public Assaultron(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        var gun = (GunItem)getGun().getItem();
        resetLaserCooldown(gun);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 75)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.FOLLOW_RANGE, 48);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new AssaultronAttackGoal<>(this, 0.7D, 20.0F));
        this.goalSelector.addGoal(4, new GeoMeleeAttackGoal<>(this, 1.5D, false));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Raider.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class, false));
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason,
                                        @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
//        setVariant(Util.getRandom(SecuritronVariant.values(), random));
        setupGuns();
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    private void setupGuns() {
        setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModWeapons.ASSAULTRON_LASER.get()));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(IS_AGGRESSIVE, false);
        entityData.define(IS_SHOOTING_LASER, false);
        entityData.define(LASER_COOLDOWN, 0);
//        entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    @Override
    public void setTarget(@Nullable LivingEntity pTarget) {
        super.setTarget(pTarget);

        if (isServerSide) {
            setIsAggressive(pTarget != null);
        }
    }

    public boolean isShootingLaser(){
        return entityData.get(IS_SHOOTING_LASER);
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        var item = getGun();
        ShootingHandler.get().fire(this, item);
        var gun = (GunItem)item.getItem();
        var laserDuration = gun.getModifiedGun(item).getProjectile().getLife();
        entityData.set(IS_SHOOTING_LASER, true);

        serverTimer.addTimer(new PlayOnceTimerTask(laserDuration, () -> {
            resetLaserCooldown(gun);
            entityData.set(IS_SHOOTING_LASER, false);
        }));
    }

    @Override
    public ItemStack getGun() {
        if(!(getMainHandItem().getItem() instanceof GunItem))
            setupGuns();

        return getMainHandItem();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(ControllerRegistrar controllers) {
        controllers.add(triggersController);
        controllers.add(new AnimationController<>(this, "controller1", 0, animateArms()));
        controllers.add(new AnimationController<>(this, "controller2", 0, animateLegs()));
    }

    @Override
    public void tick() {
        super.tick();
        if(isServerSide){
            serverTimer.tick();
            decreaseLaserCooldown();

            getEntityData().set(IS_AGGRESSIVE, getTarget() != null);
        }
    }

    private void resetLaserCooldown(GunItem gun) {
        setLaserCooldown(gun.getGun().getGeneral().getReloadTime());
    }

    public int getLaserCooldown() {
        return getEntityData().get(LASER_COOLDOWN);
    }

    public void setLaserCooldown(int value) {
        getEntityData().set(LASER_COOLDOWN, value);
    }

    public void decreaseLaserCooldown() {
        if(getLaserCooldown() > 0)
            setLaserCooldown(getLaserCooldown() - 1);
    }

    @Override
    protected void dropEquipment() {
        super.dropEquipment();
    }

    @Override
    protected boolean shouldDropLoot() {

        dropEquipment();

        return super.shouldDropLoot();
    }

    public void setIsAggressive(boolean isRunning) {
        getEntityData().set(IS_AGGRESSIVE, isRunning);

        if (isRunning)
            setSpeed(1.5f);
        else setSpeed((float) getAttributeValue(Attributes.MOVEMENT_SPEED));
    }

    public boolean isReadyToShoot() {
        return getLaserCooldown() == 0 && getEntityData().get(IS_AGGRESSIVE);
    }

    @NotNull
    private AnimationController.AnimationStateHandler<Assaultron> animateArms() {
        return event -> {
//            var controller = event.getController();
//            var animation = begin();
//            var isAggressive = getEntityData().get(IS_AGGRESSIVE);
//            controller.setAnimationSpeed(1);
//
//            if (event.isMoving()) {
//                if(isAggressive){
//                    animation.thenLoop("run_arms");
//                    controller.setAnimationSpeed(3);
//                }
//                else {
//                    animation.thenLoop("walk_arms");
//                    controller.setAnimationSpeed(2);
//                }
//            }
//            else
                return PlayState.STOP;

//            return event.setAndContinue(animation);
        };
    }

    @NotNull
    private AnimationController.AnimationStateHandler<Assaultron> animateLegs() {
        return event -> {
            var controller = event.getController();
            var animation = begin();
            var isAggressive = getEntityData().get(IS_AGGRESSIVE);
            controller.setAnimationSpeed(1);

            if(isReadyToShoot() || isShootingLaser()){
                animation.thenPlayAndHold("laser_start");
            }
            else if(controller.getCurrentAnimation() != null &&
                    controller.getCurrentAnimation().animation().name().equals("laser_start")){
                animation.then("laser_end", PLAY_ONCE);
            }
            else if (event.isMoving()) {
                if(isAggressive){
                    animation.thenLoop("run_legs");
                    controller.setAnimationSpeed(3);
                }
                else {
                    animation.thenLoop("walk_legs");
                    controller.setAnimationSpeed(2);
                }
            }
            else {
                if(isAggressive) {
                    if(controller.getCurrentAnimation() != null &&
                            controller.getCurrentAnimation().animation().name().equals("idle"))
                        animation.thenPlayAndHold("aggressive_start");
                    else animation.thenLoop("aggressive");
                }
                else animation.thenLoop("idle");
            }

            return event.setAndContinue(animation);
        };
    }

    @Override
    public void onAttack() {
        if (!startAttacking) {
            startAttacking = true;
            attackAnimName = attackAnims[random.nextInt(0, attackAnims.length)];
        }

        triggerAnim(TRIGGER,attackAnimName);
    }

//    public DeathclawVariant getVariant() {
//        return DeathclawVariant.byId(this.getTypeVariant() & 255);
//    }
//
//    private void setVariant(DeathclawVariant variant) {
//        this.setTypeVariant(variant.getId() & 255);
//    }
//
//    public int getTypeVariant() {
//        return this.entityData.get(DATA_ID_TYPE_VARIANT);
//    }
//
//    private void setTypeVariant(int pTypeVariant) {
//        this.entityData.set(DATA_ID_TYPE_VARIANT, pTypeVariant);
//    }
}