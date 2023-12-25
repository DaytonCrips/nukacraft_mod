package com.nukateam.nukacraft.client.models.guns;

import com.nukateam.guns.client.render.gun.IOverrideModel;
import com.nukateam.guns.client.data.util.RenderUtil;
import com.nukateam.guns.common.base.gun.Gun;
import com.nukateam.nukacraft.client.SpecialModels;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class Fatman implements IOverrideModel {

    @Override
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
        RenderUtil.renderModel(SpecialModels.FATMAN.getModel(), stack, matrixStack, buffer, light, overlay);
        RenderUtil.renderModel(SpecialModels.FATMAN_CART.getModel(), stack, matrixStack, buffer, light, overlay);

        if(entity.equals(Minecraft.getInstance().player)) {
            matrixStack.pushPose();
            if(Gun.hasAmmo(stack)) {
                matrixStack.scale(1, 1, 1);
                RenderUtil.renderModel(SpecialModels.FATMAN_NUKE.getModel(), stack, matrixStack, buffer, light, overlay);
                }
            else if(!Gun.hasAmmo(stack)) {
                matrixStack.scale(0, 0, 0);
                RenderUtil.renderModel(SpecialModels.FATMAN_NUKE.getModel(), stack, matrixStack, buffer, light, overlay);
            }
            matrixStack.popPose();
        }

    }
}
