package com.nukateam.nukacraft.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.common.registery.HeartType;
import com.nukateam.nukacraft.common.registery.ModAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static com.nukateam.ntgl.client.data.handler.GunRenderingHandler.GUI_ICONS_LOCATION;
import static com.nukateam.nukacraft.common.data.constants.Textures.RAD_HEART_ICON;

@Mixin(Gui.class)
public abstract class GuiMixin{
    @Unique
    protected final RandomSource random = RandomSource.create();

    private static double getPlayerRadiation() {
        return Minecraft.getInstance().player.getAttributeValue(ModAttributes.RADIATION.get());
    }

    @Unique
    private static void renderRadHeart(GuiGraphics pGuiGraphics, int heartPosX, int heartPosY, boolean isFull) {
//        RenderSystem.setShaderTexture(0, RAD_HEART_ICON);
        pGuiGraphics.blit(RAD_HEART_ICON, heartPosX, heartPosY, isFull ? 0 : 9, 0, 9, 9, 18, 9);
//        RenderSystem.setShaderTexture(0, GUI_ICONS_LOCATION);
    }

    private void renderHeart(GuiGraphics pGuiGraphics, HeartType pHeartType, int pX, int pY, int pYOffset, boolean pRenderHighlight, boolean pHalfHeart) {
        pGuiGraphics.blit(GUI_ICONS_LOCATION, pX, pY, pHeartType.getX(pHalfHeart, pRenderHighlight), pYOffset, 9, 9);
    }

    @Inject(method = "renderHearts", at = @At("HEAD"), cancellable = true)
    protected void renderHearts(GuiGraphics graphics, Player player,
                                int x, int y, int height,
                                int regen, float healthMax,
                                int health, int healthLast,
                                int absorb, boolean highlight,
                                CallbackInfo ci) {
        var heartType = HeartType.forPlayer(player);
        int yOffset = 9 * (player.level().getLevelData().isHardcore() ? 5 : 0);

        int rads = (int) getPlayerRadiation();

        int baseMaxHealth = (int) player.getAttributeBaseValue(Attributes.MAX_HEALTH);
        int baseMaxHearts = Mth.ceil((double) baseMaxHealth / 2.0D);


        int radHearts = Mth.floor(rads / 2.0D);
        int maxHearts = Mth.ceil((double) healthMax / 2.0D);
        int absorbHearts = Mth.ceil((double) absorb / 2.0D);
        int maxHalfHearts = maxHearts * 2;

        if (radHearts + maxHearts > baseMaxHearts) {
            radHearts = baseMaxHearts - maxHearts;
        }

        var allHearts = maxHearts + absorbHearts + radHearts;

        for (int heartId = allHearts - 1; heartId >= 0; --heartId) {
            int rows = heartId / 10;
            int heartInRow = heartId % 10;
            int heartPosX = x + heartInRow * 8;
            int heartPosY = y - rows * height;

            if (health + absorb <= 4)
                heartPosY += this.random.nextInt(2);

            if (heartId < maxHearts && heartId == regen)
                heartPosY -= 2;

            this.renderHeart(graphics, HeartType.CONTAINER, heartPosX, heartPosY, yOffset, highlight, false);
            int halfHearts = heartId * 2;

            ///
//            if(hearts - maxHearts > 0){
//            }
            ///

            var isHealthOdd = health != maxHearts * 2;
            var isLastHeartId = heartId == maxHearts - 1;

            if (isHealthOdd && isLastHeartId && rads > 0) {
                renderRadHeart(graphics, heartPosX, heartPosY, false);
            }

            if (heartId >= maxHearts) {
                if (allHearts - absorbHearts > heartId) {
                    renderRadHeart(graphics, heartPosX, heartPosY, true);
                } else {
                    int additionalHearts = halfHearts - maxHalfHearts;
                    if (additionalHearts < absorb) {
                        boolean isHalf = additionalHearts + 1 == absorb;
                        this.renderHeart(graphics, heartType == HeartType.WITHERED ? heartType : HeartType.ABSORBING,
                                heartPosX, heartPosY, yOffset, false, isHalf);
                    }
                }
            }

            if (highlight && halfHearts < healthLast) {
                boolean isHalf = halfHearts + 1 == healthLast;
                this.renderHeart(graphics, heartType, heartPosX, heartPosY, yOffset, true, isHalf);
            }

            if (halfHearts < health) {
                boolean isHalf = halfHearts + 1 == health;
                this.renderHeart(graphics, heartType, heartPosX, heartPosY, yOffset, false, isHalf);
            }
        }

        ci.cancel();
    }
}