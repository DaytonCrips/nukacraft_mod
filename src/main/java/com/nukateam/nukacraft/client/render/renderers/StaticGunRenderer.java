package com.nukateam.nukacraft.client.render.renderers;

import com.nukateam.nukacraft.client.models.GunModel;
import com.nukateam.nukacraft.common.data.interfaces.IResourceProvider;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.renderer.GeoObjectRenderer;

public class StaticGunRenderer<T extends IResourceProvider & GeoAnimatable> extends GeoObjectRenderer<T> {
    public StaticGunRenderer() {
        super(new GunModel<T>());
    }
}
