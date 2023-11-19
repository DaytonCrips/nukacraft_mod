package com.dayton.nukacraft.client.render.renderers;

import com.dayton.nukacraft.client.models.endity.RainerModel;
import com.dayton.nukacraft.common.foundation.entities.RaiderEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;

public class RaiderRenderer extends HumanoidMobRenderer<RaiderEntity, RainerModel> {
    public static ModelLayerLocation LAYER = new ModelLayerLocation(nukaResource("raider"), "main");

    public RaiderRenderer(EntityRendererProvider.Context context) {
        super(context, new RainerModel(context.bakeLayer(ModelLayers.ZOMBIE)), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this,
                new RainerModel(context.bakeLayer(ModelLayers.ZOMBIE_INNER_ARMOR)),
                new RainerModel(context.bakeLayer(ModelLayers.ZOMBIE_OUTER_ARMOR))));
    }

    @Override
    public ResourceLocation getTextureLocation(RaiderEntity pEntity) {
        return nukaResource("textures/entity/raider.png");
    }
}
