package com.dayton.guns.common.foundation.item;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;

import static com.dayton.nukacraft.common.data.constants.Animations.SHOT;
import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.Animation.LoopType.LOOP;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static mod.azure.azurelib.util.AzureLibUtil.createInstanceCache;

public class StaticGunItem extends GunItemBase {
    public StaticGunItem(IResourceProvider resourceProvider) {
        super(resourceProvider);
    }

    @Override
    public void registerControllers(ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "StaticGunItem", 0, animate()));
    }

    private AnimationController.AnimationStateHandler<StaticGunItem> animate() {
        return event -> {
            var animation = begin().then(SHOT, LOOP);
            return event.setAndContinue(animation);
        };
    }
}
