package com.dayton.nukacraft.common.foundation.goals;

import com.dayton.nukacraft.common.foundation.entities.PowerArmorFrame;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;

import java.util.EnumSet;

import static net.minecraft.world.entity.ai.targeting.TargetingConditions.*;

public class RidePowerArmorGoal extends Goal {
    private final PathfinderMob entity;

    private final LevelReader level;
    private PowerArmorFrame target;
    private final double speedModifier;
    private final PathNavigation navigation;
    private int timeToRecalcPath;
    private final float searchDistance;
    private float oldWaterCost;
    protected TargetingConditions targetConditions;

    public RidePowerArmorGoal(PathfinderMob entity, double speedModifier, float searchDistance) {
        this.entity = entity;
        this.level = entity.level;
        this.speedModifier = speedModifier;
        this.navigation = entity.getNavigation();
        this.searchDistance = searchDistance;
        this.targetConditions = forCombat().range(searchDistance).selector((target) -> !target.isVehicle());

        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        if (!(entity.getNavigation() instanceof GroundPathNavigation) && !(entity.getNavigation() instanceof FlyingPathNavigation)) {
            throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
        }
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        return entity.getVehicle() == null;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean canContinueToUse() {
        return !this.navigation.isDone();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void start() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.entity.getPathfindingMalus(BlockPathTypes.WATER);
        this.entity.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void stop() {
        this.navigation.stop();
        this.entity.setPathfindingMalus(BlockPathTypes.WATER, this.oldWaterCost);
    }

    protected AABB getTargetSearchArea(double pTargetDistance) {
        return this.entity.getBoundingBox().inflate(pTargetDistance, 4.0D, pTargetDistance);
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        this.target = entity.level.getNearestEntity(entity.level.getEntitiesOfClass(PowerArmorFrame.class,
                getTargetSearchArea(searchDistance), (p_148152_) -> true),
                targetConditions, entity, entity.getX(), entity.getEyeY(), entity.getZ());


        if(target == null) return;

        entity.getLookControl().setLookAt(target, 10.0F, (float)entity.getMaxHeadXRot());

        if (--timeToRecalcPath <= 0) {
            timeToRecalcPath = adjustedTickDelay(10);
            if (!entity.isLeashed() && !entity.isPassenger()) {
                navigation.moveTo(target, this.speedModifier);
            }
        }

        if(entity.distanceTo(target) < 2)
            target.ride(entity);
    }
}