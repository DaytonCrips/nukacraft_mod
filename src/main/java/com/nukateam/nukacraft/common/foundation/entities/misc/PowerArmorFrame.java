package com.nukateam.nukacraft.common.foundation.entities.misc;

import com.google.common.collect.ImmutableMap;
import com.jetug.chassis_core.common.foundation.entity.ChassisBase;
import com.jetug.chassis_core.common.foundation.entity.HandEntity;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.container.PowerArmorMenu;
import com.nukateam.nukacraft.common.foundation.container.PowerArmorStationMenu;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Raider;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

import static com.jetug.chassis_core.common.foundation.item.DamageableItem.damageItem;
import static com.nukateam.nukacraft.common.data.constants.ArmorChassisAnimation.*;
import static com.nukateam.nukacraft.common.data.constants.PowerArmorPrats.FUSION_CORE;
import static com.nukateam.nukacraft.common.data.constants.PowerArmorPrats.JETPACK;
import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.Animation.LoopType.*;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static net.minecraft.network.syncher.SynchedEntityData.defineId;

public class PowerArmorFrame extends WearableChassis {
    public static final ResourceLocation ICON = new ResourceLocation(NukaCraftMod.MOD_ID, "textures/item/power_armor_frame.png");
    public static final PowerArmorHand HAND = new PowerArmorHand();
    public static final EntityDataAccessor<Boolean> IS_OPEN = defineId(PowerArmorFrame.class, EntityDataSerializers.BOOLEAN);
    public static final String TRIGGER_CONTROLLER = "baseAnim";
    public static final EntityDimensions STANDING_DIMENSIONS = EntityDimensions.scalable(1.0f, 2.3f);
    public static final EntityDimensions CROUCHING_DIMENSIONS = EntityDimensions.scalable(1.0f, 2.0f);
    private static final Map<Pose, EntityDimensions> POSES = ImmutableMap.<Pose, EntityDimensions>builder()
            .put(Pose.STANDING, STANDING_DIMENSIONS)
            .put(Pose.CROUCHING, CROUCHING_DIMENSIONS)
            .build();

    public static AttributeSupplier.Builder createAttributes() {
        return ChassisBase.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 1000.0)
                .add(Attributes.ATTACK_DAMAGE, 0.0)
                .add(Attributes.MOVEMENT_SPEED, 0.1)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0)
                .add(Attributes.JUMP_STRENGTH, 0.5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8);
    }


    public static HashMap<String, Integer> POWER_ARMOR_PART_IDS;

    static {
        POWER_ARMOR_PART_IDS = (HashMap<String, Integer>) PART_IDS.clone();
        addSlot(FUSION_CORE);
        addSlot(JETPACK);
    }

    public RawAnimation armsAnimation = null;
    public RawAnimation legsAnimation = null;
    private int tickCounter = 0;
    protected int sprintTriggerTime;
    private boolean crouching;

    public PowerArmorFrame(EntityType<? extends WearableChassis> type, Level worldIn) {
        super(type, worldIn, POWER_ARMOR_PART_IDS);
    }

//    @Override
//    public Collection<String> getEquipment() {
//        return List.of(armorParts);
//    }


