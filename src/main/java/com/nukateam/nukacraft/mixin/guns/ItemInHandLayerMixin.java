package com.nukateam.nukacraft.mixin.guns;

import com.nukateam.guns.client.handler.AimingHandler;
import com.nukateam.guns.client.handler.GunRenderingHandler;
import com.nukateam.guns.common.base.Gun;
import com.nukateam.guns.common.foundation.item.GunItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Author: MrCrayfish
 */
@Mixin(ItemInHandLayer.class)
public class ItemInHandLayerMixin {
    @SuppressWarnings("ConstantConditions")
    @Inject(method = "renderArmWithItem", at = @At(value = "HEAD"), cancellable = true)
    private void renderArmWithItem(LivingEntity entity, ItemStack stack,
                                       ItemTransforms.TransformType transformType, HumanoidArm arm,
                                       PoseStack poseStack, MultiBufferSource source, int light, CallbackInfo ci) {
        var hand = Minecraft.getInstance().options.mainHand == arm ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;

//        if(entity instanceof PowerArmorFrame) return;
        if (hand == InteractionHand.OFF_HAND) {
//            if (stack.getItem() instanceof GunItem) {
//                ci.cancel();
//                return;
//            }

            if (entity.getMainHandItem().getItem() instanceof GunItem gunItem) {
                Gun modifiedGun = gunItem.getModifiedGun(entity.getMainHandItem());
                if (!modifiedGun.getGeneral().getGripType().getHeldAnimation().canRenderOffhandItem()) {
                    ci.cancel();
                    return;
                }
            }
        }

        if (stack.getItem() instanceof GunItem gunItem) {
            ci.cancel();
            ItemInHandLayer<?, ?> layer = (ItemInHandLayer<?, ?>) (Object) this;
            renderArmWithGun(layer, entity, stack, gunItem, transformType, hand, arm,
                    poseStack, source, light, Minecraft.getInstance().getFrameTime());
        }
    }

    //Third person render
    private static void renderArmWithGun(ItemInHandLayer<?, ?> layer, LivingEntity entity, ItemStack stack,
                                         GunItem item, ItemTransforms.TransformType transformType,
                                         InteractionHand hand, HumanoidArm arm, PoseStack poseStack,
                                         MultiBufferSource source, int light, float deltaTicks) {
        poseStack.pushPose();
        layer.getParentModel().translateToHand(arm, poseStack);
        poseStack.mulPose(Vector3f.XP.rotationDegrees(-90F));
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180F));


        GunRenderingHandler.get().applyWeaponScale(stack, poseStack);
        Gun gun = item.getModifiedGun(stack);

        var heldAnimation = gun.getGeneral().getGripType().getHeldAnimation();

        var side = arm == HumanoidArm.LEFT ? 1 : -1;

//        if(heldAnimation instanceof OneHandedPose)
//            poseStack.translate(0.5 * side, -0.5, -1.2);
//        else poseStack.translate((side * 3) / 16F, 0, -0.625);/*0.125, -0.625*/

        heldAnimation.applyHeldItemTransforms(entity, hand,
                AimingHandler.get().getAimProgress(entity, deltaTicks), poseStack, source);

        GunRenderingHandler.get().renderWeapon(entity, stack, transformType, poseStack, source, light, deltaTicks);
        poseStack.popPose();
    }
}
