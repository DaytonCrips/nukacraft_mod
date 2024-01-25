package com.nukateam.nukacraft.common.foundation.entities.misc;

import com.jetug.chassis_core.common.foundation.entity.HandEntity;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;
import org.jetbrains.annotations.NotNull;

public class PowerArmorHand extends HandEntity {

    @Override
    protected AnimationController.@NotNull AnimationStateHandler<HandEntity> predicate() {
        return event -> {
//            var controller = event.getController();
//            controller.setAnimationSpeed(1);
//            RawAnimation animation = null;
//            var chassis = getPlayerChassis();
//            if(chassis == null) return PlayState.STOP;
//
//            var player = getLocalPlayer();
//
//            if(player.swinging){
//                controller.setAnimationSpeed(2);
//                animation = begin().then(HIT, LOOP);
//            }
//            else if(chassis.isWalking()){
//                animation = begin().then(WALK, LOOP);
//            }
//            else {
//                animation = begin().then(IDLE, LOOP);
//            }
//            return event.setAndContinue(animation);

            return PlayState.STOP;
        };
    }
}
