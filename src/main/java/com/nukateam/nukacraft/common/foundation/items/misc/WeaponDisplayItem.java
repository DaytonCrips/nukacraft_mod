package com.nukateam.nukacraft.common.foundation.items.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.ItemStack;

public class WeaponDisplayItem extends HangingEntityItem {
    public WeaponDisplayItem(EntityType<? extends HangingEntity> pType, Properties pProperties) {
        super(pType, pProperties);
    }

    protected boolean mayPlace(Player pPlayer, Direction pDirection, ItemStack pItemStack, BlockPos pPos) {
        return !pPlayer.level().isOutsideBuildHeight(pPos) && pPlayer.mayUseItemAt(pPos, pDirection, pItemStack);
    }
}
