package com.nukateam.nukacraft.client.render.renderers.items;

import com.nukateam.geo.render.DynamicGeoItemRenderer;
import com.nukateam.ntgl.client.render.layers.AutoGlowingLayer;
import com.nukateam.nukacraft.client.models.items.PipBoyModel;
import com.nukateam.nukacraft.client.render.animators.PipboyAnimator;

public class PipBoyRenderer extends DynamicGeoItemRenderer<PipboyAnimator> {
    public PipBoyRenderer() {
        super(new PipBoyModel(), PipboyAnimator::new);
        addRenderLayer(new AutoGlowingLayer<>(this));
    }
}
