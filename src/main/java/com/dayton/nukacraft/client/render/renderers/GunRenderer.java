package com.dayton.nukacraft.client.render.renderers;

import com.dayton.guns.client.util.RenderUtil;
import com.dayton.guns.common.base.Gun;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.nukacraft.client.SpecialModels;
import com.dayton.nukacraft.client.models.GunModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.object.GeoBone;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.renderer.GeoObjectRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static com.dayton.guns.common.foundation.item.GunItem.*;
import static com.dayton.nukacraft.common.data.constants.Animations.SHOT;
import static net.minecraft.client.renderer.block.model.ItemTransforms.*;

public class GunRenderer extends GeoObjectRenderer<GunItem> {
    private ItemStack currentItemStack;
    private TransformType renderPerspective;

    public GunRenderer() {
        super(new GunModel());
    }

    public void render(ItemStack stack, TransformType transformType,
                       PoseStack poseStack, GunItem animatable,
                       @Nullable MultiBufferSource bufferSource,
                       @Nullable RenderType renderType, @Nullable
                           VertexConsumer buffer, int packedLight) {
        this.currentItemStack = stack;
        this.renderPerspective = transformType;
        super.render(poseStack, animatable, bufferSource, renderType, buffer, packedLight);
        this.animate(stack);
    }

    protected void animate(ItemStack stack){
        var tracker = Minecraft.getInstance().player.getCooldowns();
        float cooldown = tracker.getCooldownPercent(stack.getItem(), Minecraft.getInstance().getFrameTime());
        if(Gun.hasAmmo(stack) && cooldown > 0) {
            doAnim(stack, SHOT);
        }
        else{
            resetAnim(stack);
        }
    }

    @Override
    public void actuallyRender(PoseStack poseStack, GunItem animatable, BakedGeoModel model,
                               RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer,
                               boolean isReRender, float partialTick, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {

        if (!isReRender) {
            var animationState = new AnimationState<>(animatable, 0, 0, partialTick, false);
            long instanceId = getInstanceId(animatable);

            animationState.setData(DataTickets.TICK, animatable.getTick(this.currentItemStack));
            animationState.setData(DataTickets.ITEM_RENDER_PERSPECTIVE, this.renderPerspective);
            animationState.setData(DataTickets.ITEMSTACK, this.currentItemStack);
            animatable.getAnimatableInstanceCache().getManagerForId(instanceId).setData(DataTickets.ITEM_RENDER_PERSPECTIVE, this.renderPerspective);
            this.model.addAdditionalStateData(animatable, instanceId, animationState::setData);

            if(!bannedTransforms.contains(renderPerspective))
                this.model.handleAnimations(animatable, instanceId, animationState);
        }

        this.modelRenderTranslations = new Matrix4f(poseStack.last().pose());

        originalActuallyRender(poseStack, animatable, model, renderType, bufferSource, buffer,
                isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

     private void originalActuallyRender(PoseStack poseStack, GunItem animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.updateAnimatedTextureFrame(animatable);

         for (GeoBone group : model.topLevelBones()) {
             this.renderRecursively(poseStack, animatable, group, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
         }

    }
}
