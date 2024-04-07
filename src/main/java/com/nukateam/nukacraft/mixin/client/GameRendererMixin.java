package com.nukateam.nukacraft.mixin.client;

import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.nukateam.nukacraft.client.helpers.ExplosionUtils.getNukesAround;
import static com.nukateam.nukacraft.client.helpers.ExplosionUtils.preScreenRender;


@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Shadow
    private float darkenWorldAmount;

    @Inject(method = {"Lnet/minecraft/client/renderer/GameRenderer;tick()V"}, at = @At(value = "TAIL"))
    public void ac_tick(CallbackInfo ci) {
        var nukes = getNukesAround();
        if (nukes.isEmpty()) return;
        if (nukes.get(0).darkSkyFor > 0 && darkenWorldAmount < 1.0F)
            darkenWorldAmount = Math.min(darkenWorldAmount + 0.3F, 1.0F);
    }

    @Inject(method = {"Lnet/minecraft/client/renderer/GameRenderer;render(FJZ)V"}, at = @At(value = "INVOKE",
            target = "Lcom/mojang/blaze3d/platform/Lighting;setupFor3DItems()V", shift = At.Shift.AFTER))
    public void ac_render(float partialTick, long nanos, boolean idk, CallbackInfo ci) {
        preScreenRender(partialTick);
    }
}
