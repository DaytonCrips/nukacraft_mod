package com.dayton.nukacraft.common.foundation.entities;

import com.dayton.nukacraft.common.network.PacketHandler;
import com.dayton.nukacraft.common.network.packets.MobPacket;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;

public class Deathclaw extends Monster implements GeoEntity {
    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final boolean isClientSide = level.isClientSide;
    private final boolean isServerSide = !level.isClientSide;
    private boolean isRunning = false;

    public Deathclaw(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.ATTACK_DAMAGE, 2.0D)
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
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Raider.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Animal.class, false));
    }

    @Override
    public void setTarget(@Nullable LivingEntity pTarget) {
        super.setTarget(pTarget);

        if(isServerSide) {
            setIsRunning(pTarget != null);
            PacketHandler.sendToAllPlayers(new MobPacket(getId(), isRunning));
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controllerName", 0, animateArms()));
    }

    public void setIsRunning(boolean isRunning){
        this.isRunning = isRunning;
        if (isRunning)
            setSpeed(2f);
        else setSpeed((float) getAttributeValue(Attributes.MOVEMENT_SPEED));
    }

    @NotNull private AnimationController.AnimationStateHandler<Deathclaw> animateArms() {
        return event -> {
            var controller = event.getController();
            controller.setAnimationSpeed(1);
            RawAnimation animation;

            if(attackAnim > 0){
                if(!startAttacking){
                    startAttacking = true;
                    attackAnimName = attackAnims[random.nextInt(0,attackAnims.length)];
                }

                controller.setAnimationSpeed(2);
                animation = begin().thenLoop(attackAnimName);

            }
            else if(event.isMoving()){
                animation = isRunning ? begin().thenLoop("run") : begin().thenLoop("walk");
            }
            else {
                animation = begin().thenLoop("idle");
            }

            return event.setAndContinue(animation);
        };
    }


//    private <E extends IAnimatable> PlayState animateArms(AnimationEvent<E> event) {
//        var controller = event.getController();
//        controller.animationSpeed = 1;
//        //random.nextInt(0, 2);
//        if(attackAnim > 0){
//            if(!startAttacking){
//                startAttacking = true;
//                attackAnimName = attackAnims[random.nextInt(0,attackAnims.length)];
//            }
//            controller.animationSpeed = 2;
//            setAnimation(controller, attackAnimName, PLAY_ONCE);
//            return PlayState.CONTINUE;
//        }
//        else if(event.isMoving()){
//            if(isRunning) setAnimation(controller, "run", LOOP);
//            else setAnimation(controller, "walk", LOOP);
//        }
//        else {
//            setAnimation(controller, "idle", LOOP);
//        }
//
//        startAttacking = false;
//        return PlayState.CONTINUE;
//    }



    private boolean startAttacking = false;

    private String[] attackAnims = new String[]{
            "attack_right",
            "attack_left",
            "attack_both"
    };

    private String attackAnimName;
//
//    public static void setAnimation(AnimationController<?> controller, String name, ILoopType loopType){
//        controller.setAnimation(new AnimationBuilder().addAnimation(name, loopType));
//    }
}