package com.dayton.guns.client.handler;

import com.dayton.guns.common.base.Gun;
import com.dayton.guns.common.foundation.item.GunItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Author: MrCrayfish
 */
public class EntityModelHandler {
    /*@SubscribeEvent
    public void onRenderPlayer(PlayerModelEvent.Render.Post event)
    {
        PoseStack poseStack = event.getPoseStack();
        Player player = event.getPlayer();
        ItemStack heldItem = player.getOffhandItem();
        if(!heldItem.isEmpty() && heldItem.getItem() instanceof GunItem)
        {
            poseStack.pushPose();
            Gun gun = ((GunItem) heldItem.getItem()).getModifiedGun(heldItem);
            if(gun.getGeneral().getGripType().getHeldAnimation().applyOffhandTransforms(player, event.getPlayerModel(), heldItem, poseStack, event.getDeltaTicks()))
            {
                MultiBufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();
                GunRenderingHandler.get().renderWeapon(player, heldItem, ItemTransforms.TransformType.FIXED, poseStack, buffer, event.getLight(), event.getDeltaTicks());
            }
            poseStack.popPose();
        }
    }*/

    @SubscribeEvent
    public void onRenderPlayer(RenderLivingEvent.Pre<LivingEntity, HumanoidModel<LivingEntity>> event) {
        var entity = event.getEntity();
        var heldItem = entity.getMainHandItem();
        if (!heldItem.isEmpty() && heldItem.getItem() instanceof GunItem) {
            Gun gun = ((GunItem) heldItem.getItem()).getModifiedGun(heldItem);
            gun.getGeneral().getGripType().getHeldAnimation().applyEntityPreRender(entity, InteractionHand.MAIN_HAND,
                    AimingHandler.get().getAimProgress(event.getEntity(), event.getPartialTick()),
                    event.getPoseStack(), event.getMultiBufferSource());
        }
    }

    @SubscribeEvent
    public void onRenderPlayer(RenderLivingEvent.Post<LivingEntity, HumanoidModel<LivingEntity>> event) {
        /* Makes sure the model part positions reset back to original definitions */
        var model = event.getRenderer().getModel();
        boolean slim = event.getEntity() instanceof AbstractClientPlayer player
                && player.getModelName().equals("slim");
        model.rightArm.x = -5.0F;
        model.rightArm.y = slim ? 2.5F : 2.0F;
        model.rightArm.z = 0.0F;
        model.leftArm.x = 5.0F;
        model.leftArm.y = slim ? 2.5F : 2.0F;
        model.leftArm.z = 0.0F;


        /*model.head.x = 5.0F;
        model.leftArm.y = slim ? 2.5F : 2.0F;
        model.leftArm.z = 0.0F;*/
    }
}
