package com.dayton.nukacraft.mixin.client;

import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

import static com.dayton.nukacraft.client.models.endity.core.ClientProxy.*;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Shadow
    private float darkenWorldAmount;

    @Shadow @Final
    private RenderBuffers renderBuffers;

    @Shadow public abstract void render(float pPartialTicks, long pNanoTime, boolean pRenderLevel);

    @Inject(method = {"Lnet/minecraft/client/renderer/GameRenderer;tick()V"}, at = @At(value = "TAIL"))
    public void ac_tick(CallbackInfo ci) {
        var nukes = getNukesAround();
        if (nukes.isEmpty()) return;
        if (nukes.get(0).renderNukeSkyDarkFor > 0 && darkenWorldAmount < 1.0F) {
            darkenWorldAmount = Math.min(darkenWorldAmount + 0.3F, 1.0F);
        }
    }

    @Inject(method = {"Lnet/minecraft/client/renderer/GameRenderer;render(FJZ)V"},
            at = @At( value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Lighting;setupFor3DItems()V",
                    shift = At.Shift.AFTER))
    public void ac_render(float partialTick, long nanos, boolean idk, CallbackInfo ci) {
        preScreenRender(partialTick);
    }

//    @Inject(method = {"Lnet/minecraft/client/renderer/GameRenderer;renderLevel(FJLcom/mojang/blaze3d/vertex/PoseStack;)V"},
//            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;renderItemInHand(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/Camera;F)V", shift = At.Shift.AFTER)
//    )
//    public void ac_renderLevelAfterHand(float partialTicks, long time, PoseStack poseStack, CallbackInfo ci) {
//        if (Minecraft.getInstance().getCameraEntity() instanceof LivingEntity living && living.hasEffect(ACEffectRegistry.BUBBLED.get()) && Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
//            MultiBufferSource.BufferSource multibuffersource$buffersource = Minecraft.getInstance().renderBuffers().bufferSource();
//            ACPotionEffectLayer.renderBubbledFirstPerson(poseStack);
//            multibuffersource$buffersource.endBatch();
//        }
//    }
}
