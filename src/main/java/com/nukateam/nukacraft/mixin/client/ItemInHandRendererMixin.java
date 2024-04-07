package com.nukateam.nukacraft.mixin.client;

import net.minecraft.client.renderer.ItemInHandRenderer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemInHandRenderer.class)
public class ItemInHandRendererMixin {

//    @Inject(method = {"renderItem"}, at = @At(value = "HEAD"))
//    public void renderItem(LivingEntity livingEntity, ItemStack pItemStack, TransformType pTransformType,
//                           boolean pLeftHand, PoseStack pPoseStack, MultiBufferSource pBuffer,
//                           int pCombinedLight, CallbackInfo ci) {
//        currentEntity = livingEntity;
//    }
}
