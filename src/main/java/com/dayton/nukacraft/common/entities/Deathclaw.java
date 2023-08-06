package com.dayton.nukacraft.common.entities;

import com.dayton.nukacraft.NukaCraftMod;
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

import java.util.Objects;

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
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController((new AnimationController<>(this, "arm_controller", 0, this::animateArms)));
    }

    private boolean isRunning = false;

    @Override
    public void tick() {
        super.tick();
        if(getTarget() != null) {
            setSpeed((float) getAttributeBaseValue(Attributes.MOVEMENT_SPEED) + 1f);
            isRunning = true;
        }
        else {
            setSpeed((float) getAttributeBaseValue(Attributes.MOVEMENT_SPEED));
            isRunning = false;
        }
        //NukaCraftMod.LOGGER.error("is running: " + isRunning + " client: " + level.isClientSide);
    }

    private <E extends IAnimatable> PlayState animateArms(AnimationEvent<E> event) {
        var controller = event.getController();
        controller.animationSpeed = 1;
        if(attackAnim > 0){
            controller.animationSpeed = 2;
            setAnimation(controller, "attack_right", PLAY_ONCE);
        }
        else if(event.isMoving()){
            if(isRunning)
                setAnimation(controller, "run", LOOP);
            else
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