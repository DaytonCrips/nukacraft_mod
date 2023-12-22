package com.nukateam.guns.client.render.renderers;


import com.nukateam.guns.client.model.TestModel;
import com.nukateam.guns.client.render.layers.PlayerSkinLayer;
import com.nukateam.guns.common.foundation.item.TestItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class TestRenderer extends GeoItemRenderer<TestItem> {
    public TestRenderer() {
        super(new TestModel());
        addRenderLayer(new PlayerSkinLayer<>(this));
    }
}
