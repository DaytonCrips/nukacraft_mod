//package com.dayton.nukacraft.mixin;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import net.minecraft.client.gui.Gui;
//import net.minecraft.client.gui.GuiComponent;
//import net.minecraft.util.Mth;
//import net.minecraft.world.effect.MobEffects;
//import net.minecraft.world.entity.player.Player;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Unique;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//import java.util.Random;
//
//@Mixin(Gui.class)
//public abstract class GuiMixin extends GuiComponent {
//    @Unique
//    protected final Random random = new Random();
//
//    @Unique
//    private void renderHeart(PoseStack pPoseStack, HeartType pHeartType, int pX, int pY, int p_168705_, boolean p_168706_, boolean p_168707_) {
//        this.blit(pPoseStack, pX, pY, pHeartType.getX(p_168707_, p_168706_), p_168705_, 9, 9);
//    }
//
//    @Inject(method = "renderHearts", at = @At("HEAD"), cancellable = true)
//    protected void renderHearts(PoseStack poseStack, Player player,
//                                int pX, int pY, int pHeight,
//                                int regen, float healthMax,
//                                int health, int healthLast,
//                                int absorb, boolean highlight,
//                                CallbackInfo ci) {
//        var heartType = HeartType.forPlayer(player);
//        int i = 9 * (player.level.getLevelData().isHardcore() ? 5 : 0);
//        int j = Mth.ceil((double) healthMax / 2.0D);
//        int k = Mth.ceil((double) absorb / 2.0D);
//        int l = j * 2;
//        //player.addAdditionalSaveData();
//        for(int i1 = j + k - 1; i1 >= 0; --i1) {
//            int j1 = i1 / 10;
//            int k1 = i1 % 10;
//            int l1 = pX + k1 * 8;
//            int i2 = pY - j1 * pHeight;
//            if (health + absorb <= 4) {
//                i2 += this.random.nextInt(2);
//            }
//
//            if (i1 < j && i1 == regen) {
//                i2 -= 2;
//            }
//
//            this.renderHeart(poseStack, HeartType.CONTAINER, l1, i2, i, highlight, false);
//            int j2 = i1 * 2;
//            boolean flag = i1 >= j;
//            if (flag) {
//                int k2 = j2 - l;
//                if (k2 < absorb) {
//                    boolean flag1 = k2 + 1 == absorb;
//                    this.renderHeart(poseStack, heartType == HeartType.WITHERED ? heartType : HeartType.ABSORBING, l1, i2, i, false, flag1);
//                }
//            }
//
//            if (highlight && j2 < healthLast) {
//                boolean flag2 = j2 + 1 == healthLast;
//                this.renderHeart(poseStack, heartType, l1, i2, i, true, flag2);
//            }
//
//            if (j2 < health) {
//                boolean flag3 = j2 + 1 == health;
//                this.renderHeart(poseStack, heartType, l1, i2, i, false, flag3);
//            }
//        }
//
//    }
//
//}
//
//@OnlyIn(Dist.CLIENT)
//enum HeartType {
//    CONTAINER(0, false),
//    NORMAL(2, true),
//    POISIONED(4, true),
//    WITHERED(6, true),
//    ABSORBING(8, false),
//    FROZEN(9, false);
//
//    private final int index;
//    private final boolean canBlink;
//
//    private HeartType(int pIndex, boolean pCanBlink) {
//        this.index = pIndex;
//        this.canBlink = pCanBlink;
//    }
//
//    public int getX(boolean p_168735_, boolean p_168736_) {
//        int i;
//        if (this == CONTAINER) {
//            i = p_168736_ ? 1 : 0;
//        } else {
//            int j = p_168735_ ? 1 : 0;
//            int k = this.canBlink && p_168736_ ? 2 : 0;
//            i = j + k;
//        }
//
//        return 16 + (this.index * 2 + i) * 9;
//    }
//
//    static HeartType forPlayer(Player pPlayer) {
//        HeartType gui$hearttype;
//        if (pPlayer.hasEffect(MobEffects.POISON)) {
//            gui$hearttype = POISIONED;
//        } else if (pPlayer.hasEffect(MobEffects.WITHER)) {
//            gui$hearttype = WITHERED;
//        } else if (pPlayer.isFullyFrozen()) {
//            gui$hearttype = FROZEN;
//        } else {
//            gui$hearttype = NORMAL;
//        }
//
//        return gui$hearttype;
//    }
//}