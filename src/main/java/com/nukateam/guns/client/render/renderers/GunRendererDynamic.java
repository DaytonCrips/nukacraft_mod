package com.nukateam.guns.client.render.renderers;

import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nukateam.guns.client.animators.GunItemAnimator;
import com.nukateam.guns.client.model.GeoGunModel;
import com.nukateam.guns.client.render.layers.LocalPlayerSkinLayer;
import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.foundation.entities.PowerArmorFrame;
import com.nukateam.nukacraft.common.foundation.entities.Raider;
import mod.azure.azurelib.cache.object.GeoBone;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static com.nukateam.guns.client.handler.GunRenderingHandler.getAttachmentNames;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.*;

public class GunRendererDynamic extends GeoDynamicItemRenderer<GunItemAnimator> {
    public static final int PACKED_OVERLAY = 15728880;
    public static final String RIGHT_ARM = "right_arm";
    public static final String LEFT_ARM = "left_arm";

    private ItemStack renderStack;
    private boolean renderHands = false;
    protected LivingEntity buffEntity = null;

    public GunRendererDynamic() {
        super(new GeoGunModel<>(), GunItemAnimator::new);
        addRenderLayer(new LocalPlayerSkinLayer<>(this));
    }

    public ItemStack getRenderStack() {
        return renderStack;
    }

    public LivingEntity getRenderEntity() {
        return currentEntity;
    }

    public void setEntity(LivingEntity entity) {
        this.buffEntity = entity;
    }

    @Override
    public void render(LivingEntity entity, ItemStack stack, TransformType transformType, PoseStack poseStack,
                       @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {

        this.renderStack = stack;
        this.renderHands = transformType == FIRST_PERSON_RIGHT_HAND || transformType == FIRST_PERSON_LEFT_HAND;

        if(buffEntity != null){
            entity = buffEntity;
            buffEntity = null;
        }

        if(entity instanceof Raider){
            NukaCraftMod.LOGGER.debug("");
        }

//        poseStack.pushPose();
        switch (transformType) {
            case THIRD_PERSON_LEFT_HAND, THIRD_PERSON_RIGHT_HAND -> {
                if (entity instanceof PowerArmorFrame)
                    poseStack.translate(0, 0.07, -0.25);
            }
            case FIRST_PERSON_LEFT_HAND, FIRST_PERSON_RIGHT_HAND -> {
//                poseStack.translate(0, -1.3, -1.55);
            }
            case GUI -> {
//                poseStack.translate(0.2, -0.55, -0.5);
//                poseStack.translate(0.2, 0.1, -0.5);
            }
            case GROUND -> {
//                poseStack.translate(-0.5, -0.5, -1);
            }
        }

        renderAttachments(stack, getRenderItem(entity, transformType));

        super.render(entity, stack, transformType, poseStack, bufferSource, renderType, buffer, packedLight);
//        poseStack.popPose();


    }

    @Override
    public void renderRecursively(PoseStack poseStack, GunItemAnimator animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick,
                                  int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
//        poseStack.pushPose();
        if(bone.getName().equals(RIGHT_ARM) || bone.getName().equals(LEFT_ARM)){
            bone.setHidden(!renderHands);
//            poseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
//        poseStack.popPose();
    }

    protected void renderAttachments(ItemStack stack, GunItemAnimator item) {
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
