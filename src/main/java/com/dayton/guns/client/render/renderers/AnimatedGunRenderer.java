package com.dayton.guns.client.render.renderers;

import com.dayton.guns.client.model.GunModel;
import com.dayton.guns.common.foundation.item.AnimatedGunItem;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.guns.common.foundation.item.GunItemBase;
import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import com.jetug.chassis_core.client.render.renderers.AnimatableItemRenderer;
import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

import static com.dayton.guns.client.handler.GunRenderingHandler.getAttachmentNames;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.*;

public class AnimatedGunRenderer extends GeoItemEntityRenderer<AnimatedGunItem> {
//    public AnimatedGunRenderer() {
//        super(new GunModel<>());
//    }

    @Override
    public void render(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack,
                       AnimatedGunItem animatable, @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
        renderAttachments(stack, animatable);
        super.render(stack, transformType, poseStack, animatable, bufferSource, renderType, buffer, packedLight);
    }

    protected void renderAttachments(ItemStack stack, AnimatedGunItem item) {
        var config = item.getConfig();

        if(config != null) {
            var allMods = config.mods;
            var visibleMods = StackUtils.getAttachments(stack);
            var names = getAttachmentNames(stack);

            for (var name : allMods)
                getGeoModel().getBone(name).ifPresent((bone) -> bone.setHidden(true));
//            for (var name : visibleMods)
//                getGeoModel().getBone(name).ifPresent((bone) -> bone.setHidden(false));
            for (var name : names)
                getGeoModel().getBone(name).ifPresent((bone) -> bone.setHidden(false));
        }
    }


//    @Override
//    protected void renderAttachments(ItemStack stack, AnimatedGunItem item) {
////        super.renderAttachments(stack, item);
////
////        var names = getAttachmentNames(stack);
////        for (var name : names)
////            getGeoModel().getBone(name).ifPresent((bone) -> bone.setHidden(false));
//    }
}