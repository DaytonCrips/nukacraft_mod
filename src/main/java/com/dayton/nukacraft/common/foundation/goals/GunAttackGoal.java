package com.dayton.nukacraft.common.foundation.goals;

import com.dayton.guns.common.base.Gun;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.nukacraft.common.data.interfaces.IGunUser;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.*;

import java.util.EnumSet;

public class GunAttackGoal<T extends PathfinderMob & RangedAttackMob & IGunUser> extends Goal {
    public static final UniformInt PATHFINDING_DELAY_RANGE = TimeUtil.rangeOfSeconds(1, 2);
    private final T mob;
//    private GunAttackGoal.CrossbowState crossbowState = GunAttackGoal.CrossbowState.UNCHARGED;
    private final double speedModifier;
    private final float attackRadiusSqr;
    private int seeTime;
    private int attackDelay;
    private int updatePathDelay;

    public GunAttackGoal(T pMob, double pSpeedModifier, float pAttackRadius) {
        this.mob = pMob;
        this.speedModifier = pSpeedModifier;
        this.attackRadiusSqr = pAttackRadius * pAttackRadius;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        return this.isValidTarget() && this.isHoldingGun();
    }

    private boolean isHoldingGun() {
        return this.mob.isHolding(is -> is.getItem() instanceof GunItem);
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean canContinueToUse() {
        return this.isValidTarget() && (this.canUse() || !this.mob.getNavigation().isDone()) && this.isHoldingGun();
    }

    private boolean isValidTarget() {
        return this.mob.getTarget() != null && this.mob.getTarget().isAlive();
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void stop() {
        super.stop();
        this.mob.setAggressive(false);
        this.mob.setTarget(null);
        this.seeTime = 0;
        if (this.mob.isUsingItem()) {
            this.mob.stopUsingItem();
//            this.mob.setChargingCrossbow(false);
//            CrossbowItem.setCharged(this.mob.getUseItem(), false);
        }

    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        var target = this.mob.getTarget();
        if (target == null) return;

        var hasLineOfSight = this.mob.getSensing().hasLineOfSight(target);
        var flag1 = this.seeTime > 0;

        if (hasLineOfSight != flag1) this.seeTime = 0;

        if (hasLineOfSight)
            ++this.seeTime;
        else --this.seeTime;

        var distance = this.mob.distanceToSqr(target);
        var flag2 = (distance > (double)this.attackRadiusSqr || this.seeTime < 5) && this.attackDelay == 0;
        if (flag2) {
            --this.updatePathDelay;
            if (this.updatePathDelay <= 0) {
                this.mob.getNavigation().moveTo(target, this.canRun() ? this.speedModifier : this.speedModifier * 0.5D);
                this.updatePathDelay = PATHFINDING_DELAY_RANGE.sample(this.mob.getRandom());
            }
        } else {
            this.updatePathDelay = 0;
            this.mob.getNavigation().stop();
        }

        this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);

//        var gun = (GunItem)mob.getMainHandItem().getItem();

        if(Gun.hasAmmo(mob.getMainHandItem())){
            mob.performRangedAttack(target, 1);
        }

//        if (this.crossbowState == GunAttackGoal.CrossbowState.UNCHARGED) {
//            if (!flag2) {
//                this.mob.startUsingItem(ProjectileUtil.getWeaponHoldingHand(this.mob, item -> item instanceof CrossbowItem));
//                this.crossbowState = GunAttackGoal.CrossbowState.CHARGING;
//                this.mob.setChargingCrossbow(true);
//            }
//        } else if (this.crossbowState == GunAttackGoal.CrossbowState.CHARGING) {
//            if (!this.mob.isUsingItem()) {
//                this.crossbowState = GunAttackGoal.CrossbowState.UNCHARGED;
//            }
//
//            int i = this.mob.getTicksUsingItem();
//            var itemStack = this.mob.getUseItem();
//            if (i >= CrossbowItem.getChargeDuration(itemStack)) {
//                this.mob.releaseUsingItem();
//                this.crossbowState = GunAttackGoal.CrossbowState.CHARGED;
//                this.attackDelay = 20 + this.mob.getRandom().nextInt(20);
//                this.mob.setChargingCrossbow(false);
//            }
//        } else if (this.crossbowState == GunAttackGoal.CrossbowState.CHARGED) {
//            --this.attackDelay;
//            if (this.attackDelay == 0) {
//                this.crossbowState = GunAttackGoal.CrossbowState.READY_TO_ATTACK;
//            }
//        } else if (this.crossbowState == GunAttackGoal.CrossbowState.READY_TO_ATTACK && hasLineOfSight) {
//            this.mob.performRangedAttack(target, 1.0F);
//            var itemStack = this.mob.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this.mob, item -> item instanceof CrossbowItem));
//            CrossbowItem.setCharged(itemStack, false);
//            this.crossbowState = GunAttackGoal.CrossbowState.UNCHARGED;
//        }

    }

    private boolean canRun() {
        return true; //this.crossbowState == GunAttackGoal.CrossbowState.UNCHARGED;
    }

//    enum CrossbowState {
//        UNCHARGED,
//        CHARGING,
//        CHARGED,
//        READY_TO_ATTACK;
//    }
}
