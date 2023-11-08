package com.dayton.guns.common.foundation.item;

import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;

import static mod.azure.azurelib.util.AzureLibUtil.createInstanceCache;
import static net.minecraft.client.renderer.block.model.ItemTransforms.*;

public abstract class GunItemBase implements IResourceProvider, GeoEntity {
    protected final AnimatableInstanceCache cache = createInstanceCache(this);
    protected final String name, namespace;
    protected final ItemStack stack;
    protected final TransformType transformType;

    public GunItemBase(ItemStack stack, TransformType transformType) {
        this.transformType = transformType;
        var resourceProvider = (IResourceProvider)stack.getItem();
        this.name = resourceProvider.getName();
        this.namespace = resourceProvider.getNamespace();
        this.stack = stack;
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
