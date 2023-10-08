package com.dayton.nukacraft.client.models.guns;

import com.dayton.guns.client.render.gun.IOverrideModel;
import com.dayton.guns.client.util.RenderUtil;
import com.dayton.guns.common.base.Gun;
import com.dayton.guns.common.foundation.item.attachment.IAttachment;
import com.dayton.nukacraft.client.SpecialModels;
import com.dayton.nukacraft.common.foundation.items.ModGuns;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class Scout10MM implements IOverrideModel {
    @Override
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {
        RenderUtil.renderModel(SpecialModels.SCOUT10mm.getModel(), stack, matrixStack, buffer, light, overlay);

        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == Items.AIR)
            RenderUtil.renderModel(SpecialModels.SCOUT10mm_t0.getModel(), stack, matrixStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGuns.MAGAZINE1.get())
            RenderUtil.renderModel(SpecialModels.SCOUT10mm_t1.getModel(), stack, matrixStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGuns.MAGAZINE2.get())
            RenderUtil.renderModel(SpecialModels.SCOUT10mm_t2.getModel(), stack, matrixStack, buffer, light, overlay);
        if(Gun.getAttachment(IAttachment.Type.UNDER_BARREL, stack).getItem() == ModGuns.MAGAZINE3.get())
            RenderUtil.renderModel(SpecialModels.SCOUT10mm_t3.getModel(), stack, matrixStack, buffer, light, overlay);

    }

    private double ease(double x) {

        return 1 - Math.pow(1 - (2 * x), 4);

    }
}
