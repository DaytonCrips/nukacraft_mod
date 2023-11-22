package com.dayton.nukacraft.client.render.renderers;

import com.dayton.nukacraft.client.models.endity.RaiderModel;
import com.dayton.nukacraft.common.foundation.entities.Raider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import static com.jetug.chassis_core.common.util.helpers.PlayerUtils.isWearingChassis;

public class RaiderRenderer extends HumanoidMobRenderer<Raider, RaiderModel> {
    public RaiderRenderer(EntityRendererProvider.Context context) {
        super(context, new RaiderModel(context.bakeLayer(ModelLayers.ZOMBIE)), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(this,
                new RaiderModel(context.bakeLayer(ModelLayers.ZOMBIE_INNER_ARMOR)),
                new RaiderModel(context.bakeLayer(ModelLayers.ZOMBIE_OUTER_ARMOR))));
    }

    @Override
    public boolean shouldRender(Raider pLivingEntity, Frustum pCamera, double pCamX, double pCamY, double pCamZ) {
        if(isWearingChassis(pLivingEntity))
            return false;
        return super.shouldRender(pLivingEntity, pCamera, pCamX, pCamY, pCamZ);
    }

    @Override
    public ResourceLocation getTextureLocation(Raider entity) {
        return entity.getTexture();
    }
}
