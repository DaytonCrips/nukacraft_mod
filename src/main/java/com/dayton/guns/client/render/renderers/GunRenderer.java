package com.dayton.guns.client.render.renderers;

import com.dayton.guns.common.foundation.item.AnimatedGunItem;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.guns.common.foundation.item.StaticGunItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

import static com.dayton.guns.common.foundation.item.GunItem.bannedTransforms;

public class GunRenderer {
    public static final int PACKED_OVERLAY = 15728880;
    public static AnimatedGunRenderer<AnimatedGunItem> animatedGunRenderer = new AnimatedGunRenderer<>();
    public static StaticGunRenderer<StaticGunItem> staticGunRenderer = new StaticGunRenderer<>();

    public void renderGun(@Nullable LivingEntity entity, ItemTransforms.TransformType transformType, ItemStack stack,
                           PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light, float partialTicks) {

        try {
            var gun = (GunItem) stack.getItem();
            if (!bannedTransforms.contains(transformType))

            animatedGunRenderer.render(
                    stack,
                    transformType,
                    poseStack,
                    new AnimatedGunItem(gun.getName()),
                    renderTypeBuffer,
                    null,
                    null,
                    light);
            else staticGunRenderer.render(
                    poseStack, new StaticGunItem(gun.getName()),
                    renderTypeBuffer,
                    null,
                    null,
                    light);

        } catch (Exception ignored) {}
    }
}
