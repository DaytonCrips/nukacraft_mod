package com.dayton.nukacraft.common.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import static software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes.LOOP;
import static software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes.PLAY_ONCE;

public class Deathclaw extends Monster implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public Deathclaw(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 200)
                .add(Attributes.ATTACK_DAMAGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 48);
    }

    protected void registerGoals() {
//        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
//        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
//        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
//        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 0.2D, false));
//        this.goalSelector.addGoal(1, new FloatGoal(this));
//        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
//        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
//        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
//        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));

        this.goalSelector.addGoal(2, new RestrictSunGoal(this));
        this.goalSelector.addGoal(3, new FleeSunGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Wolf.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController((new AnimationController<>(this, "arm_controller", 0, this::animateArms)));
    }

    private <E extends IAnimatable> PlayState animateArms(AnimationEvent<E> event) {
        var controller = event.getController();
        controller.animationSpeed = 1;
        if(attackAnim > 0){
            controller.animationSpeed = 2;
            setAnimation(controller, "attack_right", PLAY_ONCE);
        }
        else if(event.isMoving()){
            if(getTarget() != null){
                setAnimation(controller, "run", LOOP);
            }
            setAnimation(controller, "walk", LOOP);
        }
        else {
            setAnimation(controller, "idle", LOOP);
        }

        return PlayState.CONTINUE;
    }

    public static void setAnimation(AnimationController<?> controller, String name, ILoopType loopType){
        controller.setAnimation(new AnimationBuilder().addAnimation(name, loopType));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}