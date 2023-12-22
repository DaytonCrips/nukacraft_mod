package com.nukateam.guns.client.render.renderers;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.nukateam.guns.client.render.layers.PlayerSkinLayer;
import com.nukateam.guns.common.foundation.item.AnimatedGunItem;
import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.cache.object.GeoBone;
import mod.azure.azurelib.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Random;

import static com.nukateam.guns.client.handler.GunRenderingHandler.*;
import static com.nukateam.nukacraft.common.data.utils.PowerArmorUtils.isWearingPowerArmor;
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

    public GunRenderer(){
        super();
//        addRenderLayer(new PlayerSkinLayer(this));
    }

    @Override
    public void render(LivingEntity entity, ItemStack stack, TransformType transformType, PoseStack poseStack,
                       AnimatedGunItem animatable, @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable VertexConsumer buffer, int packedLight) {
        poseStack.pushPose();

        switch (transformType){
            case THIRD_PERSON_LEFT_HAND, THIRD_PERSON_RIGHT_HAND -> {
                if(isWearingPowerArmor(entity))
                    poseStack.translate(-0.5, -0.5, -0.8);
//                else
//                    poseStack.translate(-0.5, -0.5, -1.2);
            }
            case FIRST_PERSON_LEFT_HAND, FIRST_PERSON_RIGHT_HAND -> {
//                poseStack.translate(0.3, -1.3, -1.55);
            }
            case GUI -> {
                poseStack.translate(0.2, -0.55, -0.5);
            }
            case GROUND -> {
                poseStack.translate(-0.5, -0.5, -1);
            }
        }

        renderAttachments(stack, animatable);
        super.render(entity, stack, transformType, poseStack, animatable, bufferSource, renderType, buffer, packedLight);
        poseStack.popPose();
    }

    @Override
    public void renderRecursively(PoseStack poseStack, AnimatedGunItem animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer,
                                  boolean isReRender, float partialTick, int packedLight, int packedOverlay,
                                  float red, float green, float blue, float alpha) {

        if(bone.getName().equals("muzzle_flash")){
//            drawMuzzleFlash(poseStack, currentTransform, bone, currentItemStack, bufferSource, partialTick);
        }

        var client = Minecraft.getInstance();

        boolean renderArms = false;

        //Bones malone let's gooo
        switch (bone.getName())
        {
            case "leftArm", "rightArm" ->
            {
                bone.setHidden(true);
                renderArms = true;
            }
        }

        if(renderArms)
        {
            var playerEntityRenderer = (PlayerRenderer)client.getEntityRenderDispatcher().getRenderer(client.player);
            PlayerModel<AbstractClientPlayer> playerEntityModel = playerEntityRenderer.getModel();

            poseStack.pushPose();

            RenderUtils.translateMatrixToBone(poseStack, bone);
            RenderUtils.translateToPivotPoint(poseStack,bone);
            RenderUtils.rotateMatrixAroundBone(poseStack, bone);
            RenderUtils.scaleMatrixForBone(poseStack, bone);
            RenderUtils.translateAwayFromPivotPoint(poseStack, bone);

            assert(client.player != null);

            var playerSkin = client.player.getSkinTextureLocation();
            VertexConsumer arm = bufferSource.getBuffer(RenderType.entitySolid(playerSkin));
            VertexConsumer sleeve = bufferSource.getBuffer(RenderType.entityTranslucent(playerSkin));

            if(bone.getName().equals("leftArm"))
            {
                poseStack.scale(0.67f, 1.33f, 0.67f);
                poseStack.translate(-0.25,-0.43625,0.1625);
                playerEntityModel.leftArm.setPos(bone.getPivotX(), bone.getPivotY(), bone.getPivotZ());
                playerEntityModel.leftArm.setRotation(0,0,0);
                playerEntityModel.leftArm.render(poseStack, arm, packedLight, packedOverlay, 1, 1, 1, 1);

                playerEntityModel.leftSleeve.setPos(bone.getPivotX(), bone.getPivotY(), bone.getPivotZ());
                playerEntityModel.leftSleeve.setRotation(0,0,0);
                playerEntityModel.leftSleeve.render(poseStack, sleeve, packedLight, packedOverlay, 1, 1, 1, 1);
            }
            else if (bone.getName().equals("rightArm"))
            {
                poseStack.scale(0.67f, 1.33f, 0.67f);
                poseStack.translate(0.25,-0.43625,0.1625);
                playerEntityModel.rightArm.setPos(bone.getPivotX(), bone.getPivotY(), bone.getPivotZ());
                playerEntityModel.rightArm.setRotation(0,0,0);
                playerEntityModel.rightArm.render(poseStack, arm, packedLight, packedOverlay, 1, 1, 1, 1);

                playerEntityModel.rightSleeve.setPos(bone.getPivotX(), bone.getPivotY(), bone.getPivotZ());
                playerEntityModel.rightSleeve.setRotation(0,0,0);
                playerEntityModel.rightSleeve.render(poseStack, sleeve, packedLight, packedOverlay, 1, 1, 1, 1);
            }

            poseStack.popPose();
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
                    getRenderItem(transformType),
                    renderTypeBuffer,
                    null,
                    null,
                    light);

        } catch (Exception ignored) {}
    }

    protected static AnimatedGunItem getRenderItem(TransformType transformType){
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
