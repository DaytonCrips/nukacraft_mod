package com.nukateam.nukacraft.client.models.items;

import com.jetug.chassis_core.common.foundation.item.StackUtils;
import com.nukateam.ntgl.client.model.IGlowingModel;
import com.nukateam.nukacraft.client.render.animators.PipboyAnimator;
import com.nukateam.nukacraft.common.foundation.items.misc.PipBoyItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;

import static com.nukateam.nukacraft.common.data.utils.Resources.nukaResource;

public class PipBoyModel extends GeoModel<PipboyAnimator> implements IGlowingModel<PipboyAnimator> {
    @Override
    public ResourceLocation getModelResource(PipboyAnimator pipBoyItem) {
        return nukaResource("geo/items/pipboy.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PipboyAnimator pipBoyItem) {
        var variant = StackUtils.getVariant(pipBoyItem.getStack());
        return nukaResource("textures/item/pipboy/pipboy2000_" + variant + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(PipboyAnimator pipBoyItem) {
        return null;
    }

    @Override
    public ResourceLocation getGlowingTextureResource(PipboyAnimator animatable) {
        return nukaResource("textures/item/pipboy/pipboy_glowmask.png");
    }
}
