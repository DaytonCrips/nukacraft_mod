package com.nukateam.nukacraft.common.foundation.goals;

import com.nukateam.ntgl.common.base.config.Gun;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.nukacraft.common.foundation.entities.mobs.Securitron;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class SecuritronRangedAttackGoal<T extends Securitron> extends Goal {
    public static final UniformInt PATHFINDING_DELAY_RANGE = TimeUtil.rangeOfSeconds(1, 2);
    private final T mob;
    private final double speedModifier;
    private final float attackRadiusSqr;
    private int seeTime;
    private int attackDelay = 0;
    private int updatePathDelay;
    private int reloadTimer = 0;
    private LivingEntity buffTarget = null;

    public SecuritronRangedAttackGoal(T pMob, double pSpeedModifier, float pAttackRadius) {
        this.mob = pMob;
        this.speedModifier = pSpeedModifier;
        this.attackRadiusSqr = pAttackRadius * pAttackRadius;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
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

    public void tick() {
        var target = this.mob.getTarget();

        if(buffTarget == null && target != null)
            attackDelay = this.mob.getAttackDelay();

        buffTarget = target;

        if (buffTarget == null) return;

        var hasLineOfSight = this.mob.getSensing().hasLineOfSight(buffTarget);
        var seen = this.seeTime > 0;

        if (hasLineOfSight != seen) this.seeTime = 0;

        if (hasLineOfSight)
            ++this.seeTime;
        else --this.seeTime;

        var distance = this.mob.distanceToSqr(buffTarget);
        var flag2 = (distance > (double) this.attackRadiusSqr || this.seeTime < 5) && this.attackDelay == 0;

        if (flag2) {
            --this.updatePathDelay;
            if (this.updatePathDelay <= 0) {
                this.mob.getNavigation().moveTo(buffTarget, this.canRun() ? this.speedModifier : this.speedModifier * 0.5D);
                this.updatePathDelay = PATHFINDING_DELAY_RANGE.sample(this.mob.getRandom());
            }
        } else {
            this.updatePathDelay = 0;
            this.mob.getNavigation().stop();
        }

        this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);

        var gunStack = mob.getGun();
        var gun = (GunItem) mob.getGun().getItem();

        if (Gun.hasAmmo(mob.getGun())) {
            if(attackDelay == 0)
                mob.performRangedAttack(target, 1);
        } else if (reloadTimer == -1) {
            reloadTimer = gun.getGun().getGeneral().getReloadTime();
        } else if (reloadTimer > 0) {
            reloadTimer = Math.max(reloadTimer - 1, 0);
        } else if (reloadTimer == 0) {
            Gun.fillAmmo(gunStack);
            reloadTimer = -1;
        }

        if(attackDelay > 0)
            attackDelay--;
    }

    private boolean canRun() {
        return true; //this.crossbowState == GunAttackGoal.CrossbowState.UNCHARGED;
    }
}
