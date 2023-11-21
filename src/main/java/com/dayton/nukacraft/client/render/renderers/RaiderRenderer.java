package com.dayton.nukacraft.client.render.renderers;

import com.dayton.nukacraft.client.models.endity.RaiderModel;
import com.dayton.nukacraft.common.foundation.entities.RaiderEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

import static com.dayton.nukacraft.common.data.utils.Resources.nukaResource;
import static com.jetug.chassis_core.common.util.helpers.PlayerUtils.isWearingChassis;

public class RaiderRenderer extends HumanoidMobRenderer<RaiderEntity, RaiderModel> {
    public RaiderRenderer(EntityRendererProvider.Context context) {
        super(context, new RaiderModel(context.bakeLayer(ModelLayers.ZOMBIE)), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this,
                new RaiderModel(context.bakeLayer(ModelLayers.ZOMBIE_INNER_ARMOR)),
                new RaiderModel(context.bakeLayer(ModelLayers.ZOMBIE_OUTER_ARMOR))));
    }

    @Override
    public boolean shouldRender(RaiderEntity pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        if(isWearingChassis(pLivingEntity))
            return false;
        return super.shouldRender(pLivingEntity, pCamera, pCamX, pCamY, pCamZ);
    }

    @Override
    public ResourceLocation getTextureLocation(RaiderEntity pEntity) {
        return nukaResource("textures/entity/raider.png");
    }
}
