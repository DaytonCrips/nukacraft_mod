package com.nukateam.nukacraft.mixin.guns;


import com.nukateam.guns.client.handler.AimingHandler;
import com.nukateam.guns.common.foundation.item.GunItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * I eventually want to get rid of this.
 * <p>
 * Author: MrCrayfish
 */
@Mixin(HumanoidModel.class)
public class LivingEntityModelMixin<T extends LivingEntity> {
    @SuppressWarnings({"ConstantConditions"})
    @Inject(method = "setupAnim*", at = @At(value = "TAIL"))
    private void setupAnimTail(T entity, float animationPos, float animationSpeed, float animationBob, float deltaHeadYaw, float headPitch, CallbackInfo ci) {
//        if (!(entity instanceof Player player))
//            return;
        var model = (HumanoidModel<T>)(Object)this;
        var heldItem = entity.getMainHandItem();
        if (heldItem.getItem() instanceof GunItem gunItem) {
            if (animationPos == 0.0F) {
                model.rightArm.xRot = 0;
                model.rightArm.yRot = 0;
                model.rightArm.zRot = 0;
                model.leftArm.xRot = 0;
                model.leftArm.yRot = 0;
                model.leftArm.zRot = 0;
                if(model instanceof PlayerModel<T> playerModel) {
                    copyModelAngles(playerModel.rightArm, playerModel.rightSleeve);
                    copyModelAngles(playerModel.leftArm, playerModel.leftSleeve);
                }
                return;
            }

            var gun = gunItem.getModifiedGun(heldItem);

            gun.getGeneral().getGripType().getHeldAnimation().applyHumanoidModelRotation(entity, model.rightArm,
                    model.leftArm, model.head, InteractionHand.MAIN_HAND,
                    AimingHandler.get().getAimProgress(entity, Minecraft.getInstance().getFrameTime()));

            if(model instanceof PlayerModel<T> playerModel) {
                copyModelAngles(playerModel.rightArm, playerModel.rightSleeve);
                copyModelAngles(playerModel.leftArm, playerModel.leftSleeve);
            }
            copyModelAngles(model.head, model.hat);
        }
    }

    private static void copyModelAngles(ModelPart source, ModelPart target) {
        target.xRot = source.xRot;
        target.yRot = source.yRot;
        target.zRot = source.zRot;
    }
}
