package com.nukateam.nukacraft.client.models;

import com.jetug.chassis_core.client.model.ChassisModel;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.nukacraft.common.foundation.entities.misc.PowerArmorFrame;
import mod.azure.azurelib.core.animatable.model.CoreGeoBone;
import mod.azure.azurelib.core.animation.AnimationState;

public class PowerArmorModel extends ChassisModel<PowerArmorFrame> {
    public static void setRotations(CoreGeoBone bone, float rot) {
        bone.setRotX(rot);
        bone.setRotY(rot);
        bone.setRotZ(rot);
    }

    @Override
    public void setCustomAnimations(PowerArmorFrame animatable, long instanceId, AnimationState<PowerArmorFrame> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        var animationProcessor = getAnimationProcessor();

        if (animatable.hasPassenger() && animatable.getControllingPassenger().getMainHandItem().getItem() instanceof GunItem gunItem) {
            gunItem.getGun().getGeneral().getGripType().getHeldAnimation()
                    .applyGeoModelRotation(animatable, animationProcessor);
        } else if (animatable.armsAnimation == null) {
            var rightArm = animationProcessor.getBone("right_arm");
            var leftArm = animationProcessor.getBone("left_arm");

            setRotations(rightArm, 0);
            setRotations(leftArm, 0);
        }
    }
}
