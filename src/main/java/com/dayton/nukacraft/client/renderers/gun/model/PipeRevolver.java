package com.dayton.nukacraft.client.renderers.gun.model;

import com.dayton.nukacraft.client.SpecialModels;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.mrcrayfish.guns.client.render.gun.IOverrideModel;
import com.mrcrayfish.guns.client.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

public class PipeRevolver  implements IOverrideModel {
    @Override
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
        RenderUtil.renderModel(SpecialModels.PIPEREVOLVER.getModel(), stack, matrixStack, buffer, light, overlay);




        float cooldown = 0F;
        if(entity != null && entity.equals(Minecraft.getInstance().player))
        {
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            cooldown = (float) easeInOutBack(cooldown);

        }
        matrixStack.pushPose();
        matrixStack.translate(0, -4.65 * 0.0625, 0);
        matrixStack.mulPose(Vector3f.ZN.rotationDegrees(45F * cooldown));
        matrixStack.translate(0, 4.65 * 0.0625, 0);
        RenderUtil.renderModel(SpecialModels.PIPEREVOLVER_CYLINDER.getModel(), stack, matrixStack, buffer, light, overlay);

        matrixStack.popPose();

    }

    private double easeInOutBack(double x)
    {
        double c1 = 1.70158;
        double c2 = c1 * 1.525;
        return (x < 0.5 ? (Math.pow(2 * x, 2) * ((c2 + 1) * 2 * x - c2)) / 2 : (Math.pow(2 * x - 2, 2) * ((c2 + 1) * (x * 2 - 2) + c2) + 2) / 2);
    }
}
