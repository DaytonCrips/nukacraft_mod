package com.nukateam.nukacraft.client.render.animators;

import com.nukateam.example.common.data.interfaces.IResourceProvider;
import com.nukateam.geo.render.DynamicGeoItemRenderer;
import com.nukateam.geo.render.ItemAnimator;
import mod.azure.azurelib.core.animation.AnimatableManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PipboyAnimator extends ItemAnimator implements IResourceProvider {
    public PipboyAnimator(ItemDisplayContext transformType) {
        super(transformType);
    }

    public PipboyAnimator(ItemDisplayContext itemDisplayContext, DynamicGeoItemRenderer<PipboyAnimator> technicAnimatorGeoDynamicItemRenderer) {
        super(itemDisplayContext);
    }

    public String getName() {
        return "flamer";
    }

    public String getNamespace() {
        return "nukacraft";
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}
}

