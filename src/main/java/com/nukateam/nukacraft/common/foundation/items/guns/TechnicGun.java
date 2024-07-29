package com.nukateam.nukacraft.common.foundation.items.guns;

import com.nukateam.ntgl.client.render.renderers.DefaultGunRenderer;
import com.nukateam.ntgl.client.render.renderers.DynamicGunRenderer;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.nukacraft.client.render.renderers.items.TechnicGunRenderer;

public class TechnicGun extends GunItem {
    private final TechnicGunRenderer GUN_RENDERER = new TechnicGunRenderer();

    public TechnicGun(Properties properties) {
        super(properties);
    }

    @Override
    public DynamicGunRenderer getRenderer() {
        return GUN_RENDERER;
    }
}
