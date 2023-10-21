package com.dayton.guns.common.foundation.item;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.AnimationController.AnimationStateHandler;
import mod.azure.azurelib.core.object.PlayState;

import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.util.AzureLibUtil.createInstanceCache;

public class StaticGunItem implements IResourceProvider, GeoEntity {
    private final AnimatableInstanceCache cache = createInstanceCache(this);
    private final String name;

    public StaticGunItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNamespace() {
        return NukaCraftMod.MOD_ID;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, animate()));
    }

    private AnimationStateHandler<StaticGunItem> animate() {
        return event -> PlayState.STOP;
    }
}