//    @Override
//    public boolean isAttackable() {
//        return false;
//    }



    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(IS_OPEN, false);
    }

    @Override
    public boolean renderHand() {
        return false;
    }

    public void open() {
        entityData.set(IS_OPEN, true);
        this.triggerAnim(TRIGGER_CONTROLLER, OPEN);
    }

    public void close() {
        entityData.set(IS_OPEN, false);
        this.triggerAnim(TRIGGER_CONTROLLER, CLOSE);
    }

    @Override
    public void positionRider(Entity entity, Entity.MoveFunction pCallback) {
        super.positionRider(entity, pCallback);

        var passenger = getControllingPassenger();
        if (passenger == null) return;

        var yOffset =  1.0f;
        var posY = getY() + getPassengersRidingOffset() + entity.getMyRidingOffset() - yOffset;
        entity.setPos(getX(), posY, getZ());

        if (entity instanceof LivingEntity livingEntity)
            livingEntity.yBodyRot = yBodyRot;

        if (entity instanceof Raider) {
            entity.setPos(this.position());
        }
    }

    @Override
    public void tick() {
        doSafe(super::tick);

        if (tickCounter >= 20) {
            rareTick();
            tickCounter = 0;
        } else {
            tickCounter++;
        }

        updatePose();
    }

    @Override
    public @NotNull EntityDimensions getDimensions(@NotNull Pose pPose) {
        return POSES.getOrDefault(pPose, STANDING_DIMENSIONS);
    }

    protected float getCrouchingSpeed(){
        return getSpeedAttribute() / 2f;
    }

    protected float getSprintingSpeed(){
        return getSpeedAttribute() * 1.5f;
    }

    protected void updatePose() {
        Pose pose;
        if (hasPlayerPassenger() && getPlayerPassenger().isShiftKeyDown()) {
            pose = Pose.CROUCHING;
            setSpeed(getCrouchingSpeed());

        } else {
            pose = Pose.STANDING;
            if(hasPlayerPassenger() && getPlayerPassenger().isSprinting())
                setSpeed(getSprintingSpeed());
            else
                setSpeed(getSpeedAttribute());
        }

        if (!hasEnergy()) {
            setSpeed(getMinSpeed());
        }

        this.setPose(pose);
    }

//    private boolean hasEnoughImpulseToStartSprinting(LocalPlayer player) {
//        double d0 = 0.8D;
//        return this.isUnderWater() ? player.input.hasForwardImpulse() : (double)player.input.forwardImpulse >= 0.8D;
//    }
//
//    public boolean isMovingSlowly() {
//        return this.isCrouching() || this.isVisuallyCrawling();
//    }

