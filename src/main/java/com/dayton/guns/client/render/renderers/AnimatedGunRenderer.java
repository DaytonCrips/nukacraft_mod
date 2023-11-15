package com.dayton.guns.client.render.renderers;

import com.dayton.guns.client.model.GunModel;
import com.dayton.guns.common.foundation.item.AnimatedGunItem;
import com.dayton.guns.common.foundation.item.GunItem;
import com.dayton.guns.common.foundation.item.GunItemBase;
import com.dayton.nukacraft.common.data.interfaces.IResourceProvider;
import com.jetug.chassis_core.client.render.renderers.AnimatableItemRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

import static net.minecraft.client.renderer.block.model.ItemTransforms.TransformType.*;

public class AnimatedGunRenderer extends AnimatableItemRenderer<AnimatedGunItem> {
    public AnimatedGunRenderer() {
        super(new GunModel<>());
    }
}