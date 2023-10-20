package com.dayton.nukacraft.client.models.endity.core;

import com.dayton.nukacraft.client.models.endity.core.Animation;

public interface IAnimatedEntity {
    Animation NO_ANIMATION = Animation.create(0);

    int getAnimationTick();

    void setAnimationTick(int var1);

    Animation getAnimation();

    void setAnimation(Animation var1);

    Animation[] getAnimations();
}
