package com.nukateam.nukacraft.common.foundation.goals;

import com.nukateam.nukacraft.common.foundation.entities.mobs.ITriggerProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class GeoMeleeAttackGoal<T extends PathfinderMob & ITriggerProvider> extends MeleeAttackGoal {
    private final T mob;

    public GeoMeleeAttackGoal(T pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.mob = pMob;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity enemy, double pDistToEnemySqr) {
        double d0 = this.getAttackReachSqr(enemy);
        if (pDistToEnemySqr <= d0 && this.getTicksUntilNextAttack() <= 0) {
            this.resetAttackCooldown();
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.doHurtTarget(enemy);
            mob.onAttack();
        }
    }
}