//    @Override
//    public void aiStep() {
//        super.aiStep();
//
//        var passenger = getControllingPassenger();
//
//        if (isClientSide && passenger instanceof LocalPlayer player) {
//            if (this.sprintTriggerTime > 0) {
//                --this.sprintTriggerTime;
//            }
//
//            var input = player.input;
//
//            boolean flag = input.jumping;
//            boolean flag1 = input.shiftKeyDown;
//            boolean flag2 = hasEnoughImpulseToStartSprinting(player);
//            this.crouching = !this.isSwimming()
//                    && this.canEnterPose(Pose.CROUCHING)
//                    && (player.isShiftKeyDown()
//                        || !this.isSleeping()
//                        && !this.canEnterPose(Pose.STANDING));
//
//            float f = Mth.clamp(0.3F + EnchantmentHelper.getSneakingSpeedBonus(this), 0.0F, 1.0F);
//            input.tick(this.isMovingSlowly(), f);
//            net.minecraftforge.client.ForgeHooksClient.onMovementInputUpdate(this, input);
////            this.minecraft.getTutorial().onInput(input);
//
//            if (this.isUsingItem() && !this.isPassenger()) {
//                input.leftImpulse *= 0.2F;
//                input.forwardImpulse *= 0.2F;
//                this.sprintTriggerTime = 0;
//            }
//
//            boolean flag3 = false;
//
//
////            if (!this.noPhysics) {
////                this.moveTowardsClosestSpace(this.getX() - (double) this.getBbWidth() * 0.35D, this.getZ() + (double) this.getBbWidth() * 0.35D);
////                this.moveTowardsClosestSpace(this.getX() - (double) this.getBbWidth() * 0.35D, this.getZ() - (double) this.getBbWidth() * 0.35D);
////                this.moveTowardsClosestSpace(this.getX() + (double) this.getBbWidth() * 0.35D, this.getZ() - (double) this.getBbWidth() * 0.35D);
////                this.moveTowardsClosestSpace(this.getX() + (double) this.getBbWidth() * 0.35D, this.getZ() + (double) this.getBbWidth() * 0.35D);
////            }
//
//            if (flag1) {
//                this.sprintTriggerTime = 0;
//            }
//
//            boolean flag4 = this.canStartSprinting();
//            boolean flag5 = this.isPassenger() ? this.getVehicle().onGround() : this.onGround();
//            boolean flag6 = !flag1 && !flag2;
//            if ((flag5 || this.isUnderWater() || this.canStartSwimming()) && flag6 && flag4) {
//                if (this.sprintTriggerTime <= 0 && !this.minecraft.options.keySprint.isDown()) {
//                    this.sprintTriggerTime = 7;
//                } else {
//                    this.setSprinting(true);
//                }
//            }
//
//            if (!this.isSprinting() && (!(this.isInWater() || this.isInFluidType((fluidType, height) -> this.canSwimInFluidType(fluidType))) || (this.isUnderWater() || this.canStartSwimming())) && this.hasEnoughImpulseToStartSprinting() && flag4 && !this.isUsingItem() && !this.hasEffect(MobEffects.BLINDNESS) && this.minecraft.options.keySprint.isDown()) {
//                this.setSprinting(true);
//            }
//
//            if (this.isSprinting()) {
//                boolean flag7 = !input.hasForwardImpulse() || !this.hasEnoughFoodToStartSprinting();
//                boolean flag8 = flag7 || this.horizontalCollision && !this.minorHorizontalCollision || this.isInWater() && !this.isUnderWater() || (this.isInFluidType((fluidType, height) -> this.canSwimInFluidType(fluidType)) && !this.canStartSwimming());
//                if (this.isSwimming()) {
//                    if (!this.onGround() && !input.shiftKeyDown && flag7 || !(this.isInWater() || this.isInFluidType((fluidType, height) -> this.canSwimInFluidType(fluidType)))) {
//                        this.setSprinting(false);
//                    }
//                } else if (flag8) {
//                    this.setSprinting(false);
//                }
//            }
//
//            boolean flag9 = false;
//            if (this.getAbilities().mayfly) {
//                if (this.minecraft.gameMode.isAlwaysFlying()) {
//                    if (!this.getAbilities().flying) {
//                        this.getAbilities().flying = true;
//                        flag9 = true;
//                        this.onUpdateAbilities();
//                    }
//                } else if (!flag && input.jumping && !flag3) {
//                    if (this.jumpTriggerTime == 0) {
//                        this.jumpTriggerTime = 7;
//                    } else if (!this.isSwimming()) {
//                        this.getAbilities().flying = !this.getAbilities().flying;
//                        flag9 = true;
//                        this.onUpdateAbilities();
//                        this.jumpTriggerTime = 0;
//                    }
//                }
//            }
//
//            if (input.jumping && !flag9 && !flag && !this.getAbilities().flying && !this.isPassenger() && !this.onClimbable()) {
//                ItemStack itemstack = this.getItemBySlot(EquipmentSlot.CHEST);
//                if (itemstack.canElytraFly(this) && this.tryToStartFallFlying()) {
//                    this.connection.send(new ServerboundPlayerCommandPacket(this, ServerboundPlayerCommandPacket.Action.START_FALL_FLYING));
//                }
//            }
//
//            this.wasFallFlying = this.isFallFlying();
//            net.minecraftforge.fluids.FluidType fluidType = this.getMaxHeightFluidType();
//            if ((this.isInWater() || (!fluidType.isAir() && this.canSwimInFluidType(fluidType))) && input.shiftKeyDown && this.isAffectedByFluids()) {
//                this.sinkInFluid(this.isInWater() ? net.minecraftforge.common.ForgeMod.WATER_TYPE.get() : fluidType);
//            }
//
//            if (this.isEyeInFluid(FluidTags.WATER)) {
//                int i = this.isSpectator() ? 10 : 1;
//                this.waterVisionTime = Mth.clamp(this.waterVisionTime + i, 0, 600);
//            } else if (this.waterVisionTime > 0) {
//                this.isEyeInFluid(FluidTags.WATER);
//                this.waterVisionTime = Mth.clamp(this.waterVisionTime - 10, 0, 600);
//            }
//
//            if (this.getAbilities().flying && this.isControlledCamera()) {
//                int j = 0;
//                if (input.shiftKeyDown) {
//                    --j;
//                }
//
//                if (input.jumping) {
//                    ++j;
//                }
//
//                if (j != 0) {
//                    this.setDeltaMovement(this.getDeltaMovement().add(0.0D, (double) ((float) j * this.getAbilities().getFlyingSpeed() * 3.0F), 0.0D));
//                }
//            }
//
//            PlayerRideableJumping playerrideablejumping = this.jumpableVehicle();
//            if (playerrideablejumping != null && playerrideablejumping.getJumpCooldown() == 0) {
//                if (this.jumpRidingTicks < 0) {
//                    ++this.jumpRidingTicks;
//                    if (this.jumpRidingTicks == 0) {
//                        this.jumpRidingScale = 0.0F;
//                    }
//                }
//
//                if (flag && !input.jumping) {
//                    this.jumpRidingTicks = -10;
//                    playerrideablejumping.onPlayerJump(Mth.floor(this.getJumpRidingScale() * 100.0F));
//                    this.sendRidingJump();
//                } else if (!flag && input.jumping) {
//                    this.jumpRidingTicks = 0;
//                    this.jumpRidingScale = 0.0F;
//                } else if (flag) {
//                    ++this.jumpRidingTicks;
//                    if (this.jumpRidingTicks < 10) {
//                        this.jumpRidingScale = (float) this.jumpRidingTicks * 0.1F;
//                    } else {
//                        this.jumpRidingScale = 0.8F + 2.0F / (float) (this.jumpRidingTicks - 9) * 0.1F;
//                    }
//                }
//            } else {
//                this.jumpRidingScale = 0.0F;
//            }
//
//            super.aiStep();
//            if (this.onGround() && this.getAbilities().flying && !this.minecraft.gameMode.isAlwaysFlying()) {
//                this.getAbilities().flying = false;
//                this.onUpdateAbilities();
//            }
//        }
//
//    }

    public static int getId(String chassisPart) {
        return POWER_ARMOR_PART_IDS.get(chassisPart);
    }

    private static void addSlot(String slot) {
        POWER_ARMOR_PART_IDS.put(slot, PART_IDS.size());
    }

    private void rareTick() {
        if (isClientSide || !hasFusionCore()) return;
        var core = getFusionCore();
        var dmg = core.getMaxDamage() - core.getDamageValue();
        if (dmg <= 0) {
            setEquipment(FUSION_CORE, ItemStack.EMPTY);
        }

        if (isWalking()) {
            damageItem(core, 1);
        }
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vector, InteractionHand hand) {
        if (this.isServerSide && !player.isPassenger() && hand == InteractionHand.MAIN_HAND) {
            if (!this.isVehicle()) {
                if (player.isShiftKeyDown()) {
                    if (entityData.get(IS_OPEN)) {
                        close();
                    } else this.openGUI(player);
                    return InteractionResult.SUCCESS;
                }

                if (entityData.get(IS_OPEN)) {
                    this.ride(player);
                    close();
                } else {
                    open();
                }
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public boolean hurt(DamageSource damageSource, float damage) {
        if (damageSource.is(DamageTypes.FALL)) {
            damageArmor(damageSource, damage);
            return false;
        } else return super.hurt(damageSource, damage);
    }

    @Override
    public boolean causeFallDamage(float height, float pMultiplier, DamageSource damageSource) {
        var damage = calculateFallDamage(height, pMultiplier);
        if (damage >= 0)
            hurt(damageSource, damage);
        return false;
    }

    @Override
    public ResourceLocation getIcon() {
        return ICON;
    }

    @Override
    public HandEntity getHandEntity() {
        return HAND;
    }

    public ItemStack getFusionCore() {
        return getEquipment(FUSION_CORE);
    }

//    @Override
//    protected void createPartIdMap() {
//        //super.createPartIdMap();
//        int i = inventorySize;
//        this.partIdMap.put(FUSION_CORE, i++);
//        this.inventorySize = i;
//    }

    public boolean hasFusionCore() {
        return hasEquipment(FUSION_CORE);
    }

    public boolean hasEnergy() {
        return hasFusionCore();
    }

    @Override
    public void jump() {
        if (hasEnergy())
            super.jump();
    }

//    @Override
//    protected void updateSpeed() {
//        if (hasEnergy()) {
//            if(isCrouching())
//                setSpeed(getSpeedAttribute() / 2);
//            else setSpeed(getSpeedAttribute());
//        }
//        else {
//            setSpeed(getMinSpeed());
//        }
//    }

    @Override
    public MenuProvider getMenuProvider() {
        return new MenuProvider() {
            @Override
            public AbstractContainerMenu createMenu(int id, Inventory menu, Player player) {
                return new PowerArmorMenu(id, inventory, menu, PowerArmorFrame.this);
            }

            @Override
            public Component getDisplayName() {
                return PowerArmorFrame.this.getDisplayName();
            }
        };
    }

    @Override
    protected MenuProvider getStantionMenuProvider() {
        return new MenuProvider() {
            @Override
            public AbstractContainerMenu createMenu(int id, Inventory menu, Player player) {
                return new PowerArmorStationMenu(id, inventory, menu, PowerArmorFrame.this);
            }

            @Override
            public Component getDisplayName() {
                return PowerArmorFrame.this.getDisplayName();
            }
        };
    }

    public Boolean isWalking() {
//        return
//                Minecraft.getInstance().options.keyUp.isDown() ||
//                Minecraft.getInstance().options.keyDown.isDown() ||
//                Minecraft.getInstance().options.keyLeft.isDown() ||
//                Minecraft.getInstance().options.keyRight.isDown();
        return speedometer.getSpeed() > 0;
    }

    public boolean passengerHaveGun() {
        return hasPassenger() && getControllingPassenger().getMainHandItem().getItem() instanceof GunItem;
    }

    @Nullable
    public GunItem getPassengerGun() {
        if (passengerHaveGun())
            return (GunItem) getControllingPassenger().getMainHandItem().getItem();
        return null;
    }

    @Override
    public boolean isOnFire() {
        return false;
    }

    AnimationController<PowerArmorFrame> triggersController = new AnimationController<>(this, TRIGGER_CONTROLLER, event -> PlayState.CONTINUE)
            .triggerableAnim(OPEN, begin().thenPlayAndHold(OPEN))
            .triggerableAnim(CLOSE, begin().thenPlay(CLOSE));

    @Override
    public void registerControllers(ControllerRegistrar controllers) {
        controllers.add(triggersController);
        controllers.add(new AnimationController<>(this, "arm_controller", 0, animateArms()));
        controllers.add(new AnimationController<>(this, "leg_controller", 0, animateLegs()));
//        controllers.add(new AnimationController<>(this, "common_controller", 0, animateCommon()));
    }

    private AnimationController.AnimationStateHandler<PowerArmorFrame> animateCommon() {
        return event -> {
            var controller = event.getController();
            controller.setAnimationSpeed(1);
            RawAnimation animation = null;

            if (entityData.get(IS_OPEN))
                animation = begin().then(OPEN, HOLD_ON_LAST_FRAME);
            else animation = begin().then(CLOSE, PLAY_ONCE);

            return animation != null ? event.setAndContinue(animation) : PlayState.STOP;
        };
    }

    private AnimationController.AnimationStateHandler<PowerArmorFrame> animateArms() {
        return event -> {
            var controller = event.getController();
            controller.setAnimationSpeed(1);
            RawAnimation animation = null;

            var passenger = getControllingPassenger();

//            if(triggersController.isPlayingTriggeredAnimation())
//                return PlayState.STOP;

            if (passenger == null) {
                animation = begin().then(IDLE_EMPTY, LOOP);
            } else if (!passengerHaveGun()) {
                if (passenger.attackAnim > 0) {
                    controller.setAnimationSpeed(2.0D);
                    animation = begin().then(HIT, PLAY_ONCE);
                } else if (hurtTime > 0) {
                    animation = begin().then(HURT, PLAY_ONCE);
                } else if (isWalking()) {
                    controller.setAnimationSpeed(speedometer.getSpeed() * 4.0D);
                    animation = begin().then(WALK_ARMS, LOOP);
                } else {
                    if (begin().then(WALK_ARMS, LOOP).equals(armsAnimation))
                        animation = begin().then(WALK_ARMS, PLAY_ONCE).then(IDLE, LOOP);
                    else
                        animation = begin().then(IDLE, LOOP);
                }
            }

            armsAnimation = animation;

            return animation != null ? event.setAndContinue(animation) : PlayState.STOP;
        };
    }

    private AnimationController.AnimationStateHandler<PowerArmorFrame> animateLegs() {
        return event -> {
            var controller = event.getController();
            controller.setAnimationSpeed(1);
            RawAnimation animation = null;

            if (!hasPassenger()) return PlayState.STOP;

            var passenger = getControllingPassenger();

            if (this.isWalking()) {
                if (isCrouching()) {
                    animation = begin().then(SNEAK_WALK, LOOP);
                } else {
                    animation = begin().then(WALK_LEGS, LOOP);
                    controller.setAnimationSpeed(speedometer.getSpeed() * 4.0D);
                }
            } else if (isCrouching()) {
                animation = begin().then(SNEAK_END, LOOP);
            } else {
                if (begin().then(WALK_LEGS, LOOP).equals(legsAnimation))
                    animation = begin().then(WALK_LEGS, PLAY_ONCE);
            }

            legsAnimation = animation;

            return animation != null ? event.setAndContinue(animation) : PlayState.STOP;
        };
    }

    private static void doSafe(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

//    private <E extends IAnimatable> PlayState animateArms(AnimationEvent<E> event) {
//        var controller = event.getController();
//        controller.animationSpeed = 1.0D;
//
//        var player = getPlayerPassenger();
//
//        if (player != null) {
//            if (player.attackAnim > 0) {
//                controller.animationSpeed = 2.0D;
//                setAnimation(controller, HIT, PLAY_ONCE);
//                return PlayState.CONTINUE;
//            } else if (hurtTime > 0) {
//                setAnimation(controller, HURT, PLAY_ONCE);
//                return PlayState.CONTINUE;
//            }
//            else if (isWalking()) {
//                setAnimation(controller, WALK_ARMS, LOOP);
//                controller.animationSpeed = speedometer.getSpeed() * 4.0D;
//                return PlayState.CONTINUE;
//            }
//        }
//
//        setAnimation(controller, "idle", LOOP);
//        return PlayState.CONTINUE;
//    }
//
//    private <E extends IAnimatable> PlayState animateLegs(AnimationEvent<E> event) {
//        var controller = event.getController();
//        controller.animationSpeed = 1.0D;
//
//        if (!hasPlayerPassenger()) return PlayState.STOP;
//        var player = getPlayerPassenger();
//
//        if (this.isWalking()) {
//            if (player.isShiftKeyDown()){
//                setAnimation(controller, SNEAK_WALK, LOOP);
//            }
//            else {
//                setAnimation(controller, WALK_LEGS, LOOP);
//                controller.animationSpeed = speedometer.getSpeed() * 4.0D;
//            }
//            return PlayState.CONTINUE;
//        }
//        else if (player.isShiftKeyDown()) {
//            setAnimation(controller, SNEAK_END, LOOP);
//            return PlayState.CONTINUE;
//        }
//        return PlayState.STOP;
//    }
}
