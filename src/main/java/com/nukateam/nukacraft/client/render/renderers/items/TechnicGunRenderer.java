package com.nukateam.nukacraft.client.render.renderers.items;

import com.nukateam.geo.render.DynamicGeoItemRenderer;
import com.nukateam.nukacraft.client.models.items.TechnicGunModel;
import com.nukateam.nukacraft.client.render.animators.TechnicAnimator;

public class TechnicGunRenderer extends DynamicGeoItemRenderer<TechnicAnimator> {
    public TechnicGunRenderer() {
        super(new TechnicGunModel<>(), TechnicAnimator::new);
    }
}
