package com.nukateam.nukacraft.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.nukateam.nukacraft.client.ClientConfig.*;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

    @Inject(method = {"renderStatic(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;ZLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/level/Level;III)V"}, at = @At(value = "HEAD"))
    public void renderStatic(LivingEntity livingEntity, ItemStack pItemStack, ItemTransforms.TransformType pTransformType,
                             boolean pLeftHand, PoseStack pPoseStack, MultiBufferSource pBuffer, Level pLevel,
                             int pCombinedLight, int pCombinedOverlay, int p_174252_, CallbackInfo ci) {
        entityForStack.put(pItemStack, livingEntity);
    }
}
