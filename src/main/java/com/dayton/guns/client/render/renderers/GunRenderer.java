package com.dayton.guns.client.render.renderers;

import com.dayton.guns.common.foundation.item.AnimatedGunItem;
import com.dayton.guns.common.foundation.item.GunItemBase;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

import static net.minecraft.client.renderer.block.model.ItemTransforms.*;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.*;

public class GunRenderer {
    public static final int PACKED_OVERLAY = 15728880;
    public static AnimatedGunRenderer animatedGunRenderer = new AnimatedGunRenderer();
    public static HashMap<ItemStack, HashMap<TransformType, AnimatedGunItem>> item = new HashMap<>();

    public static AnimatedGunItem playerItem = new AnimatedGunItem(FIRST_PERSON_RIGHT_HAND);

    private static AnimatedGunItem getRenderItem_(ItemStack stack, TransformType transformType){
        var map = item.computeIfAbsent(stack, k -> new HashMap<>());
        var item = map.get(transformType);

        if(item == null){
            item = new AnimatedGunItem(transformType);
            map.put(transformType, item);
        }

        return item;
    }

    public static Map<TransformType, AnimatedGunItem> items = Map.of(
            NONE                    , new AnimatedGunItem( NONE                   ),
            THIRD_PERSON_LEFT_HAND  , new AnimatedGunItem( THIRD_PERSON_LEFT_HAND ),
            THIRD_PERSON_RIGHT_HAND , new AnimatedGunItem( THIRD_PERSON_RIGHT_HAND),
            FIRST_PERSON_LEFT_HAND  , new AnimatedGunItem( FIRST_PERSON_LEFT_HAND ),
            FIRST_PERSON_RIGHT_HAND , new AnimatedGunItem( FIRST_PERSON_RIGHT_HAND),
            HEAD                    , new AnimatedGunItem( HEAD                   ),
            GUI                     , new AnimatedGunItem( GUI                    ),
            GROUND                  , new AnimatedGunItem( GROUND                 ),
            FIXED                   , new AnimatedGunItem( FIXED                  )
    );

    private static AnimatedGunItem getRenderItem(LivingEntity entity, ItemStack stack, TransformType transformType){
//        if(entity instanceof LocalPlayer){
//            return playerItem;
//        }
        return items.get(transformType); //getRenderItem_(stack, transformType);
    }

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
