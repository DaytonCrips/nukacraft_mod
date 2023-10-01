package com.dayton.nukacraft.common.foundation.entities;

import com.jetug.chassis_core.common.foundation.entity.HandEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import static com.dayton.nukacraft.common.data.constants.ArmorChassisAnimation.*;
import static com.jetug.chassis_core.common.util.helpers.AnimationHelper.setAnimation;
import static com.jetug.chassis_core.common.util.helpers.PlayerUtils.getPlayerChassis;
import static com.jetug.chassis_core.common.util.helpers.PlayerUtils.isWearingChassis;
import static software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes.LOOP;

public class PowerArmorHand extends HandEntity {
    @Override
    protected <T extends IAnimatable> PlayState predicate(AnimationEvent<T> event) {
        if(!isWearingChassis()) return PlayState.STOP;

        var controller = event.getController();
        var chassis = getPlayerChassis(player);
        if(chassis == null) return PlayState.STOP;

        controller.animationSpeed = 1;

        if(player.swinging){
            controller.animationSpeed = 2;
            setAnimation(controller,HIT, LOOP);
        }
        else if(chassis.isWalking()){
            setAnimation(controller,WALK, LOOP);
        }
        else {
            setAnimation(controller,IDLE, LOOP);
        }
        return PlayState.CONTINUE;
    }
}
