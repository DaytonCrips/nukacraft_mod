package com.nukateam.nukacraft.common.data.utils;

import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class PlayerUtils {
    public static boolean hasPipboy(){
        return hasPipboy(Minecraft.getInstance().player);
    }

//    @Nullable
//    public static PipBoyItem getPipboy(Player player){
//        return getPipboy(player);
//    }

//    public static ItemStack getPipboyStack(){
//        return getPipboyStack(Minecraft.getInstance().player);
//    }

    public static boolean hasPipboy(Player player){
        return SlotUtils.getPipboyStack(player).getItem() instanceof PipBoyItem;
    }

    @Nullable
    public static PipBoyItem getPipboy(Player player){
        return hasPipboy() ? (PipBoyItem) SlotUtils.getPipboyStack(player).getItem() : null;
    }

    public static ItemStack getPipboyStack(Player player){
        return player.getOffhandItem();
    }
}
