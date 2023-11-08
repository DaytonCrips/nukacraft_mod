package com.dayton.guns.common.foundation.item;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;

import static com.dayton.guns.common.foundation.item.GunItem.*;
import static com.dayton.nukacraft.common.data.constants.Animations.SHOT;
import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.Animation.LoopType.LOOP;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static mod.azure.azurelib.util.AzureLibUtil.createInstanceCache;

public class AnimatedGunItem extends GunItemBase {
    public AnimatedGunItem(IResourceProvider resourceProvider) {
        super(resourceProvider);
    }

    @Override
    public void registerControllers(ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, animate()));
    }

    private AnimationController.AnimationStateHandler<AnimatedGunItem> animate() {
        return event -> {
            var controller = event.getController();
            controller.setAnimationSpeed(1);
            var stack = event.getData(DataTickets.ITEMSTACK);
            var transformType = event.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);

            if (bannedTransforms.contains(transformType)) {
                resetAnim(stack);
                return PlayState.STOP;
            }

            var anim = stackAnimations.get(stack);
            if (anim == null) return PlayState.STOP;

            var animation = begin().then(anim, LOOP);

            if (controller.hasAnimationFinished())
                controller.forceAnimationReset();


            return event.setAndContinue(animation);
        };
    }
}
