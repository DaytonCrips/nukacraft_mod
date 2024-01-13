package com.nukateam.nukacraft.client.models.entity;

import com.nukateam.nukacraft.common.foundation.entities.Raider;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

public class RaiderModel extends HumanoidModel<Raider> {
    public RaiderModel(ModelPart pRoot) {
        super(pRoot);
    }

    public RaiderModel(ModelPart pRoot, Function<ResourceLocation, RenderType> pRenderType) {
        super(pRoot, pRenderType);
    }
}
