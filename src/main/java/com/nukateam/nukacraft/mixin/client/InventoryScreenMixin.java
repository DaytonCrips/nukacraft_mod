package com.nukateam.nukacraft.mixin.client;

import com.nukateam.ntgl.client.event.InputEvents;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

@OnlyIn(Dist.CLIENT)
@Mixin({InventoryScreen.class})
public abstract class InventoryScreenMixin extends EffectRenderingInventoryScreen<InventoryMenu> {
    @Unique private static final ResourceLocation PIPBOY_LOCATION = nukaResource("textures/gui/screen/default_pipboy.png");
    @Unique private int leftPos;
    @Unique private int topPos;

    public InventoryScreenMixin(InventoryMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
//
//    @Inject(method = {"getXSize"}, at = @At(value = "HEAD"))
//    public int getXSize() { return imageWidth; }
//
//    @Inject(method = {"getXSize"}, at = @At(value = "HEAD"))
//    public int getYSize() { return imageHeight; }

    @Inject(method = {"init()V"}, at = @At(value = "HEAD"))
    protected void init(CallbackInfo ci) {
//        this.imageWidth = 327;
//        this.imageHeight = 299;
        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
    }

    @Inject(method = {"renderBg(Lnet/minecraft/client/gui/GuiGraphics;FII)V"}, at = @At(value = "HEAD"), cancellable = true)
    protected void renderBg(GuiGraphics gui, float pPartialTick, int pMouseX, int pMouseY, CallbackInfo ci) {
        int i = this.leftPos + InputEvents.X;
        int j = this.topPos + InputEvents.Y;

//        gui.pose().pushPose();
//        {
//            gui.pose().scale(0.9f, 0.7f, 1);
            gui.blit(PIPBOY_LOCATION, i, j, 0, 0, 327, 299, 327, 299);
//        }
//        gui.pose().popPose();

//        ci.cancel();
    }
}