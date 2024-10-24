package com.nukateam.nukacraft.mixin.common;

import com.jetug.chassis_core.common.foundation.entity.WearableChassis;
import net.bettercombat.BetterCombat;
import net.bettercombat.client.collision.TargetFinder;
import net.bettercombat.logic.TargetHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.stream.Collectors;

import static com.nukateam.nukacraft.common.data.utils.PowerArmorUtils.getPowerArmor;

/*@Mixin(TargetFinder.class)
public abstract class TargetFinderMixin {
    @Inject(method = "getInitialTargets(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/Entity;D)Ljava/util/List;",
            at = @At(value = "HEAD"), cancellable = true, remap = false)
    private static void getInitialTargets(Player player, Entity cursorTarget, double attackRange,
                                          CallbackInfoReturnable<List<Entity>> cir) {
        var box = player.getBoundingBox()
                .inflate(attackRange * BetterCombat.config.target_search_range_multiplier + 1.0);

        var entities = player
                .level()
                .getEntities(player, box, entity -> !entity.isSpectator() && entity.isPickable())
                .stream()
                .filter(entity ->
                        entity != player
                        && entity != cursorTarget
                        && entity.isAttackable()
                        && (!entity.equals(player.getVehicle())
                                || !(entity instanceof WearableChassis)
                                || TargetHelper.isAttackableMount(entity))
                        && TargetHelper.getRelation(player, entity) == TargetHelper.Relation.HOSTILE)
                .collect(Collectors.toList());
        if (cursorTarget != null && cursorTarget.isAttackable() && cursorTarget != player.getVehicle()) {
            entities.add(cursorTarget);
        }

        cir.setReturnValue(entities);
        cir.cancel();
    }
}*/
