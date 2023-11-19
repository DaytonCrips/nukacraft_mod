package com.dayton.guns.client.render.renderers;

import com.dayton.guns.common.foundation.item.AnimatedGunItem;
import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.cache.object.GeoBone;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Random;

import static com.dayton.guns.client.handler.GunRenderingHandler.*;
import static net.minecraft.client.renderer.block.model.ItemTransforms.*;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.*;

public class GunRenderer extends GeoItemEntityRenderer<AnimatedGunItem>{
    public static final int PACKED_OVERLAY = 15728880;
    public static ItemStack renderStack;

    private static final Map<TransformType, AnimatedGunItem> items = Map.of(
            NONE                    , new AnimatedGunItem(NONE                   ),
            THIRD_PERSON_LEFT_HAND  , new AnimatedGunItem(THIRD_PERSON_LEFT_HAND ),
            THIRD_PERSON_RIGHT_HAND , new AnimatedGunItem(THIRD_PERSON_RIGHT_HAND),
            FIRST_PERSON_LEFT_HAND  , new AnimatedGunItem(FIRST_PERSON_LEFT_HAND ),
            FIRST_PERSON_RIGHT_HAND , new AnimatedGunItem(FIRST_PERSON_RIGHT_HAND),
            HEAD                    , new AnimatedGunItem(HEAD                   ),
            GUI                     , new AnimatedGunItem(GUI                    ),
            GROUND                  , new AnimatedGunItem(GROUND                 ),
            FIXED                   , new AnimatedGunItem(FIXED                  )
    );

    protected Random random = new Random();

    @Override
    public void render(LivingEntity entity, ItemStack stack, TransformType transformType, PoseStack poseStack,
                       AnimatedGunItem animatable, @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
        renderAttachments(stack, animatable);
        super.render(entity, stack, transformType, poseStack, animatable, bufferSource, renderType, buffer, packedLight);
    }

    @Override
    public void renderRecursively(PoseStack poseStack, AnimatedGunItem animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer,
                                  boolean isReRender, float partialTick, int packedLight, int packedOverlay,
                                  float red, float green, float blue, float alpha) {

        if(bone.getName().equals("muzzle_flash")){
//            drawMuzzleFlash(poseStack, currentTransform, bone, currentItemStack, bufferSource, partialTick);
        }

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender,
                partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void renderGun(LivingEntity entity, TransformType transformType, ItemStack stack,
                          PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light) {
        try {
            renderStack = stack;

            this.render(
                    entity,
                    stack,
                    transformType,
                    poseStack,
                    getRenderItem(entity, stack, transformType),
                    renderTypeBuffer,
                    null,
                    null,
                    light);

        } catch (Exception ignored) {}
    }

    protected static AnimatedGunItem getRenderItem(LivingEntity entity, ItemStack stack, TransformType transformType){
        return items.get(transformType);
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
}
