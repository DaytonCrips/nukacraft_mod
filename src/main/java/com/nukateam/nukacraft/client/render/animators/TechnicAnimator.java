package com.nukateam.nukacraft.client.render.animators;

import com.nukateam.example.common.data.interfaces.IResourceProvider;
import com.nukateam.ntgl.client.animators.ItemAnimator;
import com.nukateam.ntgl.client.render.renderers.GeoDynamicItemRenderer;
import mod.azure.azurelib.core.animation.AnimatableManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TechnicAnimator extends ItemAnimator implements IResourceProvider {
    public TechnicAnimator(ItemDisplayContext transformType) {
        super(transformType);
    }

    public TechnicAnimator(ItemDisplayContext itemDisplayContext, GeoDynamicItemRenderer<TechnicAnimator> technicAnimatorGeoDynamicItemRenderer) {
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

