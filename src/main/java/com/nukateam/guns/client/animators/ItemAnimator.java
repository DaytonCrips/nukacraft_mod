package com.nukateam.guns.client.animators;

import com.jetug.chassis_core.common.data.json.ItemConfig;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraftforge.common.util.Lazy;

import static com.jetug.chassis_core.client.ClientConfig.modResourceManager;
import static mod.azure.azurelib.util.AzureLibUtil.createInstanceCache;

public abstract class ItemAnimator implements GeoEntity {
    protected final AnimatableInstanceCache cache = createInstanceCache(this);
    protected final ItemTransforms.TransformType transformType;

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public ItemAnimator(ItemTransforms.TransformType transformType) {
        this.transformType = transformType;
    }

    public ItemTransforms.TransformType getTransformType() {
        return transformType;
    }
}
