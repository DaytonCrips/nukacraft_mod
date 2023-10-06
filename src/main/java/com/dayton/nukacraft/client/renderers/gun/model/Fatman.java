package com.dayton.nukacraft.client.renderers.gun.model;

import com.dayton.nukacraft.client.SpecialModels;
import com.mojang.blaze3d.vertex.PoseStack;
import com.dayton.guns.client.render.gun.IOverrideModel;
import com.dayton.guns.client.util.RenderUtil;
import com.dayton.guns.base.Gun;
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
