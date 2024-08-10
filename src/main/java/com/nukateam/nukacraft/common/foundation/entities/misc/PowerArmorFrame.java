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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
    public static HashMap<String, Integer> POWER_ARMOR_PART_IDS;
    public final AnimationController<PowerArmorFrame> triggersController = new AnimationController<>(this, TRIGGER_CONTROLLER, event -> PlayState.CONTINUE)
            .triggerableAnim(OPEN, begin().thenPlayAndHold(OPEN))
            .triggerableAnim(CLOSE, begin().thenPlay(CLOSE));

    public RawAnimation armsAnimation = null;
    public RawAnimation legsAnimation = null;
    private int tickCounter = 0;

    static {
        POWER_ARMOR_PART_IDS = (HashMap<String, Integer>) PART_IDS.clone();
        addSlot(FUSION_CORE);
        addSlot(JETPACK);
    }

    public PowerArmorFrame(EntityType<? extends WearableChassis> type, Level worldIn) {
        super(type, worldIn, POWER_ARMOR_PART_IDS);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return ChassisBase.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 1000.0)
                .add(Attributes.ATTACK_DAMAGE, 0.0)
                .add(Attributes.MOVEMENT_SPEED, 0.1)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0)
                .add(Attributes.JUMP_STRENGTH, 0.5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(IS_OPEN, false);
    }

    @Override
    public boolean renderHand() {
        return false;
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
    public EntityDimensions getStandingDimensions(){
        return STANDING_DIMENSIONS;
    }

    @Override
    public EntityDimensions getCrouchingDimensions(){
        return CROUCHING_DIMENSIONS;
    }

    @Override
    protected float getCrouchingSpeed(){
        return getSpeedAttribute() * 0.7f;
    }

    @Override
    protected float getSprintingSpeed(){
        return getSpeedAttribute() * 1.5f;
    }

    @Override
    protected void updatePose() {
        super.updatePose();

        if (!hasEnergy()) {
            setSpeed(getMinSpeed());
        }
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vector, InteractionHand hand) {
        if (this.isServerSide && !player.isPassenger() && hand == InteractionHand.MAIN_HAND) {
            if (!this.isVehicle()) {
                if (player.isShiftKeyDown()) {
                    if (entityData.get(IS_OPEN))
                        close();
                    else this.openGUI(player);
                    return InteractionResult.SUCCESS;
                }

                if (entityData.get(IS_OPEN)) {
                    this.ride(player);
                    close();
                } else open();

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

    @Override
    public void jump() {
        if (hasEnergy())
            super.jump();
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

    public ItemStack getFusionCore() {
        return getEquipment(FUSION_CORE);
    }

    public boolean hasFusionCore() {
        return hasEquipment(FUSION_CORE);
    }

    public boolean hasEnergy() {
        return hasFusionCore();
    }

    public void open() {
        entityData.set(IS_OPEN, true);
        this.triggerAnim(TRIGGER_CONTROLLER, OPEN);
    }

    public void close() {
        entityData.set(IS_OPEN, false);
        this.triggerAnim(TRIGGER_CONTROLLER, CLOSE);
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
                    controller.setAnimationSpeed(speedometer.getSpeed() * 2.0D);
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
}
