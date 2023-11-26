package com.nukateam.guns.common.foundation.item;

import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;

import static mod.azure.azurelib.util.AzureLibUtil.createInstanceCache;

public abstract class GunItemBase implements GeoEntity {
    protected final AnimatableInstanceCache cache = createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
