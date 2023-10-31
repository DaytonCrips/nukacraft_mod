package com.nukateam.nukacraft.client.models.guns;

import com.nukateam.guns.client.render.gun.IOverrideModel;
import com.nukateam.guns.client.util.RenderUtil;
import com.nukateam.guns.common.base.Gun;
import com.nukateam.guns.common.foundation.item.attachment.IAttachment;
import com.nukateam.nukacraft.client.SpecialModels;
import com.nukateam.nukacraft.common.foundation.items.ModGuns;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;

public class Classic10MMZap implements IOverrideModel {
    @Override
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
        RenderUtil.renderModel(SpecialModels.CLASSIC10mmZap.getModel(), stack, matrixStack, buffer, light, overlay);

        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGuns.MAGAZINE1.get())
            RenderUtil.renderModel(SpecialModels.CLASSIC10mm_t1Zap.getModel(), stack, matrixStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGuns.MAGAZINE2.get())
            RenderUtil.renderModel(SpecialModels.CLASSIC10mm_t2Zap.getModel(), stack, matrixStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGuns.MAGAZINE3.get())
            RenderUtil.renderModel(SpecialModels.CLASSIC10mm_t3Zap.getModel(), stack, matrixStack, buffer, light, overlay);


        if(entity.equals(Minecraft.getInstance().player)) {
            matrixStack.pushPose();
            ItemCooldowns tracker = Minecraft.getInstance().player.getCooldowns();
            float cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
            if(Gun.hasAmmo(stack))
                matrixStack.translate(0, 0, 0.1f * (-4.5 * Math.pow(cooldown-0.5, 2) + 1.125));
            else if(!Gun.hasAmmo(stack)) {

                if(cooldown > 0.5)
                    matrixStack.translate(0, 0, 0.185f * (-4.5 * Math.pow(cooldown-0.5, 2) + 0.5));
                else
                    matrixStack.translate(0, 0, 0.185f * (-4.5 * Math.pow(0.5-0.5, 2) + 0.5));
            }
            RenderUtil.renderModel(SpecialModels.CLASSIC10mm_SLIDEZap.getModel(), stack, matrixStack, buffer, light, overlay);
            matrixStack.popPose();
        }
    }

    private double ease(double x) {

        return 1 - Math.pow(1 - (2 * x), 4);

    }
}
