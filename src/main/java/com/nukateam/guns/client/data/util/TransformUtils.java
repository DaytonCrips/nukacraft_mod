package com.nukateam.guns.client.data.util;

import net.minecraft.client.renderer.block.model.ItemTransforms;

import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND;

public class TransformUtils {
    public static boolean isHandTransform(ItemTransforms.TransformType transformType){
        return switch (transformType){
            case FIRST_PERSON_RIGHT_HAND, FIRST_PERSON_LEFT_HAND, THIRD_PERSON_RIGHT_HAND, THIRD_PERSON_LEFT_HAND -> true;
            default -> false;
        };
    }

    public static boolean isRightHand(ItemTransforms.TransformType transformType){
        return transformType == FIRST_PERSON_RIGHT_HAND || transformType == THIRD_PERSON_RIGHT_HAND;
    }
}
