package com.nukateam.nukacraft.common.registery;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public enum HeartType {
    CONTAINER(0, false),
    NORMAL(2, true),
    POISIONED(4, true),
    WITHERED(6, true),
    ABSORBING(8, false),
    FROZEN(9, false);

    private final int index;
    private final boolean canBlink;

    HeartType(int pIndex, boolean pCanBlink) {
        this.index = pIndex;
        this.canBlink = pCanBlink;
    }

    public int getX(boolean isHalf, boolean highlight) {
        int x;
        if (this == CONTAINER) {
            x = highlight ? 1 : 0;
        } else {
            int halfX = isHalf ? 1 : 0;
            int highlightX = this.canBlink && highlight ? 2 : 0;
            x = halfX + highlightX;
        }

        return 16 + (this.index * 2 + x) * 9;
    }

    public static HeartType forPlayer(Player pPlayer) {
        HeartType gui$hearttype;
        if (pPlayer.hasEffect(MobEffects.POISON)) {
            gui$hearttype = POISIONED;
        } else if (pPlayer.hasEffect(MobEffects.WITHER)) {
            gui$hearttype = WITHERED;
        } else if (pPlayer.isFullyFrozen()) {
            gui$hearttype = FROZEN;
        } else {
            gui$hearttype = NORMAL;
        }

        return gui$hearttype;
    }
}