package com.nukateam.nukacraft.client.models.entity.geo;

import com.jetug.chassis_core.client.render.utils.ResourceHelper;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import static com.jetug.chassis_core.client.render.utils.GeoUtils.setHeadAnimation;
import static com.jetug.chassis_core.client.render.utils.ResourceHelper.getChassisResource;

public class EntityModel<T extends LivingEntity & GeoAnimatable> extends GeoModel<T> {
    @Override
    public ResourceLocation getModelResource(T object) {
        return getChassisResource(object,"geo/entity/", ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T object) {
        return getChassisResource(object,"textures/entity/", ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(T object) {
        return getChassisResource(object,"animations/entity/", ".animation.json");
    }

    @Override
    public void setCustomAnimations(T animatable, long instanceId, AnimationState<T> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        setHeadAnimation(animatable, this.getAnimationProcessor(), animationState);
    }

    public static ResourceLocation getChassisResource(Entity animatable, String path, String extension){
        var name = ResourceHelper.getResourceName(animatable.getType().getRegistryName());
        var modId = animatable.getType().getRegistryName().getNamespace();

        return new ResourceLocation(modId, path + name + extension);
    }
}