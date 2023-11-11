package com.dayton.guns.client.render.renderers;

import com.dayton.guns.common.foundation.item.AnimatedGunItem;
import com.dayton.guns.common.foundation.item.GunItemBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;

import static net.minecraft.client.renderer.block.model.ItemTransforms.*;

public class GunRenderer {
    public static final int PACKED_OVERLAY = 15728880;
    public static AnimatedGunRenderer animatedGunRenderer = new AnimatedGunRenderer();
    public static HashMap<ItemStack, HashMap<TransformType, AnimatedGunItem>> item = new HashMap<>();

    private static AnimatedGunItem getRenderItem(LivingEntity entity, ItemStack stack, TransformType transformType){
        var map = item.computeIfAbsent(stack, k -> new HashMap<>());
        var item = map.get(transformType);

        if(item == null){
            item = new AnimatedGunItem(transformType);
            map.put(transformType, item);
        }

        return item;
    }

//    private static GunItemBase getRenderItem(LivingEntity entity, ItemStack stack, TransformType transformType){
//        if(entity instanceof LocalPlayer){
//            return
//        }
//    }

    public static ItemStack renderStack;

    public void renderGun(LivingEntity entity, TransformType transformType, ItemStack stack,
                          PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light) {
        try {
            //items.computeIfAbsent(stack, k -> new AnimatedGunItem(stack, transformType));

            renderStack = stack;

            animatedGunRenderer.render(
                    stack,
                    transformType,
                    poseStack,
                    getRenderItem(entity, stack, transformType),
                    renderTypeBuffer,
                    null,
                    null,
                    light);

        } catch (Exception ignored) {}
    }
}
