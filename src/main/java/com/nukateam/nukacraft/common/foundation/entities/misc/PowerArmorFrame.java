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
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
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

        updatePlayerPose();
    }

    @Override
    public @NotNull EntityDimensions getDimensions(@NotNull Pose pPose) {
        return POSES.getOrDefault(pPose, STANDING_DIMENSIONS);
    }

    protected void updatePlayerPose() {
        if (this.canEnterPose(Pose.SWIMMING)) {
            Pose pose;
            if (hasPlayerPassenger() && getPlayerPassenger().isShiftKeyDown()) {
                pose = Pose.CROUCHING;
            } else {
                pose = Pose.STANDING;
            }

            this.setPose(pose);
        }
    }


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

    @Override
    protected void updateSpeed() {
        if (hasEnergy()) {
            if(isCrouching())
                setSpeed(getSpeedAttribute() / 2);
            else setSpeed(getSpeedAttribute());
        }
        else {
            setSpeed(getMinSpeed());
        }
    }

    public boolean isCrouching() {
        return this.hasPose(Pose.CROUCHING);
    }

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
                if (passenger.isShiftKeyDown()) {
                    animation = begin().then(SNEAK_WALK, LOOP);
                } else {
                    animation = begin().then(WALK_LEGS, LOOP);
                    controller.setAnimationSpeed(speedometer.getSpeed() * 4.0D);
                }
            } else if (passenger.isShiftKeyDown()) {
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
