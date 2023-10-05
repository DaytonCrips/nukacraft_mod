package com.dayton.nukacraft.common.foundation.entities;

import com.jetug.chassis_core.common.foundation.entity.HandEntity;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import static com.dayton.nukacraft.common.data.constants.ArmorChassisAnimation.*;
import static com.jetug.chassis_core.common.util.helpers.AnimationHelper.setAnimation;
import static com.jetug.chassis_core.common.util.helpers.PlayerUtils.*;
import static mod.azure.azurelib.core.animation.Animation.LoopType.LOOP;
import static mod.azure.azurelib.core.animation.Animation.LoopType.PLAY_ONCE;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;

public class PowerArmorHand extends HandEntity {

    @Override
    protected AnimationController.@NotNull AnimationStateHandler<HandEntity> predicate() {
        return event -> {
            var controller = event.getController();
            controller.setAnimationSpeed(1);
            RawAnimation animation = null;
            var chassis = getPlayerChassis(player);
            if(chassis == null) return PlayState.STOP;

            var player = getLocalPlayer();

            if(player.swinging){
                controller.setAnimationSpeed(2);
                animation = begin().then(HIT, LOOP);
            }
            else if(chassis.isWalking()){
                animation = begin().then(WALK, LOOP);
            }
            else {
                animation = begin().then(IDLE, LOOP);
            }
            return event.setAndContinue(animation);
        };
    }
}
