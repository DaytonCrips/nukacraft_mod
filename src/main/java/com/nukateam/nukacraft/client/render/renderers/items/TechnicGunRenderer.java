package com.nukateam.nukacraft.client.render.renderers.items;

import com.nukateam.ntgl.client.render.renderers.DynamicGunRenderer;
import com.nukateam.nukacraft.client.models.items.TechnicGunModel;
import com.nukateam.nukacraft.client.render.animators.TechnicAnimator;

public class TechnicGunRenderer extends DynamicGunRenderer<TechnicAnimator> {
    public TechnicGunRenderer() {
        super(new TechnicGunModel<>(), TechnicAnimator::new);
    }
}
