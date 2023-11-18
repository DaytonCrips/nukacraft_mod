package com.dayton.nukacraft.mixin.common;

import com.dayton.guns.Config;
import com.dayton.guns.client.render.gun.IOverrideModel;
import com.dayton.guns.client.render.gun.ModelOverrides;
import com.dayton.guns.common.foundation.entity.DamageSourceProjectile;
import com.dayton.guns.common.foundation.item.GunItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Author: MrCrayfish
 */
@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    private DamageSource source;

    @Inject(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;knockback(DDD)V"))
    private void capture(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        this.source = source;
    }

    @ModifyArg(method = "hurt", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;knockback(DDD)V"), index = 0)
    private double modifyApplyKnockbackArgs(double original) {
        if (this.source instanceof DamageSourceProjectile) {
            if (!Config.COMMON.gameplay.enableKnockback.get()) {
                return 0;
            }

            double strength = Config.COMMON.gameplay.knockbackStrength.get();
            if (strength > 0) {
                return strength;
            }
        }
        return original;
    }

    @Inject(method = "tick", at = @At(value = "HEAD"))
    public void tick(CallbackInfo ci) {

        var entity = (LivingEntity)(Object)this;

        ItemStack heldItem = entity.getMainHandItem();
        if (!heldItem.isEmpty() && heldItem.getItem() instanceof GunItem) {
            IOverrideModel model = ModelOverrides.getModel(heldItem);
            if (model != null) {
                model.tick(entity);
            }
        }
    }
}
