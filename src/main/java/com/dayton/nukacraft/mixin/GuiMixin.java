package com.dayton.nukacraft.mixin;

import com.dayton.nukacraft.common.registery.HeartType;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static com.dayton.nukacraft.common.data.constants.Textures.RAD_HEART_ICON;
import static com.dayton.nukacraft.common.data.utils.RadiationHelper.getPlayerRadiation;

@Mixin(Gui.class)
public abstract class GuiMixin extends GuiComponent {
    @Unique
    protected final Random random = new Random();

    @Unique
    private void renderHeart(PoseStack poseStack, HeartType heartType, int x, int y, int vOffset, boolean highlight, boolean p_168707_) {
        this.blit(poseStack, x, y, heartType.getX(p_168707_, highlight), vOffset, 9, 9);
    }

    @Inject(method = "renderHearts", at = @At("HEAD"), cancellable = true)
    protected void renderHearts(PoseStack poseStack, Player player,
                                int x, int y, int height,
                                int regen, float healthMax,
                                int health, int healthLast,
                                int absorb, boolean highlight,
                                CallbackInfo ci) {
        var heartType = HeartType.forPlayer(player);
        int yOffset = 9 * (player.level.getLevelData().isHardcore() ? 5 : 0);

        var rads = getPlayerRadiation();
        int radHearts = Mth.ceil((double) rads / 2.0D);
        int maxHearts = Mth.ceil((double) healthMax / 2.0D);
        int absorbHearts = Mth.ceil((double) absorb / 2.0D);
        int maxHalfHearts = maxHearts * 2;

        var allHearts = maxHearts + absorbHearts + radHearts;

        for (int heart = allHearts - 1; heart >= 0; --heart) {
            int rows = heart / 10;
            int heartInRow = heart % 10;
            int heartPosX = x + heartInRow * 8;
            int heartPosY = y - rows * height;

            if (health + absorb <= 4)
                heartPosY += this.random.nextInt(2);

            if (heart < maxHearts && heart == regen)
                heartPosY -= 2;

            this.renderHeart(poseStack, HeartType.CONTAINER, heartPosX, heartPosY, yOffset, highlight, false);
            int halfHearts = heart * 2;

            ///
//            if(hearts - maxHearts > 0){
//            }
            ///
            if (heart >= maxHearts) {
                if(allHearts - absorbHearts > heart){
                    RenderSystem.setShaderTexture(0, RAD_HEART_ICON);
                    blit(poseStack, heartPosX, heartPosY, 0, 0, 9, 9, 9, 9);
                    RenderSystem.setShaderTexture(0, GuiComponent.GUI_ICONS_LOCATION);
                }
                else {
                    int additionalHearts = halfHearts - maxHalfHearts;
                    if (additionalHearts < absorb) {
                        boolean isHalf = additionalHearts + 1 == absorb;
                        this.renderHeart(poseStack, heartType == HeartType.WITHERED ? heartType : HeartType.ABSORBING,
                                heartPosX, heartPosY, yOffset, false, isHalf);
                    }
                }
            }

            if (highlight && halfHearts < healthLast) {
                boolean isHalf = halfHearts + 1 == healthLast;
                this.renderHeart(poseStack, heartType, heartPosX, heartPosY, yOffset, true, isHalf);
            }

            if (halfHearts < health) {
                boolean isHalf = halfHearts + 1 == health;
                this.renderHeart(poseStack, heartType, heartPosX, heartPosY, yOffset, false, isHalf);
            }
        }

        ci.cancel();
    }
}