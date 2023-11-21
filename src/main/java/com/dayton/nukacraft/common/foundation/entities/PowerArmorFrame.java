package com.dayton.nukacraft.common.foundation.entities;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.foundation.container.menu.PowerArmorMenu;
import com.dayton.nukacraft.common.foundation.container.menu.PowerArmorStationMenu;
import com.jetug.chassis_core.common.foundation.entity.ChassisBase;
import com.jetug.chassis_core.common.foundation.entity.HandEntity;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.HashMap;

import static com.dayton.nukacraft.common.data.constants.ArmorChassisAnimation.*;
import static com.dayton.nukacraft.common.data.constants.PowerArmorPrats.FUSION_CORE;
import static com.dayton.nukacraft.common.data.constants.PowerArmorPrats.JETPACK;
import static com.jetug.chassis_core.common.foundation.item.DamageableItem.damageItem;
import static mod.azure.azurelib.core.animation.Animation.LoopType.LOOP;
import static mod.azure.azurelib.core.animation.Animation.LoopType.PLAY_ONCE;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;

@SuppressWarnings("unchecked")
public class PowerArmorFrame extends WearableChassis {
    public static final int INVENTORY_SIZE = ChassisBase.INVENTORY_SIZE + 6;
    public static final ResourceLocation ICON
            = new ResourceLocation(NukaCraftMod.MOD_ID, "textures/items/power_armor_frame.png");
    public static final PowerArmorHand HAND = new PowerArmorHand();

    public static HashMap<String, Integer> POWER_ARMOR_PART_IDS;

    public static int getId(String chassisPart){
        return POWER_ARMOR_PART_IDS.get(chassisPart);
    }

    private static void addSlot(String slot){
        POWER_ARMOR_PART_IDS.put(slot, PART_IDS.size());
    }

    static{
        POWER_ARMOR_PART_IDS = (HashMap<String, Integer>) PART_IDS.clone();
        addSlot(FUSION_CORE);
        addSlot(JETPACK);
    }

    public PowerArmorFrame(EntityType<? extends WearableChassis> type, Level worldIn) {
        super(type, worldIn, POWER_ARMOR_PART_IDS);
    }

//    @Override
//    public Collection<String> getEquipment() {
//        return List.of(armorParts);
//    }

    @Override
    public void tick() {
        super.tick();

        if(!hasFusionCore()) return;
        var core = getFusionCore();
        var dmg = core.getMaxDamage() - core.getDamageValue();
        if(dmg <= 0){
            setEquipment(FUSION_CORE, ItemStack.EMPTY);
        }

        if(isWalking()){
            damageItem(core, 1);
        }
    }

    @Override
    public boolean hurt(DamageSource damageSource, float damage) {
        if(damageSource.isFall()){
            damageArmor(damageSource, damage);
            return false;
        }
        else return super.hurt(damageSource, damage);
    }

    @Override
    public boolean causeFallDamage(float height, float pMultiplier, DamageSource damageSource) {
        var damage = calculateFallDamage(height, pMultiplier);
        if(damage >= 0)
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

    public ItemStack getFusionCore(){
        return getEquipment(FUSION_CORE);
    }

    public boolean hasFusionCore(){
        return hasEquipment(FUSION_CORE);
    }

//    @Override
//    protected void createPartIdMap() {
//        //super.createPartIdMap();
//        int i = inventorySize;
//        this.partIdMap.put(FUSION_CORE, i++);
//        this.inventorySize = i;
//    }

    public boolean hasEnergy(){
        return hasFusionCore();
    }

    @Override
    protected void updateSpeed() {
        if(hasEnergy())
            setSpeed(getSpeedAttribute());
        else {
            setSpeed(getMinSpeed());
            return;
        }
    }

    @Override
    public MenuProvider getMenuProvider(){
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
        return speedometer.getSpeed() > 0;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "arm_controller", 0, animateArms()));
        controllerRegistrar.add(new AnimationController<>(this, "leg_controller", 0, animateLegs()));
    }

    private AnimationController.AnimationStateHandler<PowerArmorFrame> animateArms() {
        return event -> {
            var controller = event.getController();
            controller.setAnimationSpeed(1);
            RawAnimation animation = null;

            var entity = getPassenger();

            if (entity != null) {
                if (entity.attackAnim > 0) {
                    controller.setAnimationSpeed(2.0D);
                    animation = begin().then(HIT, PLAY_ONCE);
                } else if (hurtTime > 0) {
                    animation = begin().then(HURT, PLAY_ONCE);
                }
                else if (isWalking()) {
                    controller.setAnimationSpeed(speedometer.getSpeed() * 4.0D);
                    animation = begin().then(WALK_ARMS, LOOP);
                }
                else animation = begin().then(IDLE, LOOP);
            }

            return event.setAndContinue(animation != null ? animation : begin().then(IDLE, LOOP));
        };
    }

    private AnimationController.AnimationStateHandler<PowerArmorFrame> animateLegs() {
        return event -> {
            var controller = event.getController();
            controller.setAnimationSpeed(1);
            RawAnimation animation;

            if (!hasPassenger()) return PlayState.STOP;

            var passenger = getPassenger();

            if (this.isWalking()) {
                if (passenger.isShiftKeyDown()){
                    animation = begin().then(SNEAK_WALK, LOOP);
                }
                else {
                    animation = begin().then(WALK_LEGS, LOOP);
                    controller.setAnimationSpeed(speedometer.getSpeed() * 4.0D);
                }
            }
            else if (passenger.isShiftKeyDown()) {
                animation = begin().then(SNEAK_END, LOOP);
            }
            else {
                return PlayState.STOP;
            }
            return event.setAndContinue(animation);
        };
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
