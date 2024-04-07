package com.nukateam.nukacraft.mixin.common;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.pathfinder.Path;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.nukateam.nukacraft.common.data.utils.PowerArmorUtils.getPowerArmor;
import static com.nukateam.nukacraft.common.data.utils.PowerArmorUtils.isWearingPowerArmor;

@Mixin(PathNavigation.class)
public abstract class PathNavigationMixin {
    @Shadow
    protected Path path;
    @Final
    @Shadow
    protected Mob mob;

    @Inject(method = "tick", at = @At(value = "HEAD"))
    public void tick(CallbackInfo ci) {
        if (this.path != null && !this.path.isDone() && isWearingPowerArmor(mob)) {
            var nextPos = this.path.getNextEntityPos(this.mob);
            var distance = nextPos.distanceTo(mob.position());

            if (nextPos.y > mob.getY() && distance < 1) {
                getPowerArmor(mob).jump();
            }
        }
    }
}
