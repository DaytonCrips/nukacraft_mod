package com.nukateam.nukacraft.client.models;

import com.jetug.chassis_core.client.model.ChassisModel;
import com.mojang.math.Vector3f;
import com.nukateam.guns.common.foundation.item.GunItem;
import com.nukateam.nukacraft.common.foundation.entities.PowerArmorFrame;
import mod.azure.azurelib.cache.object.GeoBone;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationProcessor;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.data.EntityModelData;

public class PowerArmorModel extends ChassisModel<PowerArmorFrame> {
    @Override
    public void setCustomAnimations(PowerArmorFrame animatable, long instanceId, AnimationState<PowerArmorFrame> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        var animationProcessor = getAnimationProcessor();
//        var data = (EntityModelData)animationState.getExtraData().get(DataTickets.ENTITY);

        if (animatable.hasPassenger() && animatable.getPassenger().getMainHandItem().getItem() instanceof GunItem gunItem) {
            gunItem.getGun().getGeneral().getGripType().getHeldAnimation()
                    .applyGeoModelRotation(animatable, animationProcessor);
        }
        else if (animatable.currentAnimation == null){
            CoreGeoBone rightArm = animationProcessor.getBone("right_arm");
            CoreGeoBone leftArm = animationProcessor.getBone("left_arm");

            setRotations(rightArm, 0);
            setRotations(leftArm, 0);
        }
    }

    public static void setRotations(CoreGeoBone bone, float rot) {
        bone.setRotX(rot);
        bone.setRotY(rot);
        bone.setRotZ(rot);
    }
}
