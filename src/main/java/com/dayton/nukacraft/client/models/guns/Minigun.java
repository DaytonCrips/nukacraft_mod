package com.dayton.nukacraft.client.models.guns;


import com.dayton.guns.client.GunModel;
import com.dayton.guns.client.render.gun.IOverrideModel;
import com.dayton.guns.client.util.RenderUtil;
import com.dayton.guns.common.base.Gun;
import com.dayton.guns.common.foundation.init.ModSyncedDataKeys;
import com.dayton.nukacraft.client.SpecialModels;
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
public class Minigun implements IOverrideModel {
    private final WeakHashMap<LivingEntity, Rotations> rotationMap = new WeakHashMap<>();

    @Override
    public void tick(LivingEntity entity)
    {
        this.rotationMap.putIfAbsent(entity, new Rotations());
        Rotations rotations = this.rotationMap.get(entity);
        rotations.prevRotation = rotations.rotation;

        boolean shooting = ModSyncedDataKeys.SHOOTING.getValue(entity);
        ItemStack heldItem = entity.getMainHandItem();
        if(!Gun.hasAmmo(heldItem) && entity instanceof Player player && !player.isCreative()) {
            shooting = false;
        }

        if(shooting)
            rotations.rotation += 20;
        else
            rotations.rotation += 1;
    }

    private static class Rotations {
        private static final Rotations ZERO = new Rotations();

        private int rotation;
        private int prevRotation;
    }

    @Override
    public void render(float partialTicks, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, @Nullable LivingEntity entity, PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light, int overlay) {
        Rotations rotations = entity != null ? this.rotationMap.computeIfAbsent(entity, uuid -> new Rotations()) : Rotations.ZERO;
        Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.NONE, false, poseStack, renderTypeBuffer, light, overlay, GunModel.wrap(SpecialModels.MINIGUN.getModel()));
        poseStack.pushPose();
        RenderUtil.rotateZ(poseStack, 0.0F, 0.69F, rotations.prevRotation + (rotations.rotation - rotations.prevRotation) * partialTicks);
        Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.NONE, false, poseStack, renderTypeBuffer, light, overlay, GunModel.wrap(SpecialModels.MINIGUN_BARREL.getModel()));
        poseStack.popPose();
    }

    @SubscribeEvent
    public void onClientDisconnect(ClientPlayerNetworkEvent.LoggedOutEvent event) {
        this.rotationMap.clear();
    }
}
