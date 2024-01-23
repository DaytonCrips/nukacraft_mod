package com.nukateam.nukacraft.client.events;

import com.mojang.blaze3d.vertex.PoseStack;
import com.nukateam.nukacraft.common.data.utils.SlotUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class RenderEvents {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void renderPipboy(RenderPlayerEvent event) {
//        var player = event.getPlayer();
//        var stack = SlotUtils.getPipboyStack(player);
//        var itemRenderer = Minecraft.getInstance().getItemInHandRenderer();
//        if (stack.isEmpty()) return;
//
//        try {
//            var method = ItemInHandLayer.class.getDeclaredMethod("renderArmWithItem",
//                    LivingEntity.class, ItemStack.class, ItemTransforms.TransformType.class,
//                    HumanoidArm.class, PoseStack.class, MultiBufferSource.class, int.class);
//
//            method.setAccessible(true);
//
//            method.invoke(itemRenderer,
//                    player,
//                    stack,
//                    ItemTransforms.TransformType.THIRD_PERSON_LEFT_HAND,
//                    HumanoidArm.LEFT,
//                    event.getPoseStack(),
//                    event.getMultiBufferSource(),
//                    event.getPackedLight());
//
//        } catch (Exception e) {}

//        Minecraft.getInstance().getItemInHandRenderer().renderItem(
//                player,
//                stack,
//                ItemTransforms.TransformType.THIRD_PERSON_LEFT_HAND,
//                true,
//                event.getPoseStack(),
//                event.getMultiBufferSource(),
//                event.getPackedLight()
//        );
    }
}
