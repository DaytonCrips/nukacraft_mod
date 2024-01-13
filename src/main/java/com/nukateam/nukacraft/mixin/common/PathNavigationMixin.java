package com.nukateam.nukacraft.mixin.common;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.level.pathfinder.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

import static com.nukateam.nukacraft.common.data.utils.PowerArmorUtils.*;

@Mixin(PathNavigation.class)
public abstract class PathNavigationMixin {
    @Shadow protected Path path;
    @Final @Shadow protected Mob mob;

    @Inject(method = "tick", at = @At(value = "HEAD"))
    public void tick(CallbackInfo ci) {
        if(this.path != null && !this.path.isDone() && isWearingPowerArmor(mob)){
            var nextPos = this.path.getNextEntityPos(this.mob);
            var distance = nextPos.distanceTo(mob.position());

            if(nextPos.y > mob.getY() && distance < 1){
                getPowerArmor(mob).jump();
            }
        }
    }
}
