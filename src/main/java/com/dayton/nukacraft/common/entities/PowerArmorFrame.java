package com.dayton.nukacraft.common.entities;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.container.menu.PowerArmorStationMenu;
import com.dayton.nukacraft.common.container.menu.PowerChassisMenu;
import com.dayton.nukacraft.common.items.custom.FusionCoreItem;
import com.jetug.chassis_core.common.foundation.entity.ArmorChassisBase;
import com.jetug.chassis_core.common.foundation.entity.HandEntity;
import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import com.jetug.chassis_core.common.foundation.item.DamageableItem;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;

import java.util.HashMap;

import static com.dayton.nukacraft.common.data.constants.ArmorChassisAnimation.*;
import static com.dayton.nukacraft.common.data.constants.PowerArmorPrats.FUSION_CORE;
import static com.jetug.chassis_core.common.data.enums.ChassisPart.*;
import static com.jetug.chassis_core.common.data.enums.ChassisPart.BODY_FRAME;
import static com.jetug.chassis_core.common.foundation.item.DamageableItem.*;
import static com.jetug.chassis_core.common.util.helpers.AnimationHelper.setAnimation;
import static software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes.*;

@SuppressWarnings("unchecked")
public class PowerArmorFrame extends WearableChassis {
    public static final int INVENTORY_SIZE = ArmorChassisBase.INVENTORY_SIZE + 6;
    public static final ResourceLocation ICON
            = new ResourceLocation(NukaCraftMod.MOD_ID, "textures/items/power_armor_frame.png");
    public static final PowerArmorHand HAND = new PowerArmorHand();

    public static HashMap<String, Integer> POWER_ARMOR_PART_IDS;

    public static int getId(String chassisPart){
        return POWER_ARMOR_PART_IDS.get(chassisPart);
    }

    static{
        POWER_ARMOR_PART_IDS = (HashMap<String, Integer>) PART_IDS.clone();
        POWER_ARMOR_PART_IDS.put(FUSION_CORE, PART_IDS.size());
    }

    public PowerArmorFrame(EntityType<? extends WearableChassis> type, Level worldIn) {
        super(type, worldIn, POWER_ARMOR_PART_IDS);
    }

    @Override
    public void tick() {
        super.tick();

        if(!hasFusionCore()) return;
        var core = getFusionCore();
        var dmg = core.getMaxDamage() - core.getDamageValue();
        if(dmg <= 0){
            setItem(FUSION_CORE, ItemStack.EMPTY);
        }

        if(isWalking()){
            damageItem(core, 1);
        }
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
        return getItem(FUSION_CORE);
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
                return new PowerChassisMenu(id, inventory, menu, PowerArmorFrame.this);
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

    @Override
    public void registerControllers(AnimationData data) {
        var armsController = new AnimationController<>(this, "arm_controller", 0, this::animateArms);
        data.addAnimationController(armsController);
        data.addAnimationController(new AnimationController<>(this, "leg_controller", 0, this::animateLegs));
    }

    private <E extends IAnimatable> PlayState animateArms(AnimationEvent<E> event) {
        var controller = event.getController();
        controller.animationSpeed = 1.0D;

        var player = getPlayerPassenger();

        if (player != null) {
            if (player.attackAnim > 0) {
                controller.animationSpeed = 2.0D;
                setAnimation(controller, HIT, PLAY_ONCE);
                return PlayState.CONTINUE;
            } else if (hurtTime > 0) {
                setAnimation(controller, HURT, PLAY_ONCE);
                return PlayState.CONTINUE;
            }
            else if (isWalking()) {
                setAnimation(controller, WALK_ARMS, LOOP);
                controller.animationSpeed = speedometer.getSpeed() * 4.0D;
                return PlayState.CONTINUE;
            }
        }

        setAnimation(controller, "idle", LOOP);
        return PlayState.CONTINUE;
    }

    private <E extends IAnimatable> PlayState animateLegs(AnimationEvent<E> event) {
        var controller = event.getController();
        controller.animationSpeed = 1.0D;

        if (!hasPlayerPassenger()) return PlayState.STOP;
        var player = getPlayerPassenger();

        if (this.isWalking()) {
            if (player.isShiftKeyDown()){
                setAnimation(controller, SNEAK_WALK, LOOP);
            }
            else {
                setAnimation(controller, WALK_LEGS, LOOP);
                controller.animationSpeed = speedometer.getSpeed() * 4.0D;
            }
            return PlayState.CONTINUE;
        }
        else if (player.isShiftKeyDown()) {
            setAnimation(controller, SNEAK_END, LOOP);
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }
}
