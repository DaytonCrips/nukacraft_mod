package com.dayton.nukacraft.common.registery;

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

    public int getX(boolean p_168735_, boolean highlight) {
        int i;
        if (this == CONTAINER) {
            i = highlight ? 1 : 0;
        } else {
            int j = p_168735_ ? 1 : 0;
            int k = this.canBlink && highlight ? 2 : 0;
            i = j + k;
        }

        return 16 + (this.index * 2 + i) * 9;
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