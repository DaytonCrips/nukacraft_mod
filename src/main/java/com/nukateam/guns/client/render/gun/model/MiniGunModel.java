package com.nukateam.guns.client.render.gun.model;

import com.nukateam.guns.client.model.GunModel;
import com.nukateam.guns.client.data.enums.SpecialModels;
import com.nukateam.guns.client.render.gun.IOverrideModel;
import com.nukateam.guns.client.data.util.RenderUtil;
import com.nukateam.guns.common.base.Gun;
import com.nukateam.guns.common.foundation.init.ModSyncedDataKeys;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.WeakHashMap;

/**
 * Author: MrCrayfish
 */
public class MiniGunModel implements IOverrideModel {
    private WeakHashMap<LivingEntity, Rotations> rotationMap = new WeakHashMap<>();

    @Override
    public void tick(LivingEntity entity) {
        this.rotationMap.putIfAbsent(entity, new Rotations());
        Rotations rotations = this.rotationMap.get(entity);
        rotations.prevRotation = rotations.rotation;

        boolean shooting = ModSyncedDataKeys.SHOOTING.getValue(entity);
        ItemStack heldItem = entity.getMainHandItem();
        if (!Gun.hasAmmo(heldItem) && entity instanceof Player player && !player.isCreative()) {
            shooting = false;
        }

        if (shooting) {
            rotations.rotation += 20;
        } else {
            rotations.rotation += 1;
        }
    }

    @Override
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light, int overlay) {
        Rotations rotations = entity != null ? this.rotationMap.computeIfAbsent(entity, uuid -> new Rotations()) : Rotations.ZERO;
        Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.NONE, false, poseStack, renderTypeBuffer, light, overlay, GunModel.wrap(SpecialModels.MINI_GUN_BASE.getModel()));
        poseStack.pushPose();
        RenderUtil.rotateZ(poseStack, 0.0F, -0.375F, rotations.prevRotation + (rotations.rotation - rotations.prevRotation) * partialTicks);
        Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.NONE, false, poseStack, renderTypeBuffer, light, overlay, GunModel.wrap(SpecialModels.MINI_GUN_BARRELS.getModel()));
        poseStack.popPose();
    }

    private static class Rotations {
        private static final Rotations ZERO = new Rotations();

        private int rotation;
        private int prevRotation;
    }

    @SubscribeEvent
    public void onClientDisconnect(ClientPlayerNetworkEvent.LoggedOutEvent event) {
        this.rotationMap.clear();
    }
}
