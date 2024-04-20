package com.nukateam.nukacraft.client.render.renderers.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.nukateam.ntgl.client.data.enums.SpecialModels;
import com.nukateam.ntgl.client.data.util.RenderUtil;
import com.nukateam.nukacraft.common.foundation.entities.misc.MiniNukeEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;

public class MiniNukeRenderer extends EntityRenderer<MiniNukeEntity> {
    public MiniNukeRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(MiniNukeEntity entity) {
        return null;
    }

    @Override
    public void render(MiniNukeEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light) {
        if (!entity.getProjectile().isVisible() || entity.tickCount <= 1)
            return;

        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(180F));
        poseStack.mulPose(Axis.YP.rotationDegrees(entityYaw));
        poseStack.mulPose(Axis.XP.rotationDegrees(entity.getXRot() - 90));
        Minecraft.getInstance().getItemRenderer()
                .renderStatic(entity.getItem(), ItemDisplayContext.NONE, 15728880,
                        OverlayTexture.NO_OVERLAY, poseStack, renderTypeBuffer, Minecraft.getInstance().level, 0);

        poseStack.translate(0, -1, 0);
        RenderUtil.renderModel(SpecialModels.FLAME.getModel(), entity.getItem(), poseStack,
                renderTypeBuffer, 15728880, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }
}

