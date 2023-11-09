package com.dayton.guns.client.render.renderers;

import com.dayton.guns.common.foundation.item.AnimatedGunItem;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.guns.common.foundation.item.GunItemBase;
import com.dayton.guns.common.foundation.item.StaticGunItem;
import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import com.mojang.blaze3d.vertex.PoseStack;
import mod.azure.azurelib.renderer.GeoRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.dayton.guns.common.foundation.item.GunItem.bannedTransforms;
import static net.minecraft.client.renderer.block.model.ItemTransforms.*;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.*;

public class GunRenderer {
    public static final int PACKED_OVERLAY = 15728880;
    public static AnimatedGunRenderer animatedGunRenderer = new AnimatedGunRenderer<>();
    public static StaticGunRenderer staticGunRenderer = new StaticGunRenderer<>();
    public static HashMap<ItemStack, HashMap<TransformType, GunItemBase>> item = new HashMap<>();

    public static Map<TransformType, AnimatedGunRenderer> renderers = Map.of(
            NONE, new AnimatedGunRenderer<>(),
            THIRD_PERSON_LEFT_HAND , new AnimatedGunRenderer<>(),
            THIRD_PERSON_RIGHT_HAND, new AnimatedGunRenderer<>(),
            FIRST_PERSON_LEFT_HAND , new AnimatedGunRenderer<>(),
            FIRST_PERSON_RIGHT_HAND, new AnimatedGunRenderer<>(),
            HEAD, new AnimatedGunRenderer<>(),
            GUI, new AnimatedGunRenderer<>(),
            GROUND, new AnimatedGunRenderer<>(),
            FIXED, new AnimatedGunRenderer<>()
    );


    private static GunItemBase getRenderItem(ItemStack stack, TransformType transformType){
        var map = item.get(stack);

        if(map == null){
            map = new HashMap<>();
            item.put(stack, map);
        }

        var item = map.get(transformType);

        if(item == null){
            item = new AnimatedGunItem(stack, transformType);
            map.put(transformType, item);
        }

        return item;
    }

    public void renderGun(TransformType transformType, ItemStack stack,
                           PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light) {

        try {
            var gun = (GunItem) stack.getItem();
            var renderer = renderers.get(transformType);

            animatedGunRenderer.render(
                    poseStack,
                    getRenderItem(stack, transformType),
                    renderTypeBuffer,
                    null,
                    null,
                    light);

//            renderer.render(
//                    stack,
//                    transformType,
//                    poseStack,
//                    getRenderItem(stack, transformType),
//                    renderTypeBuffer,
//                    null,
//                    null,
//                    light);

//            if (!bannedTransforms.contains(transformType)) {
//                animatedGunRenderer.render(
//                        stack,
//                        transformType,
//                        poseStack,
//                        getRenderItem(stack, transformType),
//                        renderTypeBuffer,
//                        null,
//                        null,
//                        light);
//            }
//            else staticGunRenderer.render(
//                    stack,
//                    transformType,
//                    poseStack,
//                    getRenderItem(stack, transformType),
//                    renderTypeBuffer,
//                    null,
//                    null,
//                    light);

        } catch (Exception ignored) {}
    }
}
