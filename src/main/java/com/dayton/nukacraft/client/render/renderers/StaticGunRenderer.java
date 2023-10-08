package com.dayton.nukacraft.client.render.renderers;

import com.dayton.guns.common.base.Gun;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.nukacraft.client.models.GunModel;
import com.dayton.nukacraft.common.data.interfaces.INameable;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import mod.azure.azurelib.cache.object.BakedGeoModel;
import mod.azure.azurelib.cache.object.GeoBone;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.renderer.GeoObjectRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static com.dayton.guns.common.foundation.item.GunItem.*;
import static com.dayton.nukacraft.common.data.constants.Animations.SHOT;
import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;

public class StaticGunRenderer<T extends INameable & GeoAnimatable> extends GeoObjectRenderer<T> {
    public StaticGunRenderer() {
        super(new GunModel<T>());
    }
}
