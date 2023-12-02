package com.nukateam.nukacraft.common.foundation.goals;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class FlyingGoal<T extends PathfinderMob> extends Goal {
    private final T mob;

    public FlyingGoal(T mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        return mob.getNavigation().isDone() && mob.getRandom().nextInt(10) == 0;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean canContinueToUse() {
        return mob.getNavigation().isInProgress();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void start() {
        var vec3 = this.findPos();
        if (vec3 != null) {
            mob.getNavigation().moveTo(mob.getNavigation().createPath(new BlockPos(vec3), 1), 1.0D);
        }
    }

    @Nullable
    private Vec3 findPos() {
        var viewVector = mob.getViewVector(0.0F);
        var vec = HoverRandomPos.getPos(mob, 8, 7, viewVector.x, viewVector.z, ((float) Math.PI / 2F), 3, 1);

        return vec != null ? vec : AirAndWaterRandomPos.getPos(mob, 8, 4, -2, viewVector.x, viewVector.z, (double) ((float) Math.PI / 2F));
    }
}

