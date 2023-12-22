package com.nukateam.guns.client.render.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.guns.client.model.GeoGunModel;
import com.nukateam.guns.client.model.GunModel;
import com.nukateam.guns.common.foundation.item.GunItem;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;

import static com.nukateam.guns.client.render.Render.GUN_RENDERER;

public class GunItemRenderer extends GeoItemRenderer<GunItem> {
    public GunItemRenderer() {
        super(new GeoGunModel<>());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack,
                             MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
//        super.renderByItem(stack, transformType, poseStack, bufferSource, packedLight, packedOverlay);
        var player = Minecraft.getInstance().player;
        GUN_RENDERER.renderGun(player, transformType, stack, poseStack, bufferSource, packedLight);
    }
}
