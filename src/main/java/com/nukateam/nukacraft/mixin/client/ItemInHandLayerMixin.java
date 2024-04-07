package com.nukateam.nukacraft.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.common.data.utils.PipBoyUtils;
import com.nukateam.nukacraft.common.data.utils.SlotUtils;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemInHandLayer.class)
public abstract class ItemInHandLayerMixin<T extends LivingEntity, M extends EntityModel<T> & ArmedModel> {
    private static final String RENDER = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V";
    private static final String RENDER_TARGET = "Lnet/minecraft/client/renderer/entity/layers/ItemInHandLayer;renderArmWithItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;Lnet/minecraft/world/entity/HumanoidArm;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V";

    @Shadow
    protected abstract void renderArmWithItem(LivingEntity pLivingEntity, ItemStack pItemStack,
                                              ItemTransforms.TransformType pTransformType, HumanoidArm pArm,
                                              PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight);

    //    @Inject(method = RENDER, at = @At(value = "INVOKE", target = RENDER_TARGET, ordinal = 0))
    @Inject(method = RENDER, at = @At(value = "HEAD"))
    private void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity,
                        float pLimbSwing, float pLimbSwingAmount, float pPartialTicks,
                        float pAgeInTicks, float pNetHeadYaw, float pHeadPitch, CallbackInfo ci) {

        if (pLivingEntity instanceof Player player && SlotUtils.hasCuriosPipboy(player)) {
            var stack = PipBoyUtils.getPipboyStack(player);
            this.renderArmWithItem(pLivingEntity, stack, ItemTransforms.TransformType.THIRD_PERSON_LEFT_HAND,
                    HumanoidArm.LEFT, pMatrixStack, pBuffer, pPackedLight);
        }
    }
}
