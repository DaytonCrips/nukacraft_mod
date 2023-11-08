package com.dayton.guns.client.render.renderers;

import com.dayton.guns.common.foundation.item.AnimatedGunItem;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.guns.common.foundation.item.GunItemBase;
import com.dayton.guns.common.foundation.item.StaticGunItem;
import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import com.mojang.blaze3d.vertex.PoseStack;
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

public class GunRenderer {
    public static final int PACKED_OVERLAY = 15728880;
    public static AnimatedGunRenderer animatedGunRenderer = new AnimatedGunRenderer<>();
    public static StaticGunRenderer<StaticGunItem> staticGunRenderer = new StaticGunRenderer<>();
    public static HashMap<ItemStack, HashMap<TransformType, GunItemBase>> item = new HashMap<>();

//    public static HashMap<TransformType, GunItemBase> renderers = Map.of(
//            TransformType.GUI,
//    );


    private static GunItemBase getRenderItem(ItemStack stack, TransformType transformType){
        var map = item.get(stack);

        if(map == null){
            map = new HashMap<>();
            item.put(stack, map);
        }

        var item = map.get(transformType);

        if(item == null){
            item = new AnimatedGunItem((IResourceProvider)stack.getItem());
            map.put(transformType, item);
        }

        return item;
    }

    public void renderGun(@Nullable LivingEntity entity, TransformType transformType, ItemStack stack,
                           PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light, float partialTicks) {

        try {
            var gun = (GunItem) stack.getItem();

            animatedGunRenderer.render(
                    stack,
                    transformType,
                    poseStack,
                    getRenderItem(stack, transformType),
                    renderTypeBuffer,
                    null,
                    null,
                    light);
//
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
//                    poseStack,
//                    new StaticGunItem(gun),
//                    renderTypeBuffer,
//                    null,
//                    null,
//                    light);

        } catch (Exception ignored) {}
    }
}
