package com.dayton.guns.client.render.renderers;

import com.dayton.guns.common.foundation.item.GunEntity;
import com.dayton.guns.common.foundation.item.GunItemBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;

import static net.minecraft.client.renderer.block.model.ItemTransforms.*;

public class GunRenderer {
    public static final int PACKED_OVERLAY = 15728880;
    public static AnimatedGunRenderer animatedGunRenderer = new AnimatedGunRenderer();
    public static HashMap<ItemStack, HashMap<TransformType, GunItemBase>> item = new HashMap<>();

    private static GunItemBase getRenderItem(ItemStack stack, TransformType transformType){
        var map = item.computeIfAbsent(stack, k -> new HashMap<>());
        var item = map.get(transformType);

        if(item == null){
            item = new GunEntity(stack, transformType);
            map.put(transformType, item);
        }

        return item;
    }

//    private static HashMap<ItemStack, GunEntity> items = new HashMap<>();

    public void renderGun(TransformType transformType, ItemStack stack,
                           PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light) {
        try {
            //items.computeIfAbsent(stack, k -> new GunEntity(stack, transformType));

            animatedGunRenderer.render(
                    stack,
                    transformType,
                    poseStack,
                    getRenderItem(stack, transformType),
                    renderTypeBuffer,
                    null,
                    null,
                    light);

        } catch (Exception ignored) {}
    }
}
