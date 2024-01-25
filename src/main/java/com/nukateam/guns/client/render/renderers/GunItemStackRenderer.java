package com.nukateam.guns.client.render.renderers;

import com.nukateam.guns.client.data.handler.GunRenderingHandler;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;

/**
 * Author: MrCrayfish
 */
public class GunItemStackRenderer extends BlockEntityWithoutLevelRenderer {
    public GunItemStackRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transform, PoseStack poseStack, MultiBufferSource source, int light, int overlay) {
        // Hack to remove transforms created by ItemRenderer#render
        poseStack.popPose();

        poseStack.pushPose();
        {
            var minecraft = Minecraft.getInstance();
            if (transform == ItemTransforms.TransformType.GROUND)
                GunRenderingHandler.get().applyWeaponScale(stack, poseStack);

            GunRenderingHandler.get().renderWeapon(minecraft.player, stack, transform, poseStack, source, light, minecraft.getDeltaFrameTime());
        }
        poseStack.popPose();

        // Push the stack again since we popped the pose prior
        poseStack.pushPose();
    }
}
