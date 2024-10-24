package com.nukateam.nukacraft.common.foundation.items.guns;

import com.nukateam.geo.render.DynamicGeoItemRenderer;
import com.nukateam.ntgl.common.foundation.item.GunItem;
import com.nukateam.nukacraft.client.render.renderers.items.TechnicGunRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Lazy;

public class TechnicGun extends GunItem {
    private final Lazy<TechnicGunRenderer> GUN_RENDERER = Lazy.of(() -> new TechnicGunRenderer());

    public TechnicGun(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public DynamicGeoItemRenderer getRenderer() {
        return GUN_RENDERER.get();
    }
}
