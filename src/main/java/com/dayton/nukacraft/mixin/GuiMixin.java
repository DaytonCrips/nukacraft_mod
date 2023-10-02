package com.dayton.nukacraft.mixin;

import com.dayton.nukacraft.common.registery.HeartType;
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

import static com.dayton.nukacraft.client.helpers.RadiationMath.getPlayerRadiation;

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

        for (int hearts = maxHearts + absorbHearts - 1; hearts >= 0; --hearts) {
            int rows = hearts / 10;
            int heartInRow = hearts % 10;
            int heartPosX = x + heartInRow * 8;
            int heartPosY = y - rows * height;

            if (health + absorb <= 4)
                heartPosY += this.random.nextInt(2);

            if (hearts < maxHearts && hearts == regen)
                heartPosY -= 2;

            this.renderHeart(poseStack, HeartType.CONTAINER, heartPosX, heartPosY, yOffset, highlight, false);
            int halfHearts = hearts * 2;
            boolean flag = hearts >= maxHearts;
            if (flag) {
                int k2 = halfHearts - maxHalfHearts;
                if (k2 < absorb) {
                    boolean flag1 = k2 + 1 == absorb;
                    this.renderHeart(poseStack, heartType == HeartType.WITHERED ? heartType : HeartType.ABSORBING, heartPosX, heartPosY, yOffset, false, flag1);
                }
            }

            if (highlight && halfHearts < healthLast) {
                boolean flag2 = halfHearts + 1 == healthLast;
                this.renderHeart(poseStack, heartType, heartPosX, heartPosY, yOffset, true, flag2);
            }

            if (halfHearts < health) {
                boolean flag3 = halfHearts + 1 == health;
                this.renderHeart(poseStack, heartType, heartPosX, heartPosY, yOffset, false, flag3);
            }
        }

        ci.cancel();
    }
}