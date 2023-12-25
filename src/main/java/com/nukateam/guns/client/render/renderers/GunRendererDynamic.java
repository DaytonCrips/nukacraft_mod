package com.nukateam.guns.client.render.renderers;

import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.guns.client.render.layers.PlayerSkinLayer;
import com.nukateam.guns.common.foundation.item.AnimatedGunItem;
import mod.azure.azurelib.cache.object.GeoBone;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Random;

import static com.nukateam.guns.client.handler.GunRenderingHandler.getAttachmentNames;
import static com.nukateam.nukacraft.common.data.utils.PowerArmorUtils.isWearingPowerArmor;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.*;

public class GunRendererDynamic extends GeoDynamicItemRenderer<AnimatedGunItem> {
    public static final int PACKED_OVERLAY = 15728880;
    public static final String RIGHT_ARM = "right_arm";
    public static final String LEFT_ARM = "left_arm";
    public static ItemStack renderStack;
    public static PoseStack poseStack;
    private MultiBufferSource bufferSource;
    private RenderType renderType;
    private TransformType transformType;
    private boolean renderHends = false;

    private static final Map<TransformType, AnimatedGunItem> items = Map.of(
            NONE, new AnimatedGunItem(NONE),
            THIRD_PERSON_LEFT_HAND, new AnimatedGunItem(THIRD_PERSON_LEFT_HAND),
            THIRD_PERSON_RIGHT_HAND, new AnimatedGunItem(THIRD_PERSON_RIGHT_HAND),
            FIRST_PERSON_LEFT_HAND, new AnimatedGunItem(FIRST_PERSON_LEFT_HAND),
            FIRST_PERSON_RIGHT_HAND, new AnimatedGunItem(FIRST_PERSON_RIGHT_HAND),
            HEAD, new AnimatedGunItem(HEAD),
            GUI, new AnimatedGunItem(GUI),
            GROUND, new AnimatedGunItem(GROUND),
            FIXED, new AnimatedGunItem(FIXED)
    );

    protected Random random = new Random();

    public GunRendererDynamic() {
        super();
        addRenderLayer(new PlayerSkinLayer<>(this));
    }

    @Override
    public void render(LivingEntity entity, ItemStack stack, TransformType transformType, PoseStack poseStack,
                       AnimatedGunItem animatable, @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
        this.bufferSource = bufferSource;
        this.renderType = renderType;

//        poseStack.pushPose();
        switch (transformType) {
            case THIRD_PERSON_LEFT_HAND, THIRD_PERSON_RIGHT_HAND -> {
                if (isWearingPowerArmor(entity))
                    poseStack.translate(-0.5, -0.5, -0.8);
//                else
//                    poseStack.translate(-0.5, -0.5, -1.2);
            }
            case FIRST_PERSON_LEFT_HAND, FIRST_PERSON_RIGHT_HAND -> {
//                poseStack.translate(0.3, -1.3, -1.55);
            }
            case GUI -> {
//                poseStack.translate(0.2, -0.55, -0.5);
                poseStack.translate(0.2, 0, -0.5);
            }
            case GROUND -> {
//                poseStack.translate(-0.5, -0.5, -1);
            }
        }

        renderAttachments(stack, animatable);
        super.render(entity, stack, transformType, poseStack, animatable, bufferSource, renderType, buffer, packedLight);
//        poseStack.popPose();
    }

    @Override
    public void renderRecursively(PoseStack poseStack, AnimatedGunItem animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick,
                                  int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        poseStack.pushPose();
        if(bone.getName().equals(RIGHT_ARM) || bone.getName().equals(LEFT_ARM)){
            bone.setHidden(!renderHends);
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        poseStack.popPose();
    }

    public void renderGun(LivingEntity entity, TransformType transformType, ItemStack stack,
                          PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light) {
        try {
            GunRendererDynamic.renderStack = stack;
            GunRendererDynamic.poseStack = poseStack;
            this.transformType = transformType;
            renderHends = transformType == FIRST_PERSON_RIGHT_HAND || transformType == FIRST_PERSON_LEFT_HAND;

            this.render(
                    entity,
                    stack,
                    transformType,
                    poseStack,
                    getRenderItem(transformType),
                    renderTypeBuffer,
                    null,
                    null,
                    light);

        } catch (Exception ignored) {
        }
    }

    public static AnimatedGunItem getRenderItem(TransformType transformType) {
        return items.get(transformType);
    }

    protected void renderAttachments(ItemStack stack, AnimatedGunItem item) {
        var config = item.getConfig();

        if (config != null) {
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
