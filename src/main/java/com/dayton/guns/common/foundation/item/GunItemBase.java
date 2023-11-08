package com.dayton.guns.common.foundation.item;

import com.dayton.nukacraft.NukaCraftMod;
import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimationController;

import static com.dayton.nukacraft.common.data.constants.Animations.SHOT;
import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.core.animation.Animation.LoopType.LOOP;
import static mod.azure.azurelib.core.animation.RawAnimation.begin;
import static mod.azure.azurelib.util.AzureLibUtil.createInstanceCache;

public abstract class GunItemBase implements IResourceProvider, GeoEntity {
    private final AnimatableInstanceCache cache = createInstanceCache(this);
    private final String name, namespace;

    public GunItemBase(IResourceProvider resourceProvider) {
        this.name = resourceProvider.getName();
        this.namespace = resourceProvider.getNamespace();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNamespace() {
        return namespace;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
