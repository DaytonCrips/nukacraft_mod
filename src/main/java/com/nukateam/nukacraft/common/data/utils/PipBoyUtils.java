package com.nukateam.nukacraft.common.data.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nukateam.nukacraft.client.helpers.NbtColor;
import com.nukateam.nukacraft.common.data.constants.Nbt;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import com.nukateam.nukacraft.common.registery.ModAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class PipBoyUtils {

    public static ResourceLocation warning_image = new ResourceLocation("nukacraft:textures/screens/pipboy_screens/warning_pipboy.png");
    public static Integer[] warn_cords = new Integer[]{-8, -22};

    public static int getPlayerRads(Player player){
        var radVal = player.getAttributeValue(ModAttributes.RADIATION.get());
        return Mth.ceil(radVal);
    }

    public static void setPipboyShader(){
        setPipboyShader(1);
    }

    public static void setPipboyShader(float alpha){
        var mc = Minecraft.getInstance();
        if(mc.player == null) return;

        var color = getPipboyColor(mc.player);
        RenderSystem.setShaderColor(color.red, color.green, color.blue, alpha);
    }

    public static NbtColor getPipboyColor(@NotNull Player player){
        var pipboyStack = getPipboyStack(player);
        var pipboyTag = pipboyStack.getOrCreateTag();
        var color = new NbtColor();

        if(!pipboyStack.isEmpty() && pipboyTag.contains(Nbt.COLOR)){
            color.deserializeNBT(pipboyTag.getCompound(Nbt.COLOR));
            return color;
        }

        return color;
    }

    public static boolean hasPipboy(){
        return hasPipboy(Minecraft.getInstance().player);
    }

    public static boolean hasPipboy(Player player){
        return getPipboyStack(player).getItem() instanceof PipBoyItem;
    }

    public static ItemStack getPipboyStack(Player player) {
        var pipboy = ItemStack.EMPTY;
        var offhand = player.getOffhandItem();
        var curiosPipboy = SlotUtils.getCuriosPipboy(player);

        if(offhand.getItem() instanceof PipBoyItem)
            pipboy = offhand;

        if(curiosPipboy.getItem() instanceof PipBoyItem)
            pipboy = curiosPipboy;

        return pipboy;
    }

    public static ResourceLocation getPipboySkin(Player player){
        var slot = getPipboyStack(player);
        if(slot.getItem() instanceof PipBoyItem pipBoyItem){
            return nukaResource("textures/screens/" + pipBoyItem.getSkin() + "_pipboy.png");
        }
        return nukaResource("textures/screens/default_pipboy.png");
    }
}
