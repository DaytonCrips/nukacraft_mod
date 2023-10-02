package com.dayton.nukacraft.client.renderers.gun.model;

import com.dayton.nukacraft.client.SpecialModels;
import com.dayton.nukacraft.common.foundation.items.ModGunsClass;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.item.attachment.IAttachment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class PipePistol implements IOverrideModel {
    @Override
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
        RenderUtil.renderModel(SpecialModels.PIPE_PISTOL.getModel(), stack, matrixStack, buffer, light, overlay);

        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == Items.AIR)
            RenderUtil.renderModel(SpecialModels.PIPE_PISTOL_t0.getModel(), stack, matrixStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGunsClass.MAGAZINE1.get())
            RenderUtil.renderModel(SpecialModels.PIPE_PISTOL_t1.getModel(), stack, matrixStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGunsClass.MAGAZINE2.get())
            RenderUtil.renderModel(SpecialModels.PIPE_PISTOL_t2.getModel(), stack, matrixStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGunsClass.MAGAZINE3.get())
            RenderUtil.renderModel(SpecialModels.PIPE_PISTOL_t3.getModel(), stack, matrixStack, buffer, light, overlay);


        if(entity.equals(Minecraft.getInstance().player)) {
            matrixStack.pushPose();
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            float cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            if(Gun.hasAmmo(stack))
                matrixStack.translate(0, 0, 0.1f * (-4.5 * Math.pow(cooldown-0.5, 2) + 1.125));
            else if(!Gun.hasAmmo(stack)) {

                if(cooldown > 0.5)
                    matrixStack.translate(0, 0, 0.19f * (-4.5 * Math.pow(0, 2) + 0.2));
                else
                    matrixStack.translate(0, 0, 0.19f * (-4.5 * Math.pow(0, 2) + 0.2));
            }
            RenderUtil.renderModel(SpecialModels.PIPE_PISTOL_SLIDE.getModel(), stack, matrixStack, buffer, light, overlay);
            matrixStack.popPose();
        }
    }

    private double ease(double x) {

        return 1 - Math.pow(1 - (2 * x), 4);

    }
}
