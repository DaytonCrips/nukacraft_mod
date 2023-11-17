package com.dayton.guns.client.render.renderers;

import com.dayton.guns.client.GunRenderType;
import com.dayton.guns.common.base.Gun;
import com.dayton.guns.common.data.util.GunModifierHelper;
import com.dayton.guns.common.foundation.item.AnimatedGunItem;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.guns.common.foundation.item.attachment.IAttachment;
import com.dayton.guns.common.foundation.item.attachment.IBarrel;
import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import mod.azure.azurelib.cache.object.GeoBone;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Random;

import static com.dayton.guns.client.handler.GunRenderingHandler.*;
import static com.dayton.guns.client.util.PropertyHelper.*;
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
    public void render(ItemStack stack, TransformType transformType, PoseStack poseStack,
                       AnimatedGunItem animatable, @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
        renderAttachments(stack, animatable);
        super.render(stack, transformType, poseStack, animatable, bufferSource, renderType, buffer, packedLight);
    }

    @Override
    public void renderRecursively(PoseStack poseStack, AnimatedGunItem animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer,
                                  boolean isReRender, float partialTick, int packedLight, int packedOverlay,
                                  float red, float green, float blue, float alpha) {

        if(bone.getName().equals("muzzle_flash")){
//            drawMuzzleFlash(poseStack, currentTransform, bone, currentItemStack, bufferSource, partialTick);
        }

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    private void drawMuzzleFlash(PoseStack poseStack, TransformType transformType, GeoBone bone, ItemStack weapon,
                                 MultiBufferSource buffer, float partialTicks) {
        var modifiedGun = ((GunItem) weapon.getItem()).getModifiedGun(weapon);

        if (!hasMuzzleFlash(weapon, modifiedGun)) return;

        if (modifiedGun.getDisplay().getFlash() == null)
            return;

        if (transformType != TransformType.FIRST_PERSON_RIGHT_HAND && transformType
                != TransformType.THIRD_PERSON_RIGHT_HAND && transformType
                != TransformType.FIRST_PERSON_LEFT_HAND && transformType
                != TransformType.THIRD_PERSON_LEFT_HAND)
            return;

        var random = this.random.nextFloat();
//        var poseStack = new PoseStack();
        var flip = random >= 0.5F;
        poseStack.pushPose();

//        poseStack.translate(bone.getPivotX(), bone.getPivotY(), bone.getPivotZ());

        var flashPosition = getMuzzleFlashPosition(weapon, modifiedGun);
        poseStack.translate(flashPosition.x * 0.2, flashPosition.y * 0.2, flashPosition.z * 0.2);

        // Legacy method to move muzzle flash to be at the end of the barrel attachment
        var barrelStack = Gun.getAttachment(IAttachment.Type.BARREL, weapon);
        if (!barrelStack.isEmpty() && barrelStack.getItem() instanceof IBarrel barrel
                && !isUsingBarrelMuzzleFlash(barrelStack)) {
            var scale = getAttachmentScale(weapon, modifiedGun, IAttachment.Type.BARREL);
            double length = barrel.getProperties().getLength();
            poseStack.translate(0, 0, -length * 0.0625 * scale.z);
        }

        poseStack.mulPose(Vector3f.ZP.rotationDegrees(360F * random));
        poseStack.mulPose(Vector3f.XP.rotationDegrees(flip ? 180F : 0F));

        var flashScale = getMuzzleFlashScale(weapon, modifiedGun);
        var scaleX = ((float) flashScale.x / 2F) - ((float) flashScale.x / 2F) * (1.0F - partialTicks);
        var scaleY = ((float) flashScale.y / 2F) - ((float) flashScale.y / 2F) * (1.0F - partialTicks);
        poseStack.scale(scaleX, scaleY, 1.0F);

        var scaleModifier = (float) GunModifierHelper.getMuzzleFlashScale(weapon, 1.0);
        poseStack.scale(scaleModifier, scaleModifier, 1.0F);

        // Center the texture
        poseStack.translate(0, 0, 0);

        var minU = weapon.isEnchanted() ? 0.5F : 0.0F;
        var maxU = weapon.isEnchanted() ? 1.0F : 0.5F;
        var matrix = poseStack.last().pose();
        var builder = buffer.getBuffer(GunRenderType.getMuzzleFlash());

        builder.vertex(matrix, 0, 0, 0).color(1.0F, 1.0F, 1.0F, 1.0F).uv(maxU, 1.0F).uv2(PACKED_OVERLAY).endVertex();
        builder.vertex(matrix, 1, 0, 0).color(1.0F, 1.0F, 1.0F, 1.0F).uv(minU, 1.0F).uv2(PACKED_OVERLAY).endVertex();
        builder.vertex(matrix, 1, 1, 0).color(1.0F, 1.0F, 1.0F, 1.0F).uv(minU, 0).uv2(PACKED_OVERLAY).endVertex();
        builder.vertex(matrix, 0, 1, 0).color(1.0F, 1.0F, 1.0F, 1.0F).uv(maxU, 0).uv2(PACKED_OVERLAY).endVertex();

        poseStack.popPose();
    }

    public void renderGun(LivingEntity entity, TransformType transformType, ItemStack stack,
                          PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light) {
        try {
            renderStack = stack;

            this.render(
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
