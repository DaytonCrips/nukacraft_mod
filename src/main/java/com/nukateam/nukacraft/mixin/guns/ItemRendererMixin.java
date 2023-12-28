package com.nukateam.nukacraft.mixin.guns;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.guns.client.handler.GunRenderingHandler;
import com.nukateam.guns.client.render.Render;
import com.nukateam.guns.common.foundation.item.GunItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @Inject(method = "renderStatic*", at = @At(value = "HEAD"), cancellable = true)
    public void renderStatic(@Nullable LivingEntity entity, ItemStack itemStack,
                             ItemTransforms.TransformType pTransformType, boolean pLeftHand,
                             PoseStack poseStack, MultiBufferSource buffer, @Nullable Level pLevel,
                             int pCombinedLight, int pCombinedOverlay, int p_174252_, CallbackInfo ci) {
        if(itemStack.getItem() instanceof GunItem){
            Render.GUN_RENDERER.setEntity(entity);
//            GunRenderingHandler.get().renderWeapon(entity, itemStack, pTransformType,
//                    poseStack, buffer, pCombinedLight, Minecraft.getInstance().getDeltaFrameTime());
//            ci.cancel();
        }
    }
}
