package com.dayton.guns.common.foundation.item;

import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;

import static mod.azure.azurelib.core.animation.AnimatableManager.ControllerRegistrar;
import static mod.azure.azurelib.util.AzureLibUtil.createInstanceCache;
import static net.minecraft.client.renderer.block.model.ItemTransforms.*;

public class StaticGunItem extends GunItemBase {
    public StaticGunItem(ItemStack stack, TransformType transformType) {
        super(stack, transformType);
    }

    @Override
    public void registerControllers(ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "StaticGunItem", 0, animate()));
    }

    private AnimationController.AnimationStateHandler<StaticGunItem> animate() {
        return event -> PlayState.STOP;
    }
}
