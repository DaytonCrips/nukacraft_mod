package com.dayton.nukacraft.common.foundation.entities;

import com.dayton.nukacraft.*;
import com.dayton.nukacraft.common.foundation.container.menu.*;
import com.jetug.chassis_core.common.foundation.entity.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.*;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import software.bernie.geckolib3.core.*;
import software.bernie.geckolib3.core.controller.*;
import software.bernie.geckolib3.core.event.predicate.*;
import software.bernie.geckolib3.core.manager.*;

import java.util.HashMap;

import static com.dayton.nukacraft.common.data.constants.ArmorChassisAnimation.*;
import static com.dayton.nukacraft.common.data.constants.PowerArmorPrats.*;
import static com.jetug.chassis_core.common.foundation.item.DamageableItem.*;
import static com.jetug.chassis_core.common.util.helpers.AnimationHelper.*;
import static software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes.*;

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
